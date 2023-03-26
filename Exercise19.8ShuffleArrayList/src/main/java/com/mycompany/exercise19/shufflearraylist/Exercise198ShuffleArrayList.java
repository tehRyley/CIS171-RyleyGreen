package com.mycompany.exercise19.shufflearraylist;

/**
 *
 * @author Ryley Ireland Green
 */
public class Exercise198ShuffleArrayList {

    public static void main(String[] args) {
        //Creates and loads some random person objects
        Person p1 = new Person("John", "929 B street", "417 912 1294", "John@mail.com");
        Person p2 = new Person("Richard", "718 A street", "417 911 1183", "Richard@mail.com");
        Person p3 = new Person("Frank", "607 C street", "417 910 1072", "Frank@mail.com");
        Person.Load(p1);
        Person.Load(p2);
        Person.Load(p3);

        //First three names should be John, Richard, Frank in order
        Person.getNames();

        //Shuffles the people ArrayList<>
        Person.shuffle(Person.people);

        //Last three names should be in random order (if the same you got lucky, run this file again)
        System.out.println("\n");
        Person.getNames();
    }
}
