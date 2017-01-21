/*Alec Krafzik Haroutiounian         20402979
 Henrique Hideki Nobutaki            20021120
 José Fernandes da Silva Junior      20189911
 Luis Fernando de Souza Almeida Cruz 20391742
 Murilo Procópio da Costa Silva      20368549
 Renato Fernandes Ruiz               20400790*/
package ANAC;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Gerenc gmenu = new Gerenc();
        Scanner entrada = new Scanner(System.in);
        int menu = 0;
        while (menu != 9) {
            gmenu.OpcoesMenu();
            menu = entrada.nextInt();
            switch (menu) {
                case 1:
                    gmenu.Menu1();
                    break;
                case 2:
                    gmenu.Menu2();
                    break;
                case 3:
                    gmenu.Menu3();
                    break;
                case 4:
                    gmenu.Menu4();
                    break;
                case 5:
                    gmenu.Menu5();
                    break;
                case 6:
                    gmenu.Menu6();
                    break;
                case 7:
                    gmenu.ImprimeTudo();
                    break;
                case 8:
                    gmenu.MenuFechar();
                    break;
            }
        }
    }
}
