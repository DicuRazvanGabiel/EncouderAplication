package model;
import it.sauronsoftware.jave.EncoderProgressListener;
import it.sauronsoftware.jave.MultimediaInfo;

public class ProgressBar implements EncoderProgressListener {

	private String fileName;
	
	public ProgressBar(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void message(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void progress(int arg0) {
		System.out.println(fileName + arg0/10 + "%");
		
	}

	@Override
	public void sourceInfo(MultimediaInfo arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
