package interfaces;

import java.util.List;
import model.BoletoModel;

public interface IBoletoDao {
    List<BoletoModel> ListarA() throws Exception;
    void Ingresar(BoletoModel Model) throws Exception;
    void Actualizar(BoletoModel Model) throws Exception;
}
