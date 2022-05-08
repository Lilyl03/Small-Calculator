package com.example.drafts;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainController {
    @FXML private Pane titlePane;

    @FXML private ImageView btnClose;

    @FXML private Label lblResult;

    private double x, y;
    private double num1 = 0;
    private String operator = "+";
    private boolean equal = true;

    public void init(Stage stage){
        titlePane.setOnMousePressed(mouseEvent ->{
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        } );
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
    }
    @FXML
    void onNumberClicked(MouseEvent event) {
        if(equal){
            lblResult.setText(String.valueOf(("0.0")));
            equal = false;
        }
        int value = Integer.parseInt(((Label)event.getSource()).getId().replace("btn",""));
        lblResult.setText(Double.parseDouble(lblResult.getText()) == 0 ? String.valueOf((double)value) :String.valueOf(Double.parseDouble(lblResult.getText())*10+value));

    }

    @FXML
    void onSymbolClicked(MouseEvent event) {
        String symbol = ((Label)event.getSource()).getId().replace("btn","");
        double num2 = Double.parseDouble(lblResult.getText());
        if(symbol.equals("Equals")){

            switch (operator){
                case "+" -> lblResult.setText((num1+num2) + "");
                case "-" -> lblResult.setText((num1-num2) + "");
                case "*" -> lblResult.setText((num1*num2) + "");
                case "/" -> lblResult.setText((num1/num2) + "");
            }
            operator = ".";
            equal = true;
        }else if(symbol.equals("Clear")){
            lblResult.setText(String.valueOf("0.0"));
            operator = ".";
        }else{
            switch (symbol){
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multiply" -> operator = "*";
                case "Divide" -> operator = "/";
            }
            num1 = Double.parseDouble(lblResult.getText());
            lblResult.setText(String.valueOf(("0.0")));

        }

    }


}