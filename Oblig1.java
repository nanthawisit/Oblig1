/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oblig1;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Natcha
 */
public class Oblig1 {

    ////////////////////////////////OPPGAVE 1 /////////////////////////////////////////////
    
    /**
     * ANTALL SAMMENLIGNINGER
     * 
     * En sammenligning for å avgjøre om tabellen har innhold (1)
     * I før-løkken utføres n ganger sammenligning (n)
     * if(m<a[i]) utføres n-1 ganger sammenligninger (n-1)
     * Sum: 1+n+(n-1) = 1+2n-1 = 2n
     * 
     */
    
    /**
     * ANTALL OMBYTTING
     * 
     * - Flest ombytting når tabellen er sortert synkende for
     * da ligger den minste tallet bakerst og dermed
     * må den minste tallet byttet plass hver gang if(m<a[i]) er sann, dvs. n-1.
     * 
     * - Færrest ombytting når tabellen er sortert stigende for da ligger
     * den minste tallet allerede på første plass, dvs. ingen ombytting
     * 
     * - Gjennomsnittet med tallene 1,2 og 3 får vi 6 permutasjoner. Gjennomsnittet blir 7/6
     * 
     */
    
    
    public static int min(int[] a){
        
        if(a.length < 1){
            throw new java.util.NoSuchElementException("Tabllen er tom og dermed ingen minste verdi");
        }
        
        int n = a.length-1;
        int m = a[n];
        
        for(int i = n-1; i >= 0; i--){

            if(m < a[i]){
                a[n] = a[i];
                a[i] = m;
                n = i;
                m = a[n];
            }else {
              n = i;
              m = a[n];
            }
 
        }

        return a[0];
    }
    
    public static int ombyttinger(int[] a){
        
        if(a.length < 1){
            throw new java.util.NoSuchElementException("Tabllen er tom og dermed ingen minste verdi");
        }
        
        int n = a.length-1;
        int m = a[n];
        int antallOmbytting = 0;
        
        for(int i = n-1; i >= 0; i--){
            if(m < a[i]){
                a[n] = a[i];
                a[i] = m;
                n = i;
                m = a[n];
                antallOmbytting++;
            }else {
              n = i;
              m = a[n];
            }
            
        }
        //System.out.println(Arrays.toString(a));
        return antallOmbytting;
        
    }
    
    
    
    //////////////////////////////// OPPGAVE 7 /////////////////////////////////////////////
    
    public static String flett(String s, String t){
        
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0, k = 0;

        while(i < s.length() && j < t.length()){
            
            result.insert(k++, s.charAt(i++));
            result.insert(k++, t.charAt(j++));

        }
        
        while(i < s.length()) result.insert(k++, s.charAt(i++));
        while(j < t.length()) result.insert(k++, t.charAt(j++));

        return result.toString();
        
    }
    
    public static String flett(String... s){
     
       StringBuilder sb = new StringBuilder();
       int antall = 0;

       for(String a : s){
            if(a.length() > antall){
               antall = a.length();
            }
       }

       for(int i = 0; i < antall; i++){
           for(String a : s){ 
               if(i < a.length()){
                   sb.append(a.charAt(i));
               }    
           }
       }

        return sb.toString();
    }

    
    //////////////////////////////// OPPGAVE 9 /////////////////////////////////////////////
    
    public static int[] sum(int[] a, int x){
        
        HashSet<Integer> set = new HashSet<Integer>();
        int[] tallpar = new int[2];

        for(int num : a){
            if(set.contains(x - num)){
                tallpar[0] = num;
                tallpar[1] = (x-num);
                break;
            }
            set.add(num);
        }

        if(tallpar[0] == 0 && tallpar[1] == 0){
          throw new java.util.NoSuchElementException("Finnes ingen av to tallene i tabellen der summen er lik " + x);
        }
        
        return tallpar;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       /* int[] a = {1,2,3};
        int[] b = {1,3,2};
        int[] c = {2,1,3};
        int[] d = {2,3,1};
        int[] e = {3,1,2};
        int[] f = {3,2,1};
        
        System.out.println(ombytting(a));
        System.out.println(ombytting(b));
        System.out.println(ombytting(c));
        System.out.println(ombytting(d));
        System.out.println(ombytting(e));
        System.out.println(ombytting(f));*/
        
        /*String a = flett("ABC","DEFGH");
        String b = flett("IJKLMN","OPQ");
        String c = flett("","AB");
        System.out.println(a + " " + b + " " + c);*/
        
        //String a = flett("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU");
        //flett(a);
        //System.out.println(flett(a));
        
        int[] d = {1,2,2,2,3,3};

        
        
        
    }
    
    
    
}
