module config_converter.config_conv_app {
    requires javafx.controls;
    requires javafx.fxml;
	requires xlsmapper;
	requires java.xml.bind;
	requires jdk.jfr;
	requires lombok;
	requires poi;

    opens config_converter.config_conv_app to javafx.fxml;
    exports config_converter.config_conv_app;
}