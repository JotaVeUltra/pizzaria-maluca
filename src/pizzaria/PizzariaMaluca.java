package pizzaria;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzariaMaluca extends JFrame implements ActionListener{

    static Jogadores jogadores;
    static Tabuleiro tabuleiro = new Tabuleiro();
    static Monte monte = new Monte();
    static int pino = 0;

    PizzariaMaluca(){
        super("Pizzaria Maluca");

        JPanel panel = new JPanel();

        setContentPane(panel);
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(375, 220);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public static void main(String[] args) {
        int nj = 0;
        while ( (nj>5 || nj<2) ) {
            nj = Integer.parseInt(JOptionPane.showInputDialog("Número de jogadores (2-5)"));
        }
        jogadores = new Jogadores(nj);

        new PizzariaMaluca();
    }
}
