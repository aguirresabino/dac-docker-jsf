/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.jsf.docker.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author aguirresabino
 */
public class ConFactory {
        
    private final String host;
    private final Properties props;

    public ConFactory(){
        this.host = "jdbc:postgresql://postgres:5432/dac-jsf-docker";
        props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(host, props);
    }
}