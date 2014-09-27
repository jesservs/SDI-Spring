package Persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import Entity.Categoria;
import Entity.Tipo;

@Component
public class CategoriaDao extends Dao {

	public List<Categoria> buscarPorTipo(Tipo tipo) throws Exception {
		open();
		stmt = con
				.prepareStatement("select idcategoria, desccategoria, "
						+ "idtipo, desctipo, "
						+ "idprioridade, descprioridade, temporesolucao "
						+ "from categoria "
						+ "inner join tipo on categoria.id_tipo=tipo.idtipo "
						+ "inner join prioridade on categoria.id_prioridade=prioridade.idprioridade "
						+ "where idtipo = ?");
		stmt.setInt(1, tipo.getIdTipo());

		ResultSet rs = stmt.executeQuery();

		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		while (rs.next()) {
			Categoria categoria = new Categoria();

			categoria.setIdCategoria(rs.getInt("idcategoria"));
			categoria.setDescCategoria(rs.getString("desccategoria"));

			categoria.getTipo().setIdTipo(rs.getInt("idtipo"));
			categoria.getTipo().setDescTipo(rs.getString("desctipo"));

			categoria.getPrioridade()
					.setIdPrioridade(rs.getInt("idprioridade"));
			categoria.getPrioridade().setDescPrioridade(
					rs.getString("descprioridade"));
			categoria.getPrioridade().setTempoResolucao(
					rs.getInt("temporesolucao"));

			listaCategorias.add(categoria);
		}
		close();
		return listaCategorias;
	}

	public List<Categoria> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select idcategoria, desccategoria, id_tipo, id_prioridade from categoria");
		ResultSet rs = stmt.executeQuery();
		TipoDao tipoDao = new TipoDao();
		PrioridadeDao prioridadeDao = new PrioridadeDao();
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		while (rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(rs.getInt("idcategoria"));
			categoria.setDescCategoria(rs.getString("desccategoria"));
			categoria.setTipo(		tipoDao.findById(rs.getInt("id_tipo"))		);
			categoria.setPrioridade(		prioridadeDao.findById(rs.getInt("id_prioridade"))		);
			listaCategoria.add(categoria);
		}
		close();
		return listaCategoria;
	}
	

	public List<Categoria> finByTipo(Integer id) throws Exception {
		open();
		stmt = con.prepareStatement("SELECT DISTINCT DESCCATEGORIA FROM TIPO, CATEGORIA C WHERE C.ID_TIPO = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		while (rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setIdCategoria(rs.getInt("idcategoria"));
			categoria.setDescCategoria(rs.getString("desccategoria"));
			listaCategoria.add(categoria);
		}
		close();
		return listaCategoria;
	}

}
