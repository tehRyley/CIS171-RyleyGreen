package com.mycompany.primenumbers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ryley Ireland Green
 */
public class App {

    public static void main(String[] args) throws IOException {
        initialPrimes();
    }
    
    //Checks if number is prime
    public static int checkPrime(int n) {
        if (n <= 1) {
            return 0;
        }
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
       return n;
    }
    
    //Creates file with initial 10000 prime numbers for comparisons
    public static Path initialPrimes() throws IOException {
        Path path = Paths.get("PrimeNumbers.dat");
        Files.deleteIfExists(path);
        File file = new File("PrimeNumbers.dat");
        FileWriter fw = new FileWriter (file, true);
        int primes = 0;
        int count = 2;
        while (primes != 10000) {
            if (checkPrime(count) == 0) {
                count++;
            } else {
                fw.append(String.valueOf(checkPrime(count))); 
                fw.append('\n');
                count++;
                primes++;
            }
        }
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          System.out.println(data);
        }
          return path;
    }
    
    //Build primes using comparisons in intervals of 10000
    public static void buildPrimes() throws IOException {
        List<String> list = Files.readAllLines(initialPrimes());
        long[] tenPrimes = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
           tenPrimes[i] = Long.parseLong(list.get(i)); 
        }
        for (Long x : tenPrimes) {
            System.out.print(x + "\n");
            
        }
    }
}
