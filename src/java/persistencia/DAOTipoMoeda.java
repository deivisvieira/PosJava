/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.TipoMoeda;

/**
 *
 * @author profoswaldo
 */
public class DAOTipoMoeda {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public DAOTipoMoeda() throws Exception {
        Class.forName("org.apache.mysql.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10156007", "sql10156007", "AyCXbQiS9J");

    }

    public void incluir(TipoMoeda tipoMoeda) throws Exception {

        pst = con.prepareStatement("insert into tipo_moeda values(?,?)");
        
        pst.setString(1, tipoMoeda.getNome());
        pst.setString(2, tipoMoeda.getSimbolo());

        pst.execute();

        pst.close();

    }

    public void excluir(TipoMoeda tipoMoeda) throws Exception {
        pst = con.prepareStatement("DELETE FROM tipo_moeda WHERE id = ?");

        pst.setInt(1, tipoMoeda.getId());

        pst.execute();

        pst.close();
    }

    public void alterar(TipoMoeda tipoMoeda) throws Exception {
        pst = con.prepareStatement("UPDATE tipo_moeda SET NOME = ?, SIMBOLO = ? WHERE id = ?");
        
        pst.setString(1, tipoMoeda.getNome());
        pst.setString(2, tipoMoeda.getSimbolo());
        pst.setInt(3, tipoMoeda.getId());

        pst.execute();

        pst.close();
    }

    public TipoMoeda consultar(TipoMoeda tipoMoeda) throws Exception {
        TipoMoeda temp = null;

        pst = con.prepareStatement("SELECT * FROM tipo_moeda WHERE id = ?");
        pst.setInt(1, tipoMoeda.getId());
        rs = pst.executeQuery();

        if (rs.next()) {
            temp = new TipoMoeda();

            temp.setId(rs.getInt(1));
            temp.setNome(rs.getString(2));
            temp.setSimbolo(rs.getString(3));            
        }
        pst.close();

        return temp;
    }

}
