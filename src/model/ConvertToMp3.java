package model;
import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;
import javafx.scene.text.Text;

public class ConvertToMp3{

	public static void ConvertToAudio(File video, String destination, Text text) {
		System.out.println("start");
		text.setText(text.getText() + "start" + "\n");
		String fileName = video.getName().substring(0, video.getName().length() - 4);;
		String dest = destination + "\\" + fileName;
		File audio = new File(dest + ".mp3");
		ProgressBar pBar = new ProgressBar(fileName, text);
		
		AudioAttributes audioAtrr = new AudioAttributes();
		audioAtrr.setCodec(new String("libmp3lame"));
		audioAtrr.setBitRate(new Integer(320000));
		audioAtrr.setChannels(new Integer(2));
		audioAtrr.setSamplingRate(new Integer(44100));
		
		EncodingAttributes encAtrr = new EncodingAttributes();
		encAtrr.setFormat("mp4");
		encAtrr.setAudioAttributes(audioAtrr);
		
		Encoder encoder = new Encoder();
		try {
			encoder.encode(video, audio, encAtrr, pBar);
			System.out.println("end");
			text.setText(text.getText() + "end\n");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InputFormatException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
	}
}
