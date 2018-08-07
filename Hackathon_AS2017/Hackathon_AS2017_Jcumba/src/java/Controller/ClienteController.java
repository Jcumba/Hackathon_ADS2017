package Controller;

import Dao.ClienteDao;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import Model.ClienteModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.inject.Named;

@Named(value = "clienteController")
@SessionScoped
public class ClienteController implements Serializable {
    
    List<ClienteModel> lstClient = new ArrayList();
    ClienteModel clienteModel = new ClienteModel();

    @PostConstruct
    public void iniciar() {
        try {
            Listar();
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Listar() throws Exception {
        ClienteDao dao;
        try {
            dao = new ClienteDao();
            lstClient = dao.ListarA();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Ingresar() throws Exception {
        ClienteDao dao;
        try {
            dao = new ClienteDao();
            dao.Ingresar(clienteModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Actualizar() throws Exception {
        ClienteDao dao;
        try {
            dao = new ClienteDao();
            dao.Actualizar(clienteModel);
            Listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        clienteModel = new ClienteModel();
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    public List<ClienteModel> getLstClient() {
        return lstClient;
    }

    public void setLstClient(List<ClienteModel> lstClient) {
        this.lstClient = lstClient;
    }


    
    
}
