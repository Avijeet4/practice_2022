package com.avijeet.practice_2022.string;

public class AllABeforeB {
    public boolean checkString(String s) {
        int i=s.indexOf('b');
        return s.indexOf('a',i)==-1;

    }
}
