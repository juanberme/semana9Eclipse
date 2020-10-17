package View;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Event.OnMessageListener;
import processing.core.PApplet;

public class PeerB extends PApplet implements OnMessageListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("View.PeerB");
	}
	
	UDPConnection udp;
	
	public void settings() {
		
		size(500,500);
		
	}
	
	public void setup() {
		udp = new UDPConnection();
		udp.start();
		udp.setObserver(this);
	}
	
	public void draw() {
		background(255);
	}

	@Override
	public void mensaje(String msg) {
		// TODO Auto-generated method stub
		
	}

}
