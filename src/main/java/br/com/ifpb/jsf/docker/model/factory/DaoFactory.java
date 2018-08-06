/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.jsf.docker.model.factory;

/**
 *
 * @author aguirresabino
 */
public class DaoFactory {
    public static DaoFactoryIF createDaoFactory(){
        return new DaoFactoryPostgres();
    }    
}
