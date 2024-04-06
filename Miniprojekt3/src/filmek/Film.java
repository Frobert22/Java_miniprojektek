package filmek;


interface IKorhataros {
    int Korhatar();

    int Buntetes(int kor);
}

public class Film {
    private String cim;
    private int ar;
    private int[] velemenyek;

    public Film(String cim, int ar) {
        this.cim = cim;
        this.ar = ar;
        this.velemenyek = new int[20];
    }

    public String getCim() {
        return cim;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public void Velemenyezes(int velemeny) {
        if (velemeny >= 1 && velemeny <= 5) {
            for (int i = 0; i < velemenyek.length; i++) {
                if (velemenyek[i] == 0) {
                    velemenyek[i] = velemeny;
                    break;
                }
            }
        }
    }

    public double Atlag() {
        int osszeg = 0;
        int szamol = 0;
        for (int velemeny : velemenyek) {
            if (velemeny != 0) {
                osszeg += velemeny;
                szamol++;
            }
        }
        if (szamol == 0) {
            System.out.println("A film még nem kapott véleményt.");
            return 0;
        }
        return (double) osszeg / szamol;
    }

    @Override
    public String toString() {
        return "Film cime: " + cim + ", Film ara: " + ar;
    }
}

class HorrorFilm extends Film implements IKorhataros {
    private int korhat;

    public HorrorFilm(String cim, int ar, int korh) {
        super(cim, ar);
        this.korhat = korh;
    }

    @Override
    public int Korhatar() {
        return korhat;
    }

    @Override
    public int Buntetes(int kor) {
        int kulon = kor - korhat;
        if (kulon < 0) {
            return Math.abs(kulon) * getAr();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Korhatar: " + korhat;
    }
}

