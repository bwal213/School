import java.util.Scanner;

/**
 * 
 */

/**
 * @author Ben
 * Version: 1.0
 */
public class Ben_Walker_HW2_1 {

	/**
	 * @param args
	 */
	public static String[] cards = {"Ace of Spades","Two of Spades","Three of Spades","Four of Spades","Five of Spades","Six of Spades","Seven of Spades","Eight of Spades","Nine of Spades","Ten Of Spades","Jack of Spades","Queen of Spades","King of Spades",
			"Ace of Hearts","Two of Hearts","Three of Hearts","Four of Hearts","Five of Hearts","Six of Hearts","Seven of Hearts","Eight of Hearts","Nine of Hearts","Ten Of Hearts","Jack of Hearts","Queen of Hearts","King of Hearts",
			"Ace of Clubs","Two of Clubs","Three of Clubs","Four of Clubs","Five of Clubs","Six of Clubs","Seven of Clubs","Eight of Clubs","Nine of Clubs","Ten Of Clubs","Jack of Clubs","Queen of Clubs","King of Clubs",
			"Ace of Diamonds","Two of Diamonds","Three of Diamonds","Four of Diamonds","Five of Diamonds","Six of Diamonds","Seven of Diamonds","Eight of Diamonds","Nine of Diamonds","Ten Of Diamonds","Jack of Diamonds","Queen of Diamonds","King of Diamonds"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] deck = new int[52];
		int n = 12;
		Scanner kb = new Scanner(System.in);
		
		n = getInput(kb, n);
		
		kb.close();
		
		if(n == 0){
			
			System.out.print("\nSo no one is playing today? huh.");
			return;
		}
				
		shuffleDeck(deck);
		dealTheHands(deck,n);
	}
	
	public static int getInput(Scanner kb, int n){
		
		System.out.print("Please enter the hands to be dealt: ");
		String input = "" + kb.next();
		System.out.println(input);
				
		while(n < 0 || n > 10){
			while(true){
				try{
					
					n = Integer.parseInt(input);
					break;
				}catch(Exception e){
					
					System.out.println(e);
					System.out.print("\nNumeric input is prefered\n");
					System.out.print("Please enter the hands to be dealt: ");
					input = "" + kb.nextInt();
				}				
			}
			
			if(n > 10){
				System.out.print("\nOnly a max of 10 hands can be dealt.\n");
			}
			if(n < 0){
				System.out.print("\nWho ever heard of negative players?\n");
			}
		}
		return n;
	}
	
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
	
	public static boolean isInDeck(int[] deck,int deckSize,int card){
		
		for(int i = 0; i < deckSize; i++){
			
			if(card == deck[i]){
				return false;
			}
		}
		
		return true;
	}
	
	public static void dealTheHands(int[] deck, int n){
		
		int[][] hands = new int[n][5];
		
		for(int i = 0; i < n;i++){
			
			hands[i][0] = deck[(n*0)+i];
			hands[i][1] = deck[(n*1)+i];
			hands[i][2] = deck[(n*2)+i];
			hands[i][3] = deck[(n*3)+i];
			hands[i][4] = deck[(n*4)+i];
			
			
		}
		
		showTheHands(hands);
		
	}
	
	public static void showTheHands(int[][] hands){
		
		for(int i = 0; i < hands.length;i++){
			
			System.out.print(cards[hands[i][0]] 
					+ ", " + cards[hands[i][1]] 
					+ ", " + cards[hands[i][2]] 
					+ ", " + cards[hands[i][3]] 
					+ ", " + cards[hands[i][4]]
							+ "\n\n");
			
		}
		
	}

}
