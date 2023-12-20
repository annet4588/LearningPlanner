package learningplanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordPage extends JPanel implements ActionListener {
    JPanel panel1;
    JLabel title;
    JButton backButton;
    MyGUI gui;
    ForgotPasswordPage(MyGUI myGui){

        this.gui = myGui;
        setBackground(Color.decode("#4FA6E7"));
        setLayout(new FlowLayout(FlowLayout.CENTER));

        //Create Back button to go to Account page
        backButton = new JButton();
        backButton.setIcon(new ImageIcon("images/dArrowLeft.png"));
        backButton.setFocusable(false);
        backButton.setFocusable(false);
        backButton.setPreferredSize(new Dimension(40, 40));
        backButton.setBackground(Color.decode("#4FA6E7"));
        backButton.addActionListener(this);

        //Create a Title
        title = new JLabel("Forgot Password");
        title.setFont(new Font("Open Sans", Font.BOLD, 20));

        panel1 = createPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel1.setPreferredSize(new Dimension(400, 40));
//        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.add(backButton);
        panel1.add(title);

        add(panel1);
    }
    private JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.decode("#4FA6E7"));
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showLoginPage();
        }
    }
}
