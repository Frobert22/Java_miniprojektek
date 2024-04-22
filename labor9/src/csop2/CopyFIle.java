package csop2;

import java.io.*;

public class CopyFIle {
    public static void main(String[] args) {
        String file = "Readme.txt";
        File newFile = new File(".", file);
        File newFile1 = new File("C:\\Users\\midir\\Java_miniprojektek\\labor9" + file);
        File newFile3 = new File("./Readme.txt");
        try {
            if (newFile1.createNewFile()) {
                System.out.println("file created");
            } else {
                System.out.println("file already exists");
            }
        } catch (IOException e) {
            System.out.println("File IO error");
        }

        //--------------------------//
        FileInputStream in = null;
        FileOutputStream out = null;
        File source = newFile;
        File dest = new File("C:\\Users\\midir\\Java_miniprojektek\\labor9", "ReadmeNew.text");
        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(dest);
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in !=null){
                    in.close();
                }
                if(out!=null){
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}