package ExportSetting;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	final static Logger logger = LoggerFactory.getLogger(Main.class);
	
	
	public static void main(String[] args) throws Exception {
		CMN_Setting setting = setting();
		CMN_Export settingService = new CMN_Export(setting);
		settingService.service();
		CMN_Format formatService = new CMN_Format(setting);
		formatService.service();
	}
	
	private static CMN_Setting setting() throws Exception {
    	// 入力チェック
		CMN_Setting setting = new CMN_Setting();
		String dir = "conf";
		URLClassLoader urlLoader = new URLClassLoader(new URL[]{new File(dir).toURI().toURL()});
    	ResourceBundle rb = ResourceBundle.getBundle("build", Locale.getDefault(), urlLoader);
    	setting.setServerurl(rb.getString("sf.serverurl"));
    	setting.setUid(rb.getString("sf.username"));
    	setting.setPw(rb.getString("sf.password"));
    	setting.setDir(new File(".").getAbsoluteFile().getParent() + CMN_File.sepStr() + rb.getString("report"));
    	setting.setCapturelist(rb.getString("capturelist"));
    	if (StringUtils.isEmpty(setting.getServerurl())) {
    		throw new Exception("sf.serverurlを設定してください。");
    	}
    	if (StringUtils.isEmpty(setting.getUid())) {
    		throw new Exception("sf.usernameを設定してください。");
    	}
    	if (StringUtils.isEmpty(setting.getPw())) {
    		throw new Exception("sf.passwordを設定してください。");
    	}
    	if (StringUtils.isEmpty(setting.getDir())) {
    		throw new Exception("reportを設定してください。");
    	}
    	return setting;
	}
}
