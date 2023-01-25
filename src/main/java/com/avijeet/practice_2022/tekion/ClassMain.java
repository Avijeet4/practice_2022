package com.avijeet.practice_2022.tekion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClassMain implements Runnable{
    @Override
    public void run() {
    }

    public static void main(String[] args) {
        Singleton singleton1=Singleton.getInstance();
        Singleton singleton2=Singleton.getInstance();

        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());

        ExecutorService executorService= Executors.newFixedThreadPool(5);
        List<Runnable> runnables=new ArrayList<>();
        ClassMain classMain=new ClassMain();
        for(int i=0;i<5;i++){
        }
    }
}
