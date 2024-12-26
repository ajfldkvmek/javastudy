package collection.compare.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static List<Card> cards = new ArrayList<>();

    public Deck(){
        initCard();
        shuffle();
    }

    private void initCard(){
        for(int i = 1; i <= 13; i++){
            for (Suit value : Suit.values()) {
                cards.add(new Card(i, value));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }


    public Card drawCard(){
        //셔플된 카드중 가장 위에 있는 카드를 꺼내고 반환
//        return cards.remove(0);
        return cards.removeFirst(); //이놈은 자바 21 이상부터 사용가능하다
    }

}
