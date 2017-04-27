package lab7;

import java.io.*; 
import java.net.*; 

public class clientSocket {

	public static void main(String[] args) {
		
		String host = "192.168.1.10"; 
		int port = 2500; 
		
		Socket serverSocket = null; 
		BufferedReader kbInput = new BufferedReader(
				new InputStreamReader(System.in)); 
		String kbInputString = ""; 
		PrintWriter toServer; 
		BufferedReader fromServer; 
		String response = ""; 
		
		try {
			// Socket to connect to server 
			serverSocket = new Socket(host, port);
			
			while(true) {
				// reading from keyboard 
				System.out.print("Enter Request: ");
				kbInputString = kbInput.readLine(); 
				
				// sending request to server
				toServer = new PrintWriter(
						serverSocket.getOutputStream(), true); 
				System.out.println("Client sending: " + kbInputString);
				toServer.println(kbInputString);
				System.out.println("Client request sent!\n");
				
				// reading response from server 
				fromServer = new BufferedReader(
						new InputStreamReader(serverSocket.getInputStream()));
				System.out.println("Waiting for server to respond . . ."); 
				response = fromServer.readLine(); 
				System.out.println("Server's Response: " + response + "\n");
			}
		} catch(UnknownHostException e) {
			e.printStackTrace();
			System.err.println("Don't know about host " + host); 
			
		} catch(IOException e) {
			e.printStackTrace();
			System.err.println("Couldn't get I/O for the connection to " + host);
		} // end of catch(IOException)
	} // end of main 

} // end of class 
