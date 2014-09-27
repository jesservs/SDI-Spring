package Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.Tipo;
import Persistence.TipoDao;


@Controller
@RequestMapping(value="tipo")
public class TipoAction {
	
	@Autowired(required=true)
	private TipoDao tipoDao;
	
	@RequestMapping(value="listar")
	public String findAll(Model model){
		List<Tipo> lista;
		try {
			lista = tipoDao.findAll();
			model.addAttribute("lista", lista);
			return "tipo/listar";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
