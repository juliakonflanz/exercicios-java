import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Funcionario {

    private int codFuncionario;
    private String nome;
    private String valorSalario;
    private LocalDate dataAdmissao; LocalDate dataAtual = LocalDate.now();
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Funcionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(String valorSalario) {
        this.valorSalario = valorSalario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = LocalDate.parse(dataAdmissao, formato);
    }

    public long tempodeEmpresa(){
        return ChronoUnit.DAYS.between(this.dataAdmissao, dataAtual);
    }

    @Override
    public String toString() {
        return "\n\nFUNCIONARIO\nCodigo: "+codFuncionario+"\nNome: "+nome+"\nSalario: R$ "+valorSalario+"\nTempo de empresa (em dias): "+tempodeEmpresa();
    }
}