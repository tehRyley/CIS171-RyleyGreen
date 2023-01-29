package com.mycompany.enablegeometricobjectcomparable;

/**
 *
 * @author Ryley
 */
public class EnableGeometricObjectComparable {
    public static void main(String[] args) {
        /* 
        Testing Area 
        1 = Larger than selected object
        0 = Objects are equal in size
        -1 = Smaller than selected object 
        */
        /*Create Objects*/
        Circle circle1 = new Circle(15);
        Circle circle2 = new Circle(10);
        Rectangle rectangle1 = new Rectangle(3.0, 6.0);
        Rectangle rectangle2 = new Rectangle(3.0, 6.0);
        /*Compare Objects*/
        System.out.println(circle1.compareTo(circle2));
        System.out.println(rectangle1.compareTo(rectangle2));
    }
}
