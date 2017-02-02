/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Deivis
 */
public class Cotacao {
    private int id;
    private Date data;
    private Double valor;
    private TipoMoeda tipoMoeda;

    public TipoMoeda getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(TipoMoeda tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }
    
    public String getDataString() {
        return data.toString();
    }

    public void setData(String data) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.data = df.parse(data);
    }

    public Double getValor() {
        return valor;
    }

    public String getValorString(){
        return valor.toString();
    }
    
    public void setValor(String valor) {
        this.valor = Double.parseDouble(valor);
    }
}
