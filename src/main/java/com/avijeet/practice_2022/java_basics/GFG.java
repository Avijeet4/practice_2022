package com.avijeet.practice_2022.java_basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Singleton implements Serializable {

    // public instance initialized when loading the class
    public static Singleton instance = new Singleton();

    private Singleton()
    {
        // private constructor
    }

    // implement readResolve method
    protected Object readResolve() { return instance; }
}

public class GFG {

    public static void main(String[] args)
    {
        try {
            Singleton instance1 = Singleton.instance;
            ObjectOutput out = new ObjectOutputStream(
                    new FileOutputStream("/Users/avijeet/Documents/GitHub/practice_2022/src/main/java/com/avijeet/practice_2022/java_basics/file.text"));

            out.writeObject(instance1);
            out.close();

            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(
                    new FileInputStream("/Users/avijeet/Documents/GitHub/practice_2022/src/main/java/com/avijeet/practice_2022/java_basics/file.text"));
            Singleton instance2
                    = (Singleton)in.readObject();
            in.close();

            System.out.println("instance1 hashCode:- "
                    + instance1.hashCode());
            System.out.println("instance2 hashCode:- "
                    + instance2.hashCode());
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}