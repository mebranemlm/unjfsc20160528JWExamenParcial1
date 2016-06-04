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
@Table(name="Transporte")
public class Transporte {

	@Id
	private int idTransporte;
	
	
	@ManyToOne
	@JoinColumn(name="idTipoTransporte")
	private TipoTransporte TipoTransporte;
//	private int idTipoTransporte;
	
	private String descTransporte;
	
	private double costo;
	
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="idModelo")
	private Modelo Modelo;
	
//	private int idModelo;
	
	@ManyToOne
	@JoinColumn(name="idMarca")
	private Marca Marca;
	
	//private int idMarca;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

//	public TipoTransporte getTblTipoTransporte() {
//		return tblTipoTransporte;
//	}
//
//	public void setTblTipoTransporte(TipoTransporte tblTipoTransporte) {
//		this.tblTipoTransporte = tblTipoTransporte;
//	}

	public String getDescTransporte() {
		return descTransporte;
	}

	public void setDescTransporte(String descTransporte) {
		this.descTransporte = descTransporte;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public TipoTransporte getTipoTransporte() {
		return TipoTransporte;
	}

	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		TipoTransporte = tipoTransporte;
	}

	public Modelo getModelo() {
		return Modelo;
	}

	public void setModelo(Modelo modelo) {
		Modelo = modelo;
	}

	public Marca getMarca() {
		return Marca;
	}

	public void setMarca(Marca marca) {
		Marca = marca;
	}

	
	
	
}
