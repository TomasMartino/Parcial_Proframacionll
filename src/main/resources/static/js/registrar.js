$(document).ready(function() {

	  //registrarUsuario();


});

async function registrarUsuario(id) {

	let datos={};
	datos.nombre=document.getElementById('txtNombre').value;
	datos.apellido=document.getElementById('txtApellido').value;
	datos.email=document.getElementById('txtEmail').value;
	datos.telefono=document.getElementById('txtTelefono').value;
	datos.password=document.getElementById('txtPassword').value;
	let repetirPassword=document.getElementById('txtRepetirPassword').value;
	if (repetirPassword!=datos.password){
		alert("la contraseña es incorrecta")
		return;
	}

	const request = await fetch('api/usuario', {
		method : "POST",
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		body: JSON.stringify(datos)
	});
	alert("Usuario Registrados con exito");
	window.location.href="login.html"
}