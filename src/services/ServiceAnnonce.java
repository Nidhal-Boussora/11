/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.annonce;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.MyDB;

/**
 *
 * @author FOCUS
 */
public class ServiceAnnonce {
    private Connection cnx;

    public ServiceAnnonce() {
        cnx=MyDB.getInstance().getConnection();
    
    }
    public void addAnnonce(annonce a) throws SQLException {
        String request = "INSERT INTO `annonce` (`prix`,`titre`,`categorie`,`gouvernorat`,`ville`,`description`,`numtel` )"
                + "VALUES ( '" 
                +a.getPrix() + "', '"
                +a.getTitre()+"', '"
                +a.getCategorie()+"', '"
                +a.getGouvernorat()+"', '"
                +a.getVille()+"', '"
                +a.getDescription()+"', '"
                +a.getNumtel()+ 
                "')";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }
    
    public ArrayList<annonce> getAnnonce() throws SQLException, FileNotFoundException{
        ArrayList<annonce> results = new ArrayList<>();
        String query = "SELECT * FROM `annonce`";
        Statement stm = cnx.createStatement();
        ResultSet rst= stm.executeQuery(query);
        while (rst.next()){
            
            annonce a = new annonce();
            
            a.setId(rst.getInt(1));
            a.setPrix(rst.getFloat(2));
            a.setTitre(rst.getString(3));
            a.setCategorie(rst.getString(4));
            a.setGouvernorat(rst.getString(5));
            a.setVille(rst.getString(6));
            a.setDescription(rst.getString(7));
            a.setNumtel(rst.getInt(8));
            results.add(a);
        }
        
        return results; 
    }
    
    public void updateAnnonce(annonce a) throws SQLException, FileNotFoundException{
        String request= "UPDATE `annonce` SET `prix`=?,`titre`=?,`categorie`=?,`gouvernorat`=?,`ville`=?,`description`=?,`numtel`=?"+" where id=?";
        PreparedStatement pst = cnx.prepareStatement(request);
        pst.setFloat(1, a.getPrix());
        pst.setString(2, a.getTitre());
        pst.setString(3, a.getCategorie());
        pst.setString(4, a.getGouvernorat());
        pst.setString(5, a.getVille());
        pst.setString(6, a.getDescription());
        pst.setInt(7, a.getNumtel());
        pst.setInt(8, a.getId());
       

        System.out.println(pst);
        
        pst.executeUpdate();
    }
    
    public void deleteAnnonce(int id) throws SQLException {
        String request ="DELETE FROM `annonce` WHERE id="+id;
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    
}
