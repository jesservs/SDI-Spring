package Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Entity.Usuario;
import Persistence.UsuarioDao;

@Controller
@RequestMapping(value="usuario")
public class UsuarioAction {
	
	@Autowired(required=true)
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value="listar")
	public String listarUsuarios(Model model){
		List<Usuario> lista;
		try {
			lista = usuarioDao.findAll();
			model.addAttribute("lista", lista);
			return "usuario/listar";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	@RequestMapping(value="cadastro")
	public String exibirFormCadastroUsuario(Model model){
		return "usuario/cadastro";
	}
	
	@RequestMapping(value="gravarUsuario")
	public String cadastrarUsuario(Usuario u, Model model){
		try {
			usuarioDao.salvar(u);
			model.addAttribute("mensagem", "Usuario cadastrado com sucesso!");
			return "usuario/cadastro";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "usuario/cadastro";
		}
	}
	
	@RequestMapping(value="listar")
	public String listarUsuarios(Model model){
		List<Usuario> todosUsuarios;
		try {
			todosUsuarios = usuarioDao.listar();
			model.addAttribute("lista", todosUsuarios);
			return "usuario/listar";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="deletar")
	public String deletarTarefas(Model model, Integer id){
		Usuario usuario;
		try {
			usuario = usuarioDao.findByCod(id);
			usuarioDao.deletar(usuario);
			return "redirect:listar";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	*/
}
