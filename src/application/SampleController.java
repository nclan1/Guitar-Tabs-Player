package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SampleController implements Initializable{
	//so that the method you add are used with the stuff injected with fxml
	
	@FXML
	private Pane pane;
	@FXML
	private Label songTitle;
	@FXML
	private Button play, nextSong, goBack, pause;
	@FXML
	private ToggleButton switchTab;
	@FXML
	private ProgressBar songProgressBar;
	@FXML
	private ImageView tab_Chord;
	
	//fxml annotate denote a physical thing inside the GUI
	
	private Media media;
	private MediaPlayer mediaPlayer;
	
	private Image image;
	private InputStream stream;
	
	private File directory;
	private File[] files;
	
	private ArrayList<File> songs;
	
	private int songNumber;
	
	private Timer timer;
	private TimerTask task;
	//true or false depending on whether song is playing or not
	private boolean running;
	
	
	//dynamic 
	@FXML 
	private ListView<String> myListView;
	
	String[] song; 
	
	String currentSong;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//playlist of sorts
		//songs arraylist 
		//file datatype can be put in
		songs = new ArrayList<File>();
		
		//guitarmedia contains the guitar songs/soundtrack
		directory = new File("GuitarMedia");
		
		//get all files in director to store
		files = directory.listFiles();
		
		if (files != null) {
			for (File file : files) {
				
				songs.add(file); 
	
			}
		}
		
		//media player 
		//song number indicates #of songs -1
		media = new Media(songs.get(songNumber).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		//taking string from the name 
		songTitle.setText(songs.get(songNumber).getName());
		
		//making the listview interative
		//song array director
		song = directory.list();		
		myListView.getItems().addAll(song);	
		myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// method is used to listen if an object has been changed
				currentSong = myListView.getSelectionModel().getSelectedItem();
				//used forloop to compare if the pressed on song matches, if they do, then start playing it. 
				for (int i = 0; i <= songNumber; i++) {
					if (currentSong.equals(songs.get(i).getName())) {
						
						mediaPlayer.stop();
						
						if (running) {
							cancelTimer();
						}
						
						media = new Media(songs.get(i).toURI().toString());
						mediaPlayer = new MediaPlayer(media);
						
						songTitle.setText(songs.get(i).getName());
						
						songProgressBar.setProgress(0);
						beginTimer();
						mediaPlayer.play();
					}
				}
				
				if (currentSong.equals("Grover Washington Jr, Bill Withers - Just the two of us.mp3")) {
					image = new Image(getClass().getResourceAsStream("JT2OU.jpg"));
					tab_Chord.setImage(image);
				} else if (currentSong.equals("Randy Newman - You've got a friend in me.mp3")) {
					image = new Image(getClass().getResourceAsStream("YGAFIM.jpg"));
					tab_Chord.setImage(image);
				} else if (currentSong.equals("Stevie Wonder - Isn't She Lovely.mp3")) {
					image = new Image(getClass().getResourceAsStream("ISL.jpg"));
					tab_Chord.setImage(image);
				} else if (currentSong.equals("Tom Misch - It Runs Through Me.mp3")) {
					image = new Image(getClass().getResourceAsStream("IRTM.jpg"));
					tab_Chord.setImage(image);
				}
			}
		});
		//Image image = new Image(stream);
		// imageView.setImage(image);
		
		
	}
	
	public void playMedia(ActionEvent e){
		
		beginTimer(); 
		mediaPlayer.play();
	}
	
	public void pauseMedia(ActionEvent e){
		
		cancelTimer();
		mediaPlayer.pause();
		
	}
	
	public void skipSong(ActionEvent e) {
		
		//if its not last song, skip and play next song
		if(songNumber < songs.size() - 1) {
			
			songNumber++;
			
			mediaPlayer.stop();
			
			if (running) {
				cancelTimer();
			}
			
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			songTitle.setText(songs.get(songNumber).getName());
			
			beginTimer();
			songProgressBar.setProgress(0);
			mediaPlayer.play();
			
			//go back to beginning song. 
		} else {
			songNumber=0;
			
			mediaPlayer.stop();
			
			if (running) {
				cancelTimer();
			}
			
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			songTitle.setText(songs.get(songNumber).getName());
			
			beginTimer();
			songProgressBar.setProgress(0);
			mediaPlayer.play();
			

		}
		
	}
	
	public void rewind(ActionEvent e) {
		//using seek method for media player 
		songProgressBar.setProgress(0);
		mediaPlayer.seek(Duration.seconds(0));
	}
	
	
	public void beginTimer() {
		
		timer = new Timer();
		
		task = new TimerTask() {
			
			public void run() {
				//get the current time of the song
				//get the total duration of the song, and divide it. 
				running = true;
				double current = mediaPlayer.getCurrentTime().toSeconds();
				double end = media.getDuration().toSeconds();
				songProgressBar.setProgress(current/end);
				
				if(current/end == 1) {
					cancelTimer();
				}
			}
			
		};
		//update every one second
		//use to schedule the given task again and begin after a specified delay
		timer.scheduleAtFixedRate(task, 0, 1000); 
		
	}
	
	public void cancelTimer() {
		running = false;
		timer.cancel(); 
	}
	
//	Image tab = new Image(getClass().getResourceAsStream("just the two of us tab (1)1024_2.jpg"));
//	
//	public void nextPage() {
//		tab_Chord.setImage(tab);
//	}
	

}
