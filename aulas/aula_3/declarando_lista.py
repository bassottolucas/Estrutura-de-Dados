from biblioteca import popular_lista_aleatoria, exibir_lista, copiar_lista_sem_replicados

#declarando a lista em python
lista_numeros = []

#revelando a quantidade de numeros a serem gerados aleatoriamente
quantidade_numeros = int(input("Digite quantos números gostaria de armazenar: "))

#definindo a faixa de intervalo dos numeros a serem sorteados
fase_inicial = 10
fase_final = 50

popular_lista_aleatoria(lista_numeros, quantidade_numeros, fase_inicial, fase_final)
exibir_lista(lista_numeros)

lista_resultado = []
copiar_lista_sem_replicados(lista_numeros, lista_resultado)
lista_resultado.sort()
exibir_lista(lista_resultado)