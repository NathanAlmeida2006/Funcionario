package controlefuncionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal para o controle de funcionários.
 * O sistema permite que o usuário escolha entre incluir um departamento ou listar os departamentos existentes.
 */
public class ControleFuncionario {

    /**
     * Método principal (main) que inicia a execução do programa.
     * Oferece ao usuário a opção de incluir um departamento ou listar os departamentos existentes.
     *
     * @param args Argumentos de linha de comando (não utilizado).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Departamento dep1 = new Departamento();
        List<Departamento> listaDeptos = new ArrayList<>();

        System.out.println("Escolha a operação: ");
        System.out.println("1 - Incluir Departamento");
        System.out.println("2 - Listar Departamentos");
        System.out.println("3 - Sair");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> {
                // Incluir um novo departamento
                System.out.println("Informe a descrição do departamento:");
                sc.nextLine();  // Limpa o buffer
                dep1.setDescDepto(sc.nextLine());
                if (dep1.incluirDepartamento()) {
                    System.out.println("Departamento incluído com sucesso.");
                } else {
                    System.out.println("Erro ao incluir o departamento.");
                }
            }
            case 2 -> {
                // Listar todos os departamentos
                listaDeptos = dep1.listarDepartamento();
                System.out.println("Cod.\tDescrição");
                for (Departamento depto : listaDeptos) {
                    System.out.println(depto.getIdDepto() + "\t" + depto.getDescDepto());
                }
            }
            case 3 ->
                // Sair do programa
                    System.out.println("Encerrando o programa.");
            default -> System.out.println("Opção inválida. Tente novamente.");
        }

        sc.close();
    }
}
