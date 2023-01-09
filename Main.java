import java.util.Scanner;

class hundirFlota {
    String[][] tablero = new String[10][10];
    String[][] tablero1 = new String[10][10];

    int incio = 0;

    int condicionVictoria = 0;
    void imprimirTablero() {

        if (incio == 0) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    tablero[i][j] = "🌊";
                }
            }

            tablero[0][0]=" ";
            tablero[0][1]="1";
            tablero[0][2]="2";
            tablero[0][3]="3";
            tablero[0][4]="4";
            tablero[0][5]="5";
            tablero[0][6]="6";
            tablero[0][7]="7";
            tablero[0][8]="8";
            tablero[0][9]="9";
            tablero[1][0]="A";
            tablero[2][0]="B";
            tablero[3][0]="C";
            tablero[4][0]="D";
            tablero[5][0]="E";
            tablero[6][0]="F";
            tablero[7][0]="G";
            tablero[8][0]="H";
            tablero[9][0]="I";

            incio = 1;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero[i][j]);
            }
        }
    }


    void imprimirBarco() {
        for (int i = 0; i < 2 ;) {
            int num1 =(int) (Math.random() * (4+1));
            int num2 =(int) (Math.random() * (9+1));

            if(tablero[num1][num2].equals("🌊") && tablero[num1 + 1][num2].equals("🌊")) {
                tablero1[num1][num2] = "\uD83D\uDEA2";
                tablero1[num1+ 1][num2] = "\uD83D\uDEA2";
                i++;
            }
        }
    }

    void imprimirBuque() {
        int num1 =(int) (Math.random() * (4+2));
        int num2 =(int) (Math.random() * (9+2));

        if(tablero[num1][num2].equals("🌊") && tablero[num1 + 1][num2].equals("🌊") && tablero[num1 +2][num2].equals("🌊")) {
            tablero1[num1][num2] = "\uD83D\uDEA2";
            tablero1[num1+ 1][num2] = "\uD83D\uDEA2";
            tablero1[num1+ 2][num2] = "\uD83D\uDEA2";
            }
    }



    void imprimirPortaAviones() {
        int num1 =(int) (Math.random() * (4+3));
        int num2 =(int) (Math.random() * (9+3));

        if(tablero[num1][num2].equals("🌊") && tablero[num1 + 1][num2].equals("🌊") && tablero[num1 +2][num2].equals("🌊") && tablero[num1 + 3][num2].equals("🌊")) {
            tablero1[num1][num2] = "\uD83D\uDEA2";
            tablero1[num1+ 1][num2] = "\uD83D\uDEA2";
            tablero1[num1+ 2][num2] = "\uD83D\uDEA2";
            tablero1[num1+ 3][num2] = "\uD83D\uDEA2";
            }
    }


    void comprobarPosicion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Selecciona una casilla (Eje X + Eje Y) ");
        int eje_X = scanner.nextInt();
        int eje_Y = scanner.nextInt();
        if (tablero1[eje_X][eje_Y].equals("\uD83D\uDEA2")) {
            tablero[eje_X][eje_Y] = tablero1[eje_X][eje_Y];
            condicionVictoria++;
        } else {
            System.out.print("Has fallado melon, vuelve a intentarlo...");
        }
    }

    void victoria() {
        if (condicionVictoria == 11) {
            System.out.print("¡¡¡HAS GANADO :D!!!");
        }
    }

}


public class Main {
    public void setJuego() {

        hundirFlota juego = new hundirFlota();

        juego.imprimirBarco();
        juego.imprimirBuque();
        juego.imprimirPortaAviones();

        for (int i = 0; i <27; i++) {
            juego.imprimirTablero();
            juego.comprobarPosicion();
            juego.victoria();
        }


    }
}
