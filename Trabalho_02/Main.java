package Estrutura_de_dados.Trabalho_02;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String base = "Alunos.csv";
        List<Aluno> listaAlunos = new ArrayList<>();

        Funcoes.popularLista(listaAlunos, base);
        Funcoes.exibirLista(listaAlunos);

        Funcoes.ordenarLista(listaAlunos);
        Funcoes.exibirLista(listaAlunos);

        Funcoes.buscarPorNome(listaAlunos);

        Map<Integer, Integer> contagem = Funcoes.alunosCadaAno(listaAlunos);
        System.out.println(contagem);
    }
    
}
