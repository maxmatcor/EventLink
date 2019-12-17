package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.eventData;
import model.susData;

public class Sus {
	private static String FindAll = "Select * from eventos where estado='1'";
	private static String DontByUser =  "SELECT * FROM suscripciones";
	private static String ByUser =  "SELECT * FROM eventos p inner join suscripciones c on p.idevento=c.idevento where c.idusuario=? and p.estado='1' and c.estadoSus='1'";
	private static String Insert = "insert into suscripciones (idusuario,idevento,estadoSus)"
		+ " values (?, ?, '1')";
	private static String Delete = "Update suscripciones s inner join eventos e on (e.idevento=s.idevento) set s.estadoSus=?  where s.idevento=? and s.idusuario=?";
	Connection conn = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	public ArrayList<eventData> FindAll() {
		ArrayList<eventData> eventdatas = new ArrayList<eventData>();
		try {
			conn = Conexion.conexion();
			statement = conn.prepareStatement(FindAll);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idevento = resultSet.getInt("idevento");
				int idusuario = resultSet.getInt("idusuario");
				String nombreEve = resultSet.getString("nombre_eve");
				String lugarEve = resultSet.getString("lugar_eve");
				String tipoEve = resultSet.getString("tipo_eve");
				String fechaEve = resultSet.getString("fecha_eve");
				String fechaFinEve = resultSet.getString("fechaFin_eve");
				String descripcionEve = resultSet.getString("descripcion_eve");
				int status = resultSet.getInt("estado");
				eventData eventdata = new eventData(idevento, idusuario,
						nombreEve, lugarEve, tipoEve, fechaEve, fechaFinEve,
						descripcionEve, status);
				eventdatas.add(eventdata);

			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print("Error Al conectar Con El Servidor");
		}
		return eventdatas;
	}

	public ArrayList<eventData> findByUser(int idusuario) {
		ArrayList<eventData> eventdatas = new ArrayList<eventData>();
		try {
			conn = Conexion.conexion();
			statement = conn.prepareStatement(ByUser);
			statement.setInt(1, idusuario);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idevento = resultSet.getInt("idevento");
				int idusuariobd = resultSet.getInt("idusuario");
				String nombreEve = resultSet.getString("nombre_eve");
				String lugarEve = resultSet.getString("lugar_eve");
				String tipoEve = resultSet.getString("tipo_eve");
				String fechaEve = resultSet.getString("fecha_eve");
				String fechaFinEve = resultSet.getString("fechaFin_eve");
				String descripcionEve = resultSet.getString("descripcion_eve");
				int status = resultSet.getInt("estado");
				eventData eventdata = new eventData(idevento, idusuariobd,
						nombreEve, lugarEve, tipoEve, fechaEve, fechaFinEve,
						descripcionEve, status);
				eventdatas.add(eventdata);

			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return eventdatas;
	}


	public String ValidateSuscripcion(int idevent,int iduser) {
		try {
			conn = Conexion.conexion();
			statement = conn.prepareStatement(DontByUser);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int idevento = resultSet.getInt("idevento");
				int idusuariobd = resultSet.getInt("idusuario");
				int status = resultSet.getInt("estadoSus");
				if(idevento == idevent && idusuariobd == iduser && status==1){
					return "true";
				}
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.print(e);
					}
		return "false";
	}
	
	public void CreateSus(susData susdata) {
		
			try {
				// conexion
				Connection conn = null;
				conn = Conexion.conexion();
				// query

				// alta

					statement = conn.prepareStatement(Insert);
					statement.setInt(1, susdata.getIduser());
					statement.setInt(2, susdata.getIdevent());
				    statement.executeUpdate();
					statement.close();
					conn.close();
					
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.print(e);
				}	
				
	}
	
	public void DeleteSus(int ideve, int iduser) {
		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();
			//status = 2 de baja status = 1 de alta
			int status = 2;
				statement = conn.prepareStatement(Delete);
				statement.setInt(1, status);
				statement.setInt(2, ideve);
				statement.setInt(3, iduser);
			    statement.executeUpdate();
				statement.close();
				conn.close();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}	
	}

	

	private static Sus instance = null;

	private Sus() {
	}

	public static Sus getInstace() {
		if (instance == null) {
			instance = new Sus();
		}
		return instance;
	}

	public static void main(String[] args) {

	}

}
