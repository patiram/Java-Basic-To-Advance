package udpserver;

/**
 * @author Pati Ram Yadav
 * @Created_At Nov 6, 2016 6:39:56 PM
 * @Path udpserver
 */
import java.io.*;
import java.net.*;

public class UDPServer {

	public static void main(String args[]) throws Exception {
		try {
			DatagramSocket serverSocket = new DatagramSocket(9876);

			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];

			while (true) {

				receiveData = new byte[1024];

				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

				System.out.println("Waiting for datagram packet");

				serverSocket.receive(receivePacket);

				String sentence = new String(receivePacket.getData());

				InetAddress IPAddress = receivePacket.getAddress();

				int port = receivePacket.getPort();

				System.out.println("From: " + IPAddress + ":" + port);
				System.out.println("Message Received: " + sentence);

//				String capitalizedSentence = sentence.toUpperCase();
				String newString = "Hello "+ sentence;
				System.out.print("Sending new packet to server:"+ newString);
				sendData = newString.getBytes();

				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

				serverSocket.send(sendPacket);

			}

		} catch (SocketException ex) {
			System.out.println("UDP Port 9876 is occupied.");
			System.exit(1);
		}

	}
}
