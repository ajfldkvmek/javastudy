package collection.compare.test;

public class CardGameMain {

    public static void main(String[] args) {
        
        Deck deck = new Deck();
        Player player1 = new Player("플레이어1");
        Player player2 = new Player("플레이어2");

        for(int i = 0; i < 5; i++){
            player1.drawCard(deck);
            player2.drawCard(deck);
        }

        player1.showHand();
        player2.showHand();

        Player winner = getWinner(player1, player2);

        if(winner == null) System.out.println("무승부");
        else {
            System.out.println(winner.getName() +"의 승리");
        }

    }

    private static Player getWinner(Player player1, Player player2) {
        int s1 = player1.rankSum();
        int s2 = player2.rankSum();

        if(s1 > s2)
            return player1;
        else if(s1 < s2)
            return player2;
        else
            return null;
    }
}
