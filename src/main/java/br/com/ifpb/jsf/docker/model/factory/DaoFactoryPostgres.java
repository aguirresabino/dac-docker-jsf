/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.jsf.docker.model.factory;

import br.com.ifpb.jsf.docker.model.dao.impl.ContatoDao;
import br.com.ifpb.jsf.docker.model.dao.interfaces.ContatoDaoIF;

/**
 *
 * @author aguirresabino
 */
public class DaoFactoryPostgres implements DaoFactoryIF{

    @Override
    public ContatoDaoIF createContatoDao() {
        return new ContatoDao();
    }
    
}
