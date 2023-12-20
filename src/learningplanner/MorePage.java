package learningplanner;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class MorePage extends JPanel {
    JPanel panel1, panel2;
    JLabel title;
    String[] columnText = new String[]{
            "Week day",
            "1",
            "2",
            "3",
            "4",
            "5a",
            "5b",
            "5c",
            "6",
            "7",
    };
    Object[][] dataTimeTable = new Object[][]{
            {"Monday", "Design & Manufacture", "Mathematics", "Graphic Communication", "Physics", "", "Physical Education", "Physical Education", "English", "Chemistry"},
            {"Tuesday", "Design & Manufacture", "Mathematics", "Graphic Communication", "Physics", "", "Physical Education", "Physical Education", "English", "Chemistry"},
            {"Wednesday", "Design & Manufacture", "Mathematics", "Graphic Communication", "Physics", "", "Physical Education", "Physical Education", "English", "Chemistry"},
            {"Thursday", "Design & Manufacture", "Mathematics", "Graphic Communication", "Physics", "", "Physical Education", "Physical Education", "English", "Chemistry"},
            {"Friday", "Design & Manufacture", "Mathematics", "Graphic Communication", "Physics", "", "", "", "", ""},
    };

    JTable table = new JTable(dataTimeTable, columnText);
    TableRowSorter<TableModel> sort = new TableRowSorter<>(table.getModel());


    MorePage() {

        setBackground(Color.decode("#4FA6E7"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Create a Title
        title = new JLabel("More");
        title.setFont(new Font("Open Sans", Font.BOLD, 20));

        panel1 = createPanel();
        panel1.setPreferredSize(new Dimension(400, 20));
//        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.add(title);

        panel2 = createPanel();
        panel2.setPreferredSize(new Dimension(400, 600));
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //set the width of column
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(40);
        table.setRowSorter(sort);

        panel2.add(new JScrollPane(table));

        add(panel1);
        add(panel2);

        setVisible(true);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.decode("#4FA6E7"));
        return panel;
    }
}
