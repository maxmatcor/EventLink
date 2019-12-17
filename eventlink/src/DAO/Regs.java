package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.eventData;
import model.userData;

public class Regs {
	private static String FindAll = "Select * from usuarios";
	private static String ByUser = "Select * from usuarios where usuario=?";
	private static String FindByUser = "Select * from usuarios where idusuario=?";
	private static String Insert = "insert into usuarios (usuario,contraseña,rol,correo,estadoUser)"
			+ " values (?,?,?,?,'1')";
	private static String Update = "Update usuarios set usuario=?,contraseña=?,correo=? where idusuario=?";
	private static String UpdateAdmin = "Update usuarios set usuario=?,contraseña=?,correo=?,estadoUser=?, rol=? where idusuario=?";
	private static String Delete = "Update usuarios set estadoUser=? where idUsuario=?";
	private static String RealDelete = "Delete from usuarios where idusuario=?";
	Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	public userData findByUser(int idusuario) {
		ArrayList<userData> userdatas = new ArrayList<userData>();
		try {
			conn = Conexion.conexion();
			statement = conn.prepareStatement(FindByUser);
			statement.setInt(1, idusuario);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int idusuariobd = resultSet.getInt("idusuario");
				String nombredb = resultSet.getString("usuario");
				String roledb = resultSet.getString("rol");
				String passdb = resultSet.getString("contraseña");
				String emaildb = resultSet.getString("correo");
				int status = resultSet.getInt("estadoUser");
				userData userdata = new userData(idusuariobd, nombredb, passdb,
						roledb, emaildb, status);
				userdatas.add(userdata);

			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return userdatas.get(0);
	}

	public ArrayList<userData> findAll() {
		ArrayList<userData> userdatas = new ArrayList<userData>();
		try {
			conn = Conexion.conexion();
			statement = conn.prepareStatement(FindAll);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				int idusuariobd = resultSet.getInt("idusuario");
				String nombredb = resultSet.getString("usuario");
				String roledb = resultSet.getString("rol");
				String passdb = resultSet.getString("contraseña");
				String emaildb = resultSet.getString("correo");
				int status = resultSet.getInt("estadoUser");
				userData userdata = new userData(idusuariobd, nombredb, passdb,
						roledb, emaildb, status);
				userdatas.add(userdata);

			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return userdatas;
	}

	public String CreateUser(userData userdata) {
		String result = "ok";
		int result2 = 1;
		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();
			// query
			String username = userdata.getUser();
			statement = conn.prepareStatement(ByUser);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				String userbd = resultSet.getString("usuario");

				if (userbd.equals(username)) {
					result2 = 0;
				}
			}
			if (result2 == 1) {

				// alta

				statement = conn.prepareStatement(Insert);
				statement.setString(1, username);
				statement.setString(2, userdata.getPass());
				statement.setString(3, userdata.getRole());
				statement.setString(4, userdata.getEmeil());
				statement.executeUpdate();
				statement.close();
				conn.close();
			} else {
				result = "error";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return result;
	}

	public String DeleteUser(int iduser) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();
			// status = 2 de baja status = 1 de alta
			int status = 2;
			statement = conn.prepareStatement(Delete);
			statement.setInt(1, status);
			statement.setInt(2, iduser);
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();
			
			if(valres==0){
			result = "error";}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return result;
	}

	public String RealDeleteUser(int iduser) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();

			statement = conn.prepareStatement(RealDelete);
			statement.setInt(1, iduser);
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();
			
			if(valres==0){
			result = "error";
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return result;
	}

	public String UpdateUser(userData userdata) {
		String result = null;

		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();
			statement = conn.prepareStatement(Update);
			statement.setString(1, userdata.getUser());
			statement.setString(2, userdata.getPass());
			statement.setString(3, userdata.getEmeil());
			statement.setInt(4, userdata.getIduser());
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();

		if(valres==0){
			result="error";
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}

		return result;
	}

	public String UpdateUserAdmin(userData userdata) {
		String result = null;

		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();
			statement = conn.prepareStatement(UpdateAdmin);
			statement.setString(1, userdata.getUser());
			statement.setString(2, userdata.getPass());
			statement.setString(3, userdata.getEmeil());
			statement.setInt(4, userdata.getStatusUser());
			statement.setString(5, userdata.getRole());
			statement.setInt(6, userdata.getIduser());
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();
			
			if(valres==0){
			result = "null";}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}

		return result;
	}

	private static Regs instance = null;

	private Regs() {
	}

	public static Regs getInstace() {
		if (instance == null) {
			instance = new Regs();
		}
		return instance;
	}

	public static void main(String[] args) {
		Regs users = Regs.getInstace();
	}

}
