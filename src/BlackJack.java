public class BlackJack {
    public BlackJack() {
    }
    public BlackJack(int startingAmount) {
        p1c = startingAmount;
        p2c = startingAmount;
    }
    private int p1 = 0;
    private int p2 = 0;
    private int p1c = 500;
    private int p2c = 500;
    private int latestHit;
    public void startingHand () {
        p1 = MathRandom(2, 21);
        p2 = MathRandom(2, 21);
    }
    public boolean check1() {
        if (p1 > 21) {
            return true;
        }
        return false;
    }
    public boolean check2() {
        if (p2 > 21) {
            return true;
        }
        return false;
    }
    public boolean check(int Player) {
        if (Player == 1) {
            if (p1 > 21) {
                return true;
            }
            return false;
        } else if (Player == 2) {
            if (p2 > 21) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
    public void hit (int player) {
        latestHit = MathRandom(1, 11);
        if (player == 1) {
            p1 += latestHit;
        } else {
            p2 += latestHit;
        }
    }
    public int getLatestHit () {
        return latestHit;
    }
    public int getP1() {
        return p1;
    }
    public int getP2() {
        return p2;
    }
    public int getP1c() {
        return p1c;
    }
    public int getP2c() {
        return p2c;
    }
    private int MathRandom (int min, int max) {
        return ((int) ((Math.random() * (max - min + 1)) + min));
    }
}