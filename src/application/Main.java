package application;
	
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ControllerThreads;
import model.ConvertToMp3Thread;


public class Main extends Application {
	List<ConvertToMp3Thread> listOfThreads = new ArrayList<>();
	String destination;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			ScrollPane scrollPanel = new ScrollPane();
			VBox root = new VBox();
			Button selectFile = new Button("Select File");
			selectFile.setDisable(true);
			Text text = new Text();
			Button selectDestination = new Button("Select Destiation");
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			
			final DirectoryChooser directoryChooser = new DirectoryChooser();
			
			selectDestination.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					File file = directoryChooser.showDialog(primaryStage);
					destination = file.getAbsolutePath();
					selectFile.setDisable(false);
				}
			});
			
			selectFile.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					List<File> list = fileChooser.showOpenMultipleDialog(primaryStage);
	                    if (list != null) {
	                    	ControllerThreads cT = new ControllerThreads(list, destination, text);
	                    }
				}
			});

			root.getChildren().addAll(selectDestination);
			root.getChildren().addAll(selectFile);
			root.getChildren().addAll(scrollPanel);
			root.setAlignment(Pos.CENTER);
		
			Scene scene = new Scene(root,400,400);
			text.wrappingWidthProperty().bind(scene.widthProperty());
			
			scrollPanel.setFitToWidth(true);
			scrollPanel.setContent(text);
			scrollPanel.setMinHeight(100);
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
