package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesignEngineeringPage extends CreateSubject implements ActionListener {

    DesignEngineeringPage(MyGUI myGui) {
        super(myGui);

        title.setText("Design & Engineering");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
