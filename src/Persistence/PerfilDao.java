package Persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import Entity.Perfil;
import Entity.Usuario;


@Component
public class PerfilDao extends Dao {
	public List<Perfil> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("SELECT IDPERFIL, NOMEPERFIL FROM PERFIL");
		ResultSet rs = stmt.executeQuery();

		List<Perfil> listaPerfis = new ArrayList<Perfil>();
		while (rs.next()) {
			Perfil perfil = new Perfil();
			perfil.setIdPerfil(rs.getInt("idperfil"));
			perfil.setNomePerfil(rs.getString("nomeperfil"));
			listaPerfis.add(perfil);
		}
		close();
		return listaPerfis;
	}
	
	public void create(Perfil perfil) throws Exception {
		open();
			stmt = con.prepareStatement("INSERT INTO PERFIL (NOMEPERFIL) VALUES (?)");
			stmt.setString(1, perfil.getNomePerfil());
			stmt.execute();
			stmt.close();
		close();
	}
	
	public void delete(Perfil perfil) throws Exception {
		open();
			stmt = con.prepareStatement("DELETE FROM PERFIL WHERE IDPERFIL = ?");
			stmt.setInt(1, perfil.getIdPerfil());
			stmt.execute();
			stmt.close();
		close();
	}
	
}
