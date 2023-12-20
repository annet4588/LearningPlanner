package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HFTPage extends CreateSubject implements ActionListener {

    HFTPage(MyGUI myGui) {
        super(myGui);

        title.setText("HFT");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
