package learningplanner;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

public class SubjectsPage extends JPanel implements ItemListener, ActionListener {

    public JPanel cards;
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

    protected static JTextField subClassTF;
    protected static JTextField teacherNameTF;
    protected static JTextArea lessonTopicTA;
    protected static JTextArea homeworkTA;
    protected static JTextArea whereHomeworkTA;
    private JButton submitFieldsB;
    private MyGUI gui;
    private String selectedYear, selectedSubject;
    public Map<String, SubjectData> subjectDataMap;
    private Map<String, JPanel> cardDetailsMap;
    private Map<String, JTextComponent> textComponentMap;
    private GroupLayout groupLayout;
    private CardLayout cardLayout;

//    private JTextComponent textComponent;
//    private String textComponentValue;


    SubjectsPage(MyGUI myGui) {

        this.gui = myGui;

        setBackground(Color.decode("#4FA6E7"));
        setLayout(new FlowLayout(FlowLayout.CENTER));

//        subjectDataMap = new HashMap<>();
//
//        subjectDataMap.put("Art & Design", new SubjectData("Name", "Olga", "Music", "Yes", "Teams"));

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

        whereHomeworkTA.setLineWrap(true);

        //Create Submit button
        submitFieldsB = new JButton("Submit");
        submitFieldsB.setFocusable(false);
        submitFieldsB.setPreferredSize(new Dimension(100, 30));
        submitFieldsB.addActionListener(this);


        //Create panel 2 to hold the form
        panel2 = new JPanel();
        panel2.setBackground(Color.decode("#4FA6E7"));
        panel2.setPreferredSize(new Dimension(400, 600));
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        panel2.add(cards);

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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {

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
//        JTextField textField = textComponentMap.get(selectedYear);
//        if (textField != null) {
//            textField.setText("");
//        }
//
//       saveCardDetails();
        }
    }


    //    JPanel selectedCard;
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedYear = (String) comboBoxYears.getSelectedItem();
        selectedSubject = (String) comboBoxSubjects.getSelectedItem();
        String classTF = subClassTF.getText();
        String teacherNTF = teacherNameTF.getText();
        String lessonTA = lessonTopicTA.getText();
        String homeWTF = homeworkTA.getText();
        String whereHWTA = whereHomeworkTA.getText();

//        Component currentCard = cards.getComponent(0);
//
//        JTextComponent textComponent = textComponentMap.get(currentCard);
//
//        if(textComponent != null){
//            String textComponentValue = textComponent.getText();
//        }

        //     String classTF = textFieldMap.get(selectedYear).getText();
        //     String teacherNTF = textFieldMap.get(selectedYear).getText();
        //     String lessonTA = textFieldMap.get(selectedYear).getText();
        //     String homeWTF = textFieldMap.get(selectedYear).getText();
        //     String whereHWTA = textFieldMap.get(selectedYear).getText();

        if (e.getSource() == submitFieldsB) {
            if (selectedYear != years[0] && selectedSubject != allSubj[0]) {
                JPanel selectedCard = cardDetailsMap.get(selectedYear);


//                selectedCard.putClientProperty("cardDetails", new CardDetails(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA));
//
//                selectedCard.setName(selectedYear);
//                if (selectedCard != null && selectedCard.equals("S1")) {
//                    cardLayout.show(card1, "S1");
//                    System.out.println(currentCard + " " );
////
//                }else if(selectedCard != null && selectedCard.equals("S2")){
//                    cardLayout.show(card2,"S2");
//                    System.out.println(currentCard + " " );
//
//                }else if(selectedCard != null && selectedCard.equals("S3")){
//                    cardLayout.show(card2,"S3");
//                    System.out.println(currentCard + " " );
//
//                }

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
                System.out.println(selectedCard.getName());
                System.out.println(selectedSubject);
                System.out.println(classTF + "\n" + teacherNTF + "\n" + lessonTA + "\n" + homeWTF + "\n" + whereHWTA);
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


    public class SubjectData {
        private String className;
        private String teacherName;
        private String lessonTopic;
        private String homework;
        private String whereHomework;

        public String getClassName() {
            return className;
        }

        public String getTeacherName() {
            return teacherName;
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

        public SubjectData(String className, String teacherName, String lessonTopic, String homework, String whereHomework) {
            this.className = className;
            this.teacherName = teacherName;
            this.lessonTopic = lessonTopic;
            this.homework = homework;
            this.whereHomework = whereHomework;
        }

    }

    public SubjectData getSubjectData(String selectedSubject) {
        return subjectDataMap.get(selectedSubject);
    }

}
//    private static class CardDetails {
//        String comboBoxYears;
//        String comboBoxSubjects;
//        String subClass;
//        String teachersName;
//        String lessonTopic;
//        String homework;
//        String whereHomework;
//
//        CardDetails(String comboBoxYears, String comboBoxSubjects, String subClass, String teachersName, String lessonTopic, String homework, String whereHomework) {
//            this.comboBoxYears = comboBoxYears;
//            this.comboBoxSubjects = comboBoxSubjects;
//            this.subClass = subClass;
//            this.teachersName = teachersName;
//            this.lessonTopic = lessonTopic;
//            this.homework = homework;
//            this.whereHomework = whereHomework;
//
//        }
//
//        public String getComboBoxYears() {
//            return comboBoxYears;
//        }
//
//        public String getComboBoxSubjects() {
//            return comboBoxSubjects;
//        }
//
//        public String getSubClass() {
//            return subClass;
//        }
//
//        public String getTeachersName() {
//            return teachersName;
//        }
//
//        public String getLessonTopic() {
//            return lessonTopic;
//        }
//
//        public String getHomework() {
//            return homework;
//        }
//
//        public String getWhereHomework() {
//            return whereHomework;
//        }
//    }
//
//    public void saveCardDetails() {
//        // Get the current selected card name from the JComboBox
//        String selectedCardName = (String) comboBoxYears.getSelectedItem();
//
//        // Retrieve the card details for the selected card
//        CardDetails cardDetails = new CardDetails(selectedCardName, (String) comboBoxSubjects.getSelectedItem(),
//                subClassTF.getText(), teacherNameTF.getText(), lessonTopicTA.getText(), homeworkTA.getText(), whereHomeworkTA.getText());
//
//        // Store the card details in the cardDetailsMap
//        cardDetailsMap.put(selectedCardName, cards);
//    }


    // // Access the form components of "S1" card
    //                JTextField subClassTF_S1 = (JTextField) selectedCard.getComponentByName("subClassTF");
    //                JTextField teacherNameTF_S1 = (JTextField) selectedCard.getComponentByName("teacherNameTF");
    //                JTextArea lessonTopicTA_S1 = (JTextArea) selectedCard.getComponentByName("lessonTopicTA");
    //                JTextArea homeworkTA_S1 = (JTextArea) selectedCard.getComponentByName("homeworkTA");
    //                JTextArea whereHomeworkTA_S1 = (JTextArea) selectedCard.getComponentByName("whereHomeworkTA");
    //
    //                // Now you can manipulate the form components as needed
    //                subClassTF_S1.setText("Some value for S1");
    //                teacherNameTF_S1.setText("Teacher's name for S1");
    //                lessonTopicTA_S1.setText("Lesson topics for S1");
    //                homeworkTA_S1.setText("Homework for S1");
    //                whereHomeworkTA_S1.setText("Where is Homework for S1");

    //

    //private Component getComponentByName(Container container, String name) {
    //    for (Component component : container.getComponents()) {
    //        if (component.getName() != null && component.getName().equals(name)) {
    //            return component;
    //        }
    //        if (component instanceof Container) {
    //            Component foundComponent = getComponentByName((Container) component, name);
    //            if (foundComponent != null) {
    //                return foundComponent;
    //            }
    //        }
    //    }
    //    return null;
    //}


//    public void saveCardDetails() {
//
//        CardDetails cardDetails = new CardDetails((String) comboBoxYears.getSelectedItem(), (String) comboBoxSubjects.getSelectedItem(),
//                subClassTF.getText(), teacherNameTF.getText(), lessonTopicTA.getText(), homeworkTA.getText(), whereHomeworkTA.getText()
//        );
//        for (Map.Entry m : cardDetailsMap.entrySet()) {
//            System.out.println(m.getKey() + " " + m.getValue());
//
//        }
//        cardDetailsMap.put("cardDetails", cards);
//    }
//}
// public Object getCardDetails(String selectedYear, String selectedSubject, String classTF, String teacherNTF, String lessonTA, String homeWTF, String whereHWTA) {
//    return cards;
//    }
// selectedCard.putClientProperty("cardDetails", new CardDetails(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA));

//        // Initialize comboBox fields
//        comboBoxMap = new HashMap<>();
//        comboBoxMap.put(years, new JComboBox());
//        comboBoxMap.put(allSubj, new JComboBox());
//        // Initialize text fields
//        textFieldMap = new HashMap<>();
//        textFieldMap.put(subClassL, new JTextField());
//        textFieldMap.put(teacherNameL, new JTextField());
//        // Initialize labels
//        textAreaMap = new HashMap<>();
//        textAreaMap.put(lessonTopicL, new JTextArea());
//        textAreaMap.put(homeworkL, new JTextArea());
//        textAreaMap.put(whereHomeworkL, new JTextArea());
//
//        System.out.println(textFieldMap);

//        private JPanel createCard(String option){
//            JPanel cardPanel = new JPanel();
//
//            JLabel[] labels = new JLabel[7];
//            JTextField[] textfields = textFieldMap.get(option);
//        }

//        //Get the current card name
//        Component currentCard = cards.getComponent(0);
//
//        //Get the corresponding comboBox field
//        JComboBox currentComboBox = comboBoxMap.get(currentCard);
//        selectedYear = (String)currentComboBox.getSelectedItem();
//
//        //Store the comboBox field value in the current card
//        if(currentComboBox !=null){
//            System.out.println(selectedYear);
//        }
//        cardDetailsMap.put(cards, selectedYear);

//        CardLayout cl = (CardLayout) (cards.getLayout());
//        cl.show(cards, (String)e.getItem());

//    @Override
//    public void itemStateChanged(ItemEvent e) {
//        if(e.getSource()==comboBoxYears){
//            selectedYear=comboBoxYears.getSelectedItem().toString();
//        }else if(e.getSource()== comboBoxSubjects){
//            selectedSubject=(String) comboBoxSubjects.getSelectedItem();
//        }
//    }

//JPanel pane = new JPanel(new GridBagLayout());
//GridBagConstraints c = new GridBagConstraints();
//
////For each component to be added to this container:
////...Create the component...
////...Set instance variables in the GridBagConstraints instance...
//pane.add(theComponent, c);

//c.ipady = 0;       //reset to default
//c.ipady = 40;      //make this component tall
//c.weighty = 1.0;   //request any extra vertical space
//c.anchor = GridBagConstraints.PAGE_END; //bottom of space
//c.insets = new Insets(10,0,0,0);  //top padding
//c.gridx = 1;       //aligned with button 2
//c.gridwidth = 2;   //2 columns wide
//c.gridy = 2;       //third row

//c.weightx = 0.05; //property is used to specify how extra horizontal space is distributed among the columns in a grid layout
//c.weighty = 0.05;//this is important for specifying resizing behavior.

// selectedYear=comboBoxYears.getSelectedItem().toString();
//        selectedSubject=(String) comboBoxSubjects.getSelectedItem();
//        if(selectedYear.equals(S1Panel) && selectedSubject !=null){
//            subjOutput.setText("S1 Subject");
//            subClassTF.setText("S1 Class");
//            teacherNameTF.setText("S1 Teacher");
//            lessonTopicTA.setText("S1 Lesson Topics");
//            homeworkTA.setText("S1 Homework");
//            whereHomeworkTA.setText("S1 Where is Homework");
//        }else if(selectedYear.equals(S2Panel)){
//            subjOutput.setText("S2 Subject");
//            subClassTF.setText("S2 Class");
//            teacherNameTF.setText("S2 Teacher");
//            lessonTopicTA.setText("S2 Lesson Topics");
//            homeworkTA.setText("S2 Homework");
//            whereHomeworkTA.setText("S2 Where is Homework");
//        } else if(selectedYear.equals(S3Panel)){
//            subjOutput.setText("S3 Subject");
//            subClassTF.setText("S3 Class");
//            teacherNameTF.setText("S3 Teacher");
//            lessonTopicTA.setText("S3 Lesson Topics");
//            homeworkTA.setText("S3 Homework");
//            whereHomeworkTA.setText("S3 Where is Homework");
//        }

// @Override
//    public void actionPerformed(ActionEvent e) {
//        String classTF = subClassTF.getText();
//        String teacherNTF = teacherNameTF.getText();
//        String lessonTA = lessonTopicTA.getText();
//        String homeWTF = homeworkTA.getText();
//        String whereHWTA = whereHomeworkTA.getText();
//
//        if(e.getSource()==submitFieldsB){
//            if(selectedYear!=years[0]  && selectedSubject!=allSubj[0]){
//                if(selectedSubject == "Art & Design")
//                {
//                   gui.showArtDesignPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                   clearFields();
//
//                }else if(comboBoxSubjects.getSelectedItem() == "Business Education")
//                {
//                    gui.showBusinessEducationPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//
//                }else if(comboBoxSubjects.getSelectedItem() == "Computing Science")
//                {
//                    gui.showComputingSciencePage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }else if(comboBoxSubjects.getSelectedItem() == "Design and Engineering")
//                {
//                    gui.showDesignEngineeringPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }else if(comboBoxSubjects.getSelectedItem() == "Drama")
//                {
//                    gui.showDramaPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }else if(comboBoxSubjects.getSelectedItem() == "English")
//                {
//                    gui.showEnglishPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }else if(comboBoxSubjects.getSelectedItem() == "HFT")
//                {
//                    gui.showHFTPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }else if(comboBoxSubjects.getSelectedItem() == "Maths")
//                {
//                    gui.showMathsPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }else if(comboBoxSubjects.getSelectedItem() == "Modern Languages")
//                {
//                    gui.showModernLanguagesPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }else if(comboBoxSubjects.getSelectedItem() == "Music")
//                {
//                    gui.showMusicPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }else if(comboBoxSubjects.getSelectedItem() == "Science")
//                {
//                    gui.showSciencePage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }else if(comboBoxSubjects.getSelectedItem() == "Social Studies")
//                {
//                    gui.showSocialStudiesPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }else if(comboBoxSubjects.getSelectedItem() == "RME")
//                {
//                    gui.showRMEPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }
//                else if(comboBoxSubjects.getSelectedItem() == "Wellbeing")
//                {
//                    gui.showWellbeingPage(selectedYear, selectedSubject, classTF,teacherNTF, lessonTA, homeWTF, whereHWTA);
//                    clearFields();
//                }
//
//
//            }else{
//                JOptionPane.showMessageDialog(null,"Choose the Year and the Subject fields");
//            }
//        }
//    }

//private Map<String[], JComboBox> comboBoxMap;
//    private Map<JLabel, JTextField> textFieldMap;
//    private Map<JLabel, JTextArea> textAreaMap;

//  public CardDetails getEnteredDetails() {
//        JPanel selectedCard = cardDetailsMap.get(selectedYear);
//
//        if(selectedCard !=null){
//            return((CardDetails) selectedCard.getClientProperty("cardDetails"));
//        }
//        return null;
//
////        String selectedYear = (String) comboBoxYears.getSelectedItem();
////        String selectedSubject = (String) comboBoxSubjects.getSelectedItem();
////        String subClass = subClassTF.getText();
////        String teacherName = teacherNameTF.getText();
////        String lessonTopics = lessonTopicTA.getText();
////        String homework = homeworkTA.getText();
////        String whereHomework = whereHomeworkTA.getText();
////
////        return new CardDetails(selectedYear, selectedSubject, subClass, teacherName, lessonTopics, homework, whereHomework);
//    }

//package learningplanner;
//
//import javax.swing.*;
//import javax.swing.text.JTextComponent;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import java.util.*;
//
//public class SubjectsPage extends JPanel implements ItemListener, ActionListener {
//
//    private JPanel cards;
//    private JLabel title;
//    private JComboBox<String> comboBoxYears;
//    private JComboBox<String> comboBoxSubjects;
//    private JButton submitFieldsB;
//    private MyGUI gui;
//    private String selectedYear;
//    private String selectedSubject;
//    private Map<String, JPanel> cardDetailsMap;
//    private Map<String, JTextField> textFieldMap;
//
//
//    private String[] years = {"Select Year", "S1", "S2", "S3"};
//    private String[] allSubj = {"Select Subject", "Art & Design", "Business Education", "Computing Science",
//            "Design and Engineering", "Drama", "English", "HFT", "Maths", "Modern Languages",
//            "Music", "Science", "Social Studies", "RME", "Wellbeing"};
//
//    SubjectsPage(MyGUI myGui) {
//        this.gui = myGui;
//
//        setBackground(Color.decode("#4FA6E7"));
//        setLayout(new FlowLayout(FlowLayout.CENTER));
//
//        // Create a Title
//        title = new JLabel("Subjects");
//        title.setFont(new Font("Open Sans", Font.BOLD, 20));
//
//        JPanel panel1 = createPanel();
//        panel1.setPreferredSize(new Dimension(400, 40));
//        panel1.add(title);
//
//        // Create the cards
//        cards = new JPanel(new CardLayout());
//        cardDetailsMap = new HashMap<>();
//        textFieldMap = new HashMap<>();
//
//        for (String year : years) {
//            JPanel card = new JPanel();
//            card.setName(year);
//            cards.add(card, year);
//            cardDetailsMap.put(year, card);
//            JTextField textField = new JTextField();
//            textFieldMap.put(year, textField);
//        }
//
//        // Create the combo boxes
//        comboBoxYears = new JComboBox<>(years);
//        comboBoxYears.addItemListener(this);
//
//        comboBoxSubjects = new JComboBox<>(allSubj);
//        comboBoxSubjects.addItemListener(this);
//
//        // Create the submit button
//        submitFieldsB = new JButton("Submit");
//        submitFieldsB.setFocusable(false);
//        submitFieldsB.setPreferredSize(new Dimension(100, 30));
//        submitFieldsB.addActionListener(this);
//
//        JPanel panel2 = createPanel();
//        panel2.setPreferredSize(new Dimension(400, 600));
//        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        panel2.add(comboBoxYears);
//        panel2.add(comboBoxSubjects);
//        panel2.add(submitFieldsB);
//
//        add(panel1);
//        add(cards);
//        add(panel2);
//
//        setVisible(true);
//    }
//
//    private JPanel createPanel() {
//        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        panel.setBackground(Color.decode("#4FA6E7"));
//        return panel;
//    }
//
//    @Override
//    public void itemStateChanged(ItemEvent e) {
//        selectedYear = (String) comboBoxYears.getSelectedItem();
//        selectedSubject = (String) comboBoxSubjects.getSelectedItem();
//        CardLayout cl = (CardLayout) cards.getLayout();
//        cl.show(cards, selectedYear);
//        JTextComponent textField = textFieldMap.get(selectedYear);
//        if (textField != null) {
//            textField.setText("");
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == submitFieldsB) {
//            if (selectedYear.equals(years[0]) || selectedSubject.equals(allSubj[0])) {
//                JOptionPane.showMessageDialog(null, "Choose the Year and the Subject fields");
//            } else {
//                JPanel selectedCard = cardDetailsMap.get(selectedYear);
//                if (selectedCard != null) {
//                    String classTF = textFieldMap.get(selectedYear).getText();
//                    String teacherNTF = textFieldMap.get(selectedYear).getText();
//                    String lessonTA = textFieldMap.get(selectedYear).getText();
//                    String homeWTF = textFieldMap.get(selectedYear).getText();
//                    String whereHWTA = textFieldMap.get(selectedYear).getText();
//                    selectedCard.putClientProperty("cardDetails", new CardDetails(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA));
//
//                    switch (selectedSubject) {
//                        case "Art & Design":
//                            gui.showArtDesignPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "Business Education":
//                            gui.showBusinessEducationPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "Computing Science":
//                            gui.showComputingSciencePage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "Design and Engineering":
//                            gui.showDesignEngineeringPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "Drama":
//                            gui.showDramaPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "English":
//                            gui.showEnglishPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "HFT":
//                            gui.showHFTPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "Maths":
//                            gui.showMathsPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "Modern Languages":
//                            gui.showModernLanguagesPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "Music":
//                            gui.showMusicPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "Science":
//                            gui.showSciencePage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "Social Studies":
//                            gui.showSocialStudiesPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "RME":
//                            gui.showRMEPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                        case "Wellbeing":
//                            gui.showWellbeingPage(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA);
//                            break;
//                    }
//
//                    clearFields();
//                }
//            }
//        }
//    }
//
//    private void clearFields() {
//        comboBoxYears.setSelectedItem(years[0]);
//        comboBoxSubjects.setSelectedItem(allSubj[0]);
//        textFieldMap.values().forEach(JTextComponent::setText);
//    }
//
//    private static class CardDetails {
//        private final String comboBoxYears;
//        private final String comboBoxSubjects;
//        private final String subClass;
//        private final String teachersName;
//        private final String lessonTopic;
//        private final String homework;
//        private final String whereHomework;
//
//        CardDetails(String comboBoxYears, String comboBoxSubjects, String subClass, String teachersName, String lessonTopic, String homework, String whereHomework) {
//
//            this.comboBoxYears = comboBoxYears;
//            this.comboBoxSubjects = comboBoxSubjects;
//            this.subClass = subClass;
//            this.teachersName = teachersName;
//            this.lessonTopic = lessonTopic;
//            this.homework = homework;
//            this.whereHomework = whereHomework;
//        }
//
//        public String getComboBoxYears() {
//            return comboBoxYears;
//        }
//
//        public String getComboBoxSubjects() {
//            return comboBoxSubjects;
//        }
//
//        public String getSubClass() {
//            return subClass;
//        }
//
//        public String getTeachersName() {
//            return teachersName;
//        }
//
//        public String getLessonTopic() {
//            return lessonTopic;
//        }
//
//        public String getHomework() {
//            return homework;
//        }
//
//        public String getWhereHomework() {
//            return whereHomework;
//        }
//    }
//}


//        panel2.setLayout(new GridBagLayout());

//        GridBagConstraints c = new GridBagConstraints();
//        //WEST Fields
//        c.fill = GridBagConstraints.HORIZONTAL; //Natural height, maximum width.
//
//        c.gridx = 0;
//        c.gridy = 0;
//        c.weightx = 0.1;
//        c.anchor = GridBagConstraints.FIRST_LINE_START;
//        c.insets = new Insets(5, 5,10, 0 );
//        c.gridwidth = 1;
//        panel2.add(yearL, c);
//
//
//        c.gridx = 0;
//        c.gridy = 2;
//        c.weightx = 0.1;
//        c.anchor = GridBagConstraints.PAGE_START;
//        c.insets = new Insets(5, 5,10, 0 );
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
//        panel2.add(comboBoxYears, c);
//
//        c.gridx = 2;
//        c.gridy = 2;
//        c.gridwidth = 3;
//        c.ipadx = 80;
//        c.insets = new Insets(5, 5, 10, 5);
//        panel2.add(comboBoxSubjects, c);
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
//
//        c.gridx = 2;
//        c.gridy = 13;
//        c.ipadx = 30;
//        c.insets = new Insets(0, 5, 10, 5);
//        c.anchor = GridBagConstraints.PAGE_END;
//        panel2.add(submitFieldsB, c);