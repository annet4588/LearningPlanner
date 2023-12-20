package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusinessEducationPage extends CreateSubject implements ActionListener {
    BusinessEducationPage(MyGUI myGui) {
        super(myGui);

        title.setText("Business Education");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
