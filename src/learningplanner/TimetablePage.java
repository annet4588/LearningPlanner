package learningplanner;

import learningplanner.MyGUI;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class TimetablePage extends JPanel{
        JPanel panel1, panel2;
        JLabel title;
        MyGUI gui;
        //JTable Headers
        String[] columnText = new String[]{
                "Period",
                "Subject",

        };
        //Data for JTable in 2D table
        Object[][] dataTimeTable = new Object[][]{
                {"1", "Design & Manufacture"},
                {"2", "Mathematics"},
                {"3", "Graphic Communication"},
                {"4", "Physics"},
                {"5a", ""},
                {"5b", "Physical Education"},
                {"5c", "Physical Education"},
                {"6", "English"},
                {"7", "Chemistry"},
        };

        //Set the TableModel to get data from JTable
       TableModel dataModel = new AbstractTableModel() {
        @Override
        public int getRowCount() {
            return dataTimeTable.length;
        }

        @Override
        public int getColumnCount() {
            return columnText.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return dataTimeTable[row][col];
        }
        public String getColumnName(int column){
            return columnText[column];
        }

        public Class getColumnClass(int col){
            return getValueAt(0,col).getClass();
        }

        public void setValueAt(Object aValue, int row, int column){
            dataTimeTable[row][column] = aValue;
        }

       };
        JTable table = new JTable(dataModel);
        JScrollPane scrollPane;
        TableRowSorter<TableModel> sort = new TableRowSorter<>(table.getModel());


        TimetablePage(MyGUI myGui) {
            this.gui = myGui;

            setBackground(Color.decode("#4FA6E7"));
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            //Create a Title
            title = new JLabel("Timetable");
            title.setFont(new Font("Open Sans", Font.BOLD, 20));


            panel1 = createPanel();
            panel1.setPreferredSize(new Dimension(400, 20));
            panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel1.add(title);


            panel2 = createPanel();
            panel2.setPreferredSize(new Dimension(400, 600));
            panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));


//            table.setRowSorter(sort);
            table.setRowHeight(50);
            table.getColumnModel().getColumn(0).setPreferredWidth(40);


            scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(350, 500));

            panel2.add(scrollPane);


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


//set the width of column
//            TableColumnModel columnModel = table.getColumnModel();
//            columnModel.getColumn(0).setPreferredWidth(20);