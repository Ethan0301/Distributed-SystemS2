import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * run the RMI
 * control and maintain the register table
 * In order to find Server(Client)
 */
public class CalculatorServer {
    public static void main(String[] args) throws InterruptedException{
        try {
            System.out.println("RMI Server started!");
            Calculator stub = new CalculatorImplementation();
            Registry registry = LocateRegistry.getRegistry(); //build registrt belong to the Registery class

            registry.rebind("CalculatorRebind", stub);  //search "CalculatorRebind"-->find stub----mapping keys
            System.out.println("Ready!");
            //continue run, keep run 
            while (true){
                Thread.sleep(1000);
            }
        } catch (RemoteException e) {
        
            e.printStackTrace();
        }  
    }
}
