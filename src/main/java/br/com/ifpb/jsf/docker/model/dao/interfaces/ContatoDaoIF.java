/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.jsf.docker.model.dao.interfaces;

import br.com.ifpb.jsf.docker.model.entities.Contato;
import java.util.List;

/**
 *
 * @author aguirresabino
 */
public interface ContatoDaoIF extends GenericDaoIF<Contato>{
    public Contato login(Contato contato);
    public List<Contato> searchByNome(String nome);
    public List<Contato> orderByLetra(String letra);
}
