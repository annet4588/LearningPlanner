package learningplanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class LoginPage extends JPanel implements MouseListener, ActionListener {
    //Create a copy of loginInfo
    HashMap<String, String> loginInfo;
    JPanel panel1, panel2;
    JLabel title;
    JLabel userIDL, userPasswordL, forgotPassword, notRegistered;
    JTextField userIDTF;
    JPasswordField userPasswordField;
    JButton loginB, registerB;
    MyGUI gui;

    LoginPage(MyGUI myGui, HashMap<String, String> loginOriginalInfo) {

        this.gui = myGui;
        loginInfo = loginOriginalInfo;

        setBackground(Color.decode("#4FA6E7"));
        setLayout(new FlowLayout(FlowLayout.CENTER));
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Create a Title
        title = new JLabel("Login");
        title.setFont(new Font("Open Sans", Font.BOLD, 20));


        panel1 = createPanel();
        panel1.setPreferredSize(new Dimension(400, 40));
//        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.add(title);

        //Create userId label and text field
        userIDL = new JLabel("userID");
        userIDL.setFont(new Font("Open Sans",Font.BOLD, 15));
        userIDL.setPreferredSize(new Dimension(75,25));

        userIDTF = new JTextField();
        userIDTF.setPreferredSize(new Dimension(200,25));

        //Create password label and text field
        userPasswordL = new JLabel("password");
        userPasswordL.setFont(new Font("Open Sans",Font.BOLD, 15));
        userPasswordL.setPreferredSize(new Dimension(75,25));

        userPasswordField = new JPasswordField("", 10);
//        userPasswordField.setEchoChar('*');
        userPasswordField.setPreferredSize(new Dimension(200,25));

        //Create Submit button
        loginB = new JButton("Login");
        loginB.setFocusable(false);
        loginB.setPreferredSize(new Dimension(200,20));
        loginB.addActionListener(this);

        //Create forgot password label
        forgotPassword = new JLabel("<html><a href=''>Forgot your password?<a><html>");
        forgotPassword.setFont(new Font("Open Sans",Font.BOLD, 15));
        forgotPassword.setPreferredSize(new Dimension(200,25));
        forgotPassword.addMouseListener(this);

        notRegistered = new JLabel("Not Registered?");
        notRegistered.setFont(new Font("Open Sans",Font.BOLD, 15));
        notRegistered.setPreferredSize(new Dimension(200,25));

        //Create Register Button
        registerB = new JButton("Register");
        registerB.setFocusable(false);
        registerB.setPreferredSize(new Dimension(200,20));

        //Create panel 2 to hold the user ID and password
        panel2 = new JPanel();
        panel2.setBackground(Color.decode("#4FA6E7"));
        panel2.setLayout(new GridBagLayout());
        panel2.setPreferredSize(new Dimension(390,300));
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL; ////natural height, maximum width

        //Create labels for userID and password
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0,10,20,0);
        c.gridwidth = 3;
        panel2.add(userIDL, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0,10,20,0);
        c.gridwidth = 3;
        panel2.add(userPasswordL, c);

        //Create text fields
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.5;
        c.ipadx = 200;
        c.insets = new Insets(0,10,20,0);
        panel2.add(userIDTF, c);

        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;
        c.weightx = 0.5;
        c.ipadx = 200;
        c.insets = new Insets(0,10,20,0);
        panel2.add(userPasswordField, c);

        //Create login button
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 3;
        c.weightx = 0.5;
        c.insets = new Insets(0,0,20,0);
        panel2.add(loginB, c);


        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 0.5;
        c.insets = new Insets(0,10,20,0);
        c.ipadx = 200;
        panel2.add(forgotPassword, c);

        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 5;
        c.anchor = GridBagConstraints.LINE_START;
        c.weightx = 0.5;
        c.insets = new Insets(0,10,20,0);
        c.ipadx = 200;
        panel2.add(notRegistered, c);

        //Create register button
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 6;
        c.weightx = 0.5;
        c.insets = new Insets(0,0,20,0);
        panel2.add(registerB, c);

        add(panel1);
        add(panel2);

        setVisible(true);
    }
    private JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.decode("#4FA6E7"));
        return panel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().equals(forgotPassword)){
            gui.showForgotPasswordPage();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Set the Login Button
        if (e.getSource() == loginB) {
            String userID = userIDTF.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            //If Statement to verify the userID and password
            if (loginInfo.containsKey(userID)) {
                if (loginInfo.get(userID).equals(password)) {

                    JOptionPane.showMessageDialog(null,"Login Successful");
                    gui.showAccountPage();
                    userIDTF.setText("");
                    userPasswordField.setText("");

                } else {
                    JOptionPane.showMessageDialog(null,"Wrong Password");
                    userIDTF.setText("");
                    userPasswordField.setText("");
                }

            }else{
                JOptionPane.showMessageDialog(null,"Wrong Username");
                userIDTF.setText("");
                userPasswordField.setText("");
            }
        }
    }

}

////regex check for valid Email
//    public boolean isValidEmailAddress(String email){
//            java.util.regex.Pattern p = java.util.regex.Pattern.compile("[A-Za-z0-9._\\%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
//            java.util.regex.Matcher m = p.matcher(email);
//            return m.matches();
//
//        }
//    //regex check for valid Address
//    public boolean isValidAddress(String address){
//        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\d{1,3}.?\\d{0,3}\\s[a-zA-Z]{2,30}\\s[a-zA-Z]{2,15}");
//        java.util.regex.Matcher m = p.matcher(address);
//        return m.matches();

//        //To Clear Fields
//        if (e.getSource() == resetB) {
//            userIDField.setText("");
//            userPasswordField.setText("");
//        }