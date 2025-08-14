import java.util.Scanner;

public class Editor{
	public static void main(String... args){
		pdf2nd pen = new pdf2nd();	
		 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter text you want to see on pdf: " );
		String text = input.nextLine();
		System.out.println("Enter font size of the text: " );
		int fontSize = input.nextInt();
		System.out.println("Enter position from left (0 to 590): " );
		int x = input.nextInt();
		System.out.println("Enter position from bottom of page (0 to 785): " );
		int y = input.nextInt();
		pen.createTextStream(text,fontSize,x,y);
	}
}