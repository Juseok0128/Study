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

//        for (int i = 0; i < 52; i++) {   //딜러가 섞은덱 확인 테스트
//            System.out.print(pokerDealer.deck[i].getRank());
//            System.out.print(pokerDealer.deck[i].getSuit());
//            System.out.println();
//        }

//        for (int i = 0; i < 2; i++) {
//            System.out.printf("유저 %d번패: ", i + 1);    //유저 첫번째, 두번째 패 테스트
//            System.out.print(jsKang.playerCards[i].getRank());
//            System.out.println(jsKang.playerCards[i].getSuit());
//        }
//        for (int i = 0; i < 2; i++) {
//            System.out.printf("컴퓨터 %d번패: ", i + 1);    //유저 첫번째, 두번째 패 테스트
//            System.out.print(com.playerCards[i].getRank());
//            System.out.println(com.playerCards[i].getSuit());
//        }
        while (turn < 4) {
            jsKang.getCard(pokerDealer.deck, turn);
            com.getCard(pokerDealer.deck, turn);
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
    }
}
