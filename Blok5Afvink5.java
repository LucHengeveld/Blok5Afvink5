package Afvink5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Blok5Afvink5 extends JFrame implements ActionListener {
    private JTextField input;
    private JTextArea output;

    public static void main(String[] args) {
        Blok5Afvink5 frame = new Blok5Afvink5();
        frame.setSize(500, 200);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        //Plaatsen van een label
        JLabel label = new JLabel("Voer hieronder een aminozuur sequentie in om het te vertalen");
        window.add(label);
        //Einde label

        //Plaatsen van een een textfield voor de input
        input = new JTextField("");  // initalisatie (instantiering)
        input.setPreferredSize(new Dimension(475, 25));
        window.add(input);
        //Einde input textfield

        //Plaatsen van een button en actionlistener koppelen
        JButton vertaal = new JButton("Klik hier om de ingevoerde sequentie te vertalen"); //instantie
        window.add(vertaal);  // plaats button in window
        vertaal.setPreferredSize(new Dimension(475, 25));
        vertaal.addActionListener(this); //koppel actionlistener
        //Einde button

        //Plaatsen van een een textarea voor de input (voor meerdere regels te krijgen als output)
        output = new JTextArea("");  // initalisatie (instantiering)
        output.setPreferredSize(new Dimension(475, 75));
        output.setLineWrap(true);
        window.add(output);
        //Einde output textarea
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        //Variabelen aanmaken voor de input en output
        String ingevoerd = input.getText();
        ingevoerd = ingevoerd.toUpperCase();
        String uit = "";

        //For loop dat de ingevoerde sequentie letter voor letter af gaat en deze vertaald.
        for (int i = 0; i < ingevoerd.length(); i++) {
            char temp = ingevoerd.charAt(i);
            String toTranslate = String.valueOf(temp);

            try {
                uit = uit.concat("-" + Afvink5.Translator.one2three(toTranslate));

                //To not have a connecting stripe to start
                if (i == 0) {
                    uit = uit.substring(1);
                }
            } catch (Exception e) {
                uit = e.getMessage();
                break;
            }
        }
        //Veranderd de text in de output textarea naar de vertaalde sequentie
        output.setText(uit);
    }
}