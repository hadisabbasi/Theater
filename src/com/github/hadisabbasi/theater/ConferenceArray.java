package com.github.hadisabbasi.theater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConferenceArray {
    private Conference[] conferences;

    public ConferenceArray() {
        this(10);
    }

    public ConferenceArray(int length) {
        conferences = new Conference[length];
    }

    public int add(Conference conference) {
        for (int i = 0; i < conferences.length; i++) {
            if (conferences[i] == null) {
                conferences[i] = conference;
                return conference.getId();
            }
        }

        return -1;
    }

    public int remove(int id) {
        for (int i = 0; i < conferences.length; i++) {
            if (conferences[i].getId() == id) {
                conferences[i].setDeleted(true);
                return id;
            }
        }

        return -1;
    }

    public void show() {
        for (int i = 0; i < conferences.length; i++) {
            if (conferences[i] != null && !conferences[i].isDeleted()) {
                Conference conference = conferences[i];
                System.out.println("نام: " + conference.getName() + ", روز و ساعت: " + conference.getTurn() + ", تعداد افراد: " + conference.getPeopleCount());
            }
        }
    }

    public void showEmptyTurns() {
        List<ConferenceTurn> turns = Arrays.asList(ConferenceTurn.values());
        ArrayList<ConferenceTurn> existTurns = new ArrayList<>();

        for (int i = 0; i < conferences.length; i++) {
            if (conferences[i] != null && !conferences[i].isDeleted()) {
                ConferenceTurn turn = conferences[i].getTurn();
                existTurns.add(turn);
            }
        }

        turns.removeAll(existTurns);

        for (ConferenceTurn turn : turns) {
            System.out.println(turn);
        }
    }

    public boolean isTurnExist(ConferenceTurn turn) {
        boolean isExist = false;

        for (int i = 0; i < conferences.length; i++) {
            if (conferences[i] != null && !conferences[i].isDeleted()) {
                if (conferences[i].getTurn() == turn) {
                    isExist = true;
                    break;
                }

            }
        }

        return isExist;
    }


}
