import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.regex.Pattern;

public class RiceKgForm extends JFrame {
    private JCheckBox moduloCheckBox;
    private JCheckBox iterationCheckBox;
    private JTextField oneKiloBagsTextField;
    private JTextField fiveKiloBagsTextField;
    private JPanel mainPanel;
    private JPanel bagsPanel;
    private JTextField riceInKilosTextField;
    private JButton calcButton;

    public RiceKgForm() {
        this.setTitle("Rýže");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();

        moduloCheckBox.setSelected(true);

        moduloCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moduloCheckBox.isSelected()) {
                    iterationCheckBox.setSelected(false);
                } else {
                    iterationCheckBox.setSelected(true);
                }
            }
        });

        iterationCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (iterationCheckBox.isSelected()) {
                    moduloCheckBox.setSelected(false);
                } else {
                    moduloCheckBox.setSelected(true);
                }
            }
        });
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (oneKiloBagsTextField.getText().equals("") || !(Pattern.matches("^[0-9]+$", oneKiloBagsTextField.getText()))) {
                    JOptionPane.showMessageDialog(null, "Jednokilové pole není číslo!");
                } else {
                    if (fiveKiloBagsTextField.getText().equals("") || !(Pattern.matches("^[0-9]+$", fiveKiloBagsTextField.getText()))) {
                        JOptionPane.showMessageDialog(null, "Pětikilové pole není číslo!");
                    } else {
                        if (riceInKilosTextField.getText().equals("") || !(Pattern.matches("^[0-9]+$", riceInKilosTextField.getText()))) {
                            JOptionPane.showMessageDialog(null, "Kilogramy rýže není číslo!");
                        } else {
                            if (moduloCheckBox.isSelected()) {
                                PackagingModulo packaging = new PackagingModulo();
                                Bags bags = packaging.packageRiceIntoBags(
                                        Integer.parseInt(oneKiloBagsTextField.getText().toString()),
                                        Integer.parseInt(fiveKiloBagsTextField.getText().toString()),
                                        Integer.parseInt(riceInKilosTextField.getText().toString()));
                                JOptionPane.showMessageDialog(null, packaging.print(bags));
                            } else {
                                PackagingIteration packaging = new PackagingIteration();
                                Bags bags = packaging.packageRiceIntoBags(
                                        Integer.parseInt(oneKiloBagsTextField.getText().toString()),
                                        Integer.parseInt(fiveKiloBagsTextField.getText().toString()),
                                        Integer.parseInt(riceInKilosTextField.getText().toString()));
                                JOptionPane.showMessageDialog(null, packaging.print(bags));
                            }
                        }
                    }
                }
            }
        });
    }
}
