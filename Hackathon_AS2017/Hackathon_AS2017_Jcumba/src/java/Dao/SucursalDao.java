package Dao;

import Model.SucursalModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalDao extends DAO implements ISucursalDao {

    @Override
    public List<SucursalModel> ListarA() throws Exception {
        this.Conectar();
        List<SucursalModel> lista;
        ResultSet rs;
        try {
            PreparedStatement ps = this.getCn().prepareCall("SELECT * FROM vw_listUser ORDER BY cod_usua");
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            SucursalModel Model;
            while (rs.next()) {
                Model = new SucursalModel();
                Model.setCodigo(rs.getString("cod_usua"));
                Model.setNombre(rs.getString("nom_usua"));
                lista.add(Model);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }

    @Override
    public void Ingresar(SucursalModel Model) throws Exception {
        this.Conectar();
        try {
            PreparedStatement ps = this.getCn().prepareStatement("EXEC sp_regusuario ?,?,?,?,'A'");
            ps.setString(1, Model.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void Actualizar(SucursalModel Model) throws Exception {
        this.Conectar();
        try {
            PreparedStatement ps = this.getCn().prepareStatement("EXEC sp_actusuario ?,?,?,?");
            ps.setString(1, Model.getNombre());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

}
