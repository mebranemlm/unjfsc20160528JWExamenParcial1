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
	
	
//	@ManyToOne
//	@JoinColumn(name="idTipoTransporte")
//	private TipoTransporte tblTipoTransporte;
	private int idTipoTransporte;
	
	private String descTransporte;
	
	private double costo;
	
	private int stock;
	
//	@ManyToOne
//	@JoinColumn(name="idModelo")
//	private Modelo tblModelo;
	
	private int idModelo;
	
//	@ManyToOne
//	@JoinColumn(name="idMarca")
//	private Marca tblMarca;
	
	private int idMarca;
	
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

//	public Modelo getTblModelo() {
//		return tblModelo;
//	}
//
//	public void setTblModelo(Modelo tblModelo) {
//		this.tblModelo = tblModelo;
//	}
//
//	public Marca getTblMarca() {
//		return tblMarca;
//	}
//
//	public void setTblMarca(Marca tblMarca) {
//		this.tblMarca = tblMarca;
//	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getIdTipoTransporte() {
		return idTipoTransporte;
	}

	public void setIdTipoTransporte(int idTipoTransporte) {
		this.idTipoTransporte = idTipoTransporte;
	}

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	
}
