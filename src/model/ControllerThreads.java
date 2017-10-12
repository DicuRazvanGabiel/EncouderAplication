package model;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ControllerThreads {

	public ControllerThreads(List<File> list) {
		convertVideo(list);
	}

	private void convertVideo(List<File> list) {
		int cores = Runtime.getRuntime().availableProcessors();
		ThreadPoolExecutor executor =  (ThreadPoolExecutor) Executors.newFixedThreadPool(cores);
      	String destination = "C:\\Users\\itsix\\Desktop";
		  for (File file : list) {
          	ConvertToMp3Thread t = new ConvertToMp3Thread(file, destination, "");
          	executor.execute(t);
          }
		  executor.shutdown();
	}
}
