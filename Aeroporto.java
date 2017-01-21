/*Alec Krafzik Haroutiounian          20402979
  Henrique Hideki Nobutaki            20021120
  José Fernandes da Silva Junior      20189911
  Luis Fernando de Souza Almeida Cruz 20391742
  Murilo Procópio da Costa Silva      20368549
  Renato Fernandes Ruiz               20400790*/

package ANAC;

//Criação da classe aéroporto
public class Aeroporto {
  //definição de variáveis
    private String CidAero, CodAero;
    ListaVoos LV = new ListaVoos();
//contrutor vazio
    public Aeroporto() {
    }
//inicialização
    public Aeroporto(String CodAero, String CidAero, ListaVoos LV) {
        this.CodAero = CodAero;
        this.CidAero = CidAero;
        this.LV = LV;
    }
    
// metodos gets e sets
    public String getCodAero() {
        return CodAero;
    }

    public void setCodAero(String CodAero) {
        this.CodAero = CodAero;
    }

    public String getCidAero() {
        return CidAero;
    }

    public void setCidAero(String CidAero) {
        this.CidAero = CidAero;
    }

    public ListaVoos getLV() {
        return LV;
    }

    public void setLV(ListaVoos LV) {
        this.LV = LV;
    }
    
}
