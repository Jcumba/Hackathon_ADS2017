package Dao;

import Model.ServiciosModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiciosDao extends DAO implements IServicioDao {

    @Override
    public List<ServiciosModel> ListarA() throws Exception {
        List<ServiciosModel> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = this.getCn().prepareStatement("SELECT * FROM vw_listServ ORDER BY cod_servic");
            rs = ps.executeQuery();
            lista = new ArrayList();
            ServiciosModel Model;
            while (rs.next()) {
                Model = new ServiciosModel();
                Model.setCodigo(rs.getString("cod_servic"));
                Model.setNombre(rs.getString("nom_servic"));
                lista.add(Model);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void Ingresar(ServiciosModel Model) throws Exception {
        this.Conectar();
        try {
            PreparedStatement ps = this.getCn().prepareStatement("EXEC sp_regservicio ?,'A'");
            ps.setString(1, Model.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void Actualizar(ServiciosModel Model) throws Exception {
        this.Conectar();
        try {
            PreparedStatement ps = this.getCn().prepareStatement("EXEC sp_actservicio ?,?");
            ps.setString(1, Model.getNombre());
            ps.setString(2, Model.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    
        public void EliminarEsp(ServiciosModel Model) throws Exception {
        this.Conectar();
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getCodigo());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    

}
