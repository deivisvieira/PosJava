/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    $.ajax({
        type: "POST",
        url: "/PosJava/controle.tipomoeda.listar",
        data: "nome=''&simbolo=''",
        success: function (data, textStatus, jqXHR) {
            $.each(JSON.parse(data), function (i, val){
               $("#cbId").append("<option value='"+val.id+"'>"+val.nome+"</option>") 
            });            
        }
    });
});