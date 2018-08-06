/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.jsf.docker.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author aguirresabino
 */
public interface GenericDaoIF <T> {
    public boolean create(T object);
    public List<T> read();
    public boolean update(T object);
    public boolean delete(T object);
}