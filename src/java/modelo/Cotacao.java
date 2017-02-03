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
        if (this.data != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.format(this.data);
        } else {
            return null;
        }

    }

    public void setData(String data) throws ParseException {
        if (!"".equals(data)) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            this.data = df.parse(data);
        } else {
            this.data = null;
        }
    }
    
    public void setDataString(String data) throws ParseException {
        if (!"".equals(data)) {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            this.data = df.parse(data);
        } else {
            this.data = null;
        }
    }

    public Double getValor() {
        return valor;
    }

    public String getValorString() {
        return valor.toString();
    }

    public void setValor(String valor) {
        if (!"".equals(valor)) {
            this.valor = Double.parseDouble(valor.replace(",", "."));
        } else {
            this.valor = null;
        }
    }
}
