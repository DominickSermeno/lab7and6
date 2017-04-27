package lab7;

import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.util.Random;

//testing

public class TCPstreamSocketServer 
{ 
	public static void main(String[] args) 
	{
        int port = 2500; 
        
        ServerSocket serverSocket = null; 
        
        try { 
			// creating socket on the following port 
	        serverSocket = new ServerSocket(port);
	        System.out.println("Server accpeting connection on port: " + port);
	        System.out.println("Waiting for client(s) to connect . . .");
	        
	        // start server thread 
	        while(true) {
	        	TCPserverThread clientThread = new TCPserverThread(serverSocket.accept()); 
		        clientThread.start();
	        }
        } catch(IOException e) {
        	e.printStackTrace();
        	System.out.println("Exception caught when trying to listen on port " 
        			+ port + " or listening for a connection");
        	System.out.println(e.getMessage());
        }
} 
	
	//Dominick
	public static BigInteger fibonacci(BigInteger n)
	{
		BigInteger result = BigInteger.ZERO; 
		BigInteger n1 = BigInteger.ZERO;
		BigInteger n2 = BigInteger.ZERO;
		if(n.equals(BigInteger.ZERO))
		{
			result = BigInteger.ZERO;
		}
		if(n.equals(BigInteger.ONE))
		{
			result = BigInteger.ONE;
		}
		else
		{
			n1 = BigInteger.ONE;
			n2 = BigInteger.ZERO;
			for (BigInteger i = BigInteger.ONE; i.compareTo(n) < 0 ; i = i.add(BigInteger.ONE))
			{
				result = n1.add(n2);
				n2 = n1;
				n1 = result;
			}	
		}
		return result;
	}

	  public static String nextEvenFib(BigInteger n)
	  {
		  String msg = "";
		  BigInteger temp = BigInteger.ONE;
		  BigInteger evens[]= new BigInteger[5];
		  int i = 0;
		  for(int ii = 0; ii < 5; ii++)
		  {
			  while(temp.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO)!=0)
			  {
				  temp = fibonacci(n.add(BigInteger.valueOf(i)));
				  i++;
			  }
			  evens[ii] = temp;
			  temp = temp.add(BigInteger.ONE);
			  i++;
		  }  
		  msg = "The Next Five Even Fibonacci Values are: ";
		  for (int iii = 0; iii < 5; iii++)	
		  {
			  msg = msg + "   " + evens[iii];
		  }
		  return msg;
	  }
	//Steph
		public static int nextPrime(int prime)
		{
			boolean isPrime = false;

		    int start = 2;

		    while (!isPrime)
		    {
		    	prime += 1;
		        int m = (int) Math.ceil(Math.sqrt(prime));

		        isPrime = true;
		        for (int i = start; i <= m; i++)
		        {
		            if (prime % i == 0) 
		            {
		                isPrime = false;
		                break;
		            } 
		        }
		    }
		    return prime;	
	}
	
	public static String nextFivePrime(int n)
	{
		String msg = "";
		int temp = 0;
		msg = "The Next Five Prime Numbers are: ";
		int primes[] = new int[5];
		
		
		primes[0] = nextPrime(n);
		temp = nextPrime(n);
		for(int i = 1; i < 5; i++)
		{
			primes[i] = nextPrime(temp);
			temp = nextPrime(temp);
			
		}
		  for (int ii = 0; ii < 5; ii++)	
		  {
			  msg = msg + "   " + primes[ii];
		  }
		  return msg;
	}
	
	
	
	//Lori
	public static int nextLargerRand(int s) 
	{
		int big = 0;
		int small = s;
		Random gen = new Random();
		do {
			big = gen.nextInt() + small;
			if (big < 0) {
				big += Integer.MAX_VALUE;
			}
		} while (small > big);
		return big;
	}
	
	public static String nextFiveRand(int n)
	{
		String msg = "";
		int temp = 0;
		int bigger = 0;
		msg = "The Next Five Random Numbers are: ";
		int randos[] = new int[5];
	
		randos[0] = nextLargerRand(temp);
		bigger = randos[0];
		for(int i = 1; i < 5; i++)
		{
			while (temp < bigger)
			{
				temp = nextLargerRand(temp);
			}
			randos[i] = temp;
			bigger = temp +1 ;
		}
		  for (int ii = 0; ii < 5; ii++)	
		  {
			  msg = msg + "   " + randos[ii];
		  }
		  return msg;
	}
	
} // end of server program 


	


