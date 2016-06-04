package daoi;

import java.util.List;

import util.Conn;
import model.Modelo;
import daol.ModeloDAOL;

public class ModeloDAOI implements ModeloDAOL {

	Conn cn =new Conn();
	@Override
	public List<Modelo> read() throws Exception {
		// TODO Auto-generated method stub
		cn.open();
		return cn.em.createQuery("select m from Modelo m").getResultList();
	}

}
