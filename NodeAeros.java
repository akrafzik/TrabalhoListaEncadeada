/*Alec Krafzik Haroutiounian          20402979
  Henrique Hideki Nobutaki            20021120
  José Fernandes da Silva Junior      20189911
  Luis Fernando de Souza Almeida Cruz 20391742
  Murilo Procópio da Costa Silva      20368549
  Renato Fernandes Ruiz               20400790*/

package ANAC;

//Definição das variáveis do Nó para Aeroportos
public class NodeAeros {
    private Aeroporto aero = new Aeroporto();
    NodeAeros proximo;
//Boas praticas de programação
    public NodeAeros() {
        
    }
// metodos gets e sets
    public NodeAeros(NodeAeros proximo) {
        this.proximo = null;
    }

    public Aeroporto GetAero() {
        return aero;
    }

    public void setAero(Aeroporto aero) {
        this.aero = aero;
    }

    public NodeAeros getProximo() {
        return proximo;
    }

    public void setProximo(NodeAeros proximo) {
        this.proximo = proximo;
    }
    
}

