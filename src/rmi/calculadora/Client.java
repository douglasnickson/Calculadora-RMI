package rmi.calculadora;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	
	private Client () {}

	public static void main(String[] args) {
		String host = (args.length < 1) ? null:args[0];
		
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			Calculadora stub = (Calculadora) registry.lookup("calculadora");
			
			long add = stub.Add(10, 5);
			long sub = stub.Sub(10, 5);
			long mul = stub.Mul(10, 5);
			long div = stub.Div(10, 5);

			System.out.println("A soma e: " + add);
			System.out.println("A Subtracao e: " + sub);
			System.out.println("A Multiplicacao e: " + mul);
			System.out.println("A Divisao e: " + div);

			
		}catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();		
        }
	}
}

