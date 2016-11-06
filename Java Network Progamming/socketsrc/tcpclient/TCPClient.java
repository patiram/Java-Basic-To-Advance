package tcpclient;
import java.net.*;
import java.io.*;
public class TCPClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket myClient = null;
		DataInputStream getData = null;
		PrintStream sendData = null;
		try{
			myClient = new Socket("127.0.0.1", 5000);
			System.out.println("Connecting at host:"+myClient.getRemoteSocketAddress());
		}catch (UnknownHostException e) {
            System.err.println("Don't know about host: hostname");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: hostname");
        }
		try{
			sendData = new PrintStream(myClient.getOutputStream());
			System.out.println(".............Sending name: Patiram...............");
			sendData.println("Patiram");
			getData = new DataInputStream(myClient.getInputStream());
			System.out.println("............Receiving data from server:..........");
			System.out.println(getData.readLine());
			System.out.println("......Sending signal to close the connection....");
			sendData.println("close");
		}catch(IOException e){
			System.out.println("Reading Writing to Server Error"+e);
		}
		try{
			sendData.close();
			getData.close();
			myClient.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}

}
