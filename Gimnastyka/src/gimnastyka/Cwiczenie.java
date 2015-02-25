/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnastyka;

/**
 *
 * @author MarcinP
 */
public class Cwiczenie {
    String nazwaCwiczen;
    int dni;
    int serie;
    int powtorzenia;

    public Cwiczenie() {
    }

    
    public String getNazwa() {
        return nazwaCwiczen;
    }

    public void setNazwa(String nazwa) {
        this.nazwaCwiczen = nazwa;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getPowtorzenia() {
        return powtorzenia;
    }

    public void setPowtorzenia(int powtorzenia) {
        this.powtorzenia = powtorzenia;
    }
    
    
}
