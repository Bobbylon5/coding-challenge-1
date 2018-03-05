
public class RunUnit {

	/**
	 * The public face, it requires a board and a unit (with orders),
	 * it executes those orders and returns the unit.
	 * @param board "Board"
	 * @param toRunOrigional "Unit"
	 * @return toRun "Unit"
	 */
	public Unit runUnit (Board board, Unit toRunOrigional){
		Unit toRun = toRunOrigional;		
		String[] seq = toRun.getOrders().split("(?!^)");
		//System.out.print("\n\nNEW SEQUENCE");
		
		if(!checkInArea(board.getMaxX(), board.getMaxY(), toRun)){
			toRun.setLost(true);
		}
		for (int inSequence = 0; inSequence < seq.length; inSequence++){
			//System.out.print("\ninSeq" + inSequence);
			if(checkInArea(board.getMaxX(), board.getMaxY(), toRun)){
				logic(toRun, seq[inSequence]);
			}else {
				toRun.setLost(true);
				logic(toRun, seq[inSequence]);
			}	
		}
		if(!checkInArea(board.getMaxX(), board.getMaxY(), toRun)){
			toRun.setLost(true);
		}
		return toRun;
	}
	
	
	/**
	 * North = 1
	 * East = 2
	 * South = 3
	 * West = 4
	 */
	
	private int convertDirectToInt(String direction){
		int directionInt = 0;
		switch (direction) {
        case "N":  directionInt = 1;
                 break;
        case "E":  directionInt = 2;
                 break;
        case "S":  directionInt = 3;
                 break;
        case "W":  directionInt = 4;
                 break;
        default: throw new Error("Invalid String Direction = "+ direction);
		}
		return directionInt;
	}
	private String convertIntDirectToString(int direction){
		String directionStr;
		switch (direction) {
        case 1:  directionStr = "N";
                 break;
        case 2:  directionStr = "E";
                 break;
        case 3:  directionStr = "S";
                 break;
        case 4:  directionStr = "W";
                 break;
        default: throw new Error("Invalid Int Direction = "+ direction);                
		}
		return directionStr;
	}
	
	private void logic (Unit toRun, String next){
		 if (next.equals("L")){  
			 //perform left maneuver
			 toRun.getDirect().confirmIfDirection(); {
				 if (convertDirectToInt(toRun.getDirect().getDirString()) == 1) {
					// turn (flip)
					 toRun.editDirect("W");
				 }else {
					// turn (normal)
					 int temp = convertDirectToInt(toRun.getDirect().getDirString()) -1;
					 toRun.editDirect(convertIntDirectToString(temp));
				 }
			 }
		 }else if (next.equals("R")){  
			 //perform right maneuver
			 toRun.getDirect().confirmIfDirection(); {	 
				 if (convertDirectToInt(toRun.getDirect().getDirString()) == 4){
					 // turn (flip)
					 toRun.editDirect("N");
				 }else {
					 // turn (normal)
					 int temp = convertDirectToInt(toRun.getDirect().getDirString()) +1;
					 toRun.editDirect(convertIntDirectToString(temp));
				 }
			 }
		 }else if (next.equals("F")){ 
			 //perform forward maneuver
			 String dirSt = toRun.getDirect().getDirString();
			 int dir = convertDirectToInt(dirSt);
			 if (dir == 1){
				 toRun.editY(toRun.getY().getIt()+1);
			 }else if (dir == 3){
				 toRun.editY(toRun.getY().getIt()-1);
			 }else if (dir == 2){
				 toRun.editX(toRun.getX().getIt()+1);
			 }else if (dir == 4){
				 toRun.editX(toRun.getX().getIt()-1);
			 }
		 }else {
			 throw new Error ("Invalid input = "+ next );
		 }
	}
	
	
	private boolean checkInArea (int maxX, int maxY, Unit toRun){
		int x = toRun.getX().getIt();
		int y = toRun.getY().getIt();
		if ((x < 0) || (x > maxX ) || (y < 0) || (y  > maxY))	{
			//System.out.print("    Out of area " + x + " "+ y );
			return false;
		} else {
			return true;
		}
	}
	
	
	
}
