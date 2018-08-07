package Dao;

import Model.SucursalModel;
import java.util.List;

interface ISucursalDao {

    public List<SucursalModel> ListarA() throws Exception;

    public void Ingresar(SucursalModel Model) throws Exception;

    public void Actualizar(SucursalModel Model) throws Exception;
}
