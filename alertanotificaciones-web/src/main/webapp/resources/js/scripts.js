
$(document).on("ready", main)
function main(){
	$("#btn-hidden-nav a").on("click", cambiarWindo);
	$("#btnCancelWindow").on("click", cambiarWindo);

}
function cambiarWindo () {

	$("#box-main-container").toggleClass("viewExpand");
}

/*function showMenu () {
$("#box-main-container").toggleClass("viewExpand");


}*/

/*Para Obtner Fecha actual*/
var fecha = new Date ();      
var dia_semana = fecha.getDay();
var dia_mes = fecha.getDate();
var mes = fecha.getMonth ();
var anio = fecha.getYear();
if ( anio < 1900 ) {
anio = 1900 + fecha.getYear();
}
mes += 1;
if (mes < 10) {
mes = '0' + mes;
}
if (dia_mes < 10) {
dia_mes = '0' + dia_mes;
}
if (dia_semana == 0) { dia_semana = 'Domingo, '; }
if (dia_semana == 1) { dia_semana = 'Lunes, '; }
if (dia_semana == 2) { dia_semana = 'Martes, '; }
if (dia_semana == 3) { dia_semana = 'Miércoles, '; }
if (dia_semana == 4) { dia_semana = 'Jueves, '; }
if (dia_semana == 5) { dia_semana = 'Viernes, '; }
if (dia_semana == 6) { dia_semana = 'Sábado, '; }
var nb_mes = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];


$("#date_box").text(dia_mes + ' de ' + nb_mes[mes-1] + ' de ' + anio);

/*cambiar tamaño de ventana segun el menu se deglosa*/

PrimeFaces.widget.Dialog.prototype.applyFocus = function() {
  var firstInput = this.jq.find(':not(:submit):not(:button):input:visible:enabled:first');
  if(!firstInput.hasClass('hasDatepicker')) {
      firstInput.focus();
  }
}

// para limpiar campos
	$(".limpiarCampos").click(function() {
		$('.inputClear').val("");
	});