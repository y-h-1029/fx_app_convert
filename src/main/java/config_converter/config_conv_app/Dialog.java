package config_converter.config_conv_app;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Dialog extends Alert {

    /** ダイアログ */
    private static Alert dialog = null;

    private Dialog(AlertType alertType) {
        super(alertType);
    }

    /**
     * ダイアログ種別判定
     * @param alertType
     * @param txtField
     * @param exp
     */
    public static void openDialog(@SuppressWarnings("exports") AlertType alertType, String[] txtField, Exception exp) {

        switch (alertType) {

        case CONFIRMATION:
            // 確認ダイアログ
            dialog = new Alert(alertType);
            show(txtField, exp);
            break;
        case ERROR:
            // エラーダイアログ
            dialog = new Alert(alertType);
            show(txtField, exp);
            break;
        case INFORMATION:
            // インフォ
            dialog = new Alert(alertType);
            show(txtField, exp);
            break;
        case NONE:
            // 使用しない
            break;
        case WARNING:
            // 警告ダイアログ
            dialog = new Alert(alertType);
            show(txtField, exp);
            break;
        default:
            break;
        }

    }

    /**
     * ダイアログ初期化と表示
     * @param txtField
     * @param exp
     */
    private static void show(String[] txtField, Exception exp) {
        dialog.setTitle(txtField[0]);
        dialog.setHeaderText(null);
        if (exp != null) {
            dialog.setContentText(exp.getLocalizedMessage());
        } else {
            dialog.setContentText(txtField[1]);
        }
        dialog.showAndWait();
    }

}
