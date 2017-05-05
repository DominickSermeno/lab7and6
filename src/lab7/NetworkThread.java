package lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkThread extends Thread {
	
	private String request = ""; 
	
	public NetworkThread(String r) {
		request = r; 
	} // end of constructor
	
	public void run() {
		String host = "192.168.1.10"; 
		int port = 2500; 
		
		Socket serverSocket = null; 
		PrintWriter toServer; 
		BufferedReader fromServer; 
		String response = ""; 
		
		try {
			// Socket to connect to server 
			serverSocket = new Socket(host, port);
			
			// sending request to server
			toServer = new PrintWriter(
					serverSocket.getOutputStream(), true); 
			System.out.println("Client sending: " + request);
			toServer.println(request);
			System.out.println("Client request sent!\n");
			
			// reading response from server 
			fromServer = new BufferedReader(
					new InputStreamReader(serverSocket.getInputStream()));
			System.out.println("Waiting for server to respond . . ."); 
			response = fromServer.readLine(); 
			System.out.println("Server's Response: " + response + "\n");
			
			// TODO give response from server to return queue 
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
			System.err.println("Don't know about host " + host); 
			
		} catch(IOException e) {
			e.printStackTrace();
			System.err.println("Couldn't get I/O for the connection to " + host);
		} // end of catch(IOException)
	} // end of run method 

} // end of class 
