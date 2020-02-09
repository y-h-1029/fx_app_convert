package config_converter.config_conv_app.conv.logic.writer;

import javax.xml.bind.JAXB;

import config_converter.config_conv_app.conv.bean.Configuration;

public class XmlWriter {

	public static void writeToXml(Object obj, String outPath) {

		if (obj instanceof Configuration) {
			Configuration tmp = (Configuration) obj;
			JAXB.marshal(tmp, outPath);
		}

	}

}
