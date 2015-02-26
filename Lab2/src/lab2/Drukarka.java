/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author student
 */
public class Drukarka {
    public static String url = "jdbc:derby://localhost:1527/Edu";
    public static String dbdriver = "org.apache.derby.jdbc.ClientDriver";
    public static String username= "app";
    public static String password = "app";
    
    static Statement stmt;
    static Connection con;

    public Drukarka() {
    }
    public static void utwurzZapytanie() {
        try {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Wyjatek zapytania ");
            System.exit(0);
        }
    }
    public static void drukujWyniki(String sql){
        String[] starray = sql.split(" ");
//        System.out.println(starray[0]);
//        System.out.println(starray[1]);
//        System.out.println(starray[2]);
//        System.out.println(starray[3]);
        System.out.println("\n**** Tabela: "+ starray[starray.length-1]
            + " ****");
        try {
            utwurzZapytanie();
            ResultSet resultSet = stmt.executeQuery(sql);
            wyrysujDane(resultSet);
            con.close();
        } catch (Exception e) {
        }
    }
    public static void wyrysujDane(ResultSet resultSet) throws Exception {
        ResultSetMetaData metadata = resultSet.getMetaData();
        int numcols = metadata.getColumnCount();
       // metadata.
        String[] labels = new String[numcols];
        int[] colwidths = new int[numcols];
        int[] colpos = new int[numcols];
        int linewidth;
        linewidth = 1;
        for (int i = 0; i < numcols; i++) {
            colpos[i] = linewidth;
            labels[i] = metadata.getColumnLabel(i + 1); // get its label
            int size = metadata.getColumnDisplaySize(i + 1);
            if (size > 30 || size == -1) {
                size = 30;
            }
            int labelsize = labels[i].length();
            if (labelsize > size) {
                size = labelsize;
            }
            colwidths[i] = size + 1; // save the column the size
            linewidth += colwidths[i] + 2; // increment total size
        }
        StringBuffer divider = new StringBuffer(linewidth);
        StringBuffer blankline = new StringBuffer(linewidth);
        for (int i = 0; i < linewidth; i++) {
            divider.insert(i, '-');
            blankline.insert(i, " ");
        }
        for (int i = 0; i < numcols; i++) {
            divider.setCharAt(colpos[i] - 1, '+');
        }
        divider.setCharAt(linewidth - 1, '+');
        System.out.println(divider);
        StringBuffer line = new StringBuffer(blankline.toString());
        line.setCharAt(0, '|');
        for (int i = 0; i < numcols; i++) {
            int pos = colpos[i] + 1 + (colwidths[i] - labels[i].length()) / 2;
            overwrite(line, pos, labels[i]);
            overwrite(line, colpos[i] + colwidths[i], " |");
        }
        System.out.println(line);
        System.out.println(divider);
        while (resultSet.next()) {
            line = new StringBuffer(blankline.toString());
            line.setCharAt(0, '|');
            for (int i = 0; i < numcols; i++) {
                Object value = resultSet.getObject(i + 1);
                if (value != null) {
                    overwrite(line, colpos[i] + 1, value.toString().trim());
                    overwrite(line, colpos[i] + colwidths[i], " |");
                }
            }
            System.out.println(line);
        }
        System.out.println(divider);
    }
    static void overwrite(StringBuffer b, int pos, String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            b.setCharAt(pos + i, s.charAt(i));
        }
    }
}
