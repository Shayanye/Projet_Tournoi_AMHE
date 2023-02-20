/**
 *
 */
/**
 * @author charles
 *
 */
module Projet_Tournoi_AMHE {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.toulouse.miage.amhe to javafx.fxml;
    exports fr.toulouse.miage.amhe;
}