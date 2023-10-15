package exer19;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
/*
Elaborar um programa em Java para imprimir:
- Quais empregados(cpf, nome) estão em um determinado projeto;
- Em quais projetos(código, nome) estão um determinado empregado;
- Qual empregado é gerente de outros;
*/
public class Principal {
    public static void main(String[] args) {
        Scanner inputNumber = new Scanner(System.in);
        // Criação de Empregados
        Empregado emp1 = new Empregado(1111, "Pedro");
        Empregado emp2 = new Empregado(2222, "Ana");
        Empregado emp3 = new Empregado(3333, "Marcos");
        Empregado emp4 = new Empregado(4444, "Julia");
        Empregado emp5 = new Empregado(5555, "Carlos");
        Empregado emp6 = new Empregado(6666, "Mario");
        List<Empregado> empregados = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
        // Criação de Projetos
        Projeto proj1 = new Projeto(1000, "Snake Game");
        Projeto proj2 = new Projeto(2000, "Xadrez master");
        Projeto proj3 = new Projeto(3000, "Minefield");
        List<Projeto> projetos = Arrays.asList(proj1, proj2, proj3);
        // Criando Gerentes
        emp2.setGerente(emp1); // Pedro
        emp3.setGerente(emp1); // Pedro
        emp5.setGerente(emp4); // Julia
        emp6.setGerente(emp4); // Julia
        // Add empregados em projetos
        proj1.addEmpregado(emp1);
        proj1.addEmpregado(emp2);
        proj1.addEmpregado(emp3);
        proj2.addEmpregado(emp4);
        proj2.addEmpregado(emp5);
        proj2.addEmpregado(emp6);
        
        System.out.println("=-=-=-=-= Empregados =-=-=-=-=");
        for (int i = 0, tamVetor = empregados.size(); i < tamVetor; i++) {
            System.out.print(i + "- ");
            empregados.get(i).mostrarInfo();
        }
        System.out.println("=-=-=-=-=-= Projetos =-=-=-=-=-=");
        for (int i = 0, tamVetor = projetos.size(); i < tamVetor; i++) {
            System.out.print(i + "- ");
            projetos.get(i).mostrarInfo();
        }
        // Analises
        byte opcao;
        do {
            System.out.println("=-=-=-=-=-= Menu =-=-=-=-=-=");
            System.out.println("1- Empregados de um determinado Projeto");
            System.out.println("2- Projetos que um determinado Empregado pertence");
            System.out.println("3- Gerente de quem");
            System.out.println("4- Sair do programa...");
            System.out.print(">> ");
            opcao = inputNumber.nextByte();
            
            switch (opcao) {
                case 1 -> {
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.print("Projeto (indice) >> ");
                    int indice = inputNumber.nextInt();
                    Projeto projeto = projetos.get(indice);
                    
                    System.out.println("Empregados que estao no projeto " + projeto.getNome() + ":");
                    projeto.mostrarEmpregados();
                }
                case 2 -> {
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.print("Empregado (indice) >> ");
                    int indice = inputNumber.nextInt();
                    Empregado empregado = empregados.get(indice);
                    
                    System.out.println("Projetos que " + empregado.getNome() + " participa:");
                    empregado.projetosQueParticipa(projetos);
                }
                case 3 -> {
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.print("Empregado (indice) >> ");
                    int indice = inputNumber.nextInt();
                    Empregado empregado = empregados.get(indice);
                    
                    System.out.println(empregado.getNome() + " e gerente de:");
                    empregado.subordinados(empregados);
                }
                case 4 -> {
                    System.out.println("Fim do Programa...");
                }
                default -> {
                    System.err.println("Opcao invalida!");
                }
            }
        } while (opcao != 4);
    }
}
