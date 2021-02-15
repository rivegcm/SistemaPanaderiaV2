package operacionesVenta;

import calsesPadre.InterfazGraficaFormularioEditar;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalVenta;
import formularios.FormularioEditarVenta;
import java.awt.Color;
import javax.swing.SwingConstants;
import principal.PrincipalAdministrador;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioEditarVenta extends InterfazGraficaFormularioEditar {

    protected PrincipalVenta principalVenta;
    protected TablaVenta tablaVenta;
    private PrincipalAdministrador principalAdministrador;
    private Integer idVenta;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    public TablaVenta getTablaVenta() {
        return tablaVenta;
    }

    public void setTablaVenta(TablaVenta tablaVenta) {
        this.tablaVenta = tablaVenta;
    }

    public PrincipalAdministrador getPrincipalAdministrador() {
        return principalAdministrador;
    }

    public void setPrincipalAdministrador(PrincipalAdministrador principalAdministrador) {
        this.principalAdministrador = principalAdministrador;
    }

    @Override
    public void nuevoFormularioEditar() {
        if (principalVenta.getEditarVenta() == null) {
            //seccion formulario
            FormularioEditarVenta formularioEditar = new FormularioEditarVenta(frame, true);
            formularioEditar.setPrincipalVenta(principalVenta);
            formularioEditar.setPrincipalAdministrador(principalAdministrador);
            principalVenta.setEditarVenta(formularioEditar);
            colorTema();
            transferirDatos();
            infoTextPrompt();

            //Seccion Tabla Productos Disponibles
            TablaProductosDisponibles tablaProductosDisponibles = new TablaProductosDisponibles();
            tablaProductosDisponibles.setTipoFormulario(2);
            tablaProductosDisponibles.setPrincipalVenta(principalVenta);
            tablaProductosDisponibles.ejecutarRellenarTabla();
            principalVenta.getEditarVenta().setTablaProductosDisponibles(tablaProductosDisponibles);

            //Seccion Tabla Productos Listados
            TablaProductosListados tablaProductosListados = new TablaProductosListados();
            tablaProductosListados.setTipoFormulario(2);
            tablaProductosListados.setFormularioEditarVenta(formularioEditar);
            tablaProductosListados.setIdVenta(idVenta);
            tablaProductosListados.ejecutarRellenarTabla();
            principalVenta.getEditarVenta().setListaProductosEliminar(tablaProductosListados.getListaProductosEliminar());
            principalVenta.getEditarVenta().setTablaProductosListados(tablaProductosListados);

            configuracionTxtCantidadTxtTotal();

            //Seccion Operaciones Secundarias
            //creo el objeto operaciones secundarias
            OperacionesSecundariasVenta operacionesSecundariasVenta = new OperacionesSecundariasVenta();
            //le pego el formulario con el que va a trabajar
            operacionesSecundariasVenta.setFormularioEditarVenta(formularioEditar);
            //le asigno el valor del tipo de formulario para los switchs(si es registrar 1 va a trabajar de una forma si es editar 2 va a trabajar de otra)
            operacionesSecundariasVenta.setTipoFormulario(2);
            //guardo el la instancia en el formulario grafico
            principalVenta.getEditarVenta().setOperacionesSecundariasVenta(operacionesSecundariasVenta);
            rellenarBoxes();

            //seccion tablaCliente
            TablaClienteWhenEdit tablaCliente = new TablaClienteWhenEdit();
            tablaCliente.setIdVenta(idVenta);
            tablaCliente.setFormularioEditarVenta(formularioEditar);
            tablaCliente.ejecutarRellenenarTabla();
            Integer idCliente = tablaCliente.getIdCliente();
            principalVenta.getEditarVenta().setIdCliente(idCliente);

            TablaClienteLista tablaClienteLista = new TablaClienteLista();
            tablaClienteLista.setFormularioEditarVenta(principalVenta.getEditarVenta());
            tablaClienteLista.ejecutarRellenarTabla();
            formularioEditar.setTablaClienteLista(tablaClienteLista);

            TablaCuenta tablaCuenta = new TablaCuenta();
            tablaCuenta.setFormularioEditarVenta(formularioEditar);
            formularioEditar.setTablaCuenta(tablaCuenta);
            
            radButons();

            ComprobanteVenta comprobante = new ComprobanteVenta();
            formularioEditar.setComprobante(comprobante);

        }

        principalVenta.getEditarVenta().setVisible(true);
        principalVenta.setEditarVenta(null);

    }

    public void infoTextPrompt() {
        new TextPrompt("CANTIDAD", principalVenta.getEditarVenta().getTxtCantidad());
        new TextPrompt("BUSCAR POR NOMBRE", principalVenta.getEditarVenta().getTxtBuscar());
        new TextPrompt("BUSCAR POR NOMBRE", principalVenta.getEditarVenta().getTxtBuscarClientes());
        principalVenta.getEditarVenta().getTxtBuscar().grabFocus();
    }

    @Override
    public void colorTema() {
        principalVenta.getEditarVenta().getPanelPrincipalTop().setBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getEditarVenta().getrSDateChooser().setColorBackground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getEditarVenta().getTablaGraficaListaCliente().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getEditarVenta().getTablaGraficaListaCliente().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getEditarVenta().getTablaGraficaProductosDisponibles().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getEditarVenta().getTablaGraficaProductosDisponibles().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getEditarVenta().getTablaListarProductos().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getEditarVenta().getTablaListarProductos().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getEditarVenta().getTablaGraficaDescontarCuenta().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getEditarVenta().getTablaGraficaDescontarCuenta().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getEditarVenta().getTablaGraficaCliente().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getEditarVenta().getTablaGraficaCliente().setForeground(principalVenta.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void transferirDatos() {

    }

    @Override
    public void agregarBoxes() {

    }

    @Override
    public void rellenarBoxes() {
        principalVenta.getEditarVenta().getBoxTipoVenta().addItem("Venta Simple");
        principalVenta.getEditarVenta().getBoxTipoVenta().addItem("Pedido");
    }

    private void configuracionTxtCantidadTxtTotal() {
        principalVenta.getEditarVenta().getTxtCantidad().setText("1");
        principalVenta.getEditarVenta().getTxtCantidad().setHorizontalAlignment(SwingConstants.CENTER);
        // principalVenta.getEditarVenta().getLblPrecioTotal().setText("0.0");
    }

    private void radButons() {
        principalVenta.getEditarVenta().getRadButonAbrirAlFinalizar().setEnabled(false);
        principalVenta.getEditarVenta().getRadButonImprimir().setEnabled(false);
        
        principalVenta.getEditarVenta().getRadButonAbrirAlFinalizar().setForeground(new Color(102,102,102));
        principalVenta.getEditarVenta().getRadButonImprimir().setForeground(new Color(102,102,102));

    }

}
