package projetocertificadodigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import projetocertificadodigital.Banco.Banco;
import projetocertificadodigital.vo.Certificado;

public class DAO {

    public int cadastrarICP(Certificado certificado) {

        int novoId = 0;

        String sql = "INSERT INTO ICP (emailEmissor, enderecoChave)  VALUES (?,?)";

        Connection conn = Banco.getConnection();
        PreparedStatement prepStmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

        try {
           
            prepStmt.setString(1, certificado.getEmail());
            prepStmt.setString(2, certificado.getEndereco());

            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar o Cadastro do Convenio! Causa: \n: " + e.getMessage());

        } finally {
            Banco.closePreparedStatement(prepStmt);
            Banco.closeConnection(conn);
        }
        return novoId;
    }

    public Certificado consultarICP(String emailEmissor) {

        String query = "SELECT * from icp where emailEmissor = ?";

        Connection conn = Banco.getConnection();
        PreparedStatement prepStmt = Banco.getPreparedStatement(conn, query);
        Certificado certificado = null;

        try {
            prepStmt.setString(1, emailEmissor);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                certificado = new Certificado();

                certificado.setCodigoIcp(result.getInt(1));
                certificado.setEmail(result.getString(2));
                certificado.setEndereco(result.getString(3));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            Banco.closeStatement(prepStmt);
            Banco.closeConnection(conn);
        }
        return certificado;

    }

}
