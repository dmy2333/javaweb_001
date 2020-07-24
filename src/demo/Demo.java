package demo;

import org.junit.Test;

public class Demo {
    public static void main(String[] args) {
        String id = "411425199902158745";
        id = id.substring(6, 14);
        StringBuilder s2 = new StringBuilder();
        s2.append(id).insert(4, "-");
        s2.insert(7, "-");

        System.out.println(s2);
    }

    @Test
    public void aVoid() {
        String[] a = {"411425199712258974", "411425199812258974", "411425199912258974", "411425199612258974"};
        for (String b : a) {
            System.out.println(b);
        }
        String b = null;
        for (int i = 0; i < a.length; i++) {
            b = a[i];
//            System.out.println(b);
            String c = b.substring(6, 14);
            StringBuilder str = new StringBuilder(c);
            str.insert(4, "-");
            str.insert(7, "-");
            System.out.println(str);
        }
    }
    @Test
    public void aVoid2(){
        String a ="411425199611258765";
        String d = a.substring(6, 14);
        char [] b=d.toCharArray();
        for (int i=0;i<b.length;i++) {
            System.out.print(b[i]);
            if (i==3||i==5){
                System.out.print("-");
            }
        }

    }
    //哈哈
}
