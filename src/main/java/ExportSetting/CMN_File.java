package ExportSetting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CMN_File {

	final static Logger logger = LoggerFactory.getLogger(CMN_File.class);
	
    /**
     * �g�s�l�k�v�f�t�@�C���o�͏���
     * @param path �o�̓t�@�C���p�X�i�t�@�C�����܂ށj
     * @param msg �o�͏��
     * @throws IOException �o�͗�O 
     */
    public static void writeFile(String path, String msg) throws IOException {

    	logger.info("writeFile processing Start!!...");
    	logger.debug("HTML file : " + path);
    	File file = new File(path);
    	if(!file.exists() || !file.isFile()) {
	    	try {
	    		file.createNewFile();
			} catch (IOException e) {
				logger.error("�f�B���N�g���쐬�Ɏ��s���܂����B");
				throw e;
			}
    	}
    	logger.debug("writeFile processing from now!!");
    	FileWriter filewriter;
		try {
			filewriter = new FileWriter(file);
		} catch (IOException e) {
			logger.error("�������݂Ɏ��s���܂����B");
			throw e;
		}
		logger.debug("writeFile processing writed now...");
        try {
			filewriter.write(msg);
			filewriter.close();
		} catch (IOException e) {
			logger.error("�������݂Ɏ��s���܂����B");
			throw e;
		}
        logger.debug("writeFile processing End...");
    }
    
    /**
     * @return ���s�n�r���̊K�w���ʕ���
     */
    public static String sepStr() {
    	String osnmae = System.getProperty("os.name").toLowerCase();
    	if (osnmae.startsWith("linux") || osnmae.startsWith("mac")) {
    		return "/";
    	}
    	return "\\";
    }
}
