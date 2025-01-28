package com.github.hadisabbasi.theater;

public class Conference {
    private String name;
    private ConferenceTurn turn;
    private int peopleCount;

    private boolean isDeleted;
    private int id;
    private static int COUNTER = 1;


    public Conference() {
        this("null", 0, ConferenceTurn.CHAR_SHANBE_SOBH);
    }

    public Conference(String name, int peopleCount, ConferenceTurn turn) {
        this.name = name;
        this.peopleCount = peopleCount;
        this.id = COUNTER;
        this.turn = turn;
        this.isDeleted = false;
        COUNTER++;
    }

    public String getName() {
        return name;
    }

    public ConferenceTurn getTurn() {
        return turn;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getId() {
        return id;
    }
}


