import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Lista listaFuncionario = new Lista();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\t\tNOVO FUNCIONARIO\nCodigo: ");
            int codigoFuncionario;
            codigoFuncionario = scanner.nextInt();

            if (codigoFuncionario == 0) {
                break;
            }

            else {
                System.out.println("Nome do funcionario: ");
                String nomeFuncionario = scanner.next();

                System.out.println("Valor do salario do funcionario: R$ ");
                String salarioFuncionario = scanner.next();

                System.out.println("Data de admissão do funcionario (dd/mm/aaaa): ");
                String admissaoFuncionario = scanner.next();
                LocalDate.parse(admissaoFuncionario, formatoData);

                listaFuncionario.insereNoFim(new Funcionario(codigoFuncionario, nomeFuncionario, salarioFuncionario, admissaoFuncionario));
            }
        }

        if (listaFuncionario.tamanhoLista() != 0) {
            System.out.println("\t\tDADOS DA EMPRESA");

            int colaboradores = listaFuncionario.tamanhoLista();
            System.out.println("Total de funcionarios: " + colaboradores);

            System.out.println("\nFuncionarios e tempo de empresa: ");
            listaFuncionario.imprimeLista();

            System.out.printf("\nSoma dos salarios: R$ %.2f", listaFuncionario.somaTodosSalarios());
            System.out.printf("\n\nMedia dos salarios: R$ %.2f", listaFuncionario.mediaTodosSalarios());

            System.out.println("\n\nFuncionario com maior salario:\n" + listaFuncionario.maiorSalario());
            System.out.println("\nFuncionario com menor salario:\n" + listaFuncionario.menorSalario());

            System.out.println("\nOrdenando por código:");
            listaFuncionario.ordenaCodigo();
            listaFuncionario.imprimeLista();

            System.out.println("\nOrdenando por nome:");
            listaFuncionario.ordenaNome();
            listaFuncionario.imprimeLista();

//            FUNÇÕES DO ALGORITMO NÃO SOLICITADAS NO EXERCÍCIO

//            System.out.println("\n\n\t\tREMOCAO\nRemovendo do inicio...");
//            listaFuncionario.removeNoComeco();
//            listaFuncionario.imprimeLista();

//            System.out.println("\n\n\t\tREMOCAO\nRemovendo do fim...");
//            listaFuncionario.removeNoFim();
//            listaFuncionario.imprimeLista();

//            System.out.println("\n\n\t\tREMOCAO\nInsira o codigo:");
//            int codigoBusca;
//            codigoBusca = scanner.nextInt();
//            listaFuncionario.removePorCodigo(codigoBusca);
//            listaFuncionario.imprimeLista();

//            System.out.println("\n\n\t\tBUSCA\nInsira o codigo: ");
//            int codigoBusca = scanner.nextInt();
//            listaFuncionario.buscaPorCodigo(codigoBusca);
        }

        else {
            System.out.println("FIM");
        }
    }

}