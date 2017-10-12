package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ControllerThreads {

	private List<ConvertToMp3Thread> listOfThreads = new ArrayList<>();

	public ControllerThreads(List<File> list) {
		convertVideo(list);
	}

	private void convertVideo(List<File> list) {
		  for (File file : list) {
          	String destination = "C:\\Users\\itsix\\Desktop";
          	if(listOfThreads.size() < 2) {
          		ConvertToMp3Thread t = new ConvertToMp3Thread(file, destination, "");
          		listOfThreads.add(t);
          		t.start();
          	}
          }
	}

}
