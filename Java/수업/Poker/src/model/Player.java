package model;

public class Player {

    private String name;
    public Card[] playerCards = new Card[5];
    int playerCardIndex = -1;

    public Player() {
        for (int i = 0; i < 5; i++) {
            playerCards[i] = new Card();
        }
    }

    public void getCard(Card playerGet) {
        playerCardIndex++;
        playerCards[playerCardIndex] = playerGet;
    }

    public void printMyCard() {
        for (int i = 0; i < playerCards.length; i++) {
            if (playerCards[i].getSuit() == null) {
                continue;
            }
            System.out.print(playerCards[i].getRank());
            System.out.println(playerCards[i].getSuit());
        }
    }
}
