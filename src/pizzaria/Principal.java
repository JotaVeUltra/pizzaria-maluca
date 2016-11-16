package pizzaria;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

import java.util.Random;
import org.eclipse.swt.widgets.Label;

public class Principal extends Shell {

	static Jogadores jogadores;
	static Tabuleiro tabuleiro = new Tabuleiro();
	static Monte monte = new Monte();
	static int pino = 0;
	int numeroJogadores = 0;
	public static Text txtJogador1;
	public static Text txtJogador2;
	public static Text txtJogador3;
	public static Text txtJogador4;
	public static Text txtJogador5;
	private Text txtIng1;
	private Text txtIng2;
	private Text txtIng3;
	private Text txtIng4;
	private Text txtIng5;
	private Button btnJogaDados;
	private Label lblNewLabel;

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

	public Principal(Display display) {
		super(display, SWT.SHELL_TRIM);

		Button btnNovoJogo = new Button(this, SWT.NONE);
		btnNovoJogo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int nj = 0;
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

			}
		});
		btnNovoJogo.setBounds(411, 8, 95, 25);
		btnNovoJogo.setText("Novo Jogo");

		txtJogador1 = new Text(this, SWT.BORDER);
		txtJogador1.setEditable(false);
		txtJogador1.setText("Jogador 1");
		txtJogador1.setBounds(10, 10, 63, 21);

		txtJogador2 = new Text(this, SWT.BORDER);
		txtJogador2.setEditable(false);
		txtJogador2.setText("Jogador 2");
		txtJogador2.setBounds(10, 37, 63, 21);

		txtJogador3 = new Text(this, SWT.BORDER);
		txtJogador3.setEditable(false);
		txtJogador3.setText("Jogador 3");
		txtJogador3.setBounds(10, 64, 63, 21);

		txtJogador4 = new Text(this, SWT.BORDER);
		txtJogador4.setEditable(false);
		txtJogador4.setText("Jogador 4");
		txtJogador4.setBounds(10, 91, 63, 21);

		txtJogador5 = new Text(this, SWT.BORDER);
		txtJogador5.setEditable(false);
		txtJogador5.setText("Jogador 5");
		txtJogador5.setBounds(10, 118, 63, 21);

		txtIng1 = new Text(this, SWT.BORDER);
		txtIng1.setEditable(false);
		txtIng1.setBounds(79, 10, 326, 21);

		txtIng2 = new Text(this, SWT.BORDER);
		txtIng2.setEditable(false);
		txtIng2.setBounds(79, 37, 326, 21);

		txtIng4 = new Text(this, SWT.BORDER);
		txtIng4.setEditable(false);
		txtIng4.setBounds(79, 91, 326, 21);

		txtIng5 = new Text(this, SWT.BORDER);
		txtIng5.setEditable(false);
		txtIng5.setBounds(79, 118, 326, 21);

		txtIng3 = new Text(this, SWT.BORDER);
		txtIng3.setEditable(false);
		txtIng3.setBounds(79, 64, 326, 21);

		Button btnStart = new Button(this, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtJogador1.setEditable(false);
				txtJogador2.setEditable(false);
				txtJogador3.setEditable(false);
				txtJogador4.setEditable(false);
				txtJogador5.setEditable(false);

				jogadores = new Jogadores(numeroJogadores);
				jogadores.atual = jogadores.primeiro;
				preencheTexto();
			}
		});
		btnStart.setBounds(202, 185, 75, 25);
		btnStart.setText("START");

		btnJogaDados = new Button(this, SWT.NONE);
		btnJogaDados.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Random gerador = new Random();
				pino = (pino + gerador.nextInt(6)) % 35;
				tabuleiro.moveParaPosicao(pino);
				if (tabuleiro.atual.tipo == tabuleiro.PERDE_TUDO) {
					jogadores.atual.pizza = new Pizza(jogadores.atual.pizza.tipo);
				} else {
					if (tabuleiro.atual.tipo == tabuleiro.SORTE_AZAR) {
						monte.sorteAzar(jogadores.atual);
					} else {
						jogadores.atual.pizza.removeIngrediente(tabuleiro.atual.tipo);
					}
				}
				if (jogadores.atual.pizza.tamanho() == 0) {
					String str = jogadores.atual.nome + " venceu!";
					JOptionPane.showMessageDialog(null, str);
				}
				jogadores.atual = jogadores.atual.proximo;
				preencheTexto();
			}
		});
		btnJogaDados.setBounds(411, 39, 95, 25);
		btnJogaDados.setText("Joga Dados");
		
		lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(10, 145, 476, 32);
		lblNewLabel.setText("ASSIM?");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Pizzaria Maluca");
		setSize(532, 300);

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
