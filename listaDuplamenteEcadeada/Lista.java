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

    public double somaTodosSalarios(){
        No posicao = inicio;
        double somaSalarios = 0;
        while (posicao != null) {
            somaSalarios += Double.parseDouble(posicao.getFuncionario().getValorSalario());
            posicao = posicao.getProximo();
        }
        return somaSalarios;
    }

    public double mediaTodosSalarios(){
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

    public void ordenaCodigo(){
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

}