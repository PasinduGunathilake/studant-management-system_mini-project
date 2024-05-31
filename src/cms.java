import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class cms extends JFrame
{
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> contactList = new JList<>(listModel);

    private static int contactcounter = 1; // count added contacts

    String[] fac = {"Arts", "Agriculture", "Allied Health Science", "Engineering", "Medical", "Management & Commerce", "Science", "Technology" };


    JFrame frame = new JFrame();

    JLabel name = new JLabel();
    JTextField  g_name = new JTextField();
    JLabel faculty = new JLabel();
    JComboBox<String> g_faculty = new JComboBox<String>(fac);
    JLabel gmail = new JLabel();
    JTextField  g_gmail = new JTextField();
    JLabel tp = new JLabel();
    JTextField g_tp = new JTextField();
    JButton addb = new JButton("Add");
    JButton delb = new JButton("Delete");
    JButton upb = new JButton("Update");
    Border border = BorderFactory.createLineBorder(Color.black);
    JScrollPane scroll = new JScrollPane(contactList);
    JOptionPane s_add = new JOptionPane();
    JOptionPane s_del = new JOptionPane();
    JOptionPane s_upd = new JOptionPane();




    cms()
    {


        frame.setTitle("Student Contact Management System v.0.0");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);

        //name
        name.setText("Name");
        name.setBounds(20,50,100,20);
        frame.add(name);

        g_name.setBounds(100,50,200,20);
        frame.add(g_name);

        //faculty
        faculty.setText("Faculty");
        faculty.setBounds(20,80,100,20);
        frame.add(faculty);

        g_faculty.setBounds(100,80,200,20);
        frame.add(g_faculty);

        //phone no
        tp.setText("Phone no");
        tp.setBounds(20,110,100,20);
        frame.add(tp);

        g_tp.setBounds(100,110,200,20);
        frame.add(g_tp);

        //gmail
        gmail.setText("Gmail");
        gmail.setBounds(20,140,100,20);
        frame.add(gmail);

        g_gmail.setBounds(100,140,200,20);
        frame.add(g_gmail);


        //add button
        addb.setBounds(350,50,100,30);
        frame.add(addb);
        addb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String n = g_name.getText();
                String f = (String) g_faculty.getSelectedItem();
                String p = g_tp.getText();
                String g = g_gmail.getText();

                String a =contactcounter+"."+n+" | "+f+" | "+p+" | "+g;
                listModel.addElement(a.toString());

                //dialog box
                s_add.showMessageDialog(null, "Succesfully Saved!");

                g_name.setText("");
                g_faculty.setSelectedItem(null);
                g_tp.setText("");
                g_gmail.setText("");

                contactcounter++;
            }
        });

        //delete button
        delb.setBounds(350,130,100,30);
        frame.add(delb);
        delb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                int selectedIndex = contactList.getSelectedIndex();

                if(selectedIndex != -1) //for select any contact form the list
                {
                    listModel.remove(selectedIndex);
                }

                //dialog box
                s_add.showMessageDialog(null, "Succesfully Deleted!");
            }
        });


        //update button
        upb.setBounds(350,90,100,30);
        frame.add(upb);
        upb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                int selectedIndex = contactList.getSelectedIndex();

                if(selectedIndex != -1)
                {
                    String n = g_name.getText();
                    String f = (String) g_faculty.getSelectedItem();
                    String p = g_tp.getText();
                    String g = g_gmail.getText();

                    String updatecontact = (selectedIndex +1)+"."+n+" | "+f+" | "+p+" | "+g;

                    listModel.set(selectedIndex,updatecontact);

                    g_name.setText("");
                    g_faculty.setSelectedItem(null);
                    g_tp.setText("");
                    g_gmail.setText("");
                }

                //dialog box
                s_upd.showMessageDialog(null, "Succesfully Updated!");
            }
        });

        //scrollpane
        scroll.setBounds(20,175,440,250);
        frame.add(scroll);

    }
}





class Main
{
    public static void main(String [] args)
    {
        cms object = new cms();
    }

}