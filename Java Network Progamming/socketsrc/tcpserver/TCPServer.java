package tcpserver;

import java.net.*;
import java.io.*;

/**
 * @author Pati Ram Yadav
 * @Created_At Nov 6, 2016 5:52:20 PM
 */   

public class TCPServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket tcpServer = null;
		Socket clientConnection = null;
		DataInputStream getData = null;
		PrintStream sendData = null;
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			tcpServer = new ServerSocket(5000, 50, address);
			System.out.println("Created Server at"+tcpServer.getLocalSocketAddress());
		} catch (IOException io_exception_e) {
			System.out.println(io_exception_e.toString());
		}
		try{
			clientConnection = tcpServer.accept();
			getData = new DataInputStream(clientConnection.getInputStream());
			sendData = new PrintStream(clientConnection.getOutputStream());
			while(true){
//				String prepareData = "Hello "+ getData.readUTF();
				String receivedData = getData.readLine();
				System.out.println("Server received name: "+receivedData);
				StringBuffer myString = new StringBuffer("Hello ");
				myString.append(receivedData);
				System.out.println("Server sending data: "+myString);
				sendData.println(myString);
				if(getData.readLine().equals("close")){
					break;
				}
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}
		 try {
		       sendData.close();
		       getData.close();
		       clientConnection.close();
		       tcpServer.close();
		       System.out.println("Connection Successfully closed");
		    } 
		    catch (IOException e) {
		       System.out.println(e);
		    }
	}

}
