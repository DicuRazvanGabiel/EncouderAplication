package model;
import it.sauronsoftware.jave.EncoderProgressListener;
import it.sauronsoftware.jave.MultimediaInfo;

public class ProgressBar implements EncoderProgressListener {

	@Override
	public void message(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void progress(int arg0) {
		System.out.println(arg0/10);
		
	}

	@Override
	public void sourceInfo(MultimediaInfo arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
