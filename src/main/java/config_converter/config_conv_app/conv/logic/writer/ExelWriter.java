package config_converter.config_conv_app.conv.logic.writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.gh.mygreen.xlsmapper.XlsMapper;

import config_converter.config_conv_app.conv.bean.Configuration;

public class ExelWriter {

	public static void writeXlsx(String tmpFilePath, String dstFilePath, Configuration config) {

		try (FileInputStream fis = new FileInputStream(new File(tmpFilePath));
				FileOutputStream fos = new FileOutputStream(new File(dstFilePath))) {

			XlsMapper mapper = new XlsMapper();
			mapper.save(fis, fos, config);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
