import java.io.*; //import everything from java.io
import java.util.Scanner;

public class FilePractice {
	
	public static String inputString; //creating a string to input string data values in
	public static Scanner input = new Scanner (System.in); //new scanner object

	public static void main(String[] args) throws IOException {
		
		System.out.println("1. Create new file\n2. Add to existing file\n");
		System.out.print("Enter choice: ");
		
		if (input.nextInt() == 1) {
			input.nextLine();
			//call function to create/rewrite a file
			AddNewFile();
		}
		else {
			input.nextLine();
			//call function to append to existing file
			AddExistingFile();
		}
	}
	
	//creating method to rewrite or create a new file
	public static void AddNewFile() throws IOException {
		
		//if user adds to old file, open file with append set to true
		FileOutputStream outputStream = new FileOutputStream("javaWrite.txt");
		boolean continueInput = true; //setting a variable to true
		
		while (continueInput == true) {
	    	
	    	//use to store data type string after input other data type
	    	
	    	//prompting user to enter something
	    	System.out.print("Enter something: ");
			inputString = input.nextLine(); //store input as string
			
			//must use getBytes() command to write string to file
		    byte[] strToBytes = inputString.getBytes();

	    	outputStream.write(strToBytes); //writing user input to file
	    
	    	outputStream.write("\n".getBytes()); //writing a line break to file
	    
	    	System.out.print("Would you like to enter something else? ");
	    	
	    	//if option is yes to continue inputting
	    	if (input.next().charAt(0) == 'y' || input.next().charAt(0) == 'Y') {
	    		continueInput = true; //continue is true
	    		input.nextLine();
	    	}
	    	else {
	    		continueInput = false; //if option is not yes, continue is false
	    		outputStream.close(); //close file to stop input and output
	    	}
	    }
	}
	
	//creating method to append to or create a new file
	public static void AddExistingFile() throws IOException {
		
		//if user adds to old file, open file with append set to true
		FileOutputStream outputStream = new FileOutputStream("javaWrite.txt",true);
		boolean continueInput = true; //setting a variable to true
				
		while (continueInput == true) {
			    	
			//prompting user to enter something
			System.out.print("Enter something: ");
			inputString = input.nextLine(); //store input as string
					
			//must use getBytes() command to write string to file
			byte[] strToBytes = inputString.getBytes();

			outputStream.write(strToBytes); //writing user input to file
			    
			outputStream.write("\n".getBytes()); //writing a line break to file
			    
			System.out.print("Would you like to enter something else? ");
			    	
			//if option is yes to continue inputting
			if (input.next().charAt(0) == 'y' || input.next().charAt(0) == 'Y') {
				continueInput = true; //continue is true
			    input.nextLine();
			    }
			else {
			    continueInput = false; //if option is not yes, continue is false
			    outputStream.close(); //close file to stop input and output
			    }
			}
	}	
}
