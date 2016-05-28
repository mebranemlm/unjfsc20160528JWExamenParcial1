package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Marca")
public class Marca {
	@Id
	private int idMarca;
	
	private String descMarca;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
//	@OneToMany(mappedBy="tblMarca")
//	private List<Transporte>tblTransporte;

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

//	public List<Transporte> getTblTransporte() {
//		return tblTransporte;
//	}
//
//	public void setTblTransporte(List<Transporte> tblTransporte) {
//		this.tblTransporte = tblTransporte;
//	}
//	
//	
	
	

}
