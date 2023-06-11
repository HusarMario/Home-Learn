public class Main {

    public static void main(String[] args) {
	    Unit unit01 = new Unit();
	    unit01.showStats();

	    BlueUnit blueUnit = new BlueUnit();
	    blueUnit.showStats();

	    RedUnit redUnit = new RedUnit();
	    redUnit.showStats();

	    unit01.steady();
	    blueUnit.steady();
	    redUnit.steady();

	    unit01.showStats();
	    blueUnit.showStats();
	    redUnit.showStats();

	    soldiersSteady(unit01);
	    soldiersSteady(blueUnit);
	    soldiersSteady(redUnit);

		unit01.showStats();
		blueUnit.showStats();
		redUnit.showStats();

    }

    public static void soldiersSteady(Unit unit){
    	if(unit instanceof RedUnit)
		{
			System.out.println("Red Army");
		}
    	if(unit instanceof BlueUnit)
		{
			System.out.println("Blue Army");
		}
    	unit.steady();
	}
}
