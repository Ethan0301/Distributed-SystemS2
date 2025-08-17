import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * the interface that defines the remote operations implemented by your remote service.
 * pushValue(int val): push a integer on stack
 * pushOperation(String operator): accrding to operator---> push results in stack
 * for min - push the min value of all the popped values;
 * for max - push the max value of all the popped values
 * for lcm - push the 
 * for gcd - push the greatest common divisor of all the popped values.
 * pop()----pop and return the top 
 * isEmpty()----check if is empty
*/
public interface Calculator extends Remote{
    void pushValue(int val) throws RemoteException;
    void pushOperation() throws RemoteException;
    int pop() throws RemoteException;
}


