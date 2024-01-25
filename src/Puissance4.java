import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class Puissance4 {
    // déclaration des constantes
    public static final int VICTOIRE = 4;
    public static final int LIGNES = 6;
    public static final int COLONNES = 7;
    public static final char JOUEUR1 = 'R';
    public static final char JOUEUR2 = 'J';

    public static char[][] plateau = new char[LIGNES][COLONNES];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {    //methode principal du jeu
        TerminalClear terminalClear = new TerminalClear();
        while (true) {
            terminalClear.clearTerminal();
            initPlateau();
            int currentPlayer = 1;
            displayBoard();
            
            while (true) {
                if (checkVictory(currentPlayer)) {
                    System.out.println("Joueur " + currentPlayer + " a gagné !");
                    break;
                }
                if (isBoardFull()) {
                    System.out.println("Égalité !");
                    break;
                }
                currentPlayer = (currentPlayer % 2) + 1;
                int colonne = getUserInput(currentPlayer);
                playTurn(colonne, currentPlayer);
                
                terminalClear.clearTerminal();
                displayBoard();
                

            }
            System.out.println("Voulez-vous rejouer une partie ? (oui/non)");
            Scanner scanner = new Scanner(System.in);
            String replay = scanner.next();
            if (replay.equalsIgnoreCase("oui")) {
                continue;
            } else if (replay.equalsIgnoreCase("non")) {
                break;
            } else {
                System.out.println("Réponse invalide. Veuillez répondre par 'oui' ou 'non'.");
            }
        }
    }

    // initialisation de la grille de jeu 
    private static void initPlateau() {           
        for (int i = 0; i < LIGNES; i++) {     //Boucle For pour parcourir les L et C du tableau
            for (int j = 0; j < COLONNES; j++) {
                plateau[i][j] = '_';  // initialisation du char "_" dans le tabeau = case vide
            }
        }
    }


    // Affiche le plateau de jeu
    private static void displayBoard() {   
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                if (plateau[i][j] == 'R')
                    System.out.print("\033[31m" + plateau[i][j] + "\033[0m" + " "); //couleur ANSI
                else if (plateau[i][j] == 'J')
                    System.out.print("\033[33m" + plateau[i][j] + "\033[0m" + " "); // couleur ANSI
                else
                    System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
        for (int j = 1; j <= COLONNES; j++)
            System.out.print(j + " ");
        System.out.println();
    }


    // Verification de victoire 
    private static boolean checkVictory(int currentPlayer) {

                // ===============================================
                // ====================JOUEUR 1===================
                // ===============================================
                
                // vérifier les lignes
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES - 3; j++) {
                if (plateau[i][j] == JOUEUR1 && plateau[i][j+1] == JOUEUR1 && plateau[i][j+2] == JOUEUR1 && plateau[i][j+3] == JOUEUR1) {
                    return true;
                }
            }
        }
        // vérifier les colonnes
        for (int i = 0; i < LIGNES - 3; i++) {
            for (int j = 0; j < COLONNES; j++) {
                if (plateau[i][j] == JOUEUR1 && plateau[i+1][j] == JOUEUR1 && plateau[i+2][j] == JOUEUR1 && plateau[i+3][j] == JOUEUR1) {
                    return true;
                }
            }
        }
        // vérifier les diagonales descendantes vers la droite
        for (int i = 0; i < LIGNES - 3; i++) {
            for (int j = 0; j < COLONNES - 3; j++) {
                if (plateau[i][j] == JOUEUR1 && plateau[i+1][j+1] == JOUEUR1 && plateau[i+2][j+2] == JOUEUR1 && plateau[i+3][j+3] == JOUEUR1) {
                    return true;
                }
            }
        }
        // vérifier les diagonales descendantes vers la gauche
        for (int i = 0; i < LIGNES - 3; i++) {
            for (int j = 3; j < COLONNES; j++) {
                if (plateau[i][j] == JOUEUR1 && plateau[i+1][j-1] == JOUEUR1 && plateau[i+2][j-2] == JOUEUR1 && plateau[i+3][j-3] == JOUEUR1) {
                    return true;
                }
            }
        }

                //================================================
                //====================JOUEUR 2====================
                //================================================

                      // vérifier les lignes
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES - 3; j++) {
                if (plateau[i][j] == JOUEUR2 && plateau[i][j+1] == JOUEUR2 && plateau[i][j+2] == JOUEUR2 && plateau[i][j+3] == JOUEUR2) {
                    return true;
                }
            }
        }
        // vérifier les colonnes
        for (int i = 0; i < LIGNES - 3; i++) {
            for (int j = 0; j < COLONNES; j++) {
                if (plateau[i][j] == JOUEUR2 && plateau[i+1][j] == JOUEUR2 && plateau[i+2][j] == JOUEUR2 && plateau[i+3][j] == JOUEUR2) {
                    return true;
                }
            }
        }
        // vérifier les diagonales descendantes vers la droite
        for (int i = 0; i < LIGNES - 3; i++) {
            for (int j = 0; j < COLONNES - 3; j++) {
                if (plateau[i][j] == JOUEUR2 && plateau[i+1][j+1] == JOUEUR2 && plateau[i+2][j+2] == JOUEUR2 && plateau[i+3][j+3] == JOUEUR2) {
                    return true;
                }
            }
        }
        // vérifier les diagonales descendantes vers la gauche
        for (int i = 0; i < LIGNES - 3; i++) {
            for (int j = 3; j < COLONNES; j++) {
                if (plateau[i][j] == JOUEUR2 && plateau[i+1][j-1] == JOUEUR2 && plateau[i+2][j-2] == JOUEUR2 && plateau[i+3][j-3] == JOUEUR2) {
                    return true;
                }
            }
        }
                 // ====================FIN VICTOIRE====================
     return false;
        }


       // Verification grille pleine = Egalité
private static boolean isColumnFull(int colonne) {
    return plateau[0][colonne - 1] != '_';


}


// Verification grille pleine = Egalité
private static boolean isBoardFull() {
    for (int j = 0; j < COLONNES; j++) {
        if (plateau[0][j] == '_') {
            return false; // S'il y a au moins une case vide dans la première ligne, la grille n'est pas pleine
        }
    }
    return true; // Toutes les cases de la première ligne sont remplies, la grille est pleine
}




// Entrée utilisateur 
private static int getUserInput(int currentPlayer) {
    System.out.println("Joueur " + currentPlayer + ", dans quelle colonne voulez-vous jouer ?");
    int colonne = -1;
    while (true) {
        try {
            colonne = scanner.nextInt();
            if (colonne >= 1 && colonne <= COLONNES) {
                if (isColumnFull(colonne)) {
                    System.out.println("Colonne pleine. Choisissez une autre colonne.");
                } else {
                    break;
                }
            } else {
                System.out.println("Nombre incorrect. Veuillez saisir un nombre entre 1 et " + COLONNES);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrée incorrecte. Veuillez saisir un nombre.");
            scanner.next(); // Clear the invalid input
        }
    }
    return colonne;
}
////////////////////////////

        // Place jetons du joueur sur le plateau
     private static void playTurn(int colonne, int currentPlayer) {
        char jeton = (currentPlayer == 1) ? JOUEUR1 : JOUEUR2;
        for (int i = LIGNES - 1; i >= 0; i--) {
            if (plateau[i][colonne - 1] == '_') {
                plateau[i][colonne - 1] = jeton;
                break;
            }
        }
    }
}



