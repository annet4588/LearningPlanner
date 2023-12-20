package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicPage extends CreateSubject implements ActionListener {

    MusicPage(MyGUI myGui) {
        super(myGui);

        title.setText("Music");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
