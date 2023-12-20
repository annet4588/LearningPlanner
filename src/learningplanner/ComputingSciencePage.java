package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputingSciencePage extends CreateSubject implements ActionListener {

    ComputingSciencePage(MyGUI myGui) {
        super(myGui);

        title.setText("Computing Science");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
