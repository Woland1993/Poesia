package repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Woland
 */
class PoolConnection {

    private Connection conexion = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String JNDI;

    public PoolConnection(String JNDI) {
        this.JNDI = JNDI;
    }

    public Connection conectarJNDI() {
        try {
            if (conexion != null) {
                this.cerrarConeccion();
            }
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(this.JNDI);
            if (ds != null) {
                this.conexion = ds.getConnection();
                return this.conexion;
            } else {
                System.out.println("No se encontró dataSource");
                return null;
            }
        } catch (NamingException ex) {
            System.err.println("No se encontró el nombre del recurso: " + ex);
            return null;
        } catch (SQLException ex) {
            System.err.println("No se pudo establecer conexion" + ex);
            return null;
        }
    }

    /**
     * Ejecuta la consulta recibida en la conexion abierta
     *
     * @param ps
     * @return q
     */
    public ResultSet consultar(PreparedStatement ps) {
        this.ps = ps;
        try {
            if (this.ps != null) {
                this.ps.setQueryTimeout(6);
                this.rs = this.ps.executeQuery();
            }
            return this.rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return this.rs;
    }

    /**
     * Ejecuta la consulta recibida en la conexion abierta
     *
     * @param sql
     * @return
     */
    public ResultSet consultar(String sql) {
        try {
            if (this.ps != null) {
                this.ps = this.conexion.prepareStatement(sql);
                this.ps.setQueryTimeout(6);
                this.rs = this.ps.executeQuery();
            }
            return this.rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return this.rs;
    }

    /**
     * xx Ejecuta el update recibido
     *
     * @param ps
     * @return
     */
    public boolean execUpIn(PreparedStatement ps) throws SQLException {
        this.ps = ps;
                this.ps.executeUpdate();
            return true;
    }
    
    public ResultSet insert(PreparedStatement ps) {
        this.ps = ps;
        try {
            if (this.ps != null) {
                this.ps.executeUpdate();
                this.rs=this.ps.getGeneratedKeys();
            }
            return this.rs;
        } catch (SQLException ex) {
            Logger.getLogger(PoolConnection.class.getName()).log(Level.SEVERE, null, ex);
            return this.rs;
        }

    }

    /**
     * xx Ejecuta el update recibido
     *
     * @param update
     * @return
     */
    public boolean execUpIn(String update) {
        try {
            if (this.ps != null) {
                this.ps = this.conexion.prepareStatement(update);
                this.ps.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PoolConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    /**
     *
     * @param update
     * @return
     */
    public boolean execute(String update) {
        try (CallableStatement stmt = conexion.prepareCall(update)) {
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PoolConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //
    /**
     * cierra
     * @return  resulSet, PreparedStatement y la conexion
     */
    public boolean cerrarConeccion() {

        try {

            if (this.rs != null) {
                this.rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (this.conexion != null) {
                this.conexion.close();
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            try {
                if(ps!=null){
                System.out.println("ps is Closed? " + ps.isClosed());
                }
                if(rs!=null){
                System.out.println("rs is Closed? " + rs.isClosed());
                }
                if(conexion!=null){
                System.out.println("conexion is Closed? " + conexion.isClosed());
                }
            } catch (SQLException ex) {
            }
        }
    }


}
