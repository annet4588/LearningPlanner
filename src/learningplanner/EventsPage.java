package learningplanner;

import javax.swing.*;
import java.awt.*;

public class EventsPage extends JPanel {
    JPanel panel1;
    JLabel title;

    EventsPage() {

        setBackground(Color.decode("#4FA6E7"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Create a Title
        title = new JLabel("Events");
        title.setFont(new Font("Open Sans", Font.BOLD, 20));

        panel1 = createPanel();
        panel1.setPreferredSize(new Dimension(400, 20));
//        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.add(title);

        add(panel1);

        setVisible(true);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.decode("#4FA6E7"));
        return panel;
    }

}


