package ExportSetting;

import java.io.File;

public class CMN_Setting {

	private String serverurl = "";
	private String uid = "";
	private String pw = "";
	private String dir = "";
	private String capturelist = "";
	public String getServerurl() {
		return serverurl;
	}
	public void setServerurl(String serverurl) {
		this.serverurl = serverurl;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getDir() {
		return dir;
	}
	public String getSelenide() {
		String path = dir + CMN_File.sepStr() + "Selenide";
		File d = new File(path);
		if (!d.exists() || !d.isDirectory()) {
			d.mkdirs();
		}
		return path;
	}
	public String getEvidence() {
		String path = dir + CMN_File.sepStr() + "Evidence";
		File d = new File(path);
		if (!d.exists() || !d.isDirectory()) {
			d.mkdirs();
		}
		return path;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getCapturelist() {
		return capturelist;
	}
	public void setCapturelist(String capturelist) {
		this.capturelist = capturelist;
	}
	
	
}
