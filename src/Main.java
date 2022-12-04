import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;


public class Main
{

    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String record = "";
        int word_count = 0;
        int line_count = 0;

        try
        {

            File workingDirectory = new File(System.getProperty("user.dir"));


            chooser.setCurrentDirectory(workingDirectory);


            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                String[] fields;

                while (reader.ready())
                {
                    record = reader.readLine();
                    line_count++;
                    fields = record.split(" ");
                    word_count += fields.length;
                    System.out.printf("\nLine %2d %-20s ", line_count, record);

                }
                reader.close();
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("File: "+ selectedFile+ " read!");
                System.out.println("File name: " + selectedFile.getName()) ;
                System.out.println("The file " + selectedFile.length() + " characters in it.");
                System.out.println("The file has " + line_count  + " lines in it.");
                System.out.println("The file has " + word_count + " words in it.");




            }
            else
            {
                System.out.println("You didn't select a file!!! ... exiting.\nRun the program again and select a file.");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
