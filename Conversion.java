import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Conversion {
    public static void main(String[] args) {
        JFrame f = new JFrame();

        String[] types = {
            "Speed",
            "Volume",
            "Currency"
        };

        final JComboBox cb = new JComboBox(types);
        cb.setBounds(50, 100, 90, 20);

        final JButton b = new JButton("Click Me");
        b.setBounds(50, 150, 90, 20);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println(types[cb.getSelectedIndex()]);
                System.exit(0);
            }
        });

        final JButton sb = new JButton(new ImageIcon("C:\\Users\\Adam\\Pictures\\Swap.png"));
        sb.setBounds(50, 200, 120, 90);

        f.add(cb);
        f.add(b); f.add(sb);








        /*final JLabel l1 = new JLabel("Input Field 1");
        l1.setBounds(50, 5, 120, 20);
        final JTextField tf1 = new JTextField();
        tf1.setBounds(50, 25, 120, 20);

        final JLabel l2 = new JLabel("Input Field 2");
        l2.setBounds(50, 45, 120, 20);
        final JTextField tf2 = new JTextField();
        tf2.setBounds(50, 65, 120, 20);

        JButton b = new JButton("Convert");
        b.setBounds(50, 90, 120, 30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println(tf1.getText());
                System.out.println(tf2.getText());
                System.exit(0);
            }
        });

        f.add(b);
        f.add(l1);      f.add(l2);
        f.add(tf1);     f.add(tf2);*/
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}