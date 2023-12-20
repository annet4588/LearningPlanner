package learningplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MathsPage extends CreateSubject implements ActionListener {

    MathsPage(MyGUI myGui) {
        super(myGui);

        title.setText("Maths");
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            gui.showSubjectsPage();
        }
    }
}
