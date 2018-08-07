package Dao;

import Model.PasajeroModel;
import java.util.List;

interface IPasajeroDao {

    public List<PasajeroModel> ListarA() throws Exception;

    public void Ingresar(PasajeroModel Model) throws Exception;

    public void Actualizar(PasajeroModel Model) throws Exception;
}
