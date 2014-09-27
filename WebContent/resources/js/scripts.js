$(function(){
	
});

function cadastrarUsuario(){
	var matricula = $("#matricula").val();
	var nome = $("#nome").val();
	var sobrenome = $("#sobrenome").val();
	var cpf = $("#cpf").val();
	var perfil = $("#perfil").val();
	var nascimento = $("#nascimento").val();
	var email = $("#email").val();
	var email2 = $("#email2").val();
	var senha = $("#senha").val();
	var senha2 = $("#senha2").val();
	
	if(email !== email2){
		alert("Os emails não coincidem");
	}else if(senha !== senha2){
		alert("As Senhas não coincidem");
	}else{
		alert(matricula + nome + sobrenome + cpf + perfil + nascimento + email + senha);
	}
}

function validarCampos(){
	
}