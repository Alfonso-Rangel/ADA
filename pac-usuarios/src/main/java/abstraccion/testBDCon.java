package abstraccion;

import controlador.ControllerBaseDatos;

public class testBDCon {
    public void testBDCon() {
        ControllerBaseDatos controllerBaseDatos = new ControllerBaseDatos();
        controllerBaseDatos.testBaseDatos();
    }
}
