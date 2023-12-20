package learningplanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

public class StudentsPage extends JPanel implements ItemListener, ActionListener {

        JPanel panel1, panel2;
        JLabel title;
        JLabel studentsPageImg;
        MyGUI gui;
        JComboBox comboBoxYears, comboBoxSubjects, comboBoxClass;
        //Create Array to hold all subjects
        String allSubj[] = {"Select Subject", "Art & Design", "Business Education", "Computing Science",
            "Design and Engineering", "Drama", "English", "HFT", "Maths", "Modern Languages",
            "Music", "Science", "Social Studies", "RME", "Wellbeing"};
        String[] years = {"Select Year", "S1", "S2", "S3"};
//        String[] classes = {"Select Class", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9","1.10", "1.11", "1.12"};
        String selectedYear, selectedSubject, selectedClass;

        JPanel selectedCard;
        JButton buttonGo;

        StudentsPage(MyGUI myGui) {

            this.gui = myGui;

//            selectedCard = subjectsPage.getCardDetailsMap().get(selectedYear);
//            JPanel selectedCard = subjectsPage.getCardDetailsMap().get(selectedYear);

            setBackground(Color.decode("#4FA6E7"));
            setLayout(new FlowLayout(FlowLayout.CENTER));

            //Create a Title
            title = new JLabel("Students");
            title.setFont(new Font("Open Sans", Font.BOLD, 20));

            panel1 = createPanel();
            panel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            panel1.setPreferredSize(new Dimension(400, 40));
            panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel1.add(title);

            //Create studentPage image
            studentsPageImg = new JLabel(new ImageIcon("images/students200.png"));
//            studentsPageImg.setLayout(new FlowLayout(FlowLayout.CENTER));
            studentsPageImg.setBackground(Color.decode("#4FA6E7"));
            studentsPageImg.setPreferredSize(new Dimension(400, 204));

            //Create comboBox Years
            comboBoxYears = new JComboBox(years);
            comboBoxYears.addItemListener(this);

            //Create comboBox Subjects
            comboBoxSubjects = new JComboBox(allSubj);
            comboBoxSubjects.addItemListener(this);

            //Create Go button
            buttonGo = new JButton("GO");
            buttonGo.addActionListener(this);

            //Create comboBox Class
//            comboBoxClass = new JComboBox(allSubj);
//            comboBoxClass.addItemListener(this);

            //Create panel to hold the comboBox
            panel2 = new JPanel();
            panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            panel2.setPreferredSize(new Dimension(350, 40));
            panel2.setBackground(Color.decode("#4FA6E7"));
//            panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel2.add(comboBoxYears);
            panel2.add(comboBoxSubjects);
            panel2.add(buttonGo);
//            panel2.add(comboBoxClass);

            add(panel1);
            add(studentsPageImg);
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
            if(e.getStateChange()== ItemEvent.SELECTED) {
                selectedYear = (String) comboBoxYears.getSelectedItem();
                selectedSubject = (String) comboBoxSubjects.getSelectedItem();
            }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedYear = (String) comboBoxYears.getSelectedItem();
        selectedSubject = (String) comboBoxSubjects.getSelectedItem();


        if(e.getSource()==buttonGo){
            if (selectedYear != years[0] && selectedSubject != allSubj[0]){
                switch (selectedSubject) {
                    case "Art & Design":
                        gui.showArtDesignPage();
                        break;
                    case "Business Education":
                        gui.showBusinessEducationPage();
                        break;
                    case "Computing Science":
                        gui.showComputingSciencePage();
                        break;
                    case "Design and Engineering":
                        gui.showDesignEngineeringPage();
                        break;
                    case "Drama":
                        gui.showDramaPage();
                        break;
                    case "English":
                        gui.showEnglishPage();
                        break;
                    case "HFT":
                        gui.showHFTPage();
                        break;
                    case "Maths":
                        gui.showMathsPage();
                        break;
                    case "Modern Languages":
                        gui.showModernLanguagesPage();
                        break;
                    case "Music":
                        gui.showMusicPage();
                        break;
                    case "Science":
                        gui.showSciencePage();
                        break;
                    case "Social Studies":
                        gui.showSocialStudiesPage();
                        break;
                    case "RME":
                        gui.showRMEPage();
                        break;
                    case "Wellbeing":
                        gui.showWellbeingPage();
                        break;
                }
            }else{
                JOptionPane.showMessageDialog(null, "Choose the Year and the Subject fields");
            }
        }
    }

}



////            Map<String, JPanel> cardDetailsMap = subjectsPage.getCardDetailsMap();
////            selectedCard = null;
////
////            for(Map.Entry<String, JPanel> entry: cardDetailsMap.entrySet()){
////                selectedCard = entry.getValue();
////                if(selectedCard.getName().equals(selectedYear)){
////                    break;
////
////                }
////            }
////
////            if (selectedCard != null) {
////                CardLayout cardLayout = (CardLayout) subjectsPage.cards.getLayout();
////                cardLayout.show(subjectsPage.cards, selectedCard.getName());
////            }
//
////            CardLayout cardLayout = (CardLayout) subjectsPage.cards.getLayout();
////            cardLayout.show(subjectsPage.cards, selectedYear);
//if(selectedYear !=null){
    //                selectedCard.getClientProperty(subjectsPage.getCardDetails(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA));
     //               }
// JPanel selectedCard = subjectsPage.getCardDetailsMap().get(selectedYear);
//
//            if(selectedYear !=null){
//                selectedCard.putClientProperty("cardDetails", subjectsPage.getCardDetails(selectedYear, selectedSubject, classTF, teacherNTF, lessonTA, homeWTF, whereHWTA));
//            }

//else if(e.getSource()== comboBoxClass) {
//            selectedClass = (String)comboBoxClass.getSelectedItem();
//        }

