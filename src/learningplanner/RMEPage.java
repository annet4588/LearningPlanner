package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RMEPage extends CreateSubject implements ActionListener {

    RMEPage(MyGUI myGui) {
        super(myGui);

        title.setText("RME");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
