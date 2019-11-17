package ExportSetting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CMN_File {

	final static Logger logger = LoggerFactory.getLogger(CMN_File.class);
	
    /**
     * ＨＴＭＬ要素ファイル出力処理
     * @param path 出力ファイルパス（ファイル名含む）
     * @param msg 出力情報
     * @throws IOException 出力例外 
     */
    public static void writeFile(String path, String msg) throws IOException {

    	logger.info("writeFile processing Start!!...");
    	logger.debug("HTML file : " + path);
    	File file = new File(path);
    	if(!file.exists() || !file.isFile()) {
	    	try {
	    		file.createNewFile();
			} catch (IOException e) {
				logger.error("ディレクトリ作成に失敗しました。");
				throw e;
			}
    	}
    	logger.debug("writeFile processing from now!!");
    	FileWriter filewriter;
		try {
			filewriter = new FileWriter(file);
		} catch (IOException e) {
			logger.error("書き込みに失敗しました。");
			throw e;
		}
		logger.debug("writeFile processing writed now...");
        try {
			filewriter.write(msg);
			filewriter.close();
		} catch (IOException e) {
			logger.error("書き込みに失敗しました。");
			throw e;
		}
        logger.debug("writeFile processing End...");
    }
    
    /**
     * @return 実行ＯＳ毎の階層識別文字
     */
    public static String sepStr() {
    	String osnmae = System.getProperty("os.name").toLowerCase();
    	if (osnmae.startsWith("linux") || osnmae.startsWith("mac")) {
    		return "/";
    	}
    	return "\\";
    }
}
