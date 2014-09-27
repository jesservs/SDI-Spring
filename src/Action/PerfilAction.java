package Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.Perfil;
import Persistence.PerfilDao;


@Controller
@RequestMapping(value="perfil")
public class PerfilAction {
	
	@Autowired(required=true)
	private PerfilDao perfilDao;
	
	@RequestMapping(value="listar")
	public String findAll(Model model){
		List<Perfil> lista;
		try {
			lista = perfilDao.findAll();
			model.addAttribute("lista", lista);
			return "perfil/listar";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="create")
	public String create(Perfil perfil, Model model){
		try {
			perfilDao.create(perfil);
			model.addAttribute("mensagem", "Perfil cadastrado com sucesso!");
			return "perfil/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "perfil/listar";
		}
	}
	
	@RequestMapping(value="delete")
	public String delete(Perfil perfil, Model model){
		try {
			perfilDao.delete(perfil);
			model.addAttribute("mensagem", "Perfil deleta com sucesso!");
			return "perfil/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "perfil/listar";
		}
	}
	
	
}
