import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.GenericDeclaration;
import java.awt.AWTEvent;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.net.URL;
import java.net.http.WebSocket;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import java.util.*;
import java.io.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class SwingTest {
    public static void main(String[] args) {
        new SwingTest();
    }
    
    public SwingTest() {
        startUpGame();
    }
    
    private JLayeredPane lPane = new JLayeredPane();
    private ArrayList<String> bet_numbers = new ArrayList<>();
    private ArrayList<String> bet_buttons = new ArrayList<>();
    private LinkedHashMap<String, String> map = new LinkedHashMap<>();
    private ArrayList<String> type = new ArrayList<>();
    private ArrayList<Integer> allBets = new ArrayList<>();
    private ArrayList<Integer> payout = new ArrayList<>();
    private String[] wheel = new String[38];
    private String ball;
    private int bank;
    private int total_money;
    private int bet_amount;
    private int max_amount = 5000;

    public void startUpGame() {
        JFrame f = new JFrame("Roulette");
        //f.setSize(900,450);
        f.setBounds(0, 0, 1300, 600);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(new Color(53, 101, 77));

        //JLayeredPane lPane = new JLayeredPane();
        //lPane.setLayout(new BorderLayout());
        lPane.setBounds(0, 0, 1079, 407);
        //lPane.setVisible(true);
        lPane.setBackground(new Color(53, 101, 77));

        wheel[0] = "00";
        wheel[1] = "0";
        for (int ig = 2; ig < 38; ig++) {
            int hold = ig-1;
            wheel[ig] = String.valueOf(hold);
        }

        Random rand = new Random();
        int hold = rand.nextInt(wheel.length);
        ball = wheel[hold];

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your bank amount: ");
        bank = scan.nextInt();

        System.out.println("Enter how much a chip(click) is worth: ");
        bet_amount = scan.nextInt();

        JPanel mainP = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();

        JPanel mainP2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel p8 = new JPanel();
        JPanel p9 = new JPanel();
        JPanel p10 = new JPanel();
        JPanel p11 = new JPanel();
        JPanel p12 = new JPanel();
        JPanel p13 = new JPanel();
        JPanel p14 = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(75, 125);
            };
        };
        JPanel p15 = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(75, 125);
            };
        };
        JPanel p16 = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(75, 75);
            };
        };
        JPanel p17 = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(75, 75);
            };
        };
        JPanel p18 = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(75, 75);
            };
        };
        JPanel p19 = new JPanel();
        JPanel p20 = new JPanel();

        //mainP.setPreferredSize(new Dimension(800, 407));
        mainP.setBounds(93, 50, 988, 407);
        mainP2.setBounds(85, 50, 1004, 249);
        p0.setPreferredSize(new Dimension(988, 75));
        p1.setPreferredSize(new Dimension(988, 8));
        p2.setPreferredSize(new Dimension(988, 75));
        p3.setPreferredSize(new Dimension(988, 8));
        p4.setPreferredSize(new Dimension(988, 75));
        p5.setPreferredSize(new Dimension(988, 8));
        p6.setPreferredSize(new Dimension(988, 75));
        p7.setPreferredSize(new Dimension(988, 75));
        p8.setPreferredSize(new Dimension(1004, 75));
        p9.setPreferredSize(new Dimension(1004, 8));
        p10.setPreferredSize(new Dimension(1004, 75));
        p11.setPreferredSize(new Dimension(1004, 8));
        p12.setPreferredSize(new Dimension(1004, 75));
        p13.setPreferredSize(new Dimension(1004, 8));

        p0.setLayout(new GridLayout(1, 12, 8, 0));
        p1.setLayout(new GridLayout(1, 12, 8, 0));
        p2.setLayout(new GridLayout(1, 12, 8, 0));
        p3.setLayout(new GridLayout(1, 12, 8, 0));
        p4.setLayout(new GridLayout(1, 12, 8, 0));
        p5.setLayout(new GridLayout(1, 12, 8, 0));
        p6.setLayout(new GridLayout(1, 3, 8, 0));
        p7.setLayout(new GridLayout(1, 6, 8, 0));
        p8.setLayout(new GridLayout(1, 13, 75, 0));
        p9.setLayout(new GridLayout(1, 13, 75, 0));
        p10.setLayout(new GridLayout(1, 13, 75, 0));
        p11.setLayout(new GridLayout(1, 13, 75, 0));
        p12.setLayout(new GridLayout(1, 13, 75, 0));
        p13.setLayout(new GridLayout(1, 13, 75, 0));

        mainP.setBackground(new Color(53, 101, 77));
        mainP2.setBackground(new Color(53, 101, 77));
        p0.setBackground(new Color(53, 101, 77));
        p1.setBackground(new Color(53, 101, 77));
        p2.setBackground(new Color(53, 101, 77));
        p3.setBackground(new Color(53, 101, 77));
        p4.setBackground(new Color(53, 101, 77));
        p5.setBackground(new Color(53, 101, 77));
        p6.setBackground(new Color(53, 101, 77));
        p7.setBackground(new Color(53, 101, 77));
        p8.setBackground(new Color(53, 101, 77));
        p9.setBackground(new Color(53, 101, 77));
        p10.setBackground(new Color(53, 101, 77));
        p11.setBackground(new Color(53, 101, 77));
        p12.setBackground(new Color(53, 101, 77));
        p13.setBackground(new Color(53, 101, 77));
        p14.setBackground(new Color(53, 101, 77));
        p15.setBackground(new Color(53, 101, 77));
        p16.setBackground(new Color(53, 101, 77));
        p17.setBackground(new Color(53, 101, 77));
        p18.setBackground(new Color(53, 101, 77));
        p19.setBackground(new Color(53, 101, 77));
        p20.setBackground(new Color(53, 101, 77));

        p0.setVisible(true);
        p1.setVisible(true);
        p2.setVisible(true);
        p3.setVisible(true);
        p4.setVisible(true);
        p5.setVisible(true);

        p6.setVisible(true);
        p7.setVisible(true);

        p8.setVisible(true);
        p9.setVisible(true);
        p10.setVisible(true);
        p11.setVisible(true);
        p12.setVisible(true);
        p13.setVisible(true);

        mainP.setVisible(true);
        mainP2.setVisible(true);

        String[][] board = {{"3", "6", "9", "12", "15", "18", "21", "24", "27", "30", "33", "36"},
                        {"100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111"}, 
                        {"2", "5", "8", "11", "14", "17", "20", "23", "26", "29", "32", "35"},
                        {"200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211"}, 
                        {"1", "4", "7", "10", "13", "16", "19", "22", "25", "28", "31", "34"},
                        {"300", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311"}};
        
        Color[][] colors = {{Color.RED, Color.BLACK, Color.RED, Color.RED, Color.BLACK, Color.RED, Color.RED, Color.BLACK, Color.RED, Color.RED, Color.BLACK, Color.RED},
                            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                            {Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED, Color.BLACK},
                            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                            {Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED},
                            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE}};
        
        JButton[] buttons = new JButton[72];
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //JButton temp = new JButton(board[i][j] + " " + " ");
                buttons[count] = new JButton(board[i][j]);
                buttons[count].setContentAreaFilled(true);
                buttons[count].setOpaque(true);
                buttons[count].setBorderPainted(true);
                buttons[count].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                buttons[count].setForeground(Color.WHITE);
                buttons[count].setBackground(colors[i][j]);
                buttons[count].setActionCommand(board[i][j]);
                buttons[count].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        String choice1 = e1.getActionCommand();
                        System.out.println("You have clicked button " + choice1);
                        int conv = Integer.parseInt(choice1);
                        int conv2;
                        String convert = "";
                        if (conv > 100 && conv < 113) {
                            convert = choice1.substring(1);
                            conv2 = Integer.parseInt(convert);
                            bet_numbers.add(board[0][conv2]);
                            bet_numbers.add(board[2][conv2]);
                            map.put(board[0][conv2], choice1);
                            map.put(board[2][conv2], choice1);
                            bet_buttons.add(choice1);
                            bet_buttons.add(choice1);
                            if (total_money <= max_amount-bet_amount) {
                                total_money+=bet_amount;
                                allBets.add(bet_amount);
                            }
                            
                        }
                        else if (conv > 200 && conv < 213) {
                            convert = choice1.substring(1);
                            conv2 = Integer.parseInt(convert);
                            bet_numbers.add(board[2][conv2]);
                            bet_numbers.add(board[4][conv2]);
                            map.put(board[2][conv2], choice1);
                            map.put(board[4][conv2], choice1);
                            bet_buttons.add(choice1);
                            bet_buttons.add(choice1);
                            if (total_money <= max_amount-bet_amount) {
                                total_money+=bet_amount;
                                allBets.add(bet_amount);
                            }
                        }
                        else if (conv > 300 && conv < 313) {
                            convert = choice1.substring(1);
                            conv2 = Integer.parseInt(convert);
                            bet_numbers.add(board[0][conv2]);
                            bet_numbers.add(board[2][conv2]);
                            bet_numbers.add(board[4][conv2]);
                            map.put(board[0][conv2], choice1);
                            map.put(board[2][conv2], choice1);
                            map.put(board[4][conv2], choice1);
                            bet_buttons.add(choice1);
                            bet_buttons.add(choice1);
                            bet_buttons.add(choice1);
                            if (total_money <= max_amount-bet_amount) {
                                total_money+=bet_amount;
                                allBets.add(bet_amount);
                            }
                        }
                        else {
                            bet_numbers.add(choice1);
                            map.put(choice1, choice1);
                            bet_buttons.add(choice1);
                            if (total_money <= max_amount-bet_amount) {
                                total_money+=bet_amount;
                                allBets.add(bet_amount);
                            }
                        }
                    }
                });

                if (i == 0) {
                    p0.add(buttons[count]);
                }
                else if (i == 1) {
                    p1.add(buttons[count]);
                }
                else if (i == 2) {
                    p2.add(buttons[count]);
                }
                else if (i == 3) {
                    p3.add(buttons[count]);
                }
                else if (i == 4) {
                    p4.add(buttons[count]);
                }
                else if (i == 5) {
                    p5.add(buttons[count]);
                }
                count++;
            }
        }

        String[] twelves = {"1st 12", "2nd 12", "3rd 12"};
        String[] bottom1 = {"1 to 18", "EVEN", "RED", "BLACK", "ODD", "19 to 36"};

        JButton[] buttons1 = new JButton[3];
        for (int x = 0; x < twelves.length; x++) {
            //JButton temp2 = new JButton(twelves[x] + " " + " ");
            buttons1[x] = new JButton(twelves[x]);
            buttons1[x].setContentAreaFilled(true);
            buttons1[x].setOpaque(true);
            buttons1[x].setBorderPainted(true);
            buttons1[x].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            buttons1[x].setForeground(Color.WHITE);
            buttons1[x].setBackground(new Color(53, 101, 77));
            buttons1[x].setActionCommand(twelves[x]);
            buttons1[x].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e2) {
                    String choice2 = e2.getActionCommand();            
                    System.out.println("You have clicked button " + choice2);
                    if (choice2.equals("1st 12")) {
                        for (int x1 = 0; x1 < 4; x1++) {
                            int x2 = 4;
                            bet_numbers.add(board[x2][x1]);
                            map.put(board[x2][x1], twelves[0]);
                            bet_buttons.add(twelves[0]);
                            x2-=2;
                            bet_numbers.add(board[x2][x1]);
                            map.put(board[x2][x1], twelves[0]);
                            bet_buttons.add(twelves[0]);
                            x2-=2;
                            bet_numbers.add(board[x2][x1]);
                            map.put(board[x2][x1], twelves[0]);
                            bet_buttons.add(twelves[0]);
                            if (total_money <= max_amount-bet_amount) {
                                total_money+=bet_amount;
                                allBets.add(bet_amount);
                            }
                        }
                    }
                    else if (choice2.equals("2nd 12")) {
                        for (int x1 = 4; x1 < 8; x1++) {
                            int x2 = 4;
                            bet_numbers.add(board[x2][x1]);
                            map.put(board[x2][x1], twelves[1]);
                            bet_buttons.add(twelves[1]);
                            x2-=2;
                            bet_numbers.add(board[x2][x1]);
                            map.put(board[x2][x1], twelves[1]);
                            bet_buttons.add(twelves[1]);
                            x2-=2;
                            bet_numbers.add(board[x2][x1]);
                            map.put(board[x2][x1], twelves[1]);
                            bet_buttons.add(twelves[1]);
                            if (total_money <= max_amount-bet_amount) {
                                total_money+=bet_amount;
                                allBets.add(bet_amount);
                            }
                        }
                    }
                    else if (choice2.equals("3rd 12")) {
                        for (int x1 = 8; x1 < 12; x1++) {
                            int x2 = 4;
                            bet_numbers.add(board[x2][x1]);
                            map.put(board[x2][x1], twelves[2]);
                            bet_buttons.add(twelves[2]);
                            x2-=2;
                            bet_numbers.add(board[x2][x1]);
                            map.put(board[x2][x1], twelves[2]);
                            bet_buttons.add(twelves[2]);
                            x2-=2;
                            bet_numbers.add(board[x2][x1]);
                            map.put(board[x2][x1], twelves[2]);
                            bet_buttons.add(twelves[2]);
                            if (total_money <= max_amount-bet_amount) {
                                total_money+=bet_amount;
                                allBets.add(bet_amount);
                            }
                        }
                    }
                }
            });
            p6.add(buttons1[x]);
        }

        JButton[] buttons2 = new JButton[6];
        for (int y = 0; y < bottom1.length; y++) {
            //JButton temp3 = new JButton(bottom1[y] + " " + " ");
            buttons2[y] = new JButton(bottom1[y]);
            buttons2[y].setContentAreaFilled(true);
            buttons2[y].setOpaque(true);
            buttons2[y].setBorderPainted(true);
            buttons2[y].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            buttons2[y].setForeground(Color.WHITE);
            buttons2[y].setBackground(new Color(53, 101, 77));
            buttons2[y].setActionCommand(bottom1[y]);
            buttons2[y].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e3) {
                    String choice3 = e3.getActionCommand();
                    System.out.println("You have clicked button " + choice3);
                    if (choice3.equals("1 to 18")) {
                        for (int y1 = 0; y1 < 6; y1++) {
                            int y2 = 4;
                            bet_numbers.add(board[y2][y1]);
                            map.put(board[y2][y1], bottom1[0]);
                            bet_buttons.add(bottom1[0]);
                            y2-=2;
                            bet_numbers.add(board[y2][y1]);
                            map.put(board[y2][y1], bottom1[0]);
                            bet_buttons.add(bottom1[0]);
                            y2-=2;
                            bet_numbers.add(board[y2][y1]);
                            map.put(board[y2][y1], bottom1[0]);
                            bet_buttons.add(bottom1[0]);
                            if (total_money <= max_amount-bet_amount) {
                                total_money+=bet_amount;
                                allBets.add(bet_amount);
                            }
                        }
                    }
                    else if (choice3.equals("EVEN")) {
                        for (int y1 = 0; y1 < 4; y1+=2) {
                            for (int y2 = 0; y2 < board[0].length; y2++) {
                                int convert = Integer.parseInt(board[y1][y2]);
                                if (convert%2 == 0) {
                                    bet_numbers.add(board[y1][y2]);
                                    map.put(board[y1][y2], bottom1[1]);
                                    bet_buttons.add(bottom1[1]);
                                }
                            }
                        }
                    }
                    else if (choice3.equals("RED")) {
                        for (int y1 = 0; y1 < colors.length; y1+=2) {
                            for (int y2 = 0; y2 < colors[0].length; y2++) {
                                if (colors[y1][y2].equals(Color.RED)) {
                                    bet_numbers.add(board[y1][y2]);
                                    map.put(board[y1][y2], bottom1[2]);
                                    bet_buttons.add(bottom1[2]);
                                    if (total_money <= max_amount-bet_amount) {
                                        total_money+=bet_amount;
                                        allBets.add(bet_amount);
                                    }
                                }
                            }
                        }
                    }
                    else if (choice3.equals("BLACK")) {
                        for (int y1 = 0; y1 < colors.length; y1+=2) {
                            for (int y2 = 0; y2 < colors[0].length; y2++) {
                                if (colors[y1][y2].equals(Color.BLACK)) {
                                    bet_numbers.add(board[y1][y2]);
                                    map.put(board[y1][y2], bottom1[3]);
                                    bet_buttons.add(bottom1[3]);
                                }
                            }
                        }
                    }
                    else if (choice3.equals("ODD")) {
                        for (int y1 = 0; y1 < 4; y1+=2) {
                            for (int y2 = 0; y2 < board[0].length; y2++) {
                                int convert2 = Integer.parseInt(board[y1][y2]);
                                if (convert2%2 != 0) {
                                    bet_numbers.add(board[y1][y2]);
                                    map.put(board[y1][y2], bottom1[4]);
                                    bet_buttons.add(bottom1[4]);
                                    if (total_money <= max_amount-bet_amount) {
                                        total_money+=bet_amount;
                                        allBets.add(bet_amount);
                                    }
                                }
                            }
                        }
                    }
                    else if (choice3.equals("19 to 36")) {
                        for (int y1 = 6; y1 < 12; y1++) {
                            int y2 = 4;
                            bet_numbers.add(board[y2][y1]);
                            map.put(board[y2][y1], bottom1[5]);
                            bet_buttons.add(bottom1[5]);
                            y2-=2;
                            bet_numbers.add(board[y2][y1]);
                            map.put(board[y2][y1], bottom1[5]);
                            bet_buttons.add(bottom1[5]);
                            y2-=2;
                            bet_numbers.add(board[y2][y1]);
                            map.put(board[y2][y1], bottom1[5]);
                            bet_buttons.add(bottom1[5]);
                            if (total_money <= max_amount-bet_amount) {
                                total_money+=bet_amount;
                                allBets.add(bet_amount);
                            }
                        }
                    }
                }
            });

            if (y == 2) {
                buttons2[y].setBackground(Color.RED);
            }
            if (y == 3) {
                buttons2[y].setBackground(Color.BLACK);
            }

            p7.add(buttons2[y]);
        }

        JButton[] buttons3 = new JButton[13];
        for (int a = 0; a < 13; a++) {
            //JButton temp4 = new JButton("0" + " " + " ");
            String value1 = "";
            if (a < 10) {
                value1 = "40" + String.valueOf(a);
            }
            else {
                value1 = "4" + String.valueOf(a);
            }
            buttons3[a] = new JButton(value1);
            buttons3[a].setContentAreaFilled(true);
            buttons3[a].setOpaque(true);
            buttons3[a].setBorderPainted(true);
            buttons3[a].setForeground(Color.WHITE);
            buttons3[a].setBackground(Color.WHITE);
            buttons3[a].setActionCommand(value1);
            buttons3[a].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e4) {
                    String choice4 = e4.getActionCommand();
                    System.out.println("You have clicked button " + choice4);
                    String convert = choice4.substring(1);
                    int conv = Integer.parseInt(convert);
                    if (conv > 0 && conv < 12) {
                        bet_numbers.add(board[0][conv-1]);
                        bet_numbers.add(board[0][conv]);
                        map.put(board[0][conv-1], choice4);
                        map.put(board[0][conv], choice4);
                        bet_buttons.add(choice4);
                        bet_buttons.add(choice4);
                        if (total_money <= max_amount-bet_amount) {
                            total_money+=bet_amount;
                            allBets.add(bet_amount);
                        }
                    }
                }
            });
            p8.add(buttons3[a]);
        }

        JButton[] buttons4 = new JButton[13];
        String value2 = "";
        for (int b = 0; b < 13; b++) {
            if (b < 10) {
                value2 = "50" + String.valueOf(b);
            }
            else {
                value2 = "5" + String.valueOf(b);
            }
            buttons4[b] = new JButton(value2);
            buttons4[b].setContentAreaFilled(true);
            buttons4[b].setOpaque(true);
            buttons4[b].setBorderPainted(true);
            buttons4[b].setForeground(Color.WHITE);
            buttons4[b].setBackground(Color.WHITE);
            buttons4[b].setActionCommand(value2);
            buttons4[b].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e5) {
                    String choice5 = e5.getActionCommand();
                    System.out.println("You have clicked button " + choice5);
                    String convert = choice5.substring(1);
                    int conv = Integer.parseInt(convert);
                    if (conv == 0) {
                        bet_numbers.add(board[0][conv]);
                        bet_numbers.add(board[2][conv]);
                        bet_numbers.add("00");
                        map.put(board[0][conv], choice5);
                        map.put(board[2][conv], choice5);
                        map.put("00", choice5);
                        bet_buttons.add(choice5);
                        bet_buttons.add(choice5);
                        bet_buttons.add(choice5);
                        if (total_money <= max_amount-bet_amount) {
                            total_money+=bet_amount;
                            allBets.add(bet_amount);
                        }
                    }
                    else if ( conv > 0 && conv < 12) {
                        bet_numbers.add(board[0][conv-1]);
                        bet_numbers.add(board[0][conv]);
                        bet_numbers.add(board[2][conv-1]);
                        bet_numbers.add(board[2][conv]);
                        map.put(board[0][conv-1], choice5);
                        map.put(board[0][conv], choice5);
                        map.put(board[2][conv-1], choice5);
                        map.put(board[2][conv], choice5);
                        bet_buttons.add(choice5);
                        bet_buttons.add(choice5);
                        bet_buttons.add(choice5);
                        bet_buttons.add(choice5);
                        if (total_money <= max_amount-bet_amount) {
                            total_money+=bet_amount;
                            allBets.add(bet_amount);
                        }
                    }
                }
            });
            p9.add(buttons4[b]);
        }

        JButton[] buttons5 = new JButton[13];
        for (int c = 0; c < 13; c++) {
            //JButton temp6 = new JButton("0" + " " + " ");
            String value3 = "";
            if (c < 10) {
                value3 = "60" + String.valueOf(c);
            }
            else {
                value3 = "6" + String.valueOf(c);
            }
            buttons5[c] = new JButton(value3);
            buttons5[c].setContentAreaFilled(true);
            buttons5[c].setOpaque(true);
            buttons5[c].setBorderPainted(true);
            buttons5[c].setForeground(Color.WHITE);
            buttons5[c].setBackground(Color.WHITE);
            buttons5[c].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e6) {
                    String choice6 = e6.getActionCommand();
                    System.out.println("You have clicked button " + choice6);
                    String convert = choice6.substring(1);
                    int conv = Integer.parseInt(convert);
                    if (conv > 0 && conv < 12) {
                        bet_numbers.add(board[2][conv-1]);
                        bet_numbers.add(board[2][conv]);
                        map.put(board[2][conv-1], choice6);
                        map.put(board[2][conv], choice6);
                        bet_buttons.add(choice6);
                        bet_buttons.add(choice6);
                        if (total_money <= max_amount-bet_amount) {
                            total_money+=bet_amount;
                            allBets.add(bet_amount);
                        }
                    }
                }
            });
            p10.add(buttons5[c]);
        }

        JButton[] buttons6 = new JButton[13];
        for (int d = 0; d < 13; d++) {
            //JButton temp7 = new JButton("0" + " " + " ");
            String value4 = "";
            if (d < 10) {
                value4 = "70" + String.valueOf(d);
            }
            else {
                value4 = "7" + String.valueOf(d);
            }
            buttons6[d] = new JButton(value4);
            buttons6[d].setContentAreaFilled(true);
            buttons6[d].setOpaque(true);
            buttons6[d].setBorderPainted(true);
            buttons6[d].setForeground(Color.WHITE);
            buttons6[d].setBackground(Color.WHITE);
            buttons6[d].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e7) {
                    String choice7 = e7.getActionCommand();
                    System.out.println("You have clicked button " + choice7);
                    String convert = choice7.substring(1);
                    int conv = Integer.parseInt(convert);
                    if (conv == 0) {
                        bet_numbers.add(board[2][conv]);
                        bet_numbers.add(board[4][conv]);
                        bet_numbers.add("0");
                        map.put(board[2][conv], choice7);
                        map.put(board[4][conv], choice7);
                        map.put("0", choice7);
                        bet_buttons.add(choice7);
                        bet_buttons.add(choice7);
                        bet_buttons.add(choice7);
                        if (total_money <= max_amount-bet_amount) {
                            total_money+=bet_amount;
                            allBets.add(bet_amount);
                        }
                    }
                    else if (conv < 12) {
                        bet_numbers.add(board[2][conv-1]);
                        bet_numbers.add(board[2][conv]);
                        bet_numbers.add(board[4][conv-1]);
                        bet_numbers.add(board[4][conv]);
                        map.put(board[2][conv-1], choice7);
                        map.put(board[2][conv], choice7);
                        map.put(board[4][conv-1], choice7);
                        map.put(board[4][conv], choice7);
                        bet_buttons.add(choice7);
                        bet_buttons.add(choice7);
                        bet_buttons.add(choice7);
                        bet_buttons.add(choice7);
                        if (total_money <= max_amount-bet_amount) {
                            total_money+=bet_amount;
                            allBets.add(bet_amount);
                        }
                    }
                }
            });
            p11.add(buttons6[d]);
        }

        JButton[] buttons7 = new JButton[13];
        for (int e = 0; e < 13; e++) {
            //JButton temp8 = new JButton("0" + " " + " ");
            String value5 = "";
            if (e < 10) {
                value5 = "80" + String.valueOf(e);
            }
            else {
                value5 = "8" + String.valueOf(e);
            }
            buttons7[e] = new JButton(value5);
            buttons7[e].setContentAreaFilled(true);
            buttons7[e].setOpaque(true);
            buttons7[e].setBorderPainted(true);
            buttons7[e].setForeground(Color.WHITE);
            buttons7[e].setBackground(Color.WHITE);
            buttons7[e].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e8) {
                    String choice8 = e8.getActionCommand();
                    System.out.println("You have clicked button " + choice8);
                    String convert = choice8.substring(1);
                    int conv = Integer.parseInt(convert);
                    if (conv > 0 && conv < 12) {
                        bet_numbers.add(board[4][conv-1]);
                        bet_numbers.add(board[4][conv]);
                        map.put(board[4][conv-1], choice8);
                        map.put(board[4][conv], choice8);
                        bet_buttons.add(choice8);
                        bet_buttons.add(choice8);
                        if (total_money <= max_amount-bet_amount) {
                            total_money+=bet_amount;
                            allBets.add(bet_amount);
                        }
                    }
                }
            });
            p12.add(buttons7[e]);
        }

        JButton[] buttons8 = new JButton[13];
        for (int g = 0; g < 13; g++) {
            //JButton temp9 = new JButton("0" + " " + " ");
            String value6 = "";
            if (g < 10) {
                value6 = "90" + String.valueOf(g);
            }
            else {
                value6 = "9" + String.valueOf(g);
            }
            buttons8[g] = new JButton(value6);
            buttons8[g].setContentAreaFilled(true);
            buttons8[g].setOpaque(true);
            buttons8[g].setBorderPainted(true);
            buttons8[g].setForeground(Color.WHITE);
            buttons8[g].setBackground(Color.WHITE);
            buttons8[g].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e9) {
                    String choice9 = e9.getActionCommand();
                    System.out.println("You have clicked button " + choice9);
                    String convert = choice9.substring(1);
                    int conv = Integer.parseInt(convert);
                    if (conv == 0) {
                        bet_numbers.add(board[0][0]);
                        bet_numbers.add(board[2][0]);
                        bet_numbers.add(board[4][0]);
                        bet_numbers.add("00");
                        bet_numbers.add("0");
                        map.put(board[0][0], choice9);
                        map.put(board[2][0], choice9);
                        map.put(board[4][0], choice9);
                        map.put("00", choice9);
                        map.put("0", choice9);
                        bet_buttons.add(choice9);
                        bet_buttons.add(choice9);
                        bet_buttons.add(choice9);
                        bet_buttons.add(choice9);
                        bet_buttons.add(choice9);
                        if (total_money <= max_amount-bet_amount) {
                            total_money+=bet_amount;
                            allBets.add(bet_amount);
                        }
                    }
                    else if (conv > 0 && conv < 12) {
                        for (int g1 = conv-1; g1 < (conv); g1++) {
                            bet_numbers.add(board[0][g1]);
                            bet_numbers.add(board[2][g1]);
                            bet_numbers.add(board[4][g1]);
                            map.put(board[0][g1], choice9);
                            map.put(board[2][g1], choice9);
                            map.put(board[4][g1], choice9);
                            bet_buttons.add(choice9);
                            bet_buttons.add(choice9);
                            bet_buttons.add(choice9);
                            if (total_money <= max_amount-bet_amount) {
                                total_money+=bet_amount;
                                allBets.add(bet_amount);
                            }
                        }
                    }
                }
            });
            p13.add(buttons8[g]);
        }

        JButton temp10 = new JButton("00");
        temp10.setContentAreaFilled(true);
        temp10.setOpaque(true);
        temp10.setBorderPainted(true);
        temp10.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        temp10.setForeground(Color.WHITE);
        temp10.setBackground(new Color(53, 101, 77));
        temp10.setPreferredSize(new Dimension(75, 125));
        p14.add(temp10);
        p14.setBounds(9, 46, 75, 125);
        p14.setVisible(true);
        temp10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e10) {
                String choice10 = e10.getActionCommand();
                System.out.println("You have clicked button " + choice10);
                bet_numbers.add(choice10);
                map.put(choice10, choice10);
                bet_buttons.add(choice10);
                if (total_money <= max_amount-bet_amount) {
                    total_money+=bet_amount;
                    allBets.add(bet_amount);
                }
            }
        });

        JButton temp11 = new JButton("0");
        temp11.setContentAreaFilled(true);
        temp11.setOpaque(true);
        temp11.setBorderPainted(true);
        temp11.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        temp11.setForeground(Color.WHITE);
        temp11.setBackground(new Color(53, 101, 77));
        temp11.setPreferredSize(new Dimension(75, 125));
        p15.add(temp11);
        p15.setBounds(9, 174, 75, 125);
        p15.setVisible(true);
        temp11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e11) {
                String choice11 = e11.getActionCommand();
                System.out.println("You have clicked button " + choice11);
                bet_numbers.add(choice11);
                map.put(choice11, choice11);
                bet_buttons.add(choice11);
                if (total_money <= max_amount-bet_amount) {
                    total_money+=bet_amount;
                    allBets.add(bet_amount);
                }
            }
        });

        JButton temp12 = new JButton("2 to 1");
        temp12.setContentAreaFilled(true);
        temp12.setOpaque(true);
        temp12.setBorderPainted(true);
        temp12.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        temp12.setForeground(Color.WHITE);
        temp12.setBackground(new Color(53, 101, 77));
        temp12.setPreferredSize(new Dimension(75, 75));
        p16.add(temp12);
        p16.setBounds(1090, 46, 75, 75);
        p16.setVisible(true);
        temp12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e12) {
                String choice12 = e12.getActionCommand();
                System.out.println("You have clicked button " + choice12);
                for (int i = 0; i < 12; i++) {
                    bet_numbers.add(board[0][i]);
                    map.put(board[0][i], "2 to 1");
                    bet_buttons.add("2 to 1");
                    if (total_money <= max_amount-bet_amount) {
                        total_money+=bet_amount;
                        allBets.add(bet_amount);
                    }
                }
            }
        });

        JButton temp13 = new JButton("2 to 1");
        temp13.setContentAreaFilled(true);
        temp13.setOpaque(true);
        temp13.setBorderPainted(true);
        temp13.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        temp13.setForeground(Color.WHITE);
        temp13.setBackground(new Color(53, 101, 77));
        temp13.setPreferredSize(new Dimension(75, 75));
        p17.add(temp13);
        p17.setBounds(1090, 128, 75, 75);
        p17.setVisible(true);
        temp13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e13) {
                String choice13 = e13.getActionCommand();
                System.out.println("You have clicked button " + choice13);
                for (int i = 0; i < 12; i++) {
                    bet_numbers.add(board[2][i]);
                    map.put(board[0][i], "2 to 1");
                    bet_buttons.add("2 to 1");
                    if (total_money <= max_amount-bet_amount) {
                        total_money+=bet_amount;
                        allBets.add(bet_amount);
                    }
                }
            }
        });

        JButton temp14 = new JButton("2 to 1");
        temp14.setContentAreaFilled(true);
        temp14.setOpaque(true);
        temp14.setBorderPainted(true);
        temp14.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        temp14.setForeground(Color.WHITE);
        temp14.setBackground(new Color(53, 101, 77));
        temp14.setPreferredSize(new Dimension(75, 75));
        p18.add(temp14);
        p18.setBounds(1090, 211, 75, 75);
        p18.setVisible(true);
        temp14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e14) {
                String choice14 = e14.getActionCommand();
                System.out.println("You have clicked button " + choice14);
                for (int i = 0; i < 12; i++) {
                    bet_numbers.add(board[4][i]);
                    map.put(board[0][i], "2 to 1");
                    bet_buttons.add("2 to 1");
                    if (total_money <= max_amount-bet_amount) {
                        total_money+=bet_amount;
                        allBets.add(bet_amount);
                    }
                }
            }
        });

        p20.setBounds(590, 10, 100, 100);
        p20.setVisible(true);
        p20.add(new TestPane());

        mainP.add(p0);
        mainP.add(p1);
        mainP.add(p2);
        mainP.add(p3);
        mainP.add(p4);
        mainP.add(p5);
        mainP.add(p6);
        mainP.add(p7);
        mainP2.add(p8);
        mainP2.add(p9);
        mainP2.add(p10);
        mainP2.add(p11);
        mainP2.add(p12);
        mainP2.add(p13);

        lPane.add(mainP);
        lPane.add(mainP2);
        lPane.add(p14);
        lPane.add(p15);
        lPane.add(p16);
        lPane.add(p17);
        lPane.add(p18);
        //lPane.add(p19);
        lPane.add(p20);
        f.setContentPane(lPane);

        lPane.setVisible(true);
        f.setVisible(true);
    }

    public class TestPane extends JPanel {
        private Timer timer;
        private long startTime = -1;
        private long duration = 30000;

        private JLabel label;

        public TestPane() {
            setLayout(new GridBagLayout());
            setBackground(new Color(53, 101, 77));
            label = new JLabel("WAIT");
            label.setForeground(Color.WHITE);
            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (startTime < 0) {
                        startTime = System.currentTimeMillis();
                    }
                    long now = System.currentTimeMillis();
                    long clockTime = now - startTime;
                    if (clockTime >= duration) {
                        clockTime = duration;
                        timer.stop();
                        label.setText("ALL BETS ARE OVER");
                        try {
                            Thread.sleep(3000);
                        }
                        catch (InterruptedException exc) {
                            exc.printStackTrace();
                        }
                        lPane.removeAll();
                        lPane.revalidate();
                        lPane.repaint();
                        if (map.containsKey(ball)) {
                            for (int i = 0; i < bet_numbers.size(); i++) {
                                if (bet_numbers.get(i).equals(ball)) {
                                    type.add(bet_buttons.get(i));
                                    payout.add(bet_amount);
                                }
                            }
                            //System.out.println(type);
                            
                            int money_hold = bank;
                            int convert;
                            for (int j = 0; j < payout.size(); j++) {
                                if (type.get(j).equals("2 to 1")) {
                                    bank += (payout.get(j) + (payout.get(j)*2));
                                }
                                else if (type.get(j).length() == 6 && type.get(j).substring(4).equals("12")) {
                                    bank += (payout.get(j) + (payout.get(j)*2));
                                }
                                else if (type.get(j).equals("ODD") || type.get(j).equals("EVEN")) {
                                    bank += (payout.get(j) + payout.get(j));
                                }
                                else if (type.get(j).equals("1-18") || type.get(j).equals("19-36")) {
                                    bank += (payout.get(j) + payout.get(j));
                                }
                                else if (type.get(j).equals("BLACK") || type.get(j).equals("RED")) {
                                    bank += (payout.get(j) + payout.get(j));
                                }

                                try {
                                    if (type.get(j).length() <= 3 && !(type.get(j).equals("RED")) && !(type.get(j).equals("ODD"))) {
                                        convert = Integer.parseInt(type.get(j));
                                        if (convert < 100) {
                                            bank += (payout.get(j) + (payout.get(j)*35));
                                        }
                                        else if (convert >= 100 && convert < 212) {
                                            bank += (payout.get(j) + (payout.get(j)*17));
                                        }
                                        else if (convert >= 300 && convert < 312) {
                                            bank += (payout.get(j) + (payout.get(j)*11));
                                        }
                                        else if ((convert >= 400 && convert < 412) || (convert >= 600 && convert < 612) || (convert >= 800 && convert < 812)) {
                                            bank += (payout.get(j) + (payout.get(j)*17));
                                        }
                                        else if (convert == 500 || convert == 700) {
                                            bank += (payout.get(j) + (payout.get(j)*11));
                                        }
                                        else if ((convert > 500 && convert < 512) || (convert > 700 && convert < 712)) {
                                            bank += (payout.get(j) + (payout.get(j)*8));
                                        }
                                        else if (convert == 900) {
                                            bank += (payout.get(j) + (payout.get(j)*6));
                                        }
                                        else if (convert > 900 && convert < 912) {
                                            bank += (payout.get(j) + (payout.get(j)*5));
                                        }
                                    }
                                }
                                catch (NumberFormatException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            
                            System.out.println("The Number Was " + ball + ", And You Win $" + (bank-money_hold));
                            System.out.println("Bank: $" + bank);
                            
                        }
                        else {
                            System.out.println("YOU LOSE");
                        }
                    }
                    SimpleDateFormat df = new SimpleDateFormat("ss");
                    label.setText(df.format(duration - clockTime));
                }
            });
            timer.setInitialDelay(2000);
            timer.start();
            add(label);
        }
    }
}
