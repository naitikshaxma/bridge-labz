import java.util.Random;
import java.util.Scanner;

public class CardDeck {
    public static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    public static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static String[][] initializeDeck() {
        String[][] deck = new String[suits.length][ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = new String[]{rank + " of " + suit};
            }
        }
        return deck;
    }

    public static String[][] shuffleDeck(String[][] deck) {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = i + random.nextInt(deck.length - i);
            String[] temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[][] deck, int numPlayers, int cardsPerPlayer) {
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (int j = 0; j < numPlayers; j++) {
                players[j][i] = deck[cardIndex++][0];
            }
        }
        return players;
    }

    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.printf("Player %d: ", i + 1);
            for (String card : players[i]) {
                System.out.print(card + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] deck = initializeDeck();
        deck = shuffleDeck(deck);

        System.out.print("Number of players: ");
        int players = scan.nextInt();
        System.out.print("Cards per player: ");
        int cards = scan.nextInt();

        String[][] distributed = distributeCards(deck, players, cards);
        printPlayers(distributed);
    }
}
