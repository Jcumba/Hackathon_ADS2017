package Dao;

import Model.PasajeroModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDao extends DAO implements IPasajeroDao {

    @Override
    public List<PasajeroModel> ListarA() throws Exception {
        this.Conectar();
        List<PasajeroModel> lista;
        ResultSet rs;
        try {
            PreparedStatement ps = this.getCn().prepareCall("SELECT * FROM vw_listPasajero ORDER BY cod_pasaj");
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            PasajeroModel Model;
            while (rs.next()) {
                Model = new PasajeroModel();
                Model.setCodigo(rs.getString("cod_pasaj"));
                Model.setNombre(rs.getString("nom_pasaj"));
                Model.setApellido(rs.getString("ape_pasaj"));
                Model.setTipodocumento(rs.getString("tipdocu_pasaj"));
                Model.setDocumento(rs.getString("docu_pasaj"));
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
    public void Ingresar(PasajeroModel Model) throws Exception {
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
    public void Actualizar(PasajeroModel Model) throws Exception {
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
