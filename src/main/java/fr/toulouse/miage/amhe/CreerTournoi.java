package fr.toulouse.miage.amhe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class CreerTournoi extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root, 600, 400);
        stage.getIcons().add(new Image("https://www.balsi.de/Weltkrieg/Einheiten/Heer/Artillerie/Sturmartillerie/Brigaden/242-StugBrig.gif"));
        stage.setTitle("Tournoi_AMHE");
        stage.setScene(scene);
        stage.show();

    }
}