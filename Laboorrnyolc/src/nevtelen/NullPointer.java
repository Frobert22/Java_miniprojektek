package nevtelen;

import java.sql.SQLOutput;

public class NullPointer {
    public static void nullTermesztes(){
        String str=null;
        int a;
        a=1/0;


        System.out.println(str.toLowerCase());

    }
    public static void nullMesterseges(){
        throw new NullPointerException("ezt en dobtam be!");
    }
    public static void main(String[] args) {
        try { nullTermesztes();
            //nullMesterseges();//
        }catch (ArithmeticException e){
            System.out.println("0val valo osztas");
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally{
            System.out.println("ez mindig lefut");

        }

    }
}
