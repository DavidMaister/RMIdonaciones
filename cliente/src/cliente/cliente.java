/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import icontador.Interfaz;
import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.rmi.*;
import java.rmi.registry.Registry;


public class cliente {
    public static void main(String[] args) {
        // Crea e instala el gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Crea el stub para el cliente especificando el nombre del servidor
            Registry mireg = LocateRegistry.getRegistry("127.0.0.1", 1099);

            Interfaz miInterfaz = (Interfaz)mireg.lookup("mmicontador");
            // Pone el contador al valor inicial 0
            System.out.println("Registrando cliente");
            if(miInterfaz.registro("cliente")){
                miInterfaz.donar(200, "cliente");    
            }
            System.out.println("Consulta: "+miInterfaz.consultar("cliente"));
            
        } catch(NotBoundException | RemoteException e) {
        System.err.println("Exception del sistema: " + e);
        }
    System.exit(0);
    }
}