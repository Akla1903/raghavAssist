import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class pdf2nd {

	static String createTextStream(String text,int fontSize,int x,int y){
		return "	BT /F1 " + fontSize + " Tf " + x + " " + y + " Td 0 Tr 0.5 g +(" + text + ") Tj ET "; 
		}

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.pdf")) {

            String header = "%PDF-1.4\n";

            String obj1 = "1 0 obj\n" +
                   			"<< /Type /Catalog /Pages 2 0 R >>\n" +
               				"endobj\n";

            String obj2 = "2 0 obj\n" +
                    			"<< /Type /Pages /Kids [3 0 R] /Count 1 >>\n" +
                    			"endobj\n";

            String obj3 = "3 0 obj\n" +
                   			"<< /Type /Page /Parent 2 0 R /MediaBox [0 0 612 792] /Contents 4 0 R " +
                 			"/Resources << /Font << /F1 5 0 R >> >> >>\n" +
			                "endobj\n";

           //String streamData = "BT /F1 24 Tf 595 600 Td (H) Tj ET";

	 String streamData = createTextStream("Welcome Dipesh" ,12,100,700);

         String obj4 = "4 0 obj\n" +
                    "<< /Length " + streamData.length() + " >>\n" +
                    "stream\n" +
                    streamData + "\n" +
                    "endstream\n" +
                    "endobj\n";

         String obj5 = "5 0 obj\n" +
                    "<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica >>\n" +
                    "endobj\n";

            int xrefStart = header.length() + obj1.length() + obj2.length() +
                    obj3.length() + obj4.length() + obj5.length();

            String xref = "xref\n" +
                    "0 6\n" +
                    "0000000000 65535 f \n" +
                    "0000000010 00000 n \n" +
                    "0000000079 00000 n \n" +
            
        "0000000155 00000 n \n" +
                    "0000000280 00000 n \n" +
                    "0000000383 00000 n \n";

            String trailer = "trailer\n" +
                    "<< /Size 6 /Root 1 0 R >>\n" +
                    "startxref\n" +
                    xrefStart + "\n" +
                    "%%EOF";

	String body = header + obj1 + obj2 +  obj3 + obj4 + obj5 + xref + trailer;
	
	   fos.write(body.getBytes(StandardCharsets.US_ASCII));
           
            System.out.println("PDF created as output.pdf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
