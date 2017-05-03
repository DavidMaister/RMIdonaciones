/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador;

/**
 *
 * @author david
 */
public class Entidad {
    
    
    private String nombre;
    private boolean donado;
    
    public Entidad(){
        nombre = "";
        donado = false;
    }
    
    public void setNombre(String alias){
        nombre = alias;
    }
    
    
    public String getNombre(){
        return nombre;
    }
    
    public void setDonado(){
        donado = true;
    }
    public boolean getDonado(){
        return donado;
    }
    
    
   
}
