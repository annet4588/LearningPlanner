package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SocialStudiesPage extends CreateSubject implements ActionListener {

    SocialStudiesPage(MyGUI myGui) {
        super(myGui);

        title.setText("Social Studies");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
