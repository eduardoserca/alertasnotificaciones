function onlyCharacter(evt){
    var keynum = null;

    if(window.event)  
    { 
    	keynum = evt.keyCode; 
    } 
    else if(evt.which)  
    { 
    	keynum = evt.which;
    }
    if (keynum == 13)  return false; 

    if (String.fromCharCode(keynum)==";" || String.fromCharCode(keynum)=="'" || String.fromCharCode(keynum)=="*" || String.fromCharCode(keynum)== "=" || String.fromCharCode(keynum)== "&" || String.fromCharCode(keynum)== "$" || String.fromCharCode(keynum)== "+" || String.fromCharCode(keynum)== "%" || String.fromCharCode(keynum)== "?" || String.fromCharCode(keynum)== "¿" || String.fromCharCode(keynum)== "!" || String.fromCharCode(keynum)== "¡" || String.fromCharCode(keynum)== "#" || String.fromCharCode(keynum)== '"')
    {
          return false; 
    }
}


function onlyNumber(e) { 
    tecla = (document.all) ? e.keyCode : e.which; 
    if (tecla==8) return true; 
    patron =/\d/; 
    te = String.fromCharCode(tecla); 
    return patron.test(te); 
}

function onlyDecimal(e) { 
    tecla = (document.all) ? e.keyCode : e.which; 
    if (tecla==8) return true;
    if (tecla==46) return true;
    patron =/\d/; 
    te = String.fromCharCode(tecla); 
    return patron.test(te); 
}

function validarTelefono(e) { 
	alert('dsfsdf');
    //tecla = (document.all) ? e.keyCode : e.which; 
   alert(e.keyCode);
   if (e.keyCode == '1') {
       e.preventDefault();

     }
}

function soloLetras(e){
	tecla = (document.all) ? e.keyCode : e.which;
	if (tecla==8) return true;
	patron =/[A-Za-záéíóúÁÉÍÓÚüÜñÑ\s]/;
	//patron =/[A-Za-z\s]/;
	te = String.fromCharCode(tecla);
	return patron.test(te);
}

 function validateEmail($email) {
  var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
  return emailReg.test( $email );
}
