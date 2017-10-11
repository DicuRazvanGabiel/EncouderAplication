package application;
	
import java.io.File;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ConvertToMp3;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Button selectFile = new Button("Select File");
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			selectFile.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					List<File> list = fileChooser.showOpenMultipleDialog(primaryStage);
	                    if (list != null) {
	                        for (File file : list) {
	                        	String destination = "C:\\Users\\itsix\\Desktop";
	                    		//File video = new File("C:\\Users\\itsix\\Desktop\\Tropkillaz - Pump it.mp4");
	                    		ConvertToMp3.ConvertToAudio(file, destination);
	                        }
	                    }
				}
			});
			root.setCenter(selectFile);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
