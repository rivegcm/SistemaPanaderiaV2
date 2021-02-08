package operacionesVenta;

import calsesPadre.ABM;
import clasesUtilidadGeneral.OperacionesUtiles;
import conexion.ConexionHibernate;
import ds.desktop.notify.DesktopNotify;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Estado;
import entidades.MovimientoCuenta;
import entidades.Producto;
import entidades.Producto_Venta;
import entidades.TipoVenta;
import entidades.Venta;
import entidades.Venta_MovimientoCuenta;
import escritorios.PrincipalCliente;
import escritorios.PrincipalVenta;
import formularios.FormularioEditarVenta;
import formularios.FormularioEstadoVenta;
import formularios.FormularioRegistrarVenta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author FRANCO
 */
public class ABMVenta extends ABM {

    private List<Integer> listaProductosListados = new ArrayList<Integer>();
    private FormularioRegistrarVenta formularioRegistrarVenta;
    private FormularioEditarVenta formularioEditarVenta;
    private FormularioEstadoVenta formularioEstadoVenta;
    //se utiliza solo para eliminar
    private PrincipalVenta principalVenta;
    //para obtener el idCliente
    private PrincipalCliente principalCliente;
    //se borran todos los productos de listados y se vuelven a cargar desde cero
    private List<Producto_Venta> listaProductosEliminar;

    public List<Producto_Venta> getListaProductosEliminar() {
        return listaProductosEliminar;
    }

    public void setListaProductosEliminar(List<Producto_Venta> listaProductosEliminar) {
        this.listaProductosEliminar = listaProductosEliminar;
    }

    public PrincipalCliente getPrincipalCliente() {
        return principalCliente;
    }

    public void setPrincipalCliente(PrincipalCliente principalCliente) {
        this.principalCliente = principalCliente;
    }

    public List<Integer> getListaProductosListados() {
        return listaProductosListados;
    }

    public void setListaProductosListados(List<Integer> listaProductosListados) {
        this.listaProductosListados = listaProductosListados;
    }

    public FormularioEstadoVenta getFormularioEstadoVenta() {
        return formularioEstadoVenta;
    }

    public void setFormularioEstadoVenta(FormularioEstadoVenta formularioEstadoVenta) {
        this.formularioEstadoVenta = formularioEstadoVenta;
    }

    public FormularioRegistrarVenta getFormularioRegistrarVenta() {
        return formularioRegistrarVenta;
    }

    public void setFormularioRegistrarVenta(FormularioRegistrarVenta formularioRegistrarVenta) {
        this.formularioRegistrarVenta = formularioRegistrarVenta;
    }

    public FormularioEditarVenta getFormularioEditarVenta() {
        return formularioEditarVenta;
    }

    public void setFormularioEditarVenta(FormularioEditarVenta formularioEditarVenta) {
        this.formularioEditarVenta = formularioEditarVenta;
    }

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    @Override
    public void obtenerFormularioRegistrar() {
        setFormularioRegistrar(this.getFormularioRegistrarVenta());
        //setListaCampos(null);
    }

    @Override
    public void obtenerFormularioEditar() {
        setFormularioEditar(this.getFormularioEditarVenta());
        //setListaCampos(null);
    }

    @Override
    public void transaccionRegistrar(Session miSesion) {
        Double totalunidades;
        Double precioTotal;

        Venta v = new Venta();
        if (formularioRegistrarVenta.getRadButonConsumidorFinal().isSelected()) {
            Cliente c = (Cliente) miSesion.get(Cliente.class, 1);
            v.setCodigoCliente(c);
        } else {
            Integer id = formularioRegistrarVenta.getIdCliente();
            Cliente c = (Cliente) miSesion.get(Cliente.class, id);
            v.setCodigoCliente(c);
        }
        v.setFechaHoraVenta(formularioRegistrarVenta.getrSDateChooser().getDatoFecha());
        v.setPrecioTotal(Double.valueOf(formularioRegistrarVenta.getLblPrecioTotal().getText()));

        if (formularioRegistrarVenta.getBoxTipoVenta().getSelectedItem().equals("Venta Simple")) {
            TipoVenta tvs = (TipoVenta) miSesion.get(TipoVenta.class, 1);
            v.setCodigoTipoVenta(tvs);
            Estado e = (Estado) miSesion.get(Estado.class, 3);
            v.setCodigoEstado(e);
        } else {
            TipoVenta tvp = (TipoVenta) miSesion.get(TipoVenta.class, 2);
            v.setCodigoTipoVenta(tvp);
            Estado e = (Estado) miSesion.get(Estado.class, 4);
            v.setCodigoEstado(e);
        }
        miSesion.save(v);

        for (int i = 0; i < listaProductosListados.size(); i++) {
            Producto_Venta pv = new Producto_Venta();
            Integer id = listaProductosListados.get(i);
            Producto p = (Producto) miSesion.get(Producto.class, id);
            totalunidades = Double.valueOf(formularioRegistrarVenta.getTablaListarProductos().getValueAt(i, 1).toString());
            precioTotal = Double.valueOf(formularioRegistrarVenta.getTablaListarProductos().getValueAt(i, 2).toString());
            pv.setCodigoProducto(p);
            pv.setCodigoVenta(v);
            pv.setTotalUnidades(totalunidades);
            pv.setPrecioTotal(precioTotal);
            miSesion.save(pv);

            if (formularioRegistrarVenta.getRadBtnDescontar().isSelected()) {
                Estado e = (Estado) miSesion.get(Estado.class, 1);

                MovimientoCuenta mc = new MovimientoCuenta();
                mc.setMonto(Double.valueOf("-" + formularioRegistrarVenta.getLblPrecioTotal().getText().toString()));
                mc.setMotivo("compra de productos");

               
                
                id = formularioRegistrarVenta.getIdCuenta();
                Cuenta c = (Cuenta) miSesion.get(Cuenta.class, id);
                mc.setBalance(c.getBalance() + (mc.getMonto()));

                mc.setFecha(new Date());
                mc.setCodigoEstado(e);
                mc.setCodigoCuenta(c);

                miSesion.save(mc);

                c.setBalance(mc.getBalance());
                miSesion.saveOrUpdate(c);

                Venta_MovimientoCuenta vmc = new Venta_MovimientoCuenta();
                vmc.setVentaId(v);
                vmc.setMovimientoCuentaId(mc);

                miSesion.save(vmc);

            }

        }
    }

    @Override
    public void transaccionEliminar(Session miSesion) {

        Integer id = principalVenta.getTablaVenta().obtenerIdFilaSeleccionada();

        Estado eE = (Estado) miSesion.get(Estado.class, 2);
        Estado eR = (Estado) miSesion.get(Estado.class, 3);
        Estado eP = (Estado) miSesion.get(Estado.class, 4);
        Estado eC = (Estado) miSesion.get(Estado.class, 5);
        Venta v = (Venta) miSesion.get(Venta.class, id);
        switch (formularioEstadoVenta.getEstado()) {
            case 2:
                v.setCodigoEstado(eE);
                break;
            case 3:
                v.setCodigoEstado(eR);
                break;
            case 4:
                v.setCodigoEstado(eP);
                break;
            case 5:
                v.setCodigoEstado(eC);
                break;
        }
        miSesion.saveOrUpdate(v);

    }

    @Override
    public void transaccionEditar(Session miSesion) {
        Integer idCliente;
        Integer idVenta;

        idVenta = principalVenta.getTablaVenta().obtenerIdFilaSeleccionada();

        if (formularioEditarVenta.isCambiarCliente()) {
            idCliente = principalCliente.getTablaCliente().obtenerIdFilaSeleccionada();
        } else {
            idCliente = formularioEditarVenta.getIdCliente();
        }

        Double totalunidades;
        Double precioTotal;
        List lista = getListaProductosEliminar();

        for (Object o : lista) {
            Producto_Venta pr = (Producto_Venta) o;
            Producto_Venta productoEliminar = (Producto_Venta) miSesion.get(Producto_Venta.class, pr.getIdProductoVenta());
            miSesion.delete(productoEliminar);
        }
        Venta v = (Venta) miSesion.get(Venta.class, idVenta);

        if (formularioEditarVenta.isCambiarCliente()) {
            Cliente c = (Cliente) miSesion.get(Cliente.class, idCliente);
            v.setCodigoCliente(c);
        } else if (formularioEditarVenta.getRadButonConsumidorFinal().isSelected()) {
            Cliente c = (Cliente) miSesion.get(Cliente.class, 1);
            v.setCodigoCliente(c);
        }

        v.setFechaHoraVenta(formularioEditarVenta.getrSDateChooser().getDatoFecha());
        v.setPrecioTotal(Double.valueOf(formularioEditarVenta.getLblPrecioTotal().getText()));

        if (formularioEditarVenta.getBoxTipoVenta().getSelectedItem().equals("Venta Simple")) {
            TipoVenta tvs = (TipoVenta) miSesion.get(TipoVenta.class, 1);
            v.setCodigoTipoVenta(tvs);
            Estado e = (Estado) miSesion.get(Estado.class, 3);
            v.setCodigoEstado(e);
        } else {
            TipoVenta tvp = (TipoVenta) miSesion.get(TipoVenta.class, 2);
            v.setCodigoTipoVenta(tvp);
            Estado e = (Estado) miSesion.get(Estado.class, 4);
            v.setCodigoEstado(e);
        }
        miSesion.saveOrUpdate(v);

        for (int i = 0; i < listaProductosListados.size(); i++) {
            Producto_Venta pv = new Producto_Venta();
            Integer id = listaProductosListados.get(i);
            Producto p = (Producto) miSesion.get(Producto.class, id);
            totalunidades = Double.valueOf(formularioEditarVenta.getTablaListarProductos().getValueAt(i, 1).toString());
            precioTotal = Double.valueOf(formularioEditarVenta.getTablaListarProductos().getValueAt(i, 2).toString());
            pv.setCodigoProducto(p);
            pv.setCodigoVenta(v);
            pv.setTotalUnidades(totalunidades);
            pv.setPrecioTotal(precioTotal);
            miSesion.save(pv);
        }

    }

}
