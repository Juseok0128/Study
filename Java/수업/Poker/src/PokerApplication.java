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
            if (turn < 3) {
                jsKang.getCard(pokerDealer.deal());
                jsKang.getCard(pokerDealer.deal());
                com.getCard(pokerDealer.deal());
                com.getCard(pokerDealer.deal());
            } else {
                jsKang.getCard(pokerDealer.deal());
                com.getCard(pokerDealer.deal());
            }
            System.out.println("유저가 가진 패");
            jsKang.printMyCard();
            System.out.println("GO or DIE?");
            goOrDie = sc.next();
            if (goOrDie.equals("DIE")) {
                break;
            }
            turn++;
        }
        if (turn == 4) {
            double userScore = pokerDealer.score(jsKang.playerCards);
            double comScore = pokerDealer.score(com.playerCards);
            System.out.println("유저가 가진 패");
            jsKang.printMyCard();
            System.out.print("최종 족보: ");
            pokerDealer.printRank(userScore);

            System.out.println("컴퓨터가 가진 패");
            com.printMyCard();
            System.out.print("최종 족보: ");
            pokerDealer.printRank(comScore);

            if (userScore > comScore) {
                System.out.println("승자: 유저");
            } else if (userScore == comScore) {
                System.out.println("무승부");
            } else {
                System.out.println("승자: 컴퓨터");
            }
        }


    }
}
