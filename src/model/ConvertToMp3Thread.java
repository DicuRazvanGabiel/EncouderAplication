package model;

import java.io.File;

import javafx.scene.text.Text;

public class ConvertToMp3Thread implements Runnable{
	
	private Thread t;
	private String threadName;
	private File video;
	private String destination;
	private Text text;

	public ConvertToMp3Thread(File video, String destination, String threadName, Text text) {
		this.threadName = threadName;
		this.video = video;
		this.destination = destination;
		this.text = text;
	}

	@Override
	public void run() {
		ConvertToMp3.ConvertToAudio(video, destination, text);
		
	}
	
	public void start() {
		if(t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}
