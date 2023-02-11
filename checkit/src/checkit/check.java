package checkit;

import java.util.Scanner;

public class check {

	 public static void main(String args[])
	 {
		 
		 Scanner sc = new Scanner(System.in);

		    //Input Data Stream
		    System.out.print("Enter message bits: "); // user's string to encrypt
		    String message = sc.nextLine();
		    
		    System.out.print("Enter generator: ");   // generator is pre-defined value
		    String generator = sc.nextLine();
		      
		    int data[] = new int[message.length() + generator.length() - 1]; //bits = DATA + (N-1)ZEROS
		    int divisor[] = new int[generator.length()]; // is same size of generator
		    
		    for(int i=0;i<message.length();i++)
		    {
		    data[i] = Integer.parseInt(message.charAt(i)+"");
		    }
		    
		    for(int i=0;i<generator.length();i++)
		    {
		    divisor[i] = Integer.parseInt(generator.charAt(i)+"");
		    }
		 for(int i=0;i<message.length();i++)
		    {
		    	if(data[i]==1)             // if 1 take action  // if 0 don't take action
		    	{
		        	for(int j=0;j<divisor.length;j++) // do operation till divisor length
		        	{
		            data[i+j] ^= divisor[j];    // '^' = BITWISE XOR  // storing data into data it self
		        	} 								// a=a^b
		    	}
			}
		 
		 
		 System.out.print("The checksum code is: "); // it will only print the data it self eg:000000000001110
		    for(int i=0;i<message.length();i++)
		    {
		    	data[i] = Integer.parseInt(message.charAt(i)+"");  // the original data will be copied
		    }
		    
		    for(int i=0;i<data.length;i++) 
		    {
		    System.out.print(data[i]);       // just printing the data after appending the reminder
		    }
		    System.out.println();
	 }
	 
	 
}
	
	

