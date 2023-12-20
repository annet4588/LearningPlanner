package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArtDesignPage extends CreateSubject implements ActionListener {

    ArtDesignPage(MyGUI myGui) {
        super(myGui);

        title.setText("Art & Design");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}

