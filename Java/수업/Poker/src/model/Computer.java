package model;

public class Computer extends Player {
    int computerCardIndex = 0;

    public void getCard(Card[] deck, int turn) {
        if (turn == 3) {
            this.playerCards[computerCardIndex] = deck[51 - computerCardIndex];   //컴퓨터는 딜러 덱의 뒤에서부터 받음
        } else {
            for (int i = 0; i < 2; i++) {
                this.playerCards[computerCardIndex] = deck[51 - computerCardIndex];
                computerCardIndex++;
            }
        }
    }
}
