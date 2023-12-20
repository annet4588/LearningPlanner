package learningplanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JPanel implements ActionListener {
    private JPanel panel1;
    private JLabel title;
    private JPanel students, teachers, timetable;
    private JLabel studentsL, teachersL, timetableL;
    private JLabel learningImg, studentsImg, teachersImg, timetableImg;
    private JButton studentsB, teachersB, timetableB;
    private MyGUI gui;


    HomePage(MyGUI myGui) {
        this.gui = myGui;

        setBackground(Color.decode("#4FA6E7"));
        setLayout(new FlowLayout());
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Create a Title
        title = new JLabel("Learning Planner");
        title.setFont(new Font("Open Sans", Font.BOLD, 20));

        //Create the panel 1 to hold the Title.
        panel1 = createPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel1.setPreferredSize(new Dimension(400, 40));
//        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.add(title);

        //Create the Learning image inside a Label
        learningImg = new JLabel(new ImageIcon("images/planL192.png"));
        learningImg.setLayout(new FlowLayout(FlowLayout.CENTER));
//        learningImg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        learningImg.setBackground(Color.decode("#4FA6E7"));
        learningImg.setPreferredSize(new Dimension(400, 207));

//        panel2 = createPanel();
//        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
//        panel2.setPreferredSize(new Dimension(400,210));
//        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        panel2.add(learningImg);

        //Create the Students panel
        students = createPanel();
        students.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        students.setBackground(Color.WHITE);
        students.setPreferredSize(new Dimension(380, 110));

        studentsL = new JLabel("Students");
        studentsL.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        studentsL.setPreferredSize(new Dimension(100, 20)); // Set position and size
        studentsL.setFont(new Font("Open Sans", Font.BOLD, 16));

        studentsImg = new JLabel(new ImageIcon("images/Students.png"));
        studentsImg.setLayout(new FlowLayout(FlowLayout.LEFT));
        studentsImg.setPreferredSize(new Dimension(100, 100));
        studentsImg.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        studentsB = new JButton(new ImageIcon("images/arrowRight.png"));
        studentsB.setLayout(new FlowLayout(FlowLayout.RIGHT));
        studentsB.setFocusable(false);
        studentsB.setPreferredSize(new Dimension(40, 40));
        studentsB.setBorder(null);
        studentsB.setBackground(Color.WHITE);
        studentsB.addActionListener(this);

        students.add(studentsImg);
        students.add(studentsL); // Add label to the students panel
        students.add(studentsB);

        //Create Teachers panel.
        teachers = createPanel();
        teachers.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        teachers.setBackground(Color.WHITE);
        teachers.setPreferredSize(new Dimension(380, 110));

        teachersL = new JLabel("Teachers");
        teachersL.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        teachersL.setBounds(140, 10, 100, 20); // Set position and size
        teachersL.setFont(new Font("Open Sans", Font.BOLD, 16));

        teachersImg = new JLabel(new ImageIcon("images/Teachers.png"));
        teachersImg.setLayout(new FlowLayout(FlowLayout.LEFT));
        teachersImg.setPreferredSize(new Dimension(100, 100));

        teachersB = new JButton(new ImageIcon("images/arrowRight.png"));
        teachersB.setFocusable(false);
        teachersB.setPreferredSize(new Dimension(40, 40));
        teachersB.setBorder(null);
        teachersB.setBackground(Color.WHITE);
        teachersB.addActionListener(this);

        teachers.add(teachersImg);
        teachers.add(teachersL); // Add label to the students panel
        teachers.add(teachersB);

        //Create Timetable panel.
        timetable = createPanel();
        timetable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        timetable.setBackground(Color.WHITE);
        timetable.setPreferredSize(new Dimension(380, 110));

        timetableL = new JLabel("Timetable");
        timetableL.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        timetableL.setPreferredSize(new Dimension(100, 20)); // Set position and size
        timetableL.setFont(new Font("Open Sans", Font.BOLD, 16));

        timetableImg = new JLabel(new ImageIcon("images/Timetable.png"));
        timetableImg.setPreferredSize(new Dimension(100, 100));

        timetableB = new JButton(new ImageIcon("images/arrowRight.png"));
        timetableB.setFocusable(false);
        timetableB.setPreferredSize(new Dimension(40, 40));
        timetableB.setBorder(null);
        timetableB.setBackground(Color.WHITE);
        timetableB.addActionListener(this);

        timetable.add(timetableImg);
        timetable.add(timetableL); // Add label to the students panel
        timetable.add(timetableB);

        add(panel1);
        add(learningImg);
        add(students);
        add(teachers);
        add(timetable);

        setVisible(true);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.decode("#4FA6E7"));
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==studentsB){
            gui.showStudentsPage();
        }else if(e.getSource()==teachersB){
            gui.showLoginPage();
        }else if(e.getSource()==timetableB) {
            gui.showTimetablePage();
        }

    }
}
