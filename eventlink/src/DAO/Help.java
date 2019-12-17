package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;


import model.helpData;

public class Help {
	private static String FindAll = "Select * from ayuda";
	private static String FindById = "Select * from ayuda where idayuda=?";
	private static String ByUser =  "Select * from ayuda where idusuario=? and estadoAyu='1'";
	private static String Insert = "insert into ayuda (idusuario,descripcion_ayu,estadoAyu)"
		+ " values (?, ?, '1')";
	private static String Delete = "Update ayuda set estadoAyu=? where idayuda=?";
	Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	public ArrayList<helpData> FindAll() {
		ArrayList<helpData> helpdatas = new ArrayList<helpData>(); //VIENE CON EL HELPDATA
		try {
			conn = Conexion.conexion();
			statement = conn.prepareStatement(FindAll);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idhelp = resultSet.getInt("idayuda");
				int idusuario = resultSet.getInt("idusuario");
				String descHelp = resultSet.getString("descripcion_Ayu");
				int status = resultSet.getInt("estadoAyu");
				helpData helpdata = new helpData(idhelp, idusuario,descHelp, status);
				helpdatas.add(helpdata);

			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print("e");
		}
		return helpdatas;
	}

	public ArrayList<helpData> findByUser(int idusuario) { // VIENE CON EL FINDBYUSER - BUSCA POR USUARIO
		ArrayList<helpData> helpdatas = new ArrayList<helpData>();
		try {
			conn = Conexion.conexion();
			statement = conn.prepareStatement(ByUser);
			statement.setInt(1, idusuario);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idhelp = resultSet.getInt("idayuda");
				int idusuariodb = resultSet.getInt("idusuario");
				String descHelp = resultSet.getString("descripcion_Ayu");
				int status = resultSet.getInt("estadoAyu");
				helpData helpdata = new helpData(idhelp, idusuariodb,descHelp, status);
				helpdatas.add(helpdata);
		helpdatas.add(helpdata);

			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print("e");
		}
		return helpdatas;
	}
	
	public String CreateHelp(helpData helpdata) { // VIENE POR EL ALTA DE AYUDA
		String result = null;
		
			try {
				// conexion
				Connection conn = null;
				conn = Conexion.conexion();
				// query

				// alta

					statement = conn.prepareStatement(Insert);
					statement.setInt(1, helpdata.getIduser());
					statement.setString(2, helpdata.getDescHelp());
				int	valres = statement.executeUpdate();
					statement.close();
					conn.close();
					if (valres==0){
						result="error";
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.print(e);
			}
			
	return result;
	}
	
	public String DeleteHelp(int idhelp) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();
			//status = 2 de baja status = 1 de alta
			int status = 2;
				statement = conn.prepareStatement(Delete);
				statement.setInt(1, status);
				statement.setInt(2, idhelp);
			int	valres = statement.executeUpdate();
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

	private static Help instance = null;

	private Help() {
	}

	public static Help getInstace() {
		if (instance == null) {
			instance = new Help();
		}
		return instance;
	}

	public static void main(String[] args) {	}


}
