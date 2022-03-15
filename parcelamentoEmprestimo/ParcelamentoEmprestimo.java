import java.math.BigDecimal;
import java.util.Scanner;
import java.math.RoundingMode;

public class Parcelamentoemprestimo {

    public static void main(String[] args) {

        BigDecimal emprestimo, qtdeParcelas, valorParcelas, diferenca, auxDiferenca, somaParcelas;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Valor do emprestimo: ");
        emprestimo = new BigDecimal(scanner.nextLine());

        System.out.println("Quantidade de parcelas: ");
        qtdeParcelas = new BigDecimal(scanner.nextLine());

        System.out.println("-------------------");
        System.out.println("Parcelamento");
        System.out.println("-------------------");

        valorParcelas = emprestimo.divide(qtdeParcelas,2, RoundingMode.HALF_DOWN);
        diferenca = emprestimo.subtract((valorParcelas).multiply(qtdeParcelas));

        int intqtdeParcelas = qtdeParcelas.intValue();
        auxDiferenca = diferenca;

        for(int cont=0; cont<intqtdeParcelas; cont+=1){
            System.out.format("Parcela "+ (cont+1) +": R$ %.2f\n", valorParcelas.add(auxDiferenca));
            auxDiferenca = diferenca.subtract(diferenca);
        }

        somaParcelas = (valorParcelas.multiply(qtdeParcelas)).add(diferenca);

        System.out.println("-------------------");
        System.out.format("Total.....: R$ %.2f", somaParcelas);

        scanner.close();
    }
    
}