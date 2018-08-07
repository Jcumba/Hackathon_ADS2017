package Controller;

import Dao.PasajeroDao;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import Model.PasajeroModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.inject.Named;

@Named(value = "pasajeroController")
@SessionScoped
public class PasajeroController implements Serializable {
    
    List<PasajeroModel> lstPasajero = new ArrayList();
    PasajeroModel pasajeroModel = new PasajeroModel();

    @PostConstruct
    public void iniciar() {
        try {
            Listar();
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(PasajeroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Listar() throws Exception {
        PasajeroDao dao;
        try {
            dao = new PasajeroDao();
            lstPasajero = dao.ListarA();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Ingresar() throws Exception {
        PasajeroDao dao;
        try {
            dao = new PasajeroDao();
            dao.Ingresar(pasajeroModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Actualizar() throws Exception {
        PasajeroDao dao;
        try {
            dao = new PasajeroDao();
            dao.Actualizar(pasajeroModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        pasajeroModel = new PasajeroModel();
    }

    public List<PasajeroModel> getLstPasajero() {
        return lstPasajero;
    }

    public void setLstPasajero(List<PasajeroModel> lstPasajero) {
        this.lstPasajero = lstPasajero;
    }

    public PasajeroModel getPasajeroModel() {
        return pasajeroModel;
    }

    public void setPasajeroModel(PasajeroModel pasajeroModel) {
        this.pasajeroModel = pasajeroModel;
    }

    
    
}
