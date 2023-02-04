package fr.toulouse.miage.amhe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class CreerTournoi extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Tournoi_AMHE");
        stage.setScene(scene);
        stage.show();

    }
}