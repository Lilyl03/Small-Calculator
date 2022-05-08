package com.example.drafts;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainController {
    @FXML private Pane titlePane;

    @FXML private ImageView btnClose;

    private double x, y;

    public void init(Stage stage){
        titlePane.setOnMousePressed(mouseEvent ->{
            x = mouseEvent.getSceneX();
            y= mouseEvent.getSceneY();
        } );
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getSceneX()-x);
            stage.setY(mouseEvent.getSceneY()-y);
        });

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
    }
    @FXML
    void onNumberClicked(MouseEvent event) {

    }

    @FXML
    void onSymbolClicked(MouseEvent event) {

    }


}