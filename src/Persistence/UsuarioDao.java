package Persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import Entity.Usuario;

@Component
public class UsuarioDao extends Dao {

	public void create(Usuario usuario) throws Exception {
		open();
			stmt = con.prepareStatement("insert into usuario values(null, ?, ?, ?, ?)");
			stmt.setString(1, usuario.getNomeUsuario());
			stmt.setString(2, usuario.getCpf());
			stmt.setString(3, usuario.getTel());
			stmt.setInt(4, usuario.getDepartamento().getIdDepto());
			stmt.execute();
			stmt.close();
		close();
	}

	public List<Usuario> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select idUsuario, nomeUsuario, cpfUsuario, telUsuario, id_depto from usuario");
		ResultSet rs = stmt.executeQuery();
		
		DepartamentoDao departamentoDao = new DepartamentoDao();
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("idUsuario"));
			usuario.setNomeUsuario(rs.getString("nomeUsuario"));
			usuario.setCpf(rs.getString("cpfUsuario"));
			usuario.setTel(rs.getString("telUsuario"));
			usuario.setDepartamento(  departamentoDao.findByCode( rs.getInt("id_depto") )  );

			listaUsuarios.add(usuario);
		}
		return listaUsuarios;
	}

	public void alterarUsuario(Usuario usuario) throws Exception {
		open();
		stmt = con
				.prepareStatement("update usuario set nomeUsuario = ?, cpfUsuario = ?, telUsuario = ?, id_depto = ? "
						+ "where idUsuario = ?");
		stmt.setString(1, usuario.getNomeUsuario());
		stmt.setString(2, usuario.getCpf());
		stmt.setString(3, usuario.getTel());
		stmt.setInt(4, usuario.getDepartamento().getIdDepto());
		stmt.setInt(5, usuario.getIdUsuario());
		stmt.execute();
		stmt.close();
		close();
	}

	public Usuario findByCPF(Usuario usuario) throws Exception {
		open();
		stmt = con
				.prepareStatement("select idUsuario, nomeUsuario, cpfUsuario, telUsuario, iddepto, descdepto "
						+ "from usuario "
						+ "inner join departamento on id_depto = iddepto "
						+ "where cpfUsuario = ?");
		stmt.setString(1, usuario.getCpf());

		ResultSet rs = stmt.executeQuery();

		Usuario usuarioAchado = new Usuario();
		if (rs.next()) {
			usuarioAchado.setIdUsuario(rs.getInt("idUsuario"));
			usuarioAchado.setNomeUsuario(rs.getString("nomeUsuario"));
			usuarioAchado.setCpf(rs.getString("cpfUsuario"));
			usuarioAchado.setTel(rs.getString("telUsuario"));
			usuarioAchado.getDepartamento().setIdDepto(rs.getInt("iddepto"));
			usuarioAchado.getDepartamento().setDescDepto(rs.getString("descdepto"));
		}
		close();
		return usuarioAchado;
	}

	public Usuario findById(Usuario usuario) throws Exception {
		open();
		stmt = con
				.prepareStatement("select idUsuario, nomeUsuario, cpfUsuario, telUsuario, iddepto, descdepto "
						+ "from usuario "
						+ "inner join depto on id_depto = iddepto "
						+ "where idUsuario = ?");
		stmt.setInt(1, usuario.getIdUsuario());

		ResultSet rs = stmt.executeQuery();

		Usuario usuarioAchado = new Usuario();

		if (rs.next()) {
			usuarioAchado.setIdUsuario(rs.getInt("idUsuario"));
			usuarioAchado.setNomeUsuario(rs.getString("nomeUsuario"));
			usuarioAchado.setCpf(rs.getString("cpfUsuario"));
			usuarioAchado.setTel(rs.getString("telUsuario"));
			usuarioAchado.getDepartamento().setIdDepto(rs.getInt("iddepto"));
			usuarioAchado.getDepartamento().setDescDepto(rs.getString("descdepto"));
		}
		close();
		return usuarioAchado;
	}

	public void removerUsuario(Usuario usuario) throws Exception {
		open();
		stmt = con.prepareStatement("delete from usuario where idUsuario = ?");
		stmt.setInt(1, usuario.getIdUsuario());
		stmt.execute();
		stmt.close();
		close();
	}

}
