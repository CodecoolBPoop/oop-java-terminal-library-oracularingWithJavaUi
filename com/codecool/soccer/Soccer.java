package com.codecool.soccer;

import com.codecool.termlib.*;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.codecool.soccer.Team;

import static com.codecool.soccer.Team.Teams;


public class Soccer {

	static String[] wordsFromFile;
	static File f = new File("teams.txt");
	static File resultsfile = new File("results.txt");
	static String[] menuHeader = {"Choose from these choices", "Choose a team", "Statistics", "Winner prediction"};
	static String[] mainMenu = {"1. Statistics", "2. Who would win?", "3. File read"};

	public static Map<String, ArrayList<String>> statList = new HashMap<String, ArrayList<String>> () {

		{
			put("1", new ArrayList<String>(){{ add("Goals:           3"); add("Received goals:  2"); add("Ball posession: 45%"); add("Fifa Ranking:   45");}});
			put("2", new ArrayList<String>(){{ add("Goals:           8"); add("Received goals:  2"); add("Ball posession: 59%"); add("Fifa Ranking:    9");}});
			put("3", new ArrayList<String>(){{ add("Goals:           5"); add("Received goals:  4"); add("Ball posession: 51%"); add("Fifa Ranking:    4");}});
			put("4", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  5"); add("Ball posession: 37%"); add("Fifa Ranking:   22");}});
			put("5", new ArrayList<String>(){{ add("Goals:           8"); add("Received goals:  4"); add("Ball posession: 44%"); add("Fifa Ranking:   70");}});
			put("6", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  2"); add("Ball posession: 42%"); add("Fifa Ranking:   22");}});
			put("7", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  2"); add("Ball posession: 40%"); add("Fifa Ranking:   24");}});
			put("8", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  4"); add("Ball posession: 35%"); add("Fifa Ranking:   27");}});
			put("9", new ArrayList<String>(){{ add("Goals:           1"); add("Received goals:  9"); add("Ball posession: 41%"); add("Fifa Ranking:   55");}});
			put("10", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  2"); add("Ball posession: 58%"); add("Fifa Ranking:   67");}});
			put("11", new ArrayList<String>(){{ add("Goals:           5"); add("Received goals:  1"); add("Ball posession: 58%"); add("Fifa Ranking:    2");}});
			put("12", new ArrayList<String>(){{ add("Goals:           1"); add("Received goals:  5"); add("Ball posession: 51%"); add("Fifa Ranking:    8");}});
			put("13", new ArrayList<String>(){{ add("Goals:           3"); add("Received goals:  1"); add("Ball posession: 52%"); add("Fifa Ranking:   10");}});
			put("14", new ArrayList<String>(){{ add("Goals:           3"); add("Received goals:  4"); add("Ball posession: 48%"); add("Fifa Ranking:   48");}});
			put("15", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  4"); add("Ball posession: 46%"); add("Fifa Ranking:   34");}});
			put("16", new ArrayList<String>(){{ add("Goals:           3"); add("Received goals:  7"); add("Ball posession: 45%"); add("Fifa Ranking:   21");}});
			put("17", new ArrayList<String>(){{ add("Goals:           7"); add("Received goals:  1"); add("Ball posession: 49%"); add("Fifa Ranking:   20");}});
			put("18", new ArrayList<String>(){{ add("Goals:           3"); add("Received goals:  5"); add("Ball posession: 65%"); add("Fifa Ranking:    5");}});
			put("19", new ArrayList<String>(){{ add("Goals:           5"); add("Received goals:  0"); add("Ball posession: 44%"); add("Fifa Ranking:   14");}});
			put("20", new ArrayList<String>(){{ add("Goals:           4"); add("Received goals:  3"); add("Ball posession: 57%"); add("Fifa Ranking:    61");}});
			put("21", new ArrayList<String>(){{ add("Goals:           5"); add("Received goals:  4"); add("Ball posession: 55%"); add("Fifa Ranking:    6");}});
			put("22", new ArrayList<String>(){{ add("Goals:           6"); add("Received goals:  5"); add("Ball posession: 66%"); add("Fifa Ranking:    10");}});
			put("23", new ArrayList<String>(){{ add("Goals:           4"); add("Received goals:  2"); add("Ball posession: 48%"); add("Fifa Ranking:    16");}});
			put("24", new ArrayList<String>(){{ add("Goals:           8"); add("Received goals:  2"); add("Ball posession: 57%"); add("Fifa Ranking:    3");}});
			put("25", new ArrayList<String>(){{ add("Goals:           4"); add("Received goals:  3"); add("Ball posession: 45%"); add("Fifa Ranking:    27");}});
			put("26", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  1"); add("Ball posession: 46%"); add("Fifa Ranking:    12");}});
			put("27", new ArrayList<String>(){{ add("Goals:           3"); add("Received goals:  3"); add("Ball posession: 41%"); add("Fifa Ranking:    57");}});
			put("28", new ArrayList<String>(){{ add("Goals:           3"); add("Received goals:  1"); add("Ball posession: 50%"); add("Fifa Ranking:    15");}});
			put("29", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  5"); add("Ball posession: 51%"); add("Fifa Ranking:    36");}});
			put("30", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  2"); add("Ball posession: 52%"); add("Fifa Ranking:    11");}});
			put("31", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  2"); add("Ball posession: 50%"); add("Fifa Ranking:   41");}});
			put("32", new ArrayList<String>(){{ add("Goals:           2"); add("Received goals:  4"); add("Ball posession: 67%"); add("Fifa Ranking:    1");}});
		}
	};

	public static void displayMenu(String[] menu, String header) {
		
		com.codecool.termlib.Terminal term = new com.codecool.termlib.Terminal();
		term.resetStyle();
		System.out.println("\033[0;31mWorldcup Oracle v1.0\033[0;37m \n");
		System.out.println(header);
		System.out.println("\033[0;31m━━━━━━━━━━━━━━━━━━━━━━━━━\033[0;37m");

		for (int i=0; i<menu.length; i++) {

			if (header.equals("Choose a team")) {
				System.out.format("%-20s", menu[i]);
				if (i%2==0){
					System.out.println("");
				}
			}
			else{
				System.out.println(menu[i]);
			}
		}

		System.out.println();
		System.out.println("E. Exit program");
		System.out.println();
		System.out.println();
		System.out.println("Enter your choice: ");

	}

	public static void displayMenu2(ArrayList menu, String header) {

		com.codecool.termlib.Terminal term = new com.codecool.termlib.Terminal();
		term.resetStyle();
		System.out.println("\033[0;31mWorldcup Oracle v1.0\033[0;37m \n");
		System.out.println(header);
		System.out.println("\033[0;31m━━━━━━━━━━━━━━━━━━━━━\033[0;37m");


		for (int i=0; i<menu.size(); i++) {
			System.out.println(menu.get(i));
		}

		System.out.println();
		System.out.println("E. Exit program");

	}

	public static void teams() {

		displayMenu(wordsFromFile, menuHeader[1]);
		String answer = getUserChoice();
		if (answer.equals("0")){
			menuLoop();
		}else if (Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32").contains(answer)){
			displayMenu2(statList.get(answer), menuHeader[2]);
		} else if (answer.equals("e")) {
			System.exit(0);
		} else {
			System.out.printf("error");
		}
	}

	public static void matchup() {
		com.codecool.termlib.Terminal term = new com.codecool.termlib.Terminal();
		term.resetStyle();
		com.codecool.soccer.Team team = new com.codecool.soccer.Team();
		HashMap<String, Double> magicNum = new HashMap<>();
		ArrayList<String> teamName = new ArrayList<>();
		team.processData(Teams);
		// magicNum = team.teamNamesMagicNumber;
		teamName = team.teamNames(Team.teamNamesMagicNumber);
		//team.mergeTwoList(Team.generateNumber(), teamName);
		displayMenu(wordsFromFile, menuHeader[1]);
		String answer = getUserChoice();
		if (answer.equals("0")){
			menuLoop();
		}else if (Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32").contains(answer)) {
			List keys = new ArrayList(Team.teamNamesMagicNumber.keySet());
			int team1 = Integer.parseInt(answer);
			Object obj = keys.get(team1-1);

			Double value1 = Team.teamNamesMagicNumber.get(obj);

			System.out.println("Please choose the second team: ");
			String answer2 = getUserChoice();
			int team2 = Integer.parseInt(answer2);
			Object obj2 = keys.get(team2-1);

			Double value2 = Team.teamNamesMagicNumber.get(obj2);

			if (value1 > value2) {
				System.out.println("The winner would possible be: ");
				System.out.println(obj);
			}else {
				System.out.println("The winner would possible be: ");
				System.out.println(obj2);
			}
		}
	}


	public static String getUserChoice() {

		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();
		return userChoice;
	}

	static String handleUserInput() {

		String answer = getUserChoice();
		String status = "keepGoing";
		
		if (answer.equals("1")) {
			teams();
		} else if (answer.equals("2")) {
			matchup();
		} else if (answer.equals("3")) {
			System.out.println(Arrays.toString(wordsFromFile));
		} else if (answer.equals("0")) {
			menuLoop();
		} else if (answer.equals("e")) {
			System.out.println("Thanks for using oracularing");
			status = "exit";
			System.exit(0);			
		} else {
			System.out.println("invalid");
			handleUserInput();
		}
		return status;
	}

	//Counts the lines in the file
	static int lineCount() throws FileNotFoundException
	{
		Scanner fileInput = new Scanner(f);
		int lines = 0;

		while(fileInput.hasNextLine())
		{
			lines++;
			fileInput.nextLine();
		}
		return lines;
	}

	static void fileRead() throws FileNotFoundException
	{
		Scanner fileInput = new Scanner(f);
		wordsFromFile = new String[lineCount()];
		int count = 0;
		while(fileInput.hasNextLine())
		{
			wordsFromFile[count] = fileInput.nextLine();
			count++;
		}
	}

	public static void menuLoop() {
		int program = 1;
		displayMenu(mainMenu, menuHeader[0]);
		while(program > 0) {			
			String active = handleUserInput();
			if (active.equals("exit")) {
				program --;
			}
		}
	}

    public static void main(String[] args) throws IOException {
		fileRead();
		menuLoop();
    }
}
