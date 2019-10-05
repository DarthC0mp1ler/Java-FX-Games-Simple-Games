package FinishPart;

import Game.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class Finish {

    public static Stage stage;

    public Finish() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FinishFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Game.gameStage.close();
        stage = new Stage();
        Scene scene = new Scene(root, 480, 640);
        stage.getIcons().add(new Image("Resources/image.png"));
        stage.setScene(scene);
        stage.show();
    }

}
