import java.io.FileInputStream;
import java.io.FileOutputStream;
// import java.io.FileReader;
// import java.io.FileWriter;
import java.io.IOException;

public class file_handling {

    public static void main(String[] args) throws IOException {

        // FileWriter fw = new FileWriter("file.txt");
        // fw.write("Hello, I'm Windows!");
        // fw.close();

        // FileReader fr = new FileReader("file.txt");
        // int ch;
        // while ((ch = fr.read()) != -1)
        //     System.out.println((char)ch);
        // fr.close();

        FileOutputStream out = new FileOutputStream("file.txt", true);
        String s = "This is second para";
        byte data[] = s.getBytes();
        out.write(data);
        out.close();

        FileInputStream in = new FileInputStream("file.txt");
        int ch;
        while((ch = in.read()) != -1)
            System.out.print((char)ch);
        in.close();
    }
}