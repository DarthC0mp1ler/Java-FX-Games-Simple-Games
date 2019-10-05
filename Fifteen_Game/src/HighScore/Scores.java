package HighScore;

import Main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Scores {

    static Stage stage;

    public Scores() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("ScoresFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.primaryStage.close();
        stage = new Stage();
        Scene scene = new Scene(root, 480, 640);
        stage.getIcons().add(new Image("Resources/image.png"));
        stage.setScene(scene);
        stage.show();
    }
}