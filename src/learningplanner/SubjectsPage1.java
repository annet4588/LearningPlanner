package learningplanner;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

public class SubjectsPage1 extends JPanel implements ItemListener, ActionListener {

    private CreateSubject createSubject;
    public JPanel cards;
    private CardLayout cardLayout;
    private JPanel card1, card2, card3;
    JPanel comboBoxPane;
    final static String S1Panel = "S1";
    final static String S2Panel = "S2";
    final static String S3Panel = "S3";
    private JPanel panel1, panel2, panel3;
    private JLabel title;
    private JLabel yearL, subNameL, subjOutput, subClassL, teacherNameL, lessonTopicL, homeworkL, whereHomeworkL;
    private JComboBox comboBoxYears, comboBoxSubjects;

    //Create an Array to hold the years
    private String[] years = {"Select Year", "S1", "S2", "S3"};

    //Create an Array to hold all subjects
    private String allSubj[] = {"Select Subject", "Art & Design", "Business Education", "Computing Science",
            "Design and Engineering", "Drama", "English", "HFT", "Maths", "Modern Languages",
            "Music", "Science", "Social Studies", "RME", "Wellbeing"};

    private JTextField subClassTF, teacherNameTF;
    private JTextArea lessonTopicTA, homeworkTA, whereHomeworkTA;
    private JButton submitFieldsB;
    private MyGUI gui;
    private String selectedYear, selectedSubject;
    private Map<String, JPanel> cardDetailsMap;
    private Map<String, JTextComponent> textComponentMap;
    private GroupLayout groupLayout;
    private JTextComponent textComponent;
    private String textComponentValue;


    SubjectsPage1(MyGUI myGui) {

        this.gui = myGui;

        setBackground(Color.decode("#4FA6E7"));
        setLayout(new FlowLayout(FlowLayout.CENTER));


        //Create a Title
        title = new JLabel("Subjects");
        title.setFont(new Font("Open Sans", Font.BOLD, 20));

        panel1 = createPanel();
        panel1.setPreferredSize(new Dimension(400, 40));
//        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.add(title);

        //Create Year label
        yearL = new JLabel("Choose Year");

        //Create ComboBox for Years
        comboBoxYears = new JComboBox(years);
        comboBoxYears.addItemListener(this);

        //Create Subject label
        subNameL = new JLabel("Choose Subject");

        //Create Combobox for Subjects
        comboBoxSubjects = new JComboBox(allSubj);
        comboBoxSubjects.addItemListener(this);

        //Create a label for Subject Printing
        subjOutput = new JLabel("[Select Subject]");
        subjOutput.setForeground(Color.BLUE);

        //Create Class label
        subClassL = new JLabel("Choose Class");

        //Create Class Text field
        subClassTF = new JTextField();

        //Create teacher Name label
        teacherNameL = new JLabel("Teacher's name");

        //Create Teacher name Text field
        teacherNameTF = new JTextField();

        //Create Lesson Label
        lessonTopicL = new JLabel("Lesson Topics");

        //Create Lesson Topics Text Area
        lessonTopicTA = new JTextArea();
        lessonTopicTA.setPreferredSize(new Dimension(200, 130));
        lessonTopicTA.setLineWrap(true);

        //Create Homework Label
        homeworkL = new JLabel("Homework");

        //Create Homework Text Area
        homeworkTA = new JTextArea();
        homeworkTA.setPreferredSize(new Dimension(200, 130));
        homeworkTA.setLineWrap(true);

        //Create Where Homework label
        whereHomeworkL = new JLabel("Where is Homework");

        //Create Where Homework Text Area
        whereHomeworkTA = new JTextArea();
        whereHomeworkTA.setPreferredSize(new Dimension(200, 130));
        ;
        whereHomeworkTA.setLineWrap(true);

        //Create Submit button
        submitFieldsB = new JButton("Submit");
        submitFieldsB.setFocusable(false);
        submitFieldsB.setPreferredSize(new Dimension(100, 30));
        submitFieldsB.addActionListener(this);


//        //Create panel 2 to hold the form
//        panel2 = new JPanel();
//        panel2.setBackground(Color.decode("#4FA6E7"));
//        panel2.setPreferredSize(new Dimension(400, 600));
//        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
////        panel2.add(cards);

        groupLayout = new GroupLayout(panel2);
        panel2.setLayout(groupLayout);

        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)

                .addComponent(yearL).addComponent(comboBoxYears)
                .addComponent(subNameL).addComponent(comboBoxSubjects)
                .addComponent(subClassL).addComponent(subClassTF)
                .addComponent(teacherNameL).addComponent(teacherNameTF)
                .addComponent(lessonTopicL).addComponent(lessonTopicTA)
                .addComponent(homeworkL).addComponent(homeworkTA)
                .addComponent(whereHomeworkL).addComponent(whereHomeworkTA)
                .addComponent(submitFieldsB));
        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()

                .addComponent(yearL)
                .addComponent(comboBoxYears)

                .addComponent(subNameL)
                .addComponent(comboBoxSubjects)

                .addComponent(subClassL)
                .addComponent(subClassTF)

                .addComponent(teacherNameL)
                .addComponent(teacherNameTF)

                .addComponent(lessonTopicL)
                .addComponent(lessonTopicTA)

                .addComponent(homeworkL)
                .addComponent(homeworkTA)

                .addComponent(whereHomeworkL)
                .addComponent(whereHomeworkTA)
                .addComponent(submitFieldsB));


        //Create card 1
        card1 = new JPanel();
        card1.setName("S1");
        card1.add(panel2);

        //Create card 2
        card2 = new JPanel();
        card2.setName("S2");
        card2.add(panel2);

        //Create card3
        card3 = new JPanel();
        card3.setName("S3");
        card3.add(panel2);

        //Create panel, that contains the cards
        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);
        cards.add("S1", card1);
        cards.add("S2", card2);
        cards.add("S3", card3);

        //Create the map to store the card panels
        cardDetailsMap = new HashMap<>();
        cardDetailsMap.put("S1", card1);
        cardDetailsMap.put("S2", card2);
        cardDetailsMap.put("S3", card3);


        //Create the map to store the text fields
        textComponentMap = new HashMap<>();
        textComponentMap.put("S1", textComponent);

        //Store textFields for the card1
//        List<JTextComponent> textComponentsCard1 = new ArrayList<>();
//        textComponentsCard1.add(subClassTF);

        //Create the text fields
//        JTextField textField1 = new JTextField();
//        textFieldMap.put(S1Panel, textField1);
//
//        JTextField textField2 = new JTextField();
//        textFieldMap.put(S2Panel, textField2);
//
//        JTextField textField3 = new JTextField();
//        textFieldMap.put(S3Panel, textField3);

        add(panel1);
        add(panel2);

        setVisible(true);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.decode("#4FA6E7"));
        return panel;
    }

    private JPanel createCardPanel() {
        JPanel panel = new JPanel();
        return panel;
    }


    @Override
    public void itemStateChanged(ItemEvent e) {

        //Save the selected year and subject
        selectedYear = (String) comboBoxYears.getSelectedItem();
        selectedSubject = (String) comboBoxSubjects.getSelectedItem();

        //Show the corresponding card based on the selected year

//        //Get the current card name
//        Component currentCard = cards.getComponent(0);


        //Store the text field value in the current card
//        if()
        //Show the corresponding card
//        CardLayout cl = (CardLayout) cards.getLayout();
//        cardLayout.show(cards, selectedYear);
//
//        //Get the corresponding text field
//        JTextField textField = textFieldMap.get(selectedYear);
//        if (textField != null) {
//            textField.setText("");
//        }
//
//
//        saveCardDetails();
//        System.out.println();
    }


    //    JPanel selectedCard;
    @Override
    public void actionPerformed(ActionEvent e) {
        String classTF = subClassTF.getText();
        String teacherNTF = teacherNameTF.getText();
        String lessonTA = lessonTopicTA.getText();
        String homeWTF = homeworkTA.getText();
        String whereHWTA = whereHomeworkTA.getText();

        //     String classTF = textFieldMap.get(selectedYear).getText();
        //     String teacherNTF = textFieldMap.get(selectedYear).getText();
        //     String lessonTA = textFieldMap.get(selectedYear).getText();
        //     String homeWTF = textFieldMap.get(selectedYear).getText();
        //     String whereHWTA = textFieldMap.get(selectedYear).getText();

        Component currentCard = cards.getComponent(0);

        textComponent = textComponentMap.get(currentCard);

        if(textComponent != null){
            textComponentValue = textComponent.getText();
        }

        if (e.getSource() == submitFieldsB) {
            if (selectedYear != years[0] && selectedSubject != allSubj[0]) {
                JPanel selectedCard = cardDetailsMap.get(selectedYear);
                if (selectedCard != null && selectedCard.equals("S1")) {
                    cardLayout.show(card1, "S1");
                    System.out.println(currentCard + " " + textComponentValue);
//                    selectedCard.putClientProperty("cardDetails", new CardDetails(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA));
                }else if(selectedCard != null && selectedCard.equals("S2")){
                    cardLayout.show(card2, "S2");

                }else if(selectedCard != null && selectedCard.equals("S3")) {
                    cardLayout.show(card3, "S3");
                }


                    switch (selectedSubject) {
                    case "Art & Design":
                        gui.showArtDesignPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "Business Education":
                        gui.showBusinessEducationPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "Computing Science":
                        gui.showComputingSciencePage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "Design and Engineering":
                        gui.showDesignEngineeringPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "Drama":
                        gui.showDramaPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "English":
                        gui.showEnglishPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "HFT":
                        gui.showHFTPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "Maths":
                        gui.showMathsPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "Modern Languages":
                        gui.showModernLanguagesPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "Music":
                        gui.showMusicPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "Science":
                        gui.showSciencePage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "Social Studies":
                        gui.showSocialStudiesPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "RME":
                        gui.showRMEPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                    case "Wellbeing":
                        gui.showWellbeingPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
                        break;
                }
                System.out.println();
                clearFields();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Choose the Year and the Subject fields");
        }

    }

    private void clearFields() {
        comboBoxYears.setSelectedItem(years[0]);
        comboBoxSubjects.setSelectedItem(allSubj[0]);
        subClassTF.setText("");
        teacherNameTF.setText("");
        lessonTopicTA.setText("");
        homeworkTA.setText("");
        whereHomeworkTA.setText("");
    }


    private static class CardDetails {
        String comboBoxYears;
        String comboBoxSubjects;
        String subClass;
        String teachersName;
        String lessonTopic;
        String homework;
        String whereHomework;

        CardDetails(String comboBoxYears, String comboBoxSubjects, String subClass, String teachersName, String lessonTopic, String homework, String whereHomework) {
            this.comboBoxYears = comboBoxYears;
            this.comboBoxSubjects = comboBoxSubjects;
            this.subClass = subClass;
            this.teachersName = teachersName;
            this.lessonTopic = lessonTopic;
            this.homework = homework;
            this.whereHomework = whereHomework;

        }

        public String getComboBoxYears() {
            return comboBoxYears;
        }

        public String getComboBoxSubjects() {
            return comboBoxSubjects;
        }

        public String getSubClass() {
            return subClass;
        }

        public String getTeachersName() {
            return teachersName;
        }

        public String getLessonTopic() {
            return lessonTopic;
        }

        public String getHomework() {
            return homework;
        }

        public String getWhereHomework() {
            return whereHomework;
        }
    }

    public void saveCardDetails() {
        // Get the current selected card name from the JComboBox
        String selectedCardName = (String) comboBoxYears.getSelectedItem();

        // Retrieve the card details for the selected card
        CardDetails cardDetails = new CardDetails(selectedCardName, (String) comboBoxSubjects.getSelectedItem(),
                subClassTF.getText(), teacherNameTF.getText(), lessonTopicTA.getText(), homeworkTA.getText(), whereHomeworkTA.getText());

        // Store the card details in the cardDetailsMap
        cardDetailsMap.put(selectedCardName, cards);
    }
}