function sesion(){
    var usuario = document.formLogIn.usuario.value;
    var contraseña = document.formLogIn.contraseña.value;

         
    if(usuario == 'admin' && contraseña == 'admin'){
        location.href ="./inicio.html";
    }else{
        alert('no');
        }
}