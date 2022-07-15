package com.remember.domains;

import java.util.List;

/*
 * https://stackoverflow.com/questions/32799282/does-the-enumvalues-allocate-memory-on-each-call
 */
public enum Platform {
    /*
     * datas
     */
    BEAKJOON("백준", "https://www.acmicpc.net"),
    PROGRAMMERS("프로그래머스", "https://programmers.co.kr/"),
    SWEA("삼성SW아카데미", "https://swexpertacademy.com/");


    private static final List<Platform> allList = List.of(Platform.values());

    private final String NAME;
    private final String LINK;

    /*
     * constructor
     */
    Platform(String NAME, String LINK) {
        this.NAME = NAME;
        this.LINK = LINK;
    }

    public String getNAME() {
        return NAME;
    }

    public String getLINK() {
        return LINK;
    }

    public static List<Platform> findAll() {
        return allList;
    }
}
