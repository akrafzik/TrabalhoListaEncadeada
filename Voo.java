/*Alec Krafzik Haroutiounian          20402979
  Henrique Hideki Nobutaki            20021120
  José Fernandes da Silva Junior      20189911
  Luis Fernando de Souza Almeida Cruz 20391742
  Murilo Procópio da Costa Silva      20368549
  Renato Fernandes Ruiz               20400790*/

package ANAC;
// definição das variaveis da classe
public class Voo {
    private int NumVoo;
    private String CodDest, CodOrig;
//contrutor vazio
    public Voo() {
    }
//inicialização de variaveis
    public Voo(int NumVoo, String CodDest, String CodOrig) {
        this.NumVoo = NumVoo;
        this.CodDest = CodDest;
        this.CodOrig = CodOrig;
    }
// metodos gets e sets
    public int getNumVoo() {
        return NumVoo;
    }

    public void setNumVoo(int NumVoo) {
        this.NumVoo = NumVoo;
    }

    public String getCodDest() {
        return CodDest;
    }

    public void setCodDest(String CodDest) {
        this.CodDest = CodDest;
    }

    public String getCodOrig() {
        return CodOrig;
    }

    public void setCodOrig(String CodOrig) {
        this.CodOrig = CodOrig;
    }
    

}
