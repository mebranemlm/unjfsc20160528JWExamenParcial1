package daol;

import java.util.List;

import model.Transporte;

public interface TransporteDAOL {
	
	//public abstract Transporte validarTransporte(Transporte obj) throws Exception;
	public abstract Transporte buscarTransporte(Transporte obj) throws Exception;
	public abstract void agregarTransporte(Transporte obj) throws Exception;
	public abstract void editarTransporte(Transporte obj) throws Exception;
	public abstract void eliminarTransporte(Transporte obj) throws Exception;
	public abstract List<Transporte> buscarListaTransporte(Transporte obj) throws Exception;

}
