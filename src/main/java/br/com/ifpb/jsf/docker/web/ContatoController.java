/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.jsf.docker.web;

import br.com.ifpb.jsf.docker.model.entities.Contato;
import br.com.ifpb.jsf.docker.model.service.ContatoService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author aguirresabino
 */
@Named
@SessionScoped
public class ContatoController implements Serializable{
    
    private ContatoService contatoService;
    private Contato contato;
    private Contato dadosLogin;
    private String busca;
    private boolean modeEdit;

    
    {
        contatoService = new ContatoService();
        contato = new Contato();
        dadosLogin = new Contato();
        modeEdit = false;
    }

    public String login() {
        this.contato = this.contatoService.login(this.dadosLogin);
        dadosLogin = new Contato();
        if(this.contato != null){
            return "inicio.xhtml";
        }
        this.contato = new Contato();
        this.showMessage("Usuário não cadastrado", FacesMessage.SEVERITY_WARN);
        return null;
    }

    public String create() {
        boolean result = this.contatoService.create(this.contato);
        if(result){
            this.showMessage("Cadastro realizado!", FacesMessage.SEVERITY_INFO);
        } else{
            this.showMessage("O cadastro não foi realizado", FacesMessage.SEVERITY_ERROR);
        }
        
        this.contato = new Contato();
        return "";
    }

    public List<Contato> read() {
        return this.contatoService.read();
    }

    public String update(Contato contato) {
        this.contatoService.update(this.contato);
        this.contato = new Contato();
        this.setModeEdit(false);
        return null;
    }
    
    public String editando(Contato contato) {
        this.contato = contato;
        this.setModeEdit(true);
        return null;
    }

    public String delete(Contato contato) {
        this.contatoService.delete(contato);
        this.showMessage("Contato excluído", FacesMessage.SEVERITY_INFO);
        return null;
    }
    
    public List<Contato> searchByNome(){
        List<Contato> contatos = this.contatoService.searchByNome(this.busca);
        this.busca = "";
        return contatos;
    }
    
    public List<Contato> orderByLetra(){
        List<Contato> contatos = this.contatoService.searchByNome(this.busca);
        this.busca = "";
        return contatos;
    }
    
    public String logoff(){
        this.contato = new Contato();
        return "index.xhtml";
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Contato getDadosLogin() {
        return dadosLogin;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public boolean isModeEdit() {
        return modeEdit;
    }

    public void setModeEdit(boolean modeEdit) {
        this.modeEdit = modeEdit;
    }

    public void setDadosLogin(Contato dadosLogin) {
        this.dadosLogin = dadosLogin;
    }
    
    private void showMessage(String message, FacesMessage.Severity erro){
        FacesMessage fm = new FacesMessage(erro, message, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
}
