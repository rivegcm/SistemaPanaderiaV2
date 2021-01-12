package operacionesCuenta;

import calsesPadre.InterfazGraficaEscritorio;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalCuenta;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaEscritorioCuenta  extends InterfazGraficaEscritorio {

    private Integer idCliente;
    
    private  String nombreCliente;
    

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    
    
    @Override
    public void nuevaVentana() {
        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getCuenta())) {
            PrincipalCuenta principalCuenta = new PrincipalCuenta();
            principalAdministrador.setCuenta(principalCuenta);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) principalCuenta.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getCuenta().remove(menupanel);
            principalAdministrador.getCuenta().setSize(width, Height);
            principalAdministrador.getEscritorio().add(principalAdministrador.getCuenta());
            infoTextPrompt();
            TablaCuenta tablaCuenta = new TablaCuenta();
            tablaCuenta.setPrincipalCuenta(principalAdministrador.getCuenta());
            tablaCuenta.setIdCliente(idCliente);
            tablaCuenta.ejecutarRellenarTabla();
            TablaMovimientoCuenta tablaMovimientoCuenta = new TablaMovimientoCuenta();
            tablaMovimientoCuenta.setPrincipalCuenta(principalAdministrador.getCuenta());
            insertarNombreCliente();
            principalAdministrador.getCuenta().setTablaCuenta(tablaCuenta);
            principalAdministrador.getCuenta().setTablaMovimientoCuenta(tablaMovimientoCuenta);
            InterfazGraficaFormularioEditarCuenta formularioEditar = new InterfazGraficaFormularioEditarCuenta();
          //  principalAdministrador.getCuenta().setFormularioEditar(formularioEditar);
            principalAdministrador.getCuenta().show();
        }
        colorInterfazEscritorio();
        principalAdministrador.getCuenta().toFront();
    }

    @Override
    public void infoTextPrompt() {
         new TextPrompt("BUSCAR POR FECHA, FORMATO (AAAA-MM-DD)", principalAdministrador.getCuenta().getTxtBuscar());
        principalAdministrador.getCuenta().getTxtBuscar().grabFocus();
    }

    @Override
    public void colorInterfazEscritorio() {
        principalAdministrador.getCuenta().getPanelPrincipalTop().setBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getCuenta().getTablaGraficaCuenta().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getCuenta().getTablaGraficaCuenta().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
   
        principalAdministrador.getCuenta().getTablaGraficaMovimiento().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getCuenta().getTablaGraficaMovimiento().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
    }
    
    private void insertarNombreCliente(){
         principalAdministrador.getCuenta().getLblNombre().setText(this.nombreCliente);
    }
    
}