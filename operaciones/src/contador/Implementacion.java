
package contador;


import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;

import icontador.Interfaz;
import java.util.ArrayList;


public class Implementacion extends UnicastRemoteObject implements Interfaz {
    private double suma;
    private ArrayList<Entidad> listaRegistrados;
    
    
    public Implementacion() throws RemoteException{
        listaRegistrados = new ArrayList<>();

    }
    public boolean registro(String nombre) throws RemoteException {
        
        
        if(repetido(nombre) == false){
            Entidad nuevoCliente = new Entidad();
            nuevoCliente.setNombre(nombre);
            listaRegistrados.add(nuevoCliente);
            return true;
        }
        else
            return false;
        
        
    }
    
    private boolean repetido(String nombre){
        boolean repetido = false;
        
        for(int i = 0; i< listaRegistrados.size(); i++){
            if(listaRegistrados.get(i).getNombre().compareTo(nombre) == 0){
                repetido = true;
            }
        }
        return repetido;
    }
    
    public void donar(double cantidad, String nombre){
        
        if(repetido(nombre) == true){
            suma = suma + cantidad;
            listaRegistrados.get(getPosicion(nombre)).setDonado();
        }
    }
    
    
    public double consultar(String nombre){
   
        if(repetido(nombre) == true){
            return suma;
        }
        else
            return -1;
    }
    
    private int getPosicion(String nombre){
        
        int posicion = -1;
        
        for(int i = 0; i< listaRegistrados.size(); i++){
            if(listaRegistrados.get(i).getNombre().compareTo(nombre) == 0){
                posicion = i;
            }
        }
        return posicion;
    
    }
    
    
    
    
    
    
    
    
    
    
 

    
}