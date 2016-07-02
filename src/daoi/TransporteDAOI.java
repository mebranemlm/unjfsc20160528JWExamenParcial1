package daoi;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

//import org.eclipse.persistence.internal.jpa.EJBQueryImpl;



import org.eclipse.persistence.internal.jpa.EJBQueryImpl;

import util.Conn;
import model.Marca;
import model.Modelo;
//import model.TipoModelo;
import model.TipoTransporte;
import model.Transporte;
import daol.TransporteDAOL;

public class TransporteDAOI implements TransporteDAOL {
	Conn cn = new Conn();
	

	@Override
	public void create(Transporte obj) throws Exception {
		cn.open();
		Transporte oTransporte=new Transporte();
		TipoTransporte oTipoTransporte=new TipoTransporte();
		Marca oMarca=new Marca();
		Modelo oModelo=new Modelo();
		//TipoModelo oTipoModelo=new TipoModelo();
		try 
		{
			oTransporte.setIdTransporte(obj.getIdTransporte());
			
			oTipoTransporte=cn.em.find(TipoTransporte.class, obj.getTipoTransporte().getIdTipoTransporte());
			oTransporte.setTipoTransporte(oTipoTransporte);
			
			oTransporte.setDescTransporte(obj.getDescTransporte());
			
			oTransporte.setCosto(obj.getCosto());
			
			oTransporte.setStock(obj.getStock());
			
			oModelo=cn.em.find(Modelo.class, obj.getModelo().getIdModelo());
			oTransporte.setModelo(oModelo);
			
			oMarca=cn.em.find(Marca.class, obj.getMarca().getIdMarca());
			oTransporte.setMarca(oMarca);
		
			oTransporte.setFechaRegistro(obj.getFechaRegistro());
			
			cn.em.getTransaction().begin();
			cn.em.persist(obj);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	@Override
	public List<Transporte> read() throws Exception{
		List<Transporte> trans=new ArrayList<Transporte>();
		
		String sql=	"select "
				+ "tr, "
				+ "tr.TipoTransporte.idTipoTransporte, "
				+ "tr.Modelo.idModelo, "
				+ "tr.Marca.idMarca "
				+ "from Transporte tr";
		Query q= cn.em.createQuery(sql);
		List<Object[]> otrans=q.getResultList();
		
		for(Object atran[]: otrans){
			Transporte ttran=(Transporte) atran[0];
			trans.add(ttran);
		}
		
		return trans;
		
	}
	
	@Override
	public void update(Transporte obj) throws Exception {
		cn.open();
		Transporte oTransporte=new Transporte();
		TipoTransporte oTipoTransporte=new TipoTransporte();
		Marca oMarca=new Marca();
		Modelo oModelo=new Modelo();
		//TipoModelo oTipoModelo=new TipoModelo();
		try 
		{
//			oTransporte.setIdTransporte(obj.getIdTransporte());
//			
//			oTipoTransporte=cn.em.find(TipoTransporte.class, obj.getTipoTransporte().getIdTipoTransporte());
//			oTransporte.setTipoTransporte(oTipoTransporte);
//			
//			oTransporte.setDescTransporte(obj.getDescTransporte());
//			
//			oTransporte.setCosto(obj.getCosto());
//			
//			oTransporte.setStock(obj.getStock());
//			
//			oModelo=cn.em.find(Modelo.class, obj.getModelo().getIdModelo());
//			oTransporte.setModelo(oModelo);
//			
//			oMarca=cn.em.find(Marca.class, obj.getMarca().getIdMarca());
//			oTransporte.setMarca(oMarca);
//		
//			oTransporte.setFechaRegistro(obj.getFechaRegistro());
			
			cn.em.getTransaction().begin();
			cn.em.merge(obj);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}


	@Override
	public void delete(Transporte obj) throws Exception {
		cn.open();
		System.out.println("Llegó Aquí---------------");
		Transporte oTransporte=new Transporte();
		try 
		{
			oTransporte.setIdTransporte(obj.getIdTransporte());
			oTransporte=cn.em.find(Transporte.class, oTransporte.getIdTransporte());
			
			cn.em.getTransaction().begin();
			cn.em.remove(oTransporte);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	@Override
	public Transporte get(Transporte obj) throws Exception {
		cn.open();
		Transporte oTransporte=new Transporte();
		try 
		{
			oTransporte=cn.em.find(Transporte.class, obj.getIdTransporte());
			System.out.println("Objeto: "+oTransporte);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return oTransporte;
	}
	
	
	
	@Override
	public List<Transporte> readByParameters(Transporte obj) throws Exception {
		cn.open();
		List<Transporte>trans=new ArrayList<Transporte>();
		try 
		{
			
			int idMarca=obj.getMarca().getIdMarca();
			System.out.println("idMarca: "+idMarca);
			Query q;
			String descTransporte='%'+ obj.getDescTransporte().toLowerCase()+'%';
			String sql="select "
					+ "tr, "
					+ "tr.TipoTransporte.idTipoTransporte, "
					+ "tr.Modelo.idModelo, "
					+ "tr.Marca.idMarca "
					+ "from Transporte tr where lower(tr.descTransporte) like :descTransporte";
			
			if(idMarca>0){
				sql=sql+" and tr.Marca.idMarca = :idMarca";
				q=cn.em.createQuery(sql);
				q.setParameter("descTransporte",descTransporte);
				q.setParameter("idMarca",idMarca);
			}else{
				q=cn.em.createQuery(sql);
				q.setParameter("descTransporte",descTransporte);
			}
			
			
			
			
			
			List<Object[]> otrans=q.getResultList();
			for(Object atran[]: otrans){
				Transporte ttran=(Transporte) atran[0];
				trans.add(ttran);
			}
			
			//q.unwrap()
			String oracle=q.unwrap(EJBQueryImpl.class).getDatabaseQuery().getSQLString();
			System.out.println("SENTENCIA: "+oracle);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return trans;
	}
	
//	@Override
//	public List<Marca> listarMarcas() throws Exception {
//		cn.open();
//		List<Marca>lista1=null;
//		try 
//		{
//			Query q1=cn.em.createQuery("select m from Marca m");
//			//q1.setParameter("p1",'%'+ obj.getDesc().toLowerCase()+'%');
//			lista1=q1.getResultList();
//			
//			
//			
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}
//		return lista1;
//	}
	
//	@Override
//	public List<Transporte> buscarListaPorNombre(Transporte obj) throws Exception {
//		cn.open();
//		List<Transporte>lista1=null;
//		try 
//		{
//			Query q1=cn.em.createQuery("select tr from Transporte tr where tr.descTransporte=:p1");
//			q1.setParameter("p1", obj.getDescTransporte());
//			lista1=q1.getResultList();
//			
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}
//		return lista1;
//	}

}
