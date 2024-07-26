
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Interface extends JFrame implements ActionListener {
    private JTextField InputCode;
    private JTextField InputAmount;

    JLabel ResultLabel;
    JButton ResetButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interface frame = new Interface();
                    frame.setVisible(true);
                    frame.setSize(900, 650);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*
     * Create the frame.
     */

    public Interface() {
        setResizable(false);
        getContentPane().setForeground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 240, 240));
        getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 51));
        getContentPane().setLayout(null);

        JLabel LabelWelcome = new JLabel("    Temperature Converter App");
        LabelWelcome.setBounds(151, 11, 622, 105);
        LabelWelcome.setForeground(new Color(255, 105, 180));
        LabelWelcome.setBackground(Color.LIGHT_GRAY);
        LabelWelcome.setFont(new Font("Times New Roman", Font.BOLD, 38));
        getContentPane().add(LabelWelcome);

        JLabel lblcelsius = new JLabel("1:Celsius");
        lblcelsius.setBounds(66, 101, 95, 30);
        lblcelsius.setForeground(new Color(0, 204, 204));
        lblcelsius.setBackground(SystemColor.menu);
        lblcelsius.setFont(new Font("Arial", Font.BOLD, 20));
        getContentPane().add(lblcelsius);

        JLabel lblkelvin = new JLabel("2:Kelvin ");
        lblkelvin.setForeground(new Color(0, 204, 204));
        lblkelvin.setFont(new Font("Arial", Font.BOLD, 20));
        lblkelvin.setBounds(72, 147, 89, 30);
        getContentPane().add(lblkelvin);

        JLabel lblfahrenheit = new JLabel("3:Fahrenheit ");
        lblfahrenheit.setFont(new Font("Arial", Font.BOLD, 20));
        lblfahrenheit.setForeground(new Color(0, 204, 204));
        lblfahrenheit.setBounds(63, 188, 179, 58);
        getContentPane().add(lblfahrenheit);

        JLabel LabelCode = new JLabel("Enter Temperature Code :");
        LabelCode.setBounds(10, 286, 263, 38);
        LabelCode.setForeground(new Color(0, 0, 0));
        LabelCode.setFont(new Font("Arial Black", Font.PLAIN, 17));
        getContentPane().add(LabelCode);

        JLabel LabelAmount = new JLabel("Enter Temperature:");
        LabelAmount.setFont(new Font("Arial Black", Font.PLAIN, 17));
        LabelAmount.setForeground(new Color(0, 0, 0));
        LabelAmount.setBounds(20, 335, 222, 52);
        getContentPane().add(LabelAmount);

        InputCode = new JTextField();
        InputCode.setBounds(284, 294, 179, 30);
        InputCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
        InputCode.setBackground(new Color(204, 255, 255));
        InputCode.setForeground(new Color(0, 0, 0));
        getContentPane().add(InputCode);
        InputCode.setColumns(5);

        InputAmount = new JTextField();
        InputAmount.setBounds(284, 345, 179, 30);
        InputAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
        InputAmount.setBackground(new Color(204, 255, 255));
        InputAmount.setForeground(new Color(0, 0, 0));
        InputAmount.setColumns(5);
        getContentPane().add(InputAmount);

        JButton ConvertButton = new JButton("Convert");
        ConvertButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String conversionResult = "";
                int choice = Integer.parseInt(InputCode.getText()); // For Converting String data type to Integer
                double celisus, kelvin, fahrenheit;

                if (choice == 1) {
                    celisus = Double.parseDouble(InputAmount.getText()); // For Converting String data type to Double
                    kelvin = celisus + 273.15;
                    conversionResult = "<html><p>Kelvin : " + kelvin + "K</p><br />";
                    fahrenheit = (celisus * 9 / 5) + 32;
                    conversionResult += "<p>Fahrenheit : " + (fahrenheit) + "F</p><br />";

                } else if (choice == 2) {
                    kelvin = Double.parseDouble(InputAmount.getText());
                    celisus = kelvin - 273.15;
                    conversionResult = "<html><p>Celisus : " + (celisus) + "C</p><br />";
                    fahrenheit = (kelvin - 273.15) * 9 / 5 + 32;
                    conversionResult += "<p>Fahrenheit : " + (fahrenheit) + "F</p><br />";

                } else if (choice == 3) {
                    fahrenheit = Double.parseDouble(InputAmount.getText());
                    celisus = (fahrenheit - 32) * 5 / 9;
                    conversionResult = "<html><p>Celisus : " + (celisus) + "C</p><br />";
                    kelvin = (fahrenheit - 32) * 5 / 9 + 273.15;
                    conversionResult += "<p>Kelvin : " + (kelvin) + "K</p><br />";

                } else
                    conversionResult = "You have Entered Invalid Code.......❌❌❌!";
                ResultLabel.setText(conversionResult);
            }
        });
        ConvertButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        ConvertButton.setForeground(new Color(220, 20, 60));
        ConvertButton.setBackground(new Color(102, 255, 255));
        ConvertButton.setBounds(666, 349, 95, 35);
        getContentPane().add(ConvertButton);

        ResultLabel = new JLabel();
        ResultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        ResultLabel.setForeground(new Color(0, 206, 209));
        ResultLabel.setBounds(212, 335, 538, 324);
        getContentPane().add(ResultLabel);

        JButton ResetButton = new JButton("Reset");
        ResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ResetButton) {
                    InputCode.setText(null);
                    InputAmount.setText(null);
                    ResultLabel.setText(null);
                }
            }
        });
        ResetButton.setBackground(new Color(102, 255, 255));
        ResetButton.setForeground(new Color(204, 51, 51));
        ResetButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        ResetButton.setBounds(782, 349, 95, 35);
        getContentPane().add(ResetButton);

        JLabel image = new JLabel("");
        image.setForeground(Color.LIGHT_GRAY);
        image.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\temp.jpg"));
        image.setBounds(659, 98, 395, 226);
        getContentPane().add(image);

        setBackground(Color.LIGHT_GRAY);
        setFont(null);
        setForeground(Color.LIGHT_GRAY);
        setTitle("Cuurency Converter");

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ResetButton) {
            InputCode.setText(null);
            InputAmount.setText(null);
            ResultLabel.setText(null);

        }
    }
}