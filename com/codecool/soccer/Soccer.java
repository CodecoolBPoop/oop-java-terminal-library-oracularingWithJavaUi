package com.codecool.soccer;

import com.codecool.termlib.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import com.codecool.soccer.*;

import static com.codecool.soccer.Team.Teams;


public class Soccer {

	static String[] menuHeader = {"Choose from these choices", "Choose a team", "Statistics", "Winner prediction"};
	
	static String[] mainMenu = {"1. Statistics", "2. Who would win?"};

	static String[] testTeams = {"1. Spainsss", "2. Italy", "3. Portugal", "4. Brasil", "5. Croatia", "7. Uruguay", "8. Iceland", " ", "0. Go back to Main menu"};

	static String[] testSpainStatistics = {"Goals: 5", "Received goals: 4", "Ball posession: 57%", "Fifa Ranking: 6", " ", "0. Go back to Main menu"};

	static String[] testItalyStatistics = {"Goals: 3", "Received goals: 3", "Ball posession: 52%", "Fifa Ranking: 11", " ", "0. Go back to Main menu"};


	public static Map<String, ArrayList<String>> statList = new HashMap<String, ArrayList<String>> () {
//	public static Map<String, String> statList = new HashMap<String, String> () {

		{
			//put("1", "goals:5");
			//put("2", "goals:15");
			put("1", new ArrayList<String>(){{ add("goals2"); add("recieved3"); }});
		}
	};

	public static void displayMenu(String[] menu, String header) {
		
		com.codecool.termlib.Terminal term = new com.codecool.termlib.Terminal();
		term.resetStyle();
		System.out.println("\033[0;31mWorldcup Oracle v1.0\033[0;37m \n");
		System.out.println(header);
		System.out.println("-------------------------");

		
		for (int i=0; i<menu.length; i++) {
			System.out.println(menu[i]);
		}

		System.out.println();
		System.out.println("E. Exit program");
    
	}


	public static void displayMenu2(ArrayList menu, String header) {

		com.codecool.termlib.Terminal term = new com.codecool.termlib.Terminal();
		term.resetStyle();
		System.out.println("\033[0;31mWorldcup Oracle v1.0\033[0;37m \n");
		System.out.println(header);
		System.out.println("-------------------------");


		for (int i=0; i<menu.size(); i++) {
			System.out.println(menu.get(i));
		}

		System.out.println();
		System.out.println("E. Exit program");

	}

	public static void teams() {
		displayMenu(testTeams, menuHeader[1]);
		System.out.println("df");
		String answer = getUserChoice();
		displayMenu2(statList.get(answer), menuHeader[2]);

//		String number = "1";
//		if (answer.equals(number)) {
//			//System.out.println("dffff");
//			displayMenu(dict]number, menuHeader[2]);
//		} else if (answer.equals("0")) {
//		menuLoop();}
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
			System.out.println("it is 2");
		} else if (answer.equals("3")) {
			System.out.println("it is 3");
		} else if (answer.equals("0")) {
			menuLoop();
		} else if (answer.equals("e")) {
			System.out.println("vdvbdfg");
			status = "exit";
			System.exit(0);			
		} else {
			System.out.println("invalid");
			handleUserInput();
		}
		
		return status;
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
	

    public static void main(String[] args) {
//      com.codecool.termlib.Terminal term = new com.codecool.termlib.Terminal();
      	com.codecool.soccer.Team team = new com.codecool.soccer.Team();
      	team.processData(Teams);
		System.out.println("test");
		//menuLoop();
		
    }

}
