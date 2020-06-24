package model;

public class User extends Player {
    int userCardIndex = 0;

    public void getCard(Card[] deck, int turn) {
        if (turn == 3) {
            this.playerCards[userCardIndex] = deck[userCardIndex];  //유저는 딜러 덱의 앞에서 부터 받음
        } else {
            for (int i = 0; i < 2; i++) {
                this.playerCards[userCardIndex] = deck[userCardIndex];
                this.userCardIndex++;
            }
        }
    }
}
