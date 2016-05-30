package daoi;

import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import util.Conn;
import model.Marca;
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
			objt=cn.em.find(Transporte.class, obj.getIdTransporte());
			System.out.println("Objeto: "+objt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return objt;
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
			
			int idMarca=obj.getIdMarca();
			Query q1;
			String descTransporte='%'+ obj.getDescTransporte().toLowerCase()+'%';
			String sql1="select tr from Transporte tr where lower(tr.descTransporte) like :p1";
			if(idMarca>0){
				sql1=sql1+" and tr.idMarca = :p2";
				q1=cn.em.createQuery(sql1);
				q1.setParameter("p1",descTransporte);
				q1.setParameter("p2",idMarca);
			}else{
				q1=cn.em.createQuery(sql1);
				q1.setParameter("p1",descTransporte);
			}
			
			
			System.out.println("ID de la Marca: "+idMarca);
			//String sql2="select tr, tt.descTipoTransporte, mo.descModelo, tm.descTipoModelo, ma.descMarca from Transporte tr inner join TipoTransporte tt on lower(tr.descTransporte) like :p1 tr.idTipoTransporte=tt.idTipoTransporte inner join Modelo mo on tr.idModelo=mo.idModelo inner join TipoModelo tm on mo.idTipoModelo=tm.idTipoModelo inner join Marca ma on tr.idMarca=ma.idMarca order by 1";
			//String sql3="select tr, tt , mo , tm , ma from Transporte tr inner join TipoTransporte tt on lower(tr.descTransporte) like :p1 tr.idTipoTransporte=tt.idTipoTransporte inner join Modelo mo on tr.idModelo=mo.idModelo inner join TipoModelo tm on mo.idTipoModelo=tm.idTipoModelo inner join Marca ma on tr.idMarca=ma.idMarca order by 1";

			
			
			
			lista1=q1.getResultList();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return lista1;
	}
	
	@Override
	public List<Marca> listarMarcas() throws Exception {
		cn.open();
		List<Marca>lista1=null;
		try 
		{
			Query q1=cn.em.createQuery("select m from Marca m");
			//q1.setParameter("p1",'%'+ obj.getDesc().toLowerCase()+'%');
			lista1=q1.getResultList();
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return lista1;
	}
	
	@Override
	public List<Transporte> buscarListaPorNombre(Transporte obj) throws Exception {
		cn.open();
		List<Transporte>lista1=null;
		try 
		{
			Query q1=cn.em.createQuery("select tr from Transporte tr where tr.descTransporte=:p1");
			q1.setParameter("p1", obj.getDescTransporte());
			lista1=q1.getResultList();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return lista1;
	}

}
