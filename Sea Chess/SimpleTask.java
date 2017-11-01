import java.util.Scanner;


// This task is from here: 
// https://github.com/slbedu/javase8-2016/tree/master/lab01

/* A bug:
 * 
 * says the player X wins :D
X X O 
O 5 X 
7 8 9

*/

import java.lang.String;
public class SimpleTask {
	
	
	public static void print(char table[][]){
		Neighbours m = null;
		for(int i = 0; i < m.numRowsColumns; ++i)
		{
			for(int j = 0; j < m.numRowsColumns; ++j)
				System.out.print(table[i][j] + " ");
			System.out.println();
		}
	}
	
	public static boolean isItInTable(int c)
	{
		return c >= 0 && c <=2 ? true : false;
	}
	
	public static boolean isItWinner(char table[][], int newRow, int newColumn, char mySymbol)
	{
		Neighbours m = null;
		int forCheckRow = 0, secondCheckRow = 0, forCheckColumn = 0, secondCheckColumn = 0;
		for(int i = 0; i < m.numNeighbours; ++i)
		{
			for(int j = 0; j < m.numRowsColumns - 1; ++j)
			{
				forCheckRow = newRow + m.neighbours[i][0];
				forCheckColumn = newColumn + m.neighbours[i][1];
				
				if(!isItInTable(forCheckRow) || !isItInTable(forCheckColumn))
					continue;
				if(table[forCheckRow][forCheckColumn] == mySymbol)
				{
					secondCheckRow = forCheckRow + m.neighbours[i][0];
					secondCheckColumn = forCheckColumn + m.neighbours[i][1];
					if(isItInTable(secondCheckRow) && isItInTable(secondCheckColumn) &&
							table[secondCheckRow][secondCheckColumn] == mySymbol)
						return true;
					secondCheckRow = newRow + (-1)*m.neighbours[i][0];
					secondCheckColumn = newColumn + (-1)*m.neighbours[i][1];
					if(isItInTable(secondCheckRow) && isItInTable(secondCheckColumn) &&
							table[secondCheckRow][secondCheckColumn] == mySymbol)
						return true;
				}
			}
		}
		
		return false;
	}
	public static int findRow(int input)
	{
		if(input >=0 && input <= 3)
			return 0;
		else if(input >= 4 && input <= 6)
			return 1;
		else
			return 2;
	}
	
	
	public static int findColumn(int input)
	{
		if(input == 1 ||input == 4 || input == 7)
			return 0;
		return input == 2 || input == 5 || input == 8 ? 1 : 2;
	}
	
// I need two neighbour cells to one another tow have 	
	public static boolean noWinner(char table[][])
	{
		Neighbours m = null;
		int firstFreeRow = 0, firstFreeColumn = 0, secondFreeRow = 0, secondFreeColumn, forCheckRow = 0, forCheckColumn = 0;
		for(int i = 0; i < m.numRowsColumns; ++i )
		{
			 for(int j = 0; j < m.numRowsColumns; ++j)
			 {
				 if(table[i][j] != 'X' && table[i][j] != 'O')
				 {
					 firstFreeRow = i;
					 firstFreeColumn = j;
					 for(int k = 0; k < m.numNeighbours; ++k)
					 {
						secondFreeRow = firstFreeRow + m.neighbours[k][0];
						secondFreeColumn = firstFreeColumn + m.neighbours[k][1];
						if(isItInTable(secondFreeRow) && isItInTable(secondFreeColumn) && 
								table[secondFreeRow][secondFreeColumn] != 'X' && table[secondFreeRow][secondFreeColumn] != 'O')
						{
							if(areThereOthereFree(table,firstFreeRow, firstFreeColumn, secondFreeRow, secondFreeColumn))
							{
								return false;
							}
							else 
								return true;
						}
					 }
				 }
			 }
		}
		return false;
	}
	
	// I need only two empty neighbour cells
	public static boolean areThereOthereFree(char table[][], int firstRow, int firstColumn, int secondRow, int secondColumn)
	{
		Neighbours m = null;
		for(int i = 0; i < m.numRowsColumns; ++i )
		{
			 for(int j = 0; j < m.numRowsColumns; ++j)
			 {
				 if(i!= firstRow && i != secondRow && j != firstColumn && j != secondColumn 
						 && table[i][j] != 'X' && table[i][j] != 'O')
				 {
					 return true;
				 }
			 }
		}	 
		return false;
	}
	
	public static void main(String[]args)
	{
		char table[][] = { {'1','2','3'}, {'4','5','6'}, 
				{'7','8','9'}};
		print(table);
		char mySymbol = 'X';
		int player = 0, newRow = 0, newColumn = 0, inputCell = 0;
		// Problem with the no winner function
		// !noWinner(table) && 
		while( !isItWinner(table,newRow,newColumn,mySymbol))
		{
			mySymbol = player == 0 ? 'X' : 'O';
			System.out.println
				("Player " + player + " play a move between 1 and 9");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			
			inputCell = Integer.parseInt(input);
			newRow = findRow(inputCell);
			newColumn = findColumn(inputCell);
			if(player == 0)
				table[newRow][newColumn] = 'X';
			else
				table[newRow][newColumn] = 'O';
			player = player == 0 ? 1: 0;
			print(table);
		}
		player = player == 0 ? 1: 0;
		System.out.println("The winner is player: " + player);
	}
}
