package ch.yvesbeutler.generics.exercises;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.*;

/**
 * Created by joris on 08.03.16.
 */
class Main {

    public static void main(String []args){

        String[] array = new String[3];

        array[0] = "Hallo";
        array[1] = "schöne";
        array[2] = "Welt";


        Integer[] intarray = new Integer[3];
        intarray[0] = 1;
        intarray[1] = 2;
        intarray[2] = 3;

        for(String i : array){
            System.out.println(i);
        }

        change(1,2,array);

        for(String i : array){
            System.out.println(i);
        }

        change(1,2,intarray);

        for(int i :intarray){
            System.out.println(i);
        }

        ArrayList<Integer> intlist = new ArrayList<>();
        for (int i =0; i < 10;i++){intlist.add(i);}

        System.out.println("oddnumbers:  "+odd(intlist));



    }

    //Übung 3
    public static <arr> void change(int id1, int id2, arr[] array){

        arr a = array[id1];
        array[id1] = array[id2];
        array[id2] = a;
    }

    //Übung 1
    public static <col extends Collection<Integer>> int odd(col collection){

        int counter = 0;

        for(int i : collection){
            if ((i % 2) == 1){
                counter++;
            }
        }
        return counter;
    }

    //Übung 2


    //Übung 8
    public static <E extends List<E> & Comparable<E>> E findElement(int begin, int end, E list){
        long tempsize = 0;
        int index= 0;
        for(int i = begin; i < end; i++){

            if(ObjectSizeCalculator.getObjectSize(list.get(i)) > tempsize ){
                tempsize = ObjectSizeCalculator.getObjectSize(list.get(i));
                index = i;
            }



        }

        return list.get(index);
    }




}