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
public class DAOAluno {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public DAOAluno() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/AulaPosEngenhariaSoftware", "aluno", "123");

    }

    public void incluir(TipoMoeda aluno) throws Exception {

        pst = con.prepareStatement("insert into aluno.aluno values(?,?,?,?)");

        pst.setString(1, aluno.getMatricula());
        pst.setString(2, aluno.getNome());
        pst.setDouble(3, aluno.getTeste());
        pst.setDouble(4, aluno.getProva());

        pst.execute();

        pst.close();

    }

    public void excluir(TipoMoeda aluno) throws Exception {
        pst = con.prepareStatement("DELETE FROM aluno.aluno WHERE MATRICULA = ?");

        pst.setString(1, aluno.getMatricula());

        pst.execute();

        pst.close();
    }

    public void alterar(TipoMoeda aluno) throws Exception {
        pst = con.prepareStatement("UPDATE aluno.aluno SET NOME = ?, TESTE = ?, PROVA = ? WHERE MATRICULA = ?");

        pst.setString(1, aluno.getNome());
        pst.setDouble(2, aluno.getTeste());
        pst.setDouble(3, aluno.getProva());
        pst.setString(4, aluno.getMatricula());

        pst.execute();

        pst.close();
    }

    public TipoMoeda consultar(TipoMoeda aluno) throws Exception {
        TipoMoeda temp = null;

        pst = con.prepareStatement("SELECT * FROM aluno.aluno WHERE MATRICULA = ?");
        pst.setString(1, aluno.getMatricula());
        rs = pst.executeQuery();

        if (rs.next()) {
            temp = new TipoMoeda();

            temp.setMatricula(rs.getString(1));
            temp.setNome(rs.getString(2));
            temp.setTeste(rs.getDouble(3));
            temp.setProva(rs.getDouble(4));
        }
        pst.close();

        return temp;
    }

}
