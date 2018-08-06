/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.jsf.docker.model.service;

import br.com.ifpb.jsf.docker.model.factory.DaoFactoryIF;
import br.com.ifpb.jsf.docker.model.factory.DaoFactoryPostgres;
import br.com.ifpb.jsf.docker.model.dao.interfaces.ContatoDaoIF;
import br.com.ifpb.jsf.docker.model.entities.Contato;
import java.util.List;

/**
 *
 * @author aguirresabino
 */
public class ContatoService implements ContatoDaoIF{
    
    private final DaoFactoryIF daoFactory;
    private final ContatoDaoIF contatoDao;
    
    {
        daoFactory = new DaoFactoryPostgres();
        contatoDao = daoFactory.createContatoDao();
    }
    
    @Override
    public Contato login(Contato c){
        return contatoDao.login(c);
    }

    @Override
    public boolean create(Contato c){
        return contatoDao.create(c);
    }

    @Override
    public List<Contato> read() {
        return contatoDao.read();
    }

    @Override
    public boolean update(Contato c) {
        return contatoDao.update(c);
    }

    @Override
    public boolean delete(Contato c) {
        return contatoDao.delete(c);
    }        

    @Override
    public List<Contato> searchByNome(String nome) {
        return contatoDao.searchByNome(nome);
    }

    @Override
    public List<Contato> orderByLetra(String letra) {
        return contatoDao.orderByLetra(letra);
    }
}
