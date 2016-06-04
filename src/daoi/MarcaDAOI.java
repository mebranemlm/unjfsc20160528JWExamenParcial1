package daoi;

import java.util.List;

import util.Conn;
import model.Marca;
import daol.MarcaDAOL;

public class MarcaDAOI implements MarcaDAOL {

	Conn cn =new Conn();
	
	@Override
	public List<Marca> read() throws Exception {
		cn.open();
		List<Marca> marcs=cn.em.createQuery("select m from Marca m").getResultList();
		System.out.println("Llegó a ver listar marca");
		return marcs;
	}

}
