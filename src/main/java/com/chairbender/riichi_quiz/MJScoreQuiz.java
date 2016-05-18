package com.chairbender.riichi_quiz;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MJScoreQuiz extends JFrame implements KeyListener, ActionListener, MouseListener, FocusListener, WindowListener {
    private static final int HAND_OFFSET_Y = 30;
    protected ImageIcon[] tileImages;
    int numHands;
    int numCorFu;
    int numCorHan;
    int numCorPay;
    int roundWind;
    int seatWind;
    int ronWind;
    int waitType;
    boolean isRiichi;
    boolean isClosed;
    boolean isYakuman;
    boolean isDebugMode;
    boolean isDebugYakuman;
    int handFu;
    int handHan;
    int handPayKo;
    int handPayOya;
    int numDora;
    int numClosedTiles;
    int numOpenTiles;
    int curOpenTile;
    int numKans;
    int agariHai;
    String answerString;
    String answerString2;
    boolean isRyanmen;
    boolean isChecked;
    int numYakuman;
    int unroundedFu;
    int basePay;
    int honItsu;
    boolean isMeldPossible;
    boolean isJantouSet;
    int curMeld;
    int numMelds;
    int forceKans;
    int forceAnKous;
    int forceMinKous;
    int sanityCheck;
    int meldPointer;
    boolean isDebugSpecific;
    boolean isMassDebug;
    int debugPointer;
    boolean isError;
    boolean isInfure;
    int totalHan;
    int[] meldTile;
    int[] meldType;
    int[] meldClose;
    boolean[] isMeldChecked;
    int[] handTiles;
    int[] handClosedTiles;
    int[] handOpenTiles;
    int[] handOpenDisp;
    int[] closedKans;
    int[] doraTiles;
    int[] minMelds;
    String[] yakuStrings;
    String[] yakumanStrings;
    boolean[] handYaku;
    boolean[] compatibleYaku;
    boolean[] legalTiles;
    final int NUM_YAKU = 23;
    final int NUM_YAKUMAN = 15;
    int layouty;
    int layoutx;
    int dorax;
    int doray;
    int arrayPointer;
    JLabel titleLabel;
    JLabel roundLabel;
    JTextField roundField;
    JLabel seatLabel;
    JTextField seatField;
    JTextField riichiField;
    JLabel doraLabel;
    JLabel uraLabel;
    JLabel fuLabel;
    JTextField fuEntry;
    JTextField fuAnswer;
    JLabel hanLabel;
    JTextField hanEntry;
    JTextField hanAnswer;
    JCheckBox yakumanBox;
    JLabel payLabel;
    JLabel payLabel2;
    JTextField koEntry;
    JTextField koAnswer;
    JTextField oyaEntry;
    JTextField oyaAnswer;
    JButton submitButton;
    JButton dealButton;
    JLabel corLabel;
    JLabel corFuLabel;
    JLabel corHanLabel;
    JLabel corPayLabel;
    JTextField corField;
    JTextField corFuField;
    JTextField corHanField;
    JTextField corPayField;
    JTextArea fuList;
    JTextArea hanList;
    JCheckBox infureBox;

    public static void main(String[] args) {
        MJScoreQuiz mjScoreQuiz = new MJScoreQuiz();
        mjScoreQuiz.setSize(700, 460);
        mjScoreQuiz.setVisible(true);
        mjScoreQuiz.setResizable(false);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public MJScoreQuiz() {
        this.addWindowListener(this);
        this.setLayout(null);
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        this.setBackground(Color.WHITE);
        this.titleLabel = new JLabel("Mahjong Scoring Quiz");
        this.roundLabel = new JLabel("Round wind");
        this.roundField = new JTextField(1);
        this.roundField.setEditable(false);
        this.seatLabel = new JLabel("Seat wind");
        this.seatField = new JTextField(1);
        this.seatField.setEditable(false);
        this.riichiField = new JTextField(21);
        this.riichiField.setEditable(false);
        this.doraLabel = new JLabel("Dora indicators");
        this.uraLabel = new JLabel("Uradora indicators");
        this.fuLabel = new JLabel("Fu");
        this.fuEntry = new JTextField(3);
        this.fuAnswer = new JTextField(3);
        this.fuAnswer.setEditable(false);
        this.hanLabel = new JLabel("Han");
        this.hanEntry = new JTextField(3);
        this.hanAnswer = new JTextField(3);
        this.hanAnswer.setEditable(false);
        this.yakumanBox = new JCheckBox("Yakuman");
        this.yakumanBox.setActionCommand("Yakuman");
        this.yakumanBox.addActionListener(this);
        this.payLabel = new JLabel("Payment");
        this.payLabel2 = new JLabel("(Non-dealer, Dealer)");
        this.koEntry = new JTextField(6);
        this.koAnswer = new JTextField(6);
        this.koAnswer.setEditable(false);
        this.oyaEntry = new JTextField(6);
        this.oyaAnswer = new JTextField(6);
        this.oyaAnswer.setEditable(false);
        this.submitButton = new JButton("Submit");
        this.submitButton.setActionCommand("Check");
        this.submitButton.addActionListener(this);
        this.dealButton = new JButton("New hand");
        this.dealButton.setActionCommand("New");
        this.dealButton.addActionListener(this);
        this.corLabel = new JLabel("Total hands");
        this.corFuLabel = new JLabel("Correct fu");
        this.corHanLabel = new JLabel("Correct han");
        this.corPayLabel = new JLabel("Correct payments");
        this.corField = new JTextField(3);
        this.corField.setEditable(false);
        this.corFuField = new JTextField(3);
        this.corFuField.setEditable(false);
        this.corHanField = new JTextField(3);
        this.corHanField.setEditable(false);
        this.corPayField = new JTextField(3);
        this.corPayField.setEditable(false);
        this.fuList = new JTextArea(10, 18);
        this.fuList.setEditable(false);
        this.hanList = new JTextArea(10, 25);
        this.hanList.setEditable(false);
        this.infureBox = new JCheckBox("More small hands");
        this.infureBox.setActionCommand("Infure");
        this.infureBox.addActionListener(this);
        this.riichiField.addKeyListener(this);
        this.hanEntry.addFocusListener(this);
        this.addMouseListener(this);
        this.layouty = 0;
        this.layoutx = 5;
        this.add(this.titleLabel);
        Dimension dim = this.titleLabel.getPreferredSize();
        this.titleLabel.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx = 5;
        this.layouty += dim.height + 5;
        this.doray = this.layouty+25;
        this.add(this.roundLabel);
        dim = this.roundLabel.getPreferredSize();
        this.roundLabel.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.roundField);
        dim = this.roundField.getPreferredSize();
        this.roundField.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.seatLabel);
        dim = this.seatLabel.getPreferredSize();
        this.seatLabel.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.seatField);
        dim = this.seatField.getPreferredSize();
        this.seatField.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx = 5;
        this.layouty += dim.height+5;
        this.add(this.riichiField);
        dim = this.riichiField.getPreferredSize();
        this.riichiField.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx += dim.width + 20;
        this.layouty = 0;
        this.dorax = this.layoutx;
        this.add(this.doraLabel);
        dim = this.doraLabel.getPreferredSize();
        this.doraLabel.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx += 165;
        this.add(this.uraLabel);
        dim = this.uraLabel.getPreferredSize();
        this.uraLabel.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layouty = 185;
        this.layoutx = 5;
        this.add(this.fuLabel);
        dim = this.fuLabel.getPreferredSize();
        this.fuLabel.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.fuEntry);
        this.add(this.fuAnswer);
        dim = this.fuEntry.getPreferredSize();
        this.fuEntry.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.fuAnswer.setBounds(this.layoutx, this.layouty + dim.height + 5, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.hanLabel);
        dim = this.hanLabel.getPreferredSize();
        this.hanLabel.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.hanEntry);
        this.add(this.hanAnswer);
        dim = this.hanEntry.getPreferredSize();
        this.hanEntry.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.hanAnswer.setBounds(this.layoutx, this.layouty + dim.height + 5, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.yakumanBox);
        dim = this.yakumanBox.getPreferredSize();
        this.yakumanBox.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.payLabel);
        dim = this.payLabel.getPreferredSize();
        this.payLabel.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.add(this.payLabel2);
        dim = this.payLabel2.getPreferredSize();
        this.payLabel2.setBounds(this.layoutx, this.layouty + dim.height + 5, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.koEntry);
        this.add(this.koAnswer);
        dim = this.koEntry.getPreferredSize();
        this.koEntry.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.koAnswer.setBounds(this.layoutx, this.layouty + dim.height + 5, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.oyaEntry);
        this.add(this.oyaAnswer);
        dim = this.oyaEntry.getPreferredSize();
        this.oyaEntry.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.oyaAnswer.setBounds(this.layoutx, this.layouty + dim.height + 5, dim.width, dim.height);
        this.layouty += 2 * (dim.height + 10);
        this.layoutx = 5;
        this.add(this.submitButton);
        dim = this.submitButton.getPreferredSize();
        this.submitButton.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.dealButton);
        dim = this.dealButton.getPreferredSize();
        this.dealButton.setBounds(this.layoutx, this.layouty, dim.width, dim.height);
        this.layoutx += dim.width;
        this.layouty += dim.height + 10;
        this.add(this.corLabel);
        dim = this.corLabel.getPreferredSize();
        this.corLabel.setBounds(5, this.layouty, dim.width, dim.height);
        this.add(this.corField);
        dim = this.corField.getPreferredSize();
        this.corField.setBounds(this.layoutx - dim.width, this.layouty, dim.width, dim.height);
        this.layouty += dim.height + 10;
        this.add(this.corFuLabel);
        dim = this.corFuLabel.getPreferredSize();
        this.corFuLabel.setBounds(5, this.layouty, dim.width, dim.height);
        this.add(this.corFuField);
        dim = this.corFuField.getPreferredSize();
        this.corFuField.setBounds(this.layoutx - dim.width, this.layouty, dim.width, dim.height);
        this.layouty += dim.height + 10;
        this.add(this.corHanLabel);
        dim = this.corHanLabel.getPreferredSize();
        this.corHanLabel.setBounds(5, this.layouty, dim.width, dim.height);
        this.add(this.corHanField);
        dim = this.corHanField.getPreferredSize();
        this.corHanField.setBounds(this.layoutx - dim.width, this.layouty, dim.width, dim.height);
        this.layouty += dim.height + 10;
        this.add(this.corPayLabel);
        dim = this.corPayLabel.getPreferredSize();
        this.corPayLabel.setBounds(5, this.layouty, dim.width, dim.height);
        this.add(this.corPayField);
        dim = this.corPayField.getPreferredSize();
        this.corPayField.setBounds(this.layoutx - dim.width, this.layouty, dim.width, dim.height);
        this.layouty += dim.height + 10;
        this.add(this.infureBox);
        dim = this.infureBox.getPreferredSize();
        this.infureBox.setBounds(5, this.layouty, dim.width, dim.height);
        this.layouty -= dim.height + 10 + 3 * (this.corPayField.getPreferredSize().height + 10) + this.dealButton.getPreferredSize().height + 10;
        this.add(this.hanList);
        dim = this.hanList.getPreferredSize();
        this.hanList.setBounds(this.layoutx + 10, this.layouty, dim.width, dim.height);
        this.layoutx += dim.width + 10;
        this.add(this.fuList);
        dim = this.fuList.getPreferredSize();
        this.fuList.setBounds(this.layoutx + 10, this.layouty, dim.width, dim.height);
        this.tileImages = new ImageIcon[35];
        this.arrayPointer = 0;
        int imageLoadStatus = 0;

        int i;
        for(i = 1; i <= 9; ++i) {
            this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/man" + i + ".gif"));
            ++this.arrayPointer;
            ++imageLoadStatus;
        }

        for(i = 1; i <= 9; ++i) {
            this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/pin" + i + ".gif"));
            ++this.arrayPointer;
            ++imageLoadStatus;
        }

        for(i = 1; i <= 9; ++i) {
            this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/sou" + i + ".gif"));
            ++this.arrayPointer;
            ++imageLoadStatus;
        }

        this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/haku.gif"));
        ++this.arrayPointer;
        ++imageLoadStatus;
        this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/hatsu.gif"));
        ++this.arrayPointer;
        ++imageLoadStatus;
        this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/chun.gif"));
        ++this.arrayPointer;
        ++imageLoadStatus;
        this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/ton.gif"));
        ++this.arrayPointer;
        ++imageLoadStatus;
        this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/nan.gif"));
        ++this.arrayPointer;
        ++imageLoadStatus;
        this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/sha.gif"));
        ++this.arrayPointer;
        ++imageLoadStatus;
        this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/pei.gif"));
        ++this.arrayPointer;
        ++imageLoadStatus;
        this.tileImages[this.arrayPointer] = new ImageIcon(getClass().getClassLoader().getResource("images/tiles/back.gif"));
        ++imageLoadStatus;
        this.handTiles = new int[34];
        this.handClosedTiles = new int[34];
        this.handOpenTiles = new int[34];
        this.handOpenDisp = new int[16];
        this.closedKans = new int[4];
        this.doraTiles = new int[8];
        this.minMelds = new int[19];
        this.meldType = new int[5];
        this.meldTile = new int[5];
        this.meldClose = new int[5];
        this.isMeldChecked = new boolean[5];
        this.handYaku = new boolean[23];
        this.compatibleYaku = new boolean[23];
        this.legalTiles = new boolean[34];
        this.isDebugMode = this.isDebugYakuman = this.isDebugSpecific = this.isMassDebug = false;
        this.isInfure = true;
        this.sanityCheck = this.debugPointer = 0;
        this.numHands = 1;
        this.numCorHan = this.numCorFu = this.numCorPay = 0;
        this.yakuStrings = new String[23];
        this.yakuStrings[0] = "Riichi";
        this.yakuStrings[1] = "Tsumo";
        this.yakuStrings[2] = "Round wind";
        this.yakuStrings[3] = "Seat wind";
        this.yakuStrings[4] = "Yakuhai";
        this.yakuStrings[5] = "Tanyao";
        this.yakuStrings[6] = "Pinfu";
        this.yakuStrings[7] = "Iipeikou";
        this.yakuStrings[8] = "Chanta";
        this.yakuStrings[9] = "Ittsu";
        this.yakuStrings[10] = "Sanshoku";
        this.yakuStrings[11] = "Sanshoko doukou";
        this.yakuStrings[12] = "Open riichi";
        this.yakuStrings[13] = "San kantsu";
        this.yakuStrings[14] = "Toitoi";
        this.yakuStrings[15] = "San ankou";
        this.yakuStrings[16] = "Shousangen";
        this.yakuStrings[17] = "Honroutou";
        this.yakuStrings[18] = "Chiitoitsu";
        this.yakuStrings[19] = "Junchan";
        this.yakuStrings[20] = "Honitsu";
        this.yakuStrings[21] = "Ryanpeikou";
        this.yakuStrings[22] = "Chinitsu";
        this.yakumanStrings = new String[15];
        this.yakumanStrings[0] = "Daisangen";
        this.yakumanStrings[1] = "Suu ankou";
        this.yakumanStrings[2] = "Suu ankou tanki wait";
        this.yakumanStrings[3] = "Tsuuiisou";
        this.yakumanStrings[4] = "Ryuuiisou";
        this.yakumanStrings[5] = "Daisharin";
        this.yakumanStrings[6] = "Chinroutou";
        this.yakumanStrings[7] = "Kokushi musou";
        this.yakumanStrings[8] = "Kokushi musou 13-sided wait";
        this.yakumanStrings[9] = "Shousuushi";
        this.yakumanStrings[10] = "Daisuushi";
        this.yakumanStrings[11] = "Suu kantsu";
        this.yakumanStrings[12] = "Chuuren poutou";
        this.yakumanStrings[13] = "Junsei chuuren poutou";
        this.yakumanStrings[14] = "Open riichi, win by Ron";
        this.newHand();
        if(!this.isError) {
            this.hanList.setText("Thanks to UmaiKeiki on \n#mahjong who wrote the applet \nthat this was created from.");
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        int drawX = 10;
        this.numClosedTiles = 0;

        int i;
        for(i = 0; i < this.handClosedTiles.length; ++i) {
            this.numClosedTiles += this.handClosedTiles[i];
        }

        for(i = 0; i < this.closedKans.length; ++i) {
            if(this.closedKans[i] > -1) {
                this.numClosedTiles += 4;
            }
        }

        if(!this.handYaku[12]) {
            g.setColor(Color.BLACK);
            g.fillRect(5, 100 + HAND_OFFSET_Y, 5 + 35 * this.numClosedTiles, 75);
            g.setColor(Color.WHITE);
            g.drawString("Closed", 10, 115 + HAND_OFFSET_Y);
        } else {
            g.setColor(Color.BLACK);
            g.drawRect(5, 100 + HAND_OFFSET_Y, 5 + 35 * this.numClosedTiles, 75);
            g.drawString("Open", 10, 115 + HAND_OFFSET_Y);
        }

        for(i = 0; i < this.handClosedTiles.length; ++i) {
            if(this.handClosedTiles[i] > 0) {
                for(int j = 0; j < this.handClosedTiles[i]; ++j) {
                    this.tileImages[i].paintIcon(this, g, drawX, 126 + HAND_OFFSET_Y);
                    drawX += 35;
                }
            }
        }

        for(i = 0; i < this.closedKans.length; ++i) {
            if(this.closedKans[i] > -1) {
                this.tileImages[34].paintIcon(this, g, drawX, 126 + HAND_OFFSET_Y);
                drawX += 35;
                this.tileImages[this.closedKans[i]].paintIcon(this, g, drawX, 126 + HAND_OFFSET_Y);
                drawX += 35;
                this.tileImages[this.closedKans[i]].paintIcon(this, g, drawX, 126 + HAND_OFFSET_Y);
                drawX += 35;
                this.tileImages[34].paintIcon(this, g, drawX, 126 + HAND_OFFSET_Y);
                drawX += 35;
            }
        }

        if(this.numOpenTiles > 0) {
            g.setColor(Color.BLACK);
            drawX = 15 + 35 * this.numClosedTiles;
            g.drawRect(drawX, 100 + HAND_OFFSET_Y, 5 + 35 * this.numOpenTiles, 75);
            drawX += 5;
            g.drawString("Open", drawX, 115 + HAND_OFFSET_Y);

            for(i = 0; i < this.numOpenTiles; ++i) {
                this.tileImages[this.handOpenDisp[i]].paintIcon(this, g, drawX, 126 + HAND_OFFSET_Y);
                drawX += 35;
            }
        }

        g.setColor(Color.BLACK);
        drawX = 35 * (this.numOpenTiles + this.numClosedTiles) + 20;
        if(this.numOpenTiles > 0) {
            drawX += 10;
        }

        if(this.ronWind == 4) {
            g.fillRect(drawX, 100 + HAND_OFFSET_Y, 90, 75);
            g.setColor(Color.WHITE);
            g.drawString("Tsumo", drawX + 5, 115 + HAND_OFFSET_Y);
            g.setColor(Color.BLACK);
        } else {
            g.drawRect(drawX, 100 + HAND_OFFSET_Y, 90, 75);
            g.drawString("Ron (" + this.getWindString(this.ronWind) + ")", drawX + 5, 115 + HAND_OFFSET_Y);
        }

        this.tileImages[this.agariHai].paintIcon(this, g, drawX + 30, 126 + HAND_OFFSET_Y);
        g.drawRect(this.dorax, this.doray, 155, 59);
        g.drawRect(this.dorax + 165, this.doray, 155, 59);

        for(i = 0; i < 4; ++i) {
            if(this.doraTiles[i] > -1) {
                this.tileImages[this.doraTiles[i]].paintIcon(this, g, this.dorax + 10 + 35 * i, this.doray + 10);
            }
        }

        for(i = 4; i < 8; ++i) {
            if(this.doraTiles[i] > -1) {
                this.tileImages[this.doraTiles[i]].paintIcon(this, g, this.dorax + 175 + 35 * (i - 4), this.doray + 10);
            }
        }

    }

    public int rand(int range) {
        return (int)(Math.random() * (double)range);
    }

    public void newHand() {
        this.fuEntry.setText("0");
        this.fuEntry.setForeground(Color.BLACK);
        this.hanEntry.setText("0");
        this.hanEntry.setForeground(Color.BLACK);
        this.fuEntry.setEnabled(true);
        this.hanEntry.setEnabled(true);
        this.koEntry.setText("0");
        this.koEntry.setForeground(Color.BLACK);
        this.oyaEntry.setText("0");
        this.oyaEntry.setForeground(Color.BLACK);
        this.yakumanBox.setSelected(false);
        this.yakumanBox.setForeground(Color.BLACK);
        this.fuAnswer.setText("");
        this.hanAnswer.setText("");
        this.koAnswer.setText("");
        this.oyaAnswer.setText("");
        this.riichiField.setText("");
        this.fuList.setText("");
        this.hanList.setText("");
        this.hanList.setForeground(Color.BLACK);
        this.answerString = "";
        this.answerString2 = "";
        this.corField.setText(Integer.toString(this.numHands));
        this.corFuField.setText(Integer.toString(this.numCorFu));
        this.corHanField.setText(Integer.toString(this.numCorHan));
        this.corPayField.setText(Integer.toString(this.numCorPay));

        int i;
        for(i = 0; i < this.handTiles.length; ++i) {
            this.handTiles[i] = 0;
        }

        for(i = 0; i < this.handOpenTiles.length; ++i) {
            this.handOpenTiles[i] = 0;
        }

        for(i = 0; i < this.handOpenDisp.length; ++i) {
            this.handOpenDisp[i] = -1;
        }

        for(i = 0; i < this.handClosedTiles.length; ++i) {
            this.handClosedTiles[i] = 0;
        }

        for(i = 0; i < this.doraTiles.length; ++i) {
            this.doraTiles[i] = -1;
        }

        for(i = 0; i < this.closedKans.length; ++i) {
            this.closedKans[i] = -1;
        }

        for(i = 0; i < this.minMelds.length; ++i) {
            this.minMelds[i] = 0;
        }

        for(i = 0; i < this.meldTile.length; ++i) {
            this.meldTile[i] = 0;
        }

        for(i = 0; i < this.meldType.length; ++i) {
            this.meldType[i] = 3;
        }

        for(i = 0; i < this.meldClose.length; ++i) {
            this.meldClose[i] = 0;
        }

        for(i = 0; i < this.isMeldChecked.length; ++i) {
            this.isMeldChecked[i] = false;
        }

        for(i = 0; i < this.handYaku.length; ++i) {
            this.handYaku[i] = false;
        }

        for(i = 0; i < this.compatibleYaku.length; ++i) {
            this.compatibleYaku[i] = true;
        }

        for(i = 0; i < this.legalTiles.length; ++i) {
            this.legalTiles[i] = true;
        }

        this.honItsu = -1;
        this.agariHai = -1;
        this.curOpenTile = 0;
        this.numKans = 0;
        this.waitType = 0;
        this.isClosed = false;
        this.isRiichi = false;
        this.isRyanmen = false;
        this.curMeld = 4;
        this.numMelds = 0;
        this.isJantouSet = false;
        this.forceKans = 0;
        this.forceAnKous = 0;
        this.forceMinKous = 0;
        this.meldPointer = 0;
        this.numYakuman = 0;
        this.unroundedFu = 0;
        this.handHan = this.handFu = this.handPayKo = this.handPayOya = 0;
        this.numDora = 0;
        this.basePay = 0;
        this.isChecked = false;
        this.isError = false;
        if(this.rand(50) == 1) {
            this.roundWind = 3;
        } else if(this.rand(15) == 1) {
            this.roundWind = 2;
        } else if(this.rand(2) == 1) {
            this.roundWind = 1;
        } else {
            this.roundWind = 0;
        }

        this.seatWind = this.rand(4);
        this.ronWind = this.seatWind;
        this.roundField.setText(this.getWindString(this.roundWind));
        this.seatField.setText(this.getWindString(this.seatWind));
        this.seatField.setCaretPosition(0);
        this.roundField.setCaretPosition(0);
        if(this.isDebugMode) {
            this.isDebugMode = false;
            if(this.isDebugYakuman) {
                if(!this.isMassDebug) {
                    this.isDebugYakuman = false;
                }

                this.addYakuman(this.debugPointer);
            } else if(this.isDebugSpecific) {
                this.isDebugSpecific = false;
                this.addYakuman(1337);
            } else {
                this.addYaku(this.debugPointer);
            }
        } else if(this.isInfure) {
            if(this.rand(10) == 1) {
                this.addYakuman(this.rand(15));
            } else {
                this.addYaku(this.rand(23));
            }
        } else {
            this.compatibleYaku[17] = this.compatibleYaku[16] = this.compatibleYaku[22] = false;

            do {
                this.arrayPointer = this.rand(23);
            } while(!this.compatibleYaku[this.arrayPointer]);

            this.addYaku(this.arrayPointer);
        }

        if(this.isRiichi) {
            this.riichiField.setText("Riichi declared");
        }

        this.addHandTiles();
        this.setWaits();
        this.numOpenTiles = 0;

        for(i = 0; i < this.handOpenTiles.length; ++i) {
            this.numOpenTiles += this.handOpenTiles[i];
        }

        if(this.numOpenTiles == 0) {
            this.isClosed = true;
        } else {
            this.isClosed = false;
        }

        if(!this.isClosed && this.rand(3) == 1) {
            this.ronWind = 4;
        }

        if(this.ronWind == this.seatWind) {
            do {
                this.ronWind = this.rand(4);
            } while(this.ronWind == this.seatWind);
        }

        this.addDora();
        this.countYakuman();
        this.isYakuman = this.numYakuman > 0;

        for(i = 0; i < this.handYaku.length; ++i) {
            if(i == 12) {
                ++i;
            }

            this.handYaku[i] = false;
        }

        if(!this.isYakuman) {
            this.countYaku();
            this.countHan();
            this.totalHan += this.handHan;
            this.countFu();
        }

        this.countPayments();
        this.arrayPointer = 0;
        this.repaint();
    }

    public String getWindString(int w) {
        switch(w) {
            case 0:
                return "東";
            case 1:
                return "南";
            case 2:
                return "西";
            case 3:
                return "北";
            default:
                return "X";
        }
    }

    public void setLegalTiles() {
        int i;
        if(this.handYaku[5]) {
            this.legalTiles[0] = this.legalTiles[8] = this.legalTiles[9] = this.legalTiles[17] = this.legalTiles[18] = this.legalTiles[26] = false;

            for(i = 27; i < 34; ++i) {
                this.legalTiles[i] = false;
            }
        }

        int j;
        if(this.handYaku[8] || this.handYaku[19] || this.handYaku[17]) {
            for(i = 0; i < 3; ++i) {
                for(j = 1; j < 8; ++j) {
                    this.legalTiles[i * 9 + j] = false;
                }
            }
        }

        if(this.handYaku[19] || this.handYaku[22]) {
            for(i = 27; i < 34; ++i) {
                this.legalTiles[i] = false;
            }
        }

        if(this.honItsu != -1) {
            for(i = 0; i < 3; ++i) {
                if(this.honItsu != i) {
                    for(j = 0; j < 9; ++j) {
                        this.legalTiles[i * 9 + j] = false;
                    }
                }
            }
        }

    }

    public int getLegalTile() {
        this.sanityCheck = 0;

        int newTile;
        do {
            newTile = this.rand(34);
        } while(!this.sanityCheck("getLegalTile()\n") && !this.isError && !this.legalTiles[newTile]);

        return newTile;
    }

    public boolean isImpossibleSanShoku(int tile, int num) {
        return this.handTiles[tile] >= num || this.handTiles[tile + 9] >= num || this.handTiles[tile + 18] >= num;
    }

    public void addDora() {
        if(!this.isInfure && this.numKans < 3 && this.rand(6) == 1) {
            ++this.numKans;
            if(this.numKans < 3 && this.rand(6) == 1) {
                ++this.numKans;
                if(this.numKans < 3 && this.rand(6) == 1) {
                    ++this.numKans;
                }
            }
        }

        if(this.numKans > 3) {
            this.numKans = 3;
        }

        int i;
        for(i = 0; i <= this.numKans; ++i) {
            do {
                this.doraTiles[i] = this.rand(34);
            } while(this.handTiles[this.doraTiles[i]] > 3);

            ++this.handTiles[this.doraTiles[i]];
        }

        if(this.isRiichi) {
            for(i = 4; i <= 4 + this.numKans; ++i) {
                do {
                    this.doraTiles[i] = this.rand(34);
                } while(this.handTiles[this.doraTiles[i]] > 3);

                ++this.handTiles[this.doraTiles[i]];
            }
        }

        for(i = 0; i < this.doraTiles.length; ++i) {
            if(this.doraTiles[i] > -1) {
                --this.handTiles[this.doraTiles[i]];
            }
        }

        int j;
        for(i = 0; i < 27; ++i) {
            if(this.handTiles[i] > 0) {
                if(i % 9 == 0) {
                    for(j = 0; j < this.doraTiles.length; ++j) {
                        if(this.doraTiles[j] == i + 8) {
                            this.numDora += this.handTiles[i];
                        }
                    }
                } else {
                    for(j = 0; j < this.doraTiles.length; ++j) {
                        if(this.doraTiles[j] == i - 1) {
                            this.numDora += this.handTiles[i];
                        }
                    }
                }
            }
        }

        for(i = 0; i < 3; ++i) {
            if(this.handTiles[i + 27] > 0) {
                for(j = 0; j < this.doraTiles.length; ++j) {
                    if(this.doraTiles[j] - 27 == (i + 2) % 3) {
                        this.numDora += this.handTiles[i + 27];
                    }
                }
            }
        }

        for(i = 0; i < 4; ++i) {
            if(this.handTiles[i + 30] > 0) {
                for(j = 0; j < this.doraTiles.length; ++j) {
                    if(this.doraTiles[j] - 30 == (i + 3) % 4) {
                        this.numDora += this.handTiles[i + 30];
                    }
                }
            }
        }

    }

    public void addYaku(int y) {
        this.handYaku[y] = true;
        label65:
        switch(y) {
            case 0:
            default:
                this.isRiichi = this.isClosed = true;
                break;
            case 1:
                this.isClosed = true;
                this.ronWind = 4;
                if(!this.isRiichi && this.rand(2) == 1) {
                    this.addYaku(0);
                }
                break;
            case 2:
                this.compatibleYaku[5] = this.compatibleYaku[6] = this.compatibleYaku[18] = this.compatibleYaku[21] = this.compatibleYaku[19] = this.compatibleYaku[22] = false;
                break;
            case 3:
                this.compatibleYaku[5] = this.compatibleYaku[6] = this.compatibleYaku[18] = this.compatibleYaku[21] = this.compatibleYaku[22] = this.compatibleYaku[19] = false;
                break;
            case 4:
                this.compatibleYaku[5] = this.compatibleYaku[6] = this.compatibleYaku[18] = this.compatibleYaku[21] = this.compatibleYaku[22] = this.compatibleYaku[19] = this.compatibleYaku[16] = false;
                break;
            case 5:
                this.minMelds[1] = this.minMelds[7] = this.minMelds[8] = this.minMelds[9] = -1;
                this.minMelds[12] = 1;
                this.compatibleYaku[2] = this.compatibleYaku[3] = this.compatibleYaku[4] = this.compatibleYaku[8] = this.compatibleYaku[9] = this.compatibleYaku[16] = this.compatibleYaku[17] = this.compatibleYaku[19] = this.compatibleYaku[20] = false;
                break;
            case 6:
                this.isClosed = true;
                this.waitType = 2;
                this.minMelds[18] = 1;
                this.minMelds[5] = this.minMelds[6] = this.minMelds[7] = this.minMelds[8] = this.minMelds[9] = this.minMelds[10] = this.minMelds[11] = -1;
                this.compatibleYaku[2] = this.compatibleYaku[3] = this.compatibleYaku[4] = this.compatibleYaku[11] = this.compatibleYaku[13] = this.compatibleYaku[14] = this.compatibleYaku[15] = this.compatibleYaku[16] = this.compatibleYaku[17] = this.compatibleYaku[18] = false;
                if(this.rand(2) == 1) {
                    this.addYaku(0);
                }
                break;
            case 7:
                this.isClosed = true;
                this.minMelds[2] = 1;
                this.compatibleYaku[11] = this.compatibleYaku[13] = this.compatibleYaku[14] = this.compatibleYaku[15] = this.compatibleYaku[16] = this.compatibleYaku[17] = this.compatibleYaku[18] = false;
                if(this.rand(2) == 1) {
                    this.addYaku(0);
                }
                break;
            case 8:
                this.minMelds[0] = this.minMelds[6] = -1;
                this.minMelds[15] = this.minMelds[1] = 1;
                this.compatibleYaku[5] = this.compatibleYaku[6] = this.compatibleYaku[9] = this.compatibleYaku[14] = this.compatibleYaku[22] = this.compatibleYaku[17] = this.compatibleYaku[18] = false;
                break;
            case 9:
                this.minMelds[3] = 1;
                this.compatibleYaku[11] = this.compatibleYaku[13] = this.compatibleYaku[14] = this.compatibleYaku[6] = this.compatibleYaku[8] = this.compatibleYaku[10] = this.compatibleYaku[15] = this.compatibleYaku[16] = this.compatibleYaku[17] = this.compatibleYaku[18] = this.compatibleYaku[19] = this.compatibleYaku[21] = this.compatibleYaku[5] = false;
                break;
            case 10:
                this.minMelds[4] = 1;
                this.compatibleYaku[11] = this.compatibleYaku[13] = this.compatibleYaku[14] = this.compatibleYaku[9] = this.compatibleYaku[22] = this.compatibleYaku[15] = this.compatibleYaku[16] = this.compatibleYaku[17] = this.compatibleYaku[18] = this.compatibleYaku[20] = this.compatibleYaku[21] = false;
                break;
            case 11:
                this.minMelds[10] = 1;
                this.compatibleYaku[6] = this.compatibleYaku[7] = this.compatibleYaku[9] = this.compatibleYaku[10] = this.compatibleYaku[16] = this.compatibleYaku[18] = this.compatibleYaku[20] = this.compatibleYaku[21] = this.compatibleYaku[22] = false;
                break;
            case 12:
                this.isRiichi = this.isClosed = true;
                if(this.rand(4) >= 1) {
                    if(this.compatibleYaku[1]) {
                        this.addYaku(1);
                    }
                    break;
                } else {
                    while(true) {
                        this.ronWind = this.rand(4);
                        if(this.ronWind != this.seatWind) {
                            break label65;
                        }
                    }
                }
            case 13:
                this.minMelds[11] = 3;
                this.compatibleYaku[6] = this.compatibleYaku[7] = this.compatibleYaku[9] = this.compatibleYaku[10] = this.compatibleYaku[21] = this.compatibleYaku[18] = this.compatibleYaku[8] = this.compatibleYaku[19] = false;
                break;
            case 14:
                this.minMelds[0] = this.minMelds[1] = this.minMelds[2] = this.minMelds[3] = this.minMelds[4] = -1;
                this.compatibleYaku[6] = this.compatibleYaku[7] = this.compatibleYaku[9] = this.compatibleYaku[10] = this.compatibleYaku[12] = this.compatibleYaku[1] = this.compatibleYaku[21] = this.compatibleYaku[18] = this.compatibleYaku[0] = this.compatibleYaku[19] = this.compatibleYaku[8] = false;
                break;
            case 15:
                this.minMelds[5] = 3;
                this.compatibleYaku[6] = this.compatibleYaku[7] = this.compatibleYaku[9] = this.compatibleYaku[10] = this.compatibleYaku[21] = this.compatibleYaku[18] = false;
                break;
            case 16:
                this.minMelds[16] = 1;
                this.compatibleYaku[5] = this.compatibleYaku[6] = this.compatibleYaku[18] = this.compatibleYaku[9] = this.compatibleYaku[10] = this.compatibleYaku[11] = this.compatibleYaku[21] = this.compatibleYaku[19] = this.compatibleYaku[22] = this.compatibleYaku[4] = false;
                break;
            case 17:
                this.minMelds[0] = this.minMelds[6] = this.minMelds[1] = this.minMelds[2] = this.minMelds[3] = this.minMelds[4] = -1;
                this.minMelds[15] = 1;
                this.minMelds[9] = 4;
                this.compatibleYaku[5] = this.compatibleYaku[6] = this.compatibleYaku[9] = this.compatibleYaku[10] = this.compatibleYaku[0] = this.compatibleYaku[1] = this.compatibleYaku[7] = this.compatibleYaku[12] = this.compatibleYaku[22] = this.compatibleYaku[19] = this.compatibleYaku[8] = false;
                break;
            case 18:
                this.waitType = 4;
                this.compatibleYaku[2] = this.compatibleYaku[3] = this.compatibleYaku[4] = this.compatibleYaku[6] = this.compatibleYaku[7] = this.compatibleYaku[10] = this.compatibleYaku[9] = this.compatibleYaku[11] = this.compatibleYaku[13] = this.compatibleYaku[14] = this.compatibleYaku[15] = this.compatibleYaku[16] = this.compatibleYaku[21] = this.compatibleYaku[8] = this.compatibleYaku[19] = false;
                break;
            case 19:
                this.minMelds[0] = this.minMelds[6] = this.minMelds[8] = this.minMelds[9] = -1;
                this.minMelds[13] = this.minMelds[1] = 1;
                this.compatibleYaku[5] = this.compatibleYaku[16] = this.compatibleYaku[9] = this.compatibleYaku[18] = this.compatibleYaku[22] = this.compatibleYaku[20] = this.compatibleYaku[17] = this.compatibleYaku[14] = false;
                break;
            case 20:
                this.minMelds[4] = this.minMelds[10] = -1;
                this.compatibleYaku[5] = this.compatibleYaku[10] = this.compatibleYaku[11] = this.compatibleYaku[19] = this.compatibleYaku[22] = false;
                break;
            case 21:
                this.isClosed = true;
                this.minMelds[2] = 2;
                this.compatibleYaku[2] = this.compatibleYaku[3] = this.compatibleYaku[4] = this.compatibleYaku[13] = this.compatibleYaku[14] = this.compatibleYaku[15] = this.compatibleYaku[16] = this.compatibleYaku[17] = this.compatibleYaku[18] = this.compatibleYaku[9] = this.compatibleYaku[10] = this.compatibleYaku[11] = false;
                if(this.rand(2) == 1) {
                    this.addYaku(0);
                }
                break;
            case 22:
                this.minMelds[4] = this.minMelds[10] = -1;
                this.compatibleYaku[16] = this.compatibleYaku[10] = this.compatibleYaku[11] = this.compatibleYaku[2] = this.compatibleYaku[3] = this.compatibleYaku[4] = this.compatibleYaku[17] = this.compatibleYaku[19] = this.compatibleYaku[8] = false;
        }

        if(this.isInfure && this.rand(2) == 1) {
            for(int i = 0; i < 5; ++i) {
                this.arrayPointer = this.rand(23);
                if(this.compatibleYaku[this.arrayPointer]) {
                    this.addYaku(this.arrayPointer);
                    i = 5;
                }
            }
        }

    }

    public void addYakuman(int y) {
        boolean isYakumanSpecial = false;
        int i;
        switch(y) {
            case 0:
            default:
                this.addMeld(4, 27, 2);
                this.addMeld(4, 29, 2);
                this.addMeld(4, 28, 2);
                this.curMeld = 1;
                this.numMelds = 3;
                break;
            case 2:
                isYakumanSpecial = true;
            case 1:
                this.isClosed = true;
                this.forceAnKous = 4;
                this.addYaku(14);
                if(isYakumanSpecial) {
                    this.waitType = 4;
                } else {
                    this.waitType = 3;
                    this.addYaku(1);
                }
                break;
            case 3:
                this.minMelds[8] = 4;
                this.minMelds[14] = 1;
                this.addYaku(14);
                break;
            case 4:
                if(this.rand(2) == 1) {
                    this.addMeld(3, 28, 0);
                    this.isJantouSet = true;
                } else {
                    this.addMeld(4, 28, 2);
                    ++this.numMelds;
                    --this.curMeld;
                }

                while(this.numMelds < 4) {
                    this.arrayPointer = this.rand(6);
                    switch(this.arrayPointer) {
                        case 0:
                        default:
                            this.isMeldPossible = true;
                            this.isMeldPossible = this.handTiles[19] < 4 && this.handTiles[20] < 4 && this.handTiles[21] < 4;
                            if(this.isMeldPossible) {
                                this.addMeld(0, 19, 2);
                                ++this.numMelds;
                                --this.curMeld;
                            }
                            break;
                        case 1:
                            if(this.handTiles[19] <= 1) {
                                this.addMeld(4, 19, 2);
                                ++this.numMelds;
                                --this.curMeld;
                            }
                            break;
                        case 2:
                            if(this.handTiles[20] <= 1) {
                                this.addMeld(4, 20, 2);
                                ++this.numMelds;
                                --this.curMeld;
                            }
                            break;
                        case 3:
                            if(this.handTiles[21] <= 1) {
                                this.addMeld(4, 21, 2);
                                ++this.numMelds;
                                --this.curMeld;
                            }
                            break;
                        case 4:
                            if(this.handTiles[23] <= 1) {
                                this.addMeld(4, 23, 2);
                                ++this.numMelds;
                                --this.curMeld;
                            }
                            break;
                        case 5:
                            if(this.handTiles[25] <= 1) {
                                this.addMeld(4, 25, 2);
                                ++this.numMelds;
                                --this.curMeld;
                            }
                    }

                    if(this.sanityCheck("case 4:\t\t//Ryuu 1 sou\n") || this.isError) {
                        break;
                    }
                }

                if(!this.isJantouSet) {
                    for(i = 0; i < 12; ++i) {
                        this.arrayPointer = this.rand(5) + 19;
                        if(this.arrayPointer == 22) {
                            this.arrayPointer = 25;
                        }

                        if(!this.isJantouSet && this.handTiles[this.arrayPointer] <= 2) {
                            this.addMeld(3, this.arrayPointer, 0);
                            this.isJantouSet = true;
                        }
                    }
                }
                break;
            case 5:
                for(i = 0; i < 7; ++i) {
                    this.addMeld(3, 10 + i, 0);
                }

                this.curMeld = 0;
                this.numMelds = 7;
                this.isJantouSet = true;
                break;
            case 6:
                this.minMelds[7] = 4;
                this.minMelds[13] = 1;
                this.addYaku(14);
                break;
            case 8:
                isYakumanSpecial = true;
            case 7:
                this.handTiles[0] = 1;
                this.handTiles[8] = 1;
                this.handTiles[9] = 1;
                this.handTiles[17] = 1;
                this.handTiles[18] = 1;
                this.handTiles[26] = 1;
                this.handTiles[27] = 1;
                this.handTiles[28] = 1;
                this.handTiles[29] = 1;
                this.handTiles[30] = 1;
                this.handTiles[31] = 1;
                this.handTiles[32] = 1;
                this.handTiles[33] = 1;
                this.handClosedTiles[0] = 1;
                this.handClosedTiles[8] = 1;
                this.handClosedTiles[9] = 1;
                this.handClosedTiles[17] = 1;
                this.handClosedTiles[18] = 1;
                this.handClosedTiles[26] = 1;
                this.handClosedTiles[27] = 1;
                this.handClosedTiles[28] = 1;
                this.handClosedTiles[29] = 1;
                this.handClosedTiles[30] = 1;
                this.handClosedTiles[31] = 1;
                this.handClosedTiles[32] = 1;
                this.handClosedTiles[33] = 1;
                this.arrayPointer = this.rand(2);
                if(this.arrayPointer == 0) {
                    this.arrayPointer = this.rand(7) + 27;
                    ++this.handTiles[this.arrayPointer];
                } else {
                    this.arrayPointer = 8 * this.rand(2) + 9 * this.rand(3);
                    ++this.handTiles[this.arrayPointer];
                }

                if(isYakumanSpecial) {
                    this.agariHai = this.arrayPointer;
                } else {
                    ++this.handClosedTiles[this.arrayPointer];
                }

                this.curMeld = 0;
                this.numMelds = 13;
                this.isJantouSet = true;
                break;
            case 9:
                for(i = 0; i < 3; ++i) {
                    this.arrayPointer = this.rand(4) + 30;

                    for(int j = 0; j < 12; ++j) {
                        if(this.handTiles[this.arrayPointer] > 1) {
                            this.arrayPointer = this.rand(4) + 30;
                        }
                    }

                    if(this.handTiles[this.arrayPointer] <= 1) {
                        this.addMeld(4, this.arrayPointer, 2);
                        ++this.numMelds;
                        --this.curMeld;
                    }
                }

                this.minMelds[17] = 1;
                break;
            case 10:
                this.addMeld(4, 30, 2);
                this.addMeld(4, 31, 2);
                this.addMeld(4, 32, 2);
                this.addMeld(4, 33, 2);
                this.curMeld = 0;
                this.numMelds = 4;
                break;
            case 11:
                this.forceKans = 4;
                this.addYaku(14);
                break;
            case 13:
                isYakumanSpecial = true;
            case 12:
                this.honItsu = this.rand(3);
                this.handTiles[0 + 9 * this.honItsu] = 3;
                this.handTiles[1 + 9 * this.honItsu] = 1;
                this.handTiles[2 + 9 * this.honItsu] = 1;
                this.handTiles[3 + 9 * this.honItsu] = 1;
                this.handTiles[4 + 9 * this.honItsu] = 1;
                this.handTiles[5 + 9 * this.honItsu] = 1;
                this.handTiles[6 + 9 * this.honItsu] = 1;
                this.handTiles[7 + 9 * this.honItsu] = 1;
                this.handTiles[8 + 9 * this.honItsu] = 3;
                this.handClosedTiles[0 + 9 * this.honItsu] = 3;
                this.handClosedTiles[1 + 9 * this.honItsu] = 1;
                this.handClosedTiles[2 + 9 * this.honItsu] = 1;
                this.handClosedTiles[3 + 9 * this.honItsu] = 1;
                this.handClosedTiles[4 + 9 * this.honItsu] = 1;
                this.handClosedTiles[5 + 9 * this.honItsu] = 1;
                this.handClosedTiles[6 + 9 * this.honItsu] = 1;
                this.handClosedTiles[7 + 9 * this.honItsu] = 1;
                this.handClosedTiles[8 + 9 * this.honItsu] = 3;
                this.arrayPointer = this.rand(9) + 9 * this.honItsu;
                ++this.handTiles[this.arrayPointer];
                if(isYakumanSpecial) {
                    this.agariHai = this.arrayPointer;
                } else {
                    ++this.handClosedTiles[this.arrayPointer];
                }

                this.curMeld = 0;
                this.numMelds = 9;
                this.isJantouSet = true;
                break;
            case 14:
                this.compatibleYaku[1] = false;
                this.addYaku(12);
                break;
            case 1337:
                this.addMeld(1, 0, 0);
                this.addMeld(1, 1, 0);
                this.addMeld(1, 2, 0);
                this.addMeld(0, 18, 2);
                this.addMeld(3, 28, 0);
                this.curMeld = 0;
                this.numMelds = 4;
                this.isJantouSet = true;
        }

    }

    public void addHandTiles() {
        int numKouMelds = 0;

        int i;
        for(i = 5; i < 12; ++i) {
            if(this.minMelds[i] > 0) {
                numKouMelds += this.minMelds[i];
                if(i == 10) {
                    numKouMelds += 2 * this.minMelds[i];
                }
            }
        }

        if(this.handYaku[2]) {
            ++numKouMelds;
        }

        if(this.handYaku[3]) {
            ++numKouMelds;
        }

        if(this.handYaku[4]) {
            ++numKouMelds;
        }

        if(this.handYaku[16]) {
            numKouMelds += 2;
        }

        if(numKouMelds > 3) {
            ++this.forceMinKous;
        }

        this.sanityCheck = 0;

        while(numKouMelds > 4) {
            if(this.minMelds[5] >= this.minMelds[11]) {
                if(this.minMelds[5] > 0) {
                    ++this.forceAnKous;
                    --this.minMelds[5];
                }
            } else if(this.minMelds[11] > this.minMelds[5]) {
                ++this.forceKans;
                --this.minMelds[11];
            }

            --numKouMelds;
            if(this.sanityCheck("while ( numKouMelds > 4 ) {\n") || this.isError) {
                break;
            }
        }

        if(this.handYaku[2]) {
            this.addMeld(4, 30 + this.roundWind, 2);
            --this.curMeld;
            ++this.numMelds;
        }

        if(this.handYaku[3] && this.handTiles[30 + this.seatWind] < 2) {
            this.addMeld(4, 30 + this.seatWind, 2);
            --this.curMeld;
            ++this.numMelds;
        }

        if(this.handYaku[4]) {
            this.arrayPointer = this.rand(3) + 27;
            if(this.handTiles[this.arrayPointer] < 2) {
                this.addMeld(4, this.arrayPointer, 2);
                --this.curMeld;
                ++this.numMelds;
            }
        }

        if(this.handYaku[16]) {
            do {
                this.arrayPointer = this.rand(3) + 27;
            } while(!this.sanityCheck("if (handYaku[16]) {\n") && !this.isError && this.handTiles[this.arrayPointer] > 1);

            if(this.numMelds < 4) {
                this.addMeld(4, this.arrayPointer, 2);
                --this.curMeld;
                ++this.numMelds;
            }

            this.arrayPointer = this.rand(3) + 27;

            for(i = 0; i < 10; ++i) {
                if(this.handTiles[this.arrayPointer] > 1) {
                    this.arrayPointer = this.rand(3) + 27;
                }
            }

            if(this.handTiles[this.arrayPointer] < 2 && this.numMelds < 4) {
                this.addMeld(4, this.arrayPointer, 2);
                --this.curMeld;
                ++this.numMelds;
            }
        }

        if(this.handYaku[20] || this.handYaku[22]) {
            this.honItsu = this.rand(3);
        }

        this.setLegalTiles();
        if(this.handYaku[18]) {
            for(i = 0; i < 7; ++i) {
                do {
                    this.arrayPointer = this.getLegalTile();
                } while(!this.sanityCheck("if (handYaku[18]) {\n") && !this.isError && this.handTiles[this.arrayPointer] > 1);

                this.addMeld(3, this.arrayPointer, 0);
            }

            this.curMeld = 0;
            this.numMelds = 7;
            this.isJantouSet = true;
        }

        while(this.curMeld > 0) {
            for(i = 0; i < 12; ++i) {
                if(this.minMelds[i] >= this.curMeld && this.numMelds < 4) {
                    --this.minMelds[i];
                    this.verifyAndAddMeld(i);
                }
            }

            --this.curMeld;
            if(this.sanityCheck("while ( curMeld > 0 ) {\n") || this.isError) {
                break;
            }
        }

        this.minMelds[4] = this.minMelds[3] = this.minMelds[5] = -1;

        while(this.numMelds < 4) {
            this.arrayPointer = this.rand(9);
            if(this.minMelds[this.arrayPointer] >= 0) {
                this.verifyAndAddMeld(this.arrayPointer);
            }

            if(this.sanityCheck("while ( numMelds < 4 ) {\n") || this.isError) {
                break;
            }
        }

        for(i = 6; i >= 0; --i) {
            if(this.minMelds[12 + i] > 0 && !this.isJantouSet) {
                this.verifyAndAddMeld(12 + i);
            }
        }

        if(!this.isJantouSet) {
            this.sanityCheck = 0;

            do {
                this.arrayPointer = this.getLegalTile();
            } while(!this.sanityCheck("if (!isJantouSet) {\n") && !this.isError && this.handTiles[this.arrayPointer] >= 3);

            this.addMeld(3, this.arrayPointer, 0);
        }

    }

    public void verifyAndAddMeld(int type) {
        this.sanityCheck = 0;
        int temp;
        int temp4;
        int k;
        int k1;
        switch(type) {
            case 0:
            default:
                this.isMeldPossible = true;
                if(this.honItsu > -1) {
                    this.arrayPointer = 1 + this.rand(5) + 9 * this.honItsu;
                } else {
                    this.arrayPointer = 1 + this.rand(5) + 9 * this.rand(3);
                }

                for(temp = 0; temp < 9; ++temp) {
                    this.isMeldPossible = this.handTiles[this.arrayPointer] < 4 && this.handTiles[this.arrayPointer + 1] < 4 && this.handTiles[this.arrayPointer + 2] < 4;
                    if(!this.isMeldPossible) {
                        if(this.honItsu > -1) {
                            this.arrayPointer = 1 + this.rand(5) + 9 * this.honItsu;
                        } else {
                            this.arrayPointer = 1 + this.rand(5) + 9 * this.rand(3);
                        }
                    }
                }

                if(this.isMeldPossible) {
                    this.addMeld(0, this.arrayPointer, 2);
                    ++this.numMelds;
                }
                break;
            case 1:
                this.isMeldPossible = true;
                if(this.honItsu > -1) {
                    this.arrayPointer = 6 * this.rand(2) + 9 * this.honItsu;
                } else {
                    this.arrayPointer = 6 * this.rand(2) + 9 * this.rand(3);
                }

                for(temp = 0; temp < 9; ++temp) {
                    this.isMeldPossible = this.handTiles[this.arrayPointer] < 4 && this.handTiles[this.arrayPointer + 1] < 4 && this.handTiles[this.arrayPointer + 2] < 4;
                    if(!this.isMeldPossible) {
                        if(this.honItsu > -1) {
                            this.arrayPointer = 6 * this.rand(2) + 9 * this.honItsu;
                        } else {
                            this.arrayPointer = 6 * this.rand(2) + 9 * this.rand(3);
                        }
                    }
                }

                if(this.isMeldPossible) {
                    this.addMeld(0, this.arrayPointer, 2);
                    ++this.numMelds;
                }
                break;
            case 2:
                if(this.numMelds < 3) {
                    this.isMeldPossible = true;
                    if(!this.handYaku[8] && !this.handYaku[19]) {
                        if(this.handYaku[5]) {
                            if(this.honItsu > -1) {
                                this.arrayPointer = 1 + this.rand(5) + 9 * this.honItsu;
                            } else {
                                this.arrayPointer = 1 + this.rand(5) + 9 * this.rand(3);
                            }

                            for(temp = 0; temp < 9; ++temp) {
                                this.isMeldPossible = this.handTiles[this.arrayPointer] <= 2 && this.handTiles[this.arrayPointer + 1] <= 2 && this.handTiles[this.arrayPointer + 2] <= 2;
                                if(!this.isMeldPossible) {
                                    if(this.honItsu > -1) {
                                        this.arrayPointer = 1 + this.rand(5) + 9 * this.honItsu;
                                    } else {
                                        this.arrayPointer = 1 + this.rand(5) + 9 * this.rand(3);
                                    }
                                }
                            }
                        } else {
                            if(this.honItsu > -1) {
                                this.arrayPointer = this.rand(7) + 9 * this.honItsu;
                            } else {
                                this.arrayPointer = this.rand(7) + 9 * this.rand(3);
                            }

                            for(temp = 0; temp < 9; ++temp) {
                                this.isMeldPossible = this.handTiles[this.arrayPointer] <= 2 && this.handTiles[this.arrayPointer + 1] <= 2 && this.handTiles[this.arrayPointer + 2] <= 2;
                                if(!this.isMeldPossible) {
                                    if(this.honItsu > -1) {
                                        this.arrayPointer = this.rand(7) + 9 * this.honItsu;
                                    } else {
                                        this.arrayPointer = this.rand(7) + 9 * this.rand(3);
                                    }
                                }
                            }
                        }
                    } else {
                        if(this.honItsu > -1) {
                            this.arrayPointer = 6 * this.rand(2) + 9 * this.honItsu;
                        } else {
                            this.arrayPointer = 6 * this.rand(2) + 9 * this.rand(3);
                        }

                        for(temp = 0; temp < 9; ++temp) {
                            this.isMeldPossible = this.handTiles[this.arrayPointer] <= 2 && this.handTiles[this.arrayPointer + 1] <= 2 && this.handTiles[this.arrayPointer + 2] <= 2;
                            if(!this.isMeldPossible) {
                                if(this.honItsu > -1) {
                                    this.arrayPointer = 6 * this.rand(2) + 9 * this.honItsu;
                                } else {
                                    this.arrayPointer = 6 * this.rand(2) + 9 * this.rand(3);
                                }
                            }
                        }
                    }

                    if(this.isMeldPossible) {
                        this.addMeld(0, this.arrayPointer, 2);
                        this.addMeld(0, this.arrayPointer, 2);
                        this.numMelds += 2;
                    }
                }
                break;
            case 3:
                if(this.numMelds < 2) {
                    this.isMeldPossible = true;
                    if(this.honItsu > -1) {
                        for(temp = 0; temp < 9; ++temp) {
                            this.isMeldPossible = this.isMeldPossible && this.handTiles[temp + 9 * this.honItsu] < 4;
                        }
                    } else {
                        this.arrayPointer = this.rand(3);

                        for(temp = 0; temp < 3; ++temp) {
                            for(temp4 = 0; temp4 < 9; ++temp4) {
                                this.isMeldPossible = this.isMeldPossible && this.handTiles[temp4 + 9 * this.arrayPointer] < 4;
                            }

                            if(!this.isMeldPossible) {
                                this.arrayPointer = this.rand(3);
                            }
                        }
                    }

                    if(this.isMeldPossible) {
                        if(this.honItsu > -1) {
                            this.arrayPointer = this.honItsu;
                        }

                        this.addMeld(0, 0 + 9 * this.arrayPointer, 2);
                        this.addMeld(0, 3 + 9 * this.arrayPointer, 2);
                        this.addMeld(0, 6 + 9 * this.arrayPointer, 2);
                        this.numMelds += 3;
                    }
                }
                break;
            case 4:
                if(this.numMelds < 2) {
                    this.isMeldPossible = true;
                    if(!this.handYaku[8] && !this.handYaku[19]) {
                        if(this.handYaku[5]) {
                            this.arrayPointer = 1 + this.rand(5);

                            for(temp = 0; temp < 9; ++temp) {
                                this.isMeldPossible = !this.isImpossibleSanShoku(this.arrayPointer, 4) && !this.isImpossibleSanShoku(this.arrayPointer + 1, 4) && !this.isImpossibleSanShoku(this.arrayPointer + 2, 4);
                                if(!this.isMeldPossible) {
                                    this.arrayPointer = 1 + this.rand(5);
                                }
                            }
                        } else {
                            this.arrayPointer = this.rand(7);

                            for(temp = 0; temp < 9; ++temp) {
                                this.isMeldPossible = !this.isImpossibleSanShoku(this.arrayPointer, 4) && !this.isImpossibleSanShoku(this.arrayPointer + 1, 4) && !this.isImpossibleSanShoku(this.arrayPointer + 2, 4);
                                if(!this.isMeldPossible) {
                                    this.arrayPointer = this.rand(7);
                                }
                            }
                        }
                    } else {
                        this.arrayPointer = 6 * this.rand(2);

                        for(temp = 0; temp < 9; ++temp) {
                            this.isMeldPossible = !this.isImpossibleSanShoku(this.arrayPointer, 4) && !this.isImpossibleSanShoku(this.arrayPointer + 1, 4) && !this.isImpossibleSanShoku(this.arrayPointer + 2, 4);
                            if(!this.isMeldPossible) {
                                this.arrayPointer = 6 * this.rand(2);
                            }
                        }
                    }

                    if(this.isMeldPossible) {
                        this.addMeld(0, this.arrayPointer, 2);
                        this.addMeld(0, this.arrayPointer + 9, 2);
                        this.addMeld(0, this.arrayPointer + 18, 2);
                        this.numMelds += 3;
                    }
                }
                break;
            case 5:
                this.arrayPointer = this.getLegalTile();

                for(temp = 0; temp < 10; ++temp) {
                    if(this.handTiles[this.arrayPointer] >= 2) {
                        this.arrayPointer = this.getLegalTile();
                    }
                }

                if(this.handTiles[this.arrayPointer] < 2) {
                    this.addMeld(4, this.arrayPointer, 0);
                    ++this.numMelds;
                }
                break;
            case 6:
                if(this.honItsu > -1) {
                    do {
                        this.arrayPointer = 1 + this.rand(7) + 9 * this.honItsu;
                    } while(!this.sanityCheck("case 6: // Kou - Tan yao\nif (honItsu > -1) {\n") && !this.isError && this.handTiles[this.arrayPointer] >= 2);
                } else {
                    do {
                        this.arrayPointer = 1 + this.rand(7) + 9 * this.rand(3);
                    } while(!this.sanityCheck("case 6: // Kou - Tan yao\nelse\n") && !this.isError && this.handTiles[this.arrayPointer] >= 2);
                }

                this.addMeld(4, this.arrayPointer, 2);
                ++this.numMelds;
                break;
            case 7:
                if(this.honItsu > -1) {
                    temp = this.rand(2);
                    this.arrayPointer = temp * 8 + 9 * this.honItsu;
                    if(this.handTiles[this.arrayPointer] < 2) {
                        this.addMeld(4, this.arrayPointer, 2);
                        ++this.numMelds;
                    } else {
                        this.arrayPointer = (1 - temp) * 8 + 9 * this.honItsu;
                    }

                    if(this.handTiles[this.arrayPointer] < 2) {
                        this.addMeld(4, this.arrayPointer, 2);
                        ++this.numMelds;
                    }
                } else {
                    this.arrayPointer = 8 * this.rand(2) + 9 * this.rand(3);

                    for(temp = 0; temp < 9; ++temp) {
                        if(this.handTiles[this.arrayPointer] >= 2) {
                            this.arrayPointer = 8 * this.rand(2) + 9 * this.rand(3);
                        }
                    }

                    if(this.handTiles[this.arrayPointer] < 2) {
                        this.addMeld(4, this.arrayPointer, 2);
                        ++this.numMelds;
                    }
                }
                break;
            case 8:
                this.arrayPointer = this.rand(7) + 27;

                for(temp = 0; temp < 9; ++temp) {
                    if(this.handTiles[this.arrayPointer] >= 2) {
                        this.arrayPointer = this.rand(7) + 27;
                    }
                }

                if(this.handTiles[this.arrayPointer] < 2) {
                    this.addMeld(4, this.arrayPointer, 2);
                    ++this.numMelds;
                }
                break;
            case 9:
                if(this.honItsu > -1) {
                    temp = this.rand(9);
                    if(temp != 0 && temp != 1) {
                        this.arrayPointer = temp + 25;
                    } else {
                        this.arrayPointer = temp * 8 + 9 * this.honItsu;
                    }

                    for(temp4 = 0; temp4 < 9; ++temp4) {
                        if(this.handTiles[this.arrayPointer] >= 2) {
                            temp = this.rand(9);
                            if(temp != 0 && temp != 1) {
                                this.arrayPointer = temp + 25;
                            } else {
                                this.arrayPointer = temp * 8 + 9 * this.honItsu;
                            }
                        }
                    }

                    if(this.handTiles[this.arrayPointer] < 2) {
                        this.addMeld(4, this.arrayPointer, 2);
                        ++this.numMelds;
                    }
                } else {
                    temp = this.rand(2);

                    for(temp4 = 0; temp4 < 9; ++temp4) {
                        if(temp == 0) {
                            this.arrayPointer = this.rand(7) + 27;

                            for(k = 0; k < 9; ++k) {
                                if(this.handTiles[this.arrayPointer] >= 2) {
                                    this.arrayPointer = this.rand(7) + 27;
                                }
                            }
                        } else {
                            this.arrayPointer = 8 * this.rand(2) + 9 * this.rand(3);

                            for(k = 0; k < 9; ++k) {
                                if(this.handTiles[this.arrayPointer] >= 2) {
                                    this.arrayPointer = 8 * this.rand(2) + 9 * this.rand(3);
                                }
                            }
                        }
                    }

                    if(this.handTiles[this.arrayPointer] < 2) {
                        this.addMeld(4, this.arrayPointer, 2);
                        ++this.numMelds;
                    }
                }
                break;
            case 10:
                if(this.numMelds < 2) {
                    temp4 = this.rand(2) + 1;
                    this.arrayPointer = this.rand(9);

                    for(k = 0; k < 9; ++k) {
                        if(!this.legalTiles[this.arrayPointer]) {
                            this.arrayPointer = (this.arrayPointer + temp4) % 9;
                        }
                    }

                    for(k = 0; k < 9; ++k) {
                        if(this.isImpossibleSanShoku(this.arrayPointer, 2)) {
                            this.arrayPointer = this.rand(9);

                            for(k1 = 0; k1 < 9; ++k1) {
                                if(!this.legalTiles[this.arrayPointer]) {
                                    this.arrayPointer = (this.arrayPointer + temp4) % 9;
                                }
                            }
                        }
                    }

                    if(!this.isImpossibleSanShoku(this.arrayPointer, 2) && this.legalTiles[this.arrayPointer]) {
                        this.addMeld(4, this.arrayPointer, 2);
                        this.addMeld(4, this.arrayPointer + 9, 2);
                        this.addMeld(4, this.arrayPointer + 18, 2);
                        this.numMelds += 3;
                    }
                }
                break;
            case 11:
                do {
                    this.arrayPointer = this.getLegalTile();
                } while(!this.sanityCheck("case 11:  //Kan\n") && !this.isError && this.handTiles[this.arrayPointer] >= 1);

                this.addMeld(2, this.arrayPointer, 2);
                ++this.numMelds;
                break;
            case 12:
                if(this.honItsu > -1) {
                    do {
                        this.arrayPointer = 1 + this.rand(7) + 9 * this.honItsu;
                    } while(!this.sanityCheck("case 12: //Atama - Tan yao\nif (honItsu > -1) {\n") && !this.isError && this.handTiles[this.arrayPointer] >= 3);
                } else {
                    do {
                        this.arrayPointer = 1 + this.rand(7) + 9 * this.rand(3);
                    } while(!this.sanityCheck("case 12: //Atama - Tan yao\nelse {\n") && !this.isError && this.handTiles[this.arrayPointer] >= 3);
                }

                this.addMeld(3, this.arrayPointer, 0);
                this.isJantouSet = true;
                break;
            case 13:
                if(this.honItsu > -1) {
                    temp4 = this.rand(2);
                    this.arrayPointer = temp4 * 8 + 9 * this.honItsu;
                    if(this.handTiles[this.arrayPointer] < 3) {
                        this.addMeld(3, this.arrayPointer, 0);
                        this.isJantouSet = true;
                    } else {
                        this.arrayPointer = (1 - temp4) * 8 + 9 * this.honItsu;
                    }

                    if(this.handTiles[this.arrayPointer] < 3) {
                        this.addMeld(3, this.arrayPointer, 0);
                        this.isJantouSet = true;
                    }
                } else {
                    this.arrayPointer = 8 * this.rand(2) + 9 * this.rand(3);

                    for(temp4 = 0; temp4 < 9; ++temp4) {
                        if(this.handTiles[this.arrayPointer] >= 3) {
                            this.arrayPointer = 8 * this.rand(2) + 9 * this.rand(3);
                        }
                    }

                    if(this.handTiles[this.arrayPointer] < 3) {
                        this.addMeld(3, this.arrayPointer, 0);
                        this.isJantouSet = true;
                    }
                }
                break;
            case 14:
                this.arrayPointer = this.rand(7) + 27;

                for(temp4 = 0; temp4 < 9; ++temp4) {
                    if(this.handTiles[this.arrayPointer] >= 3) {
                        this.arrayPointer = this.rand(7) + 27;
                    }
                }

                if(this.handTiles[this.arrayPointer] < 3) {
                    this.addMeld(3, this.arrayPointer, 0);
                    this.isJantouSet = true;
                }
                break;
            case 15:
                if(this.honItsu > -1) {
                    temp4 = this.rand(9);
                    if(temp4 != 0 && temp4 != 1) {
                        this.arrayPointer = temp4 + 25;
                    } else {
                        this.arrayPointer = temp4 * 8 + 9 * this.honItsu;
                    }

                    for(k = 0; k < 9; ++k) {
                        if(this.handTiles[this.arrayPointer] >= 3) {
                            temp4 = this.rand(9);
                            if(temp4 != 0 && temp4 != 1) {
                                this.arrayPointer = temp4 + 25;
                            } else {
                                this.arrayPointer = temp4 * 8 + 9 * this.honItsu;
                            }
                        }
                    }

                    if(this.handTiles[this.arrayPointer] < 3) {
                        this.addMeld(3, this.arrayPointer, 0);
                        this.isJantouSet = true;
                    }
                } else {
                    temp4 = this.rand(2);

                    for(k = 0; k < 9; ++k) {
                        if(temp4 == 0) {
                            this.arrayPointer = this.rand(7) + 27;

                            for(k1 = 0; k1 < 9; ++k1) {
                                if(this.handTiles[this.arrayPointer] >= 3) {
                                    this.arrayPointer = this.rand(7) + 27;
                                }
                            }
                        } else {
                            this.arrayPointer = 8 * this.rand(2) + 9 * this.rand(3);

                            for(k1 = 0; k1 < 9; ++k1) {
                                if(this.handTiles[this.arrayPointer] >= 3) {
                                    this.arrayPointer = 8 * this.rand(2) + 9 * this.rand(3);
                                }
                            }
                        }
                    }

                    if(this.handTiles[this.arrayPointer] < 3) {
                        this.addMeld(3, this.arrayPointer, 0);
                        this.isJantouSet = true;
                    }
                }
                break;
            case 16:
                this.arrayPointer = this.rand(3) + 27;

                for(k = 0; k < 12; ++k) {
                    if(this.handTiles[this.arrayPointer] > 2) {
                        this.arrayPointer = this.rand(3) + 27;
                    }
                }

                if(this.handTiles[this.arrayPointer] <= 2) {
                    this.addMeld(3, this.arrayPointer, 0);
                    this.isJantouSet = true;
                }
                break;
            case 17:
                this.arrayPointer = this.rand(4) + 30;

                for(k = 0; k < 12; ++k) {
                    if(this.handTiles[this.arrayPointer] > 2) {
                        this.arrayPointer = this.rand(4) + 30;
                    }
                }

                if(this.handTiles[this.arrayPointer] <= 2) {
                    this.addMeld(3, this.arrayPointer, 0);
                    this.isJantouSet = true;
                }
                break;
            case 18:
                this.arrayPointer = this.getLegalTile();

                for(k = 0; k < 20; ++k) {
                    if(this.handTiles[this.arrayPointer] >= 3) {
                        this.arrayPointer = this.getLegalTile();
                    }

                    if(this.arrayPointer >= 27) {
                        if(this.arrayPointer >= 30 + this.roundWind) {
                            this.arrayPointer = this.getLegalTile();
                        }

                        if(this.arrayPointer >= 30 + this.seatWind) {
                            this.arrayPointer = this.getLegalTile();
                        }

                        if(this.arrayPointer < 30) {
                            this.arrayPointer = this.getLegalTile();
                        }
                    }
                }

                if(this.handTiles[this.arrayPointer] < 3) {
                    this.addMeld(3, this.arrayPointer, 0);
                    this.isJantouSet = true;
                }
        }

    }

    public void addMeld(int type, int tile, int close) {
        if(close == 2) {
            close = this.rand(2);
        }

        if(this.isClosed) {
            close = 0;
        }

        if(type == 4) {
            type = 1;
            if(this.rand(4) == 1 && this.numKans < 3 && this.handTiles[tile] == 0) {
                type = 2;
            }
        }

        if(type == 2 && this.forceAnKous > 0 && close == 1) {
            close = 0;
            --this.forceAnKous;
        }

        if(type == 1) {
            if(this.forceKans > 0) {
                type = 2;
                --this.forceKans;
            }

            if(this.forceAnKous > 0 && close == 1) {
                close = 0;
                --this.forceAnKous;
            } else if(this.forceMinKous > 0 && close == 0) {
                close = 1;
                --this.forceMinKous;
                if(this.isClosed) {
                    close = 0;
                }
            }
        }

        int o;
        switch(type) {
            case 0:
                ++this.handTiles[tile];
                ++this.handTiles[tile + 1];
                ++this.handTiles[tile + 2];
                if(close == 1) {
                    ++this.handOpenTiles[tile];
                    this.handOpenDisp[this.curOpenTile] = tile;
                    ++this.curOpenTile;
                    ++this.handOpenTiles[tile + 1];
                    this.handOpenDisp[this.curOpenTile] = tile + 1;
                    ++this.curOpenTile;
                    ++this.handOpenTiles[tile + 2];
                    this.handOpenDisp[this.curOpenTile] = tile + 2;
                    ++this.curOpenTile;
                } else {
                    ++this.handClosedTiles[tile];
                    ++this.handClosedTiles[tile + 1];
                    ++this.handClosedTiles[tile + 2];
                }

                this.meldTile[this.meldPointer] = tile;
                this.meldType[this.meldPointer] = type;
                this.meldClose[this.meldPointer] = close;
                ++this.meldPointer;
                break;
            case 1:
            default:
                this.handTiles[tile] += 3;
                if(close == 1) {
                    this.handOpenTiles[tile] += 3;

                    for(o = 0; o < 3; ++o) {
                        this.handOpenDisp[this.curOpenTile] = tile;
                        ++this.curOpenTile;
                    }
                }

                if(close == 0) {
                    this.handClosedTiles[tile] += 3;
                }

                this.meldTile[this.meldPointer] = tile;
                this.meldType[this.meldPointer] = type;
                this.meldClose[this.meldPointer] = close;
                ++this.meldPointer;
                break;
            case 2:
                this.handTiles[tile] += 4;
                if(close == 1) {
                    this.handOpenTiles[tile] += 4;

                    for(o = 0; o < 4; ++o) {
                        this.handOpenDisp[this.curOpenTile] = tile;
                        ++this.curOpenTile;
                    }
                }

                if(close == 0) {
                    this.closedKans[this.numKans] = tile;
                }

                ++this.numKans;
                this.meldTile[this.meldPointer] = tile;
                this.meldType[this.meldPointer] = type;
                this.meldClose[this.meldPointer] = close;
                ++this.meldPointer;
                break;
            case 3:
                this.handTiles[tile] += 2;
                if(close == 1) {
                    this.handOpenTiles[tile] += 2;

                    for(o = 0; o < 2; ++o) {
                        this.handOpenDisp[this.curOpenTile] = tile;
                        ++this.curOpenTile;
                    }
                }

                if(close == 0) {
                    this.handClosedTiles[tile] += 2;
                }

                this.meldTile[4] = tile;
                this.meldType[4] = type;
                this.meldClose[4] = close;
        }

    }

    public void setWaits() {
        int i;
        int j;
        int k;
        for(i = 0; i <= 4; ++i) {
            if(this.meldType[i] == 0 && this.meldClose[i] == 0) {
                this.isMeldChecked[i] = true;

                for(j = 0; j <= 4; ++j) {
                    if(!this.isMeldChecked[j] && this.meldType[j] == 0 && this.meldClose[j] == 0 && this.meldTile[j] == this.meldTile[i]) {
                        this.isMeldChecked[j] = true;

                        for(k = 0; k <= 4; ++k) {
                            if(!this.isMeldChecked[k] && this.meldType[k] == 0 && this.meldClose[k] == 0 && this.meldTile[k] == this.meldTile[i] && this.meldTile[k] == this.meldTile[j]) {
                                this.isMeldChecked[k] = true;
                                this.meldType[i] = this.meldType[j] = this.meldType[k] = 1;
                                ++this.meldTile[j];
                                this.meldTile[k] += 2;
                            }
                        }
                    }
                }
            }
        }

        for(i = 0; i < this.isMeldChecked.length; ++i) {
            this.isMeldChecked[i] = false;
        }

        for(i = 0; i <= 4; ++i) {
            if(this.meldType[i] == 1 && this.meldClose[i] == 0 && this.meldTile[i] < 25 && this.meldTile[i] % 9 < 7) {
                this.isMeldChecked[i] = true;

                for(j = 0; j <= 4; ++j) {
                    if(!this.isMeldChecked[j] && this.meldType[j] == 1 && this.meldClose[j] == 0 && this.meldTile[j] == this.meldTile[i] + 1) {
                        this.isMeldChecked[j] = true;

                        for(k = 0; k <= 4; ++k) {
                            if(!this.isMeldChecked[k] && this.meldType[k] == 1 && this.meldClose[k] == 0 && this.meldTile[k] == this.meldTile[i] + 2) {
                                this.isMeldChecked[k] = true;

                                int m;
                                for(m = 0; m <= 4; ++m) {
                                    if(!this.isMeldChecked[m] && this.meldType[m] == 0 && this.meldClose[m] == 0 && this.meldTile[m] == this.meldTile[i]) {
                                        this.meldType[i] = this.meldType[j] = this.meldType[k] = 0;
                                        --this.meldTile[j];
                                        this.meldTile[k] -= 2;
                                    }
                                }

                                if(this.meldType[i] == 1) {
                                    for(m = 0; m < this.isMeldChecked.length; ++m) {
                                        this.isMeldChecked[m] = false;
                                    }

                                    this.isMeldChecked[i] = this.isMeldChecked[j] = this.isMeldChecked[k] = true;
                                    this.isMeldPossible = true;

                                    for(m = 0; m <= 4; ++m) {
                                        if(!this.isMeldChecked[m]) {
                                            if(this.meldType[m] == 0) {
                                                this.isMeldPossible = this.isMeldPossible && (this.meldTile[m] % 9 == 0 || this.meldTile[m] % 9 == 6);
                                            } else if(this.meldTile[m] < 27) {
                                                this.isMeldPossible = this.isMeldPossible && (this.meldTile[m] % 9 == 0 || this.meldTile[m] % 9 == 8);
                                            }

                                            this.isMeldPossible = this.isMeldPossible && this.meldClose[m] == 0;
                                            if(this.meldType[m] == 1) {
                                                this.isMeldPossible = false;
                                            }
                                        }
                                    }

                                    if(this.isMeldPossible) {
                                        this.meldType[i] = this.meldType[j] = this.meldType[k] = 0;
                                        --this.meldTile[j];
                                        this.meldTile[k] -= 2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for(i = 0; i < this.isMeldChecked.length; ++i) {
            this.isMeldChecked[i] = false;
        }

        if(this.numMelds == 7) {
            this.meldPointer = -1;

            for(i = 0; i < this.handClosedTiles.length - 7; ++i) {
                if(this.handClosedTiles[i] == 2 && this.handClosedTiles[i] % 9 < 7 && this.handClosedTiles[i + 1] == 2 && this.handClosedTiles[i + 2] == 2) {
                    if(this.meldPointer == -1) {
                        this.meldPointer = i;
                    } else if(i > this.meldPointer + 2) {
                        this.meldType[0] = this.meldType[1] = this.meldType[2] = this.meldType[3] = 0;
                        this.meldTile[0] = this.meldTile[1] = this.meldPointer;
                        this.meldTile[2] = this.meldTile[3] = i;
                        this.numMelds = 4;
                        i = this.handClosedTiles.length;
                    }
                }
            }

            if(this.numMelds == 4) {
                for(i = 0; i < this.handClosedTiles.length; ++i) {
                    if(this.handClosedTiles[i] == 2 && i != this.meldTile[0] && i != this.meldTile[0] + 1 && i != this.meldTile[0] + 2 && i != this.meldTile[2] && i != this.meldTile[2] + 1 && i != this.meldTile[2] + 2) {
                        this.meldTile[4] = i;
                        i = this.handClosedTiles.length;
                    }
                }
            }
        }

        if(this.agariHai == -1) {
            label398:
            switch(this.waitType) {
                case 2:
                    this.meldPointer = this.rand(4);
                    i = 0;

                    while(true) {
                        if(i >= 4) {
                            break label398;
                        }

                        if(this.meldType[this.meldPointer] == 0 && this.meldClose[this.meldPointer] == 0) {
                            i = 5;
                            if(this.meldTile[this.meldPointer] % 9 == 0) {
                                this.agariHai = this.meldTile[this.meldPointer];
                                --this.handClosedTiles[this.agariHai];
                            } else if(this.meldTile[this.meldPointer] % 9 == 6) {
                                this.agariHai = this.meldTile[this.meldPointer] + 2;
                                --this.handClosedTiles[this.agariHai];
                            } else {
                                this.agariHai = this.meldTile[this.meldPointer];
                                if(this.rand(2) == 1) {
                                    this.agariHai = this.meldTile[this.meldPointer] + 2;
                                }

                                --this.handClosedTiles[this.agariHai];
                            }
                        } else {
                            ++this.meldPointer;
                            if(this.meldPointer > 3) {
                                this.meldPointer = 0;
                            }
                        }

                        ++i;
                    }
                case 3:
                    this.meldPointer = this.rand(4);
                    i = 0;

                    while(true) {
                        if(i >= 4) {
                            break label398;
                        }

                        if(this.meldType[this.meldPointer] == 1 && this.meldClose[this.meldPointer] == 0) {
                            i = 5;
                            this.agariHai = this.meldTile[this.meldPointer];
                            --this.handClosedTiles[this.agariHai];
                        } else {
                            ++this.meldPointer;
                            if(this.meldPointer > 3) {
                                this.meldPointer = 0;
                            }
                        }

                        ++i;
                    }
                case 4:
                    this.agariHai = this.meldTile[4];
                    --this.handClosedTiles[this.agariHai];
                    break;
                default:
                    do {
                        this.agariHai = this.rand(34);
                    } while(this.handClosedTiles[this.agariHai] == 0);

                    --this.handClosedTiles[this.agariHai];
            }
        }

        if(this.agariHai == -1) {
            do {
                this.agariHai = this.rand(34);
            } while(this.handClosedTiles[this.agariHai] == 0);

            --this.handClosedTiles[this.agariHai];
            this.waitType = 0;
        }

        if(this.waitType == 0) {
            for(i = 0; i < 4; ++i) {
                if(this.meldType[i] == 0 && this.meldClose[i] == 0) {
                    if(this.meldTile[i] % 9 == 0) {
                        if(this.agariHai == this.meldTile[i]) {
                            this.waitType = 2;
                            this.isRyanmen = true;
                            i = 5;
                        }
                    } else if(this.meldTile[i] % 9 == 6) {
                        if(this.agariHai == this.meldTile[i] + 2) {
                            this.waitType = 2;
                            this.isRyanmen = true;
                            i = 5;
                        }
                    } else if(this.agariHai == this.meldTile[i] || this.agariHai == this.meldTile[i] + 2) {
                        this.waitType = 2;
                        this.isRyanmen = true;
                        i = 5;
                    }
                }
            }

            for(i = 0; i < 4; ++i) {
                if(this.meldType[i] == 1 && this.meldClose[i] == 0 && this.agariHai == this.meldTile[i]) {
                    this.waitType = 3;
                    i = 5;
                }
            }

            if(this.agariHai == this.meldTile[4]) {
                this.waitType = 4;
            }

            for(i = 0; i < 4; ++i) {
                if(this.meldType[i] == 0 && this.meldClose[i] == 0 && this.agariHai == this.meldTile[i] + 1) {
                    this.waitType = 1;
                    i = 5;
                }
            }

            for(i = 0; i < 4; ++i) {
                if(this.meldType[i] == 0 && this.meldClose[i] == 0) {
                    if(this.meldTile[i] % 9 == 0 && this.agariHai == this.meldTile[i] + 2) {
                        this.waitType = 0;
                        i = 5;
                    } else if(this.meldTile[i] % 9 == 6 && this.agariHai == this.meldTile[i]) {
                        this.waitType = 0;
                        i = 5;
                    }
                }
            }
        }

        if(this.waitType == 2 || this.waitType == 4) {
            for(i = 0; i < 4; ++i) {
                if(this.meldType[i] == 0 && this.meldClose[i] == 0) {
                    this.isMeldChecked[i] = true;
                    if(this.meldTile[i] == this.meldTile[4] - 3 && this.meldTile[4] % 9 != 0 || this.meldTile[i] == this.meldTile[4] + 1 && this.meldTile[4] % 9 != 8) {
                        for(j = 0; j <= 4; ++j) {
                            if(!this.isMeldChecked[j] && this.meldType[j] == 0 && this.meldClose[j] == 0 && this.meldTile[j] == this.meldTile[i]) {
                                this.isMeldChecked[j] = true;
                                if(this.meldTile[i] == this.meldTile[4] - 3 && this.agariHai == this.meldTile[i] || this.meldTile[i] == this.meldTile[4] + 1 && this.agariHai == this.meldTile[i] + 3) {
                                    this.isRyanmen = true;
                                    this.waitType = 4;
                                    j = 5;
                                    i = 5;
                                } else if(this.agariHai == this.meldTile[4]) {
                                    this.isRyanmen = true;
                                    this.waitType = 4;
                                    j = 5;
                                    i = 5;
                                }
                            }
                        }
                    }
                }
            }
        }

        for(i = 0; i < this.isMeldChecked.length; ++i) {
            this.isMeldChecked[i] = false;
        }

    }

    public void countFu() {
        if(this.handHan >= 5) {
            if(this.handHan < 6) {
                this.answerString2 = this.answerString2 + "Mangan\n";
            } else if(this.handHan < 8) {
                this.answerString2 = this.answerString2 + "Haneman\n";
            } else if(this.handHan < 11) {
                this.answerString2 = this.answerString2 + "Baiman\n";
            } else if(this.handHan < 13) {
                this.answerString2 = this.answerString2 + "Sanbaiman\n";
            } else {
                this.answerString2 = this.answerString2 + "Yakuman\n";
            }

        } else if(this.numMelds == 7) {
            this.handFu = this.unroundedFu = 25;
            this.answerString2 = this.answerString2 + "25 - Chiitoitsu\n";
        } else {
            this.unroundedFu = 20;
            this.answerString2 = this.answerString2 + "20 - Fuutei\n";
            if(this.isClosed && this.ronWind < 4) {
                this.unroundedFu += 10;
                this.answerString2 = this.answerString2 + "10 - Menzen ron\n";
            }

            if(this.ronWind == 4 && !this.handYaku[6]) {
                this.unroundedFu += 2;
                this.answerString2 = this.answerString2 + "2 - Tsumo\n";
            }

            int i;
            for(i = 0; i < this.isMeldChecked.length; ++i) {
                this.isMeldChecked[i] = false;
            }

            for(i = 0; i < 4; ++i) {
                if(!this.isMeldChecked[i] && this.meldType[i] == 1 && this.meldTile[i] < 27 && this.meldClose[i] == 1 && this.meldTile[i] % 9 > 0 && this.meldTile[i] % 9 < 8) {
                    this.unroundedFu += 2;
                    this.answerString2 = this.answerString2 + "2 - Tanyao minkou\n";
                    this.isMeldChecked[i] = true;
                }
            }

            for(i = 0; i < 4; ++i) {
                if(!this.isMeldChecked[i] && this.meldType[i] == 1 && this.meldClose[i] == 1) {
                    if(this.meldTile[i] < 27) {
                        if(this.meldTile[i] % 9 == 0 || this.meldTile[i] % 9 == 8) {
                            this.unroundedFu += 4;
                            this.answerString2 = this.answerString2 + "4 - Yao chuu minkou\n";
                            this.isMeldChecked[i] = true;
                        }
                    } else {
                        this.unroundedFu += 4;
                        this.answerString2 = this.answerString2 + "4 - Yao chuu minkou\n";
                        this.isMeldChecked[i] = true;
                    }
                }
            }

            for(i = 0; i < 4; ++i) {
                if(!this.isMeldChecked[i] && this.meldType[i] == 1 && this.meldTile[i] < 27 && this.meldClose[i] == 0 && this.meldTile[i] % 9 > 0 && this.meldTile[i] % 9 < 8) {
                    this.unroundedFu += 4;
                    this.answerString2 = this.answerString2 + "4 - Tanyao ankou\n";
                    this.isMeldChecked[i] = true;
                }
            }

            for(i = 0; i < 4; ++i) {
                if(!this.isMeldChecked[i] && this.meldType[i] == 1 && this.meldClose[i] == 0) {
                    if(this.meldTile[i] < 27) {
                        if(this.meldTile[i] % 9 == 0 || this.meldTile[i] % 9 == 8) {
                            this.unroundedFu += 8;
                            this.answerString2 = this.answerString2 + "8 - Yao chuu ankou\n";
                            this.isMeldChecked[i] = true;
                        }
                    } else {
                        this.unroundedFu += 8;
                        this.answerString2 = this.answerString2 + "8 - Yao chuu ankou\n";
                        this.isMeldChecked[i] = true;
                    }
                }
            }

            for(i = 0; i < 4; ++i) {
                if(!this.isMeldChecked[i] && this.meldType[i] == 2 && this.meldTile[i] < 27 && this.meldClose[i] == 1 && this.meldTile[i] % 9 > 0 && this.meldTile[i] % 9 < 8) {
                    this.unroundedFu += 8;
                    this.answerString2 = this.answerString2 + "8 - Tan yao minkan\n";
                    this.isMeldChecked[i] = true;
                }
            }

            for(i = 0; i < 4; ++i) {
                if(!this.isMeldChecked[i] && this.meldType[i] == 2 && this.meldClose[i] == 1) {
                    if(this.meldTile[i] < 27) {
                        if(this.meldTile[i] % 9 == 0 || this.meldTile[i] % 9 == 8) {
                            this.unroundedFu += 16;
                            this.answerString2 = this.answerString2 + "16 - Yao chuu minkan\n";
                            this.isMeldChecked[i] = true;
                        }
                    } else {
                        this.unroundedFu += 16;
                        this.answerString2 = this.answerString2 + "16 - Yao chuu minkan\n";
                        this.isMeldChecked[i] = true;
                    }
                }
            }

            for(i = 0; i < 4; ++i) {
                if(!this.isMeldChecked[i] && this.meldType[i] == 2 && this.meldTile[i] < 27 && this.meldClose[i] == 0 && this.meldTile[i] % 9 > 0 && this.meldTile[i] % 9 < 8) {
                    this.unroundedFu += 16;
                    this.answerString2 = this.answerString2 + "16 - Tan yao ankan\n";
                    this.isMeldChecked[i] = true;
                }
            }

            for(i = 0; i < 4; ++i) {
                if(!this.isMeldChecked[i] && this.meldType[i] == 2 && this.meldClose[i] == 0) {
                    if(this.meldTile[i] < 27) {
                        if(this.meldTile[i] % 9 == 0 || this.meldTile[i] % 9 == 8) {
                            this.unroundedFu += 32;
                            this.answerString2 = this.answerString2 + "32 - Yao chuu ankan\n";
                            this.isMeldChecked[i] = true;
                        }
                    } else {
                        this.unroundedFu += 32;
                        this.answerString2 = this.answerString2 + "32 - Yao chuu ankan\n";
                        this.isMeldChecked[i] = true;
                    }
                }
            }

            for(i = 0; i < this.isMeldChecked.length; ++i) {
                this.isMeldChecked[i] = false;
            }

            if(this.meldTile[4] > 26 && this.meldTile[4] < 30) {
                this.unroundedFu += 2;
                this.answerString2 = this.answerString2 + "2 - Sangenpai jantou\n";
            }

            if(this.meldTile[4] == 30 + this.seatWind) {
                this.unroundedFu += 2;
                this.answerString2 = this.answerString2 + "2 - Seat wind jantou\n";
            }

            if(this.meldTile[4] == 30 + this.roundWind) {
                this.unroundedFu += 2;
                this.answerString2 = this.answerString2 + "2 - Round wind jantou\n";
            }

            if(!this.handYaku[6]) {
                switch(this.waitType) {
                    case 0:
                        this.unroundedFu += 2;
                        this.answerString2 = this.answerString2 + "2 - Penchan wait\n";
                        break;
                    case 1:
                        this.unroundedFu += 2;
                        this.answerString2 = this.answerString2 + "2 - Kanchan wait\n";
                        break;
                    case 2:
                        this.answerString2 = this.answerString2 + "0 - Ryanmen wait\n";
                        break;
                    case 3:
                        this.answerString2 = this.answerString2 + "0 - Shanpon wait\n";
                        break;
                    case 4:
                    default:
                        this.unroundedFu += 2;
                        this.answerString2 = this.answerString2 + "2 - Tanki wait\n";
                }
            } else {
                this.answerString2 = this.answerString2 + "0 - Ryanmen wait\n";
            }

            if(this.handHan == 1 && this.unroundedFu == 20 && !this.handYaku[6]) {
                this.unroundedFu += 10;
                this.answerString2 = this.answerString2 + "10 - Open pinfu\n";
            }

            this.answerString2 = this.answerString2 + "==========\n";
            this.answerString2 = this.answerString2 + this.unroundedFu + "\n";
            this.handFu = 10 * (int)Math.ceil((double)this.unroundedFu / 10.0D);
            this.answerString2 = this.answerString2 + "->" + this.handFu + "\n";
        }
    }

    public void countYakuman() {
        if(this.handYaku[12] && this.ronWind < 4) {
            ++this.numYakuman;
            this.answerString = this.answerString + this.yakumanStrings[14] + "\n";
        }

        if(this.numMelds == 13) {
            if(this.handTiles[this.agariHai] == 2) {
                this.numYakuman += 2;
                this.answerString = this.answerString + this.yakumanStrings[8] + "\n";
            } else {
                ++this.numYakuman;
                this.answerString = this.answerString + this.yakumanStrings[7] + "\n";
            }
        }

        int i;
        if(this.isClosed) {
            this.isMeldPossible = true;

            for(i = 10; i < 17; ++i) {
                this.isMeldPossible = this.isMeldPossible && this.handTiles[i] == 2;
            }

            if(this.isMeldPossible) {
                ++this.numYakuman;
                this.answerString = this.answerString + this.yakumanStrings[5] + "\n";
            }
        }

        if(this.isClosed) {
            for(i = 0; i < 3; ++i) {
                this.isMeldPossible = true;

                for(int j = 0; j < 9; ++j) {
                    if(j != 0 && j != 8) {
                        this.isMeldPossible = this.isMeldPossible && this.handTiles[j + 9 * i] >= 1;
                    } else {
                        this.isMeldPossible = this.isMeldPossible && this.handTiles[j + 9 * i] >= 3;
                    }
                }

                if(this.isMeldPossible) {
                    if(this.agariHai != 0 + 9 * i && this.agariHai != 8 + 9 * i) {
                        if(this.handTiles[this.agariHai] == 2) {
                            this.numYakuman += 2;
                            this.answerString = this.answerString + this.yakumanStrings[13] + "\n";
                        } else {
                            ++this.numYakuman;
                            this.answerString = this.answerString + this.yakumanStrings[12] + "\n";
                        }
                    } else if(this.handTiles[this.agariHai] == 4) {
                        this.numYakuman += 2;
                        this.answerString = this.answerString + this.yakumanStrings[13] + "\n";
                    } else {
                        ++this.numYakuman;
                        this.answerString = this.answerString + this.yakumanStrings[12] + "\n";
                    }
                }
            }
        }

        this.meldPointer = 0;

        for(i = 0; i < 4; ++i) {
            if(this.meldTile[i] == 27) {
                this.meldPointer += 3;
            }

            if(this.meldTile[i] == 28) {
                this.meldPointer += 5;
            }

            if(this.meldTile[i] == 29) {
                this.meldPointer += 7;
            }
        }

        if(this.meldPointer == 15) {
            ++this.numYakuman;
            this.answerString = this.answerString + this.yakumanStrings[0] + "\n";
        }

        this.meldPointer = 0;

        for(i = 0; i < 4; ++i) {
            if((this.meldType[i] == 1 || this.meldType[i] == 2) && this.meldClose[i] == 0) {
                ++this.meldPointer;
            }
        }

        if(this.meldPointer == 4) {
            if(this.waitType == 4) {
                this.numYakuman += 2;
                this.answerString = this.answerString + this.yakumanStrings[2] + "\n";
            } else if(this.ronWind == 4) {
                ++this.numYakuman;
                this.answerString = this.answerString + this.yakumanStrings[1] + "\n";
            }
        }

        this.isMeldPossible = true;

        for(i = 0; i < 27; ++i) {
            this.isMeldPossible = this.isMeldPossible && this.handTiles[i] == 0;
        }

        if(this.isMeldPossible) {
            ++this.numYakuman;
            this.answerString = this.answerString + this.yakumanStrings[3] + "\n";
        }

        this.isMeldPossible = true;

        for(i = 0; i < this.handTiles.length; ++i) {
            if(i == 19) {
                i = 22;
            }

            if(i == 23) {
                i = 24;
            }

            if(i == 25) {
                i = 26;
            }

            if(i == 28) {
                i = 29;
            }

            this.isMeldPossible = this.isMeldPossible && this.handTiles[i] == 0;
        }

        if(this.isMeldPossible) {
            ++this.numYakuman;
            this.answerString = this.answerString + this.yakumanStrings[4] + "\n";
        }

        this.isMeldPossible = true;

        for(i = 0; i < this.handTiles.length; ++i) {
            if(i < 27 && i % 9 == 8) {
                ++i;
            }

            if(i < 27 && i % 9 == 0) {
                ++i;
            }

            this.isMeldPossible = this.isMeldPossible && this.handTiles[i] == 0;
        }

        if(this.isMeldPossible) {
            ++this.numYakuman;
            this.answerString = this.answerString + this.yakumanStrings[6] + "\n";
        }

        this.meldPointer = 0;

        for(i = 0; i < 4; ++i) {
            if(this.meldTile[i] > 29) {
                ++this.meldPointer;
            }
        }

        if(this.meldPointer == 3) {
            if(this.meldTile[4] > 29) {
                ++this.numYakuman;
                this.answerString = this.answerString + this.yakumanStrings[9] + "\n";
            }
        } else if(this.meldPointer == 4) {
            this.numYakuman += 2;
            this.answerString = this.answerString + this.yakumanStrings[10] + "\n";
        }

        this.meldPointer = 0;

        for(i = 0; i < 4; ++i) {
            if(this.meldType[i] == 2) {
                ++this.meldPointer;
            }
        }

        if(this.meldPointer == 4) {
            ++this.numYakuman;
            this.answerString = this.answerString + this.yakumanStrings[11] + "\n";
        }

    }

    public void countYaku() {
        if(this.isRiichi && !this.handYaku[12]) {
            this.handYaku[0] = true;
        }

        if(this.isClosed && this.ronWind == 4) {
            this.handYaku[1] = true;
        }

        this.meldPointer = 0;

        int i;
        for(i = 0; i < 4; ++i) {
            if(this.meldTile[i] == 30 + this.roundWind) {
                this.handYaku[2] = true;
            }

            if(this.meldTile[i] == 30 + this.seatWind) {
                this.handYaku[3] = true;
            }

            if(this.meldTile[i] >= 27 && this.meldTile[i] <= 29) {
                ++this.meldPointer;
                this.handYaku[4] = true;
            }
        }

        if(this.meldPointer == 2 && this.meldTile[4] >= 27 && this.meldTile[4] <= 29) {
            this.handYaku[16] = true;
        }

        this.isMeldPossible = this.handTiles[0] == 0 && this.handTiles[8] == 0 && this.handTiles[9] == 0 && this.handTiles[17] == 0 && this.handTiles[18] == 0 && this.handTiles[26] == 0;

        for(i = 27; i < 34; ++i) {
            this.isMeldPossible = this.isMeldPossible && this.handTiles[i] == 0;
        }

        this.handYaku[5] = this.isMeldPossible;
        if(this.isClosed) {
            this.isMeldPossible = true;

            for(i = 0; i < 4; ++i) {
                this.isMeldPossible = this.isMeldPossible && this.meldType[i] == 0 && this.meldClose[i] == 0;
            }

            this.isMeldPossible = this.isMeldPossible && (this.meldTile[4] < 27 || this.meldTile[4] > 29);
            this.isMeldPossible = this.isMeldPossible && this.meldTile[4] != 30 + this.roundWind && this.meldTile[4] != 30 + this.seatWind;
            this.isRyanmen = this.isRyanmen || this.waitType == 2;
            this.isMeldPossible = this.isMeldPossible && this.isRyanmen;
            this.handYaku[6] = this.isMeldPossible;
        }

        for(i = 0; i < this.isMeldChecked.length; ++i) {
            this.isMeldChecked[i] = false;
        }

        int j;
        if(this.isClosed) {
            this.meldPointer = 0;

            for(i = 0; i <= 4; ++i) {
                if(this.meldType[i] == 0 && this.meldClose[i] == 0 && !this.isMeldChecked[i]) {
                    for(j = 0; j <= 4; ++j) {
                        if(!this.isMeldChecked[j] && j != i && this.meldType[j] == 0 && this.meldClose[j] == 0 && this.meldTile[j] == this.meldTile[i]) {
                            this.isMeldChecked[j] = this.isMeldChecked[i] = true;
                            ++this.meldPointer;
                            j = 5;
                        }
                    }
                }
            }

            if(this.meldPointer == 2) {
                this.handYaku[21] = true;
            }

            if(this.meldPointer == 1) {
                this.handYaku[7] = true;
            }

            for(i = 0; i < this.isMeldChecked.length; ++i) {
                this.isMeldChecked[i] = false;
            }
        }

        this.isMeldPossible = true;

        for(i = 0; i < 27; ++i) {
            if(i % 9 == 8) {
                ++i;
            }

            if(i % 9 == 0) {
                ++i;
            }

            if(i < 27) {
                this.isMeldPossible = this.isMeldPossible && this.handTiles[i] == 0;
            }
        }

        if(this.isMeldPossible) {
            this.handYaku[17] = true;
        } else {
            this.isMeldPossible = this.numMelds != 7;

            for(i = 0; i <= 4; ++i) {
                if(this.meldType[i] == 0) {
                    this.isMeldPossible = this.isMeldPossible && (this.meldTile[i] % 9 == 0 || this.meldTile[i] % 9 == 6);
                } else if(this.meldTile[i] < 27) {
                    this.isMeldPossible = this.isMeldPossible && (this.meldTile[i] % 9 == 0 || this.meldTile[i] % 9 == 8);
                }
            }

            if(this.isMeldPossible) {
                this.meldPointer = 0;

                for(i = 27; i < 34; ++i) {
                    this.meldPointer += this.handTiles[i];
                }

                if(this.meldPointer > 0) {
                    this.handYaku[8] = true;
                } else {
                    this.handYaku[19] = true;
                }
            }
        }

        int k;
        for(i = 0; i < 4; ++i) {
            if(this.meldType[i] == 0 && this.meldTile[i] % 9 == 0) {
                for(j = 0; j < 4; ++j) {
                    if(this.meldType[j] == 0 && this.meldTile[j] == this.meldTile[i] + 3) {
                        for(k = 0; k < 4; ++k) {
                            if(this.meldType[k] == 0 && this.meldTile[k] == this.meldTile[j] + 3) {
                                this.handYaku[9] = true;
                                k = 5;
                                j = 5;
                                i = 5;
                            }
                        }
                    }
                }
            }
        }

        for(i = 0; i < 4; ++i) {
            this.meldPointer = 0;
            if(this.meldTile[i] < 9) {
                if(this.meldType[i] > 0) {
                    this.meldPointer = 1;
                }

                for(j = 0; j < 4; ++j) {
                    if((this.meldType[j] + this.meldType[i] >= 3 || this.meldType[j] == this.meldType[i]) && this.meldTile[j] == this.meldTile[i] + 9) {
                        for(k = 0; k < 4; ++k) {
                            if((this.meldType[k] + this.meldType[i] >= 3 || this.meldType[k] == this.meldType[i]) && this.meldTile[k] == this.meldTile[j] + 9) {
                                if(this.meldPointer > 0) {
                                    this.handYaku[11] = true;
                                } else {
                                    this.handYaku[10] = true;
                                }

                                k = 5;
                                j = 5;
                                i = 5;
                            }
                        }
                    }
                }
            }
        }

        this.meldPointer = 0;

        for(i = 0; i < 4; ++i) {
            if(this.meldType[i] == 2) {
                ++this.meldPointer;
            }
        }

        if(this.meldPointer >= 3) {
            this.handYaku[13] = true;
        }

        this.isMeldPossible = true;

        for(i = 0; i < 4; ++i) {
            this.isMeldPossible = this.isMeldPossible && (this.meldType[i] == 2 || this.meldType[i] == 1);
        }

        if(this.isMeldPossible) {
            this.handYaku[14] = true;
        }

        this.meldPointer = 0;

        for(i = 0; i < 4; ++i) {
            if((this.meldType[i] == 2 || this.meldType[i] == 1) && this.meldClose[i] == 0) {
                ++this.meldPointer;
            }
        }

        if(this.meldPointer >= 3) {
            this.handYaku[15] = true;
        }

        if(this.numMelds == 7) {
            this.handYaku[18] = true;
        }

        this.isMeldPossible = true;
        this.arrayPointer = this.meldPointer = 0;

        for(i = 0; i < 3; ++i) {
            this.arrayPointer = 0;

            for(j = 0; j < 9; ++j) {
                this.arrayPointer += this.handTiles[j + 9 * i];
            }

            if(this.meldPointer == 0) {
                this.meldPointer = this.arrayPointer;
            } else if(this.arrayPointer > 0) {
                this.isMeldPossible = false;
            }
        }

        if(this.isMeldPossible) {
            this.meldPointer = 0;

            for(i = 27; i < 34; ++i) {
                this.meldPointer += this.handTiles[i];
            }

            if(this.meldPointer > 0) {
                this.handYaku[20] = true;
            } else {
                this.handYaku[22] = true;
            }
        }

    }

    public void countHan() {
        boolean hanValue = false;

        for(int i = 0; i < this.handYaku.length; ++i) {
            if(this.handYaku[i]) {
                int var4;
                var4 = 0;
                label68:
                switch(i) {
                    case 0:
                    default:
                        var4 = 1;
                        break;
                    case 1:
                        var4 = 1;
                        break;
                    case 2:
                        var4 = 1;
                        break;
                    case 3:
                        var4 = 1;
                        break;
                    case 4:
                        int j = 0;

                        while(true) {
                            if(j >= 4) {
                                break label68;
                            }

                            if(this.meldTile[j] >= 27 && this.meldTile[j] <= 29) {
                                ++var4;
                            }

                            ++j;
                        }
                    case 5:
                        var4 = 1;
                        break;
                    case 6:
                        var4 = 1;
                        break;
                    case 7:
                        var4 = 1;
                        break;
                    case 8:
                        var4 = 2;
                        if(!this.isClosed) {
                            --var4;
                        }
                        break;
                    case 9:
                        var4 = 2;
                        if(!this.isClosed) {
                            --var4;
                        }
                        break;
                    case 10:
                        var4 = 2;
                        if(!this.isClosed) {
                            --var4;
                        }
                        break;
                    case 11:
                        var4 = 2;
                        break;
                    case 12:
                        var4 = 2;
                        break;
                    case 13:
                        var4 = 2;
                        break;
                    case 14:
                        var4 = 2;
                        break;
                    case 15:
                        var4 = 2;
                        break;
                    case 16:
                        var4 = 2;
                        break;
                    case 17:
                        var4 = 2;
                        break;
                    case 18:
                        var4 = 2;
                        break;
                    case 19:
                        var4 = 3;
                        if(!this.isClosed) {
                            --var4;
                        }
                        break;
                    case 20:
                        var4 = 3;
                        if(!this.isClosed) {
                            --var4;
                        }
                        break;
                    case 21:
                        var4 = 3;
                        break;
                    case 22:
                        var4 = 6;
                        if(!this.isClosed) {
                            --var4;
                        }
                }

                this.handHan += var4;
                this.answerString = this.answerString + var4 + " - " + this.yakuStrings[i] + "\n";
            }
        }

        if(this.numDora > 0) {
            this.handHan += this.numDora;
            this.answerString = this.answerString + this.numDora + " - Dora\n";
        }

        this.answerString = this.answerString + "==========\n" + this.handHan + "\n";
    }

    public void countPayments() {
        if(this.numYakuman > 0) {
            this.basePay = this.numYakuman * 8000;
        } else if(this.handHan >= 5) {
            if(this.handHan < 6) {
                this.basePay = 2000;
            } else if(this.handHan < 8) {
                this.basePay = 3000;
            } else if(this.handHan < 11) {
                this.basePay = 4000;
            } else if(this.handHan < 13) {
                this.basePay = 6000;
            } else {
                this.basePay = 8000;
            }
        } else {
            this.basePay = this.handFu * 4;

            for(int i = 0; i < this.handHan; ++i) {
                this.basePay *= 2;
            }

            if(this.basePay > 2000) {
                this.basePay = 2000;
            }
        }

        if(this.seatWind == 0) {
            this.basePay *= 2;
            if(this.ronWind < 4) {
                this.basePay *= 3;
                this.basePay = 100 * (int)Math.ceil((double)this.basePay / 100.0D);
                this.handPayKo = this.basePay;
            } else {
                this.basePay = 100 * (int)Math.ceil((double)this.basePay / 100.0D);
                this.handPayKo = this.basePay;
            }
        } else if(this.ronWind < 4) {
            this.basePay *= 4;
            this.basePay = 100 * (int)Math.ceil((double)this.basePay / 100.0D);
            if(this.ronWind == 0) {
                this.handPayOya = this.basePay;
            } else {
                this.handPayKo = this.basePay;
            }
        } else {
            this.handPayKo = 100 * (int)Math.ceil((double)this.basePay / 100.0D);
            this.basePay *= 2;
            this.handPayOya = 100 * (int)Math.ceil((double)this.basePay / 100.0D);
        }

    }

    public void submitAnswer() {
        this.hanList.setText(this.answerString);
        this.fuList.setText(this.answerString2);
        this.fuAnswer.setText(Integer.toString(this.handFu));
        this.hanAnswer.setText(Integer.toString(this.handHan));
        this.koAnswer.setText(Integer.toString(this.handPayKo));
        this.oyaAnswer.setText(Integer.toString(this.handPayOya));
        this.meldPointer = this.arrayPointer = 0;

        try {
            this.arrayPointer = Integer.parseInt(this.fuEntry.getText());
        } catch (NumberFormatException var5) {
            this.fuEntry.setText("0");
        }

        try {
            this.arrayPointer = Integer.parseInt(this.hanEntry.getText());
        } catch (NumberFormatException var4) {
            this.hanEntry.setText("0");
        }

        try {
            this.arrayPointer = Integer.parseInt(this.koEntry.getText());
        } catch (NumberFormatException var3) {
            this.koEntry.setText("0");
        }

        try {
            this.arrayPointer = Integer.parseInt(this.oyaEntry.getText());
        } catch (NumberFormatException var2) {
            this.oyaEntry.setText("0");
        }

        this.meldPointer = Integer.parseInt(this.fuEntry.getText());
        if(this.meldPointer != this.handFu && this.meldPointer != this.unroundedFu) {
            this.fuEntry.setForeground(Color.RED);
        } else {
            ++this.numCorFu;
            this.fuEntry.setForeground(Color.GREEN);
        }

        this.meldPointer = Integer.parseInt(this.hanEntry.getText());
        if(this.yakumanBox.isSelected()) {
            this.arrayPointer = 1;
        } else {
            this.arrayPointer = 0;
        }

        if(this.meldPointer == this.handHan) {
            this.hanEntry.setForeground(Color.GREEN);
            if(this.isYakuman) {
                if(this.arrayPointer == 1) {
                    ++this.numCorHan;
                    this.yakumanBox.setForeground(Color.GREEN);
                } else {
                    this.yakumanBox.setForeground(Color.RED);
                }
            } else if(this.arrayPointer == 0) {
                ++this.numCorHan;
                this.yakumanBox.setForeground(Color.GREEN);
            } else {
                this.yakumanBox.setForeground(Color.RED);
            }
        } else {
            this.hanEntry.setForeground(Color.RED);
            if(this.isYakuman) {
                if(this.arrayPointer == 1) {
                    this.yakumanBox.setForeground(Color.GREEN);
                } else {
                    this.yakumanBox.setForeground(Color.RED);
                }
            } else if(this.arrayPointer == 0) {
                this.yakumanBox.setForeground(Color.GREEN);
            } else {
                this.yakumanBox.setForeground(Color.RED);
            }
        }

        this.meldPointer = Integer.parseInt(this.koEntry.getText());
        this.arrayPointer = Integer.parseInt(this.oyaEntry.getText());
        if(this.ronWind < 4) {
            if(this.meldPointer == this.handPayKo && this.arrayPointer == this.handPayOya || this.meldPointer == this.handPayOya && this.arrayPointer == this.handPayKo) {
                ++this.numCorPay;
                this.koEntry.setForeground(Color.GREEN);
                this.oyaEntry.setForeground(Color.GREEN);
            } else if(this.meldPointer == this.handPayKo) {
                this.koEntry.setForeground(Color.GREEN);
                this.oyaEntry.setForeground(Color.RED);
            } else if(this.arrayPointer == this.handPayOya) {
                this.oyaEntry.setForeground(Color.GREEN);
                this.koEntry.setForeground(Color.RED);
            } else {
                this.koEntry.setForeground(Color.RED);
                this.oyaEntry.setForeground(Color.RED);
            }
        } else if(this.meldPointer == this.handPayKo && this.arrayPointer == this.handPayOya) {
            ++this.numCorPay;
            this.koEntry.setForeground(Color.GREEN);
            this.oyaEntry.setForeground(Color.GREEN);
        } else if(this.meldPointer == this.handPayKo) {
            this.koEntry.setForeground(Color.GREEN);
            this.oyaEntry.setForeground(Color.RED);
        } else if(this.arrayPointer == this.handPayOya) {
            this.oyaEntry.setForeground(Color.GREEN);
            this.koEntry.setForeground(Color.RED);
        } else {
            this.koEntry.setForeground(Color.RED);
            this.oyaEntry.setForeground(Color.RED);
        }

        this.corFuField.setText(Integer.toString(this.numCorFu));
        this.corHanField.setText(Integer.toString(this.numCorHan));
        this.corPayField.setText(Integer.toString(this.numCorPay));
    }

    public boolean sanityCheck(String s) {
        ++this.sanityCheck;
        if(this.sanityCheck == 100) {
            this.isError = true;
            this.answerString = this.answerString + "ERROR: " + s;

            int i;
            for(i = 0; i < this.handYaku.length; ++i) {
                if(this.handYaku[i]) {
                    this.answerString = this.answerString + i + ".";
                }
            }

            for(i = 0; i <= 4; ++i) {
                this.answerString = this.answerString + this.meldType[i] + "." + this.meldTile[i] + "." + this.meldClose[i];
                if(i < 4) {
                    this.answerString = this.answerString + ".";
                }
            }

            this.answerString = this.answerString + "\nPlease report this!\n";
            this.hanList.setForeground(Color.RED);
            this.hanList.setText(this.answerString);
            this.sanityCheck = 0;
        }

        return false;
    }

    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 110) {
            if(this.isDebugMode) {
                ++this.debugPointer;
                if(this.isDebugYakuman) {
                    if(this.debugPointer >= this.yakumanStrings.length) {
                        this.debugPointer = 0;
                    }

                    this.riichiField.setText(this.yakumanStrings[this.debugPointer]);
                } else {
                    if(this.debugPointer >= this.yakuStrings.length) {
                        this.debugPointer = 0;
                    }

                    this.riichiField.setText(this.yakuStrings[this.debugPointer]);
                }
            } else {
                this.isDebugMode = true;
                this.debugPointer = 0;
                this.riichiField.setText(this.yakuStrings[this.debugPointer]);
            }
        }

        if(e.getKeyChar() == 121) {
            this.isDebugYakuman = !this.isDebugYakuman;
            this.debugPointer = 0;
            if(this.isDebugMode) {
                if(this.isDebugYakuman) {
                    this.riichiField.setText(this.yakumanStrings[this.debugPointer]);
                } else {
                    this.riichiField.setText(this.yakuStrings[this.debugPointer]);
                }
            } else {
                this.isDebugMode = true;
                this.riichiField.setText(this.yakumanStrings[this.debugPointer]);
            }
        }

        if(e.getKeyChar() == 100) {
            this.isDebugSpecific = true;
            this.isDebugMode = true;
            this.riichiField.setText("Specific debug mode");
        }

        if(e.getKeyChar() == 119) {
            this.isMassDebug = true;
            this.riichiField.setText("Mass debug mode");
        }

    }

    public void keyPressed(KeyEvent arg0) {
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void actionPerformed(ActionEvent e) {
        if("New".equals(e.getActionCommand())) {
            if(!this.isMassDebug) {
                ++this.numHands;
                this.newHand();
            } else {
                int i;
                if(this.isDebugMode) {
                    for(i = 0; i < 9000; ++i) {
                        this.isDebugMode = true;
                        ++this.numHands;
                        ++this.numCorFu;
                        ++this.numCorHan;
                        ++this.numCorPay;
                        if(this.rand(5) == 1) {
                            --this.numCorHan;
                        }

                        if(this.rand(5) == 1) {
                            --this.numCorPay;
                        }

                        if(this.rand(4) == 1) {
                            --this.numCorFu;
                        }

                        this.newHand();
                        if(this.isError) {
                            i = 9001;
                        }
                    }
                } else {
                    for(i = 0; i < 9000; ++i) {
                        ++this.numHands;
                        ++this.numCorFu;
                        ++this.numCorHan;
                        ++this.numCorPay;
                        if(this.rand(5) == 1) {
                            --this.numCorHan;
                        }

                        if(this.rand(5) == 1) {
                            --this.numCorPay;
                        }

                        if(this.rand(4) == 1) {
                            --this.numCorFu;
                        }

                        this.newHand();
                        if(this.isError) {
                            i = 9001;
                        }
                    }
                }

                this.isMassDebug = false;
            }
        }

        if("Check".equals(e.getActionCommand()) && !this.isChecked) {
            this.isChecked = true;
            this.submitAnswer();
        }

        if("Yakuman".equals(e.getActionCommand())) {
            if(this.yakumanBox.isSelected()) {
                this.fuEntry.setEnabled(false);
                this.fuEntry.setText("0");
                this.hanEntry.setEnabled(false);
                this.hanEntry.setText("0");
            } else {
                this.fuEntry.setEnabled(true);
                this.hanEntry.setEnabled(true);
            }
        }

        if("Infure".equals(e.getActionCommand())) {
            this.isInfure = !this.infureBox.isSelected();
        }

    }

    public void focusGained(FocusEvent e) {
        this.fuEntry.setEnabled(true);
    }

    public void focusLost(FocusEvent e) {
        try {
            if(Integer.parseInt(this.hanEntry.getText()) >= 5) {
                this.fuEntry.setEnabled(false);
                this.fuEntry.setText("0");
            }
        } catch (NumberFormatException var3) {
            this.hanEntry.setText("0");
        }

    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mouseClicked(MouseEvent event) {
        this.repaint();
    }
}
