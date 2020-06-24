package model;

public class Card {

    private int rank;
    private String suit;

    public void setCard(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
}