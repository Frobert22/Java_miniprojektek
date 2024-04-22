import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class C {
    int i,j;
    public C(int i, int j) { this.i = i; this.j=j; /* érték hozzárendelése a hiányzó változóhoz */ }
    public C(int i) { this.i = i; }
}

public class B {
    public static void main(String[] args) {
        List<C> l = new ArrayList<C>();
        l.add(new C(5 , 4));
        l.add(l.get(0));
        l.add(new C(6 , 0));
        l.add(new C(5 , 4));
        l.add(new C(6));
        Set<C> s = new HashSet<C>();
        s.addAll(l);
        System.out.print("L =" + l.size() + " S " + s.size());
    }
}