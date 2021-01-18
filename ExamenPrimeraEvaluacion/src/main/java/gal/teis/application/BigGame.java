package gal.teis.application;

import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase implementa la aplicación El gran juego del salto.
 */
@SuppressWarnings("resource")
public class BigGame {

    private static final String[] ORDINALS = {"primer", "segundo", "tercer", "cuarto", "quinto"};

    // Declaro como constantes el tamaño del tablero, el número máximo de intentos y el tamaño del dado; por 2 motivos:
    // 1. Leyendo el código, sabré a que me estoy refiriendo, en vez de tener un número que he de conocer.
    // 2. Si quisiera modificarlo, solo tengo que cambiarlo aquí.
    private static final byte BOARD_SIZE = 20;
    private static final byte MAX_ATTEMPTS = 5;
    private static final byte DICE_SIZE = 6;

    private static byte currentAttempt;
    private static byte position;
    private static Random rnd;

    public static void game() {
        Scanner sc = new Scanner(System.in);
        currentAttempt = 1;
        position = 0;
        rnd = new Random();

        System.out.println("Bienvenido a la aplicacion El gran juego del salto.");

        do {
            if (position == 0) {
                System.out.println("\nEste es tu " + ORDINALS[currentAttempt-1] + " intento, tienes " + MAX_ATTEMPTS + ".");
                System.out.println("Estás en la casilla de salida.");
            }
            System.out.println("Pulsa Enter para lanzar el dado.");
            sc.nextLine();
            rollDice();
            if (position > BOARD_SIZE) {
                System.out.println("Vaya, te has pasado...");
                position = 0;
                currentAttempt++;
            }
        } while (position != BOARD_SIZE && currentAttempt <= MAX_ATTEMPTS);

        if (position == BOARD_SIZE) {
            System.out.println("¡Enhorabuena! Has ganado en tu " + ORDINALS[currentAttempt-1] + " intento.");
        } else {
            System.out.println("Lo siento, has perdido.");
        }
    }

    private static void rollDice() {
        int diceOutput = 1 + rnd.nextInt(DICE_SIZE);
        position += diceOutput;

        StringBuilder sb = new StringBuilder();
        sb.append("Has sacado un ");
        sb.append(diceOutput);
        if (position < BOARD_SIZE) {
            sb.append(", alcanzando la casilla ");
            sb.append(position);
            sb.append('.');
        } else if (position == BOARD_SIZE) {
            sb.append(", alcanzado el final del tablero.");
        } else {
            sb.append(", saliéndote del tablero.");
        }
        System.out.println(sb);
    }
}
