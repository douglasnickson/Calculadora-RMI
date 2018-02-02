package rmi.calculadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote{
	
	public long Add (long x, long y) throws RemoteException;
	public long Sub (long x, long y) throws RemoteException;
	public long Mul (long x, long y) throws RemoteException;
	public long Div (long x, long y) throws RemoteException;

}
