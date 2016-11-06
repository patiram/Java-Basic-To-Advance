package tcpserver;

import java.net.*;
import java.io.*;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket tcpServer = new ServerSocket(5000);
		Socket acceptClientConnection = null;
		DataInputStream receiveFromClient = null;
		DataOutputStream sendToCleint = null;
		while (true) {
			try {
				acceptClientConnection = tcpServer.accept();
				receiveFromClient = new DataInputStream(acceptClientConnection.getInputStream());
			} catch (IOException io_exception_e) {
				System.out.println(io_exception_e.toString());
			} catch (Exception generic_exception) {
				System.out.println(generic_exception.toString());
			}
		}

	}

}
