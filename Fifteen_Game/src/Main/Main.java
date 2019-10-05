package Main;


import Game.Game;
import HighScore.Scores;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        Scene s = new Scene(root, 480, 640);
        primaryStage.getIcons().add(new Image("Resources/image.png"));
        primaryStage.setScene(s);
        primaryStage.show();

    }

    @FXML
    public void newGameButton() {
        new Game();
    }

    @FXML
    public void scoresButton() {
        new Scores();
    }

    @FXML
    public void exitButton() {
        System.exit(0);
    }
}