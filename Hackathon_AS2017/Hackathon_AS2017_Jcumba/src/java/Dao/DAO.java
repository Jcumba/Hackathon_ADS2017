package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    private Connection cn;
    
    public void Conectar() throws Exception{
    
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    cn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;databaseName=BDHackathon","sa","vallegrande2018");
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    
    
}
