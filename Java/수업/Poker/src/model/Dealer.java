package model;

import java.math.BigDecimal;

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
        Card temp;
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

    public double score(Card[] playerDeck) {
        double rank = 0;
        int sameSuit = 1;
        int[] numCheck = new int[5];
        int[] numCount = new int[13];
        String[] suitCheck = new String[5];

        for (int i = 0; i < playerDeck.length; i++) {
            numCheck[i] = playerDeck[i].getRank();
            suitCheck[i] = playerDeck[i].getSuit();
        }
        for (int i = 0; i < numCheck.length; i++) {
            numCount[numCheck[i] - 1]++;
        }
        for (int i = 1; i < suitCheck.length; i++) {
            if (suitCheck[0] == suitCheck[i]) {
                sameSuit++;
            }
        }
        for (int i = 0; i < numCount.length; i++) {     //포카드
            if (numCount[i] == 4) {
                rank = 5;
                return rank;
            }
        }
        if (sameSuit == 5) {    //플러쉬
            rank = 4;
            return rank;
        }
        for (int i = numCount.length - 1; i >= 0; i--) {     //트리플
            if (numCount[i] == 3) {
                rank = this.getRankScore(i, 3.01);
                if (rank == 3.01) return 3.14;      //a점수 보정
                return rank;
            }
        }
        for (int i = numCount.length - 1; i >= 0; i--) {     //원페어
            if (numCount[i] == 2) {
                rank = this.getRankScore(i, 2.01);
                if (rank == 2.01) return 2.14;      //a점수 보정
                return rank;
            }
        }
        for (int i = numCount.length - 1; i >= 0; i--) {     //탑
            if (numCount[i] == 1) {
                rank = this.getRankScore(i, 1.01);
                if (rank == 1.01) return 1.14;      //a점수 보정
                return rank;
            }
        }
        System.out.println("아무 조건에 해당하지 않습니다.");
        return 0;
    }
    static double getRankScore(int cardNumber, double defalutScore){
        BigDecimal tmp = new BigDecimal(String.valueOf(cardNumber)).divide(new BigDecimal("100")).add(new BigDecimal(String.valueOf(defalutScore)));
        return tmp.doubleValue();
    }

    public void printRank(double rank) {
        int printRank;
        if (rank == 5) {
            System.out.println("포카드");
            return;
        }
        if (rank == 4) {
            System.out.println("플러쉬");
            return;
        }
        if (rank > 3) {
            rank = new BigDecimal(String.valueOf(rank)).subtract(new BigDecimal("3")).doubleValue();
            System.out.println(this.getScoreMark(rank)+"트리플");
            return;
        }
        if (rank > 2) {
            rank = new BigDecimal(String.valueOf(rank)).subtract(new BigDecimal("2")).doubleValue();
            System.out.println(this.getScoreMark(rank)+"원페어");
            return;
        }
        if (rank > 1) {
            rank = new BigDecimal(String.valueOf(rank)).subtract(new BigDecimal("1")).doubleValue();
            System.out.println(this.getScoreMark(rank)+"탑");
            return;
        }
        System.out.println("해당하는 족보가 없습니다.");
    }
    String getScoreMark(double rank){
        if (rank == 0.14) {
            return "A";
        } else if (rank == 0.13) {
            return "K";
        } else if (rank == 0.12) {
            return "Q";
        } else if (rank == 0.11) {
            return "J";
        } else {
            BigDecimal tmp = new BigDecimal(String.valueOf(rank)).multiply(new BigDecimal("100"));
            int prnitTmp = tmp.intValue();
            return String.valueOf(prnitTmp);
        }
    }
}