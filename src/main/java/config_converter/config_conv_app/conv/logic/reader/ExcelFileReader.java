package config_converter.config_conv_app.conv.logic.reader;

import java.io.File;
import java.io.FileInputStream;

import com.gh.mygreen.xlsmapper.XlsMapper;

import config_converter.config_conv_app.Dialog;
import config_converter.config_conv_app.conv.bean.Configuration;
import javafx.scene.control.Alert.AlertType;

/**
 * Excelファイルリーダクラス
 * 「.xlsx」ファイルを読み込む
 * @author ゆうぎ
 */
public class ExcelFileReader {

    /**
     * xlsxのファイル読み込み
     * @param path
     * @return
     */
	public static Configuration readXlsx(String path) {
		XlsMapper mapper = new XlsMapper();
		Configuration config = null;
		try(FileInputStream fis = new FileInputStream(new File(path))) {
			config = mapper.load(fis, Configuration.class);
		} catch (Exception e) {
			Dialog.openDialog(AlertType.ERROR, new String[]{"エラー", "ファイル読み込みに失敗しました"}, e);
		}
		return config;
	}
}
