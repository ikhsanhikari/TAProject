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
}
