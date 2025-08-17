import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * a test client that should connect to the server, and test its operation.
 * 
 */

public class CalculatorClient {
    public static void main (String[] args) throws NotBoundException{
        //get the registry table
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry();
             //get stub
        Calculator stub = (Calculator) registry.lookup("CalculatorRebind");
        stub.pushValue(55);
        stub.pushValue(45);
        //void pushOperation(String operator); testing case
        stub.pushOperation();
        int result = stub.pop(); //expect the result 55
        System.out.println("55 and 45, the max value is:" + result);

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
    
}
