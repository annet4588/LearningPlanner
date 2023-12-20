package learningplanner;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class SearchPage extends JPanel {
    JPanel panel1, panel2;
    JLabel title;
    String[]columns = new String[]{
            "Year",
            "Event",
            "Day",
            "Time"
    };

    //JTable data in 2D table
    Object[][] data = new Object[][]{
            {"S1", "Computing Club", "Monday", "15:30"},
            {"S2", "Computing Club", "Tuesday", "15:30"},
            {"S3", "Computing Club", "Wednesday", "15:30"},
            {"S1", "Science Club", "Tuesday", "15:30"},
            {"S2", "Science Club", "Wednesday", "15:30"},
            {"S3", "Science Club", "Monday", "15:30"},
    };

    //Create a JTable with data
    JTable table = new JTable(data, columns);

    TableRowSorter<TableModel> sort = new TableRowSorter<>(table.getModel());
    JLabel labelWord;
    JTextField textField;

    SearchPage() {

        setBackground(Color.decode("#4FA6E7"));
//        setLayout(new BorderLayout());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Create a Title
        title = new JLabel("Search");
        title.setFont(new Font("Open Sans", Font.BOLD, 20));


        panel1 = createPanel();
        panel1.setPreferredSize(new Dimension(400, 20));
//        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.add(title);

        //Set the width of the 3rd column to 200px
       TableColumnModel columnModel = table.getColumnModel();
       columnModel.getColumn(1).setPreferredWidth(100);

       table.setRowSorter(sort);

        labelWord = new JLabel("Search for Events");
        labelWord.setFont(new Font("Open Sans",Font.PLAIN, 15));
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 20));

        panel2 = createPanel();
        panel2.add(labelWord);
        panel2.add(textField);

        add(panel1);
        add(panel2);
        add(new JScrollPane(table));

        textField.getDocument().addDocumentListener(new DocumentListener() {

           @Override
            public void insertUpdate(DocumentEvent e) {
               String str = textField.getText();
               if(str.trim().length() == 0){
                   sort.setRowFilter(null);
               } else {
                   //(?i) means case-insensitive search
                   sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
               }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String str = textField.getText();
                if (str.trim().length() == 0) {
                    sort.setRowFilter(null);
                } else {
                    sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                }

            }

             @Override
             public void changedUpdate(DocumentEvent e) {

             }
             });



        setVisible(true);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.decode("#4FA6E7"));
        return panel;
    }
}

