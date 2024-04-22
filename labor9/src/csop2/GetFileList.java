package csop2;

import java.io.File;

public class GetFileList {
    public static void printFiles(File[] files){
        for (File f:files){
            System.out.println(f);
        }
    }

    public static void printOnlyFiles(File[] files){
        for (File f : files){
            if (f.isFile()){
                System.out.println(f.toString());
            }
        }
    }

        public static void main(String[] args) {
            File aktualisMappa = new File(".");
            File[] files1 = aktualisMappa.listFiles();
            //printOnlyFiles(files1);

            File szuloMappa = new File("..");
            File[] files2 = szuloMappa.listFiles();
            // printFiles(files2);

            File specMappa = new File("./src/labor9");
            File[] files3 = specMappa.listFiles();
            //printFiles(files3);

            File path=new File("d:\\mappa\\.\\almappa\\.\\alalmappa");
            System.out.println(path.getAbsolutePath());
            //System.out.println(path.getCanonicalPath());

    }
}
