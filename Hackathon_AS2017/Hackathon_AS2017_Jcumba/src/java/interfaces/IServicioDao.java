package interfaces;

import java.util.List;
import model.ServiciosModel;

public interface IServicioDao {
    List<ServiciosModel> ListarA() throws Exception;
    
    void Ingresar(ServiciosModel Model) throws Exception;
    
    void Actualizar(ServiciosModel Model) throws Exception;
}


