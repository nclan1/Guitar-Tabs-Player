package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
			Parent root = loader.load();
			//VBox root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,780, 680);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Guitar Tab App");
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	MediaPlayer mediaplayer;
//	public void music() {
//	String s = "IsntSheLovely";
//	Media h = new Media(Paths.get(s).toUri().toString());
//	mediaplayer = new MediaPlayer(h);
//	mediaplayer.play();
//	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


















//package application;
//	
//
//import java.io.IOException;
//
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.ListView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//
//public class Main extends Application { 
//   @Override 
//   public void start(Stage stage) throws IOException { 
//	   
////	   Parent root = FXMLLoader.load(getClass().getResource("GUI (1).fxml"));
//	   
////	   Media player = new Media(getClass().getResource().toExternalForm()); 
////	   MediaPlayer mediaPlayer = new MediaPlayer(player);
////	   mediaPlayer.play();
//	   
//      //Drawing rectangles (for planning layout)
//      Rectangle rect1 = new Rectangle();    
//      Rectangle rect2 = new Rectangle();
//      Rectangle rect3 = new Rectangle();
//      
//      //Setting the properties of the rectangles 
////      rect1.setX(10.0f);
////      rect1.setY(10.0f);
//      rect1.setWidth(350.0f);
//      rect1.setHeight(400.0f);
//      
//      
////      rect2.setX(500.0f);
////      rect2.setY(10.0f);
//      rect2.setWidth(350.0f);
//      rect2.setHeight(200.0f);
//      
//      
//      rect3.setWidth(350.0f);
//      rect3.setHeight(650.0f);
//     
//      //creating song list (placeholder song names for now)
//      ObservableList<String> songs = FXCollections.observableArrayList("song1", "song2", "song3");
//      ListView<String> songDirectory = new ListView<String>(songs);
//      songDirectory.setMaxSize(200, 350);
//       
//      
//      //Creating an Anchor Pane  
//      AnchorPane anchorPane = new AnchorPane();  
//       
//      //Setting the anchor to the rectangles      
//      AnchorPane.setTopAnchor(rect1, 25.0); 
//      AnchorPane.setLeftAnchor(rect1, 25.0); 
//      AnchorPane.setRightAnchor(rect1, 500.0); 
//      AnchorPane.setBottomAnchor(rect1, 200.0); 
//      
//      AnchorPane.setTopAnchor(rect2, 475.0); 
//      AnchorPane.setLeftAnchor(rect2, 25.0); 
//      AnchorPane.setRightAnchor(rect2, 500.0); 
//      AnchorPane.setBottomAnchor(rect2, 25.0); 
//      
//      AnchorPane.setTopAnchor(rect3, 25.0); 
//      AnchorPane.setLeftAnchor(rect3, 475.0); 
//      AnchorPane.setRightAnchor(rect3, 25.0); 
//      AnchorPane.setBottomAnchor(rect3, 25.0); 
//      
//      //anchoring song list
//      AnchorPane.setTopAnchor(songDirectory, 25.0); 
//      AnchorPane.setLeftAnchor(songDirectory, 25.0); 
//      AnchorPane.setRightAnchor(songDirectory, 500.0); 
//      AnchorPane.setBottomAnchor(songDirectory, 200.0); 
//      
//      
//      //coloring rectangles
//      rect1.setFill(Color.WHITE);
//      rect2.setFill(Color.WHITE);
//      rect3.setFill(Color.WHITE);
//       
//      rect1.setStrokeWidth(1);
//      rect2.setStrokeWidth(1);
//      rect3.setStrokeWidth(1);
//      
//      rect1.setStroke(Color.BLACK);
//      rect2.setStroke(Color.BLACK);
//      rect3.setStroke(Color.BLACK);
//      
//      
//      
//      //Retrieving the observable list of the Anchor Pane 
//      ObservableList list = anchorPane.getChildren();  
//      
//      //Adding cylinder to the pane 
//      list.addAll(rect1, rect2, rect3, songDirectory);      //, player  
//         
//      //Creating a scene object 
//      Scene scene = new Scene(anchorPane);  
//      
//      //Setting title to the Stage 
//      stage.setTitle("Guitar Tabs"); 
//         
//      //Adding scene to the stage 
//      stage.setScene(scene); 
//          
//      //Displaying the contents of the stage 
//      stage.show(); 
//   } 
//   public static void main(String args[]){ 
//      launch(args); 
//   } 
//}