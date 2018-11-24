/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Criteria.Criteria;
import concrete.AndCriteria;
import concrete.CriteriaFemale;
import concrete.CriteriaMale;
import concrete.CriteriaSingle;
import concrete.OrCriteria;
import entidad.Person;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class DaoArticulo extends Configuracion {
     //Conexion
    private Connection conexionSqlServer;
    private PreparedStatement pdst;

    public DaoArticulo() throws ClassNotFoundException {
         try {
            Class.forName(DriverSqlServer);
            this.conexionSqlServer = DriverManager.getConnection(UrlSqlServer);
            this.conexionSqlServer.setAutoCommit(false);
            System.out.println("Conexion a SQLServer OK");
        } catch (SQLException ex) {
            Logger.getLogger(DaoArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    List<Person> persons= new ArrayList<Person>();
    
      public List buscarArticulos() {
         
        try {
            Statement st = conexionSqlServer.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Person");
            while (rs.next()) {
              
              String nombre=rs.getString(1);
            
              String genero=rs.getString(2);
              String marital=rs.getString(3);
              
                System.out.println(nombre);
              persons.add(new Person( nombre, genero, marital));
            }

        } catch (SQLException ex) {
           
        }
        
        return persons;

    }
    
      Criteria male = new CriteriaMale();
      Criteria female = new CriteriaFemale();
      Criteria single = new CriteriaSingle();
      Criteria singleMale = new AndCriteria(single, male);
      Criteria singleOrFemale = new OrCriteria(single, female);
      
      
      
    public static void printPersons(List<Person> persons){
            for (Person product : persons) {
                System.out.println("Persona : [nombre: "+product.getName()+" Genero "+product.getGender()+" Estado marital"+product.getMaritalStatus());
        }
        }
    
    

}
