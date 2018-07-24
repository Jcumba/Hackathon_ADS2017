package Controller;

import Dao.ServiciosDao;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import Model.ServiciosModel;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.inject.Named;

@Named(value = "serviciosController")
@SessionScoped
public class ServiciosController implements Serializable {

    ServiciosModel serviciosModel = new ServiciosModel();
    private List<ServiciosModel> lstServic;

    @PostConstruct
    public void iniciar() {
        try {
            Listar();
            limpiar();
        } catch (Exception e) {
        }
    }

    public void Listar() throws Exception {
        ServiciosDao dao;
        try {
            dao = new ServiciosDao();
            lstServic = dao.ListarA();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Ingresar() throws Exception {
        ServiciosDao dao;
        try {
            dao = new ServiciosDao();
            dao.Ingresar(serviciosModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Actualizar() throws Exception {
        ServiciosDao dao;
        try {
            dao = new ServiciosDao();
            dao.Actualizar(serviciosModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
       serviciosModel  = new ServiciosModel();
    }

    public ServiciosModel getServiciosModel() {
        return serviciosModel;
    }

    public void setServiciosModel(ServiciosModel serviciosModel) {
        this.serviciosModel = serviciosModel;
    }

    public List<ServiciosModel> getLstServic() {
        return lstServic;
    }

    public void setLstServic(List<ServiciosModel> lstServic) {
        this.lstServic = lstServic;
    }


    
    
}
