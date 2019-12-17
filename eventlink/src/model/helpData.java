package model;

public class helpData {

	int idhelp;
	int iduser;
	String descHelp;
	int StatusHelp;
	
	
	
	
	public helpData(int iduser, String descHelp, int statusHelp) {
		super();
		this.iduser = iduser;
		this.descHelp = descHelp;
		StatusHelp = statusHelp;
	}
	public helpData(int idhelp, int iduser, String descHelp, int statusHelp) {
		super();
		this.idhelp = idhelp;
		this.iduser = iduser;
		this.descHelp = descHelp;
		StatusHelp = statusHelp;
	}
	public int getIdhelp() {
		return idhelp;
	}
	public void setIdhelp(int idhelp) {
		this.idhelp = idhelp;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getDescHelp() {
		return descHelp;
	}
	public void setDescHelp(String descHelp) {
		this.descHelp = descHelp;
	}
	public int getStatusHelp() {
		return StatusHelp;
	}
	public void setStatusHelp(int statusHelp) {
		StatusHelp = statusHelp;
	}
	
}
