package model;

public class Player {

    private String name;
    public Card[] playerCards = new Card[5];
    int playerCardIndex=-1;

    public Player() {
        for (int i = 0; i < 5; i++) {
            playerCards[i] = new Card();
        }
    }
    public void getCard(Card playerGet){
        playerCardIndex++;
        playerCards[playerCardIndex]=playerGet;
    }
}
