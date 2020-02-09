package config_converter.config_conv_app.conv.logic.reader;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXB;

import config_converter.config_conv_app.conv.bean.Configuration;

public class XmlReader {

	public static Configuration readXml(String path) {
		Configuration config = null;
		try {
			File xml = new File(path);
			if (!xml.exists()) {
				throw new IOException("xml read error");
			}
			config = JAXB.unmarshal(xml, Configuration.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return config;
	}
}
