import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	
	public static void main(String[] args)throws Exception 
	{ 
		BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in)); 

		DatagramSocket clientSocket=new DatagramSocket(); 

		InetAddress IPAddress=InetAddress.getByName("localhost"); 

		byte[] sendData=new byte[1024];      // use sent in array of bytes
		byte[] receiveData=new byte[1024]; 
		
		System.out.println("Enter the sting to be converted in to Upper case"); 
		String sentence=inFromUser.readLine(); 

		sendData=sentence.getBytes(); 

		DatagramPacket sendPacket=new 
				
		DatagramPacket(sendData,sendData.length,IPAddress,4000); //Parameters (wt to send, length of data, IP address ,port no)


		clientSocket.send(sendPacket); 

		DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);  //(rcv_data, rcv_data.length)

		clientSocket.receive(receivePacket); 

		String modifiedSentence=new String(receivePacket.getData()); 

		System.out.println("FROM SERVER:"+modifiedSentence); 

		clientSocket.close(); 

	}
}
