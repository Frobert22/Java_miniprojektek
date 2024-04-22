package modified_package_name;

import java.io.File;

public class Jellemzok {
    public static void main(String[] args) {
        System.out.println( File.separator);
        System.out.println(File.pathSeparator);

        File path1 = new File("d:\\mappa\\almappa");
        System.out.println(path1.getAbsolutePath());
        File path2 = new File(".");// aktualis mappa
        File path3 = new File(".."); //szulo mappa
        File path4 = new File("./mappa/almappa"); //szulo mappa
        System.out.println(path4.getAbsolutePath());
        path2 = path2.getParentFile();
        while (path2 != null){
            System.out.println(path2.getPath() + "[" + path2.getName() + "]");
            path2 = path2.getParentFile();
        }
    }
}
