package Dao;

import Model.UsuarioModel;
import java.util.List;

interface IUsuarioDao {
    
    public List<UsuarioModel> ListarA() throws Exception;
    public void Ingresar(UsuarioModel Model) throws Exception;
    public void Actualizar(UsuarioModel Model) throws Exception;
    
}
