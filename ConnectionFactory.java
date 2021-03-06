/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lluca
 */
public class ConnectionFactory {
    
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/mydb";
    private final String USER = "root";
    private final String PASS = "";
  
   
    
     public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            
                 return DriverManager.getConnection(URL, USER, PASS);
                         
                 
                 
                 
                    } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
     }
     
     public static void closeConnection(Connection con){
       
           try {
               if(con!=null){
               con.close();
               }
           } catch (SQLException ex) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
           }
       } 
          public static void closeConnection(Connection con,PreparedStatement stmt){
       
           try {
               if(stmt!=null){
               stmt.close();
               }
           } catch (SQLException ex) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
           }
       } 
     
      public static void closeConnection(Connection con, PreparedStatement stmt,ResultSet rs){
       closeConnection(con);
           try {
               
               if(rs != null){
                   rs.close();
                           
                           
               }
           } catch (SQLException ex) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
           }
       }  
      
   
      

     }
     
     
