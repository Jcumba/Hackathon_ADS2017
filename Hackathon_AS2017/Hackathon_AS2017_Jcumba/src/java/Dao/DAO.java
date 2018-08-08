package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAO {

    private Connection cn;

    public void Conectar() throws Exception {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver).newInstance();
            cn = DriverManager.getConnection("jdbc:sqlserver://35.196.239.151;databaseName=BDHackathon", "root", "root");

    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

}
