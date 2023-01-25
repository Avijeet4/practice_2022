package com.avijeet.practice_2022.java_basics;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        ((B)new C()).method2();
    }
}

class B extends A{
    void method1(){
        System.out.println("m1");
    }
    void method2(){
        System.out.println("m2");
    }
}
class C extends B{
    void method2(){
        System.out.println("m22");
    }
}
class ConfigCreator {
    OutputStream create(List<? extends B> list){
        return null;
    }
}

