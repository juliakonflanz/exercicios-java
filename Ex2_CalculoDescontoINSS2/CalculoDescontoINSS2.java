import java.util.Scanner;

public class CalculoDescontoINSS2 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o valor do salário: ");
        double salario = scanner.nextDouble();

        double tetoFaixa1 = 1100;
        double aliquotaFaixa1 = 0.075;
        double descontoFaixa1 = tetoFaixa1 * aliquotaFaixa1;

        double tetoFaixa2 = 2203.48;
        double aliquotaFaixa2 = 0.09;
        double descontoFaixa2 = ((tetoFaixa2 - tetoFaixa1) * aliquotaFaixa2) + descontoFaixa1;

        double tetoFaixa3 = 3305.22;
        double aliquotaFaixa3 = 0.12;
        double descontoFaixa3 = ((tetoFaixa3 - tetoFaixa2) * aliquotaFaixa3) + descontoFaixa2;

        double tetoFaixa4 = 6433.57;
        double aliquotaFaixa4 = 0.14;

        double descontoINSS = 0;

        if(salario<= tetoFaixa1){
            descontoINSS = descontoFaixa1;
        }

        else if(salario<= tetoFaixa2){
            descontoINSS = ((salario- tetoFaixa1) * aliquotaFaixa2) + descontoFaixa1;
        }

        else if(salario<= tetoFaixa3){
            descontoINSS = ((salario- tetoFaixa2) * aliquotaFaixa3) + descontoFaixa2;
        }

        else if(salario<= tetoFaixa4){
            descontoINSS = ((salario- tetoFaixa3) * aliquotaFaixa4) + descontoFaixa3;
        }

        else if(salario> tetoFaixa4){
            descontoINSS = ((tetoFaixa4 - tetoFaixa3) * aliquotaFaixa4) + descontoFaixa3;
        }

        else{
            System.out.println("salarioinvalido.");
        }

        System.out.format("O desconto do INSS, neste caso, é de R$ %.2f", descontoINSS);
        scanner.close();
    }

}
