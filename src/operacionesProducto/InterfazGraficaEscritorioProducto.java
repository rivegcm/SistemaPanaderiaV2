package operacionesProducto;

import calsesPadre.InterfazGraficaEscritorio;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalProducto;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaEscritorioProducto extends InterfazGraficaEscritorio {

    @Override
    public void nuevaVentana() {
        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getCliente())) {
            PrincipalProducto principalProducto = new PrincipalProducto();
            principalAdministrador.setProducto(principalProducto);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) principalProducto.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getProducto().remove(menupanel);
            principalAdministrador.getProducto().setSize(width, Height);
            principalAdministrador.getEscritorio().add(principalAdministrador.getProducto());
            infoTextPrompt();
            TablaProducto tablaProducto = new TablaProducto();
            tablaProducto.setPrincipalProducto(principalAdministrador.getProducto());
            tablaProducto.ejecutarRellenarTabla();
            principalAdministrador.getProducto().setTablaProducto(tablaProducto);

            InterfazGraficaFormularioRegistrarProducto formularioRegistrar = new InterfazGraficaFormularioRegistrarProducto();
            InterfazGraficaFormularioEditarProducto formularioEditar = new InterfazGraficaFormularioEditarProducto();
            InterfazGraficaFormularioRegistrarPrecioProducto formularioPrecio = new InterfazGraficaFormularioRegistrarPrecioProducto();

            principalAdministrador.getProducto().setFormularioRegistrar(formularioRegistrar);
            principalAdministrador.getProducto().setFormularioEditar(formularioEditar);
            principalAdministrador.getProducto().setFormularioPrecio(formularioPrecio);

            principalAdministrador.getProducto().show();
        }
        colorInterfazEscritorio();
        principalAdministrador.getProducto().toFront();
    }

    @Override
    public void infoTextPrompt() {
        principalAdministrador.getProducto().getPanelPrincipalTop().setBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getProducto().getTablaGrafica().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getProducto().getTablaGrafica().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void colorInterfazEscritorio() {
        new TextPrompt("BUSCAR POR NOMBRE", principalAdministrador.getProducto().getTxtBuscar());
        principalAdministrador.getProducto().getTxtBuscar().grabFocus();
    }

}