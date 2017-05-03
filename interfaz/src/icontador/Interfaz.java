// Interfaz.java
package icontador;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfaz extends Remote {
    
   
    public boolean registro(String nombre) throws RemoteException;
    public void donar(double cantidad, String nombre) throws RemoteException;
    public double consultar(String nombre) throws RemoteException;

}
