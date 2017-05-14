/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;


import contador.Implementacion;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



//import contador.contador;
public class servidor {
    public static void main(String[] args) {

        // Crea e instala el gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Crea una instancia de contador

            //System.setProperty("java.rmi.server.hostname","192.168.1.107");
            Registry reg=LocateRegistry.createRegistry(1099);
            Implementacion implementacion = new Implementacion();
            Naming.rebind("miInterfaz", implementacion);
            //suma = 0;
            System.out.println("Servidor RemoteException | MalformedURLExceptiondor preparado");
        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
