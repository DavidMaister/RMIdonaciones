/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import icontador.Interfaz;
import java.rmi.registry.LocateRegistry;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class cliente {
    public static void main(String[] args) {
        // Crea e instala el gestor de seguridad
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // Crea el stub para el cliente especificando el nombre del servidor
            Registry mireg = LocateRegistry.getRegistry("127.0.0.1", 1099);

            Interfaz miInterfaz = (Interfaz)mireg.lookup("miInterfaz");
            // Pone el contador al valor inicial 0
            double cantidad;
            int continua, unCliente=1, registrado=0;
            Scanner scan=new Scanner (System.in);
            String cliente=null;
            while (unCliente==1){
                if (registrado==0){
            System.out.println("REGISTRANDO CLIENTE\n");
            System.out.println("Introduzca su nombre: ");
            cliente=scan.next();
                }
            continua=1;
            if(miInterfaz.registro(cliente)||registrado==1){
                while (continua==1){
                System.out.println("¿Desea donar? Responda si o no: ");
                if ("si".equals(scan.next())){
                    System.out.println("¿Que cantidad desea donar? ");
                    cantidad=scan.nextDouble();
                    miInterfaz.donar(cantidad, cliente); 
                }
                    System.out.println("¿Desea consultar el total donado? Responda si o no: ");
                    if ("si".equals(scan.next())){
                        if(miInterfaz.consultar(cliente)==-1){
                            System.out.println("Debe hacer una donacion para consultar el total donado");
                        }
                        else{
                        System.out.println("Consulta: "+miInterfaz.consultar(cliente));
                    }
                    }
            
                System.out.println("¿Desea continuar realizando operaciones? Responda si o no: ");
                if ("no".equals(scan.next())){
                    continua=0;
                    registrado=0;
                System.out.println("¿Nuevo cliente? Responda si o no: ");
                if ("no".equals(scan.next())){
                    unCliente=0;
                }
                }
                }
            }
            
            else{
             System.out.println("El nombre ya existe"); 
             System.out.println("¿Desea entrar a su cuenta? Responda si o no: ");
             if ("si".equals(scan.next())){
                 registrado=1;
             } 
            }
            }
            
        } catch(NotBoundException | RemoteException e) {
        System.err.println("Exception del sistema: " + e);
        }
    System.exit(0);
    }
}