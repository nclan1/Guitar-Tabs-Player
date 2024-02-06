module Guitar_Tab {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.media;
	requires java.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
