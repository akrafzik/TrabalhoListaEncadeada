/*Alec Krafzik Haroutiounian          20402979
  Henrique Hideki Nobutaki            20021120
  José Fernandes da Silva Junior      20189911
  Luis Fernando de Souza Almeida Cruz 20391742
  Murilo Procópio da Costa Silva      20368549
  Renato Fernandes Ruiz               20400790*/

package ANAC;

//Definição das variáveis do Nó para Voos
public class NodeVoos {
    private Voo Voos = new Voo();
    NodeVoos proximo;
//Boas praticas de programação
    public NodeVoos() {
    }
//metodos gets e sets
    public NodeVoos(NodeVoos proximo) {
        this.proximo = null;
    }

    public Voo getVoos() {
        return Voos;
    }

    public void setVoos(Voo Voos) {
        this.Voos = Voos;
    }

    public NodeVoos getProximo() {
        return proximo;
    }

    public void setProximo(NodeVoos proximo) {
        this.proximo = proximo;
    }

    
}
