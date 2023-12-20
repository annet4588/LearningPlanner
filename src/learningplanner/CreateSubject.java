package learningplanner;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CreateSubject extends JPanel {

    private JPanel cards;
    private JPanel card1, card2, card3;
    private JPanel panel1, panel2;
    protected JButton backButton;
    private GroupLayout groupLayout;
    private CardLayout cardLayout;
    private Map<String, JPanel> cardMap;
    private Map<String, List<JTextComponent>> textComponentMap;
    protected JLabel title;
    private JLabel yearL;
    private JLabel subNameL;
    private JLabel subClassL;
    private JLabel teacherNameL;
    private JLabel lessonTopicL;
    private JLabel homeworkL;
    private JLabel whereHomeworkL;
    protected JTextField yearOutput;
    protected JTextField subjOutput;
    protected  JTextField subClassTF;
    protected  JTextField teacherNameTF;
    protected  JTextArea lessonTopicTA;
    protected  JTextArea homeworkTA;
    protected  JTextArea whereHomeworkTA;

    String[] years = {"S1", "S2", "S3"};
    String selectedYear;
    MyGUI gui;


    //Getters
    public JTextField getYearOutput() {
        return yearOutput;
    }

    public JTextField getSubjOutput() {
        return subjOutput;
    }

    public JTextField getSubClassTF() {
        return subClassTF;
    }

    public JTextField getTeacherNameTF() {
        return teacherNameTF;
    }

    public JTextArea getLessonTopicTA() {
        return lessonTopicTA;
    }

    public JTextArea getHomeworkTA() {
        return homeworkTA;
    }

    public JTextArea getWhereHomeworkTA() {
        return whereHomeworkTA;
    }

    //Setters
    public void setYearOutput(JTextField yearOutput) {
        this.yearOutput = yearOutput;
    }

    public void setSubjOutput(JTextField subjOutput) {
        this.subjOutput = subjOutput;
    }

    public void setSubClassTF(JTextField subClassTF) {
        this.subClassTF = subClassTF;
    }

    public void setTeacherNameTF(JTextField teacherNameTF) {
        this.teacherNameTF = teacherNameTF;
    }

    public void setLessonTopicTA(JTextArea lessonTopicTA) {
        this.lessonTopicTA = lessonTopicTA;
    }

    public void setHomeworkTA(JTextArea homeworkTA) {
        this.homeworkTA = homeworkTA;
    }

    public void setWhereHomeworkTA(JTextArea whereHomeworkTA) {
        this.whereHomeworkTA = whereHomeworkTA;
    }
    CreateSubject(MyGUI myGui) {
        this.gui = myGui;

        setBackground(Color.decode("#4FA6E7"));
        setLayout(new FlowLayout(FlowLayout.CENTER));

        panel1 = createPanel();
        backButton = gui.createBackButton();

        title = new JLabel();
        title.setFont(new Font("Open Sans", Font.BOLD, 20));

        panel1.setPreferredSize(new Dimension(400, 40));
        panel1.setBackground(Color.decode("#4FA6E7"));
//        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.add(backButton);
        panel1.add(title);

        yearL = new JLabel("Year");
        subNameL = new JLabel("Subject");
        subClassL = new JLabel("Class");
        teacherNameL = new JLabel("Teacher's name");
        lessonTopicL = new JLabel("Lesson Topics");
        homeworkL = new JLabel("Homework");
        whereHomeworkL = new JLabel("Where is Homework");

        yearOutput = new JTextField();
        subjOutput = new JTextField();
        subClassTF = new JTextField();
        teacherNameTF = new JTextField();

        lessonTopicTA = new JTextArea();
        lessonTopicTA.setPreferredSize(new Dimension(200, 130));
        lessonTopicTA.setLineWrap(true);
        homeworkTA = new JTextArea();
        homeworkTA.setPreferredSize(new Dimension(200, 130));
        homeworkTA.setLineWrap(true);
        whereHomeworkTA = new JTextArea();
        whereHomeworkTA.setPreferredSize(new Dimension(200, 130));
        whereHomeworkTA.setLineWrap(true);

        //Create panel 2 to hold the form
        panel2 = createCardPanel();
        panel2.setBackground(Color.decode("#4FA6E7"));
        panel2.setPreferredSize(new Dimension(400, 600));
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

//        //Create cards
//        card1 = createCardPanel();
//        card2 = createCardPanel();
//        card3 = createCardPanel();
//
//        //Create panel, that contain the cards and set it to CardLayout
//        cards = new JPanel();
//        cards.setBackground(Color.decode("#4FA6E7"));
//        cards.setPreferredSize(new Dimension(400, 600));
//        cards.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        cardLayout = new CardLayout();
//        cards.setLayout(cardLayout);
//
//        //// Initialize the cardMap and textComponentMap before calling showCardForYear("S1")
//        //Create the map to store the card panels
//        cardMap = new HashMap<>();
//
//        //Create the map to store the text fields
//        textComponentMap = new HashMap<>();
//
//        cards.add("S1", card1);
//        cards.add("S2", card2);
//        cards.add("S3", card3);

//        //Call the method showCardForYear("S1") initially to show "S1" card
//        showCardData("S1");

        //Store textComponents
//        List<JTextComponent> textComponentList = new ArrayList<>();
//        textComponentList.add(yearOutput);
//        textComponentList.add(subjOutput);
//        textComponentList.add(subClassTF);
//        textComponentList.add(teacherNameTF);
//        textComponentList.add(lessonTopicTA);
//        textComponentList.add(homeworkTA);
//        textComponentList.add(whereHomeworkTA);
//
//        cardMap.put("S1", card1);
//        textComponentMap.put("S1", textComponentList);
//        cardMap.put("S2", card2);
//        textComponentMap.put("S2", textComponentList);
//        cardMap.put("S3", card3);
//        textComponentMap.put("S3", textComponentList);

        add(panel1);
        add(panel2);
//        add(cards);

        setVisible(true);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.decode("#4FA6E7"));
        return panel;
    }
    private JPanel createCardPanel() {
        //Create an instance of the panel for each card.
        JPanel panel = new JPanel();

        //Add labels and text components to the panel.
        panel.add(yearL);
        panel.add(yearOutput);
        panel.add(subNameL);
        panel.add(subjOutput);
        panel.add(subClassL);
        panel.add(subClassTF);
        panel.add(teacherNameL);
        panel.add(teacherNameTF);
        panel.add(lessonTopicL);
        panel.add(lessonTopicTA);
        panel.add(homeworkL);
        panel.add(homeworkTA);
        panel.add(whereHomeworkL);
        panel.add(whereHomeworkTA);

        groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);

        //Add labels and text components to the GroupLayout
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(yearL).addComponent(yearOutput)
                .addComponent(subNameL).addComponent(subjOutput)
                .addComponent(subClassL).addComponent(subClassTF)
                .addComponent(teacherNameL).addComponent(teacherNameTF)
                .addComponent(lessonTopicL).addComponent(lessonTopicTA)
                .addComponent(homeworkL).addComponent(homeworkTA)
                .addComponent(whereHomeworkL).addComponent(whereHomeworkTA));

        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addComponent(yearL).addComponent(yearOutput)
                .addComponent(subNameL).addComponent(subjOutput)
                .addComponent(subClassL).addComponent(subClassTF)
                .addComponent(teacherNameL).addComponent(teacherNameTF)
                .addComponent(lessonTopicL).addComponent(lessonTopicTA)
                .addComponent(homeworkL).addComponent(homeworkTA)
                .addComponent(whereHomeworkL).addComponent(whereHomeworkTA));

        return panel;

    }
}


//    //Method to access each subject's text
//    protected void accessData(){
//        yearOutput.getText();
//        subjOutput.getText();
//        subClassTF.getText();
//        teacherNameTF.getText();
//        lessonTopicTA.getText();
//        homeworkTA.getText();
//        whereHomeworkTA.getText();
//
//    }
//   public JPanel accessPanel(){
//        JPanel panel = new JPanel();
//        getYearOutput();
//        getSubjOutput();
//        getSubClassTF();
//        getTeacherNameTF();
//        getHomeworkTA();
//        getWhereHomeworkTA();
//
//        return panel;
//    }
//
//    // Method to access each card's labels and text fields
//    protected void accessCardData() {
//        // Loop through the cardMap to access each card
//        for (String cardName : cardMap.keySet()) {
//            JPanel cardPanel = cardMap.get(cardName);
//
//            // Retrieve the associated list of text components for the current card
//            List<JTextComponent> textComponents = textComponentMap.get(cardName);
//
//            // Loop through the list of text components to access their labels and text fields
//            for (JTextComponent textComponent : textComponents) {
//                String labelText = null;
//
//                // Find the corresponding label for the current text component
//                for (Component component : cardPanel.getComponents()) {
//                    if (component instanceof JLabel) {
//                        JLabel label = (JLabel) component;
//                        if (label.getLabelFor() == textComponent) {
//                            labelText = label.getText();
//                            break;
//                        }
//                    }
//                }
//
//                // Print the label and text field value
//                if (labelText != null) {
//                    System.out.println(labelText + ": " + textComponent.getText());
//                }
//            }
//        }
//    }
//    public void showCardData(String cardName){
//        //
//        if(textComponentMap.containsKey(cardName)){
//            List<JTextComponent> textComponents = textComponentMap.get(cardName);
//            for(JTextComponent textComponent: textComponents){
//                System.out.println(textComponent.getName() + ": " + textComponent.getText());
//            }
//        }else{
//            System.out.println("Card not found" + cardName);
//        }
//    }



//    final static String S1Panel = "S1";
//    final static String S2Panel = "S2";
//    final static String S3Panel = "S3";
    //Retrieve the text from all text fields in the cards
//    StringBuilder outputText = new StringBuilder();
//
//    for(Map.Entry<String, List<JTextComponent>> entry: textComponentMap.entrySet()){
//        String cardName = entry.getKey();
//        List<JTextComponent> cardTextComponents = entry.getValue();
//        for(JTextComponent textComponent: cardTextComponents){
//            String cardText = textComponent.getText();
//            outputText.append(cardName).append(cardText);
//        }
//    }
// private void showCardForYear(String selectedYear) {
//        //Check if the selected year exists in the cardMap
//        if(cardMap.containsKey(selectedYear)){
//            //Show the selected card
//            cardLayout.show(cards, selectedYear);
//        }else{
//            //Handle the case when the selected year is not in the cardMap
//            System.out.println("Selected year doesn't exist " + selectedYear);
//        }
//    }

//    private void showCards(){
//        if(yearOutput.equals("S1")) {
//            CardLayout cl = new CardLayout();
//            cl.show(cards, "S1");
//        }else if (yearOutput.equals("S2")) {
//            CardLayout cl = new CardLayout();
//            cl.show(cards, "S2");
//        }else if (yearOutput.equals("S3")) {
//            CardLayout cl = new CardLayout();
//            cl.show(cards, "S3");
//        }
//    }

//        card1 = new JPanel();
//        card2 = new JPanel();
//        card3 = new JPanel();

//Create panel 2 to hold the form
//        panel2.setBackground(Color.decode("#4FA6E7"));
//        panel2.setPreferredSize(new Dimension(400, 600));
//        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        panel2.add(cards);

//        groupLayout = new GroupLayout(panel2);
//        panel2.setLayout(groupLayout);
//
//        groupLayout.setAutoCreateGaps(true);
//        groupLayout.setAutoCreateContainerGaps(true);
//
//        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//
//                .addComponent(yearL).addComponent(yearOutput)
//                .addComponent(subNameL).addComponent(subjOutput)
//                .addComponent(subClassL).addComponent(subClassTF)
//                .addComponent(teacherNameL).addComponent(teacherNameTF)
//                .addComponent(lessonTopicL).addComponent(lessonTopicTA)
//                .addComponent(homeworkL).addComponent(homeworkTA)
//                .addComponent(whereHomeworkL).addComponent(whereHomeworkTA));
//
//        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
//
//                .addComponent(yearL)
//                .addComponent(yearOutput)
//
//                .addComponent(subNameL)
//                .addComponent(subjOutput)
//
//                .addComponent(subClassL)
//                .addComponent(subClassTF)
//
//                .addComponent(teacherNameL)
//                .addComponent(teacherNameTF)
//
//                .addComponent(lessonTopicL)
//                .addComponent(lessonTopicTA)
//
//                .addComponent(homeworkL)
//                .addComponent(homeworkTA)
//
//                .addComponent(whereHomeworkL)
//                .addComponent(whereHomeworkTA));



//        panel2.setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        //WEST Fields
//        c.fill = GridBagConstraints.HORIZONTAL; //Natural height, maximum width.
//
//        c.gridx = 0;
//        c.gridy = 0;
//        c.weightx = 0.1;
//        c.anchor = GridBagConstraints.FIRST_LINE_START;
//        c.insets = new Insets(5, 5, 10, 0);
//        c.gridwidth = 1;
//        panel2.add(yearL, c);
//
//
//        c.gridx = 0;
//        c.gridy = 2;
//        c.weightx = 0.1;
//        c.anchor = GridBagConstraints.PAGE_START;
//        c.insets = new Insets(5, 5, 10, 0);
//        c.gridwidth = 1;
//        panel2.add(subNameL, c);
//
//        c.gridx = 0;
//        c.gridy = 4;
//        c.anchor = GridBagConstraints.PAGE_START;
//        c.insets = new Insets(0, 5, 10, 0);
//        c.gridwidth = 1;
//        panel2.add(subClassL, c);
//
//        c.gridx = 0;
//        c.gridy = 6;
//        c.anchor = GridBagConstraints.PAGE_START;
//        c.insets = new Insets(0, 5, 10, 0);
//        c.gridwidth = 1;
//        panel2.add(teacherNameL, c);
//
//        c.gridx = 0;
//        c.gridy = 8;
//        c.anchor = GridBagConstraints.PAGE_START;
//        c.insets = new Insets(0, 5, 5, 0);
//        c.gridwidth = 1;
//        panel2.add(lessonTopicL, c);
//
//        c.gridx = 0;
//        c.gridy = 10;
//        c.anchor = GridBagConstraints.PAGE_START;
//        c.insets = new Insets(0, 5, 5, 0);
//        c.gridwidth = 1;
//        panel2.add(homeworkL, c);
//
//        c.gridx = 0;
//        c.gridy = 12;
//        c.anchor = GridBagConstraints.PAGE_START;
//        c.insets = new Insets(0, 5, 5, 0);
//        c.gridwidth = 1;
//        panel2.add(whereHomeworkL, c);
//
//        //Next to WEST Fields
//        c.gridx = 2;
//        c.gridy = 0;
//        c.gridwidth = 3;
//        c.ipadx = 80;
//        c.insets = new Insets(5, 5, 10, 5);
//        panel2.add(yearOutput, c);
//
//        c.gridx = 2;
//        c.gridy = 2;
//        c.gridwidth = 3;
//        c.ipadx = 80;
//        c.insets = new Insets(5, 5, 10, 5);
//        panel2.add(subjOutput, c);
//
//        c.gridx = 2;
//        c.gridy = 4;
//        c.gridwidth = 3;
//        c.ipadx = 80;
//        c.insets = new Insets(0, 5, 10, 5);
//        panel2.add(subClassTF, c);
//
//        c.gridx = 2;
//        c.gridy = 6;
//        c.gridwidth = 3;
//        c.ipadx = 80;
//        c.insets = new Insets(0, 5, 10, 5);
//        panel2.add(teacherNameTF, c);
//
//        c.gridx = 2;
//        c.gridy = 8;
//        c.gridwidth = 3;
//        c.gridheight = 1;
//        c.insets = new Insets(0, 5, 10, 5);
//        panel2.add(lessonTopicTA, c);
//
//        c.gridx = 2;
//        c.gridy = 10;
//        c.gridwidth = 3;
//        c.gridheight = 1;
//        c.insets = new Insets(0, 5, 10, 5);
//        panel2.add(homeworkTA, c);
//
//        c.gridx = 2;
//        c.gridy = 12;
//        c.gridwidth = 3;
//        c.gridheight = 1;
//        c.weighty = 0.1;
//        c.insets = new Insets(0, 5, 5, 5);
//        panel2.add(whereHomeworkTA, c);

//c.weightx = 0.0; //property is used to specify how extra horizontal space is distributed among the columns in a grid layout
//c.weighty = 0.0;//this is important for specifying resizing behavior.

