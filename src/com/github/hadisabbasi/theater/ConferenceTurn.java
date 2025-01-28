package com.github.hadisabbasi.theater;

import java.util.Scanner;

public enum ConferenceTurn {
    SHANBE_SOBH("shanbe", 1),
    SHANBE_ZOHR("shanbe", 2),
    YEK_SHANBE_SOBH("yek_shanbe", 1),
    YEK_SHANBE_ZOHR("yek_shanbe", 2),
    DO_SHANBE_SOBH("do_shanbe", 1),
    DO_SHANBE_ZOHR("do_shanbe", 2),
    SE_SHANBE_SOBH("se_shanbe", 1),
    SE_SHANBE_ZOHR("se_shanbe", 2),
    CHAR_SHANBE_SOBH("chahar_shanbe", 1),
    CHAR_SHANBE_ZOHR("chahar_shanbe", 2);


    private String day;
    private int turn;

    private ConferenceTurn(String day, int turn) {
        this.day = day;
        this.turn = turn;
    }

    public static ConferenceTurn getByNameAndTurn(String day, int turn) {
        ConferenceTurn[] values = ConferenceTurn.values();
        for (ConferenceTurn value : values) {
            if (value.day.equals(day) && value.turn == turn) {
                return value;
            }
        }

        // throw exception
        return null;
    }
}

