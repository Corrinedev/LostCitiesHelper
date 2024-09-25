package com.corrinedev.lostcitieshelper;

import javafx.stage.DirectoryChooser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSplitter {

    public static void extractPallete() {

        DirectoryChooser fileChooser = new DirectoryChooser();

        String directory = String.valueOf(fileChooser.showDialog(null));

        System.out.println(directory);


    }

}
