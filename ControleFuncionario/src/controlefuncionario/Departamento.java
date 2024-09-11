package controlefuncionario;

import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Departamento.
 * Contém métodos para manipulação de dados de um departamento no banco de dados.
 */
public class Departamento {
    private int idDepto;
    private String descDepto;

    /**
     * Método que tenta incluir o departamento no banco de dados.
     *
     * @return {@code true} se a inclusão for bem-sucedida, {@code false} em caso de erro.
     */
    public boolean incluirDepartamento() {
        String sql = "INSERT INTO Departamento (descDepto) VALUES (?);";
        Connection con = Conexao.conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.descDepto);
            stm.execute();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Departamento> listarDepartamento() {
        String sql = "SELECT idDepto, descDepto FROM departamento ORDER BY descDepto;";
        List<Departamento> lst = new ArrayList<>();
        Connection con = Conexao.conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Departamento dep = new Departamento();
                dep.setIdDepto(rs.getInt("iddepto"));
                dep.setDescDepto(rs.getString("descdepto"));
                lst.add(dep);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }

    /**
     * Obtém o ID do departamento.
     *
     * @return O ID do departamento.
     */
    public int getIdDepto() {
        return idDepto;
    }

    /**
     * Define o ID do departamento.
     *
     * @param idDepto O ID a ser atribuído ao departamento.
     */
    public void setIdDepto(int idDepto) {
        this.idDepto = idDepto;
    }

    /**
     * Obtém a descrição do departamento.
     *
     * @return A descrição do departamento.
     */
    public String getDescDepto() {
        return descDepto;
    }

    /**
     * Define a descrição do departamento.
     *
     * @param descDepto A descrição a ser atribuída ao departamento.
     */
    public void setDescDepto(String descDepto) {
        this.descDepto = descDepto;
    }
}
