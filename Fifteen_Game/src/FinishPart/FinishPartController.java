package FinishPart;

import Game.GameController;
import Main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FinishPartController {

    @FXML
    TextField f;
    @FXML
    Label l;

    private String text = "";

    @FXML
    public void backButton() {
        text = text + (!f.getText().equals("") ? f.getText() : "Incognito") +  " : " + GameController.finishtime + " sec\n";
        try {
            PrintWriter writer = new PrintWriter("src/Resources/ScoresTxt");
            writer.print(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Finish.stage.close();
        Main.primaryStage.show();
    }

    @FXML
    public void initialize() {
        l.setText("Your time is: " + GameController.finishtime + " sec");
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Resources/ScoresTxt"));
            while ((line = br.readLine()) != null) {
                line += "\n";
                text += line;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
