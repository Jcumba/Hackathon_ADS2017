package Dao;

import Model.ClienteModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends DAO implements IClienteDao {

    @Override
    public List<ClienteModel> ListarA() throws Exception {
        List<ClienteModel> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = this.getCn().prepareStatement("SELECT * FROM vw_listUser");
            rs = ps.executeQuery();
            lista = new ArrayList();
            ClienteModel Model;
            while (rs.next()) {
                Model = new ClienteModel();
                Model.setNombre(rs.getString("nom_usua"));
                Model.setApellido(rs.getString("ape_usua"));
                Model.setDni(rs.getString("dni_usua"));
                Model.setNacimiento(rs.getString("fef_nac_usua"));

            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void Ingresar(ClienteModel Model) throws Exception {
        this.Conectar();
        try {
            PreparedStatement ps = this.getCn().prepareStatement("EXEC sp_regusuario ?,?,?,?,'A'");
            ps.setString(1, Model.getNombre());
            ps.setString(2, Model.getApellido());
            ps.setString(3, Model.getDni());
            ps.setString(4, Model.getNacimiento());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void Actualizar(ClienteModel Model) throws Exception {
        this.Conectar();
        try {
            PreparedStatement ps = this.getCn().prepareStatement("EXEC sp_actusuario ?,?,?,?");
            ps.setString(1, Model.getNombre());
            ps.setString(2, Model.getApellido());
            ps.setString(3, Model.getDni());
            ps.setString(4, Model.getNacimiento());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

}
