/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnastyka;

import GUI.Okno;

/**
 *
 * @author MarcinP
 */
public class Gimnastyka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Okno okno = new Okno();
        
        String sql="CREATE  TABLE  CWICZENIA(" + 
                "NAZWA varchar(32), " +
                "DNI int, " +
                "SERIE int, " +
                "POWTORZENIA int)";
        
        Service service = new Service();
        service.usunTabele("drop table APP.CWICZENIA");
        service.utwurzTabele (sql);
        okno.setVisible(true);
        
        
        
        
    }
    
}
