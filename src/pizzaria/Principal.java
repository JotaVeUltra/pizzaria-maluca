package pizzaria;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

public class Principal extends Shell {

	static Jogadores jogadores;
	static Jogador jogador;
	static Tabuleiro tabuleiro = new Tabuleiro();
	static Monte monte = new Monte();
	static int pino = 0;
	int a = 0;
	public static Text txtJogador;
	public static Text txtJogador_1;
	public static Text txtJogador_2;
	public static Text txtJogador_3;
	public static Text txtJogador_4;
	private Text txtIng;
	private Text txtIng_1;
	private Text txtIng_3;
	private Text txtIng_4;
	private Text txtIng_2;

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

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
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
					txtJogador.setEditable(true);
					txtJogador.setText("");
					txtJogador_1.setEditable(true);
					txtJogador_1.setText("");
					a = 2;
				}

				if (nj == 3) {
					txtJogador.setEditable(true);
					txtJogador.setText("");
					txtJogador_1.setEditable(true);
					txtJogador_1.setText("");
					txtJogador_2.setEditable(true);
					txtJogador_2.setText("");
					a = 3;
				}

				if (nj == 4) {
					txtJogador.setEditable(true);
					txtJogador.setText("");
					txtJogador_1.setEditable(true);
					txtJogador_1.setText("");
					txtJogador_2.setEditable(true);
					txtJogador_2.setText("");
					txtJogador_3.setEditable(true);
					txtJogador_3.setText("");
					a = 4;
				}

				if (nj == 5) {
					txtJogador.setEditable(true);
					txtJogador.setText("");
					txtJogador_1.setEditable(true);
					txtJogador_1.setText("");
					txtJogador_2.setEditable(true);
					txtJogador_2.setText("");
					txtJogador_3.setEditable(true);
					txtJogador_3.setText("");
					txtJogador_4.setEditable(true);
					txtJogador_4.setText("");
					a = 5;
				}

			}
		});
		btnNovoJogo.setBounds(349, 10, 75, 25);
		btnNovoJogo.setText("Novo Jogo");

		txtJogador = new Text(this, SWT.BORDER);
		txtJogador.setEditable(false);
		txtJogador.setText("Jogador 1");
		txtJogador.setBounds(10, 10, 63, 21);

		txtJogador_1 = new Text(this, SWT.BORDER);
		txtJogador_1.setEditable(false);
		txtJogador_1.setText("Jogador 2");
		txtJogador_1.setBounds(10, 37, 63, 21);

		txtJogador_2 = new Text(this, SWT.BORDER);
		txtJogador_2.setEditable(false);
		txtJogador_2.setText("Jogador 3");
		txtJogador_2.setBounds(10, 64, 63, 21);

		txtJogador_3 = new Text(this, SWT.BORDER);
		txtJogador_3.setEditable(false);
		txtJogador_3.setText("Jogador 4");
		txtJogador_3.setBounds(10, 91, 63, 21);

		txtJogador_4 = new Text(this, SWT.BORDER);
		txtJogador_4.setEditable(false);
		txtJogador_4.setText("Jogador 5");
		txtJogador_4.setBounds(10, 118, 63, 21);

		txtIng = new Text(this, SWT.BORDER);
		txtIng.setEditable(false);
		txtIng.setBounds(79, 10, 264, 21);

		txtIng_1 = new Text(this, SWT.BORDER);
		txtIng_1.setEditable(false);
		txtIng_1.setBounds(79, 37, 264, 21);

		txtIng_3 = new Text(this, SWT.BORDER);
		txtIng_3.setEditable(false);
		txtIng_3.setBounds(79, 91, 264, 21);

		txtIng_4 = new Text(this, SWT.BORDER);
		txtIng_4.setEditable(false);
		txtIng_4.setBounds(79, 118, 264, 21);

		txtIng_2 = new Text(this, SWT.BORDER);
		txtIng_2.setEditable(false);
		txtIng_2.setBounds(79, 64, 264, 21);

		Button btnStart = new Button(this, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtJogador.setEditable(false);
				txtJogador_1.setEditable(false);
				txtJogador_2.setEditable(false);
				txtJogador_3.setEditable(false);
				txtJogador_4.setEditable(false);
				
				//Jogador jogador = new Jogador(txtJogador.getText());
				jogadores = new Jogadores(a);
				//Jogadores(txtJogador.getText());
				
				// jogador = new Jogador(txtJogador.getText());

			}
		});
		btnStart.setBounds(158, 189, 75, 25);
		btnStart.setText("START");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Pizzaria Maluca");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void nomeiaJogador() {

	}
}
