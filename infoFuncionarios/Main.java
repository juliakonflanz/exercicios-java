import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class Main {

    public static void Main(String[] args)  {

        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

        while(true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\t\tNOVO FUNCIONARIO\nCodigo: ");
            int codFuncionario;
            codFuncionario = scanner.nextInt();

            if (codFuncionario == 0) {
                break;
            }

            else {
                listaFuncionarios.add(new Funcionario(codFuncionario));

                System.out.println("Nome do funcionario: ");
                listaFuncionarios.get(listaFuncionarios.size() - 1).setNome(scanner.next());

                System.out.println("Valor do salário do funcionario: R$ ");
                listaFuncionarios.get(listaFuncionarios.size() - 1).setValorSalario(scanner.next());

                System.out.println("Data de admissão do funcionario [dd/mm/aaaa]: ");
                listaFuncionarios.get(listaFuncionarios.size() - 1).setDataAdmissao(scanner.next());
            }
        }

        if(listaFuncionarios.isEmpty()){
            System.out.println("Lista de funcionarios vazia.");
        }

        else {
            System.out.println("\t\tDADOS DA EMPRESA");

            int colaboradores = listaFuncionarios.size();
            System.out.println("Total de funcionarios: "+ colaboradores);

            System.out.println("\nFuncionários e tempo de empresa: "+ listaFuncionarios);

            double somaSalarios = listaFuncionarios.stream().mapToDouble(Func -> Double.parseDouble(Func.getValorSalario())).sum();
            System.out.printf("\nSoma dos salarios: R$ %.2f\n", somaSalarios);

            double mediaSalarios = somaSalarios / colaboradores;
            System.out.printf("\nMedia dos salarios: R$ %.2f\n", mediaSalarios);

            Comparator<Funcionario> comparaSalarios = (funcionario1, funcionario2) -> {
                if(Double.parseDouble(funcionario1.getValorSalario()) >= Double.parseDouble(funcionario2.getValorSalario())) {
                    return 1;
                }
                if(Double.parseDouble(funcionario1.getValorSalario()) < Double.parseDouble(funcionario2.getValorSalario())) {
                    return -1;
                }
                return 0;
            };

            System.out.println("\nFuncionario com maior salario: " + listaFuncionarios.stream().max(comparaSalarios));

            System.out.println("\nFuncionario com menor salario: "+  listaFuncionarios.stream().min(comparaSalarios));
        }
    }

}