import java.util.ArrayList;

public class PuzzleTest {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> Puzzle = new ArrayList<ArrayList<Integer>>();
		int Dimension = 4;
		
		for(int i = 0; i<Dimension;i++) {
			ArrayList<Integer> anArray = new ArrayList<Integer>();
			Puzzle.add(anArray);
		}
		
		//Dimension = 3
		/*Puzzle.get(0).add(5);
		Puzzle.get(0).add(0);
		Puzzle.get(0).add(3);
		Puzzle.get(1).add(2);
		Puzzle.get(1).add(1);
		Puzzle.get(1).add(7);
		Puzzle.get(2).add(4);
		Puzzle.get(2).add(8);
		Puzzle.get(2).add(6);*/

		Puzzle.get(0).add(5);
		Puzzle.get(0).add(1);
		Puzzle.get(0).add(2);
		Puzzle.get(0).add(3);
		Puzzle.get(1).add(6);
		Puzzle.get(1).add(0);
		Puzzle.get(1).add(8);
		Puzzle.get(1).add(15);
		Puzzle.get(2).add(9);
		Puzzle.get(2).add(12);
		Puzzle.get(2).add(4);
		Puzzle.get(2).add(7);
		Puzzle.get(3).add(13);
		Puzzle.get(3).add(10);
		Puzzle.get(3).add(14);
		Puzzle.get(3).add(11);
		
		System.out.println(Puzzle);
		
		long startTime = System.nanoTime();
		
		State startingState = new State(Puzzle);
		PathFinder pf = new PathFinder(startingState,Dimension);
		pf.GCalculator();
		pf.printHole();
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println((double)totalTime/1000000000);
	}
}
