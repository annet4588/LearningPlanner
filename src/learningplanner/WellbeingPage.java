package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WellbeingPage extends CreateSubject implements ActionListener {

    WellbeingPage(MyGUI myGui) {
        super(myGui);

        title.setText("Wellbeing");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
