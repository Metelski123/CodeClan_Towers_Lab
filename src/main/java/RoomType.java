public enum RoomType {
    SINGLE (1, 100),
    DOUBLE (2, 200),
    TRIPLE (3, 300),
    FAMILY (4, 400),
    CONFERENCE(20, 1000),
    DINING(30, 0);

    private final int value;
    private final int rate;

    RoomType(int value, int rate) {
        this.value = value;
        this.rate = rate;
    }

    public int getValue() {
        return this.value;
    }

    public int getRate(){
        return this.rate;
    }
}

