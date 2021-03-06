package listaEncadeada;

import javafx.collections.ObservableList;
import static javafx.collections.FXCollections.observableArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Lista<listaEncadeada>{

    private No<listaEncadeada> inicio, fim;

    public Lista() {
        inicio = null;
        fim = null;
    }

    public boolean listaVazia() {
        return inicio == null && fim == null;
    }

    public int tamanhoLista() {
        No posicao = inicio;
        int tamanho = 0;
        while (posicao != null) {
            tamanho++;
            posicao = posicao.getProximo();
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

    public void insereNoInicio(listaEncadeada funcionario) {
        No posicao = new No(funcionario);
        posicao.setProximo(inicio);
        if (inicio != null) {
            inicio.setAnterior(posicao);
        }
        inicio = posicao;
        if (fim == null) {
            fim = posicao;
        }
    }

    public void insereNoFim(listaEncadeada funcionario) {
        No posicao = new No(funcionario);
        posicao.setAnterior(fim);
        if(fim != null) {
            fim.setProximo(posicao);
        }
        fim = posicao;
        if (inicio == null) {
            inicio = posicao;
        }
    }

    public void removeNoInicio() {
        try {
            listaEncadeada funcionario = (listaEncadeada) inicio.getFuncionario();
            inicio = inicio.getProximo();
            if (inicio == null) {
                fim = null;
            } else {
                inicio.setAnterior(null);
            }
            System.out.println("Removido: \n" + funcionario +"\n");
        } catch (NullPointerException e){
            System.out.println("Sem registros para remover.");
        }
    }

    public listaEncadeada removeNoFim()  {
        try {
            listaEncadeada funcionario = (listaEncadeada) fim.getFuncionario();
            fim = fim.getAnterior();
            if (fim == null) {
                inicio = null;
            } else {
                fim.setProximo(null);
            }
            System.out.println("Removido: \n" + funcionario +"\n");
            return funcionario;
        } catch (NullPointerException e){
            System.out.println("Sem registros para remover.");
            return null;
        }
    }

    public void removePorCodigo(int codFuncionario) throws IOException {
        No posicao = inicio;
        boolean troca = false;
        while (posicao != null) {
            if (posicao.getFuncionario().getCodFuncionario() == codFuncionario) {
                troca=true;
            }
            if(troca && posicao.getProximo()!=null) {
                posicao.setFuncionario((listaEncadeada) posicao.getProximo().getFuncionario());
            }
            posicao = posicao.getProximo();
        }
        removeNoFim();
        salvaArquivo();
    }

    public void limpaLista() {
        while (!this.listaVazia()) {
            this.removeNoInicio();
        }
    }

    public void ordenaPorNome() {
        boolean ordem;
        Funcionario funcionario;
        do {
            No posicao = inicio;
            ordem = true;
            while (posicao.getProximo() != null) {
                if (posicao.getFuncionario().getNome().compareTo(posicao.getProximo().getFuncionario().getNome())>0) {
                    funcionario = posicao.getFuncionario();
                    posicao.setFuncionario((listaEncadeada) posicao.getProximo().getFuncionario());
                    posicao.getProximo().setFuncionario(funcionario);
                    ordem = false;
                }
                posicao = posicao.getProximo();
            }
        }while (!ordem);
    }

    public void ordenaPorCodigo() {
        boolean ordem;
        Funcionario funcionario;
        do {
            No posicao = inicio;
            ordem = true;
            while (posicao.getProximo() != null) {
                if (posicao.getFuncionario().getCodFuncionario() > posicao.getProximo().getFuncionario().getCodFuncionario()) {
                    funcionario = posicao.getFuncionario();
                    posicao.setFuncionario((listaEncadeada) posicao.getProximo().getFuncionario());
                    posicao.getProximo().setFuncionario(funcionario);
                    ordem = false;
                }
                posicao = posicao.getProximo();
            }
        }while (!ordem);
    }

    public String somaSalarios() {
        No posicao = inicio;
        double somaSalario = 0;
        while (posicao != null) {
            somaSalario += Double.parseDouble(posicao.getFuncionario().getValorSalario());
            posicao = posicao.getProximo();
        }
        return String.valueOf(somaSalario);
    }

    public String mediaSalarios(){
        return String.valueOf(Double.parseDouble(this.somaSalarios())/this.tamanhoLista());
    }

    public String maiorSalario() {
        No posicao = inicio;
        double maiorSalario = 0;
        while (posicao != null) {
            if (Double.parseDouble(posicao.getFuncionario().getValorSalario()) > maiorSalario) {
                maiorSalario = Double.parseDouble(posicao.getFuncionario().getValorSalario());
            }
            posicao = posicao.getProximo();
        }
        return String.valueOf(maiorSalario);
    }

    public String menorSalario(){
        No posicao = inicio;
        double menorSalario = Double.parseDouble(posicao.getFuncionario().getValorSalario());
        while (posicao != null) {
            if (Double.parseDouble(posicao.getFuncionario().getValorSalario()) <= menorSalario) {
                menorSalario = Double.parseDouble(posicao.getFuncionario().getValorSalario());
            }
            posicao = posicao.getProximo();
        }
        return String.valueOf(menorSalario);
    }

    private String formataCodigo(int codFuncionario) {
        String txtCodFuncionario = "" + codFuncionario;
        while (txtCodFuncionario.length() < 6){
            txtCodFuncionario = "0" + txtCodFuncionario;
        }
        return txtCodFuncionario;
    }

    private String formataNome(String nomeFuncionario) {
        while (nomeFuncionario.length() < 100){
            nomeFuncionario = nomeFuncionario + "";
        }
        return nomeFuncionario;
    }

    private String formataSalario(String valorSalario) {
        while (valorSalario.length() < 16){
            valorSalario = "0" + valorSalario;
        }
        return valorSalario;
    }

    public String trocaSalario(String salario) {
        DecimalFormat formatado = new DecimalFormat("#,##0.00");
        formatado.setRoundingMode(RoundingMode.FLOOR);
        return formatado.format(Double.parseDouble(salario));
    }

    private void criaArquivo(String nomeArquivo) throws IOException {
        No posicao = inicio;
        FileWriter arquivo = new FileWriter("C:\\Users\\julia\\OneDrive\\Documentos\\Scadi\\Treinamento\\Ex8_InterfaceCadastro\\src\\main\\java\\listaEncadeada\\arquivos\\" + nomeArquivo);
        PrintWriter gravaArquivo = new PrintWriter(arquivo);
        while (posicao != null) {
            gravaArquivo.printf("CodFuncionario -> " + formataCodigo(posicao.getFuncionario().getCodFuncionario()));
            gravaArquivo.printf("\nNome -> " + formataNome(posicao.getFuncionario().getNome()));
            gravaArquivo.printf("\nValorSalario -> " + formataSalario(posicao.getFuncionario().getValorSalario()));
            gravaArquivo.printf("\nDataAdmissao -> " + posicao.getFuncionario().getDataAdimissao()+"\n");
            posicao = posicao.getProximo();
        }
        arquivo.close();
    }

    public void salvaArquivo() throws IOException {
        try {
            this.criaArquivo("funcionario.dat");
            this.ordenaPorCodigo();
            this.criaArquivo("funcionario_idx01.idx");
            this.ordenaPorNome();
            this.criaArquivo("funcionario_idx02.idx");
        } catch (NullPointerException e ){
            System.out.println("N??o H?? Registros para gravar");
        }
    }

    public void salvaPorArquivo(Scanner in) {
        int contLine=0;
        String nomeFuncionario = null, valorSalario = null, dataAdmissao = null;
        int codFuncionario = 0;
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
                String dia,mes,ano;
                dataAdmissao = line.substring(16);
                ano = dataAdmissao.substring(0,4);
                mes = dataAdmissao.substring(5,7);
                dia = dataAdmissao.substring(8,10);
                dataAdmissao = dia+"/"+mes+"/"+ano;
            }
            if(contLine%4==0){
                this.insereNoFim((listaEncadeada) new Funcionario(codFuncionario, nomeFuncionario, valorSalario, dataAdmissao));
            }
        }
    }

    public void leArquivo() {
        try {
            FileReader file = new FileReader("C:\\Users\\julia\\OneDrive\\Documentos\\Scadi\\Treinamento\\Ex8_InterfaceCadastro\\src\\main\\java\\listaEncadeada\\arquivos\\funcionario.dat");
            Scanner in = new Scanner(file);
            this.salvaPorArquivo(in);
        } catch (FileNotFoundException e){
            System.out.println("Arquivo n??o encontrado");
        }
    }

    public ObservableList<Funcionario> listaObservable() {
        ObservableList<Funcionario> listaFuncionarios = observableArrayList();
        limpaLista();
        leArquivo();
        No posicao = inicio;
        while (posicao != null) {
            listaFuncionarios.add(posicao.getFuncionario());
            posicao = posicao.getProximo();
        }
        return observableArrayList(listaFuncionarios);
    }

}