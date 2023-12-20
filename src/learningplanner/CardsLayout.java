package learningplanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CardsLayout extends JPanel implements ItemListener {

    JPanel cards;
    final static String S1Panel = "S1";
    final static String S2Panel = "S2";
    final static String S3Panel = "S3";
    JPanel card1, card2, card3;
    JPanel comboBoxPane;
    String comboBoxItems[] = {"S1", "S2", "S3"};
    JComboBox comboBoxYears;

    CardsLayout(){

        //Create cards
        card1 = new JPanel();
        card2 = new JPanel();
        card3 = new JPanel();

        //Create the panel that contains the "cards"
        cards = new JPanel(new CardLayout());
        cards.add(card1, S1Panel);
        cards.add(card2, S2Panel);
        cards.add(card3, S3Panel);

        //Put ComboBox in a JPanel
        comboBoxPane = new JPanel();
        comboBoxYears = new JComboBox(comboBoxItems);
        comboBoxYears.setEditable(false);
        comboBoxYears.addItemListener(this);

        comboBoxPane.add(comboBoxYears);
        comboBoxPane.add(cards);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)e.getItem());
    }
}
