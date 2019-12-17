package DAO;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import model.eventData;
import model.userData;

public class Login {

	private static String FindAll = "Select * from usuarios";

	public String LoginUser(userData userdata) {

		String userName = userdata.getUser();
		String password = userdata.getPass();

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String userNameDB = "";
		String passwordDB = "";
		String roleDB = "";

		try {
			con = Conexion.conexion();
			statement = con.createStatement();
			resultSet = statement.executeQuery(FindAll);

			while (resultSet.next()) {
				userNameDB = resultSet.getString("usuario");
				passwordDB = resultSet.getString("contraseña");
				roleDB = resultSet.getString("rol");
				int status = resultSet.getInt("estadoUser");
			int	iduser = resultSet.getInt("idusuario");
				if (userName.equals(userNameDB) && password.equals(passwordDB)
						&& roleDB.equals("admin")&& status==1)
					return "Admin_Role-"+iduser;
				else if (userName.equals(userNameDB)
						&& password.equals(passwordDB)
						&& roleDB.equals("editor") && status==1)
					return "Editor_Role-"+iduser;
				else if (userName.equals(userNameDB)
						&& password.equals(passwordDB) && roleDB.equals("user") && status==1)
					return "User_Role-"+iduser;
			} 
		} catch (SQLException e) {
			System.err.print(e);
		}
		return "null";
	}

	private static Login instance = null;

	public Login() {
	}

	public static Login getInstace() {
		if (instance == null) {
			instance = new Login();
		}
		return instance;
	}

	public static void main(String[] args) {

	}

}
