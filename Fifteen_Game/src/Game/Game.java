package Game;

import Main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {

    public static Stage gameStage;

    public Game() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("GameFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.primaryStage.close();
        gameStage = new Stage();
        Group groot = new Group(root);
        Scene gameScene = new Scene(groot,440,640);
        gameStage.getIcons().add(new Image("Resources/image.png"));
        gameStage.setScene(gameScene);
        gameStage.show();
    }
}