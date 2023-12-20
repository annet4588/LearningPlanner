package learningplanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MyMenu extends JPanel implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4;
    private MyGUI gui;


    //Inside the Constructor accept an instance of learningplanner.MyGUI as a parameter
    MyMenu(MyGUI myGUI){
        this.gui = myGUI;

        menuBar = new JMenuBar();

        menu = new JMenu();
        menu.setIcon(new ImageIcon("images/menu.png"));
        menuBar.add(menu);

        menuItem1 = new JMenuItem("Students", KeyEvent.VK_T);
        menuItem1.addActionListener(this);

        menuItem2 = new JMenuItem("Teachers");
        menuItem2.addActionListener(this);

        menuItem3 = new JMenuItem("Timetable");
        menuItem3.addActionListener(this);

//        menuItem4 = new JMenuItem("Subjects");
//        menuItem4.addActionListener(this);

        //Add Items to the Menu
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
//        menu.add(menuItem4);
        menu.addSeparator();

        //JPanel to set the layout for the menu
        setLayout(new BorderLayout());
        add(menuBar);

        setVisible(true);
    }

    //Create a Method to return menuBar
    public JMenuBar getMenuBar(){
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==menuItem1){
            gui.showStudentsPage();
        } else if (e.getSource()==menuItem2) {
            gui.showLoginPage();
        }else if (e.getSource()==menuItem3) {
            gui.showTimetablePage();
//        }else if(e.getSource()==menuItem4){
//            gui.showSubjectsPage();
        }
    }
}
