/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entities.annonce;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServiceAnnonce;

/**
 *
 * @author FOCUS
 */
public class Main {

    static Connection cnx;

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws FileNotFoundException {
        
            annonce a1 = new annonce(0, "titre", "type", "gouvernorat", "ville", "description", 0);
            annonce a2 = new annonce(1000, "titre", "type", "gouvernorat", "ville", "description", 29280596);
             annonce a4 = new annonce(14,68888, "aaaa", "bbb", "cccc", "ddd", "eee", 10000);
            
            //  annonce a3 = new annonce(777);
            ServiceAnnonce sa = new ServiceAnnonce();
         
            
        
            try {
                   sa.updateAnnonce(a4);
          //sa.updatePrix(777, 7);
        //  sa.updateAnnonce(a4, 50);
  //sa.addAnnonce(a1);
  //a2.setPrix(500);
 // sa.updateAnnonce(a2,5);
              //  System.out.println( sa.getAnnonce(13).toString());
          
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }

}
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
             

        
            
        
       
    


