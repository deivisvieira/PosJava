/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    if ($("#hdnMsg").val() != null && $("#hdnMsg").val() != "")
    $.notify({
        icon: 'glyphicon glyphicon-ok',
        message: $("#hdnMsg").val()
    }, {        
        type: 'success'
    });
    
    $("#hdnMsg").val("");
});