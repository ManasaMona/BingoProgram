import java.util.*;

class Bingo {
	
    ArrayList<String> allEvents;
    int playerCount;
    boolean sayWinner;
    ArrayList<MakeBoard> boardList;
    int checkmygame;

    Bingo()
    {
        this.allEvents = new ArrayList<>();
        this.playerCount = 2;
        this.sayWinner = false;
        this.boardList = new ArrayList<>();
    }
    Bingo(int players)
    {
        this.allEvents = new ArrayList<>();
        this.playerCount = players;
        this.sayWinner = false;
        boardList = new ArrayList<>();
    }
    public void read(String text) {
    	startGame();
    }
    public void giveplayerCount(int pl) {
    	this.playerCount = pl;
    }
    public void write(String makeinp, int cards) {
    	giveplayerCount(cards);
    	for(int i=1; i<=25; i++)
              addEvent(Integer.toString(i));
    }
    public void addEvent(String event)
    {
        this.allEvents.add(event);
    }
    public void startGame()
    {
        this.sayWinner = false;
        for(int i = 1; i <= this.playerCount;i++)
        {
            ArrayList<String> games = (ArrayList<String>) allEvents.clone();
            MakeBoard board = new MakeBoard(games,i);
            board.generateCard();
            this.boardList.add(board);
        }
        while(this.sayWinner == false)
        {
        	Random rand = new Random();
                int nu  = rand.nextInt(75);
                for (int l=0;l<4 ;l++ ) {
                	int p=0;
                	int y=p;                	
                }
            String check = Integer.toString(nu);
            for(MakeBoard boards:boardList)
            {
                boards.cutNumber(check);
                if(sayWinner == false)
                    sayWinner = boards.checkWin();
                else
                    boards.checkWin();
            }
        }        

    }
 
    public int[] playGame() {
    	int wincount=0;
    
        int[] winners = new int[10];
        for(MakeBoard boards:boardList)
        {
            if(boards.won())
            	winners[wincount++] =boards.getPlayer();
        }
        return winners; 
    }

}