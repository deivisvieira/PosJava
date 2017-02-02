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
import modelo.Cotacao;

/**
 *
 * @author Deivis
 */
public class DAOCotacao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public DAOCotacao() throws Exception {jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10156007?zeroDateTimeBehavior=convertToNull [sql10156007 em Esquema default]
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10156007?zeroDateTimeBehavior=convertToNull", "sql10156007", "AyCXbQiS9J");

    }

    public void incluir(Cotacao cotacao) throws Exception {

        pst = con.prepareStatement("insert into sql10156007.cotacao values(null, ?,?)");
        
        pst.setString(1, cotacao.getDataString());
        pst.setString(2, cotacao.getValorString());

        pst.execute();

        pst.close();

    }

    public void excluir(Cotacao cotacao) throws Exception {
        pst = con.prepareStatement("DELETE FROM sql10156007.cotacao WHERE id = ?");

        pst.setInt(1, cotacao.getId());        

        pst.execute();

        pst.close();
    }

    public void alterar(Cotacao cotacao) throws Exception {
        pst = con.prepareStatement("UPDATE sql10156007.cotacao SET data = ?, valor = ? WHERE id = ?");
        
        pst.setString(1, cotacao.getDataString());
        pst.setString(2, cotacao.getValorString());
        pst.setInt(3, cotacao.getId());

        pst.execute();

        pst.close();
    }

    public ArrayList<Cotacao> consultar(Cotacao cotacao) throws Exception {
        Cotacao temp = null;
        ArrayList<Cotacao> list = new ArrayList<>();
        pst = con.prepareStatement("SELECT * FROM sql10156007.cotacao c inner join sql10156007.tipo_moeda tm "
         +" WHERE tm.nome like '%"+cotacao.getTipoMoeda().getNome()+"%' and data ="+cotacao.getData());
                
        rs = pst.executeQuery();

        while (rs.next()) {
            temp = new Cotacao();

            temp.setId(rs.getInt(1));
            temp.setData(rs.getString(2));
            temp.setValor(rs.getString(3)); 
            list.add(temp);
        }
        pst.close();

        return list;
    }

}
