package operacionesCuenta;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import entidades.Cuenta;
import entidades.MovimientoCuenta;
import escritorios.PrincipalCuenta;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Hasper Franco
 */
public class TablaMovimientoCuenta extends Tabla {

    private Integer idCuenta;
    private PrincipalCuenta principalCuenta;
    private List<Integer> listaResutladosActuales = new ArrayList<Integer>();

    public TablaMovimientoCuenta() {
        setEstadoConsulta(0);
    }

    public PrincipalCuenta getPrincipalCuenta() {
        return principalCuenta;
    }

    public void setPrincipalCuenta(PrincipalCuenta principalCuenta) {
        this.principalCuenta = principalCuenta;
    }

    public List<Integer> getListaResutladosActuales() {
        return listaResutladosActuales;
    }

    public void setListaResutladosActuales(List<Integer> listaResutladosActuales) {
        this.listaResutladosActuales = listaResutladosActuales;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla cuentas de la
     * ventana PrincipalCuenta.
     *
     * @param p
     */
    @Override
    public void ejecutarRellenarTabla() {
        setTabla(principalCuenta.getTablaGraficaMovimiento());
        setStringConsulta("from MovimientoCuenta where codigoCuenta=" + this.idCuenta);
        evaluarEstadoConsulta();
        //setCampoTexto(principalCuenta.getTxtBuscar());
        rellenarTabla("");
    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
            Integer totalFilas = principalCuenta.getTablaGraficaMovimiento().getRowCount();
            Integer filasSeleccionada = principalCuenta.getTablaGraficaMovimiento().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalCuenta.getTablaMovimientoCuenta().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
            this.setIdTabla(id);
        } catch (Exception e) {
        }
        return idTabla;
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {

        DefaultTableModel tablaMovimientoCuenta = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaMovimientoCuenta);

        try {
            this.listaResutladosActuales.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {
            MovimientoCuenta mc = (MovimientoCuenta) o;
            this.listaResutladosActuales.add(0, mc.getIdMovimientoCuenta());
            Vector<Object> fila = new Vector<>();
            fila.add(mc.getMotivo());
            fila.add(mc.getMonto());
            fila.add(mc.getBalance());
            fila.add(new OperacionesUtiles().formatoFechaSinHora(mc.getFecha()));
            tablaMovimientoCuenta.addRow(fila);

        }
        OperacionesUtiles.ordenarLista(listaResutladosActuales);
    }

    @Override
    public boolean verificarFilaSeleccionada() {
        try {
            int fila = principalCuenta.getTablaGraficaMovimiento().getSelectedRow();
            principalCuenta.getTablaGraficaMovimiento().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}