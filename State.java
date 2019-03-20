import java.util.ArrayList;

public class State {
	
	double F;
	double G;
	double H;
	int id = -1;
	State Father;
	ArrayList<ArrayList<Integer>> State = new ArrayList<ArrayList<Integer>>();
	boolean Free;
	
	public State(ArrayList<ArrayList<Integer>> sCoordinates){
		
		State = sCoordinates;
	}
	
	public double getF(){
		return F;
	}
	
	public double getG(){
		return G;
	}
	
	public double getH(){
		return H;
	}
	
	public ArrayList<ArrayList<Integer>> getState(){
		return State;
	}
	
	public ArrayList<Integer> getCoordinates(){
		ArrayList<Integer> coordinates = new ArrayList<Integer>();
		for(int i=0;i<State.size();i++) {
			for(int j=0;j<State.get(i).size();j++) {
				if(State.get(i).get(j) == 0) {
					coordinates.add(i);
					coordinates.add(j);
				}
			}
		}
		return coordinates;
	}
	
	public boolean isFree(){
		return Free;
	}
	
	public State getFather(){
		return Father;
	}
	
	public void setF(double aF){
		F = aF;
	}
	
	public void setG(double aG){
		G = aG;
	}
	
	public void setH(double aH){
		H = aH;
	}
	
	public void setFather(State aFather){
		Father = aFather;
	}
	
	public void setFree(boolean FreeOrNot){
		Free = FreeOrNot;
	}
}
