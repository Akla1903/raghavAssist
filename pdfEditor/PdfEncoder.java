import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PdfEncoder{
	public static void main(String... args) throws IOException{
		File file = new File("ADCA certificate_STP414520639847.pdf");
		try(FileInputStream fis = new FileInputStream(file)){
		byte[] buffer = new byte[(int) file.length()];
		fis.read(buffer);
		
		String content = new String(buffer, StandardCharsets.US_ASCII);

		// ===================version check===========================\\

		int indexOfversion = content.indexOf("%PDF-");

		if(indexOfversion != -1 && indexOfversion + 8 <= content.length()){
			String version = content.substring(indexOfversion + 5 , indexOfversion +8 );
			System.out.println("PDF Version: " + version);
		}else{
			System.out.println("PDF header not found or too short.");
		}

		// ==========================================================\\		
		
		int indexOffilter = content.indexOf("/Filter");

		if(indexOfversion != -1 && indexOfversion + 8 <= content.length()){
			String version = content.substring(indexOfversion + 5 , indexOfversion +8 );
			System.out.println("PDF Version: " + version);
		}else{
			System.out.println("PDF header not found or too short.");
		}
	
		} catch (IOException e){
			e.printStackTrace();
		}



		//FileOutputStream fos = new FileOutputStream("out.pdf");
		   //fos.write(buffer);
	}
}