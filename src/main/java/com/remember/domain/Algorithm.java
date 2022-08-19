package com.remember.domain;

import java.util.List;

public enum Algorithm {
    /*
     * datas
     */
    STACK("스택"),
    QUEUE("큐");

    private static List<Algorithm> allList = List.of(Algorithm.values());

    private final String NAME;
    /*
     * constructor
     */
    Algorithm(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }

    public static List<Algorithm> findAll() {
        return allList;
    }
}
