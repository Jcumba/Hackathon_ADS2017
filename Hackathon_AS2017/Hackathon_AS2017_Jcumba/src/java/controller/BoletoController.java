package controller;

import dao.BoletoDao;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import model.BoletoModel;

@Named(value = "boletoController")
@SessionScoped
public class BoletoController implements Serializable {

    List<BoletoModel> LstBoleto = new ArrayList();
    BoletoModel BoletoModel = new BoletoModel();
    
    @PostConstruct
    public void iniciar() {
        try {
            Listar();
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(BoletoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Listar() throws Exception {
        BoletoDao dao;
        try {
            dao = new BoletoDao();
            LstBoleto = dao.ListarA();
        } catch (Exception e) {
            throw e;
        }
    }

    public void ingresar() throws Exception {
        BoletoDao dao;
        try {
            dao = new BoletoDao();
            dao.Ingresar(BoletoModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizar() throws Exception {
        BoletoDao dao;
        try {
            dao = new BoletoDao();
            dao.Actualizar(BoletoModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
       BoletoModel  = new BoletoModel();
    }

    public List<BoletoModel> getLstBoleto() {
        return LstBoleto;
    }

    public void setLstBoleto(List<BoletoModel> LstBoleto) {
        this.LstBoleto = LstBoleto;
    }

    public BoletoModel getBoletoModel() {
        return BoletoModel;
    }

    public void setBoletoModel(BoletoModel BoletoModel) {
        this.BoletoModel = BoletoModel;
    }



   
    
    
    
    
}
