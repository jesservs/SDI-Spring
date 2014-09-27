package Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.Categoria;
import Entity.Departamento;
import Persistence.CategoriaDao;
import Persistence.DepartamentoDao;



@Controller
@RequestMapping(value="categoria")
public class CategoriaAction {
	
	@Autowired(required=true)
	private CategoriaDao categoriaDao;
	
	@RequestMapping(value="listar")
	public String findAll(Model model){
		List<Categoria> lista;
		try {
			lista = categoriaDao.findAll();
			model.addAttribute("lista", lista);
			return "categoria/listar";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
