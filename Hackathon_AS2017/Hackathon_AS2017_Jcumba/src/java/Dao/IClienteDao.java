package Dao;

import Model.ClienteModel;
import java.util.List;

interface IClienteDao {
    
    public List<ClienteModel> ListarA() throws Exception;
    public void Ingresar(ClienteModel Model) throws Exception;
    public void Actualizar(ClienteModel Model) throws Exception;
    
}
