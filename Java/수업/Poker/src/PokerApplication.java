import model.Computer;
import model.Dealer;
import model.User;


import java.util.Arrays;
import java.util.Scanner;

public class PokerApplication {

    public static void main(String[] args) {
        int turn = 1;
        Scanner sc = new Scanner(System.in);
        String goOrDie = new String("GO");
        Dealer pokerDealer = new Dealer();
        User jsKang = new User();
        Computer com = new Computer();
        pokerDealer.newDeck();

        while (turn < 4) {
            if(turn<3) {
                jsKang.getCard(pokerDealer.deal());
                jsKang.getCard(pokerDealer.deal());
                com.getCard(pokerDealer.deal());
                com.getCard(pokerDealer.deal());
            } else {
                jsKang.getCard(pokerDealer.deal());
                com.getCard(pokerDealer.deal());
            }

            for (int i = 0; i < jsKang.playerCards.length; i++) {
                System.out.print(jsKang.playerCards[i].getRank());
                System.out.println(jsKang.playerCards[i].getSuit());
            }
            System.out.println("GO or DIE?");
            goOrDie = sc.next();
            if(goOrDie.equals("DIE")){
                break;
            }
            turn++;
        }
        System.out.println("컴퓨터 패 보기");
        for (int i = 0; i < com.playerCards.length; i++) {
            System.out.print(com.playerCards[i].getRank());
            System.out.println(com.playerCards[i].getSuit());
        }
        System.out.println("딜러가 섞은덱 확인 테스트");

        for (int i = 0; i < 52; i++) {   //딜러가 섞은덱 확인 테스트
            System.out.print(pokerDealer.deck[i].getRank());
            System.out.print(pokerDealer.deck[i].getSuit());
            System.out.println();
        }
    }
}
