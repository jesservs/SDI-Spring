package Entity;

public class Usuario implements Comparable<Usuario>{

	private Integer idUsuario;
	private String nomeUsuario;
	private String cpf;
	private String tel;
	
	private Departamento departamento;
	
	public Usuario() {
		departamento = new Departamento();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.nomeUsuario.equals(((Usuario)obj).getNomeUsuario());
	}
	
	@Override
	public int compareTo(Usuario usuario) {
		return this.nomeUsuario.compareTo(usuario.getNomeUsuario());
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
