/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.apache.derby.client.am.DateTime;

/**
 *
 * @author Deivis
 */
public class Cotacao {
    private int id;
    private DateTime data;
    private Double valor;    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTime getData() {
        return data;
    }

    public void setData(String data) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.data = df.parse(data);
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = Double.parseDouble(valor);
    }
}
