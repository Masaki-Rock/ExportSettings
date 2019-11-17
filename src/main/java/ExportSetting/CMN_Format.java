package ExportSetting;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CMN_Format {

	final static Logger logger = LoggerFactory.getLogger(CMN_Format.class);
	
	private CMN_Setting setting = null;
	
	public CMN_Format(CMN_Setting setting) {
		this.setting = setting;
	}
	
	public void service() throws Exception {
		logger.info("main processing Start!!...");
		
		File dir1 = new File(this.setting.getSelenide());
		for (File f : dir1.listFiles()) {
			Document document = parse(f.getAbsolutePath());
			String csvs = fomat(document);
			CMN_File.writeFile(this.setting.getEvidence()  + CMN_File.sepStr() + f.getName(), csvs);
		}
		
		logger.info("main processing End...");
	}
	
	private Document parse(String path) throws IOException {
		logger.info("parse processing Start!!...");
		Document doc = null;
		doc = Jsoup.parse(new File(path), "SJIS");
		logger.debug("parse processing End...");
		return doc;
	}
	
	private String fomat(Document doc) {
		logger.info("fomat processing Start!!...");
		doc.select("img[src='/img/s.gif']").remove();
		doc.select("input[type='submit']").remove();
		doc.select("input[type='button']").remove();
		doc.select("span.help").remove();
		doc.select("a.help").remove();
		doc.select("a").forEach(b -> { 
			if (StringUtils.equals("[éQè∆]",b.text())) {b.remove();} 
			});
		Elements els = doc.select("table");
		logger.debug("fomat processing End...");
        return els.outerHtml();
	}
}
