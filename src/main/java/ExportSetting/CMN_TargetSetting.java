package ExportSetting;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class CMN_TargetSetting {

	@CsvBindByName(column = "Category2")
	private String category1;
	@CsvBindByName(column = "Category2")
	private String category2;
	@CsvBindByName(column = "Function")
	private String label;
	@CsvBindByName(column = "Type", required = true)
	private String type;
	@CsvBindByName(column = "Name", required = true)
	private String developername;
	@CsvBindByName(column = "Context", required = true)
	private String context;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDevelopername() {
		return developername;
	}

	public void setDevelopername(String developername) {
		this.developername = developername;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	
}
