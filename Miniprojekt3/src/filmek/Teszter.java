package filmek;



import java.util.ArrayList;
import java.util.List;

public class Teszter {
    public static void main(String[] args) {
        List<Film> filmek = new ArrayList<>();

        filmek.add(new Film("egy", 4500));
        filmek.add(new Film("ketto", 7800));
        filmek.add(new Film("harom", 6500));
        filmek.add(new HorrorFilm("negy", 4000, 18));
        filmek.add(new HorrorFilm("ot", 3900, 19));
        filmek.add(new HorrorFilm("hat", 2190, 18));

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