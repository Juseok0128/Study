package model;

public class Dealer {

    private String[] suits = {"S", "H", "D", "C"};
    private int numcard;
    public Card[] deck = new Card[52];
    int cardIndex = -1;

    public Dealer() {
        numcard = 13;
    }

    public void newDeck() {     //딜러가 새로운 덱을 만들고 순서를 랜덤하게 섞음
        int i = 0;
        Card temp = new Card();
        int randomIndex = 0;
        for (int suitsCount = 0; suitsCount < suits.length; suitsCount++) {
            while (numcard != 0) {
                deck[i] = new Card();
                deck[i].setCard(suits[suitsCount], numcard);
                numcard--;
                i++;
            }
            numcard = 13;
        }
        for (i = 0; i < deck.length; i++) {
            randomIndex = (int) (Math.random() * 52);
            temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    public Card deal() {
        cardIndex++;
        return deck[cardIndex];
    }

    public int score(Card[] playerDeck) {
        int rank = 0;
        int[] numCheck = new int[5];
        int[] numCount = new int[13];
        String[] suitCheck = new String[5];
        int[] suitCount = new int[4];

        for (int i = 0; i < playerDeck.length; i++) {
            numCheck[i] = playerDeck[i].getRank();
            suitCheck[i] = playerDeck[i].getSuit();
        }
        for(int i=0;i<numCheck.length;i++){
            numCount[numCheck[i]-1]++;
        }
//        for(int i=0;i<suitCheck.length;i++){ 여기 하다가 말음
//            suitCount[]++;
//        }
        


        return rank;
    }
}