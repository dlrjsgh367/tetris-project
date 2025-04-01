module com.geonho.tetris.tetrisgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.geonho.tetris to javafx.fxml;
    exports com.geonho.tetris;
}