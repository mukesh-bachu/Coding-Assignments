package com.company;
import java.io.*;
import java.util.*;

public class Hashing {
    public static int tableSize = 31;
    public static int numCollisions = 0;
    public static int getHashCode (String value, int tableSize)
    {
        int hc = 0;
        //traverse the string and add the ascii value and mod by tableSize
        for (int i = 0; i < value.length (); ++i)
        {
            hc += value.charAt (i);
        }
        return hc % tableSize;
    }
    //rehashing
    public static String[] rehashing(String[] ht){
        numCollisions = 0;
        String[]newHt = new String[tableSize * 2];
        for (int i = 0; i < tableSize * 2; ++i)
            newHt[i] = null;
        for (int i = 0; i < tableSize; ++i)
            if (ht[i] != null){
                int hash = getHashCode (ht[i], 2*tableSize);
                if (newHt[hash] != null)
                {
                    numCollisions++;
                    for (int j = 0; j < 2*tableSize; j++)
                    {
                        // Computing the new hash value by quadratic probing
                        int t = (hash + j * j) % tableSize;
                        if (newHt[t] == null) {
                            newHt[t] = ht[i];
                            break;
                        }else{
                            numCollisions++;
                        }
                    }
                }
                else
                {
                    newHt[hash] = ht[i];
                }
            }
        //modifying the tableSize
        tableSize = tableSize * 2;
        ht = new String[tableSize];
        //copying all the values to ht
        System.arraycopy(newHt, 0, ht, 0, tableSize);
        return ht;
    }
    //insert into the hash table
    public static String[] insert (String[]ht, String value, float numElements)
    {
        //if load factor is greater than or equal to 0.5 doubling the size of table
        if ((numElements / tableSize) >= 0.5)
        {
            ht = rehashing(ht);
        }
        int hash = getHashCode (value, tableSize);
        if (ht[hash] != null)
        {
            numCollisions++;
            for (int j = 0; j < tableSize; j++)
            {
                // Computing the new hash value by quadratic probing
                int t = (hash + j * j) % tableSize;
                if (ht[t] == null) {
                    ht[t] = value;
                    break;
                }else{
                    numCollisions++;
                }
            }
        }
        else
        {
            ht[hash] = value;
            return ht;
        }
        return ht;
    }
    public static void printht (String[]ht, int size)
    {
        for (int i = 0; i < size; ++i)
        {
            System.out.print (ht[i] + "\n");
        }
        System.out.println (" ");
    }
    public static void main (String[]args) throws FileNotFoundException {
        int numElements = 1;
        String[]ht = new String[tableSize];
        // pass the path to the file as a parameter
        File file = new File("C:\\UTD_BMK\\DSA_5343\\ASSIGNMENTS\\ASSIGNMENT_6_MUKESH_BACHU\\input_file.txt");
        Scanner sc = new Scanner(file);
        String value;
        while (sc.hasNextLine()) {
            value = sc.nextLine();
            numElements += 1; //numElements to count how many values have been inserted in the table
            ht = insert(ht, value, numElements);
        }
        System.out.println("\n");
        System.out.println("The number of collisions: "+numCollisions);
        System.out.println("\n");
        //printht (ht, tableSize);
    }
}
