import java.util.Scanner;
import java.io.*;

public class WordPuzzle{
    //matrix[][] contains the input matrix
    //whenever a word is found in matrix[][],
    //copy the word to output[][] 
    public static char matrix[][], output[][];

    
    // Direction check methods
    public static boolean up(String word, int index, int col, int row) {
    	if(index >= word.length()) // Finish recursion when string length is reached
    		return true;
    	if(row < 0)
    		return false;
    	if(matrix[row][col] == word.charAt(index)) { // Check if matrix matches word
    		if(up(word, index + 1, col, row - 1)) { // Check if next element matches
    			output[row][col] = matrix[row][col];
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean down(String word, int index, int col, int row) {
    	if(index >= word.length()) // Finish recursion when string length is reached
    		return true;
    	if(row >= matrix.length)
    		return false;
    	if(matrix[row][col] == word.charAt(index)) { // Check if matrix matches word
    		if(down(word, index + 1, col, row + 1)) { // Check if next element matches
    			output[row][col] = matrix[row][col];
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean left(String word, int index, int col, int row) {
    	if(index >= word.length()) // Finish recursion when string length is reached
    		return true;
    	if(col < 0)
    		return false;
    	if(matrix[row][col] == word.charAt(index)) { // Check if matrix matches word
    		if(left(word, index + 1, col - 1, row)) { // Check if next element matches
    			output[row][col] = matrix[row][col];
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean right(String word, int index, int col, int row) {
    	if(index >= word.length()) // Finish recursion when string length is reached
    		return true;
    	if(col >= matrix.length)
    		return false;
    	if(matrix[row][col] == word.charAt(index)) { // Check if matrix matches word
    		if(right(word, index + 1, col + 1, row)) { // Check if next element matches
    			output[row][col] = matrix[row][col];
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean upleft(String word, int index, int col, int row) {
    	if(index >= word.length()) // Finish recursion when string length is reached
    		return true;
    	if(row < 0 || col < 0)
    		return false;
    	if(matrix[row][col] == word.charAt(index)) { // Check if matrix matches word
    		if(upleft(word, index + 1, col - 1, row - 1)) { // Check if next element matches
    			output[row][col] = matrix[row][col];
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean upright(String word, int index, int col, int row) {
    	if(index >= word.length()) // Finish recursion when string length is reached
    		return true;
    	if(row < 0 || col >= matrix.length)
    		return false;
    	if(matrix[row][col] == word.charAt(index)) { // Check if matrix matches word
    		if(upright(word, index + 1, col + 1, row - 1)) { // Check if next element matches
    			output[row][col] = matrix[row][col];
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean downleft(String word, int index, int col, int row) {
    	if(index >= word.length()) // Finish recursion when string length is reached
    		return true;
    	if(row >= matrix.length || col < 0)
    		return false;
    	if(matrix[row][col] == word.charAt(index)) { // Check if matrix matches word
    		if(downleft(word, index + 1, col - 1, row + 1)) { // Check if next element matches
    			output[row][col] = matrix[row][col];
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean downright(String word, int index, int col, int row) {
    	if(index >= word.length()) // Finish recursion when string length is reached
    		return true;
    	if(row >= matrix.length || col >= matrix.length)
    		return false;
    	if(matrix[row][col] == word.charAt(index)) { // Check if matrix matches word
    		if(downright(word, index + 1, col + 1, row + 1)) { // Check if next element matches
    			output[row][col] = matrix[row][col];
    			return true;
    		}
    	}
    	return false;
    }

    
    
    //search the word in all 8 directions from each position!
    public static void findWord(String word) {
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix.length; j++) {
        		up(word, 0, j, i);
        		down(word, 0, j, i);
        		left(word, 0, j, i);
        		right(word, 0, j, i);
        		upleft(word, 0, j, i);
        		upright(word, 0, j, i);
        		downleft(word, 0, j, i);
        		downright(word, 0, j, i);
        	}
        }
    }
    
    public static void main(String[] args) throws IOException {
        //let us use command line argument for input filename.
        File inputFile = new File("text.txt");  // Change argument to args[0] for submission
        Scanner finput = new Scanner(inputFile);

        int matrixSize = finput.nextInt();
        matrix = new char [matrixSize][matrixSize];
        output = new char [matrixSize][matrixSize]; 
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = finput.next().charAt(0);
                System.out.print(matrix[i][j] + " ");
                output[i][j] = ' ';
            }
            System.out.println();
        }

        //read the words and find them in matrix!
        int numWords = finput.nextInt();
        for (int i = 0; i < numWords; i++) {
            String word = finput.next();
            System.out.println(word);
            findWord(word);
        }

        //output the words in matrix format
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++)
                System.out.print(output[i][j] + " ");
            System.out.println();
        }
    }
}