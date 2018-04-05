/**
 * 
 */
package blackjack;

/**
 * @author Ben
 *
 */
public class Ben_Walker_HW3 {
	
	public static boolean aceWasUsed = false;
	
	public static String[] cards = {"Ace of Spades","Two of Spades","Three of Spades","Four of Spades","Five of Spades","Six of Spades","Seven of Spades","Eight of Spades","Nine of Spades","Ten Of Spades","Jack of Spades","Queen of Spades","King of Spades",
		"Ace of Hearts","Two of Hearts","Three of Hearts","Four of Hearts","Five of Hearts","Six of Hearts","Seven of Hearts","Eight of Hearts","Nine of Hearts","Ten Of Hearts","Jack of Hearts","Queen of Hearts","King of Hearts",
		"Ace of Clubs","Two of Clubs","Three of Clubs","Four of Clubs","Five of Clubs","Six of Clubs","Seven of Clubs","Eight of Clubs","Nine of Clubs","Ten Of Clubs","Jack of Clubs","Queen of Clubs","King of Clubs",
		"Ace of Diamonds","Two of Diamonds","Three of Diamonds","Four of Diamonds","Five of Diamonds","Six of Diamonds","Seven of Diamonds","Eight of Diamonds","Nine of Diamonds","Ten Of Diamonds","Jack of Diamonds","Queen of Diamonds","King of Diamonds"};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] deck = new int[52];
		
		int n = getInput();
		int total = 0;
		
		shuffleDeck(deck);
		int i = 0;
		while(true){
			
			total = total + getPointValue(cards[deck[i]], total);
			System.out.print(cards[deck[i]]);
			i++;
			
			if(aceWasUsed && total > 21){
				aceWasUsed = false;
				total = total - 10;
			}
			
			if(total >= n){
				break;
			}
			System.out.print(", ");
		}
		
		System.out.print("\nGoal: " + n + ", Total: " + total);
		
	}
	
	/**
	 * This handles getting input and making sure it is an int
	 * 
	 * @param kb The scanner
	 * @param n The "int" of the input
	 * @return n THe int of the input to be used for the hands
	 */
	
	public static int getInput(){
		
		int n = 0;
		
		while(n < 16 || n > 21){
			
			n = (int) (Math.random() * 100) % 22;
			
		}
		return n;
	}
	
	/**
	 * Generates 1-52 and puts it into the array.
	 * 
	 * This will uniquely generate 1-52, so that each card has
	 * a position in the deck, this way I only need to know the
	 * position of the card, and not reorganize an array.
	 * 
	 * @param deck The array to have card numbers added to.
	 */
	
	public static void shuffleDeck(int[] deck){
		
		boolean newCard = false;
		
		for(int i = 0; i < 52;i++){
			
			newCard = false;
			
			while(newCard == false){
				
				deck[i] = ((int)(Math.random() * 10000) % 52); 
				
				if(isInDeck(deck,i,deck[i]) == true){
					
					newCard = true;
				}
			}
		}
	}
	
	/**
	 * Checks if the number of the card is already in the deck.
	 * 
	 * @param deck Array of cards.
	 * @param deckSize The current length of items in the array.
	 * @param card The current number that is being checked.
	 * @return boolean Tells if the card is there or not.
	 */
	
	public static boolean isInDeck(int[] deck,int deckSize,int card){
		
		for(int i = 0; i < deckSize; i++){
			
			if(card == deck[i]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks a card for its numerical value in blackjack.
	 * 
	 * This takes in a card and the total value of the hand
	 * and returns the numerical value of the card in question.
	 * 
	 * Aces are a special case and required a extra public
	 * boolean to be able to handle smoothly. To know when they
	 * are a 1 or 11, I need to know if they have been used,
	 * and if the value of the hand is too high.
	 * 
	 * @param card The current card value to be converted.
	 * @param count The total of the cards in the hand.
	 * @return int The value of the card checked.
	 */
	
	public static int getPointValue(String card, int count){
		
		int cardValue = 0;
		
		String cardType = card.substring(0, card.indexOf(' '));
		
		if(cardType.equals("Ace")){
			if(count > 10){
				cardValue = 1;
			}
			if(count < 11){
				cardValue = 11;
				aceWasUsed = true;
			}
		}
		if(cardType.equals("King") || cardType.equals("Queen") 
				|| cardType.equals("Jack") || cardType.equals("Ten")){
			cardValue = 10;
		}
		if(cardType.equals("Nine")){
			cardValue = 9;
		}
		if(cardType.equals("Eight")){
			cardValue = 8;
		}
		if(cardType.equals("Seven")){
			cardValue = 7;
		}
		if(cardType.equals("Six")){
			cardValue = 6;
		}
		if(cardType.equals("Five")){
			cardValue = 5;
		}
		if(cardType.equals("Four")){
			cardValue = 4;
		}
		if(cardType.equals("Three")){
			cardValue = 3;
		}
		if(cardType.equals("Two")){
			cardValue = 2;
		}
		
		return cardValue;
	}

}
