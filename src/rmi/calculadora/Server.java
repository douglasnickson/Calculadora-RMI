package rmi.calculadora;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Calculadora{
	
	public Server () {}

	public static void main(String[] args) {
		
		try {
			Server obj = new Server();
			Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(obj,0);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("calculadora", stub);
			
			System.err.println("Server ON");
			
		}catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
		

	}

	@Override
	public long Add(long x, long y) throws RemoteException {
		return x + y;
	}

	@Override
	public long Sub(long x, long y) throws RemoteException {
		return x - y;
	}

	@Override
	public long Mul(long x, long y) throws RemoteException {
		return x * y;
	}

	@Override
	public long Div(long x, long y) throws RemoteException {
		return x / y;
	}

}
