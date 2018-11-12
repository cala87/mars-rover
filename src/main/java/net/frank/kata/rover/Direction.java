package net.frank.kata.rover;

public enum Direction {

    NORTH("\u25B3") {
        @Override
        public Direction right() {
            return EAST;
        }

        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public int getXHop() {
            return 0;
        }

        @Override
        public int getYHop() {
            return 1;
        }
    },
    SOUTH("\u25BD") {
        @Override
        public Direction right() {
            return WEST;
        }

        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        public int getXHop() {
            return 0;
        }

        @Override
        public int getYHop() {
            return -1;
        }
    },
    EAST("\u25B7") {
        @Override
        public Direction right() {
            return SOUTH;
        }

        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public int getXHop() {
            return 1;
        }

        @Override
        public int getYHop() {
            return 0;
        }
    },
    WEST("\u25C1") {
        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        public int getXHop() {
            return -1;
        }

        @Override
        public int getYHop() {
            return 0;
        }
    };

    private final String mark;

    Direction(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public abstract Direction right();

    public abstract Direction left();

    public abstract int getXHop();

    public abstract int getYHop();
}
