package pizzaria;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import javax.swing.*;
import java.util.Random;

public class Principal extends Shell {

    public static Text txtJogador1;
    public static Text txtJogador2;
    public static Text txtJogador3;
    public static Text txtJogador4;
    public static Text txtJogador5;
    static Jogadores jogadores;
    static Tabuleiro tabuleiro = new Tabuleiro();
    static Monte monte = new Monte();
    static int pino = 0;
    static int numeroJogadores = 0;
    private Text txtIng1;
    private Text txtIng2;
    private Text txtIng3;
    private Text txtIng4;
    private Text txtIng5;
    private Button btnJogaDados;
    Button btnStart;
    static Label lblInfo;

    public Principal(Display display) {
        super(display, SWT.SHELL_TRIM);

        Button btnNovoJogo = new Button(this, SWT.NONE);
        btnNovoJogo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                int nj = 0;
                try {
                    while (nj < 2 || nj > 5) {
                        nj = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de jogadores 2-5"));
                    }
                    if (nj == 2) {
                        txtJogador1.setEditable(true);
                        txtJogador1.setText("");
                        txtJogador2.setEditable(true);
                        txtJogador2.setText("");
                        numeroJogadores = 2;
                    }
                    if (nj == 3) {
                        txtJogador1.setEditable(true);
                        txtJogador1.setText("");
                        txtJogador2.setEditable(true);
                        txtJogador2.setText("");
                        txtJogador3.setEditable(true);
                        txtJogador3.setText("");
                        numeroJogadores = 3;
                    }
                    if (nj == 4) {
                        txtJogador1.setEditable(true);
                        txtJogador1.setText("");
                        txtJogador2.setEditable(true);
                        txtJogador2.setText("");
                        txtJogador3.setEditable(true);
                        txtJogador3.setText("");
                        txtJogador4.setEditable(true);
                        txtJogador4.setText("");
                        numeroJogadores = 4;
                    }
                    if (nj == 5) {
                        txtJogador1.setEditable(true);
                        txtJogador1.setText("");
                        txtJogador2.setEditable(true);
                        txtJogador2.setText("");
                        txtJogador3.setEditable(true);
                        txtJogador3.setText("");
                        txtJogador4.setEditable(true);
                        txtJogador4.setText("");
                        txtJogador5.setEditable(true);
                        txtJogador5.setText("");
                        numeroJogadores = 5;
                    }
                    lblInfo.setText("Insira o nome dos jogaderes nos campos vazios");
                    btnStart.setVisible(true);
                } catch (Exception x) {
                    x.printStackTrace();
                }
            }
        });
        btnNovoJogo.setBounds(526, 8, 95, 25);
        btnNovoJogo.setText("Novo Jogo");

        txtJogador1 = new Text(this, SWT.BORDER);
        txtJogador1.setEditable(false);
        txtJogador1.setText("Jogador 1");
        txtJogador1.setBounds(10, 10, 75, 21);

        txtJogador2 = new Text(this, SWT.BORDER);
        txtJogador2.setEditable(false);
        txtJogador2.setText("Jogador 2");
        txtJogador2.setBounds(10, 37, 75, 21);

        txtJogador3 = new Text(this, SWT.BORDER);
        txtJogador3.setEditable(false);
        txtJogador3.setText("Jogador 3");
        txtJogador3.setBounds(10, 64, 75, 21);

        txtJogador4 = new Text(this, SWT.BORDER);
        txtJogador4.setEditable(false);
        txtJogador4.setText("Jogador 4");
        txtJogador4.setBounds(10, 91, 75, 21);

        txtJogador5 = new Text(this, SWT.BORDER);
        txtJogador5.setEditable(false);
        txtJogador5.setText("Jogador 5");
        txtJogador5.setBounds(10, 118, 75, 21);

        txtIng1 = new Text(this, SWT.BORDER);
        txtIng1.setEditable(false);
        txtIng1.setBounds(91, 10, 420, 21);

        txtIng2 = new Text(this, SWT.BORDER);
        txtIng2.setEditable(false);
        txtIng2.setBounds(91, 37, 420, 21);

        txtIng4 = new Text(this, SWT.BORDER);
        txtIng4.setEditable(false);
        txtIng4.setBounds(91, 91, 420, 21);

        txtIng5 = new Text(this, SWT.BORDER);
        txtIng5.setEditable(false);
        txtIng5.setBounds(91, 118, 420, 21);

        txtIng3 = new Text(this, SWT.BORDER);
        txtIng3.setEditable(false);
        txtIng3.setBounds(91, 64, 420, 21);

        btnStart = new Button(this, SWT.NONE);
        btnStart.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!(txtJogador1.getText().equals("") ||
                        txtJogador2.getText().equals("") ||
                        txtJogador3.getText().equals("") ||
                        txtJogador4.getText().equals("") ||
                        txtJogador5.getText().equals(""))) {
                    txtJogador1.setEditable(false);
                    txtJogador2.setEditable(false);
                    txtJogador3.setEditable(false);
                    txtJogador4.setEditable(false);
                    txtJogador5.setEditable(false);
                    jogadores = new Jogadores(numeroJogadores);
                    jogadores.atual = jogadores.primeiro;
                    preencheTexto();
                    btnStart.setVisible(false);
                    btnJogaDados.setVisible(true);
                }
            }
        });
        btnStart.setBounds(202, 185, 75, 25);
        btnStart.setText("START");
        btnStart.setVisible(false);

        btnJogaDados = new Button(this, SWT.NONE);
        btnJogaDados.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Random gerador = new Random();
                pino = (pino + gerador.nextInt(6) + 1) % 35;
                tabuleiro.moveParaPosicao(pino);
                lblInfo.setText(jogadores.atual.nome);
                if (tabuleiro.atual.tipo == tabuleiro.PERDE_TUDO) {
                    jogadores.atual.pizza = new Pizza(jogadores.atual.pizza.tipo);
                    lblInfo.setText(lblInfo.getText()+" perdeu tudo!");
                } else {
                    if (tabuleiro.atual.tipo == tabuleiro.SORTE_AZAR) {
                        monte.sorteAzar(jogadores.atual);
                    } else {
                        jogadores.atual.pizza.removeIngrediente(tabuleiro.atual.tipo);
                    }
                }
                if (jogadores.atual.pizza.tamanho() == 0) {
                    Principal.lblInfo.setText(Principal.lblInfo.getText()+" e venceu!");
                    btnJogaDados.setVisible(false);
                }
                if (monte.estaVazio()) {
                    monte = new Monte();
                }
                jogadores.atual = jogadores.atual.proximo;
                preencheTexto();
            }
        });
        btnJogaDados.setBounds(526, 39, 95, 25);
        btnJogaDados.setText("Joga Dados");
        btnJogaDados.setVisible(false);

        lblInfo = new Label(this, SWT.NONE);
        lblInfo.setAlignment(SWT.CENTER);
        lblInfo.setBounds(10, 145, 476, 32);
        lblInfo.setText("Pizzaria Maluca");
        createContents();
    }

    public static void main(String args[]) {
        try {
            Display display = Display.getDefault();
            Principal shell = new Principal(display);
            shell.open();
            shell.layout();
            while (!shell.isDisposed()) {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void createContents() {
        setText("Pizzaria Maluca");
        setSize(647, 300);

    }

    public void preencheTexto() {
        Jogador tempJ = jogadores.primeiro;
        txtIng1.setText(tempJ.pizza.toString());
        tempJ = tempJ.proximo;
        txtIng2.setText(tempJ.pizza.toString());
        if (numeroJogadores > 2) {
            tempJ = tempJ.proximo;
            txtIng3.setText(tempJ.pizza.toString());
        }
        if (numeroJogadores > 3) {
            tempJ = tempJ.proximo;
            txtIng4.setText(tempJ.pizza.toString());
        }
        if (numeroJogadores > 4) {
            tempJ = tempJ.proximo;
            txtIng5.setText(tempJ.pizza.toString());
        }
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }
}
