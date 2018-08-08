package Controller;

import Dao.UsuarioDao;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import Model.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.inject.Named;

@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {
    
    List<UsuarioModel> lstClient = new ArrayList();
    UsuarioModel usuarioModel = new UsuarioModel();

    @PostConstruct
    public void iniciar() {
        try {
            Listar();
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Listar() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            lstClient = dao.ListarA();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Ingresar() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            dao.Ingresar(usuarioModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Actualizar() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            dao.Actualizar(usuarioModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        usuarioModel = new UsuarioModel();
    }

    public List<UsuarioModel> getLstClient() {
        return lstClient;
    }

    public void setLstClient(List<UsuarioModel> lstClient) {
        this.lstClient = lstClient;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    
    
}
