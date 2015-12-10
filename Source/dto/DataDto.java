package dto;

public class DataDto {
	
	private String 	TCID = null;
	private String ACTIONS = null;
	private String ID_TYPE = null;
	private String VALUE = null;
	private String DATA = null;
	private String 	TDID = null;
	private String SKUValue = null;
	private int QTY;
	//private String VALUE = null;
	
	
	
	public String getTCID() {
		return TCID;
	}
	public void setTCID(String tCID) {
		TCID = tCID;
	}
	public String getACTIONS() {
		return ACTIONS;
	}
	public void setACTIONS(String aCTIONS) {
		ACTIONS = aCTIONS;
	}
	public String getID_TYPE() {
		return ID_TYPE;
	}
	public void setID_TYPE(String iD_TYPE) {
		ID_TYPE = iD_TYPE;
	}
	public String getVALUE() {
		return VALUE;
	}
	public void setVALUE(String vALUE) {
		VALUE = vALUE;
	}
	public String getDATA() {
		return DATA;
	}
	public void setDATA(String dATA) {
		DATA = dATA;
	}
	public String getTDID() {
		return TDID;
	}
	public void setTDID(String tDID) {
		TDID = tDID;
	}
	public String getSKUValue() {
		return SKUValue;
	}
	public void setSKUValue(String sKUValue) {
		SKUValue = sKUValue;
	}
	public int getQTY() {
		return QTY;
	}
	public void setQTY(int qTY) {
		QTY = qTY;
	}
	
	
	
	
	
}
