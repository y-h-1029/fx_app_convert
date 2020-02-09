package config_converter.config_conv_app;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TopController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox topDisp;

    @FXML
    private CheckBox chk_xlsxToXml;

    @FXML
    private CheckBox chk_xmlToXlsx;

    @FXML
    private TextField filePathInput;

    @FXML
    private Button fileSelectButton;

    @FXML
    private Button ExecuteButton;

    @FXML
    void executeChgButton(ActionEvent event) {

    }

    @FXML
    void selectFileButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert topDisp != null : "fx:id=\"topDisp\" was not injected: check your FXML file 'top.fxml'.";
        assert chk_xmlToXlsx != null : "fx:id=\"chk_xmlToXlsx\" was not injected: check your FXML file 'top.fxml'.";
        assert filePathInput != null : "fx:id=\"filePathInput\" was not injected: check your FXML file 'top.fxml'.";
        assert fileSelectButton != null : "fx:id=\"fileSelectButton\" was not injected: check your FXML file 'top.fxml'.";
        assert ExecuteButton != null : "fx:id=\"ExecuteButton\" was not injected: check your FXML file 'top.fxml'.";

    }
}
