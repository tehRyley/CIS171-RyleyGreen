package com.mycompany.exercise19.sortarraylist;

/**
 *
 * @author Ryley Ireland Green
 */
public class Exercise199SortArrayList {

    public static void main(String[] args) {
        //Creates and loads some random person objects
        Person p1 = new Person("John", "929 B street", "217 912 1294", "John@mail.com");
        Person p2 = new Person("Richard", "718 A street", "317 911 1183", "Richard@mail.com");
        Person p3 = new Person("Frank", "607 C street", "417 910 1072", "Frank@mail.com");
        Person p4 = new Person("Blake", "345 D street", "517 345 1045", "Blake@mail.com");
        Person p5 = new Person("Bryan", "867 E street", "917 876 5732", "Bryan@mail.com");
        Person p6 = new Person("Haley", "678 F street", "117 234 1235", "Haley@mail.com");
        Person.Load(p1);
        Person.Load(p2);
        Person.Load(p3);
        Person.Load(p4);
        Person.Load(p5);
        Person.Load(p6);

        //Displays names (in order by when loaded into ArrayList<>)
        Person.getNames();

        //Shuffles the people ArrayList<>
        Person.shuffle(Person.people);

        //Displays names (if the same you got lucky, run this file again)
        System.out.println("\n");
        Person.getNames();

        //Sorts then displays names by the first number of each phone number
        Person.sort(Person.people);
        System.out.println("\n");
        Person.getNames();
    }
}
