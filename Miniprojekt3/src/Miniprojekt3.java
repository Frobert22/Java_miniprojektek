import java.util.ArrayList;

import java.util.List;

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
        this.velemenyek = new int[20]; // Maximum 20 vélemény tárolása
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

    public class Teszter {
        public static void main(String[] args) {
            List<Film> filmek = new ArrayList<>();

            filmek.add(new Film("Matrix", 1500));
            filmek.add(new Film("Inception", 1800));
            filmek.add(new Film("Pulp Fiction", 1200));
            filmek.add(new HorrorFilm("The Shining", 2000, 18));
            filmek.add(new HorrorFilm("Psycho", 1900, 16));
            filmek.add(new HorrorFilm("The Exorcist", 2100, 18));

            System.out.println("Eredeti lista:");
            for (Film film : filmek) {
                System.out.println(film);
            }

            for (int i = 0; i < filmek.size() - 1; i++) {
                for (int j = i + 1; j < filmek.size(); j++) {
                    if (filmek.get(i).getAr() > filmek.get(j).getAr()) {
                        Film pelda = filmek.get(i);
                        filmek.set(i, filmek.get(j));
                        filmek.set(j, pelda);
                    }
                }
            }

            System.out.println("\nRendezett lista:");
            for (Film film : filmek) {
                System.out.println(film);
            }

            List<IKorhataros> korhatarosFilmek = new ArrayList<>();
            for (Film film : filmek) {
                if (film instanceof HorrorFilm) {
                    korhatarosFilmek.add((HorrorFilm) film);
                }
            }

            System.out.println("\nKorhataros filmek:");
            for (IKorhataros film : korhatarosFilmek) {
                System.out.println(film);
            }

            int kor = 18;
            int osszBuntetes = 0;
            for (IKorhataros film : korhatarosFilmek) {
                osszBuntetes += film.Buntetes(kor);
            }
            System.out.println("\nÖsszes büntetés " + kor + " éves kor alapján: " + osszBuntetes);
        }
    }
