package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnglishPage extends CreateSubject implements ActionListener {

    EnglishPage(MyGUI myGui) {
        super(myGui);

        title.setText("English");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
