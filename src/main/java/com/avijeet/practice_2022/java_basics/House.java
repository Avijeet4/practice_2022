package com.avijeet.practice_2022.java_basics;

import lombok.Builder;

@Builder
public class House {
    private int gate;
    private int bathroom;
    private int bathtubs;
    private int beds;

    public static void main(String[] args) {
        House house = House.builder().beds(2).gate(2).build();
    }

}
