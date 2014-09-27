package Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.Departamento;
import Persistence.DepartamentoDao;



@Controller
@RequestMapping(value="departamento")
public class DepartamentoAction {
	
	@Autowired(required=true)
	private DepartamentoDao departamentoDao;
	
	@RequestMapping(value="listar")
	public String findAll(Model model){
		List<Departamento> lista;
		try {
			lista = departamentoDao.findAll();
			model.addAttribute("lista", lista);
			return "departamento/listar";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
