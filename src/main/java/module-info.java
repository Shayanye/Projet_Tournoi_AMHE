module fr.toulouse.miage.amhe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens fr.toulouse.miage.amhe to javafx.fxml;
    exports fr.toulouse.miage.amhe;
}