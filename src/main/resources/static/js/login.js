$(document).ready(function() {

});

async function iniciarSesion() {
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    const request = await fetch('api/login', {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const respuesta = await request.text();

    if (respuesta === 'OK') {
        window.location.href = "usuarios.html";
    } else {
        alert("Las credenciales son incorrectas. Inténtalo de nuevo");
    }
}