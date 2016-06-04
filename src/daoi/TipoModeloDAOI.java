package daoi;

import java.util.List;

import util.Conn;
import model.TipoModelo;
import daol.TipoModeloDAOL;

public class TipoModeloDAOI implements TipoModeloDAOL{

	Conn cn =  new Conn();
	@Override
	public List<TipoModelo> read() throws Exception {
		// TODO Auto-generated method stub
		cn.open();
		return cn.em.createQuery("select m from TipoModelo m").getResultList();
	}

}
