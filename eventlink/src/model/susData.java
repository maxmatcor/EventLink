package model;

public class susData {

	int idsus;
	int iduser;
	int idevent;
	int statusSus;
	
	
	
	
	public susData(int iduser, int idevent, int statusSus) {
		super();
		this.iduser = iduser;
		this.idevent = idevent;
		this.statusSus = statusSus;
	}
	public susData(int idsus, int iduser, int idevent, int statusSus) {
		super();
		this.idsus = idsus;
		this.iduser = iduser;
		this.idevent = idevent;
		this.statusSus = statusSus;
	}
	public int getIdsus() {
		return idsus;
	}
	public void setIdsus(int idsus) {
		this.idsus = idsus;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public int getIdevent() {
		return idevent;
	}
	public void setIdevent(int idevent) {
		this.idevent = idevent;
	}
	public int getStatusSus() {
		return statusSus;
	}
	public void setStatusSus(int statusSus) {
		this.statusSus = statusSus;
	}

	
	
}
