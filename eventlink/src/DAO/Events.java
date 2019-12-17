package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import model.eventData;
import model.userData;

public class Events {
	private static String FindAll = "Select * from eventos";
	private static String FindById = "Select * from eventos where idevento=?";
	private static String ByUser = "Select * from eventos where idusuario=? and estado='1'";
	private static String Insert = "insert into eventos (idusuario,nombre_eve,lugar_eve,tipo_eve,fecha_eve,fechaFin_eve,descripcion_eve, estado)"
			+ " values (?, ?, ?, ?,?, ?, ?, '1')";
	private static String Update = "Update eventos set idusuario=?,nombre_eve=?,lugar_eve=?,tipo_eve=?,fecha_eve=?,fechaFin_eve=?,descripcion_eve=?,estado=? where idevento=?";
	private static String Delete = "Update eventos set estado=? where idevento=?";
	private static String RealDelete = "Delete from eventos where idevento=?";
	private static String BySuscripcion = "Select * from usuarios p inner join suscripciones s on p.idusuario=s.idusuario where s.idevento=? and s.estadoSus='1'";

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
			System.err.print(e);
		}
		return eventdatas;
	}

	public ArrayList<userData> FindBySus(int idevent) {
		ArrayList<userData> userdatas = new ArrayList<userData>();
		try {
			conn = Conexion.conexion();
			statement = conn.prepareStatement(BySuscripcion);
			statement.setInt(1, idevent);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int iduser = resultSet.getInt("idusuario");
				String user = resultSet.getString("usuario");
				String role = resultSet.getString("rol");
				userData userdata = new userData(iduser, user, role);
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

	public eventData findById(int idevento) {
		ArrayList<eventData> eventdatas = new ArrayList<eventData>();
		try {
			conn = Conexion.conexion();
			statement = conn.prepareStatement(FindById);
			statement.setInt(1, idevento);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("idevento");
				int idusuario = resultSet.getInt("idusuario");
				String nombreEve = resultSet.getString("nombre_eve");
				String lugarEve = resultSet.getString("lugar_eve");
				String tipoEve = resultSet.getString("tipo_eve");
				String fechaEve = resultSet.getString("fecha_eve");
				String fechaFinEve = resultSet.getString("fechaFin_eve");
				String descripcionEve = resultSet.getString("descripcion_eve");
				int status = resultSet.getInt("estado");
				eventData eventdata = new eventData(id, idusuario, nombreEve,
						lugarEve, tipoEve, fechaEve, fechaFinEve,
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
		return eventdatas.get(0);
	}

	public String CreateEvent(eventData eventdata) {
		String result = null;

		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();
			// query

			// alta

			statement = conn.prepareStatement(Insert);
			statement.setInt(1, eventdata.getIdusuario());
			statement.setString(2, eventdata.getNombre_eve());
			statement.setString(3, eventdata.getLugar_eve());
			statement.setString(4, eventdata.getTipo_eve());
			statement.setString(5, eventdata.getFecha_eve());
			statement.setString(6, eventdata.getFechaFin_eve());
			statement.setString(7, eventdata.getDescripcion_eve());
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();

			if (valres == 0) {
				result = "error";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print("Error Al conectar Con El Servidor");
		}

		return result;
	}

	public String DeleteEvent(int idevento) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();
			// status = 2 de baja status = 1 de alta
			int status = 2;
			statement = conn.prepareStatement(Delete);
			statement.setInt(1, status);
			statement.setInt(2, idevento);
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();

			if (valres == 0) {
				result = "error";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return result;
	}

	public String RealDeleteEvent(int idevento) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();

			statement = conn.prepareStatement(RealDelete);
			statement.setInt(1, idevento);
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();
			if (valres == 0) {
				result = "error";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}
		return result;
	}

	public String UpdateEvent(int idevento, eventData eventdata) {
		String result = null;
		try {
			// conexion
			Connection conn = null;
			conn = Conexion.conexion();
			statement = conn.prepareStatement(Update);
			statement.setInt(1, eventdata.getIdusuario());
			statement.setString(2, eventdata.getNombre_eve());
			statement.setString(3, eventdata.getLugar_eve());
			statement.setString(4, eventdata.getTipo_eve());
			statement.setString(5, eventdata.getFecha_eve());
			statement.setString(6, eventdata.getFechaFin_eve());
			statement.setString(7, eventdata.getDescripcion_eve());
			statement.setInt(8, eventdata.getStatus());
			statement.setInt(9, eventdata.getIdevento());
			int valres = statement.executeUpdate();
			statement.close();
			conn.close();

			if (valres == 0) {
				result = "error";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.print(e);
		}

		return result;
	}

	private static Events instance = null;

	private Events() {
	}

	public static Events getInstace() {
		if (instance == null) {
			instance = new Events();
		}
		return instance;
	}

	public static void main(String[] args) {
		Events event = Events.getInstace();
		ArrayList<eventData> eventdatas = event.FindAll();
		System.out.println(eventdatas);
	}

}
