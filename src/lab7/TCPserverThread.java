package lab7;

import java.io.*;
import java.math.BigInteger;
import java.net.*; 

public class TCPserverThread extends Thread {
	
	private Socket clientSocket = null; 
	
	public TCPserverThread(Socket socket) {
		clientSocket = socket; 
	}
	
	public void run() {
		System.out.println("\nClient(s) connected to the server"); 
		
		try { 
            while(true) {
            	// read client's request
                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("Waiting for client's request . . .");
                String request = fromClient.readLine(); 
                System.out.println("Client's Request: " + request);
                
                // process client's request 
                System.out.println("Processing client's request . . .");
                String response = ""; 
                switch(request) {
                case "nextevenfib":
                case "nextEvenFib": // TODO: nextEvenFib
                	response = TCPstreamSocketServer.nextEvenFib(BigInteger.ZERO); 
                	break;
                case "nextlargerrand":
                case "nextLargerRand": // TODO: nextLargerRand
                	response = TCPstreamSocketServer.nextFiveRand(0); 
                	break; 
                case "nextprime":
                case "nextPrime": // TODO: nextPrime
                	response = TCPstreamSocketServer.nextFivePrime(0); 
                	break; 
                default: // unknown request 
                	response = "ERROR: Unknown Request! Cannot Process . . ."; 
                }
                
                // send server's response 
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
                System.out.println("Server sending: " + response);
                toClient.println(response);
                System.out.println("Server's response sent!\n");
                toClient.flush();
            }
        } catch(IOException e) {
        	e.printStackTrace();
        	System.out.println("Exception caught when trying to listen on port " 
        			+ clientSocket.getPort() + " or listening for a connection");
        	System.out.println(e.getMessage());
        }
}
}