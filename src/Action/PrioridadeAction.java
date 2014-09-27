package Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.Prioridade;
import Persistence.PrioridadeDao;


@Controller
@RequestMapping(value="prioridade")
public class PrioridadeAction {
	
	@Autowired(required=true)
	private PrioridadeDao prioridadeDao;
	
	@RequestMapping(value="listar")
	public String findAll(Model model){
		List<Prioridade> lista;
		try {
			lista = prioridadeDao.findAll();
			model.addAttribute("lista", lista);
			return "prioridade/listar";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
