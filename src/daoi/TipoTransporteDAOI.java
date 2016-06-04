package daoi;

import java.util.List;

import util.Conn;
import model.TipoTransporte;
import daol.TipoTransporteDAOL;

public class TipoTransporteDAOI implements TipoTransporteDAOL {

	Conn cn = new Conn();
	@Override
	public List<TipoTransporte> read() throws Exception {
		// TODO Auto-generated method stub
		cn.open();
		return cn.em.createQuery("select m from TipoTransporte m").getResultList();
	}

}
