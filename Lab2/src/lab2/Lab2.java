/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import services.PlytaService;

/**
 *
 * @author student
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("Lab2PU");
        EntityManager manager = factory.createEntityManager();
        
        PlytaService service = new PlytaService(manager);
        EntityTransaction tranzakcja = manager.getTransaction();
        tranzakcja.begin();
//        String nazwa,autor;
//        int liczbaUtworow;
//        double cena;
//        Scanner odczyt= new Scanner(System.in);
        
//        System.out.println("Nazwa plyty:");
//        nazwa = odczyt.nextLine();
//        System.out.println("Nazwa autora:");
//        autor = odczyt.nextLine();
//        System.out.println("Liczba utworow:");
//        liczbaUtworow = Integer.parseInt(odczyt.nextLine());
//        System.out.println("Cena:");
//        cena = Double.parseDouble(odczyt.nextLine());
//        service.create(nazwa, autor, liczbaUtworow, cena);
        service.create("Plyta nr 1", "Autor 1", 10, 23.12);
        service.create("Plyta nr 2", "Autor 2", 12, 20.12);
        
        tranzakcja.commit();
        
        manager.close();
        factory.close();
        
        Drukarka.drukujWyniki("SELECT * From PLYTA");
    }
    
}
