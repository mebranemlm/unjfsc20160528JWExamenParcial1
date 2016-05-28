package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Modelo")
public class Modelo {
	
	@Id
	private int idModelo;
	
	@ManyToOne
	@JoinColumn(name="idTipoModelo")
	private TipoModelo tblTipoModelo;
	
	private String descModelo;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	public TipoModelo getTblTipoModelo() {
		return tblTipoModelo;
	}

	public void setTblTipoModelo(TipoModelo tblTipoModelo) {
		this.tblTipoModelo = tblTipoModelo;
	}

	public String getDescModelo() {
		return descModelo;
	}

	public void setDescModelo(String descModelo) {
		this.descModelo = descModelo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
	

}
