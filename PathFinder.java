import java.util.ArrayList;


public class PathFinder {
	
	State StartingState ;
	
	int Dimension;
	int id = 0;
	
	ArrayList<Integer> Coordinates;
	ArrayList<State> Close = new ArrayList<State>();
	ArrayList<State> Open = new ArrayList<State>();
	
	public PathFinder(State aStart, int aDimension){
		
		Dimension = aDimension;
		StartingState = aStart ;
	}
	
	public int ManhattanDistanceCalculator(State aState) {
		
		State currentState = aState ;

		int ManhattanDistance = 0;
		int x=0;
		int y=0;

		for(int i =0;i<currentState.getState().size();i++){
			for(int j=0;j<currentState.getState().get(i).size();j++){
				if( (currentState.getState().get(i).get(j) % Dimension) != 0 ){
					
					x = Math.abs(i-(currentState.getState().get(i).get(j)/Dimension));
					y = Math.abs(j-((currentState.getState().get(i).get(j)%Dimension)-1));
					
				}else if(currentState.getState().get(i).get(j) !=0){
					
					x = Math.abs(i-((currentState.getState().get(i).get(j)/Dimension)-1));
					y = Math.abs(j-(Dimension-1));
					
				}else{
				
				}
				
				ManhattanDistance = ManhattanDistance + x + y;
			}
		}
		
		return ManhattanDistance;
	}
	
	public void GCalculator(){
		
		StartingState.setF(0);
		StartingState.setG(0);
		StartingState.setFather(null);
		Open.add(StartingState);
		
		boolean flag = true ;
		boolean flag2 = true;
		boolean flag3 = true;
		
		State currentState = null;
		
		while(flag==true){
			
			double minF = Open.get(0).getF();;
			int position = 0;
			
			for(int i=0; i < Open.size(); i++){
				if(minF> Open.get(i).getF()){
					
					minF = Open.get(i).getF();
					position = i;
				}
			}
			
			if(Open.size()>0){

				currentState = Open.get(position);
				Open.remove(Open.get(position));
				Close.add(currentState);
			}
			
			ArrayList<Integer> CurrentCoordinates = currentState.getCoordinates();
			
			if(CurrentCoordinates.get(1)+1 <= Dimension - 1){
				
				ArrayList<ArrayList<Integer>> cs = new ArrayList<ArrayList<Integer>>();
					
				for(int x=0;x<Dimension;x++) {
						
					@SuppressWarnings("unchecked")
					ArrayList<Integer> t = (ArrayList<Integer>) currentState.getState().get(x).clone();
					cs.add(t); 
				}
					
				int a = cs.get(CurrentCoordinates.get(0)).get(CurrentCoordinates.get(1)+1);
					
				cs.get(CurrentCoordinates.get(0)).set(CurrentCoordinates.get(1)+1, 0);
				cs.get(CurrentCoordinates.get(0)).set(CurrentCoordinates.get(1), a);
					
				State MoveRight = new State(cs);
				for(int i=0;i<Open.size();i++){
					if(MoveRight.equals(Open.get(i))){
						flag2 = false;
					}
				}
				for(int i=0;i<Close.size();i++){
					if(MoveRight.equals(Close.get(i))){
						flag3 = false;
					}
				}
				if(flag2&&flag3){
					MoveRight.setFather(currentState);
					MoveRight.setG(currentState.getG()+0.5);
					double g = MoveRight.getG();
					int aH = ManhattanDistanceCalculator(MoveRight);
					MoveRight.setF(g+aH);
					Open.add(MoveRight);
						
				}else if(flag2==false&&flag3){
					if(MoveRight.getG()>currentState.getG()+0.5){
						MoveRight.setFather(currentState);
						MoveRight.setG(currentState.getG()+0.5);
						double g = MoveRight.getG();
						int aH = ManhattanDistanceCalculator(MoveRight);
						MoveRight.setF(g+aH);
					}
				}		
			}
			
			flag2 = true;
			flag3 = true;
			
			if(CurrentCoordinates.get(1)-1 >= 0){
				
				ArrayList<ArrayList<Integer>> cs = new ArrayList<ArrayList<Integer>>();
				for(int x=0;x<Dimension;x++) {
					@SuppressWarnings("unchecked")
					ArrayList<Integer> t = (ArrayList<Integer>) currentState.getState().get(x).clone();
					cs.add(t); 
				}
					
				int a = cs.get(CurrentCoordinates.get(0)).get(CurrentCoordinates.get(1)-1);
					
				cs.get(CurrentCoordinates.get(0)).set(CurrentCoordinates.get(1)-1, 0);
				cs.get(CurrentCoordinates.get(0)).set(CurrentCoordinates.get(1), a);
					
					
				State MoveLeft = new State(cs);
				for(int i=0;i<Open.size();i++){
					if(MoveLeft.equals(Open.get(i))){
						flag2 = false;
					}
				}
				for(int i=0;i<Close.size();i++){
					if(MoveLeft.equals(Close.get(i))){
						flag3 = false;
					}
				}
				if(flag2&&flag3){
					MoveLeft.setFather(currentState);
					MoveLeft.setG(currentState.getG()+0.5);
					double g = MoveLeft.getG();
					int aH = ManhattanDistanceCalculator(MoveLeft);
					MoveLeft.setF(g+aH);
					Open.add(MoveLeft);
						
				}else if(flag2==false&&flag3){
					if(MoveLeft.getG()>currentState.getG()+0.5){
						MoveLeft.setFather(currentState);
						MoveLeft.setG(currentState.getG()+0.5);
						double g = MoveLeft.getG();
						int aH = ManhattanDistanceCalculator(MoveLeft);
						MoveLeft.setF(g+aH);
					}		
				}	
			}
			
			flag2 = true;
			flag3 = true;
			
			if(CurrentCoordinates.get(0)-1 >= 0){
				
				ArrayList<ArrayList<Integer>> cs = new ArrayList<ArrayList<Integer>>();
				for(int x=0;x<Dimension;x++) {
					@SuppressWarnings("unchecked")
					ArrayList<Integer> t = (ArrayList<Integer>) currentState.getState().get(x).clone();
					cs.add(t); 
				}
					
				int a = cs.get(CurrentCoordinates.get(0)-1).get(CurrentCoordinates.get(1));
					
				cs.get(CurrentCoordinates.get(0)-1).set(CurrentCoordinates.get(1), 0);
				cs.get(CurrentCoordinates.get(0)).set(CurrentCoordinates.get(1), a);
					
					
				State MoveUp = new State(cs);
				for(int i=0;i<Open.size();i++){
					if(MoveUp.equals(Open.get(i))){
						flag2 = false;
					}
				}
				for(int i=0;i<Close.size();i++){
					if(MoveUp.equals(Close.get(i))){
						flag3 = false;
					}
				}
				if(flag2&&flag3){
					MoveUp.setFather(currentState);
					MoveUp.setG(currentState.getG()+0.5);
					double g = MoveUp.getG();
					int aH = ManhattanDistanceCalculator(MoveUp);
					MoveUp.setF(g+aH);
					Open.add(MoveUp);
						
				}else if(flag2==false&&flag3){
					if(MoveUp.getG()>currentState.getG()+0.5){
						MoveUp.setFather(currentState);
						MoveUp.setG(currentState.getG()+0.5);
						double g = MoveUp.getG();
						int aH = ManhattanDistanceCalculator(MoveUp);
						MoveUp.setF(g+aH);
					}
				}	
			}
			
			flag2 = true;
			flag3 = true;
			
			if(CurrentCoordinates.get(0)+1 <= Dimension - 1){
				ArrayList<ArrayList<Integer>> cs = new ArrayList<ArrayList<Integer>>();
				for(int x=0;x<Dimension;x++) {
					@SuppressWarnings("unchecked")
					ArrayList<Integer> t = (ArrayList<Integer>) currentState.getState().get(x).clone();
					cs.add(t); 
				}
					
				int a = cs.get(CurrentCoordinates.get(0)+1).get(CurrentCoordinates.get(1));
					
				cs.get(CurrentCoordinates.get(0)+1).set(CurrentCoordinates.get(1), 0);
				cs.get(CurrentCoordinates.get(0)).set(CurrentCoordinates.get(1), a);
					
					
				State MoveDown = new State(cs);
				for(int i=0;i< Open.size();i++){
					if(MoveDown.equals(Open.get(i))){
						flag2 = false;
					}
				}
				for(int i=0;i< Close.size();i++){
					if(MoveDown.equals(Close.get(i))){
						flag3 = false;
					}
				}
				if(flag2&&flag3){
					MoveDown.setFather(currentState);
					MoveDown.setG(currentState.getG()+0.5);
					double g = MoveDown.getG();
					int aH = ManhattanDistanceCalculator(MoveDown);
					MoveDown.setF(g+aH);
					Open.add(MoveDown);
						
				}else if(flag2==false&&flag3){
					if(MoveDown.getG()>currentState.getG()+0.5){
						MoveDown.setFather(currentState);
						MoveDown.setG(currentState.getG()+0.5);
						double g = MoveDown.getG();
						int aH = ManhattanDistanceCalculator(MoveDown);
						MoveDown.setF(g+aH);
							
					}
				}				
			}
			
			flag2 = true;
			flag3 = true;
			
			for(int i=0;i< Close.size();i++){
				
				State c = Close.get(i);
				int md = ManhattanDistanceCalculator(c);
				
				if(md == 0 || Open.size() == 0){
					if(Open.size() == 0) {
						System.out.println("No Solution");
					}else {
						System.out.println(Close.get(i).getState());
					}
					
					flag = false;
				}
			}
		}	
	}
	
	public void printHole() {
		
		ArrayList<State> OnlyPathNodes = new ArrayList<State>();
		boolean flag4 = true;
		OnlyPathNodes.add(Close.get(Close.size()-1));
		State PFather = Close.get(Close.size()-1).getFather();
		
		if(PFather!=null ){
			while(flag4){
				if(PFather.equals(StartingState)){
					flag4 = false;
				}
				OnlyPathNodes.add(PFather);
				PFather = PFather.getFather();	
			}
		}
		for(int y = OnlyPathNodes.size()-1;y>=0;y--) {
			for(int x=0;x<OnlyPathNodes.get(y).getState().size();x++) {
				
					System.out.println(OnlyPathNodes.get(y).getState().get(x));
				
			}
			System.out.println("\n");
		}
	}
}
