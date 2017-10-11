package model;
import java.awt.List;
import java.io.File;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		String destination = "C:\\Users\\itsix\\Desktop";
		File video = new File("C:\\Users\\itsix\\Desktop\\Tropkillaz - Pump it.mp4");
		ConvertToMp3.ConvertToAudio(video, destination);
	}
}
