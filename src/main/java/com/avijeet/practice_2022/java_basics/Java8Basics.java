package com.avijeet.practice_2022.java_basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
class Transaction{
    int id;
    int value;
    String type;
    Transaction(int id,int value, String type){
        this.id=id;
        this.value=value;
        this.type=type;
    }
}
public class Java8Basics {
    public static void main(String[] args) {
        List<Transaction> transactions=new ArrayList<>();
        transactions.add(new Transaction(1,20,"grocery"));
        transactions.add(new Transaction(2,30,"grocery"));
        transactions.add(new Transaction(3,10,"grocery"));
        transactions.add(new Transaction(4,40,"grocery"));
        transactions.add(new Transaction(4,40,"asd"));
        List<Integer> ids = transactions.stream().filter(e->e.type.equals("grocery")).sorted((e1,e2)->e2.value-e1.value).map(e->e.id).collect(Collectors.toList());
        System.out.println(ids);
//        Map
    }
}
