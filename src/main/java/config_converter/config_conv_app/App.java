package config_converter.config_conv_app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    /**
     * start by fxapp
     */
    @SuppressWarnings("exports")
	@Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("top"), 600, 275);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * 画面オブジェクトセット
     * @param fxml
     * @throws IOException
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * FXML読み込み
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * 実行
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}