package Dao;

import Model.ServiciosModel;
import java.util.List;

interface IServicioDao {

    public List<ServiciosModel> ListarA() throws Exception;

    public void Ingresar(ServiciosModel Model) throws Exception;

    public void Actualizar(ServiciosModel Model) throws Exception;
}
