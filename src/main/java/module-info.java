module com.corrinedev.lostcitieshelper {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.corrinedev.lostcitieshelper to javafx.fxml;
    exports com.corrinedev.lostcitieshelper;
}