/*Alec Krafzik Haroutiounian          20402979
 Henrique Hideki Nobutaki            20021120
 José Fernandes da Silva Junior      20189911
 Luis Fernando de Souza Almeida Cruz 20391742
 Murilo Procópio da Costa Silva      20368549
 Renato Fernandes Ruiz               20400790*/
package ANAC;

import java.util.Scanner;

public class Gerenc {

    ListaAeros Anac = new ListaAeros();
    Scanner entrada = new Scanner(System.in);

    public void OpcoesMenu() {
        System.out.println("Bem vindo ao FOMA"
                + "(Ferramenta de Organização de Malha Aérea)"
                + "\n 1 - Novo Aéroporto"
                + "\n 2 - Cadastrar Voo"
                + "\n 3 - Procurar Voo"
                + "\n 4 - Remover Voo"
                + "\n 5 - Alterar Código de Voo"
                + "\n 6 - Imprimir Voos partindo de um Aeroporto"
                + "\n 7 - Imprimir todos os Voos cadastrados"
                + "\n 8 - Finalizar programa");
    }

    public void Menu1() {
        NodeAeros aaux;
        String Cid, Cod;
        aaux = Anac.primeiro;
        
        System.out.println("Digite o nome da cidade do Aéroporto");
        Cid = entrada.nextLine();
        System.out.println("Digite o codigo do aeroporto");
        Cod = entrada.nextLine();
        while (aaux != null && !aaux.GetAero().getCodAero().equals(Cod)) {
            aaux = aaux.getProximo();
        }
        if (aaux == null) {
            Anac.CadastrarAeroporto(Cid, Cod);
            System.out.println("Aeroporto cadastrado com sucesso");
        } else {
            System.out.println("Codigo já usado, escreva um código diferente");
        }
    }

    public void Menu2() {

        int Vnvoo, Vcorig, Vcdest;
        Vnvoo = Vcorig = Vcdest = 0;
        NodeAeros aaux;
        aaux = Anac.primeiro;
        NodeVoos vaux;
        int NVoo;
        String CDest, COrig;
        System.out.println("Digite o número do Voo");
        NVoo = entrada.nextInt();
        System.out.println("Digite o código de origem");
        COrig = entrada.next();
        System.out.println("Digite o código de destino");
        CDest = entrada.next();
        if (CDest.equals(COrig)) {
            System.out.println("Não é possivel cadastrar voo com origem e destino no mesmo aeroporto");
        } else {
            while (aaux != null) {
                vaux = aaux.GetAero().getLV().primeiro;
                while (vaux != null) {
                    if (vaux.getVoos().getNumVoo() == NVoo) {
                        Vnvoo = 1;
                        break;
                    } else {
                        vaux = vaux.getProximo();
                    }
                    }if (Vnvoo == 1){
                        break;
                }
                aaux = aaux.getProximo();
            }
            if (Vnvoo == 1) {
                System.out.println("Numero de voo já ultilizado");
            } else {
                aaux = Anac.primeiro;
                    while (aaux != null) {
                        if (aaux.GetAero().getCodAero().equals(CDest)) {
                            Vcdest = 1;
                            break;
                        } else {
                            aaux = aaux.getProximo();
                        }
                    }
                    if (Vcdest != 1 ) {
                        System.out.println("Codigo de aeroporto destino de não encontrado");
                    } else {
                        
                aaux = Anac.primeiro;
                while (aaux != null) {
                    if (!aaux.GetAero().getCodAero().equalsIgnoreCase(COrig)) {
                         aaux = aaux.getProximo();
                    } else {
                       Vcorig = 1;
                        aaux.GetAero().getLV().CadastroVoo(NVoo, COrig, CDest);
                       break;
                       
                    }
                }
                if (Vcorig == 0) {
                    System.out.println("Codigo de aeroporto origem de não encontrado");
                }                
                  
                }
            }
        }
    }

    public void Menu3() {
        String COrg, CDest;
        System.out.println("Digite o codigo do aéroporto do origem");
        COrg = entrada.next();
        System.out.println("Digite o código do aéroporto de destino");
        CDest = entrada.next();
        Anac.ProcVoo(COrg, CDest);

    }

    public void Menu4() {
        int NVoo;
        System.out.println("Digite o número do voo que deseja retirar");
        NVoo = entrada.nextInt();
        Anac.RemoverVoo(NVoo);
    }

    public void Menu5() {
        int NAnt, NNov;
        System.out.println("Digite o número do voo que deseja modificar");
        NAnt = entrada.nextInt();
        System.out.println("Digite o novo número do voo");
        NNov = entrada.nextInt();
        Anac.AltCodVoo(NAnt, NNov);

    }

    public void Menu6() {
        String CAero;
        System.out.println("Digite o aeroporto que deseja ver a lista de voos");
        CAero = entrada.next();
        Anac.ImprimeVoos(CAero);
    }

    public void ImprimeTudo() {
        NodeAeros aaux;
        NodeVoos vaux;
        aaux = Anac.primeiro;
        if (aaux == null) {
            System.out.println("Nenhum aeroporto cadastrado");
        } else {
            
            while (aaux != null) {
                vaux = aaux.GetAero().getLV().primeiro;
                System.out.println("A cidade do aeroporto de partida é: " + aaux.GetAero().getCidAero()
                        + "\nO codigo de aéroporto é :" + aaux.GetAero().getCodAero() + "\nSeus voos são:");
               if(vaux == null){
                   System.out.println("Lista de voos vazia");
               }
                while (vaux != null) {
                    System.out.println("O número do voo é: " + vaux.getVoos().getNumVoo()
                            + "\n A cidade destino é: " + vaux.getVoos().getCodDest());
                    vaux = vaux.getProximo();
                }
                aaux = aaux.getProximo();
            }
        }
    }

    public void MenuFechar() {
        System.out.println("Programa desenvolvido por:"
                + "\nAlec Krafzik Haroutiounian          20402979"
                + "\nHenrique Hideki Nobutaki            20021120"
                + "\nJosé Fernandes da Silva Junior      20189911"
                + "\nLuis Fernando de Souza Almeida Cruz 20391742"
                + "\nMurilo Procópio da Costa Silva      20368549"
                + "\nRenato Fernandes Ruiz               20400790");
    }

}
