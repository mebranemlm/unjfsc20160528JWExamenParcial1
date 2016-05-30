package bean;

import java.util.Date;
import java.util.List;

import daoi.TransporteDAOI;
import model.Marca;
import model.Transporte;


public class TransporteBean {
	public int idTransporte;
	public int idTipoTransporte;
	public String descTransporte;
	public double costo;
	public int stock;
	public int idModelo;
	public int idMarca;
	public Date fechaRegistro;
	
	
	public TransporteDAOI trdaoi= new TransporteDAOI();
	private List<Transporte> listaTransportes;
	private List<Marca> listaMarcas;
	private int tamano_lista;
	private boolean accion_modificar;
	private Marca marca;
	
	Transporte obj=new Transporte();
	
	public boolean accion_agrega(){
		accion_modificar=false;
		return accion_modificar;
	}
	
	public boolean accion_modifica(){
		accion_modificar=true;
		return accion_modificar;
	}
	
	
	public void agregarTransporte() throws Exception {
		Transporte otr=new Transporte();
		otr.setIdTransporte(getIdTransporte());
		otr.setIdTipoTransporte(getIdTipoTransporte());
		otr.setDescTransporte(getDescTransporte());
		otr.setCosto(getCosto());
		otr.setStock(getStock());
		otr.setIdModelo(getIdModelo());
		otr.setIdMarca(getIdMarca());
		otr.setFechaRegistro(getFechaRegistro());
		trdaoi.agregarTransporte(otr);
	}

	public void modificarTransporte() throws Exception {
		Transporte otr=new Transporte();
		otr.setIdTransporte(getIdTransporte());
		otr.setIdTipoTransporte(getIdTipoTransporte());
		otr.setDescTransporte(getDescTransporte());
		otr.setCosto(getCosto());
		otr.setStock(getStock());
		otr.setIdModelo(getIdModelo());
		otr.setIdMarca(getIdMarca());
		otr.setFechaRegistro(getFechaRegistro());
		trdaoi.editarTransporte(otr);
	}
	
	
	public void eliminarTransporte() throws Exception {
		Transporte otr=new Transporte();
		otr.setIdTransporte(getIdTransporte());
//		otr.setIdTipoTransporte(getIdTipoTransporte());
//		otr.setDescTransporte(getDescTransporte());
//		otr.setCosto(getCosto());
//		otr.setStock(getStock());
//		otr.setIdModelo(getIdModelo());
//		otr.setIdMarca(getIdMarca());
//		otr.setFechaRegistro(getFechaRegistro());
		trdaoi.eliminarTransporte(otr);
	}
	
	public void buscarlistaTransportes() throws Exception
	{
		Transporte objt=new Transporte();
		int idTransporte=getIdTransporte();
		System.out.println("idTransporte: "+idTransporte);
		objt.setIdTransporte(idTransporte);
		objt=trdaoi.buscarTransporte(objt);
		listaTransportes=trdaoi.buscarListaTransporte(objt);
		tamano_lista=listaTransportes.size();
	}
	
	public void buscarListaPorNombres()throws Exception{
	
		Transporte objt=new Transporte();
		String descTransporte=getDescTransporte();
		System.out.println("DescTransporte: "+descTransporte);
		objt.setDescTransporte(descTransporte);
		objt.setIdMarca(getIdMarca());
		//objt=trdaoi.buscarListaPorNombre(objt);
		listaTransportes=trdaoi.buscarListaTransporte(objt);
		tamano_lista=listaTransportes.size();
	}
	
	public void listarMarcas()throws Exception{
		System.out.println("Llegó a la función listar Marcas del Bean.");
		listaMarcas=trdaoi.listarMarcas();
		
		System.out.println("Se han encontrado "+listaMarcas.size()+ " marcas.");
		for (int i = 0; i < listaMarcas.size(); i++) {
			int id=listaMarcas.get(i).getIdMarca();
			String desc=listaMarcas.get(i).getDescMarca();
			System.out.println("Codigo: "+id + "\t Desc: "+desc);
		}
		
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

	public TransporteDAOI getTrdaoi() {
		return trdaoi;
	}

	public void setTrdaoi(TransporteDAOI trdaoi) {
		this.trdaoi = trdaoi;
	}

	public List<Transporte> getListaTransportes() {
		return listaTransportes;
	}

	public void setListaTransportes(List<Transporte> listaTransportes) {
		this.listaTransportes = listaTransportes;
	}

	public int getTamano_lista() {
		return tamano_lista;
	}

	public void setTamano_lista(int tamano_lista) {
		this.tamano_lista = tamano_lista;
	}

	public boolean isAccion_modificar() {
		return accion_modificar;
	}

	public void setAccion_modificar(boolean accion_modificar) {
		this.accion_modificar = accion_modificar;
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

	public Transporte getObj() {
		return obj;
	}

	public void setObj(Transporte obj) {
		this.obj = obj;
	}

	public List<Marca> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaMarcas(List<Marca> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	
}
