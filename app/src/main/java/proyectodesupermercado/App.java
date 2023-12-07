/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package proyectodesupermercado;

import proyectodesupermercado.Vista.AppFrame;
import proyectodesupermercado.Vista.interfaces.ControlInventario;
import proyectodesupermercado.Vista.roles.AdminITViewCreator;
import proyectodesupermercado.Vista.roles.ContabilidadViewCreator;
import proyectodesupermercado.Vista.roles.GerenteViewCreator;
import proyectodesupermercado.Vista.roles.InventarioViewCreator;
import proyectodesupermercado.Vista.roles.PuntoDeVentaViewCreator;
import proyectodesupermercado.controller.DBControlManejoGanancias;
import proyectodesupermercado.controller.DatabaseControlHistorialSolicitudes;
import proyectodesupermercado.controller.DatabaseControlInventario;
import proyectodesupermercado.controller.DatabaseControlListaPendientes;
import proyectodesupermercado.controller.DatabaseControlProductoRegistro;
import proyectodesupermercado.controller.DatabaseControlPuntoDeVenta;
import proyectodesupermercado.controller.DatabaseControlUsuario;
import proyectodesupermercado.controller.DatabaseSesionUsuario;
import proyectodesupermercado.controller.DatabaseSolicitudCompra;
import proyectodesupermercado.controller.StateBroker;
import proyectodesupermercado.controller.authentication.HashPasswordFactory;
import proyectodesupermercado.controller.authentication.Rol;
import proyectodesupermercado.controller.dao.NotificacionesDAO;
import proyectodesupermercado.controller.dao.RolDAO;
import proyectodesupermercado.controller.dao.SolicitudesDAO;
import proyectodesupermercado.controller.dao.SuplidorDAO;
import proyectodesupermercado.controller.dao.mysql.InventarioProductoMySQLDAO;
import proyectodesupermercado.controller.dao.mysql.ManejoGananciasMySQLDAO;
import proyectodesupermercado.controller.dao.mysql.NotificacionesMySQLDAO;
import proyectodesupermercado.controller.dao.mysql.ProductoRegistroMySQLDAO;
import proyectodesupermercado.controller.dao.mysql.PuntoDeVentaStockMySQLDAO;
import proyectodesupermercado.controller.dao.mysql.SolicitudesMySQLDAO;
import proyectodesupermercado.controller.dao.mysql.SuplidorMySQLDAO;
import proyectodesupermercado.controller.dao.mysql.UsuarioMySQLDAO;
import proyectodesupermercado.lib.databaseUtils.DatabaseEnvironment;

import javax.swing.JFrame;
import java.security.SecureRandom;
import java.util.Map;

public class App {
    public static ThreadLocal<SecureRandom> secureRandom;
    static {
        // init mysql driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("No se pudo cargar 'com.mysql.jdbc.Driver'");
            System.exit(-1);
        }

        // init secureRandom
        secureRandom = ThreadLocal.withInitial(SecureRandom::new);
    }
    public static void main(String[] args) {

        DatabaseEnvironment dbEnv = new DatabaseEnvironment(
                "jdbc:mysql://localhost:3306/Prog1",
                "MySQL test",
                "testtest"
        );
        RolDAO.initRoles(dbEnv);
        UsuarioMySQLDAO usuarioDAO = new UsuarioMySQLDAO(dbEnv);
        // Ctrl + / comentar/descomentar netbeans

//        UsuarioMySQLDAO.initTestUsers(usuarioDAO);

        SuplidorDAO suplidorDAO = new SuplidorMySQLDAO(dbEnv);
        ControlInventario controlInventario = new DatabaseControlInventario(
                new InventarioProductoMySQLDAO(dbEnv)
        );

        SolicitudesDAO controlSolicitudesDAO = new SolicitudesMySQLDAO(dbEnv);
        NotificacionesDAO notificacionesDAO = new NotificacionesMySQLDAO(dbEnv);

        AppFrame changer = new AppFrame();
        DatabaseSesionUsuario sesionUsuario = new DatabaseSesionUsuario(
                usuarioDAO
        );
        StateBroker stateBroker;
        stateBroker = new StateBroker(
                changer,
                changer::dispose,
                Map.of(
                        Rol.PuntoDeVenta, new PuntoDeVentaViewCreator(
                                sesionUsuario,
                                new DatabaseControlPuntoDeVenta(
                                        new PuntoDeVentaStockMySQLDAO(dbEnv),
                                        price -> price * 0.18),
                                new DatabaseControlInventario(
                                        new InventarioProductoMySQLDAO(dbEnv, false, 1)
                                )
                        ),
                        Rol.Inventario, new InventarioViewCreator(
                                controlInventario,
                                new DatabaseControlInventario(
                                        new InventarioProductoMySQLDAO(dbEnv, true, 0)
                                )
                        ),
                        Rol.Gerente, new GerenteViewCreator(
                                new DatabaseControlProductoRegistro(
                                        new ProductoRegistroMySQLDAO(dbEnv),
                                        suplidorDAO),
                                new DatabaseSolicitudCompra(
                                        controlSolicitudesDAO,
                                        notificacionesDAO
                                ),
                                controlInventario,
                                new DatabaseControlListaPendientes(
                                        notificacionesDAO
                                ),
                                new DatabaseControlHistorialSolicitudes(
                                        controlSolicitudesDAO
                                ),
                                sesionUsuario
                        ),
                        Rol.AdminIT, new AdminITViewCreator(
                                new DatabaseControlUsuario(
                                        new UsuarioMySQLDAO(dbEnv)
                                ),
                                new HashPasswordFactory.PBKDF2HashPasswordFactory()
                        ),
                        Rol.Contabilidad, new ContabilidadViewCreator(
                                new DBControlManejoGanancias(
                                        new ManejoGananciasMySQLDAO(dbEnv)
                                )
                        )
                )
        );
        sesionUsuario.setStateBroker(stateBroker);
        changer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        stateBroker.moveToLogin(sesionUsuario);
        changer.setTitle("Ventana");
        changer.pack();
        changer.setVisible(true);
        changer.setLocationRelativeTo(null);
        Runtime.getRuntime().addShutdownHook(new Thread(sesionUsuario::logOut));
    }
}
