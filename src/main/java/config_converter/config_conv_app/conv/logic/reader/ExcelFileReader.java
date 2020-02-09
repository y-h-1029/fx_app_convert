package config_converter.config_conv_app.conv.logic.reader;

import java.io.File;
import java.io.FileInputStream;

import com.gh.mygreen.xlsmapper.XlsMapper;

import config_converter.config_conv_app.conv.bean.Configuration;

/**
 * Excelファイルリーダクラス
 * 「.xlsx」ファイルを読み込む
 * @author ゆうぎ
 */
public class ExcelFileReader {

	public static Configuration loadConfig(String path) {

		XlsMapper mapper = new XlsMapper();
		Configuration config = null;
		try(FileInputStream fis = new FileInputStream(new File(path))) {
			config = mapper.load(fis, Configuration.class);
			if (config == null) {
				System.out.println("xlsx read error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return config;
	}
}
