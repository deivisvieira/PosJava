/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Cotacao;
import modelo.Morris;
import modelo.TipoMoeda;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

/**
 *
 * @author Deivis
 */
public class DAOCotacao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public DAOCotacao() throws Exception {
        jdbc:
        mysql://sql10.freemysqlhosting.net:3306/sql10156007?zeroDateTimeBehavior=convertToNull [sql10156007 em Esquema default]
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10156007?zeroDateTimeBehavior=convertToNull", "sql10156007", "AyCXbQiS9J");

    }

    public void incluir(Cotacao cotacao) throws Exception {

        pst = con.prepareStatement("insert into sql10156007.cotacao values(null, ?,?,?)");

        pst.setString(1, cotacao.getDataString());
        pst.setString(2, cotacao.getValorString());
        pst.setInt(3, cotacao.getTipoMoeda().getId());

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
        TipoMoeda tipoMoedaTemp = null;
        ArrayList<Cotacao> list = new ArrayList<>();
        String strSql = new String();
        strSql = "SELECT * FROM sql10156007.cotacao c inner join sql10156007.tipo_moeda tm on c.tipo_moeda=tm.id WHERE 1=1";
        if (cotacao.getTipoMoeda().getId() != 0) {
            strSql += " tipo_moeda ='" + cotacao.getTipoMoeda().getId() + "'";
        }

        if (cotacao.getDataString() != null) {
            strSql += " and data = '" + cotacao.getDataString() + "'";
        }

        if (cotacao.getValor() != null) {
            strSql += " and valor = " + cotacao.getValorString() + "";
        }

        pst = con.prepareStatement(strSql);

        rs = pst.executeQuery();

        while (rs.next()) {
            temp = new Cotacao();

            temp.setId(rs.getInt(1));
            temp.setData(rs.getString(2));
            temp.setValor(rs.getString(3));

            tipoMoedaTemp = new TipoMoeda();
            tipoMoedaTemp.setId(rs.getInt(5));
            tipoMoedaTemp.setNome(rs.getString(6));
            tipoMoedaTemp.setSimbolo(rs.getString(7));

            temp.setTipoMoeda(tipoMoedaTemp);
            list.add(temp);
        }
        pst.close();

        return list;
    }

    public ArrayList<Cotacao> ultimasCotacoes() throws Exception {
        Cotacao temp = null;
        TipoMoeda tipoMoedaTemp = null;
        ArrayList<Cotacao> list = new ArrayList<>();
        String strSql = new String();
        strSql = "SELECT c.id, DATE_FORMAT(c.data,\"%d/%m/%Y\"), c.valor, c.tipo_moeda, tm.id, tm.nome, tm.simbolo, max.maxdata, max.tipo_moeda ";
        strSql += " FROM sql10156007.cotacao c inner join sql10156007.tipo_moeda tm on c.tipo_moeda=tm.id ";
        strSql += "inner join ";
        strSql += "(select max(data) maxdata, tipo_moeda from sql10156007.cotacao group by tipo_moeda) max ";
        strSql += " on max.tipo_moeda=c.tipo_moeda and max.maxdata = c.data order by max.maxdata desc;";
        pst = con.prepareStatement(strSql);

        rs = pst.executeQuery();

        while (rs.next()) {
            temp = new Cotacao();

            temp.setId(rs.getInt(1));
            temp.setDataString(rs.getString(2));
            temp.setValor(rs.getString(3));

            tipoMoedaTemp = new TipoMoeda();
            tipoMoedaTemp.setId(rs.getInt(5));
            tipoMoedaTemp.setNome(rs.getString(6));
            tipoMoedaTemp.setSimbolo(rs.getString(7));

            temp.setTipoMoeda(tipoMoedaTemp);
            list.add(temp);
        }
        pst.close();

        return list;
    }

    public String morris() throws Exception {
        Morris temp = null;        
        ArrayList<Morris> list = new ArrayList<>();
        String strSql = new String();
        DAOTipoMoeda daoTm = new DAOTipoMoeda();
        ArrayList<TipoMoeda> listaMoeda = daoTm.listar();
        int contador = 0;
        
        strSql = "SELECT DATE_FORMAT(c.data,\"%d/%m/%Y\") as data,  ";
        
        for (TipoMoeda tm : listaMoeda){
            contador++;
            strSql += " MAX(IF(`tipo_moeda` = "+tm.getId()+",cast(valor as char(6)),0)) AS '"+tm.getId()+"'";
            if (contador<listaMoeda.size()){
                strSql+=",";
            }
        }        
        
        strSql += " FROM sql10156007.cotacao c inner join sql10156007.tipo_moeda tm GROUP   BY c.data";
        
        String saida = resultSetToJson(con, strSql);


        return saida;
    }
    
    public static String resultSetToJson(Connection connection, String query) {
        List<Map<String, Object>> listOfMaps = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            listOfMaps = queryRunner.query(connection, query, new MapListHandler());
        } catch (SQLException se) {
            throw new RuntimeException("Couldn't query the database.", se);
        } finally {
            DbUtils.closeQuietly(connection);
        }
        return new Gson().toJson(listOfMaps);
    }
}
