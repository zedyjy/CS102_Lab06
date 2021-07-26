package CS102.Lab06;

import java.io.File;

public class Lab06 {

    public static int countLength(String s){
        if (s.equals("")){
            return 0;
        }
        else{
            return countLength(s.substring(1)) + 1;
        }
    }

    public static int numOfVowels(String s, int num){
        if (num == 1) {
            return isNonVowel(s.charAt(num - 1));
        }
        return (numOfVowels(s, num - 1) + isNonVowel(s.charAt(num - 1)));
    }

    public static int isNonVowel(char ch){
        ch = Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return 1;
        }
        else if(ch == ' '){
            return 1;
        }
        else if (Character.isDigit(ch)){
            return 1;
        }
        return 0;
    }

    public static void generateBinary(int k, char [] ch, int n){
        String s ="";

        if (n == k) {
            for(char i : ch){
                s += "" + i;
            }
            System.out.print(s + " ");
            return;
        }

        if (ch[n - 1] == '0') {
            ch[n] = '0';
            generateBinary(k, ch, n + 1);
            ch[n] = '1';
            generateBinary(k, ch, n + 1);
        }

        if (ch[n - 1] == '1') {
            ch[n] = '0';
            generateBinary(k, ch, n + 1);
        }
    }

    public static void initialize(int num){
        char [] ch = new char[num];

        ch[0] = '0';
        generateBinary(num, ch, 1);

        ch[0] = '1';
        generateBinary(num, ch, 1);
    }

    public static long getSize(File file){
        long length = 0;
        if (!file.isDirectory()){
            length = file.length();
        }
        else{
            for (File a : file.listFiles()){
                length += getSize(a);
            }
        }
        return length;
    }

    public static void main (String [] args){
    String s = "CS102 is a good course";
    System.out.println(countLength("CS102 is the best"));

    System.out.println(countLength(s)-(numOfVowels(s,countLength(s))));

    initialize(3);
    File file = new File("C:\\Users\\zeyne\\Dropbox\\My PC (LAPTOP-UIF680BP)\\Desktop\\cs102_ders");
    System.out.println("\n" + getSize(file));
    }
}
