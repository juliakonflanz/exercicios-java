package listaEncadeada;

public class No<listaEncadeada>{
    private No proximo, anterior;
    private Funcionario funcionario;

    public No(listaEncadeada funcionario) {
        this.funcionario = (Funcionario) funcionario;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(listaEncadeada funcionario) {
        this.funcionario = (Funcionario) funcionario;
    }

}
