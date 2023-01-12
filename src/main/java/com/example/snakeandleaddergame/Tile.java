package com.example.snakeandleaddergame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(final int x, final int y){
        this.setWidth(HelloApplication.Tile_size);
        this.setHeight(HelloApplication.Tile_size);
        this.setFill(Color.PINK);
        this.setStroke(Color.BLACK);

    }

}
