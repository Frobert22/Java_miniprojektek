package nevtelen;

import java.util.ArrayList;

public class Nevtelenkiterjtesztes {

    static class SzemuvegesEmber extends Ember{
        @Override
        public String jellemzo() {
            return "szemuveges";
        }
    }


    public static void main(String[] args) {
        ArrayList<Ember> lista = new ArrayList<>();
        class OkosEmber extends Ember{
            public String jellemzo(){
                return "okos";
            }
        }
        lista.add(new OkosEmber());
        lista.add(new SzemuvegesEmber());
        lista.add(new Ember(){
            public String jellemzo() {
                return "magas";
            }
        });
        for (Ember ember:lista){
            System.out.println(ember.jellemzo());
        }

    }
}
