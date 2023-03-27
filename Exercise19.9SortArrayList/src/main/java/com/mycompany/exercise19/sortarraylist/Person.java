package com.mycompany.exercise19.sortarraylist;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ryley Ireland Green
 */
public class Person implements Comparable {

    //Initial variables
    private String name;
    private String address;
    private String phone;
    private String email;
    static ArrayList<Person> people = new ArrayList<>();

    //Create person
    public Person(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Used for testing purposes (lists all names in people ArrayList)
    public static void getNames() {
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).getName());
        }
    }

    //Load person into an ArrayList<>
    public static void Load(Person person) {
        people.add(person);
    }

    //Shuffle an ArrayList<>
    public static <E> void shuffle(ArrayList<E> list) {
        Collections.shuffle(list);
    }

    @Override
    public int compareTo(Object comparesto) {
        String comparephone = ((Person) comparesto).getPhone();
        int firstChar = comparephone.charAt(0);
        int compChar = this.phone.charAt(0);
        return compChar - firstChar;
    }

    //Sort an ArrayList<>
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        Collections.sort(list);
    }

}
