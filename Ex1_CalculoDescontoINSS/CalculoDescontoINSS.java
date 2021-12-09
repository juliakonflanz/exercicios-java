import java.util.Scanner;

public class CalculoDescontoINSS {
        public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor do salário: ");
        double salario = scanner.nextDouble();

        double tetoFaixa1 = 1100;
        double aliquotaFaixa1 = 0.075;

        double tetoFaixa2 = 2203.48;
        double aliquotaFaixa2 = 0.09;

        double tetoFaixa3 = 3305.22;
        double aliquotaFaixa3 = 0.12;

        double tetoFaixa4 = 6433.57;
        double aliquotaFaixa4 = 0.14;

        double descontoINSS = 0;

        if(salario <= tetoFaixa1){
            descontoINSS = aliquotaFaixa1 * salario;
        }

        else if(salario <= tetoFaixa2){
            descontoINSS = aliquotaFaixa2 * salario;
        }

        else if(salario <= tetoFaixa3){
            descontoINSS = aliquotaFaixa3 * salario;
        }

        else if(salario <= tetoFaixa4){
            descontoINSS = aliquotaFaixa4 * salario;
        }

        else if(salario > tetoFaixa4){
            descontoINSS = aliquotaFaixa4 * tetoFaixa4;
        }

        else{
            System.out.println("salario invalido.");
        }

        System.out.format("O desconto do INSS, neste caso, é de R$ %.2f", descontoINSS);

        scanner.close();
    }
    
}