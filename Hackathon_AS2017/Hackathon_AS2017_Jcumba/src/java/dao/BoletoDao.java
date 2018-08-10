package dao;

import interfaces.IBoletoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BoletoModel;

public class BoletoDao extends DAO implements IBoletoDao{

    @Override
    public List<BoletoModel> ListarA() throws Exception {
        this.Conectar();
        List<BoletoModel> lista;
        ResultSet rs;

        try {
            String sql = "SELECT * FROM vw_listServ ORDER BY cod_servic";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            BoletoModel Model;
            while (rs.next()) {
                Model = new BoletoModel();
                Model.setCodigo(rs.getString(""));
                Model.setRazsocial(rs.getString(""));
                Model.setRuc(rs.getString(""));
                Model.setNompasajero(rs.getString(""));
                Model.setTipdoc(rs.getString(""));
                Model.setDoc(rs.getString(""));
                Model.setOrigen(rs.getString(""));
                Model.setDestino(rs.getString(""));
                Model.setFechaviaje(rs.getString(""));
                Model.setAsiento(rs.getString(""));
                Model.setCantboleto(rs.getString(""));
                Model.setPrecioboleto(rs.getString(""));
                Model.setFechaboleto(rs.getString(""));
                lista.add(Model);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void Ingresar(BoletoModel Model) throws Exception {
        this.Conectar();
        try {
            String sql = "EXEC sp_regservicio ?,'A'";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getRazsocial());
            ps.setString(2, Model.getRuc());
            ps.setString(3, Model.getNompasajero());
            ps.setString(4, Model.getTipdoc());
            ps.setString(5, Model.getDoc());
            ps.setString(6, Model.getOrigen());
            ps.setString(7, Model.getDestino());
            ps.setString(8, Model.getFechaviaje());
            ps.setString(9, Model.getAsiento());
            ps.setString(10, Model.getCantboleto());
            ps.setString(11, Model.getPrecioboleto());
            ps.setString(12, Model.getFechaboleto());  
            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void Actualizar(BoletoModel Model) throws Exception {
        this.Conectar();
        try {
            String sql = "EXEC sp_actservicio ?,?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getRazsocial());
            ps.setString(2, Model.getRuc());
            ps.setString(3, Model.getNompasajero());
            ps.setString(4, Model.getTipdoc());
            ps.setString(5, Model.getDoc());
            ps.setString(6, Model.getOrigen());
            ps.setString(7, Model.getDestino());
            ps.setString(8, Model.getFechaviaje());
            ps.setString(9, Model.getAsiento());
            ps.setString(10, Model.getCantboleto());
            ps.setString(11, Model.getPrecioboleto());
            ps.setString(12, Model.getFechaboleto());  
            ps.setString(13, Model.getCodigo()); 
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}
