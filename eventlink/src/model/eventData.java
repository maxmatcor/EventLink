package model;



public class eventData {

	int idevento;
	int idusuario;
	String nombre_eve;
	String lugar_eve;
	String tipo_eve;
	String fecha_eve;
	String fechaFin_eve;
	String descripcion_eve;
	int estado;
	
	public eventData(int idevento, int idusuario, String nombreEve,
			String lugarEve, String tipoEve, String fechaEve,
			String fechaFinEve, String descripcionEve, int status) {
		super();
		this.idevento = idevento;
		this.idusuario = idusuario;
		nombre_eve = nombreEve;
		lugar_eve = lugarEve;
		tipo_eve = tipoEve;
		fecha_eve = fechaEve;
		fechaFin_eve = fechaFinEve;
		descripcion_eve = descripcionEve;
		estado = status;
	}
	public eventData(int idusuario, String nombreEve, String lugarEve,
			String tipoEve, String fechaEve, String fechaFinEve,
			String descripcionEve, int status) {
		super();
		this.idusuario = idusuario;
		nombre_eve = nombreEve;
		lugar_eve = lugarEve;
		tipo_eve = tipoEve;
		fecha_eve = fechaEve;
		fechaFin_eve = fechaFinEve;
		descripcion_eve = descripcionEve;
		estado = status;
	}
	public int getIdevento() {
		return idevento;
	}
	public void setIdevento(int idevento) {
		this.idevento = idevento;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre_eve() {
		return nombre_eve;
	}
	public void setNombre_eve(String nombreEve) {
		nombre_eve = nombreEve;
	}
	public String getLugar_eve() {
		return lugar_eve;
	}
	public void setLugar_eve(String lugarEve) {
		lugar_eve = lugarEve;
	}
	public String getTipo_eve() {
		return tipo_eve;
	}
	public void setTipo_eve(String tipoEve) {
		tipo_eve = tipoEve;
	}
	public String getFecha_eve() {
		return fecha_eve;
	}
	public void setFecha_eve(String fechaEve) {
		fecha_eve = fechaEve;
	}
	public String getFechaFin_eve() {
		return fechaFin_eve;
	}
	public void setFechaFin_eve(String fechaFinEve) {
		fechaFin_eve = fechaFinEve;
	}
	public String getDescripcion_eve() {
		return descripcion_eve;
	}
	public void setDescripcion_eve(String descripcionEve) {
		descripcion_eve = descripcionEve;
	}

	public int getStatus() {
		return estado;
	}
	public void setestado(int status) {
		this.estado = status;
	}
}