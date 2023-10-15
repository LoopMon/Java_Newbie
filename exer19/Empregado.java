package exer19;
import java.util.List;
import java.util.ArrayList;
/*
Elaborar um programa em Java para imprimir:
- Quais empregados (cpf, nome) estão em um determinado projeto;
- Em quais projetos(código, nome) estão um determinado empregado;
- Qual empregado é gerente de outros;
*/
public class Empregado {
    private int cpf;
    private String nome;
    private Empregado gerente;
    
    public Empregado(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    
    public void mostrarInfo() {
        System.out.print("CPF: " + this.cpf);
        System.out.println(", Nome: " + this.nome);
    }
    
    public boolean meuGerente(Empregado gerente) {
        return this.gerente == gerente;
    }
    
    public void projetosQueParticipa(List<Projeto> projetos) {
        for (Projeto projeto : projetos) {
            if (projeto.empregadoPertence(this)) {
                projeto.mostrarInfo();
            }
        }
    }
    
    public void subordinados(List<Empregado> empregados) {
        for (Empregado empregado : empregados) {
            if (empregado.meuGerente(this)) {
                empregado.mostrarInfo();
            }
        }
    }
    
    public int getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGerente() {
        if (this.gerente == null) {
            return "Empregado não possui Gerente";
        } 
        return this.gerente.getNome();
    }

    public void setGerente(Empregado gerente) {
        this.gerente = gerente;
    }
}
