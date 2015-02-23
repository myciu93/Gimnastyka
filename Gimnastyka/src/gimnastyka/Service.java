/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnastyka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MarcinP
 */
public class Service {
    public final String url = "jdbc:derby://localhost:1527/Edu";
    public final String dbDriver = "org.apache.derby.jdbc.ClientDriver";
    public final String username = "app";
    public final String password = "app";
    
    static Statement stmt;
    static PreparedStatement pstmt;
    static Connection con;
    
    public Service(){
        //utwurzTabele(sql);
    }
    
    public  void utwurzTabele(String sql){   
        try {
            utwurzZapytanie();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println("Wyjatek utrwalania danych");
            System.exit(0);
        }
    }
    
    public  void utwurzZapytanie() {
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Wyjatek zapytania ");
            System.exit(0);
        }
    }
    
    public  void usunTabele(String sql){
        try {
            utwurzZapytanie();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
        }
    }
    
    public void dodajRekord(Cwiczenie cwiczenie){
        try {
            utwurzZapytanie();
            pstmt=con.prepareStatement("insert into APP.CWICZENIA(Nazwa,Dni,Serie,Powtorzenia) VALUES (?,?,?,?)");
            pstmt.setString(1, cwiczenie.nazwa);
            pstmt.setInt(2, cwiczenie.dni);
            pstmt.setInt(3, cwiczenie.serie);
            pstmt.setInt(4, cwiczenie.powtorzenia);
            pstmt.execute();
            con.close();
            
        } catch (Exception e) {
        }
    }
}
