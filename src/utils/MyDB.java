/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author FOCUS
 */
public class MyDB {
    String url="jdbc:mysql://127.0.0.1:3306/jdbc";
    String login="root";
    String password="";
    
    Connection connection;
    
    static MyDB instance;
    private MyDB() {
        try {
            connection = DriverManager.getConnection(url,login,password);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println("ERREUR:"+ex.getMessage());
        }   
    }
    public static MyDB getInstance(){
        if(instance == null)
            instance = new MyDB();
        
        return instance;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
}
