package bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import daoi.TransporteDAOI;
import model.Marca;
import model.Transporte;


public class TransporteBean {
	
	public TransporteDAOI oTransporteDAOI= new TransporteDAOI();
	
	public int idTransporte;
	public model.TipoTransporte TipoTransporte;
	public String descTransporte;
	public double costo;
	public int stock;
	public model.Modelo Modelo;
	public model.Marca Marca;
	public Date fechaRegistro;
	
	private List<Transporte> list;
	private int list_size;
	private boolean sw_edit;
	
	Transporte obj=new Transporte();
	
	public boolean actionAdd(){
		sw_edit=false;
		return sw_edit;
	}
	
	public boolean actionEdit(){
		sw_edit=true;
		return sw_edit;
	}
	
	
	public void create() throws Exception {
		Transporte oTransporte=new Transporte();
		oTransporte.setIdTransporte(getIdTransporte());
		oTransporte.setTipoTransporte(getTipoTransporte());
		oTransporte.setDescTransporte(getDescTransporte());
		oTransporte.setCosto(getCosto());
		oTransporte.setStock(getStock());
		oTransporte.setModelo(getModelo());
		oTransporte.setMarca(getMarca());
		oTransporte.setFechaRegistro(getFechaRegistro());
		oTransporteDAOI.create(oTransporte);
	}
	
	public void read() throws Exception
	{

		List<Transporte> trans=oTransporteDAOI.read();
		list=trans;
		list_size=trans.size();
	}



	public void update() throws Exception {
		Transporte oTransporte=new Transporte();
		oTransporte.setIdTransporte(getIdTransporte());
		oTransporte.setTipoTransporte(getTipoTransporte());
		oTransporte.setDescTransporte(getDescTransporte());
		oTransporte.setCosto(getCosto());
		oTransporte.setStock(getStock());
		oTransporte.setModelo(getModelo());
		oTransporte.setMarca(getMarca());
		oTransporte.setFechaRegistro(getFechaRegistro());
		oTransporteDAOI.update(oTransporte);
	}
	
	
	public void delete() throws Exception {
		Transporte oTransporte=new Transporte();
		oTransporte.setIdTransporte(getIdTransporte());
		oTransporteDAOI.delete(oTransporte);	
	}
	
	public void readByParameters() throws Exception
	{
		Transporte oTransporte=new Transporte();
		
		oTransporte.setDescTransporte(getDescTransporte());
		oTransporte.setMarca(getMarca());
		list=oTransporteDAOI.readByParameters(oTransporte);
		//list=oTransporteDAOI.buscarListaTransporte(objt);
		list_size=list.size();
	}
	
	public void get() throws Exception{
		Transporte oTransporte=new Transporte();
		oTransporte.setIdTransporte(getIdTransporte());
		obj=oTransporteDAOI.get(oTransporte);
	}
	
	

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

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

	public model.TipoTransporte getTipoTransporte() {
		return TipoTransporte;
	}

	public void setTipoTransporte(model.TipoTransporte tipoTransporte) {
		TipoTransporte = tipoTransporte;
	}

	public model.Modelo getModelo() {
		return Modelo;
	}

	public void setModelo(model.Modelo modelo) {
		Modelo = modelo;
	}

	public Transporte getObj() {
		return obj;
	}

	public void setObj(Transporte obj) {
		this.obj = obj;
	}

	public Marca getMarca() {
		return Marca;
	}

	public void setMarca(Marca marca) {
		Marca = marca;
	}

	public List<Transporte> getList() {
		return list;
	}

	public void setList(List<Transporte> list) {
		this.list = list;
	}

	public int getList_size() {
		return list_size;
	}

	public void setList_size(int list_size) {
		this.list_size = list_size;
	}

	public boolean isSw_edit() {
		return sw_edit;
	}

	public void setSw_edit(boolean sw_edit) {
		this.sw_edit = sw_edit;
	}

	@PostConstruct
	public void init() {
	    TipoTransporte=new model.TipoTransporte();
	    Modelo = new model.Modelo();
	    Marca = new Marca();
	    
	}


	
}
