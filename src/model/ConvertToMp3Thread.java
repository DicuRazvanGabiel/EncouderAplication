package model;

import java.io.File;

public class ConvertToMp3Thread implements Runnable{
	
	private Thread t;
	private String threadName;
	private File video;
	private String destination;

	public ConvertToMp3Thread(File video, String destination, String threadName) {
		this.threadName = threadName;
		this.video = video;
		this.destination = destination;
	}

	@Override
	public void run() {
		System.out.println("converting, start");
		ConvertToMp3.ConvertToAudio(video, destination);
		
	}
	
	public void start() {
		if(t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}
