/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.apache.derby.client.am.DateTime;
import org.apache.derby.client.am.Decimal;

/**
 *
 * @author Deivis
 */
public class Cotacao {
    private int id;
    private DateTime data;
    private Decimal valor;    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTime getData() {
        return data;
    }

    public void setData(DateTime data) {
        this.data = data;
    }

    public Decimal getValor() {
        return valor;
    }

    public void setValor(Decimal valor) {
        this.valor = valor;
    }
}
