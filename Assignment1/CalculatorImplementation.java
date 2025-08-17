/**
* 服务端实现：线程安全的共享栈计算器
* 所有客户端共享一个栈
/**operator ∈ {"min","max","lcm","gcd"}
 * for min - push the min value of all the popped values;
 * for max - push the max value of all the popped values
 * for lcm - push the least common multiple of all the popped values;
 * for gcd - push the greatest common divisor of all the popped values.
*/
//按客户端独立栈,在README 中的说明基础上扩展接口并维护 Map<clientId, Deque<Integer>>。
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator{
    private Stack<Integer> stack;
    //construct
    public CalculatorImplementation() throws RemoteException{
        super();
        this.stack = new Stack<>();
        System.out.println("Server Calculator has been bulid share one stack!"); //print some inf in terminal
    }

    //push operation
    public synchronized void pushValue(int val) throws RemoteException{
        stack.push(val);
    }
    //perations always sensible, do not need to consider the other conditions
    public synchronized void pushOperation() throws RemoteException{
        //max way, build the max value 
        int maxValue = Integer.MIN_VALUE;
        //if stack is not empty,it will pop value(current value)----> compare to maxValue--->if bigger--->update
        while (!stack.isEmpty()){
            int curr = stack.pop();
            if (curr > maxValue)
            maxValue = curr;
        }
        //print the max value 
        System.out.println("find the max value in the stack" + maxValue);
        //push the max value
        stack.push(maxValue);
    }
    //pop operation
    public synchronized int pop() throws RemoteException{
        //if the stack is empty, it cannot be pop
        if(stack.isEmpty()) return 0;
        return stack.pop();
    }
    
}
