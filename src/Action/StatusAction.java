package Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.Status;
import Persistence.StatusDao;



@Controller
@RequestMapping(value="status")
public class StatusAction {
	
	@Autowired(required=true)
	private StatusDao statusDao;
	
	@RequestMapping(value="listar")
	public String findAll(Model model){
		List<Status> lista;
		try {
			lista = statusDao.findAll();
			model.addAttribute("lista", lista);
			return "status/listar";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
