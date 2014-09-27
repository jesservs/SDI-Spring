package Persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import Entity.Tipo;

@Component
public class TipoDao extends Dao {

	public List<Tipo> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select idtipo, desctipo from tipo");
		ResultSet rs = stmt.executeQuery();

		List<Tipo> listaTipos = new ArrayList<Tipo>();
		while (rs.next()) {
			Tipo tipo = new Tipo();
			tipo.setIdTipo(rs.getInt("idtipo"));
			tipo.setDescTipo(rs.getString("desctipo"));
			listaTipos.add(tipo);
		}
		close();
		return listaTipos;
	}
	
	public Tipo findById(Integer id) throws Exception {
		open();
		stmt = con
				.prepareStatement("select idtipo, desctipo from tipo where idtipo = ?");
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		Tipo tipoAchado = new Tipo();

		if (rs.next()) {
			tipoAchado.setIdTipo(rs.getInt("idtipo"));
			tipoAchado.setDescTipo(rs.getString("desctipo"));
		}
		close();
		return tipoAchado;
	}

	
}
