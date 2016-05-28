package daoi;

import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import util.Conn;
import model.TipoTransporte;
import model.Transporte;
import daol.TransporteDAOL;

public class TransporteDAOI implements TransporteDAOL {
	Conn cn = new Conn();
	
	@Override
	public Transporte buscarTransporte(Transporte obj) throws Exception {
		cn.open();
		Transporte objt=new Transporte();
		try 
		{
			obj=cn.em.find(Transporte.class, objt.getIdTransporte());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return obj;
	}

	@Override
	public void agregarTransporte(Transporte obj) throws Exception {
		cn.open();
		Transporte objt=new Transporte();
		try 
		{
			objt.setIdTransporte(obj.getIdTransporte());
			objt.setIdTipoTransporte(obj.getIdTipoTransporte());
			objt.setDescTransporte(obj.getDescTransporte());
			objt.setCosto(obj.getCosto());
			objt.setStock(obj.getStock());
			objt.setIdModelo(obj.getIdModelo());
			objt.setIdMarca(obj.getIdMarca());
			objt.setFechaRegistro(obj.getFechaRegistro());
			cn.em.getTransaction().begin();
			cn.em.persist(obj);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	@Override
	public void editarTransporte(Transporte obj) throws Exception {
		cn.open();
		Transporte objt=new Transporte();
		try 
		{
			objt.setIdTransporte(obj.getIdTransporte());
			objt.setIdTipoTransporte(obj.getIdTipoTransporte());
			objt.setDescTransporte(obj.getDescTransporte());
			objt.setCosto(obj.getCosto());
			objt.setStock(obj.getStock());
			objt.setIdModelo(obj.getIdModelo());
			objt.setIdMarca(obj.getIdMarca());
			objt.setFechaRegistro(obj.getFechaRegistro());
			cn.em.getTransaction().begin();
			cn.em.merge(obj);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	@Override
	public void eliminarTransporte(Transporte obj) throws Exception {
		cn.open();
		System.out.println("Llegó Aquí---------------");
		Transporte objt=new Transporte();
		try 
		{
			objt.setIdTransporte(obj.getIdTransporte());
		
			objt=cn.em.find(Transporte.class, objt.getIdTransporte());
//			objt.setIdTipoTransporte(obj.getIdTipoTransporte());
//			objt.setDescTransporte(obj.getDescTransporte());
//			objt.setCosto(obj.getCosto());
//			objt.setStock(obj.getStock());
//			objt.setIdModelo(obj.getIdModelo());
//			objt.setIdMarca(obj.getIdMarca());
//			objt.setFechaRegistro(obj.getFechaRegistro());
			
			cn.em.getTransaction().begin();
			cn.em.remove(objt);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	@Override
	public List<Transporte> buscarListaTransporte(Transporte obj) throws Exception {
		cn.open();
		List<Transporte>lista1=null;
		try 
		{
			Query q1=cn.em.createQuery("select tr from Transporte tr where tr.idTransporte=:p1");
			q1.setParameter("p1", obj.getIdTransporte());
			lista1=q1.getResultList();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return lista1;
	}
	
	

}
