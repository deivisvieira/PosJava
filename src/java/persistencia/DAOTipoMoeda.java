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
import java.util.ArrayList;
import java.util.List;
import modelo.TipoMoeda;

/**
 *
 * @author profoswaldo
 */
public class DAOTipoMoeda {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public DAOTipoMoeda() throws Exception {jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10156007?zeroDateTimeBehavior=convertToNull [sql10156007 em Esquema default]
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10156007?zeroDateTimeBehavior=convertToNull", "sql10156007", "AyCXbQiS9J");

    }

    public void incluir(TipoMoeda tipoMoeda) throws Exception {

        pst = con.prepareStatement("insert into sql10156007.tipo_moeda values(null, ?,?)");
        
        pst.setString(1, tipoMoeda.getNome());
        pst.setString(2, tipoMoeda.getSimbolo());

        pst.execute();

        pst.close();

    }

    public void excluir(TipoMoeda tipoMoeda) throws Exception {
        pst = con.prepareStatement("DELETE FROM sql10156007.tipo_moeda WHERE id = ?");

        pst.setInt(1, tipoMoeda.getId());        

        pst.execute();

        pst.close();
    }

    public void alterar(TipoMoeda tipoMoeda) throws Exception {
        pst = con.prepareStatement("UPDATE sql10156007.tipo_moeda SET nome = ?, simbolo = ? WHERE id = ?");
        
        pst.setString(1, tipoMoeda.getNome());
        pst.setString(2, tipoMoeda.getSimbolo());
        pst.setInt(3, tipoMoeda.getId());

        pst.execute();

        pst.close();
    }

    public ArrayList<TipoMoeda> consultar(TipoMoeda tipoMoeda) throws Exception {
        TipoMoeda temp = null;
        ArrayList<TipoMoeda> list = new ArrayList<>();
        pst = con.prepareStatement("SELECT * FROM sql10156007.tipo_moeda WHERE nome like '%"+tipoMoeda.getNome()+"%' and simbolo like '%"+tipoMoeda.getSimbolo()+"%'");
                
        rs = pst.executeQuery();

        while (rs.next()) {
            temp = new TipoMoeda();

            temp.setId(rs.getInt(1));
            temp.setNome(rs.getString(2));
            temp.setSimbolo(rs.getString(3)); 
            list.add(temp);
        }
        pst.close();

        return list;
    }

}
