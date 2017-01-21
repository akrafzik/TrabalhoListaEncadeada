/*Alec Krafzik Haroutiounian          20402979
 Henrique Hideki Nobutaki            20021120
 José Fernandes da Silva Junior      20189911
 Luis Fernando de Souza Almeida Cruz 20391742
 Murilo Procópio da Costa Silva      20368549
 Renato Fernandes Ruiz               20400790*/
package ANAC; 

public class ListaVoos {
//Definição de variaveis para a lista de Voos
    NodeVoos primeiro, ultimo;
    int tamanho;
// Inicialização de variáveis
    public ListaVoos() {
        primeiro = ultimo = null;
        tamanho = 0;
    }
/*Se a lista estiver vazia ele vai criar os nodes de referencia primeiro 
  e ultimo e inserir as informações no node primeiro*/
    public void CadastroVoo(int NumVoo, String CodOrig,String CodDest) {
        if (IsEmpty()) {
            primeiro = ultimo = new NodeVoos();
            primeiro.getVoos().setNumVoo(NumVoo);
            primeiro.getVoos().setCodDest(CodDest);
            primeiro.getVoos().setCodOrig(CodOrig);
            primeiro.setProximo(null);
            tamanho++;
            System.out.println("Voo cadastrado com sucesso");
        } else {
            //Criação do node novo e de nodes auxiliares para não perde a referencia
            NodeVoos novo = new NodeVoos();
           //Atribuição de dados
            novo.getVoos().setCodDest(CodDest);
            novo.getVoos().setNumVoo(NumVoo);
            novo.getVoos().setCodOrig(CodOrig);
            NodeVoos aux, antes;
            antes = aux = primeiro;
            
            //While para percorrer a lista de node e while para achar onde será inserido o aeroporto na lista seguinda a ordem numérica
            while (aux != null && aux.getVoos().getNumVoo() < NumVoo) {
                antes = aux;
                aux = aux.getProximo();
            }
            //Se ele for o primeiro na ordem alfabética logo de cara
            if (aux == primeiro) {
                novo.setProximo(primeiro);
                primeiro = novo;
                tamanho++;
                System.out.println("Voo cadastrado com sucesso");
            }
            //Se ele for o ultimo na ordem numérica
            else if (aux == null) {
                ultimo.setProximo(novo);
                ultimo = novo;
                tamanho++;
                System.out.println("Voo cadastrado com sucesso");
            } else 
            {
            //Se for uma inserção no meio da lista
                novo.setProximo(aux);
                antes.setProximo(novo);
                tamanho++;
                System.out.println("Voo cadastrado com sucesso");
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

}
