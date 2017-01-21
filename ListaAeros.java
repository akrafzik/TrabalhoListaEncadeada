/*Alec Krafzik Haroutiounian         20402979
 Henrique Hideki Nobutaki            20021120
 José Fernandes da Silva Junior      20189911
 Luis Fernando de Souza Almeida Cruz 20391742
 Murilo Procópio da Costa Silva      20368549
 Renato Fernandes Ruiz               20400790*/
package ANAC;

public class ListaAeros {
//Definição de variaveis para a lista de Aeroportos

    NodeAeros primeiro, ultimo;
    int tamanho;
//Inicialização de variáveis

    public ListaAeros() {
        primeiro = ultimo = null;
        tamanho = 0;
    }

    public void CadastrarAeroporto(String Cidade, String Codigo) {
        /*Se a lista estiver vazia ele vai criar os nodes de referencia primeiro 
         e ultimo e inserir as informações no node primeiro*/
        if (IsEmpty()) {
            primeiro = ultimo = new NodeAeros();
            ListaVoos voos = new ListaVoos();
            primeiro.GetAero().setCidAero(Cidade);
            primeiro.GetAero().setCodAero(Codigo);
            primeiro.GetAero().setLV(voos);
            primeiro.setProximo(null);
            tamanho++;
        } else {
            //Criação do node novo e de nodes auxiliares para não perde a referencia
            NodeAeros novo = new NodeAeros();
            ListaVoos voos = new ListaVoos();
            novo.GetAero().setCidAero(Cidade);
            novo.GetAero().setCodAero(Codigo);
            novo.GetAero().setLV(voos);
            NodeAeros aux, antes;
            antes = aux = primeiro;
            //While para percorrer a lista de nodes e while para achar onde será inserido o aeroporto na lista seguindo a ordem alfabética
            while (aux != null && aux.GetAero().getCidAero().compareTo(Codigo) <= 0) {
                antes = aux;
                aux = aux.getProximo();
            }

            //Se ele for o primeiro na ordem alfabética logo de cara
            if (aux == primeiro) {
                novo.setProximo(primeiro);
                primeiro = novo;
                tamanho++;
            } /*Se o Node aux for nulo, ou seja ter percorrido a lista toda e 
             o nome inserido não é maior que ele no compare to em nenhum dos casos
             isso significa que o novo node será o ultimo da lista*/ else if (aux == null) {
                ultimo.setProximo(novo);
                ultimo = novo;
                tamanho++;
            } else {
                //Se for uma inserção no meio da lista
                novo.setProximo(aux);
                antes.setProximo(novo);
                tamanho++;
            }

        }
    }

    //Método auxiliar
    public int size() {
        return tamanho;
    }

    //Método auxiliar
    public boolean IsEmpty() {
        return primeiro == null;
    }

    public void imprimirAeros() {
        // Criação de definição de variáveis auxiliares
        NodeAeros aux;
        aux = primeiro;
        //Verificação se a lista está vazia e mensagem de erro
        if (IsEmpty()) {
            System.out.println("A lista está vazia, "
                    + "adicione um aeroporto antes de "
                    + "fazer esta verificação");
        } else {
            //Mensagem com a informação desejada
            while (aux != null) {
                System.out.println("O nome do aeroporto é: "
                        + aux.GetAero().getCidAero() + "\n O codigo do "
                        + "aeroporto é: " + aux.GetAero().getCodAero());
                aux = aux.getProximo();
            }
        }

    }

    public void ProcVoo(String CodOrg, String CodDest) {
        // definição de variaveis
        NodeAeros aaux, aaux2;
        int naux = 0;
        aaux = aaux2 = primeiro;
        NodeVoos aux, aux2;
        String vpaux;
        //while para percorrer a lista de aeroportos
        while (aaux != null && !aaux.GetAero().getCodAero().equals(CodDest)) {
            aaux = aaux.getProximo();
        }
        //se o codigo de origem nao for encontrado
        if (aaux == null) {
            System.out.println("Codigo de origem não encontrado, cadastre "
                    + "um aeroporto com esse código ou tente novamente");

        } else {
            //Se for
            aux = aaux.GetAero().getLV().primeiro;

            //verificação dos codigos de destino
            while (aux != null) {
                if (aux.getVoos().getCodDest().equals(CodDest)) {
                    naux = 1;
                    System.out.println("existe um voo para o destino escolhido");
                    break;
                } else {
                    aux = aux.getProximo();
                }

            }
            //Se codigo de destino for encontrado, verificar codigo de origem
            if (aux != null) {

                aaux = primeiro;
                while (aaux != null) {
                    aux = aaux.GetAero().LV.primeiro;
                    vpaux = aux.getVoos().getCodDest();
                    while (aaux2 != null) {
                        if (aaux2.GetAero().getCodAero().equals(vpaux)) {
                            aux2 = aaux2.GetAero().LV.primeiro;
                            while (aux2 != null) {
                                if (aux2.getVoos().getCodDest().equals(CodDest)) {
                                    System.out.println("existe um voo para o destino escolhido");
                                    break;
                                } else {
                                    aux2 = aux2.getProximo();
                                }
                            }
                        }
                        aaux2 = aaux2.getProximo();
                    }
                    aaux = aaux.getProximo();
                }
                //se não tiver voo partindo deste aero para o aero selecionado
                System.out.println("Não exite voo para este local partindo deste aéroporto");
            }
        }
    }

    public void ImprimeVoos(String CodAero) {
        //criação de variaveis 
        NodeAeros aux;
        NodeVoos vaux;
        aux = primeiro;
        //while para percorrer a lista e procurar o aeroporto com o codigo inserido
        while (aux != null) {
            //Se o codigo do aeroporto for encontrado
            if (aux.GetAero().getCodAero().equals(CodAero)) {
                vaux = aux.GetAero().getLV().primeiro;
                //percorrer a lista de voos do aeroporto e imprimir cada voo cadastrado
                while (vaux != null) {
                    System.out.println("O numero do voo é: "
                            + vaux.getVoos().getNumVoo()
                            + "\n O destino deste voo é:" + vaux.getVoos().getCodDest());
                    vaux = vaux.getProximo();
                }
                break;
            } else {
                aux = aux.getProximo();
            }
        }
        //se nenhum codigo de aeroporto bater com o codigo cadastrado
        if (aux == null) {
            System.out.println("Codigo do aeroporto nao encontrado");
        }
    }

    public void AltCodVoo(int NAnt, int NNov) {
        //definição de variaveis
        NodeAeros aaux;
        NodeVoos vaux;
        int naux = 0;
        aaux = primeiro;
        //while para percorrer a lista de aeros
        while (aaux != null) {
            vaux = aaux.GetAero().getLV().primeiro;
            //while para percorrer a lista de voo
            while (vaux != null) {
                //se o codigo do voo bater
                if (vaux.getVoos().getNumVoo() == NAnt) {
                    //definição do novo numero
                    vaux.getVoos().setNumVoo(NNov);
                    System.out.println("Número de voo alterado com sucesso");
                    naux = 1;
                    break;

                }
                vaux = vaux.getProximo();
            }
            //parar toda a aplicação
            if (naux == 1) {
                break;
            } else {
                aaux = aaux.getProximo();
            }

        }
        //se chegar ao final da lista de aeroportos e a aplicação nao parar é porque o numero nao foi encontrado
        if (aaux == null) {
            System.out.println("Numero de voo não encontrado, tente novamente");
        }
    }

    public void RemoverVoo(int NumVoo) {
        //variaveis auxiliares
        NodeAeros aaux;
        aaux = primeiro;
        NodeVoos aux, antes;
        //while para percorrer a lista de aeroportos
        while (aaux != null) {
            aux = antes = aaux.GetAero().getLV().primeiro;
            // while para percorrer lista de voo
            while (aux != null && aux.getVoos().getNumVoo() != NumVoo) {
                antes = aux;
                aux = aux.getProximo();
            }
            aaux = aaux.getProximo();
            // se auxiliar estiver parado antes de terminar a lista
            if (aux != null) {
                //verifica se a posição do voo é inicial
                if (aux == aaux.GetAero().getLV().primeiro) {
                    aaux.GetAero().getLV().primeiro = aaux.GetAero().getLV().ultimo = null;
                    aux.setProximo(null);
                    tamanho--;
                    System.out.println("Voo removido com sucesso");
                    break;
                    //posição do voo no meio
                } else if (aux.getProximo() != null) {
                    antes.setProximo(aux.getProximo());
                    aux.setProximo(null);
                    tamanho--;
                    System.out.println("Voo removido com sucesso");
                    break;
                    //posição do voo no fim
                } else {
                    antes.setProximo(null);
                    aaux.GetAero().getLV().ultimo = antes;
                    tamanho--;
                    System.out.println("Voo removido com sucesso");
                    break;
                }

            }
            //se não encontrar o voo
        }
        if (aaux == null) {
            System.out.println("Numero de voo não encontrado");
        }
    }

}
