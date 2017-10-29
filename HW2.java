import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add B0544143 and 洪千惠  here
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		 cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int i=1;i<=nDeck;i++)//看有幾副牌，要重複幾次print一副撲克牌
			{for(int x=1;x<=4;x++)//每副撲克牌有四種花色，從第一個花色到第四個花色
				{for(int y=1;y<=13;y++)//每個花色有13張牌，從1到13
					{Card card =new Card(x,y);//new一個card，分別是前面花色，後面數值，把花色和值存在卡中
					 cards.add(card);//把含有花色值和數值的card，加入ArrayList的cards裡
					}
				}
			}
	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
        for(Card c:cards)//把ArratList的cards一個一個被取出，存在c裡
		{c.printCard();}//把所有c給print出來
        
		}
	
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
     String suitname="";//創一個變數來儲存suit的花色名稱
     String rankname="";//創一個變數來儲存rank的數值名稱
		if(suit==1)//如果suit是1的話
			suitname="Clubs";//suit的名稱是Clubs
		else if(suit==2)//其他的，如果suit是2的話
			suitname="Diamonds";//suit的名稱是Diamonds
		else if(suit==3)//其他的，如果suit是3的話
			suitname="Hearts";//suit的名稱是Hearts
		else//其他剩下的，也就是suit=4
			suitname="Spades";//suit的名稱是Spades
		if(rank==1)//如果rank是1的話
			rankname="Ace";//rank的名稱是Ace
		else if(rank==11)//其他的，如果rank是11的話
			rankname="Jack";//rank的名稱是Jack
		else if(rank==12)//其他的，如果rank是12的話
			rankname="Queen";//rank的名稱是Queen
		else if(rank==13)//其他的，如果rank是13的話
			rankname="King";//rank的名稱是King
		else//其他剩下的，包含2,3,4,5,6,7,8,9,10
			rankname=(rank+"");//rank的名稱是原本rank的值
		System.out.println(suitname+" "+rankname);//print出花色名稱和值的名稱
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
