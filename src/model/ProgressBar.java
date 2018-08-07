package model;
import it.sauronsoftware.jave.EncoderProgressListener;
import it.sauronsoftware.jave.MultimediaInfo;
import javafx.scene.text.Text;

public class ProgressBar implements EncoderProgressListener {

	private String fileName;
	private Text text;
	
	public ProgressBar(String fileName, Text text) {
		this.fileName = fileName;
		this.text = text;
	}

	@Override
	public void message(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void progress(int arg0) {
		System.out.println(fileName + arg0/10 + "%");
		text.setText(text.getText() + fileName + arg0/10 + "%\n");
		
	}

	@Override
	public void sourceInfo(MultimediaInfo arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
