package com.corrinedev.lostcitieshelper;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

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

        BuildingCreator.createBuilding();

    }
    @FXML
    protected void onTemplateButton() {

        TemplateCreator templateCreator = new TemplateCreator();
        templateCreator.run();

    }
    @FXML
    protected void onHyperlink() {

        if( Desktop.isDesktopSupported() )
        {
            new Thread(() -> {
                try {
                    Desktop.getDesktop().browse( new URI( "https://github.com/Corrinedev" ) );
                    System.out.println(Thread.currentThread());
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }).start();
       //     new Thread(() -> {
            //thread example
      //      }).start();
        }
    }
}