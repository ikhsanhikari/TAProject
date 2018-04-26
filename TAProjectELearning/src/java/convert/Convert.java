/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

/**
 *
 * @author Sou
 */
public class Convert {
    public static Integer toInteger(Object obj){
        return Integer.parseInt(obj.toString());
    }
    public static String toString(Object obj){
        return obj.toString();
    }
    
    
    public static String convertSpas(String arg) {
        String tamp = "";
        for (int i = 0; i < arg.length(); i++) {
            if (arg.charAt(i) == '$') {
                tamp = tamp + "\n";
            } else if (arg.charAt(i) == '@') {
                tamp = tamp + "\t";
            } else {
                tamp = tamp + arg.charAt(i) ;
            }

        }
        return tamp;
    }
    public static void main(String[] args) {
        System.out.println(convertSpas("hsaghda@rw$rw"));   
    }
}
