package learningplanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountPage extends JPanel implements ActionListener {

    JPanel panel1, panel2;
    JLabel title,  subjectL;
    JButton logoutB,subjectB;
    MyGUI gui;
    AccountPage(MyGUI myGUI){
        setBackground(Color.decode("#4FA6E7"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.gui = myGUI;

        //Create a Title
        title = new JLabel("My Account");
        title.setFont(new Font("Open Sans", Font.BOLD, 20));


        logoutB = new JButton("Logout");
        logoutB.addActionListener(this);

        panel1 = createPanel();
        panel1.setPreferredSize(new Dimension(400, 20));
//        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.add(title);
        panel1.add(logoutB);

        subjectL = new JLabel("Subjects");
        subjectL.setFont(new Font("Open Sans", Font.BOLD, 20));
        subjectL.setLayout(new FlowLayout());
        subjectB = new JButton("Go");
        subjectB.addActionListener( this);

        panel2 = createPanel();
        panel2.setPreferredSize(new Dimension(400, 40));
        panel2.add(subjectL);
        panel2.add(subjectB);

        add(panel1);
        add(panel2);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.decode("#4FA6E7"));
        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==subjectB){
            gui.showSubjectsPage();
        }else if(e.getSource()==logoutB){
            gui.showLoginPage();
        }
    }
}
