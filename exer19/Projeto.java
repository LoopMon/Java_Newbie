package exer19;
import java.util.List;
import java.util.ArrayList;
/*
Elaborar um programa em Java para imprimir:
- Quais empregados (cpf, nome) estão em um determinado projeto;
- Em quais projetos(código, nome) estão um determinado empregado;
- Qual empregado é gerente de outros;
*/
public class Projeto {
    private int codigo;
    private String nome;
    private List<Empregado> empregados = new ArrayList<>();
    
    public Projeto(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public void mostrarInfo() {
        System.out.print("Codigo: " + this.codigo);
        System.out.println(", Nome: " + this.nome);
    }
    
    public void mostrarEmpregados() {
        if (!this.empregados.isEmpty()) {
            for (Empregado empregado : this.empregados) {
                empregado.mostrarInfo();
            }
        } else {
            System.out.println("Não há empregados no projeto");
        }
    }
    
    public boolean empregadoPertence(Empregado empregadoEspecifico) {
        boolean pertence = this.empregados.contains(empregadoEspecifico);
        return pertence;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Empregado> getEmpregados() {
        return this.empregados;
    }
    
    public void addEmpregado(Empregado empregado) {
        this.empregados.add(empregado);
    }   
}
