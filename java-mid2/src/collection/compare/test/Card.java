package collection.compare.test;

public class Card implements Comparable<Card> {

    private final int rank;
    private final Suit suit;

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    /**
     *
     * enum 의 경우 기본적으로 Enum 을 상속받고 있기때문에
     * Enum 클래스에 생성되어 있는 compareTo 메소드를 사용할 수 있다.
     *
     */
    @Override
    public int compareTo(Card anotherCard) {
        //숫자를 먼저 비교하고 그 후 suit를 비교
        if (this.rank != anotherCard.rank){
            return Integer.compare(this.rank, anotherCard.rank);
        } else {
            return this.suit.compareTo(anotherCard.suit);
        }
    }

    @Override
    public String toString() {
        return rank + "(" + suit.getIcon() + ")";
    }
}
