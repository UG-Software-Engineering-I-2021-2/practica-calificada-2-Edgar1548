package org.example;

public final class Pair<firsttype, secondtype> {
    private final firsttype first;
    private final secondtype second;

    public Pair(firsttype first, secondtype second) {
        this.first  = first;
        this.second = second;
    }

    public firsttype first() {
        return first;
    }

    public secondtype second() {
        return second;
    }
}
