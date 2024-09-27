package com.corrinedev.lostcitieshelper;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class ButtonController {
    @FXML
    private Button fileButton;
    @FXML
    private Button quitButton;
    @FXML
    private Button emptyButton;
    @FXML
    private Button templateButton;
    @FXML
    private Hyperlink hyperlink;

    @FXML
    protected void onFileButton() {

        FileSplitter.extractPieces();

    }
    @FXML
    protected void onQuitButton() {

        System.exit(0);

    }
    @FXML
    protected void onEmptyButton() {



    }
    @FXML
    protected void onTemplateButton() {

        TemplateCreator.createTemplates();

    }
    @FXML
    protected void onHyperlink() {

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(URI.create("https://github.com/Corrinedev"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}