/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Deivis
 */
public class Morris {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double[] getValor() {
        return valor;
    }

    public void setValor(Double[] valor) {
        this.valor = valor;
    }

    private String nome;
    private String data;
    private Double[] valor;
}
