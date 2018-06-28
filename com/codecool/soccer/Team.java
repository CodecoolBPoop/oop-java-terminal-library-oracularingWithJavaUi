import java.util.*;
import java.util.HashMap;

public class Team {
	
	public String name;
	public int rank;
	public int goalFor;
	public int goalAgainst;
	public int ballPosession;

	

	static String[][] Teams = new String[][]{
        {"Uruguay","14","5","0","58","9"},
	{"Russia","70","8","4","44","4.5"},
	{"Saud-Arabia","67","2","2","58","4.5"},
	{"Egypt","45","3","2","45","6"},
	{"Spain","10","6","5","66","9"},
	{"Portugal","4","5","4","51","10"},
	{"Marocco","41","2","2","50","6.5"},
	{"Iran","27","2","4","35","7.5"},
	{"France","7","3","1","52","10"},
	{"Denmark","12","2","1","46","9"},
	{"Australia","36","2","5","51","6.5"},
	{"Peru","11","2","2","52","9"},
	{"Croatia","20","7","1","49","8"},
	{"Nigeria","48","3","4","48","6"},
	{"Argentina","5","3","5","65","10"},
	{"Iceland","22","2","5","37","7.5"},
	{"Brazil","2","5","1","58","10"},
	{"Switzerland","6","5","4","55","10"},
	{"Serbia","34","2","4","46","7"},
	{"Costa Rica","23","2","2","42","7.5"},
	{"Mexico","15","3","1","50","8"},
	{"Germany","1","2","4","67","10"},
	{"Sweden","24","2","2","40","7.5"},
	{"SouthKorea","57","3","3","41","5"},
	{"England","12","8","2","59","9"},
	{"Belgium","3","8","2","57","10"},
	{"Tunisia","21","3","7","45","8"},
	{"Panama","55","1","9","41","5.5"},
	{"Japan","61","4","3","57","5"},
	{"Senegal","27","4","3","45","7.5"},
	{"Columbia","16","4","2","48","8"},
	{"Poland","8","1","5","51","9"},
	};
	
	
	static HashMap<String, Double> teamNamesMagicNumber = new HashMap<>();
	
	public static void processData(String[][] Array){
		for (int row = 0; row < Array.length; row++){	

			List<Double> values = new ArrayList<Double>();
			
			for(int column = 0; column < Array[row].length; column ++) {
				
				if (column != 0 && column !=1 ) {
					
					values.add(Double.valueOf(Array[row][column]));
					
					if (column == 5) {
						
						String teamName = Array[row][0];
						double magicNumber = createAggregatedNumber(values.get(0),values.get(1),values.get(2),values.get(3));
						
						fillMap(teamName, magicNumber);
					}
				}			
			}
		
		}
	}

	public static void mergeTwoList(ArrayList numbers, ArrayList teams){
		for (int i = 0; i < 32; i++) {
			System.out.println(numbers.get(i)+". "+teams.get(i));
		}
		
		
	}

	public static ArrayList generateNumber() {
		ArrayList numbers = new ArrayList();
		for (int index = 1; index < 33; index++ ) {
			numbers.add(index);
			
		}
		return numbers;
	}


	public static ArrayList teamNames(HashMap<String, Double> givenMap) {

		ArrayList teamNames = new ArrayList();
		teamNames.addAll(givenMap.keySet());
		return teamNames;
	}
	
	public static void fillMap(String teamName, double magicNumber){
		teamNamesMagicNumber.put(teamName, magicNumber);
	}


	public static double createAggregatedNumber(double gf,double ga,double bp,double multiplier){
		double result = (gf*multiplier)-(ga*multiplier)+(bp*(multiplier/10.0));
		return result;
		
	}
	


  	public static void main(String[] args){
	
		processData(Teams);
		teamNames(teamNamesMagicNumber);
		mergeTwoList(generateNumber(),teamNames(teamNamesMagicNumber));

	}
}









