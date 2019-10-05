package HighScore;

import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoresController {

    @FXML
    public TextArea scoresArea;

    @FXML
    public void backButton() {
        Scores.stage.close();
        Main.primaryStage.show();
    }

    @FXML
    public void initialize() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Resources/ScoresTxt"));
            while ((line = br.readLine()) != null) {
                line+="\n";
                scoresArea.appendText(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}