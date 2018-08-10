package interfaces;

import java.util.List;
import model.PasajeroModel;

public interface IPasajeroDao {
    List<PasajeroModel> ListarA() throws Exception;
    void Ingresar(PasajeroModel Model) throws Exception;
    void Actualizar(PasajeroModel Model) throws Exception;
}
