package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SciencePage extends CreateSubject implements ActionListener {

    SciencePage(MyGUI myGui) {
        super(myGui);

        title.setText("Science");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
