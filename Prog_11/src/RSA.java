import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;  //big integer used for longer numbers 
import java.util.Random;
public class RSA
{
	private BigInteger p,q,N,phi,e,d; // biginteger is a datatype
	private int bitlength=1024;
	private Random r;
	
	public RSA()
	{
		r= new Random();                                   //geneate random number
		p=BigInteger.probablePrime(bitlength,r);          //selecting prime number 1
		q=BigInteger.probablePrime(bitlength,r);		  //selecting prime number 2
		System.out.println("Prime number p is"+p);
		System.out.println("prime number q is"+q);
		N=p.multiply(q);                                   //multiplying p and q
		phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		//phi(n)
		e=BigInteger.probablePrime(bitlength/2,r);      
		// condition of 1<e<n
		while(phi.gcd(e).compareTo(BigInteger.ONE)>0&&e.compareTo(phi)<0)
		{
			e.add(BigInteger.ONE);   //increasing one by one 
		}
		System.out.println("Public key is"+e);
		d=e.modInverse(phi);                       //mod inverse is inverting to left side 
		System.out.println("Private key is"+d);
	}
	
	public RSA(BigInteger e,BigInteger d,BigInteger N)
	{
		this.e=e;
		this.d=d;
		this.N=N;
	}
	
	public static void main(String[] args)throws IOException
	{
		RSA rsa=new RSA(); 
		
		//DataInputStream in=new DataInputStream(System.in); //construct the read the input from the user
		BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));
		
		String testString;
		
		System.out.println("Enter the plain text:");
		
		testString=buf.readLine();
		
		System.out.println("Encrypting string:"+testString);
		
		System.out.println("string in bytes:"+bytesTostrings((testString.getBytes())));  //converting the string into bytes
		
		byte[] encrypted=rsa.encrypt(testString.getBytes());
		
		
		byte[] decrypted=rsa.decrypt(encrypted);
		
		System.out.println("Dcrypting Bytes:"+bytesTostrings(decrypted));
		
		
		System.out.println("Dcrypted string:"+new String(decrypted));
	}
	
	private static String bytesTostrings(byte[] encrypted)
	{
		String test=" ";
		for(byte b:encrypted)
		{
			test+=Byte.toString(b);
		}
		
		return test;
	}
	
	public byte[] encrypt(byte[]message)
	{
		return(new BigInteger(message)).modPow(e,N).toByteArray();
	}
	
	public byte[] decrypt(byte[]message)
	{
		return(new BigInteger(message)).modPow(d,N).toByteArray();
	}
}
