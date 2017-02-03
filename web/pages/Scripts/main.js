/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    if ($("#hdnMsg").val() != null && $("#hdnMsg").val() != "")
    $.notify({        
        message: $("#hdnMsg").val()
    }, {        
        type: $("#hdnTipoMsg").val()
    });
    
    $("#hdnMsg").val("");
});