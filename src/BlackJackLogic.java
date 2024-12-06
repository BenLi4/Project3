import java.util.Scanner;
public class BlackJackLogic {
    Scanner scan = new Scanner(System.in);
    private int bet1;
    private int bet2;
    private int pot;
    private String hs;
    private BlackJack i = new BlackJack();
    private BlackJack a;
    private int P1B = i.getP1c();
    private int P2B = i.getP2c();
    private int P1I = i.getP1c();
    private int P2I = i.getP2c();
    public void start() {
        System.out.print("Welcome to Blackjack. \n");
        while ((P1B > 0 && P1B < P1I * 6) && (P2B > 0 && P2I < 3000)) {
            pot = 0;
            System.out.println("Player1's current balance: " + P1B);
            System.out.println("Player2's current balance: " + P2B);
            System.out.println("Goal to reach: " + (P1I * 6));
            System.out.print("Enter player 1 bet amount: ");
            bet1 = scan.nextInt();
            while (bet1 > P1B || bet1 <= 0) {
                while (bet1 <= 0) {
                    System.out.print("Enter a bet higher than 0: ");
                    bet1 = scan.nextInt();
                } if (bet1 > P1B) {
                    System.out.print("You're too broke for that. Enter another number within your balance: ");
                    bet1 = scan.nextInt();
                }
            }P1B -= bet1;
            System.out.print("Enter player 2 bet amount: ");
            bet2 = scan.nextInt();
            while (bet2 > P2B || bet2 <= 0) {
                while (bet2 <= 0) {
                    System.out.print("Enter a bet higher than 0: ");
                    bet2 = scan.nextInt();
                } if (bet2 > P2B) {
                    System.out.print("You're too broke for that. Enter another number within your balance: ");
                    bet2 = scan.nextInt();
                }
            }P2B -= bet2;
            pot = bet1 + bet2;
            scan.nextLine();
            i.startingHand();
            while (i.getP1() == 21 && i.getP2() == 21) {
                i.startingHand();
            }
            if (i.getP1() == 21) {
                System.out.println("Player 1 wins with black jack!");
            } else if (i.getP2() == 21) {
                System.out.println("Player 2 wins with black jack!");
            } else {
                System.out.println("Player 1 currently has a " + i.getP1());
                System.out.print("Would you like to hit or stand (P1)? (h/s): ");
                hs = scan.nextLine();
                while ((!hs.equals("s")) && i.getP1() <= 21) {
                    if(!hs.equals("h")) {
                        while (!hs.equals("h") && !hs.equals("s")) {
                            if (hs.length() > 1) {
                                System.out.println("Enter an answer with only ONE letter.");
                                hs = scan.nextLine();
                            } else {
                                System.out.print("Enter a valid response (h/s): ");
                                hs = scan.nextLine();
                            }
                        }
                    }
                    if (hs.equals("h")) {
                        i.hit(1);
                        System.out.println("Player 1 got: " + i.getLatestHit());
                        System.out.println("Player 1 currently has a " + i.getP1());
                    }
                    if (i.getP1() > 21) {
                        System.out.println("Player 1 loses");
                    }
                    if (!i.check1() && !hs.equals("s")) {
                        System.out.print("Would you like to hit or stand (P1)? (h/s): ");
                        hs = scan.nextLine();
                    }
                }
                if (i.getP1() <= 21) {
                    System.out.println("Player 2 currently has a " + i.getP2());
                    System.out.print("Would you like to hit or stand (P2)? (h/s): ");
                    hs = scan.nextLine();
                    while ((!hs.equals("s")) && i.getP2() <= 21) {
                        if (!hs.equals("h")) {
                            while (!hs.equals("h") && !hs.equals("s")) {
                                if (hs.length() > 1) {
                                    System.out.println("Enter an answer with only ONE letter.");
                                    hs = scan.nextLine();
                                } else {
                                    System.out.print("Enter a valid response (h/s): ");
                                    hs = scan.nextLine();
                                }
                            }
                        }
                        if (hs.equals("h")) {
                            i.hit(2);
                            System.out.println("Player 2 got: " + i.getLatestHit());
                            System.out.println("Player 2 currently has a " + i.getP2());
                        }
                        if (i.getP2() > 21) {
                            System.out.println("Player 2 loses");
                        }
                        if (!i.check2() && !hs.equals("s")) {
                            System.out.print("Would you like to hit or stand (P2)? (h/s): ");
                            hs = scan.nextLine();
                        }
                    }
                }
            }
            if (i.check1()) {
                System.out.println("Player 2 wins: " + Earnings2() + "!");
            } else if (i.check2()) {
                System.out.println("Player 1 wins: " + Earnings1() + "!");
            } else if (i.getP1() > i.getP2()) {
                System.out.println("Player 1 wins: " + Earnings1() + "!");
            } else if (i.getP2() > i.getP1()) {
                System.out.println("Player 2 wins: " + Earnings2() + "!");
            } else if (i.getP2() == i.getP1()) {
                System.out.println("Tie!");
                P1B += bet1;
                P2B += bet2;
            }
        }
        if (P1B > P2B) {
            System.out.println("Player 1 is the winner!");
        } else {
            System.out.println("Player 2 is the winner!");
        }
    }
    public void start (int startingAmount) {
        System.out.print("Welcome to Blackjack. \n");
        a = new BlackJack(startingAmount);
        P1B = a.getP1c();
        P2B = a.getP2c();
        P1I = a.getP1c();
        P2I = a.getP2c();
        while ((P1B > 0 && P1B < P1I * 6) && (P2B > 0 && P2I < 3000)) {
            pot = 0;
            System.out.println("Player1's current balance: " + P1B);
            System.out.println("Player2's current balance: " + P2B);
            System.out.println("Goal to reach: " + (P1I * 6));
            System.out.print("Enter player 1 bet amount: ");
            bet1 = scan.nextInt();
            while (bet1 > P1B || bet1 <= 0) {
                while (bet1 <= 0) {
                    System.out.print("Enter a bet higher than 0: ");
                    bet1 = scan.nextInt();
                } if (bet1 > P1B) {
                    System.out.print("You're too broke for that. Enter another number within your balance: ");
                    bet1 = scan.nextInt();
                }
            }P1B -= bet1;
            System.out.print("Enter player 2 bet amount: ");
            bet2 = scan.nextInt();
            while (bet2 > P2B || bet2 <= 0) {
                while (bet2 <= 0) {
                    System.out.print("Enter a bet higher than 0: ");
                    bet2 = scan.nextInt();
                } if (bet2 > P2B) {
                    System.out.print("You're too broke for that. Enter another number within your balance: ");
                    bet2 = scan.nextInt();
                }
            }P2B -= bet2;
            pot = bet1 + bet2;
            scan.nextLine();
            a.startingHand();
            while (a.getP1() == 21 && a.getP2() == 21) {
                a.startingHand();
            }
            if (a.getP1() == 21) {
                System.out.println("Player 1 wins with black jack!");
            } else if (a.getP2() == 21) {
                System.out.println("Player 2 wins with black jack!");
            } else {
                System.out.println("Player 1 currently has a " + a.getP1());
                System.out.print("Would you like to hit or stand (P1)? (h/s): ");
                hs = scan.nextLine();
                while ((!hs.equals("s")) && a.getP1() <= 21) {
                    if(!hs.equals("h")) {
                        while (!hs.equals("h") && !hs.equals("s")) {
                            if (hs.length() > 1) {
                                System.out.println("Enter an answer with only ONE letter.");
                                hs = scan.nextLine();
                            } else {
                                System.out.print("Enter a valid response (h/s): ");
                                hs = scan.nextLine();
                            }
                        }
                    }
                    if (hs.equals("h")) {
                        a.hit(1);
                        System.out.println("Player 1 got: " + a.getLatestHit());
                        System.out.println("Player 1 currently has a " + a.getP1());
                    }
                    if (a.getP1() > 21) {
                        System.out.println("Player 1 loses");
                    }
                    if (!a.check1() && !hs.equals("s")) {
                        System.out.print("Would you like to hit or stand (P1)? (h/s): ");
                        hs = scan.nextLine();
                    }
                }
                if (a.getP1() <= 21) {
                    System.out.println("Player 2 currently has a " + a.getP2());
                    System.out.print("Would you like to hit or stand (P2)? (h/s): ");
                    hs = scan.nextLine();
                    while ((!hs.equals("s")) && a.getP2() <= 21) {
                        if (!hs.equals("h")) {
                            while (!hs.equals("h") && !hs.equals("s")) {
                                if (hs.length() > 1) {
                                    System.out.println("Enter an answer with only ONE letter.");
                                    hs = scan.nextLine();
                                } else {
                                    System.out.print("Enter a valid response (h/s): ");
                                    hs = scan.nextLine();
                                }
                            }
                        }
                        if (hs.equals("h")) {
                            a.hit(2);
                            System.out.println("Player 2 got: " + a.getLatestHit());
                            System.out.println("Player 2 currently has a " + a.getP2());
                        }
                        if (a.getP2() > 21) {
                            System.out.println("Player 2 loses");
                        }
                        if (!a.check2() && !hs.equals("s")) {
                            System.out.print("Would you like to hit or stand (P2)? (h/s): ");
                            hs = scan.nextLine();
                        }
                    }
                }
            }
            if (a.check(1)) {
                System.out.println("Player 2 wins: " + Earnings(2) + "!");
            } else if (a.check(2)) {
                System.out.println("Player 1 wins: " + Earnings(1) + "!");
            } else if (a.getP1() > a.getP2()) {
                System.out.println("Player 1 wins: " + Earnings(1) + "!");
            } else if (a.getP2() > a.getP1()) {
                System.out.println("Player 2 wins: " + Earnings(2) + "!");
            } else if (a.getP2() == a.getP1()) {
                System.out.println("Tie!");
                P1B += bet1;
                P2B += bet2;
            }
        }
        if (P1B > P2B) {
            System.out.println("Player 1 is the winner!");
        } else {
            System.out.println("Player 2 is the winner!");
        }
    }
    private int Earnings1 () {
        if (bet1 > bet2) {
            P1B += pot * 2;
            return pot * 2;
        } else if (bet1 < bet2) {
            P1B += bet1 * 2 + bet2;
            return bet1 * 2 + bet2;
        } else {
            P1B += pot;
            return pot;
        }
    }
    private int Earnings2 () {
        if (bet2 > bet1) {
            P2B += pot * 2;
            return pot * 2;
        } else if (bet2 < bet1) {
            P2B += bet2 * 2 + bet1;
            return bet2 * 2 + bet1;
        } else {
            P2B += pot;
            return pot;
        }
    }
    private int Earnings (int Player) {
        if (Player == 1) {
            if (bet1 > bet2) {
                P1B += pot * 2;
                return pot * 2;
            } else if (bet1 < bet2) {
                P1B += bet1 * 2 + bet2;
                return bet1 * 2 + bet2;
            } else {
                P1B += pot;
                return pot;
            }
        } else if (Player == 2) {
            if (bet2 > bet1) {
                P2B += pot * 2;
                return pot * 2;
            } else if (bet2 < bet1) {
                P2B += bet2 * 2 + bet1;
                return bet2 * 2 + bet1;
            } else {
                P2B += pot;
                return pot;
            }
        } else {
            return 0;
        }
    }
}