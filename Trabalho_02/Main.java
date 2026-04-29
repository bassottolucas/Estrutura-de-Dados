package Estrutura_de_dados.Trabalho_02;
import java.util.*;

public class Main {
  public static void main(String[] args) {
        String base = "Alunos.csv"; 
        List<Aluno> listaAlunos = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        Funcoes.popularLista(listaAlunos, base);

        if (listaAlunos.isEmpty()) {
            System.out.println("Erro: A lista está vazia, o arquivo não foi encontrado ou esta vazio ");
            return;
        }

        int escolha = 0;
        while (true) {
            System.out.println("Como deseja organizar a lista?");
            System.out.println("1 - Por Ano de Ingresso");
            System.out.println("2 - Por Nome");
            System.out.print("Escolha uma opção ");
            
            try {
                String entrada = teclado.nextLine();
                escolha = Integer.parseInt(entrada);

                if (escolha == 1 || escolha == 2) {
                    break; 
                } else {
                    System.out.println("\n[!] Opção inválida! Por favor, digite apenas 1 ou 2.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n[!] Erro: Você deve digitar um número (1 ou 2).\n");
            }
        }

        Funcoes.ordenarLista(listaAlunos, escolha);
        Funcoes.exibirLista(listaAlunos);

        Funcoes.buscarPorNome(listaAlunos);

        Map<Integer, Integer> contagem = Funcoes.alunosCadaAno(listaAlunos);
        System.out.println("Quantidade de ingressantes por ano:");
        System.out.println(contagem);
        
        teclado.close();
    }
}