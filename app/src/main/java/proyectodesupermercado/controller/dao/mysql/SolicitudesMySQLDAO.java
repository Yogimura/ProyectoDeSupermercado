package proyectodesupermercado.controller.dao.mysql;

import com.mysql.jdbc.NotImplemented;
import proyectodesupermercado.controller.ConditionsBuilder;
import proyectodesupermercado.controller.dao.DatabaseUtil;
import proyectodesupermercado.controller.dao.SolicitudesDAO;
import proyectodesupermercado.lib.databaseUtils.DatabaseEnvironment;
import proyectodesupermercado.modelo.SolicitudCompra;
import proyectodesupermercado.modelo.SolicitudCompraProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class SolicitudesMySQLDAO implements SolicitudesDAO {
    private DatabaseEnvironment dbEnv;

    public SolicitudesMySQLDAO(DatabaseEnvironment dbEnv) {
        this.dbEnv = dbEnv;
    }

    @Override
    public Set<SolicitudCompra> listAll() {
        String query = "SELECT * FROM Solicitud ORDER BY fechaDeCreacion DESC LIMIT 50";
        try (Connection conn = dbEnv.getConnection();
             Statement statement = conn.createStatement();) {
            ResultSet rs = statement.executeQuery(query);
            Set<SolicitudCompra> res = new HashSet<>();
            while (rs.next()) {
                res.add(
                        new SolicitudCompra(
                                rs.getInt("Solicitud.id"),
                                rs.getTimestamp("Solicitud.fechaDeCreacion"),
                                rs.getBoolean("Solicitud.aceptado")
                        )
                );
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<SolicitudCompra> listById(Object id) {
        throw new UnsupportedOperationException("Not implemented method");
    }

    @Override
    public List<SolicitudCompra> searchByFields(Timestamp fechaDeInicio, Timestamp fechaDeFinalizacon, boolean noAceptados) {
        ConditionsBuilder builder = new ConditionsBuilder(
                "SELECT * FROM Solicitud "
        ).addConditionIf(fechaDeInicio != null,
                "Solicitud.fechaDeCreacion > ?",
                fechaDeInicio
        ).addConditionIf(fechaDeFinalizacon != null,
                "Solicitud.fechaDeCreacion < ?",
                fechaDeFinalizacon
        ).addCondition("Solicitud.aceptado = ?", noAceptados
        ).setAtLast(" LIMIT 50");

        try (Connection conn = dbEnv.getConnection();
             PreparedStatement statement = conn.prepareStatement(builder.commitConditions(" AND "))) {
            int index = 1;
            for (Object param : builder.getParams()) {
                statement.setObject(index, param);
                index++;
            }
            ResultSet rs = statement.executeQuery();
            List<SolicitudCompra> res = new ArrayList<>();
            while (rs.next()) {
                res.add(
                        new SolicitudCompra(
                                rs.getInt("Solicitud.id"),
                                rs.getTimestamp("Solicitud.fechaDeCreacion"),
                                rs.getBoolean("Solicitud.aceptado")
                        )
                );
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(SolicitudCompra object) {
        String queryNewSolicitud = "INSERT INTO Solicitud(id, fechaDeCreacion) VALUES (?, ?)";
        String queryRegisterProductos = "INSERT INTO SolicitudProducto(id, idProductoRegistro, idSolicitud, " +
                "cantidad, precioCompraPorUnidad) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbEnv.getConnection();) {
            try (PreparedStatement statementNewSolicitud = conn.prepareStatement(queryNewSolicitud);
                 PreparedStatement statementRegisterProductos = conn.prepareStatement(queryRegisterProductos)) {
                conn.setAutoCommit(false);
                int id = DatabaseUtil.getLastInsertId(statementNewSolicitud, "Solicitud") + 1;

                statementNewSolicitud.setInt(1, id);
                statementNewSolicitud.setTimestamp(2, object.getFecha());
                statementNewSolicitud.executeUpdate();

                for (SolicitudCompraProducto producto : object.getProductos()) {
                    int lastIndex = DatabaseUtil.getLastInsertId(statementRegisterProductos, "SolicitudProducto");
                    statementRegisterProductos.setInt(1, lastIndex + 1);
                    statementRegisterProductos.setLong(2, producto.getIdProductoRegistro());
                    statementRegisterProductos.setInt(3, id);
                    statementRegisterProductos.setInt(4, producto.getCantidad());
                    statementRegisterProductos.setDouble(5, producto.getPrecioDeCompra());
                    statementRegisterProductos.executeUpdate();
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
