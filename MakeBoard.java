import java.util.*;

class MakeBoard {
	String board[][];
    int length_brd = 5;
    int compSize = length_brd * length_brd;
    HashMap<String,Boolean> emapcall;
    ArrayList<String> events;
    ArrayList<String> markEve;
    String dummy =" ";
    int player;
    boolean win;

	MakeBoard() {    
        board = new String[length_brd][length_brd];
        markEve = new ArrayList<>();
        events = new ArrayList<>();
        emapcall = new HashMap<>();
        emapcall.put(dummy, true);
        player = -1;
        win = false;
	} 
	 MakeBoard(ArrayList<String> myList)
    {
        board = new String[length_brd][length_brd];
        markEve = new ArrayList<>();
        events = myList;
        emapcall = new HashMap<>();
                emapcall.put(dummy, true);
                int r= -1;
                player = r;
                win = false;
    }  
    MakeBoard(ArrayList<String> myList, int  numb) {
        board = new String[length_brd][length_brd];
        markEve = new ArrayList<>();
        events = myList;
        emapcall = new HashMap<>();
                emapcall.put(dummy, true);
                player = numb;
                win = false;
    } 
     public void RefreshEvents(ArrayList<String> myList) {
           	events.addAll(myList);
        }

     public boolean generateCard()
        {
            if(this.events.size() < compSize - 1)
                return false;
            while(markEve.size() < compSize  - 1)
            {
                Random rand = new Random();
                int index  = rand.nextInt(this.events.size());
                String str = events.get(index);
                markEve.add(str);
                events.remove(str);
            }
            int count = 0;
            for(String str:markEve)
            {
                emapcall.put(str,false);
                if(count == compSize/2)
                {  
                    board[count/length_brd][count%length_brd] = dummy;
                    count++;
                }
                board[count/length_brd][count%length_brd] = str;
                count++;
            }
            return true;
        }
    

        public void cutNumber(String value)
        {
            if(emapcall.containsKey(value))
                emapcall.put(value, Boolean.TRUE);
        }

        public boolean checkWin()
        {
            this.win = evalBoard();
            return this.win;
        }
        public boolean won()
        {
            return this.win;
        }
        public int getPlayer()
        {
            return player;
        }
        private boolean evalBoard()
        {
            int i, j, count;

            for(i = 0; i < length_brd; i++)
            {
                j = 0;
                count = 0;
                while(emapcall.get(board[i][j]) != false)
                {
                    count++;
                    j++;
                    if(count == length_brd)
                        return true;
                }

                j = 0;
                count = 0;
                while(emapcall.get(board[j][i]) != false)
                {
                    count++;
                    j++;
                    if(count == length_brd)
                        return true;
                }
            }

            i = 0;
            count = 0;
            while(emapcall.get(board[i][i]) != false)
            {
                count++;
                    i++;
                    if(count == length_brd)
                        return true;
            }

            i = length_brd -1;
            j = 0;
            count = 0; 
            while(emapcall.get(board[i][j]) != false)
            {
                count++;
                i--;
                j++;
                if(count == length_brd)
                    return true;
            }

            return false;
        }
        

}