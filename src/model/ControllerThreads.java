package model;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javafx.scene.text.Text;

public class ControllerThreads {

	private String destination;
	private Text text;
	
	public ControllerThreads(List<File> list, String destination, Text text) {
		this.destination = destination;
		this.text = text;
		convertVideo(list);
	}

	private void convertVideo(List<File> list) {
		int cores = Runtime.getRuntime().availableProcessors();
		ThreadPoolExecutor executor =  (ThreadPoolExecutor) Executors.newFixedThreadPool(cores);

		  for (File file : list) {
          	ConvertToMp3Thread t = new ConvertToMp3Thread(file, destination, "", text);
          	executor.execute(t);
          }
		  executor.shutdown();
	}
}
