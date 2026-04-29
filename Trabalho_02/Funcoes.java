package Estrutura_de_dados.Trabalho_02;
import java.io.*;
import java.util.*;

public class Funcoes {
    public static void popularLista(List<Aluno> lista, String base) {
        try (BufferedReader br = new BufferedReader(new FileReader(base))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] vetorLinha = linha.split(",");
                Aluno obj = new Aluno(vetorLinha[0], vetorLinha[1], vetorLinha[2], Integer.parseInt(vetorLinha[3]));
                

                lista.add(obj);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void exibirLista(List<Aluno> lista) {
        for (Aluno a : lista) {
            System.out.println(a);
        }
        System.out.println("");
    }

    public static void ordenarLista(List<Aluno> lista, int opcao) {
    if (opcao == 1) {
        lista.sort(Comparator.comparing(Aluno::getAnoIngresso)
                             .thenComparing(Aluno::getNome));
        System.out.println("\nLista Ordenada por Ano ");
    } else {
        lista.sort(Comparator.comparing(Aluno::getNome));
        System.out.println("\nLista Ordenada por Nome ");
    }
}
    

    public static void buscarPorNome(List<Aluno> lista) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um nome: ");
        String nomeBusca = sc.nextLine().toLowerCase();

        for (Aluno aluno : lista) {
            if (aluno.getNome().toLowerCase().contains(nomeBusca)) {
                System.out.println(aluno + "\n");
                return;
            }
        }
        System.out.println("Nome não encontrado!\n");
    }

    public static Map<Integer, Integer> alunosCadaAno(List<Aluno> lista) {
        Map<Integer, Integer> quantidade = new HashMap<>();
        for (Aluno aluno : lista) {
            int ano = aluno.getAnoIngresso();
            quantidade.put(ano, quantidade.getOrDefault(ano, 0) + 1);
        }
        return quantidade;
    }
    
}
