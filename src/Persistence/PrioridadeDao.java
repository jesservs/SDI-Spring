package Persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import Entity.Prioridade;
import Entity.Tipo;

@Component
public class PrioridadeDao extends Dao {

	public List<Prioridade> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select idprioridade, descprioridade, temporesolucao from prioridade");
		ResultSet rs = stmt.executeQuery();

		List<Prioridade> listaPrioridades = new ArrayList<Prioridade>();
		while (rs.next()) {
			Prioridade prioridade = new Prioridade();
			prioridade.setIdPrioridade(rs.getInt("idprioridade"));
			prioridade.setDescPrioridade(rs.getString("descprioridade"));
			prioridade.setTempoResolucao(rs.getInt("temporesolucao"));
			listaPrioridades.add(prioridade);
		}
		close();
		return listaPrioridades;
	}
	
	public Prioridade findById(Integer id) throws Exception {
		open();
		stmt = con
				.prepareStatement("select idprioridade, descprioridade, temporesolucao from prioridade where idprioridade = ?");
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		Prioridade prioridadeAchado = new Prioridade();

		if (rs.next()) {
			prioridadeAchado.setIdPrioridade(rs.getInt("idprioridade"));
			prioridadeAchado.setDescPrioridade(rs.getString("descprioridade"));
			prioridadeAchado.setTempoResolucao(		rs.getInt("temporesolucao")		);
		}
		close();
		return prioridadeAchado;
	}
}
