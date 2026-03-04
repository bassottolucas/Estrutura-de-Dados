#include <iostream>
#include <cstdlib> 
#include<ctime>
#include <vector> //para a lista

using namespace std;

/**
 * @brief metodo que popula numeros inteiros dentro
 * 
 * @param lista contem os numeros aleatorios gerados
 * @param quantidadeNumeros contem quantos numeros se deseja inserir na tela
 * @param faixaInicial contem o numero inicial da faixa 
 * @param faixaFinal contem o numero final da faixa 
 */

void popularListaAleatoria(vector<int> &lista, int quantidadeNumeros, int faixaInicial, int faixaFinal){
     //observe o simbolo & na frente de variável lista. Isso acontece pq em C++ se houver alteração na lista
    // precisa usar o simbolo de endereçamento &

    srand(time(NULL));
    int numeroSorteado;
    for(int i = 0; i < quantidadeNumeros){
        numeroSorteado = faixaInicial + (rand() % faixaFinal);
        lista.push_back(numeroSorteado);
    }
}
/**
 * @brief método que recebe uma lista e a exibe, elementos um abaixo do outro
 * 
 * @param lista lista contendo números inteiros
 */

void exibirLista(vector<int> lista){
    for(int i = 0; i < lista.size() ; i++){
        cout << lista[i] << "\n";
    }
    cout << "--------";
    cout << "total de elementos:" <<lista.size()<<
    "\n";

/**
 * @brief metodo que copia os numeros da lista origem para lista destino exceto os repetidos
 * @param listaOrigem contem os numeros originais da lista
 * 
 * @param listaDestino lista final contendo somente os números não replicados
 */

void copiarListaSemReplicados(vector<int> listaOrigem, vector<int> &listaDestino)
    int numeroTemporario = 0;
    int flag = 0;
    for(int i = 0; i < listaOrigem.size(); i++)
    {
        numeroTemporario = listaOrigem[i];
        for(int j = 0; j < listaDestino.size(); j++);
        {
            flag = 1;
        }
    }
    if(flag == 1){
        listaDestino.push_back (numeroTemporario);
    }
    flag =0;
}

}