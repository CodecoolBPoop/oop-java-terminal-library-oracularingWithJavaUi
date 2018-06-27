package com.codecool.soccer;

import com.codecool.termlib.*;

import java.util.Scanner;

public class Soccer {

	static String[] menuHeader = {"Choose from these choices", "Choose a team", "Statistics", "Winner prediction"};
	
	static String[] mainMenu = {"1. Statistics", "2. Who would win?", " ", "0. Go back to Main menu"};

	static String[] testTeams = {"1. Spain", "2. Italy", "3. Portugal", "4. Brasil", "5. Croatia", "7. Uruguay", "8. Iceland", " ", "0. Go back to Main menu"};

	static String[] testSpainStatistics = {"Goals: 5", "Received goals: 4", "Ball posession: 57%", "Fifa Ranking: 6", " ", "0. Go back to Main menu"};

	static String[] testItalyStatistics = {"Goals: 3", "Received goals: 3", "Ball posession: 52%", "Fifa Ranking: 11", " ", "0. Go back to Main menu"};



	public static void displayMenu(String[] menu, String header) {
		
		com.codecool.termlib.Terminal term = new com.codecool.termlib.Terminal();
		term.resetStyle();
		System.out.println();
		System.out.println(header);
		System.out.println("-------------------------");

		
		for (int i=0; i<menu.length; i++) {
			System.out.println(menu[i]);
		}

		System.out.println();
		System.out.println("E. Exit program");
    
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
			displayMenu(testTeams, menuHeader[1]);

//			if (answer.equals("1")) {
//				displayMenu(testSpainStatistics, menuHeader[2]);
//			} else if (answer.equals("2")) {
//				displayMenu(testItalyStatistics, menuHeader[2]);
//			}

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
				System.out.println("df");
				program --;
			}
		}

	}
	

    public static void main(String[] args) {
//      com.codecool.termlib.Terminal term = new com.codecool.termlib.Terminal();
		menuLoop();
		
    }

}
