package proyectodesupermercado.Vista.interfaces;

import proyectodesupermercado.lib.tableModel.ObjectTableModel;
import proyectodesupermercado.modelo.NotificacionPendiente;
import proyectodesupermercado.modelo.SolicitudCompra;
import proyectodesupermercado.modelo.Usuario;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface ControlManejoSolicitudes {
    ObjectTableModel<SolicitudCompra> refreshSolicitudCompra();

    Optional<String> creaNuevaSolicitud(SolicitudCompra solicitudCompra);

    boolean areNotificationsActivated(Usuario usuario);

    Optional<Timestamp> getDateOfLastNotification(Usuario usuario);

    ;

    OptionalInt getLimit(Usuario usuario);

    Optional<String> activateLimit(Usuario usuario, boolean activate, int limit);
}
