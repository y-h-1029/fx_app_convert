package config_converter.config_conv_app;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class TopController {

    /** ファイル選択ダイアログ */
    private FileChooser fileChooser = new FileChooser();

    /** xlsx拡張子チェック用正規表現 */
    private static final String XLSX_REG = ".*.xlsx";

    /** xml拡張子チェック用正規表現 */
    private static final String XML_REG = ".*.xml";

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

    /**
     * 変換実行処理
     * @param event
     */
    @FXML
    void executeChgButton(ActionEvent event) throws Exception {
        // 入力チェック（チェックボックス）
        if (!chk_xlsxToXml.isDisable() && !chk_xmlToXlsx.isDisable()) {
            Dialog.openDialog(AlertType.WARNING, new String[] {"警告", "チェックボックスにチェックして下さい"}, null);
        }

        // 入力チェック（ファイルパス）
        if (filePathInput.getText().isEmpty()) {
            Dialog.openDialog(AlertType.WARNING, new String[] {"警告", "ファイルパスを入力してください"}, null);
        }

        // 入力チェック（ファイルの拡張子とチェックボックスの相間チェック）
        if (!chk_xmlToXlsx.isDisable()) {
            if (!Pattern.matches(XML_REG, filePathInput.getText())) {
                Dialog.openDialog(AlertType.WARNING, new String[] {"警告", "xml拡張子のファイルを選択して下さい"}, null);
            }
        } else if (!chk_xlsxToXml.isDisable()) {
            if (!Pattern.matches(XLSX_REG, filePathInput.getText())) {
                Dialog.openDialog(AlertType.WARNING, new String[] {"警告", "xlsx拡張子のファイルを選択して下さい"}, null);
            }
        }

        // 変換処理呼び出し
    }

    /**
     * 参照ボタン
     * ディレクトリ選択ダイアログを開く
     * @param event
     */
    @FXML
    void selectFileButton(ActionEvent event) {

        try {
            // inputからファイルパス取得
            String srcFile = this.filePathInput.textProperty().get();
            // ファイルパス入力チェック
            if (srcFile != null && !srcFile.isEmpty()) {
                // ファイルオブジェクト生成
                File file = new File(srcFile);
                // ファイル存在チェック
                if (file.exists()) {
                    this.fileChooser.setInitialDirectory(file);
                } else {
                    throw new IOException("ファイルが存在しません");
                }
            }

            // ファイル選択ダイアログ
            File selectedFile = fileChooser.showOpenDialog(((Button) event.getSource()).getScene().getWindow());
            // ファイルパス入力チェック
            if (selectedFile != null) {
                this.filePathInput.setText(selectedFile.getAbsolutePath());
                this.filePathInput.requestFocus();
            }
        } catch (Exception e) {
            Dialog.openDialog(AlertType.ERROR, new String[] {
                    "エラー"
            }, e);
        }
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
