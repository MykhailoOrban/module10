package homeWork10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class PhoneNumberReader {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("phoneNumber.txt");
        BufferedReader readerLine = new BufferedReader(reader);
        Pattern pattern = Pattern.compile("^(\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})$");
        String line;
        while ((line = readerLine.readLine()) != null)
            if(line.matches(pattern.pattern())){
            System.out.println(line);
        }
    }
}
