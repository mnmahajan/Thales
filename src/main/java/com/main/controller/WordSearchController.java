package com.main.controller;

import com.main.model.CSVReader;
import com.main.view.WordSearchView;

/** controller class , call CSV loader and count occurances for word in a grid
 * @author ACER
 *
 */
public class WordSearchController {

	private String input;
	
	/**
	 * @param input constructor
	 */
	public WordSearchController(String input) {
		// read the csv file and persist the data
		String filePath = "src/main/resources/wordSearch.csv";
		CSVReader reader = new CSVReader(filePath);
		String[][] grid = reader.getElements();

		//getcount of word
		int numberOfTimewordFound = getOccurance(grid, input,grid[0].length ,grid.length);
		WordSearchView view = WordSearchView.getBean();
		view.setOutput("Number of occurances are "+numberOfTimewordFound);

	}
	public WordSearchController() {
		// TODO Auto-generated constructor stub
	}
	
// *** CLI input option	
//	/**
//	 * @return takes the input from the user from command line
//	 */
//	private static String getUserInput() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Kindly enter word to be searched");
//		String input = sc.next();
//		sc.close();
//		return input;
//	}

	/**
	 * @param grid  grid input from csv file
	 * @param input input text to be searched
	 * @param numberOfRows number of rows
	 * @param numberOfColumn number of columns
	 * @return it returns the number of times the word present in grid
	 */
	private int getOccurance(String[][] grid, String input, int numberOfRows, int numberOfColumn) {
		int occurance = 0;
		
		int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	    int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
		
		for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumn; col++) {
  
            	if (grid[row][col] != null && !grid[row][col].equals(input.substring(0,1)))
                    break;
         
                int len = input.length();
         
                // Search word in all 8 directions
                // starting from (row, col)
                for (int dir = 0; dir < 8; dir++) {
                    // Initialize starting point for current direction
                    int k, rd = row + x[dir], cd = col + y[dir];
         
                    // First character is already checked,match remaining characters
                    for (k = 1; k < len; k++) {
                    	
                        // If out of bound break
                        if (rd >= numberOfRows || rd < 0 || cd >= numberOfColumn || cd < 0)
                            break;
         
                        // If not matched, break
                        if (grid[rd][cd] != null && !grid[rd][cd].equals(input.charAt(k)))
                            break;
         
                        // Moving in particular direction
                        rd += x[dir];
                        cd += y[dir];
                    }
                    if (k == len)
                        occurance++;
                }
                break;
            }
        }
		return occurance/2;
	}
}
