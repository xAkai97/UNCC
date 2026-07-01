import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Derek Wang
 */
 
 /*
 * Client to generate a ping requests over UDP.
 */
 
public class PingClient{
	
	private static final int MAX_TIMEOUT = 1000;	// milliseconds

	public static void main(String[] args) throws Exception
	{
		// Get command line arguments.
		if (args.length != 2) {
			System.out.println("Required arguments: Server port");
			return;
		}
		// Port number to access
		int port = Integer.parseInt(args[1]);
		// Server to Ping (has to have the PingServer running)
		InetAddress server;
		server = InetAddress.getByName(args[0]);

		// Create a datagram socket for sending and receiving UDP packets
		// through the port specified on the command line.
		DatagramSocket socket = new DatagramSocket(port);

		int sequenceNumber = 0;
		
		// Processing loop.
		while (sequenceNumber < 10) {
			
			Date now = new Date();
			long msSend = now.getTime();
			
			String str = "PING " + sequenceNumber + " " + msSend + " \n";
			byte[] buf = new byte[1024];
			buf = str.getBytes();
			
			// Create a datagram packet to send as an UDP packet.
			DatagramPacket ping = new DatagramPacket(buf, buf.length, server, port);

			// Send the Ping datagram to the specified server
			socket.send(ping);
			
			// Try to receive the packet - but it can fail (timeout)
			try {
				// Set up the timeout 1000 ms = 1 sec
				socket.setSoTimeout(MAX_TIMEOUT);
				
				// Set up an UPD packet for recieving
				DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
				
				// Try to receive the response from the ping
				socket.receive(response);
				
				now = new Date();
				long msReceived = now.getTime();
				
				// Print the packet and the delay
				printData(response, msReceived - msSend);
				
			} catch (IOException e) {
				
				// Print which packet has timed out
				System.out.println("Timeout for packet " + sequenceNumber);
			}
			// next packet
			sequenceNumber ++;
		}
	}


   /* 
    * Print ping data to the standard output stream.
    */
   private static void printData(DatagramPacket request, long delayTime) throws Exception
   {
      // Obtain references to the packet's array of bytes.
      byte[] buf = request.getData();

      // Wrap the bytes in a byte array input stream
      ByteArrayInputStream bais = new ByteArrayInputStream(buf);

      // Wrap the byte array output stream in an input stream reader,
      InputStreamReader isr = new InputStreamReader(bais);

      // Wrap the input stream reader in a bufferred reader,
      BufferedReader br = new BufferedReader(isr);

      // The message data is contained in a single line, so read this line.
      String line = br.readLine();

      // Print host address and data received from it.
      System.out.println(
         "Received from " + 
         request.getAddress().getHostAddress() + 
         ": " +
         new String(line) + " Delay: " + delayTime );
   }
}