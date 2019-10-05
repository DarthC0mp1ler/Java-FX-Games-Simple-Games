package Game;

import FinishPart.Finish;
import Main.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameController {

    @FXML
    public ImageView imageView0;
    @FXML
    public ImageView imageView1;
    @FXML
    public ImageView imageView2;
    @FXML
    public ImageView imageView3;
    @FXML
    public ImageView imageView4;
    @FXML
    public ImageView imageView5;
    @FXML
    public ImageView imageView6;
    @FXML
    public ImageView imageView7;
    @FXML
    public ImageView imageView8;
    @FXML
    public ImageView imageView9;
    @FXML
    public ImageView imageView10;
    @FXML
    public ImageView imageView11;
    @FXML
    public ImageView imageView12;
    @FXML
    public ImageView imageView13;
    @FXML
    public ImageView imageView14;
    @FXML
    public Label timelabel;

    @FXML
    public void toMainMenuButton() {
        Game.gameStage.close();
        Main.primaryStage.show();
    }

    @FXML
    public void exitButton() {
        System.exit(0);
    }

    int currenttime = 0;
    public static int finishtime = 0;
    Timeline timeline;

    double emptyX = 320.0;
    double emptyY = 320.0;
    Image[] images;

    List<ImageView> list;

    double[][] checkArr = {{20, 20}, {120, 20}, {220, 20}, {320, 20}, {20, 120}, {120, 120}, {220, 120}, {320, 120},
            {20, 220}, {120, 220}, {220, 220}, {320, 220}, {20, 320}, {120, 320}, {220, 320}, {emptyX, emptyY}};

    public void timer() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        e -> {currenttime++;
                            timelabel.setText(currenttime + " sec");}
                ));
        timeline.play();
    }

    @FXML
    public void initialize() {
        timer();

        timelabel.setText("0 sec");
        Image image = new Image("Resources/image.png");
        images = getSubimage(image);

        list = Arrays.asList(imageView0,imageView1,imageView2,imageView3,
                imageView4,imageView5,imageView6,imageView7,
                imageView8,imageView9,imageView10,imageView11,
                imageView12,imageView13,imageView14);
        Collections.shuffle(list);

        int i = 0;
        for (ImageView img: list) {
            img.setImage(images[i++]);
            img.setOnMouseClicked(e -> click(img));
        }
    }

    public boolean check(ImageView img) {
        double minX, minY, maxX, maxY;
        if (img.getLayoutY() > emptyY) {
            maxY = img.getLayoutY();
            minY = emptyY;
        } else {
            maxY = emptyY;
            minY = img.getLayoutY();
        }
        if (img.getLayoutX() > emptyX) {
            minX = emptyX;
            maxX = img.getLayoutX();
        } else {
            maxX = emptyX;
            minX = img.getLayoutX();
        }
        return (maxX - minX == 100 && maxY - minY == 0) || (maxX - minX == 0 && maxY - minY == 100);
    }

    private void click(ImageView img) {
        if (check(img)) {
            double temporaryX = img.getLayoutX();
            double temporaryY = img.getLayoutY();
            img.setLayoutX(emptyX);
            img.setLayoutY(emptyY);
            emptyX = temporaryX;
            emptyY = temporaryY;

            if (checkOrder()) {
                timeline.stop();
                finishtime = currenttime;
                new Finish();
            }
        }
    }

    Image[] getSubimage(Image image) {
        PixelReader pixelReader = image.getPixelReader();
        int hor = 4;
        int vert = 4;

        double width = image.getWidth() / hor;
        double height = image.getHeight() / vert;

        Image[] images = new Image[vert*hor];
        for (int v = 0, count = 0; v < vert && count < images.length; v++) {
            for (int h = 0; h < hor; h++, count++) {
                images[count] = new WritableImage(
                        pixelReader, (int) (h * width),
                        (int) (v * height),
                        (int) width, (int) height
                );
            }
        }
        return images;
    }

    public boolean checkOrder() {
        for (int i = 0; i < checkArr.length-1; i++) {
            int j = 0;
            if(list.get(i).getLayoutX() != checkArr[i][j]){
                return false;
            }
            j++;
            if(list.get(i).getLayoutY() != checkArr[i][j]){
                return false;
            }
        }
        if((checkArr[checkArr.length-1][0] != emptyX) || (checkArr[checkArr.length-1][1] != emptyY)){
            return false;
        }
        return true;
    }
}