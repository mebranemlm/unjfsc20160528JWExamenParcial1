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
@Table(name="TipoTransporte")
public class TipoTransporte {
	
	@Id
	private int idTipoTransporte;
	
	private String descTipoTransporte;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
//	@OneToMany(mappedBy="tblTipoTransporte")
//	private List<Transporte>tblTransporte;

	public int getIdTipoTransporte() {
		return idTipoTransporte;
	}

	public void setIdTipoTransporte(int idTipoTransporte) {
		this.idTipoTransporte = idTipoTransporte;
	}

	public String getDescTipoTransporte() {
		return descTipoTransporte;
	}

	public void setDescTipoTransporte(String descTipoTransporte) {
		this.descTipoTransporte = descTipoTransporte;
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
	

}
