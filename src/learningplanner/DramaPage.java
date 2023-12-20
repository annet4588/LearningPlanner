package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DramaPage extends CreateSubject implements ActionListener {

    DramaPage(MyGUI myGui) {
        super(myGui);

        title.setText("Drama");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
