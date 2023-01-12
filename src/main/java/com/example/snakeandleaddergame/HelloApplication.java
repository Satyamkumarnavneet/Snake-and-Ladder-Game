package com.example.snakeandleaddergame;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    public static final int Tile_size = 60;
    public static final int width_size = 10;
    public static final int height_size = 10;
    public static int player1Xposition = 30;
    public static int player1Yposition = 570;
    public static int player2Xposition = 30;
    public static int player2Yposition = 570;
    private final Group tileGroup = new Group();
    public int random;
    public Label randomResult;
    public int[][] cirPos = new int[10][10];
    public int[][] ladderPosition = new int[8][7];
    public Circle player1;
    public Circle player2;
    public int playerPosition1 = 1;
    public int playerPosition2 = 1;
    public boolean player1Turn = true;
    public boolean player2Turn = true;
    public int positionCircle1 = 1;
    public int positionCircle2 = 1;
    public boolean gameStart;
    public Button gameButton;

    public static void main(final String[] args) {
        Application.launch();
    }

    private Parent createContent() throws FileNotFoundException {
        final Pane root = new Pane(); // StackPane lays out its children in a back-to-front stack.
        root.setPrefSize(HelloApplication.width_size * HelloApplication.Tile_size, (HelloApplication.height_size * HelloApplication.Tile_size) + 80);
        root.getChildren().addAll(this.tileGroup);

        for (int i = 0; height_size > i; i++) {
            for (int j = 0; width_size > j; j++) {
                final Tile tile = new Tile(HelloApplication.Tile_size, HelloApplication.Tile_size);
                tile.setTranslateX(j * HelloApplication.Tile_size);
                tile.setTranslateY(i * HelloApplication.Tile_size);
                this.tileGroup.getChildren().add(tile);

                this.cirPos[i][j] = j * (HelloApplication.Tile_size - 30); // Calculate X coordinate

            }
        }

        for (int i = 0; height_size > i; i++) { // Print X coordinate
            for (int j = 0; width_size > j; j++) {
                System.out.print(this.cirPos[i][j] + " ");
            }
            System.out.println();
        }

        this.player1 = new Circle(25);
        this.player1.setId("player1");
        this.player1.setFill(Color.RED);
        this.player1.getStyleClass().add("style.css");
        this.player1.setTranslateX(HelloApplication.player1Xposition);
        this.player1.setTranslateY(HelloApplication.player1Yposition);

        this.player2 = new Circle(25);
        this.player2.setId("player2");
        this.player2.setFill(Color.BLUE);
        this.player2.getStyleClass().add("style.css");
        this.player2.setTranslateX(HelloApplication.player2Xposition);
        this.player2.setTranslateY(HelloApplication.player2Yposition);

        final Button button1 = new Button("player1");
        button1.setTranslateX(6);
        button1.setTranslateY(625);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent Event) {
                if (HelloApplication.this.gameStart) {
                    if (HelloApplication.this.player1Turn) {
                        HelloApplication.this.getDiceValue();
                        HelloApplication.this.randomResult.setText(String.valueOf(HelloApplication.this.random));
                        HelloApplication.this.move1Player();
                        HelloApplication.this.translatePlayer(HelloApplication.player1Xposition, HelloApplication.player1Yposition, HelloApplication.this.player1);
                        HelloApplication.this.player1Turn = false;
                        HelloApplication.this.player2Turn = true;
                        HelloApplication.this.playerPosition1 += HelloApplication.this.random;

//                        if (player1Xposition == 90 && player1Yposition == 570){
//                            translatePlayer(player1Xposition = 150,player1Yposition = 450, player1);
//                        }
//                        if(player1Xposition == 210 && player1Yposition == 570){
//                            translatePlayer(player1Xposition = 450, player1Yposition = 210, player1);
//                        }
//                        if(player1Xposition == 330 && player1Yposition == 570){
//                            translatePlayer(player1Xposition = 270, player1Yposition = 330, player1);
//                        }
//                        if(player1Xposition == 30 && player1Yposition == 510){
//                            translatePlayer(player1Xposition = 90, player1Yposition = 270, player1);
//                        }


                        if (90 == player1Xposition && 570 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 150, HelloApplication.player1Yposition = 450, HelloApplication.this.player1);
                        }
                        if (330 == player1Xposition && 570 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 270, HelloApplication.player1Yposition = 330, HelloApplication.this.player1);
                        }
                        if (210 == player1Xposition && 570 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 450, HelloApplication.player1Yposition = 210, HelloApplication.this.player1);
                        }
                        if (30 == player1Xposition && 510 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 90, HelloApplication.player1Yposition = 270, HelloApplication.this.player1);
                        }
                        if (150 == player1Xposition && 330 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 210, HelloApplication.player1Yposition = 510, HelloApplication.this.player1);
                        }
                        if (570 == player1Xposition && 330 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 270, HelloApplication.player1Yposition = 570, HelloApplication.this.player1);
                        }
                        if (510 == player1Xposition && 270 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 510, HelloApplication.player1Yposition = 150, HelloApplication.this.player1);
                        }
                        if (270 == player1Xposition && 270 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 450, HelloApplication.player1Yposition = 570, HelloApplication.this.player1);
                        }
                        if (210 == player1Xposition && 270 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 270, HelloApplication.player1Yposition = 30, HelloApplication.this.player1);
                        }
                        if (450 == player1Xposition && 150 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 330, HelloApplication.player1Yposition = 510, HelloApplication.this.player1);
                        }
                        if (390 == player1Xposition && 90 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 510, HelloApplication.player1Yposition = 330, HelloApplication.this.player1);
                        }
                        if (210 == player1Xposition && 90 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 150, HelloApplication.player1Yposition = 270, HelloApplication.this.player1);
                        }
                        if (570 == player1Xposition && 150 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 510, HelloApplication.player1Yposition = 30, HelloApplication.this.player1);
                        }
                        if (150 == player1Xposition && 30 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 30, HelloApplication.player1Yposition = 390, HelloApplication.this.player1);
                        }
                        if (570 == player1Xposition && 450 == player1Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player1Xposition = 270, HelloApplication.player1Yposition = 20, HelloApplication.this.player1);
                        }

                    }
                }
            }
        });

        final Button button2 = new Button("player2");
        button2.setTranslateX(540);
        button2.setTranslateY(625);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent Event) {
                if (HelloApplication.this.gameStart) {
                    if (HelloApplication.this.player2Turn) {
                        HelloApplication.this.getDiceValue();
                        HelloApplication.this.randomResult.setText(String.valueOf(HelloApplication.this.random));
                        HelloApplication.this.move2Player();
                        HelloApplication.this.translatePlayer(HelloApplication.player2Xposition, HelloApplication.player2Yposition, HelloApplication.this.player2);
                        HelloApplication.this.player2Turn = false;
                        HelloApplication.this.player1Turn = true;
                        HelloApplication.this.playerPosition2 += HelloApplication.this.random;

//                        if (player2Xposition == 90 && player2Yposition == 570){
//                            translatePlayer(player2Xposition = 150,player2Yposition = 450, player2);
//                        }
//                        if(player2Xposition == 210 && player2Yposition == 570){
//                            translatePlayer(player2Xposition = 450, player2Yposition = 210, player2);
//                        }
//                        if(player2Xposition == 330 && player2Yposition == 570){
//                            translatePlayer(player2Xposition = 270, player2Yposition = 330, player2);
//                        }
//                        if(player2Xposition == 30 && player2Yposition == 510){
//                            translatePlayer(player2Xposition = 90, player2Yposition = 270, player2);
//                        }


                        if (90 == player2Xposition && 570 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 150, HelloApplication.player2Yposition = 450, HelloApplication.this.player2);
                        }
                        if (330 == player2Xposition && 570 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 270, HelloApplication.player2Yposition = 330, HelloApplication.this.player2);
                        }
                        if (210 == player2Xposition && 570 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 450, HelloApplication.player2Yposition = 210, HelloApplication.this.player2);
                        }
                        if (30 == player2Xposition && 510 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 90, HelloApplication.player2Yposition = 270, HelloApplication.this.player2);
                        }
                        if (150 == player2Xposition && 330 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 210, HelloApplication.player2Yposition = 510, HelloApplication.this.player2);
                        }
                        if (570 == player2Xposition && 330 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 270, HelloApplication.player2Yposition = 570, HelloApplication.this.player2);
                        }
                        if (510 == player2Xposition && 270 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 510, HelloApplication.player2Yposition = 150, HelloApplication.this.player2);
                        }
                        if (270 == player2Xposition && 270 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 450, HelloApplication.player2Yposition = 570, HelloApplication.this.player2);
                        }
                        if (210 == player2Xposition && 270 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 270, HelloApplication.player2Yposition = 30, HelloApplication.this.player2);
                        }
                        if (450 == player2Xposition && 150 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 330, HelloApplication.player2Yposition = 510, HelloApplication.this.player2);
                        }
                        if (390 == player2Xposition && 90 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 510, HelloApplication.player2Yposition = 330, HelloApplication.this.player2);
                        }
                        if (210 == player2Xposition && 90 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 150, HelloApplication.player2Yposition = 270, HelloApplication.this.player2);
                        }
                        if (570 == player2Xposition && 150 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 510, HelloApplication.player2Yposition = 30, HelloApplication.this.player2);
                        }
                        if (150 == player2Xposition && 30 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 30, HelloApplication.player2Yposition = 390, HelloApplication.this.player2);
                        }
                        if (570 == player2Xposition && 450 == player2Yposition) {
                            HelloApplication.this.translatePlayer(HelloApplication.player2Xposition = 270, HelloApplication.player2Yposition = 20, HelloApplication.this.player2);
                        }
                    }
                }
            }
        });

        this.gameButton = new Button("Start Game");
        this.gameButton.setTranslateX(260);
        this.gameButton.setTranslateY(625);
        this.gameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent Event) {
                HelloApplication.this.gameButton.setText("Game started");
                HelloApplication.player1Xposition = 30;
                HelloApplication.player1Yposition = 570;

                HelloApplication.player2Xposition = 30;
                HelloApplication.player2Yposition = 570;

                HelloApplication.this.player1.setTranslateX(HelloApplication.player1Xposition);
                HelloApplication.this.player1.setTranslateY(HelloApplication.player1Yposition);

                HelloApplication.this.player2.setTranslateX(HelloApplication.player2Xposition);
                HelloApplication.this.player2.setTranslateY(HelloApplication.player2Yposition);
                HelloApplication.this.gameStart = true;
            }
        });

        this.randomResult = new Label("0");
        this.randomResult.setTranslateX(260);
        this.randomResult.setTranslateY(625);

        //Image img = new Image("C:\\image\\jayati.jpg");
        //Image img = new Image(new FileInputStream("C:\\image\\jayati.jpg"));
        final Image img = new Image(new FileInputStream("C:\\Users\\satyam kumar navneet\\Documents\\Satyam document\\Java projects\\Snake and Leadder Game\\src\\main\\java\\com\\example\\snakeandleaddergame\\background1.jpg"));

        final ImageView backGroundImage = new ImageView();
        backGroundImage.setImage(img);
        backGroundImage.setFitHeight(600);
        backGroundImage.setFitWidth(600);

        this.tileGroup.getChildren().addAll(backGroundImage, this.player1, this.player2, button1, button2, this.gameButton, this.randomResult);
        return root;


    }

    private void getDiceValue() {
        this.random = (int) (Math.random() * 6 + 1);
    }

    private void move1Player() {

        for (int i = 0; i < this.random; i++) {
            if (1 == positionCircle1 % 2) {
                HelloApplication.player1Xposition += 60;
            }
            if (0 == positionCircle1 % 2) {
                HelloApplication.player1Xposition -= 60;
            }
            if (570 < player1Xposition) {
                HelloApplication.player1Yposition -= 60;
                HelloApplication.player1Xposition -= 60;
                this.positionCircle1++;
            }
            if (30 > player1Xposition) {
                HelloApplication.player1Yposition -= 60;
                HelloApplication.player1Xposition += 60;
                this.positionCircle1++;
            }
            if (20 > player1Xposition || 20 > player1Yposition) {
                HelloApplication.player1Xposition = 30;
                HelloApplication.player1Yposition = 30;
                this.randomResult.setText("Player One Won");
                this.gameButton.setText("start Again");

            }

        }


    }

    private void move2Player() {
        for (int i = 0; i < this.random; i++) {
            if (1 == positionCircle2 % 2) {
                HelloApplication.player2Xposition += 60;
            }
            if (0 == positionCircle2 % 2) {
                HelloApplication.player2Xposition -= 60;
            }
            if (570 < player2Xposition) {
                HelloApplication.player2Yposition -= 60;
                HelloApplication.player2Xposition -= 60;
                this.positionCircle2++;
            }
            if (30 > player2Xposition) {
                HelloApplication.player2Yposition -= 60;
                HelloApplication.player2Xposition += 60;
                this.positionCircle2++;
            }
            if (20 > player2Xposition || 20 > player2Yposition) {
                HelloApplication.player2Xposition = 30;
                HelloApplication.player2Yposition = 30;
                this.randomResult.setText("Player One Won");
                this.gameButton.setText("start Again");

            }

        }
    }

    private void translatePlayer(final int x, final int y, final Circle b) {
        final TranslateTransition animate = new TranslateTransition(Duration.millis(1000), b);
        animate.setToX(x);
        animate.setToY(y);
        animate.setAutoReverse(false);
        animate.play();
    }

    @Override
    public void start(final Stage stage) throws IOException {
        final Scene scene = new Scene(this.createContent());
        stage.setTitle("Snake and Ladder Game made with ❤ by Satyam & Archi");
        stage.setScene(scene);
        stage.show();
    }
}