package application;
	
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ControllerThreads;
import model.ConvertToMp3Thread;


public class Main extends Application {
	List<ConvertToMp3Thread> listOfThreads = new ArrayList<>();
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			Button selectFile = new Button("Select File");
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			selectFile.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					List<File> list = fileChooser.showOpenMultipleDialog(primaryStage);
	                    if (list != null) {
	                    	ControllerThreads cT = new ControllerThreads(list);
	                    }
				}
			});
			root.getChildren().addAll(selectFile);
			root.setAlignment(Pos.CENTER);
			
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
