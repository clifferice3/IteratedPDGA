/**
 * Class containing an type of Strategy.
 * @author	081028AW
 */
public class Strategy3MGA extends Strategy
   {
  /**
   * Encoding for a strategy.
   */

   int[] lastMoves = {-1,-1,-1}
   boolean start = true;
   int[][][] decisions;
   int[] startMoves;
   String name;
   

  // 0 = defect, 1 = cooperate
  // -1 = Start of game, 0 = CC, 1 = CD, DC = 2, DD = 3 in decision array indexing

   public Strategy(int[][][] decisions, int[] startMoves){
		this.decisions = decisions;
		this.name = "3-Memory GA";
		this.startMoves = smartMoves;
    }

   public int nextMove(){
		if(start)
		{
			if (lastMoves[0] == -1){
				return startMoves[0];
			}
			else if (lastMoves[1] == -1) {
				return startMoves[1 + lastMoves[0]);
			}
			else if (lastMoves[2] == -1){
				return startMoves[5 + lastMoves[0] + lastMoves[1]);
			)
		}
		else
		{
			return decisions[lastMoves[0]][lastMoves[1]][lastMoves[2]];
		}
    }  /* nextMove */


   public void saveMoves(int myMove, int oppMove){
		int situation;
		if(myMove == 1){
			if(oppMove == 1){
				situation = 0;
			}
			else{
				situation = 1;
			}
		}
		else {
			if(oppMove == 1){
				situation = 2;
			}
			else{
				situation = 3;
			}
		}
		lastMoves[2] = lastMoves[1];
		lastMoves[1] = lastMoves[0];
		lastMoves[0] = situation;
		for (int i=0; i < 3 && start; i++){
			if (lastMoves[i] == -1) { return; }
		}
		start = false;
	}
	
   public String getName()  { return name; }
   }  /* class Strategy */

