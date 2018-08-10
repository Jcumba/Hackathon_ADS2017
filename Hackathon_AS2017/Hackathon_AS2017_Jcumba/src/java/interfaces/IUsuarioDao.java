package interfaces;

import java.util.List;
import model.UsuarioModel;

public interface IUsuarioDao {
    List<UsuarioModel> ListarA() throws Exception;
    void Ingresar(UsuarioModel Model) throws Exception;
    void Actualizar(UsuarioModel Model) throws Exception;
}
