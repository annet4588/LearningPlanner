package learningplanner;

import learningplanner.MyGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavBar extends JPanel implements ActionListener {

    JToolBar tb;
    private JButton homeButton;
    private JButton accountButton;
    private JButton eventsButton;
    private JButton searchButton;
    private JButton moreButton;
    private MyGUI gui;

    NavBar(MyGUI myGUI){
        this.gui = myGUI;

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());


        tb = new JToolBar();
        tb.setRollover(true);
        tb.setFloatable(false);
        tb.setBackground(Color.WHITE);
        tb.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        homeButton = createButton("Home", "images/house.png");
        homeButton.addActionListener(this);
        accountButton = createButton("Account", "images/account.png");
        accountButton.addActionListener(this);
        eventsButton = createButton("Events", "images/events.png");
        eventsButton.addActionListener(this);
        searchButton = createButton("Search", "images/search.png");
        searchButton.addActionListener(this);
        moreButton = createButton("More", "images/more.png");
        moreButton.addActionListener(this);

        tb.add(homeButton);
        tb.addSeparator();
        tb.add(accountButton);
        tb.addSeparator();
        tb.add(eventsButton);
        tb.addSeparator();
        tb.add(searchButton);
        tb.addSeparator();
        tb.add(moreButton);
        tb.addSeparator();

        add(tb);

        setVisible(true);
    }

    private JButton createButton(String text, String iconPath) {

        JButton button = new JButton(text);

        button.setIcon(new ImageIcon(iconPath));
        button.setFocusable(false);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setBorderPainted(false);
        button.setBackground(Color.WHITE);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==homeButton){
            gui.showHomePage();
        }else if(e.getSource()==accountButton){
            gui.showLoginPage();
        }else if(e.getSource()==eventsButton){
            gui.showEventsPage();
        }else if(e.getSource()==searchButton){
            gui.showSearchPage();
        }else if(e.getSource()==moreButton) {
            gui.showMorePage();
        }
    }
}


//        FlowLayout flowLayout = new FlowLayout();
//        flowLayout.setAlignOnBaseline(true);
//        flowLayout.setHgap(8);