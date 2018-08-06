/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.jsf.docker.model.dao.impl;

import br.com.ifpb.jsf.docker.model.dao.interfaces.ContatoDaoIF;
import br.com.ifpb.jsf.docker.model.entities.Contato;
import br.com.ifpb.jsf.docker.model.factory.ConFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguirresabino
 */
public class ContatoDao implements ContatoDaoIF {

    private Connection con = null;
    private PreparedStatement stmt = null;

    @Override
    public Contato login(Contato c) {
        Contato contato = null;
        try {
            con = this.getConnection();
            String sql = "SELECT * FROM Contato WHERE email = ?;";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getEmail());

            if (stmt == null) {
                System.out.println("FUDEU");
            }

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                contato = new Contato();

                contato.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                contato.setEmail(rs.getString("email"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return contato;
    }

    @Override
    public boolean create(Contato c) {
        int result = 0;
        try {
            con = this.getConnection();

            String sql = "INSERT INTO Contato(nome, email, telefone, dataNascimento) VALUES(?, ?, ?, ?);";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getTelefone());
            stmt.setDate(4, Date.valueOf(c.getDataNascimento()));

            result = stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return result > 0;
    }

    @Override
    public List<Contato> read() {
        List<Contato> contatos = null;

        try {
            con = this.getConnection();
            
            String sql = "SELECT * FROM Contato ORDER BY nome ASC;";
            stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            contatos = new ArrayList<>();
            
            while(rs.next()){
                Contato contato = new Contato();
                
                contato.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                contato.setEmail(rs.getString("email"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                
                contatos.add(contato);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    

        return contatos;
    }

    @Override
    public boolean update(Contato c) {
        int result = 0;
        try {
            con = this.getConnection();

            String sql = "UPDATE Contato SET nome = ?, telefone = ?, dataNascimento = ?"
                    + "     WHERE Email = ?;";

            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setDate(3, Date.valueOf(c.getDataNascimento()));
            
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result > 0;
    }

    @Override
    public boolean delete(Contato c) {
        int result = 0;
        try {
            con = this.getConnection();

            String sql = "DELETE FROM Contato WHERE email = ?;";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, c.getEmail());

            result = stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result > 0;
    }

    @Override
    public List<Contato> searchByNome(String nome) {
        List<Contato> contatos = null;

        try {
            con = this.getConnection();
            
            String sql = "SELECT * FROM Contato WHERE nome ILIKE ?;";
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            contatos = new ArrayList<>();
            
            while(rs.next()){
                Contato contato = new Contato();
                
                contato.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                contato.setEmail(rs.getString("email"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                
                contatos.add(contato);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    

        return contatos;
    }

    @Override
    public List<Contato> orderByLetra(String letra) {
        List<Contato> contatos = null;

        try {
            con = this.getConnection();
            
            String sql = "SELECT * FROM Contato WHERE nome ILIKE ?;";
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, letra);
            
            ResultSet rs = stmt.executeQuery();
            contatos = new ArrayList<>();
            
            while(rs.next()){
                Contato contato = new Contato();
                
                contato.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                contato.setEmail(rs.getString("email"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                
                contatos.add(contato);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    

        return contatos;
    }
    
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        return new ConFactory().getConnection();
    }
}
