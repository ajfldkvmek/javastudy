package collection.compare.test;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void drawCard(Deck deck){
        hand.add(deck.drawCard());
    }

    public int rankSum(){
        int value = 0;
        for (Card card : hand) {
            value += card.getRank();
        }
        return value;
    }

    public void showHand(){
        hand.sort(null);
        System.out.println(name + "의 카드: " + hand + " 합계: " + rankSum() );
    }

}

