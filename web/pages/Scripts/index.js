/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $.ajax({
        type: "POST",
        url: "/PosJava/controle.cotacao.ultimacotacao",
        success: function (data, textStatus, jqXHR) {
            if (!IsJsonString(data)) {
                var elements = $(data);
                if ($("#hdnMsg", elements).val() != "") {
                    $.notify({
                        message: $("#hdnMsg", elements).val()
                    }, {
                        type: $("#hdnTipoMsg", elements).val()
                    });

                    $("#hdnMsg", elements).val("");
                }
            } else {
                $.each(JSON.parse(data), function (i, val) {

                    var strHtml = "<a href='#' class='list-group-item'>" +
                            "<i class='fa fa-money fa-fw'></i> " +
                            val.tipoMoeda.nome + "(" + val.tipoMoeda.simbolo +
                            "): " + val.valor +
                            "<span class='pull-right text-muted small'><em>" +
                            new Date(val.data).toLocaleString([], {day: '2-digit', month: '2-digit', year: 'numeric'});
                    +"</em></span></a>";
                    $(".list-group").append(strHtml);
                });
            }
        }
    });

    $.ajax({
        type: "POST",
        url: "/PosJava/controle.cotacao.morris",
        success: function (data, textStatus, jqXHR) {
            if (!IsJsonString(data)) {
                var elements = $(data);
                if ($("#hdnMsg", elements).val() != "") {
                    $.notify({
                        message: $("#hdnMsg", elements).val()
                    }, {
                        type: $("#hdnTipoMsg", elements).val()
                    });

                    $("#hdnMsg", elements).val("");
                }
            } else {
                var arr = JSON.parse(data);
                Morris.Area({
                    element: 'morris-area-chart',
                    data: arr,
                    xkey: 'data'
                });
            }
        }
    });
});

function IsJsonString(str) {
    try {
        JSON.parse(str);
    } catch (e) {
        return false;
    }
    return true;
}