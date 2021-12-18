import java.io.*;
import java.util.Scanner;

public class Lista {

    private No inicio;
    private No fim;

    public Lista() {
        inicializa();
    }

    public void inicializa() {
        inicio = null;
        fim = null;
    }

    public int tamanhoLista() {
        No posicao = inicio;
        int tamanho = 0;
        if (posicao == null) {
            System.out.println("Lista vazia.");
        }
        else {
            tamanho = 1;
            while (posicao != fim) {
                tamanho += 1;
                posicao = posicao.getProximo();
            }
        }
        return tamanho;
    }

    public void imprimeLista() {
        No posicao = inicio;
        if (posicao == null) {
            System.out.println("Lista vazia.");
        }
        else {
            while (posicao != null) {
                System.out.println(posicao.getFuncionario());
                posicao = posicao.getProximo();
            }
        }
    }

    public void insereNoComeco(Funcionario funcionario) {
        No novo = new No(funcionario);
        if (inicio == null) {
            inicio = fim = novo;
        }
        else {
            inicio.setAnterior(novo);
            inicio = novo;
        }
    }

    public void insereNoFim(Funcionario funcionario) {
        No novo = new No(funcionario);
        if (inicio == null)
            inicio = fim = novo;
        else {
            fim.setProximo(novo);
            fim = novo; // tirar o fim do else
        }
    }

    public Object removeNoComeco() {
        Funcionario funcionario = inicio.getFuncionario();
        inicio = inicio.getProximo();
        if(inicio == null) {
            fim = null;
        }
        else {
            inicio.setAnterior(null);
        }
        return funcionario;
    }

    public Object removeNoFim() {
        Funcionario funcionario = fim.getFuncionario();
        fim = fim.getAnterior();
        if(fim == null) {
            inicio = null;
        }
        else {
            fim.setProximo(null);
        }
        return funcionario;
    }

    public void removePorCodigo(int codigo) {
        No posicao = inicio;
        while ((posicao != null) && (posicao.getFuncionario().getCodFuncionario() != codigo)) {
            posicao = posicao.getProximo();
        }
        if ((posicao != null) && (posicao.getFuncionario().getCodFuncionario() == codigo)) {
            if (inicio != fim) {
                if (posicao == inicio) {
                    inicio = posicao.getProximo();
                    posicao.getProximo().setAnterior(null);
                    System.out.println("Funcionario removido do inicio da lista.");
                }
                else if (posicao == fim) {
                    fim = posicao.getAnterior();
                    posicao.getAnterior().setProximo(null);
                    System.out.println("Funcionario removido do final da lista.");
                }
                else {
                    posicao.getAnterior().setProximo(posicao.getProximo());
                    posicao.getProximo().setAnterior(posicao.getAnterior());
                    System.out.println("Funcionario removido do meio da lista.");
                }
                posicao.setAnterior(null);
                posicao.setProximo(null);
            }
            else {
                System.out.println("Lista vazia.");
            }
        }
        else {
            System.out.println("Funcionario nao encontrado.");
        }
    }

    public Funcionario buscaPorCodigo(int codigo) {
        No posicao = inicio;
        Funcionario funcionario = posicao.getFuncionario();
        int busca;
        while ((posicao != null) && (posicao.getFuncionario().getCodFuncionario() != codigo)) {
            posicao = posicao.getProximo();
        }
        if ((posicao != null) && (posicao.getFuncionario().getCodFuncionario() == codigo)) {
            System.out.println(posicao.getFuncionario());
        }
        else {
            System.out.println("Funcionario nao encontrado.");
        }
        return funcionario;
    }

    public double somaTodosSalarios() {
        No posicao = inicio;
        double somaSalarios = 0;
        while (posicao != null) {
            somaSalarios += Double.parseDouble(posicao.getFuncionario().getValorSalario());
            posicao = posicao.getProximo();
        }
        return somaSalarios;
    }

    public double mediaTodosSalarios() {
        double soma, mediaSalarios;
        int tamanho;
        soma = somaTodosSalarios();
        tamanho = tamanhoLista();
        mediaSalarios = soma/tamanho;
        return mediaSalarios;
    }

    public Funcionario maiorSalario() {
        No posicao = inicio;
        Funcionario funcionario = posicao.getFuncionario();
        double salario, maior = 0;
        while (posicao != null) {
            salario = Double.parseDouble(posicao.getFuncionario().getValorSalario());
            if (salario > maior) {
                maior = salario;
                funcionario = posicao.getFuncionario();
            }
            posicao = posicao.getProximo();
        }
        return funcionario;
    }

    public Funcionario menorSalario() {
        No posicao = inicio;
        Funcionario funcionario = posicao.getFuncionario();
        double salario, menor = 0;
        menor = Double.parseDouble(posicao.getFuncionario().getValorSalario());
        while (posicao != null) {
            salario = Double.parseDouble(posicao.getFuncionario().getValorSalario());
            if (salario < menor) {
                menor = salario;
                funcionario = posicao.getFuncionario();
            }
            posicao = posicao.getProximo();
        }
        return funcionario;
    }

    public void ordenaCodigo() {
        boolean substitui;
        Funcionario funcionario;
        do {
            No posicao = inicio;
            substitui = false;
            while (posicao.getProximo() != null) {
                if (posicao.getFuncionario().getCodFuncionario() > posicao.getProximo().getFuncionario().getCodFuncionario()) {
                    funcionario = posicao.getFuncionario();
                    posicao.setFuncionario(posicao.getProximo().getFuncionario());
                    posicao.getProximo().setFuncionario(funcionario);
                    substitui=true;
                }
                posicao = posicao.getProximo();
            }
        }while (substitui);
    }

    public void ordenaNome() {
        boolean substitui;
        Funcionario auxFuncionario;
        do {
            No posicao = inicio;
            substitui = false;
            while (posicao.getProximo() != null) {
                if (posicao.getFuncionario().getNome().compareTo(posicao.getProximo().getFuncionario().getNome())>0) {
                    auxFuncionario = posicao.getFuncionario();
                    posicao.setFuncionario(posicao.getProximo().getFuncionario());
                    posicao.getProximo().setFuncionario(auxFuncionario);
                    substitui=true;
                }
                posicao = posicao.getProximo();
            }
        }while (substitui);
    }

    private String formataCodFuncionario(int codFuncionario) {
        String txtCodFuncionario = "" + codFuncionario;
        while (txtCodFuncionario.length()<6) {
            txtCodFuncionario = "0" + txtCodFuncionario;
        }
        return txtCodFuncionario;
    }

    private String formataNomeFuncionario(String nomeFuncionario) {
        while (nomeFuncionario.length()<100) {
            nomeFuncionario = nomeFuncionario + " ";
        }
        return nomeFuncionario;
    }

    private String formataValorSalario(String valorSalario) {
        while (valorSalario.length()<16) {
            valorSalario = "0" + valorSalario;
        }
        return valorSalario;
    }

    private void criaArquivo(String nomeArquivo) throws IOException {
        No posicao = inicio;
        FileWriter arquivo = new FileWriter("C:\\Users\\julia\\OneDrive\\Documentos\\Scadi\\Treinamento\\Ex7_Arquivos" + nomeArquivo);
        PrintWriter grava = new PrintWriter(arquivo);
        while (posicao != null) {
            grava.printf("CodFuncionario -> " + formataCodFuncionario(posicao.getFuncionario().getCodFuncionario()));
            grava.printf("\nNome -> " + formataNomeFuncionario(posicao.getFuncionario().getNome()));
            grava.printf("\nValorSalario -> " + formataValorSalario(posicao.getFuncionario().getValorSalario()));
            grava.printf("\nDataAdmissao -> " + posicao.getFuncionario().getDataAdmissao()+"\n");
            posicao = posicao.getProximo();
        }
        arquivo.close();
    }

    public void salvaArquivo() throws IOException {
        try {
            this.criaArquivo("funcionario.dat");
            this.ordenaCodigo();
            this.criaArquivo("funcionario_idx01.idx");
            this.ordenaNome();
            this.criaArquivo("funcionario_idx02.idx");
        } catch (NullPointerException e ){
            System.out.println("Erro, sem registros.");
        }
    }

    public void adicionaPorArquivo(Scanner in) {
        int contLine = 0, codFuncionario = 0;
        String nomeFuncionario = null, valorSalario = null, dataAdmissao = null;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            contLine++;
            if (line.startsWith("CodFuncionario -> ")) {
                int indice = 18;
                while (line.charAt(indice) == '0') {
                    indice++;
                }
                codFuncionario = Integer.parseInt(line.substring(indice));
            }
            if (line.startsWith("Nome -> ")) {
                int indice = 8;
                while (line.charAt(indice) == '0') {
                    indice++;
                }
                nomeFuncionario = line.substring(indice);
            }
            if (line.startsWith("ValorSalario -> ")) {
                int indice = 16;
                while (line.charAt(indice) == '0') {
                    indice++;
                }
                valorSalario = line.substring(indice);
            }
            if (line.startsWith("DataAdmissao -> ")) {
                String dia, mes, ano;
                dataAdmissao = line.substring(16);
                ano = dataAdmissao.substring(0,4);
                mes = dataAdmissao.substring(5,7);
                dia = dataAdmissao.substring(8,10);
                dataAdmissao = dia + "/" + mes + "/" + ano;
            }
            if (contLine%4==0) {
                this.insereNoFim(new Funcionario(codFuncionario, nomeFuncionario, valorSalario, dataAdmissao));
            }
        }
    }

    public void leArquivo() {
        try {
            FileReader file = new FileReader("C:\\Users\\julia\\OneDrive\\Documentos\\Scadi\\Treinamento\\Ex7_Arquivos\\funcionario.dat");
            Scanner scanner = new Scanner(file);
            this.adicionaPorArquivo(scanner);
        } catch (FileNotFoundException e){
            System.out.println("Erro, arquivo não encontrado.");
        }
    }

}
