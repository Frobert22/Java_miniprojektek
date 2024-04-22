import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

interface BankSzamla {
    void betesz(double osszeg);
    void kivesz(double osszeg);
}

class Tranzakcio {
    private LocalDateTime idopont;
    private TranzakcioTipus tranzTipus;
    private double osszeg;

    public Tranzakcio(TranzakcioTipus tranzTipus, double osszeg) {
        this.idopont = LocalDateTime.now();
        this.tranzTipus = tranzTipus;
        this.osszeg = osszeg;
    }

    @Override
    public String toString() {
        return idopont.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) +
                " - " + tranzTipus + ": " + osszeg;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Tranzakcio)){
            return false;
        }
        Tranzakcio other = (Tranzakcio) obj;
        return idopont.equals(other.idopont) &&
                tranzTipus == other.tranzTipus &&
                Double.compare(osszeg, other.osszeg) == 0;
    }
}

enum TranzakcioTipus {
    DEPOSIT, WITHDRAW
}

class RegularisSzamla implements BankSzamla {
    double egyenleg;
    private String tulajdonos;
    private String szamlaszam;
    private static int szamlaSzam = 0;
    private List<Tranzakcio> tranzakciok;

    private static String generateSzamlaszam() {
        return "kell-" + (++szamlaSzam);
    }

    public RegularisSzamla(String tulajdonos) {
        this.tulajdonos = tulajdonos;
        this.tranzakciok = new ArrayList<>();
        this.szamlaszam = generateSzamlaszam();
    }


    @Override
    public void betesz(double osszeg) {
        this.egyenleg += osszeg;
        tranzakciok.add(new Tranzakcio(TranzakcioTipus.DEPOSIT, osszeg));
    }

    @Override
    public void kivesz(double osszeg) {
        if (osszeg > egyenleg) {
            System.out.println("nincs eleg penz");
            return;
        }
        this.egyenleg -= osszeg;
        tranzakciok.add(new Tranzakcio(TranzakcioTipus.WITHDRAW, osszeg));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("szamlaszam: ").append(szamlaszam).append("\n");
        sb.append("tulajdonos: ").append(tulajdonos).append("\n");
        sb.append("egyenleg: ").append(egyenleg).append("\n");
        sb.append("tranzakciok:\n");
        for (Tranzakcio tranzakcio : tranzakciok) {
            sb.append(tranzakcio).append("\n");
        }
        return sb.toString();
    }
}

class FolyoSzamla extends RegularisSzamla {
    private static final int ingyen = 0;
    private int tranzakciokSzama;

    public FolyoSzamla(String tulajdonos) {
        super(tulajdonos);
    }

    @Override
    public void betesz(double osszeg) {
        super.betesz(osszeg);
        tranzakciokSzama++;
    }

    @Override
    public void kivesz(double osszeg) {
        super.kivesz(osszeg);
        tranzakciokSzama++;
    }

    public void levonKoltseg(double tranzakcioAra) {
        if (tranzakciokSzama > ingyen) {
            double levonando = tranzakcioAra * (tranzakciokSzama - ingyen);
            super.kivesz(levonando);
            tranzakciokSzama = 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FolyoSzamla)) return false;
        FolyoSzamla pew = (FolyoSzamla) obj;
        return super.equals(obj) && tranzakciokSzama == pew.tranzakciokSzama;
    }
}

class TakarekSzamla extends RegularisSzamla {
    private double kamatRata;

    public TakarekSzamla(String tulajdonos, double kamatRata) {
        super(tulajdonos);
        this.kamatRata = kamatRata;
    }

    public void hozzaadKamat() {
        double kamat = super.egyenleg * (kamatRata / 100);
        super.betesz(kamat);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TakarekSzamla)) return false;
        TakarekSzamla other = (TakarekSzamla) obj;
        return super.equals(obj) && Double.compare(kamatRata, other.kamatRata) == 0;
    }
}

public class Bankos {
    public static void main(String[] args) {
        RegularisSzamla regularisSzamla = new RegularisSzamla("egyes");
        regularisSzamla.betesz(122);

        regularisSzamla.kivesz(1444);
        System.out.println(regularisSzamla);

        FolyoSzamla folyoSzamla = new FolyoSzamla("kettes");
        folyoSzamla.betesz(1555);
        folyoSzamla.kivesz(12);
        folyoSzamla.betesz(222);
        folyoSzamla.betesz(333);
        folyoSzamla.levonKoltseg(7);
        System.out.println(folyoSzamla);

        TakarekSzamla takarekSzamla = new TakarekSzamla("harmas", 5);
        takarekSzamla.betesz(4555);
        takarekSzamla.hozzaadKamat();
        System.out.println(takarekSzamla);
    }
}
