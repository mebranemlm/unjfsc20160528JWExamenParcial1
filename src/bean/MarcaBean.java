package bean;

import java.util.Date;
import java.util.List;

import daoi.MarcaDAOI;
import model.Marca;

public class MarcaBean {

	MarcaDAOI oMarcaDaoi= new MarcaDAOI();
	
	public int idMarca;
	public String descMarca;
	public Date fechaRegistro;
	
	private List<Marca> list;
	
	public void read() throws Exception{
		list=oMarcaDaoi.read();
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getDescMarca() {
		return descMarca;
	}

	public void setDescMarca(String descMarca) {
		this.descMarca = descMarca;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Marca> getList() {
		return list;
	}

	public void setList(List<Marca> list) {
		this.list = list;
	}
	
	
}
