package AlgorithmAndDataStructureTests.LeetCode.Facebook;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by weizhou on 12/17/16.
 */
public class LargestPlus {
    HashMap<String, Integer> hm;
    int hitCount;
    public enum Direction {
        LEFT, RIGHT, UP, DOWN;
    }
    private class Position {
        int i;
        int j;
        public Position(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public ArrayList<Position> getCandidates(int[][] board){
        ArrayList<Position> candidates = new ArrayList<Position>();
        for (int i = 1; i < board.length-1; i++){
            for (int j = 1; j < board[0].length-1; j++){
                if (board[i][j] ==1 && board[i-1][j] == 1 && board[i+1][j] == 1 && board[i][j-1]== 1 && board[i][j+1] == 1)
                    candidates.add(new Position(i, j));
            }
        }
        return candidates;
    }

    public int getMaxSize(Position p, int[][] board){
        int min = Integer.MIN_VALUE;
        int left = getMaxSize(p.i, p.j-1, Direction.LEFT, board);
        int right = getMaxSize(p.i, p.j-1, Direction.RIGHT, board);
        int up = getMaxSize(p.i-1, p.j, Direction.UP, board);
        int down = getMaxSize(p.i+1, p.j, Direction.DOWN, board);
        return Math.min(left, Math.min(right, Math.min(up, down)));
    }

    public int getMaxSize(int i, int j, Direction d, int[][] board){
        if (i< 0 || i >=board.length || j < 0 || j >= board[0].length || board[i][j] == 0) return 0;
        String key = i+""+j+""+d;
        hitCount++;
        if (hm.containsKey(key)) return hm.get(key);
        int size = 1;
        switch(d){
            case LEFT:
                size+= getMaxSize(i, j-1, d, board);
                break;
            case RIGHT:
                size+= getMaxSize(i, j+1, d, board);
                break;
            case UP:
                size+= getMaxSize(i-1, j, d, board);
                break;
            case DOWN:
                size+= getMaxSize(i+1, j, d, board);
                break;
        }
        hm.put(key, size);
        return size;
    }

    public void getMaxPlus(int[][] board){
        ArrayList<Position> candidates = getCandidates(board);
        hm = new HashMap<String, Integer>();
        hitCount = 0;
        int maxSize = Integer.MIN_VALUE;
        Position maxPosition = null;
        for (Position p: candidates){
            int size = getMaxSize(p, board);
            if (size > maxSize){
                maxSize = size;
                maxPosition = p;
            }
        }

        System.out.println("hitCount: "+hitCount);
        if (maxPosition!= null) System.out.println("The max plus is rooted at: ("+ maxPosition.i+", "+maxPosition.j+")");
        else System.out.println("No plus found");
    }

    public static void main(String[] args){
        LargestPlus lp = new LargestPlus();
        int[][] board = {
                {0,0,0,0,0,1,0},
                {1,0,1,1,1,0,1},
                {1,1,1,1,1,1,1},
                {0,0,1,1,0,0,0},
                {0,0,0,1,0,0,0}};



		/*
			{
			{0,0,0,1,0,1,0},
		 	{1,0,1,1,1,0,1},
		 	{1,1,1,1,1,1,1},
		 	{0,0,1,1,0,0,0},
		 	{0,0,0,1,0,0,0}};

		*/
        lp.getMaxPlus(board);
    }
}
