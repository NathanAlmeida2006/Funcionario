package util;

import java.sql.*;

/**
 * Classe responsável por fornecer a conexão com o banco de dados.
 */
public class Conexao {

    /**
     * Estabelece uma conexão com o banco de dados MySQL.
     *
     * @return Um objeto {@link Connection} se a conexão for bem-sucedida, {@code null} em caso de falha.
     */
    public static Connection conectar() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/controlefuncionario";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao conectar ao banco de dados");
        }

        return con;
    }
}
