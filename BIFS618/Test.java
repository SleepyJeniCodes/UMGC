//FallJFileChooser.java

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.*;

public class FallJFileChooser extends JFrame implements ActionListener {
        JMenuBar mb;
        JMenu file;
        JMenuItem open;
        JTextArea ta;

        public FallJFileChooser() {
                open = new JMenuItem("Open File");
                open.addActionListener(this);
                file = new JMenu("File");
                file.add(open);
                mb = new JMenuBar();
                mb.setBounds(0, 0, 800, 20);
                mb.add(file);
                ta = new JTextArea(800, 800);
                ta.setBounds(0, 20, 800, 800);
                add(mb);
                add(ta);
        }

        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == open) {
                        JFileChooser fc = new JFileChooser();
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
                        fc.setFileFilter(filter);
                        int i = fc.showOpenDialog(this);
                        if (i == JFileChooser.APPROVE_OPTION) {
                                File f = fc.getSelectedFile();
                                String filepath = f.getPath();
                                try {
                                        BufferedReader br = new BufferedReader(new FileReader(filepath));
                                        String s1 = "", s2 = "";
                                        s2 += ("Sequence is: ");
                                        s1 = br.readLine().toUpperCase();
                                        s2 += s1 + "\n";
                                        s2 += ("\n\n");
                                        int A = 0, G = 0, T = 0, C = 0, n = s1.length();
                                        for (int j = 0; j < n; j++) {
                                                if (s1.charAt(j) == 'A')
                                                        A++;
                                                else if (s1.charAt(j) == 'G')
                                                        G++;
                                                else if (s1.charAt(j) == 'T')
                                                        T++;
                                                else if (s1.charAt(j) == 'C')
                                                        C++;
                                        }
                                        s2 += ("Composition is as follows: \n");
                                        s2 += ("Number of A: " + A + "\n");
                                        s2 += ("Number of G: " + G + "\n");
                                        s2 += ("Number of T: " + T + "\n");
                                        s2 += ("Number of C: " + C + "\n");
                                        s2 += ("\n\n");
                                        s2 += ("GC content: " + ((G + C) * 100 / (A + G + T + C)) + "%\n");
                                        s2 += "\n";

                                        String complement = "";
                                        for (int j = 0; j < n; j++) {
                                                if (s1.charAt(j) == 'A')
                                                        complement += "T";
                                                else if (s1.charAt(j) == 'G')
                                                        complement += "C";
                                                else if (s1.charAt(j) == 'T')
                                                        complement += "A";
                                                else if (s1.charAt(j) == 'C')
                                                        complement += "G";
                                        }

                                        s2 += ("Complement of the above sequence is: " + complement + "\n\n");
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(s1);
                                        s1 = sb.reverse().toString();
                                        complement = "";
                                        for (int j = 0; j < n; j++) {
                                                if (s1.charAt(j) == 'A')
                                                        complement += "T";
                                                else if (s1.charAt(j) == 'G')
                                                        complement += "C";
                                                else if (s1.charAt(j) == 'T')
                                                        complement += "A";
                                                else if (s1.charAt(j) == 'C')
                                                        complement += "G";
                                        }

                                        s2 += ("Reverse Complement of the above sequence is: " + complement + "\n\n");

                                        ta.setText(s2);
                                        br.close();
                                } catch (Exception ex) {
                                        ex.printStackTrace();
                                }
                        }
                }
        }

}
//FallJFileChooserTest.java

import javax.swing.JFrame;

public class FallJFileChooserTest {
        public static void main(String[] args) {
                FallJFileChooser om = new FallJFileChooser();
                om.setSize(800, 500);
                om.setLayout(null);
                om.setVisible(true);
                om.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}