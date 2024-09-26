package com.corrinedev.lostcitieshelper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ButtonController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Created Parts/Palletes");
        FileSplitter.extractPieces();

    }
}