package Controller;

import Dao.SucursalDao;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import Model.SucursalModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.inject.Named;

@Named(value = "sucursalController")
@SessionScoped
public class SucursalController implements Serializable {
    
    List<SucursalModel> lstSucursal = new ArrayList();
    SucursalModel sucursalModel = new SucursalModel();

    @PostConstruct
    public void iniciar() {
        try {
            Listar();
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(SucursalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Listar() throws Exception {
        SucursalDao dao;
        try {
            dao = new SucursalDao();
            lstSucursal = dao.ListarA();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Ingresar() throws Exception {
        SucursalDao dao;
        try {
            dao = new SucursalDao();
            dao.Ingresar(sucursalModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Actualizar() throws Exception {
        SucursalDao dao;
        try {
            dao = new SucursalDao();
            dao.Actualizar(sucursalModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        sucursalModel = new SucursalModel();
    }

    public List<SucursalModel> getLstSucursal() {
        return lstSucursal;
    }

    public void setLstSucursal(List<SucursalModel> lstSucursal) {
        this.lstSucursal = lstSucursal;
    }

    public SucursalModel getSucursalModel() {
        return sucursalModel;
    }

    public void setSucursalModel(SucursalModel sucursalModel) {
        this.sucursalModel = sucursalModel;
    }


    
    
}
