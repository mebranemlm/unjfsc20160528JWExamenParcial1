package bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import daoi.MarcaDAOI;
import daoi.ModeloDAOI;
import daoi.TipoModeloDAOI;
import daoi.TipoTransporteDAOI;
import daoi.TransporteDAOI;
import model.Marca;
import model.Transporte;


public class TransporteBean {
	
	public TransporteDAOI oTransporteDAOI= new TransporteDAOI();
	public MarcaDAOI oMarcaDAOI = new MarcaDAOI();
	public ModeloDAOI oModeloDAOI = new ModeloDAOI();
	public TipoModeloDAOI oTipoModeloDAOI = new TipoModeloDAOI();
	public TipoTransporteDAOI oTipoTransporteDAOI = new TipoTransporteDAOI();
	
	
	public int idTransporte;
	public model.TipoTransporte TipoTransporte;
	public String descTransporte;
	public double costo;
	public int stock;
	public model.Modelo Modelo;
	public model.Marca Marca;
	public Date fechaRegistro;
	
	private List<Transporte> list;
	private List<model.Marca> listMarca;
	private List<model.Modelo> listModelo;
	private List<model.TipoModelo> listTipoModelo;
	private List<model.TipoTransporte> listTipoTransporte;
	
	private int list_size;
	private boolean sw_edit;
	
	Transporte obj=new Transporte();
	
	public void clean() throws Exception{
		Transporte oTransporte=new Transporte();
		obj=oTransporte;
	}
	
	public void cbos() throws Exception{
		listMarca=oMarcaDAOI.read();
		listModelo=oModeloDAOI.read();
		listTipoModelo=oTipoModeloDAOI.read();
		listTipoTransporte=oTipoTransporteDAOI.read();
	}
	
	public boolean actionAdd() throws Exception{
		sw_edit=false;
		clean();
		cbos();
		return sw_edit;
	}
	
	public boolean actionEdit() throws Exception{
		sw_edit=true;
		cbos();
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
	
	public void delete2(ActionEvent e) throws Exception {
		Transporte oTransporte=new Transporte();
		String codigo=e.getComponent().getAttributes().get("attr_idTransporte").toString();
		System.out.println("Codigo: "+ codigo);
		oTransporte.setIdTransporte(Integer.parseInt(codigo));
		oTransporteDAOI.delete(oTransporte);
		clear();
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
	
	public void clear(){
		setIdTransporte(0);
		setDescTransporte(null);
		setFechaRegistro(null);
		setCosto(0);
		setStock(0);
		
		model.TipoTransporte tt= new model.TipoTransporte();
		model.Modelo mo = new model.Modelo();
		Marca ma = new Marca();
		setMarca(ma);
		setTipoTransporte(tt);
		setModelo(mo);
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

	public List<model.Marca> getListMarca() {
		return listMarca;
	}

	public void setListMarca(List<model.Marca> listMarca) {
		this.listMarca = listMarca;
	}

	public List<model.Modelo> getListModelo() {
		return listModelo;
	}

	public void setListModelo(List<model.Modelo> listModelo) {
		this.listModelo = listModelo;
	}

	public List<model.TipoModelo> getListTipoModelo() {
		return listTipoModelo;
	}

	public void setListTipoModelo(List<model.TipoModelo> listTipoModelo) {
		this.listTipoModelo = listTipoModelo;
	}

	public List<model.TipoTransporte> getListTipoTransporte() {
		return listTipoTransporte;
	}

	public void setListTipoTransporte(List<model.TipoTransporte> listTipoTransporte) {
		this.listTipoTransporte = listTipoTransporte;
	}
	
	


	
}
