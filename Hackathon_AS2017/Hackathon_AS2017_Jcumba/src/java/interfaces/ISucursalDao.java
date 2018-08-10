package interfaces;

import java.util.List;
import model.SucursalModel;

public interface ISucursalDao {
    List<SucursalModel> ListarA() throws Exception ;
    void Ingresar(SucursalModel Model) throws Exception;
    void Actualizar(SucursalModel Model) throws Exception; 
    
}
