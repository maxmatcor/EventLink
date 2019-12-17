package model;

public class userData {
	
	int iduser;
	String user;
	String pass;
	String role;
	String emeil;
	int statusUser;
	
	
	
	public userData(int iduser, String user, String role) {
		super();
		this.iduser = iduser;
		this.user = user;
		this.role = role;
	}

	public userData(int iduser, String user, String pass, String role) {
		super();
		this.iduser = iduser;
		this.user = user;
		this.pass = pass;
		this.role = role;
	}

	public userData(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}

	public userData(String user, String pass, String role, int statusUser) {
		super();
		this.user = user;
		this.pass = pass;
		this.role = role;
		this.statusUser = statusUser;
	}
	
	public userData(int iduser, String user, String pass, String role,
			String emeil, int statusUser) {
		super();
		this.iduser = iduser;
		this.user = user;
		this.pass = pass;
		this.role = role;
		this.emeil = emeil;
		this.statusUser = statusUser;
	}
	public userData(String user, String pass, String role, String emeil,
			int statusUser) {
		super();
		this.user = user;
		this.pass = pass;
		this.role = role;
		this.emeil = emeil;
		this.statusUser = statusUser;
	}


	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmeil() {
		return emeil;
	}
	public void setEmeil(String emeil) {
		this.emeil = emeil;
	}
	public int getStatusUser() {
		return statusUser;
	}
	public void setStatusUser(int statusUser) {
		this.statusUser = statusUser;
	}
	
	}
