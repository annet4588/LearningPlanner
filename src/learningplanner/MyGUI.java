package learningplanner;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class MyGUI extends JFrame {

    private UserIDPasswordMatch idPasswordMatch = new UserIDPasswordMatch();
    private Container contentPane;
    private MyMenu myMenu;
    private NavBar navbar;
    private HomePage homePage;
    private StudentsPage studentsPage;
    private TeachersPage teachersPage;
    private TimetablePage timetablePage;
    private LoginPage loginPage;
    private EventsPage eventsPage;
    private SearchPage searchPage;
    private MorePage morePage;
    private SubjectsPage subjectsPage;
    private ForgotPasswordPage forgotPasswordPage;
    private AccountPage accountPage;
    private ArtDesignPage artDesignPage;
    private BusinessEducationPage businessEducationPage;
    private ComputingSciencePage computingSciencePage;
    private DesignEngineeringPage designEngineeringPage;
    private DramaPage dramaPage;
    private EnglishPage englishPage;
    private HFTPage hftPage;
    private MathsPage mathsPage;
    private ModernLanguagesPage modernLanguagesPage;
    private MusicPage musicPage;
    private SciencePage sciencePage;
    private SocialStudiesPage socialStudiesPage;
    private RMEPage rmePage;
    private WellbeingPage wellbeingPage;
    public JButton button;

    MyGUI(){

//        loginInfo = new HashMap<String,String>();
        //Create and set up the window.
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 800);
        setTitle("Learning Planner");
        setIconImage(new ImageIcon("images/events.png").getImage());

        //Create and set up the content pane.
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(Color.decode("#4FA6E7"));

        //Add learningplanner.NavBar and learningplanner.MyMenu
        myMenu = new MyMenu(this);
        contentPane.add(BorderLayout.NORTH, myMenu.getMenuBar());
        navbar = new NavBar(this);
        contentPane.add(BorderLayout.SOUTH, navbar);

        //Create panels
        homePage = new HomePage(this);
        studentsPage = new StudentsPage(this);
        teachersPage = new TeachersPage(this);
        timetablePage = new TimetablePage(this);
        loginPage = new LoginPage(this, idPasswordMatch.getLoginInfo()); //Send the loginIngo as an argument to our learningplanner.LoginPage
        eventsPage = new EventsPage();
        searchPage = new SearchPage();
        morePage = new MorePage();
        subjectsPage = new SubjectsPage(this);
        forgotPasswordPage = new ForgotPasswordPage(this);
        accountPage = new AccountPage(this);
        artDesignPage = new ArtDesignPage(this);
        businessEducationPage = new BusinessEducationPage(this);
        computingSciencePage = new ComputingSciencePage(this);
        designEngineeringPage = new DesignEngineeringPage(this);
        dramaPage = new DramaPage(this);
        englishPage = new EnglishPage(this);
        hftPage = new HFTPage(this);
        mathsPage = new MathsPage(this);
        modernLanguagesPage = new ModernLanguagesPage(this);
        musicPage = new MusicPage(this);
        sciencePage = new SciencePage(this);
        socialStudiesPage = new SocialStudiesPage(this);
        rmePage = new RMEPage(this);
        wellbeingPage = new WellbeingPage(this);

        // Display the learningplanner.HomePage initially
        contentPane.add(BorderLayout.CENTER, homePage);

        //display the window
        setVisible(true);
    }

    //Method removing all the pages except the chosen one.
    private void removeAllPagesExcept(Component page){
        Component[] components = contentPane.getComponents();
        for(Component component: components) {
            if (component != page) {
                contentPane.remove(component);
            }
        }
    }
    //Method showing the chosen page, and adding the page to the contentPane.
    private void showPage(Component page){
        removeAllPagesExcept(page);
        contentPane.add(BorderLayout.CENTER, page);
        contentPane.add(BorderLayout.NORTH, myMenu.getMenuBar());
        contentPane.add(BorderLayout.SOUTH, navbar);
        revalidate();
        repaint();
    }

//    public void showPageFields(Component page){
//        Component[] pages = contentPane.getComponents();
//      for(Component component: pages){
//          if(component !=page){
//              showPage(component);
//          }
//      }
//    }

    public void showHomePage(){
        showPage(homePage);
    }
    public void showStudentsPage(){
        showPage(studentsPage);
    }
    public void showTeachersPage(){
        showPage(teachersPage);
    }
    public void showTimetablePage(){
        showPage(timetablePage);
    }
    public void showLoginPage(){
        showPage(loginPage);
    }

    public void showEventsPage(){
        showPage(eventsPage);
    }
    public void showSearchPage(){
        showPage(searchPage);
    }
    public void showMorePage(){
        showPage(morePage);
    }
    public void showSubjectsPage(){
        showPage(subjectsPage);
    }
    public void showForgotPasswordPage(){
        showPage(forgotPasswordPage);
    }
    public void showAccountPage(){
        showPage(accountPage);
    }

    //Methods to set fields in the Subject class
    public void showArtDesignPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                                  String lessonTA, String homeWTF, String whereHWTA){
        showPage(artDesignPage);
        artDesignPage.yearOutput.setText(selectedYear);
        artDesignPage.yearOutput.setEditable(false);
        artDesignPage.subjOutput.setText(selectedSubject);
        artDesignPage.subjOutput.setEditable(false);
        artDesignPage.subClassTF.setText(classTF);
        artDesignPage.subClassTF.setEditable(false);
        artDesignPage.teacherNameTF.setText(teacherNameTF);
        artDesignPage.teacherNameTF.setEditable(false);
        artDesignPage.lessonTopicTA.setText(lessonTA);
        artDesignPage.lessonTopicTA.setEditable(false);
        artDesignPage.homeworkTA.setText(homeWTF);
        artDesignPage.homeworkTA.setEditable(false);
        artDesignPage.whereHomeworkTA.setText(whereHWTA);
        artDesignPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(artDesignPage, false);
    }
    public void showBusinessEducationPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                                  String lessonTA, String homeWTF, String whereHWTA){
        showPage(businessEducationPage);
        businessEducationPage.yearOutput.setText(selectedYear);
        businessEducationPage.yearOutput.setEditable(false);
        businessEducationPage.subjOutput.setText(selectedSubject);
        businessEducationPage.subjOutput.setEditable(false);
        businessEducationPage.subClassTF.setText(classTF);
        businessEducationPage.subClassTF.setEditable(false);
        businessEducationPage.teacherNameTF.setText(teacherNameTF);
        businessEducationPage.teacherNameTF.setEditable(false);
        businessEducationPage.lessonTopicTA.setText(lessonTA);
        businessEducationPage.lessonTopicTA.setEditable(false);
        businessEducationPage.homeworkTA.setText(homeWTF);
        businessEducationPage.homeworkTA.setEditable(false);
        businessEducationPage.whereHomeworkTA.setText(whereHWTA);
        businessEducationPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(businessEducationPage, false);
    }
    public void showComputingSciencePage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                                          String lessonTA, String homeWTF, String whereHWTA){
        showPage(computingSciencePage);
        computingSciencePage.yearOutput.setText(selectedYear);
        computingSciencePage.yearOutput.setEditable(false);
        computingSciencePage.subjOutput.setText(selectedSubject);
        computingSciencePage.subjOutput.setEditable(false);
        computingSciencePage.subClassTF.setText(classTF);
        computingSciencePage.subClassTF.setEditable(false);
        computingSciencePage.teacherNameTF.setText(teacherNameTF);
        computingSciencePage.teacherNameTF.setEditable(false);
        computingSciencePage.lessonTopicTA.setText(lessonTA);
        computingSciencePage.lessonTopicTA.setEditable(false);
        computingSciencePage.homeworkTA.setText(homeWTF);
        computingSciencePage.homeworkTA.setEditable(false);
        computingSciencePage.whereHomeworkTA.setText(whereHWTA);
        computingSciencePage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(computingSciencePage, false);
    }
    public void showDesignEngineeringPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                                         String lessonTA, String homeWTF, String whereHWTA){
        showPage(designEngineeringPage);
        designEngineeringPage.yearOutput.setText(selectedYear);
        designEngineeringPage.yearOutput.setEditable(false);
        designEngineeringPage.subjOutput.setText(selectedSubject);
        designEngineeringPage.subjOutput.setEditable(false);
        designEngineeringPage.subClassTF.setText(classTF);
        designEngineeringPage.subClassTF.setEditable(false);
        designEngineeringPage.teacherNameTF.setText(teacherNameTF);
        designEngineeringPage.teacherNameTF.setEditable(false);
        designEngineeringPage.lessonTopicTA.setText(lessonTA);
        designEngineeringPage.lessonTopicTA.setEditable(false);
        designEngineeringPage.homeworkTA.setText(homeWTF);
        designEngineeringPage.homeworkTA.setEditable(false);
        designEngineeringPage.whereHomeworkTA.setText(whereHWTA);
        designEngineeringPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(designEngineeringPage, false);
    }
    public void showDramaPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                                          String lessonTA, String homeWTF, String whereHWTA){
        showPage(dramaPage);
        dramaPage.yearOutput.setText(selectedYear);
        dramaPage.yearOutput.setEditable(false);
        dramaPage.subjOutput.setText(selectedSubject);
        dramaPage.subjOutput.setEditable(false);
        dramaPage.subClassTF.setText(classTF);
        dramaPage.subClassTF.setEditable(false);
        dramaPage.teacherNameTF.setText(teacherNameTF);
        dramaPage.teacherNameTF.setEditable(false);
        dramaPage.lessonTopicTA.setText(lessonTA);
        dramaPage.lessonTopicTA.setEditable(false);
        dramaPage.homeworkTA.setText(homeWTF);
        dramaPage.homeworkTA.setEditable(false);
        dramaPage.whereHomeworkTA.setText(whereHWTA);
        dramaPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(dramaPage, false);
    }
    public void showEnglishPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                              String lessonTA, String homeWTF, String whereHWTA){
        showPage(englishPage);
        englishPage.yearOutput.setText(selectedYear);
        englishPage.yearOutput.setEditable(false);
        englishPage.subjOutput.setText(selectedSubject);
        englishPage.subjOutput.setEditable(false);
        englishPage.subClassTF.setText(classTF);
        englishPage.subClassTF.setEditable(false);
        englishPage.teacherNameTF.setText(teacherNameTF);
        englishPage.teacherNameTF.setEditable(false);
        englishPage.lessonTopicTA.setText(lessonTA);
        englishPage.lessonTopicTA.setEditable(false);
        englishPage.homeworkTA.setText(homeWTF);
        englishPage.homeworkTA.setEditable(false);
        englishPage.whereHomeworkTA.setText(whereHWTA);
        englishPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(englishPage, false);
    }
    public void showHFTPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                                String lessonTA, String homeWTF, String whereHWTA){
        showPage(hftPage);
        hftPage.yearOutput.setText(selectedYear);
        hftPage.yearOutput.setEditable(false);
        hftPage.subjOutput.setText(selectedSubject);
        hftPage.subjOutput.setEditable(false);
        hftPage.subClassTF.setText(classTF);
        hftPage.subClassTF.setEditable(false);
        hftPage.teacherNameTF.setText(teacherNameTF);
        hftPage.teacherNameTF.setEditable(false);
        hftPage.lessonTopicTA.setText(lessonTA);
        hftPage.lessonTopicTA.setEditable(false);
        hftPage.homeworkTA.setText(homeWTF);
        hftPage.homeworkTA.setEditable(false);
        hftPage.whereHomeworkTA.setText(whereHWTA);
        hftPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(hftPage, false);
    }
    public void showMathsPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                            String lessonTA, String homeWTF, String whereHWTA){
        showPage(mathsPage);
        mathsPage.yearOutput.setText(selectedYear);
        mathsPage.yearOutput.setEditable(false);
        mathsPage.subjOutput.setText(selectedSubject);
        mathsPage.subjOutput.setEditable(false);
        mathsPage.subClassTF.setText(classTF);
        mathsPage.subClassTF.setEditable(false);
        mathsPage.teacherNameTF.setText(teacherNameTF);
        mathsPage.teacherNameTF.setEditable(false);
        mathsPage.lessonTopicTA.setText(lessonTA);
        mathsPage.lessonTopicTA.setEditable(false);
        mathsPage.homeworkTA.setText(homeWTF);
        mathsPage.homeworkTA.setEditable(false);
        mathsPage.whereHomeworkTA.setText(whereHWTA);
        mathsPage.whereHomeworkTA.setEditable(false);

        revalidate();
        repaint();
//        setFieldsEditable(mathsPage, false);
    }
    public void showModernLanguagesPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                              String lessonTA, String homeWTF, String whereHWTA){
        showPage(modernLanguagesPage);
        modernLanguagesPage.yearOutput.setText(selectedYear);
        modernLanguagesPage.yearOutput.setEditable(false);
        modernLanguagesPage.subjOutput.setText(selectedSubject);
        modernLanguagesPage.subjOutput.setEditable(false);
        modernLanguagesPage.subClassTF.setText(classTF);
        modernLanguagesPage.subClassTF.setEditable(false);
        modernLanguagesPage.teacherNameTF.setText(teacherNameTF);
        modernLanguagesPage.teacherNameTF.setEditable(false);
        modernLanguagesPage.lessonTopicTA.setText(lessonTA);
        modernLanguagesPage.lessonTopicTA.setEditable(false);
        modernLanguagesPage.homeworkTA.setText(homeWTF);
        modernLanguagesPage.homeworkTA.setEditable(false);
        modernLanguagesPage.whereHomeworkTA.setText(whereHWTA);
        modernLanguagesPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(modernLanguagesPage, false);
    }
    public void showMusicPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                                        String lessonTA, String homeWTF, String whereHWTA){
        showPage(musicPage);
        musicPage.yearOutput.setText(selectedYear);
        musicPage.yearOutput.setEditable(false);
        musicPage.subjOutput.setText(selectedSubject);
        musicPage.subjOutput.setEditable(false);
        musicPage.subClassTF.setText(classTF);
        musicPage.subClassTF.setEditable(false);
        musicPage.teacherNameTF.setText(teacherNameTF);
        musicPage.teacherNameTF.setEditable(false);
        musicPage.lessonTopicTA.setText(lessonTA);
        musicPage.lessonTopicTA.setEditable(false);
        musicPage.homeworkTA.setText(homeWTF);
        musicPage.homeworkTA.setEditable(false);
        musicPage.whereHomeworkTA.setText(whereHWTA);
        musicPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(musicPage, false);
    }
    public void showSciencePage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                              String lessonTA, String homeWTF, String whereHWTA){
        showPage(sciencePage);
        sciencePage.yearOutput.setText(selectedYear);
        sciencePage.yearOutput.setEditable(false);
        sciencePage.subjOutput.setText(selectedSubject);
        sciencePage.subjOutput.setEditable(false);
        sciencePage.subClassTF.setText(classTF);
        sciencePage.subClassTF.setEditable(false);
        sciencePage.teacherNameTF.setText(teacherNameTF);
        sciencePage.teacherNameTF.setEditable(false);
        sciencePage.lessonTopicTA.setText(lessonTA);
        sciencePage.lessonTopicTA.setEditable(false);
        sciencePage.homeworkTA.setText(homeWTF);
        sciencePage.homeworkTA.setEditable(false);
        sciencePage.whereHomeworkTA.setText(whereHWTA);
        sciencePage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(sciencePage, false);
    }
    public void showSocialStudiesPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                                String lessonTA, String homeWTF, String whereHWTA){
        showPage(socialStudiesPage);
        socialStudiesPage.yearOutput.setText(selectedYear);
        socialStudiesPage.yearOutput.setEditable(false);
        socialStudiesPage.subjOutput.setText(selectedSubject);
        socialStudiesPage.subjOutput.setEditable(false);
        socialStudiesPage.subClassTF.setText(classTF);
        socialStudiesPage.subClassTF.setEditable(false);
        socialStudiesPage.teacherNameTF.setText(teacherNameTF);
        socialStudiesPage.teacherNameTF.setEditable(false);
        socialStudiesPage.lessonTopicTA.setText(lessonTA);
        socialStudiesPage.lessonTopicTA.setEditable(false);
        socialStudiesPage.homeworkTA.setText(homeWTF);
        socialStudiesPage.homeworkTA.setEditable(false);
        socialStudiesPage.whereHomeworkTA.setText(whereHWTA);
        socialStudiesPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(socialStudiesPage, false);
    }
    public void showRMEPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                                      String lessonTA, String homeWTF, String whereHWTA){
        showPage(rmePage);
        rmePage.yearOutput.setText(selectedYear);
        rmePage.yearOutput.setEditable(false);
        rmePage.subjOutput.setText(selectedSubject);
        rmePage.subjOutput.setEditable(false);
        rmePage.subClassTF.setText(classTF);
        rmePage.subClassTF.setEditable(false);
        rmePage.teacherNameTF.setText(teacherNameTF);
        rmePage.teacherNameTF.setEditable(false);
        rmePage.lessonTopicTA.setText(lessonTA);
        rmePage.lessonTopicTA.setEditable(false);
        rmePage.homeworkTA.setText(homeWTF);
        rmePage.homeworkTA.setEditable(false);
        rmePage.whereHomeworkTA.setText(whereHWTA);
        rmePage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(rmePage, false);
    }
    public void showWellbeingPage(String selectedYear, String selectedSubject, String classTF, String teacherNameTF,
                            String lessonTA, String homeWTF, String whereHWTA){
        showPage(wellbeingPage);
        wellbeingPage.yearOutput.setText(selectedYear);
        wellbeingPage.yearOutput.setEditable(false);
        wellbeingPage.subjOutput.setText(selectedSubject);
        wellbeingPage.subjOutput.setEditable(false);
        wellbeingPage.subClassTF.setText(classTF);
        wellbeingPage.subClassTF.setEditable(false);
        wellbeingPage.teacherNameTF.setText(teacherNameTF);
        wellbeingPage.teacherNameTF.setEditable(false);
        wellbeingPage.lessonTopicTA.setText(lessonTA);
        wellbeingPage.lessonTopicTA.setEditable(false);
        wellbeingPage.homeworkTA.setText(homeWTF);
        wellbeingPage.homeworkTA.setEditable(false);
        wellbeingPage.whereHomeworkTA.setText(whereHWTA);
        wellbeingPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
//        setFieldsEditable(wellbeingPage, false);
    }


    //Methods to get fields from all the subjects and show page in the Student class
    public void showArtDesignPage(){
        showPage(artDesignPage);
        artDesignPage.yearOutput.getText();
        artDesignPage.yearOutput.setEditable(false);
        artDesignPage.subjOutput.getText();
        artDesignPage.subjOutput.setEditable(false);
        artDesignPage.subClassTF.getText();
        artDesignPage.subClassTF.setEditable(false);
        artDesignPage.teacherNameTF.getText();
        artDesignPage.teacherNameTF.setEditable(false);
        artDesignPage.lessonTopicTA.getText();
        artDesignPage.lessonTopicTA.setEditable(false);
        artDesignPage.homeworkTA.getText();
        artDesignPage.homeworkTA.setEditable(false);
        artDesignPage.whereHomeworkTA.getText();
        artDesignPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showBusinessEducationPage(){
        showPage(businessEducationPage);
        businessEducationPage.yearOutput.getText();
        businessEducationPage.yearOutput.setEditable(false);
        businessEducationPage.subjOutput.getText();
        businessEducationPage.subjOutput.setEditable(false);
        businessEducationPage.subClassTF.getText();
        businessEducationPage.subClassTF.setEditable(false);
        businessEducationPage.teacherNameTF.getText();
        businessEducationPage.teacherNameTF.setEditable(false);
        businessEducationPage.lessonTopicTA.getText();
        businessEducationPage.lessonTopicTA.setEditable(false);
        businessEducationPage.homeworkTA.getText();
        businessEducationPage.homeworkTA.setEditable(false);
        businessEducationPage.whereHomeworkTA.getText();
        businessEducationPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showComputingSciencePage(){
        showPage(computingSciencePage);
        computingSciencePage.yearOutput.getText();
        computingSciencePage.yearOutput.setEditable(false);
        computingSciencePage.subjOutput.getText();
        computingSciencePage.subjOutput.setEditable(false);
        computingSciencePage.subClassTF.getText();
        computingSciencePage.subClassTF.setEditable(false);
        computingSciencePage.teacherNameTF.getText();
        computingSciencePage.teacherNameTF.setEditable(false);
        computingSciencePage.lessonTopicTA.getText();
        computingSciencePage.lessonTopicTA.setEditable(false);
        computingSciencePage.homeworkTA.getText();
        computingSciencePage.homeworkTA.setEditable(false);
        computingSciencePage.whereHomeworkTA.getText();
        computingSciencePage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showDesignEngineeringPage(){
        showPage(designEngineeringPage);
        designEngineeringPage.yearOutput.getText();
        designEngineeringPage.yearOutput.setEditable(false);
        designEngineeringPage.subjOutput.getText();
        designEngineeringPage.subjOutput.setEditable(false);
        designEngineeringPage.subClassTF.getText();
        designEngineeringPage.subClassTF.setEditable(false);
        designEngineeringPage.teacherNameTF.getText();
        designEngineeringPage.teacherNameTF.setEditable(false);
        designEngineeringPage.lessonTopicTA.getText();
        designEngineeringPage.lessonTopicTA.setEditable(false);
        designEngineeringPage.homeworkTA.getText();
        designEngineeringPage.homeworkTA.setEditable(false);
        designEngineeringPage.whereHomeworkTA.getText();
        designEngineeringPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showDramaPage(){
        showPage(dramaPage);
        dramaPage.yearOutput.getText();
        dramaPage.yearOutput.setEditable(false);
        dramaPage.subjOutput.getText();
        dramaPage.subjOutput.setEditable(false);
        dramaPage.subClassTF.getText();
        dramaPage.subClassTF.setEditable(false);
        dramaPage.teacherNameTF.getText();
        dramaPage.teacherNameTF.setEditable(false);
        dramaPage.lessonTopicTA.getText();
        dramaPage.lessonTopicTA.setEditable(false);
        dramaPage.homeworkTA.getText();
        dramaPage.homeworkTA.setEditable(false);
        dramaPage.whereHomeworkTA.getText();
        dramaPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showEnglishPage(){
        showPage(englishPage);
        englishPage.yearOutput.getText();
        englishPage.yearOutput.setEditable(false);
        englishPage.subjOutput.getText();
        englishPage.subjOutput.setEditable(false);
        englishPage.subClassTF.getText();
        englishPage.subClassTF.setEditable(false);
        englishPage.teacherNameTF.getText();
        englishPage.teacherNameTF.setEditable(false);
        englishPage.lessonTopicTA.getText();
        englishPage.lessonTopicTA.setEditable(false);
        englishPage.homeworkTA.getText();
        englishPage.homeworkTA.setEditable(false);
        englishPage.whereHomeworkTA.getText();
        englishPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showHFTPage(){
        showPage(hftPage);
        hftPage.yearOutput.getText();
        hftPage.yearOutput.setEditable(false);
        hftPage.subjOutput.getText();
        hftPage.subjOutput.setEditable(false);
        hftPage.subClassTF.getText();
        hftPage.subClassTF.setEditable(false);
        hftPage.teacherNameTF.getText();
        hftPage.teacherNameTF.setEditable(false);
        hftPage.lessonTopicTA.getText();
        hftPage.lessonTopicTA.setEditable(false);
        hftPage.homeworkTA.getText();
        hftPage.homeworkTA.setEditable(false);
        hftPage.whereHomeworkTA.getText();
        hftPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showMathsPage(){
        showPage(mathsPage);
        mathsPage.yearOutput.getText();
        mathsPage.yearOutput.setEditable(false);
        mathsPage.subjOutput.getText();
        mathsPage.subjOutput.setEditable(false);
        mathsPage.subClassTF.getText();
        mathsPage.subClassTF.setEditable(false);
        mathsPage.teacherNameTF.getText();
        mathsPage.teacherNameTF.setEditable(false);
        mathsPage.lessonTopicTA.getText();
        mathsPage.lessonTopicTA.setEditable(false);
        mathsPage.homeworkTA.getText();
        mathsPage.homeworkTA.setEditable(false);
        mathsPage.whereHomeworkTA.getText();
        mathsPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showModernLanguagesPage(){
        showPage(modernLanguagesPage);
        modernLanguagesPage.yearOutput.getText();
        modernLanguagesPage.yearOutput.setEditable(false);
        modernLanguagesPage.subjOutput.getText();
        modernLanguagesPage.subjOutput.setEditable(false);
        modernLanguagesPage.subClassTF.getText();
        modernLanguagesPage.subClassTF.setEditable(false);
        modernLanguagesPage.teacherNameTF.getText();
        modernLanguagesPage.teacherNameTF.setEditable(false);
        modernLanguagesPage.lessonTopicTA.getText();
        modernLanguagesPage.lessonTopicTA.setEditable(false);
        modernLanguagesPage.homeworkTA.getText();
        modernLanguagesPage.homeworkTA.setEditable(false);
        modernLanguagesPage.whereHomeworkTA.getText();
        modernLanguagesPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showMusicPage(){
        showPage(musicPage);
        musicPage.yearOutput.getText();
        musicPage.yearOutput.setEditable(false);
        musicPage.subjOutput.getText();
        musicPage.subjOutput.setEditable(false);
        musicPage.subClassTF.getText();
        musicPage.subClassTF.setEditable(false);
        musicPage.teacherNameTF.getText();
        musicPage.teacherNameTF.setEditable(false);
        musicPage.lessonTopicTA.getText();
        musicPage.lessonTopicTA.setEditable(false);
        musicPage.homeworkTA.getText();
        musicPage.homeworkTA.setEditable(false);
        musicPage.whereHomeworkTA.getText();
        musicPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showSciencePage(){
        showPage(sciencePage);
        sciencePage.yearOutput.getText();
        sciencePage.yearOutput.setEditable(false);
        sciencePage.subjOutput.getText();
        sciencePage.subjOutput.setEditable(false);
        sciencePage.subClassTF.getText();
        sciencePage.subClassTF.setEditable(false);
        sciencePage.teacherNameTF.getText();
        sciencePage.teacherNameTF.setEditable(false);
        sciencePage.lessonTopicTA.getText();
        sciencePage.lessonTopicTA.setEditable(false);
        sciencePage.homeworkTA.getText();
        sciencePage.homeworkTA.setEditable(false);
        sciencePage.whereHomeworkTA.getText();
        sciencePage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showSocialStudiesPage(){
        showPage(socialStudiesPage);
        socialStudiesPage.yearOutput.getText();
        socialStudiesPage.yearOutput.setEditable(false);
        socialStudiesPage.subjOutput.getText();
        socialStudiesPage.subjOutput.setEditable(false);
        socialStudiesPage.subClassTF.getText();
        socialStudiesPage.subClassTF.setEditable(false);
        socialStudiesPage.teacherNameTF.getText();
        socialStudiesPage.teacherNameTF.setEditable(false);
        socialStudiesPage.lessonTopicTA.getText();
        socialStudiesPage.lessonTopicTA.setEditable(false);
        socialStudiesPage.homeworkTA.getText();
        socialStudiesPage.homeworkTA.setEditable(false);
        socialStudiesPage.whereHomeworkTA.getText();
        socialStudiesPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }
    public void showRMEPage(){
        showPage(rmePage);
        rmePage.yearOutput.getText();
        rmePage.yearOutput.setEditable(false);
        rmePage.subjOutput.getText();
        rmePage.subjOutput.setEditable(false);
        rmePage.subClassTF.getText();
        rmePage.subClassTF.setEditable(false);
        rmePage.teacherNameTF.getText();
        rmePage.teacherNameTF.setEditable(false);
        rmePage.lessonTopicTA.getText();
        rmePage.lessonTopicTA.setEditable(false);
        rmePage.homeworkTA.getText();
        rmePage.homeworkTA.setEditable(false);
        rmePage.whereHomeworkTA.getText();
        rmePage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }

    public void showWellbeingPage(){
        showPage(wellbeingPage);
        wellbeingPage.yearOutput.getText();
        wellbeingPage.yearOutput.setEditable(false);
        wellbeingPage.subjOutput.getText();
        wellbeingPage.subjOutput.setEditable(false);
        wellbeingPage.subClassTF.getText();
        wellbeingPage.subClassTF.setEditable(false);
        wellbeingPage.teacherNameTF.getText();
        wellbeingPage.teacherNameTF.setEditable(false);
        wellbeingPage.lessonTopicTA.getText();
        wellbeingPage.lessonTopicTA.setEditable(false);
        wellbeingPage.homeworkTA.getText();
        wellbeingPage.homeworkTA.setEditable(false);
        wellbeingPage.whereHomeworkTA.getText();
        wellbeingPage.whereHomeworkTA.setEditable(false);
        revalidate();
        repaint();
    }

    private void setFieldsEditable(JPanel panel, boolean editable){
        Component[] components = panel.getComponents();
        for(Component component: components){
            if(component instanceof JTextComponent) {
                JTextComponent textComponent = (JTextComponent) component;
                textComponent.setEditable(editable);
            }
        }
    }
    protected JButton createBackButton(){
        button = new JButton();
        button.setIcon(new ImageIcon("images/dArrowLeft.png"));
        button.setFocusable(false);
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(30, 30));
        button.setBackground(Color.decode("#4FA6E7"));
        return button;
    }



}

//    setComponentTextEditability(businessEducationPage.subjOutput,selectedSubject, false);
//    setComponentTextEditability(businessEducationPage.subjOutput,classTF, false);
//    setComponentTextEditability(businessEducationPage.subjOutput,teacherNameTF, false);
//    setComponentTextEditability(businessEducationPage.subjOutput,lessonTA, false);
//    setComponentTextEditability(businessEducationPage.subjOutput,homeWTF, false);
//    setComponentTextEditability(businessEducationPage.subjOutput,whereHWTA, false);

//  private void setComponentTextEditability(JTextComponent component, String text, boolean editable){
//        component.setText(text);
//        component.setEditable(editable);
//    }