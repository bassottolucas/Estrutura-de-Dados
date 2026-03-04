import random

def popular_lista_aleatoria(lista, quantidade, faixa_inicial, faixa_final):
    """_summary_

    Args:
        lista (_type_): _description_
        quantidade (_type_): _description_
        faixa_inicial (_type_): _description_
        faixa_final (_type_): _description_
    """
   
    for i in range(quantidade):
        lista.append( random.randint(faixa_inicial, faixa_final))


def exibir_lista(lista):
    """metodo que recebe uma lista e a exibe elementos um abaixo do outro 

    Args:
        lista (_type_): _description_
    """
    for item in lista:
        print(item)

    print("-----------")
    print("total de elementos: ", len(lista))

    def copiar_lista_sem_replicados(lista_origem, lista_destino):
        """_summary_

        Args:
            lista_origem (_type_): lista original contando todos os numeros
            lista_destino (_type_): lista final contando somente os numeros replicados 
        """
        for item in lista_origem:
            if item not in lista_destino:
                lista_destino.append(item)