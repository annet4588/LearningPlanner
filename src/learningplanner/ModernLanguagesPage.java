package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModernLanguagesPage extends CreateSubject implements ActionListener {

    ModernLanguagesPage(MyGUI myGui) {
        super(myGui);

        title.setText("Modern Languages");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
