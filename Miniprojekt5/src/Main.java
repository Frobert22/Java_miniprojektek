import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class Jegy {
    private final String tantargy;
    private final int jegy;


    public Jegy(String tantargy, int jegy) {
        this.tantargy = tantargy;
        this.jegy = jegy;
    }

    public String getTantargy() {
        return tantargy;
    }

    @Override
    public String toString() {
        return "Jegy{" +
                "tantargy='" + tantargy + '\'' +
                ", jegy=" + jegy +
                '}';
    }

    public int getJegy() {
        return jegy;
    }
}


class Hallgato {
    private final int ID;
    private final String vezeteknev;
    private final String keresztnev;
    private final ArrayList<Jegy> jegyek;

    private static int nextID = 1;


    public Hallgato(String vezeteknev, String keresztnev) {
        this.ID = nextID++;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.jegyek = new ArrayList<>();
    }


    public int getID() {
        return ID;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void ujBejegyzes(Jegy jegy) {
        jegyek.add(jegy);
    }

    public void ujJegy(Jegy jegy) {
        jegyek.add(jegy);
    }
    public double tantargyAtlag(String tantargy) {
        double sum = 0;
        int count = 0;
        for (Jegy j : jegyek) {
            if (j.getTantargy().equals(tantargy)) {
                sum += j.getJegy();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }


    public ArrayList<String> getTantargyak() {
        ArrayList<String> tantargyak = new ArrayList<>();
        for (Jegy j : jegyek) {
            if (!tantargyak.contains(j.getTantargy())) {
                tantargyak.add(j.getTantargy());
            }
        }
        return tantargyak;
    }


    public void listazas() {
        System.out.println(getVezeteknev() + " " + getKeresztnev());
        for (String tantargy : getTantargyak()) {
            System.out.println(tantargy + ": " + tantargyAtlag(tantargy));
        }
    }
}


class Naplo {
    private final ArrayList<Hallgato> hallgatok;


    public Naplo(String file) {
        this.hallgatok = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] adatok = line.split(",");
                if (adatok.length >= 2) {
                    Hallgato hallgato = new Hallgato(adatok[0], adatok[1]);
                    hallgatok.add(hallgato);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ujJegy(int ID, Jegy jegy) {
        for (Hallgato hallgato : hallgatok) {
            if (hallgato.getID() == ID) {
                hallgato.ujJegy(jegy);
                return;
            }
        }
    }

    public void listazHallgatoiAdatok() {
        for (Hallgato hallgato : hallgatok) {
            hallgato.listazas();
        }
    }

    public void listazNevek() {
        for (Hallgato hallgato : hallgatok) {
            System.out.println(hallgato.getID() + ". " + hallgato.getVezeteknev() + " " + hallgato.getKeresztnev());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Naplo naplo = new Naplo("C:\\Users\\midir\\OneDrive\\Asztali gép\\hazifeladaatok\\jegyek.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\midir\\OneDrive\\Asztali gép\\hazifeladaatok\\jegyek.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] adatok = line.split(",");
                if (adatok.length >= 3) {
                    int ID = Integer.parseInt(adatok[0]);
                    String tantargy = adatok[1];
                    int jegy = Integer.parseInt(adatok[2]);
                    Jegy ujJegy = new Jegy(tantargy, jegy);
                    naplo.ujJegy(ID, ujJegy);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        naplo.listazHallgatoiAdatok();
    }
}
