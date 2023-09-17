package sk.tomashrdy.testovaniefx;

import com.almasb.fxgl.entity.action.Action;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField textFieldCislo1;
    @FXML
    private ComboBox comboBoxAction;
    @FXML
    private TextField textFieldCislo2;
    @FXML
    private Label labelVysledok;
    @FXML
    private Button buttonVypocitaj;


    @FXML
    protected void buttonDajVysledok(ActionEvent event) {
        Double cislo1 = Double.parseDouble(textFieldCislo1.getText());
        Double cislo2 = Double.parseDouble(textFieldCislo2.getText());
        String operacia = (String) comboBoxAction.getSelectionModel().getSelectedItem();
        Double vysledok = 0.0;
        switch (operacia){
            case "+" : vysledok = cislo1 + cislo2;
                break;
            case "-" : vysledok = cislo1 - cislo2;
                break;
            case "*" : vysledok = cislo1 * cislo2;
                break;
            case "/" : if (cislo2 != 0){vysledok = cislo1 / cislo2;}
                break;
        }
        labelVysledok.setText(vysledok.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> operacie = FXCollections.observableArrayList("+" , "-" , "*" , "/");
        comboBoxAction.setItems(operacie);
        comboBoxAction.getSelectionModel().selectFirst();
    }
}