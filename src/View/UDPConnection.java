package View;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import Event.OnMessageListener;
import Model.Generic;

public class UDPConnection extends Thread{
	
	private DatagramSocket socket;
	private OnMessageListener observer;
	
	public void setObserver(OnMessageListener observer) {
		this.observer = observer;
	}
	
	
	public void run() {
		try {
			socket = new DatagramSocket(5000);
			
			while(true) {
				byte[] buffer = new byte[100];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				System.out.println("Waiting datagram");
				socket.receive(packet);
				String msg = new String(packet.getData()).trim();
				System.out.println(msg);
				
				Gson gson = new Gson();
				Generic generico = gson.fromJson(msg, Generic.class);
				System.out.println("recibido"+generico);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String msg) {
		new Thread(
				()->{
					try {
						InetAddress ip = InetAddress.getByName("10.0.2.2");
						DatagramPacket packette = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ip, 6000);
						socket.send(packette);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				).start();
	}

}
