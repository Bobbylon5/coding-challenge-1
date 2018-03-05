
public class Setup {
	

	
	public String start(String input){
		String lines[] = input.split("[\\r\\n]+");
		String output = runSetup(lines);
		return output;
	}
	
	public String runSetup(String[] lines){
		Board map = setupBoard(lines[0]);
		Unit[] allUnits = new Unit[(lines.length-1)/2];
		int noOfUnits = 0;
		for (int i = 1; i < lines.length; i += 2){
			Unit aUnit = new Unit();
			setupUnit(aUnit, lines[i]);
			aUnit.setOrders(lines[i+1]);
			allUnits[noOfUnits] = aUnit;
			noOfUnits++;
		}
		System.out.println("setup done");
		String retStri = run(map, allUnits);
		return retStri;
	}
	
	private String run(Board map, Unit[] allUnits){
		Unit[] results = new Unit[allUnits.length];
		RunUnit running = new RunUnit();
		for (int i = 0; i < allUnits.length; i ++){
			results[i] = running.runUnit(map, allUnits[i]);
		}
		
		System.out.println("run done");
		String retStri = finish(results);
		return retStri;
	}
	
	public String finish(Unit[] results){
		String retStri = "";
		System.out.print("\n\n");
		for (int i = 0; i < results.length; i ++){
			retStri += "\n";
			retStri += results[i].getX().getIt();
			retStri += " ";
			System.out.print(results[i].getX().getIt() + " ");
			retStri += results[i].getY().getIt();
			retStri += " ";
			System.out.print(results[i].getY().getIt() + " ");
			retStri += results[i].getDirect().getDirString();
			retStri += " ";
			System.out.print(results[i].getDirect().getDirString() + " ");	
			if (results[i].getLost()){
				System.out.print("LOST");
				retStri += "LOST";
			}
			System.out.print("\n");	
		}
		System.out.println("finish done");
		return retStri;
	}


	private void setupUnit(Unit thisUnit, String str){
		String[] splitStr = split(str);
		System.out.println("Unit = "+ splitStr[0] +" "+ splitStr[1] + " " + splitStr[2]);
		Detail dX = new Detail(false, true, intCast(splitStr[0]));
		Detail dY = new Detail(false, true, intCast(splitStr[1]));
		Detail dD = new Detail(true, false, splitStr[2]);
		thisUnit.setX(dX);
		thisUnit.setY(dY);
		thisUnit.setDirect(dD);
		
	}
	
	private Board setupBoard( String str){
		String[] splitStr = split(str);
		Board theBoard = new Board(intCast(splitStr[0]), intCast(splitStr[1]));
		System.out.println("The Board size = "+ splitStr[0] +" "+ splitStr[1]);
		return theBoard;
	}
	
	private String[] split (String str){
		String[] splitStr = str.split("\\s+");
		return splitStr;
	}
	
	private int intCast(String str){
		int intResult = Integer.parseInt(str);
		return intResult;
	}
	
}
