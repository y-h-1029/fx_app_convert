package config_converter.config_conv_app.conv.logic.reader;

import java.io.File;

import javax.xml.bind.JAXB;

import config_converter.config_conv_app.conv.bean.Configuration;

public class XmlReader {

    /**
     * xmlファイル読み込み処理
     * @param path
     * @return
     */
	public static Configuration readXml(String path) {
		Configuration config = null;
		try {
			File xml = new File(path);
			config = JAXB.unmarshal(xml, Configuration.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return config;
	}
}
