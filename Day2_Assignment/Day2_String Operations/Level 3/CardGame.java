import java.util.Scanner;
public class CardGame {
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int n = suits.length * ranks.length;
        String[] deck = new String[n];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }
    public static String[][] distributeCards(String[] deck, int numPlayers) {
        int n = deck.length;
        if (n % numPlayers != 0) {
            System.out.println("Warning: Cards cannot be distributed equally. Distributing max possible per player.");
        }
        int cardsPerPlayer = n / numPlayers;
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int deckIndex = 0;
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (int p = 0; p < numPlayers; p++) {
                players[p][i] = deck[deckIndex++];
            }
        }
        return players;
    }
    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + "'s Hand:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.print("[" + players[i][j] + "] ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);
        System.out.print("Enter number of players: ");
        int x = sc.nextInt();
        if (x <= 0 || x > 52) {
            System.out.println("Invalid number of players.");
        } else {
            String[][] playerHands = distributeCards(deck, x);
            printPlayers(playerHands);
        }
    }
}