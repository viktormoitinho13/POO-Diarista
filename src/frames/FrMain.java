package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

import classes.Cliente;
import classes.Diarista;
import classes.Servico;
import database.TabelaCliente;
import database.TabelaDiarista;
import database.TabelaServico;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrMain {

	private JFrame frame;
	private JTextField textCadCliNome;
	private JTextField textCadCliCpf;
	private JTextField textCadCliTelefone;
	private JTextField textCadCliCep;
	private JTextField textCadCliCidade;
	private JTextField textCadCliBairro;
	private JTextField textCadCliEndereco;
	private JTextField textCadCliComplemento;
	private final JButton btnCadCliCadastrar = new JButton("Cadastrar");
	private JTextField textCadDiaNome;
	private JTextField textCadDiaNascimento;
	private JTextField textCadDiaCpf;
	private JTextField textCadDiaTelefone;
	private JTextField textCadDiaEndereco;
	private JTextField textAtuCliNome;
	private JTextField textAtuCliCpf;
	private JTextField textAtuCliTelefone;
	private JTextField textAtuCliCep;
	private JTextField textAtuCliCidade;
	private JTextField textAtuCliBairro;
	private JTextField textAtuCliEndereco;
	private JTextField textAtuCliComplemento;
	private JTextField textAtuCliCodigo;
	private JTextField textCadCliComodos;
	private JTextField textAtuCliComodos;
	private JTextField textRmvCliCodigo;
	private JTextField textAtuDiaNome;
	private JTextField textAtuDiaNascimento;
	private JTextField textAtuDiaCpf;
	private JTextField textAtuDiaTelefone;
	private JTextField textAtuDiaEndereco;
	private JTextField textAtuDiaCodigo;
	private JTextField textRmvDiaCodigo;
	private JTextField textServCodCli;
	private JTextField textServCodDia;
	private JTextField textServServCod;
	private JTextField textServDias;
	private JTextField textServComValor;
	private JTextField textServRoupasQtd;
	private JTextField textServPecasValor;
	private JTextField textServTranspValor;
	private JTextField textBoletoCodCli;
	private JTextField textBoletoCodDia;
	private JTextField textBoletoLimpDias;
	private JTextField textBoletoLimpValor;
	private JTextField textBoletoRoupasQtd;
	private JTextField textBoletoRoupasValor;
	private JTextField textBoletoTranspValor;
	private JTextField textBoletoCodServ;
	private JTextField textBoletoValorTotal;
	private JTextField textBoletoComodos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrMain window = new FrMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 506, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		frame.getContentPane().add(layeredPane, "name_1058763853039600");
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel inicio = new JPanel();
		layeredPane.add(inicio, "name_1062223512669900");
		
		JLabel lblNewLabel = new JLabel("inicio");
		inicio.add(lblNewLabel);
		
		JPanel cad_cli = new JPanel();
		layeredPane.add(cad_cli, "cad_cli");
		cad_cli.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrar Cliente");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 500, 40);
		cad_cli.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nome:");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(10, 51, 40, 20);
		cad_cli.add(lblNewLabel_3_1);
		
		textCadCliNome = new JTextField();
		textCadCliNome.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadCliNome.setColumns(10);
		textCadCliNome.setBounds(60, 51, 420, 20);
		cad_cli.add(textCadCliNome);
		
		JLabel lblNewLabel_3_2 = new JLabel("CPF:");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(10, 82, 32, 20);
		cad_cli.add(lblNewLabel_3_2);
		
		textCadCliCpf = new JTextField();
		textCadCliCpf.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadCliCpf.setColumns(10);
		textCadCliCpf.setBounds(52, 82, 110, 20);
		cad_cli.add(textCadCliCpf);
		
		textCadCliTelefone = new JTextField();
		textCadCliTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadCliTelefone.setColumns(10);
		textCadCliTelefone.setBounds(236, 82, 110, 20);
		cad_cli.add(textCadCliTelefone);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Telefone:");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(172, 82, 60, 20);
		cad_cli.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("CEP:");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(358, 82, 32, 20);
		cad_cli.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Bairro:");
		lblNewLabel_3_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_4.setBounds(261, 113, 49, 20);
		cad_cli.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Cidade:");
		lblNewLabel_3_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_5.setBounds(10, 113, 49, 20);
		cad_cli.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_7 = new JLabel("Endere\u00E7o:");
		lblNewLabel_3_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_7.setBounds(10, 144, 65, 20);
		cad_cli.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("Complemento:");
		lblNewLabel_3_8.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_8.setBounds(10, 175, 91, 20);
		cad_cli.add(lblNewLabel_3_8);
		
		textCadCliCep = new JTextField();
		textCadCliCep.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadCliCep.setColumns(10);
		textCadCliCep.setBounds(400, 82, 80, 20);
		cad_cli.add(textCadCliCep);
		
		textCadCliCidade = new JTextField();
		textCadCliCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadCliCidade.setColumns(10);
		textCadCliCidade.setBounds(62, 113, 189, 20);
		cad_cli.add(textCadCliCidade);
		
		textCadCliBairro = new JTextField();
		textCadCliBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadCliBairro.setColumns(10);
		textCadCliBairro.setBounds(320, 113, 160, 20);
		cad_cli.add(textCadCliBairro);
		
		textCadCliEndereco = new JTextField();
		textCadCliEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadCliEndereco.setColumns(10);
		textCadCliEndereco.setBounds(85, 145, 395, 20);
		cad_cli.add(textCadCliEndereco);
		
		textCadCliComplemento = new JTextField();
		textCadCliComplemento.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadCliComplemento.setColumns(10);
		textCadCliComplemento.setBounds(111, 175, 252, 20);
		cad_cli.add(textCadCliComplemento);
		btnCadCliCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TabelaCliente db = new TabelaCliente();
				Cliente c = new Cliente(
						textCadCliNome.getText(),
						textCadCliCpf.getText(),
						textCadCliTelefone.getText(),

						textCadCliEndereco.getText(),
						textCadCliCep.getText(),
						textCadCliBairro.getText(),
						textCadCliCidade.getText(),
						textCadCliComodos.getText(),
						textCadCliComplemento.getText()
				);
				
				try {
					db.inserir(c);
				} catch (Exception e) {
					e.printStackTrace();
				}

				textCadCliNome.setText("");
				textCadCliCpf.setText("");
				textCadCliTelefone.setText("");
				
				textCadCliEndereco.setText("");
				textCadCliCep.setText("");
				textCadCliBairro.setText("");
				textCadCliCidade.setText("");
				textCadCliComodos.setText("");
				textCadCliComplemento.setText("");
			}
		});
		btnCadCliCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadCliCadastrar.setBounds(200, 230, 100, 40);
		cad_cli.add(btnCadCliCadastrar);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("C\u00F4modos:");
		lblNewLabel_3_1_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_3.setBounds(373, 175, 65, 20);
		cad_cli.add(lblNewLabel_3_1_3);
		
		textCadCliComodos = new JTextField();
		textCadCliComodos.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadCliComodos.setColumns(10);
		textCadCliComodos.setBounds(448, 175, 32, 20);
		cad_cli.add(textCadCliComodos);
		
		JPanel cad_dia = new JPanel();
		layeredPane.add(cad_dia, "cad_dia");
		cad_dia.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cadastrar Diarista");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(0, 0, 500, 40);
		cad_dia.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 51, 40, 20);
		cad_dia.add(lblNewLabel_2);
		
		textCadDiaNome = new JTextField();
		textCadDiaNome.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadDiaNome.setBounds(60, 51, 243, 20);
		cad_dia.add(textCadDiaNome);
		textCadDiaNome.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nascimento:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(313, 51, 77, 20);
		cad_dia.add(lblNewLabel_2_1);
		
		textCadDiaNascimento = new JTextField();
		textCadDiaNascimento.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadDiaNascimento.setColumns(10);
		textCadDiaNascimento.setBounds(400, 51, 80, 20);
		cad_dia.add(textCadDiaNascimento);
		
		JLabel lblNewLabel_2_2 = new JLabel("CPF:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 82, 32, 20);
		cad_dia.add(lblNewLabel_2_2);
		
		textCadDiaCpf = new JTextField();
		textCadDiaCpf.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadDiaCpf.setColumns(10);
		textCadDiaCpf.setBounds(52, 82, 110, 20);
		cad_dia.add(textCadDiaCpf);
		
		JLabel lblNewLabel_2_3 = new JLabel("Telefone:");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(172, 82, 60, 20);
		cad_dia.add(lblNewLabel_2_3);
		
		textCadDiaTelefone = new JTextField();
		textCadDiaTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadDiaTelefone.setColumns(10);
		textCadDiaTelefone.setBounds(242, 82, 110, 20);
		cad_dia.add(textCadDiaTelefone);
		
		JLabel lblNewLabel_2_4 = new JLabel("Endereco:");
		lblNewLabel_2_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(10, 113, 65, 20);
		cad_dia.add(lblNewLabel_2_4);
		
		textCadDiaEndereco = new JTextField();
		textCadDiaEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
		textCadDiaEndereco.setColumns(10);
		textCadDiaEndereco.setBounds(85, 113, 395, 20);
		cad_dia.add(textCadDiaEndereco);
		
		JButton btnCadDiaCadastrar = new JButton("Cadastrar");
		btnCadDiaCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data = textCadDiaNascimento.getText();
				String dia = data.substring(0,2);
				String mes = data.substring(3,5);
				String ano = data.substring(6,10);
				data = ano + "-" + mes + "-" + dia;
				
				TabelaDiarista db = new TabelaDiarista();
				Diarista d = new Diarista(
						textCadDiaNome.getText(),
						data,
						textCadDiaCpf.getText(),
						textCadDiaTelefone.getText(),
						textCadDiaEndereco.getText()
				);
				
				try {
					db.inserir(d);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				textCadDiaNome.setText("");
				textCadDiaNascimento.setText("");
				textCadDiaCpf.setText("");
				textCadDiaTelefone.setText("");
				textCadDiaEndereco.setText("");
			}
		});
		btnCadDiaCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadDiaCadastrar.setBounds(200, 230, 100, 40);
		cad_dia.add(btnCadDiaCadastrar);
		
		JPanel atu_cli = new JPanel();
		layeredPane.add(atu_cli, "atu_cli");
		atu_cli.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Atualizar Cliente");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(0, 0, 500, 40);
		atu_cli.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Nome:");
		lblNewLabel_3_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(128, 51, 40, 20);
		atu_cli.add(lblNewLabel_3_1_2);
		
		textAtuCliNome = new JTextField();
		textAtuCliNome.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuCliNome.setColumns(10);
		textAtuCliNome.setBounds(178, 51, 302, 20);
		atu_cli.add(textAtuCliNome);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("CPF:");
		lblNewLabel_3_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_2_1.setBounds(10, 82, 32, 20);
		atu_cli.add(lblNewLabel_3_2_1);
		
		textAtuCliCpf = new JTextField();
		textAtuCliCpf.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuCliCpf.setColumns(10);
		textAtuCliCpf.setBounds(52, 82, 110, 20);
		atu_cli.add(textAtuCliCpf);
		
		textAtuCliTelefone = new JTextField();
		textAtuCliTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuCliTelefone.setColumns(10);
		textAtuCliTelefone.setBounds(236, 82, 110, 20);
		atu_cli.add(textAtuCliTelefone);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Telefone:");
		lblNewLabel_3_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1.setBounds(172, 82, 60, 20);
		atu_cli.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("CEP:");
		lblNewLabel_3_3_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_3_1.setBounds(358, 82, 32, 20);
		atu_cli.add(lblNewLabel_3_3_1);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Bairro:");
		lblNewLabel_3_4_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_4_1.setBounds(261, 113, 49, 20);
		atu_cli.add(lblNewLabel_3_4_1);
		
		JLabel lblNewLabel_3_5_1 = new JLabel("Cidade:");
		lblNewLabel_3_5_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_5_1.setBounds(10, 113, 49, 20);
		atu_cli.add(lblNewLabel_3_5_1);
		
		JLabel lblNewLabel_3_7_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_3_7_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_7_1.setBounds(10, 144, 65, 20);
		atu_cli.add(lblNewLabel_3_7_1);
		
		JLabel lblNewLabel_3_8_1 = new JLabel("Complemento:");
		lblNewLabel_3_8_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_8_1.setBounds(10, 175, 91, 20);
		atu_cli.add(lblNewLabel_3_8_1);
		
		textAtuCliCep = new JTextField();
		textAtuCliCep.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuCliCep.setColumns(10);
		textAtuCliCep.setBounds(400, 82, 80, 20);
		atu_cli.add(textAtuCliCep);
		
		textAtuCliCidade = new JTextField();
		textAtuCliCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuCliCidade.setColumns(10);
		textAtuCliCidade.setBounds(62, 113, 189, 20);
		atu_cli.add(textAtuCliCidade);
		
		textAtuCliBairro = new JTextField();
		textAtuCliBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuCliBairro.setColumns(10);
		textAtuCliBairro.setBounds(320, 113, 160, 20);
		atu_cli.add(textAtuCliBairro);
		
		textAtuCliEndereco = new JTextField();
		textAtuCliEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuCliEndereco.setColumns(10);
		textAtuCliEndereco.setBounds(85, 145, 395, 20);
		atu_cli.add(textAtuCliEndereco);
		
		textAtuCliComplemento = new JTextField();
		textAtuCliComplemento.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuCliComplemento.setColumns(10);
		textAtuCliComplemento.setBounds(111, 175, 252, 20);
		atu_cli.add(textAtuCliComplemento);
		
		JButton btnAtuCliAtualizar = new JButton("Atualizar");
		btnAtuCliAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cod = Integer.parseInt(textAtuCliCodigo.getText());
				
				TabelaCliente db = new TabelaCliente();
				Cliente c = new Cliente(
						textAtuCliNome.getText(),
						textAtuCliCpf.getText(),
						textAtuCliTelefone.getText(),

						textAtuCliEndereco.getText(),
						textAtuCliCep.getText(),
						textAtuCliBairro.getText(),
						textAtuCliCidade.getText(),
						textAtuCliComodos.getText(),
						textAtuCliComplemento.getText()
				);
				
				try {
					db.atualizar(cod, c);
				} catch (Exception e) {
					e.printStackTrace();
				}

				textAtuCliCodigo.setText("");
				textAtuCliNome.setText("");
				textAtuCliCpf.setText("");
				textAtuCliTelefone.setText("");

				textAtuCliEndereco.setText("");
				textAtuCliCep.setText("");
				textAtuCliBairro.setText("");
				textAtuCliCidade.setText("");
				textAtuCliComodos.setText("");
				textAtuCliComplemento.setText("");
			}
		});
		btnAtuCliAtualizar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtuCliAtualizar.setBounds(200, 230, 100, 40);
		atu_cli.add(btnAtuCliAtualizar);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_3_1_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1.setBounds(10, 51, 49, 20);
		atu_cli.add(lblNewLabel_3_1_2_1);
		
		textAtuCliCodigo = new JTextField();
		textAtuCliCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuCliCodigo.setColumns(10);
		textAtuCliCodigo.setBounds(69, 51, 49, 20);
		atu_cli.add(textAtuCliCodigo);
		
		JLabel lblNewLabel_3_1_3_1 = new JLabel("C\u00F4modos:");
		lblNewLabel_3_1_3_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_3_1.setBounds(373, 175, 65, 20);
		atu_cli.add(lblNewLabel_3_1_3_1);
		
		textAtuCliComodos = new JTextField();
		textAtuCliComodos.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuCliComodos.setColumns(10);
		textAtuCliComodos.setBounds(448, 175, 32, 20);
		atu_cli.add(textAtuCliComodos);
		
		JPanel atu_dia = new JPanel();
		layeredPane.add(atu_dia, "atu_dia");
		atu_dia.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Atualizar Diarista");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(0, 0, 500, 40);
		atu_dia.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_5 = new JLabel("Nome:");
		lblNewLabel_2_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(119, 51, 40, 20);
		atu_dia.add(lblNewLabel_2_5);
		
		textAtuDiaNome = new JTextField();
		textAtuDiaNome.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuDiaNome.setColumns(10);
		textAtuDiaNome.setBounds(169, 51, 134, 20);
		atu_dia.add(textAtuDiaNome);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Nascimento:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(313, 51, 77, 20);
		atu_dia.add(lblNewLabel_2_1_1);
		
		textAtuDiaNascimento = new JTextField();
		textAtuDiaNascimento.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuDiaNascimento.setColumns(10);
		textAtuDiaNascimento.setBounds(400, 51, 80, 20);
		atu_dia.add(textAtuDiaNascimento);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("CPF:");
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(10, 82, 32, 20);
		atu_dia.add(lblNewLabel_2_2_1);
		
		textAtuDiaCpf = new JTextField();
		textAtuDiaCpf.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuDiaCpf.setColumns(10);
		textAtuDiaCpf.setBounds(52, 82, 110, 20);
		atu_dia.add(textAtuDiaCpf);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Telefone:");
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setBounds(172, 82, 60, 20);
		atu_dia.add(lblNewLabel_2_3_1);
		
		textAtuDiaTelefone = new JTextField();
		textAtuDiaTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuDiaTelefone.setColumns(10);
		textAtuDiaTelefone.setBounds(242, 82, 110, 20);
		atu_dia.add(textAtuDiaTelefone);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Endereco:");
		lblNewLabel_2_4_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_4_1.setBounds(10, 113, 65, 20);
		atu_dia.add(lblNewLabel_2_4_1);
		
		textAtuDiaEndereco = new JTextField();
		textAtuDiaEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuDiaEndereco.setColumns(10);
		textAtuDiaEndereco.setBounds(85, 113, 395, 20);
		atu_dia.add(textAtuDiaEndereco);
		
		JButton btnAtuDiaAtualizar = new JButton("Atualizar");
		btnAtuDiaAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data = textAtuDiaNascimento.getText();
				String dia = data.substring(0,2);
				String mes = data.substring(3,5);
				String ano = data.substring(6,10);
				data = ano + "-" + mes + "-" + dia;
				
				int cod = Integer.parseInt(textAtuDiaCodigo.getText());
				
				TabelaDiarista db = new TabelaDiarista();
				Diarista d = new Diarista(
						textAtuDiaNome.getText(),
						data,
						textAtuDiaCpf.getText(),
						textAtuDiaTelefone.getText(),
						textAtuDiaEndereco.getText()
				);
				
				try {
					db.atualizar(cod, d);
				} catch (Exception e) {
					e.printStackTrace();
				}

				textAtuDiaCodigo.setText("");
				textAtuDiaNome.setText("");
				textAtuDiaNascimento.setText("");
				textAtuDiaCpf.setText("");
				textAtuDiaTelefone.setText("");
				textAtuDiaEndereco.setText("");
			}
		});
		btnAtuDiaAtualizar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAtuDiaAtualizar.setBounds(200, 230, 100, 40);
		atu_dia.add(btnAtuDiaAtualizar);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_2_5_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_5_1.setBounds(10, 51, 49, 20);
		atu_dia.add(lblNewLabel_2_5_1);
		
		textAtuDiaCodigo = new JTextField();
		textAtuDiaCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
		textAtuDiaCodigo.setColumns(10);
		textAtuDiaCodigo.setBounds(69, 51, 40, 20);
		atu_dia.add(textAtuDiaCodigo);
		
		JPanel rmv_cli = new JPanel();
		layeredPane.add(rmv_cli, "rmv_cli");
		rmv_cli.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Remover Cliente");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(0, 0, 500, 40);
		rmv_cli.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_3_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1_1.setBounds(196, 51, 49, 20);
		rmv_cli.add(lblNewLabel_3_1_2_1_1);
		
		textRmvCliCodigo = new JTextField();
		textRmvCliCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
		textRmvCliCodigo.setColumns(10);
		textRmvCliCodigo.setBounds(255, 51, 40, 20);
		rmv_cli.add(textRmvCliCodigo);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cod = Integer.parseInt(textRmvCliCodigo.getText());
				
				TabelaCliente db = new TabelaCliente();
				
				try {
					db.remover(cod);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				textRmvCliCodigo.setText("");
			}
		});
		btnRemover.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRemover.setBounds(200, 230, 100, 40);
		rmv_cli.add(btnRemover);
		
		JPanel rmv_dia = new JPanel();
		layeredPane.add(rmv_dia, "rmv_dia");
		rmv_dia.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Remover Diarista");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(0, 0, 500, 40);
		rmv_dia.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_5_1_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_2_5_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_5_1_1.setBounds(196, 51, 49, 20);
		rmv_dia.add(lblNewLabel_2_5_1_1);
		
		textRmvDiaCodigo = new JTextField();
		textRmvDiaCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
		textRmvDiaCodigo.setColumns(10);
		textRmvDiaCodigo.setBounds(255, 51, 40, 20);
		rmv_dia.add(textRmvDiaCodigo);
		
		JButton btnRmvDiaRemover = new JButton("Remover");
		btnRmvDiaRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cod = Integer.parseInt(textRmvDiaCodigo.getText());
				
				TabelaDiarista db = new TabelaDiarista();
				
				try {
					db.remover(cod);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				textRmvDiaCodigo.setText("");
			}
		});
		btnRmvDiaRemover.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRmvDiaRemover.setBounds(200, 230, 100, 40);
		rmv_dia.add(btnRmvDiaRemover);
		
		JPanel lst_cli = new JPanel();
		layeredPane.add(lst_cli, "name_1152776064600800");
		lst_cli.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Listar Clientes");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(0, 0, 500, 40);
		lst_cli.add(lblNewLabel_1_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 470, 228);
		lst_cli.add(scrollPane);
		
		JTextArea textPaneLstCli = new JTextArea();
		textPaneLstCli.setEditable(false);
		textPaneLstCli.setTabSize(4);
		textPaneLstCli.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		scrollPane.setViewportView(textPaneLstCli);
		
		JPanel lst_dia = new JPanel();
		layeredPane.add(lst_dia, "name_1152779954905000");
		lst_dia.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Listar Diaristas");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(0, 0, 500, 40);
		lst_dia.add(lblNewLabel_1_1_1_1_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 51, 470, 228);
		lst_dia.add(scrollPane_1);
		
		JTextArea textPaneLstDia = new JTextArea();
		textPaneLstDia.setTabSize(4);
		textPaneLstDia.setEditable(false);
		textPaneLstDia.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		scrollPane_1.setViewportView(textPaneLstDia);
		
		JPanel novo_servico = new JPanel();
		layeredPane.add(novo_servico, "novo_servico");
		novo_servico.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Contratar Servi\u00E7o");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(0, 0, 500, 40);
		novo_servico.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_3_1_4 = new JLabel("Codigo do Cliente:");
		lblNewLabel_3_1_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4.setBounds(10, 51, 117, 20);
		novo_servico.add(lblNewLabel_3_1_4);
		
		textServCodCli = new JTextField();
		textServCodCli.setFont(new Font("Arial", Font.PLAIN, 14));
		textServCodCli.setColumns(10);
		textServCodCli.setBounds(141, 51, 40, 20);
		novo_servico.add(textServCodCli);
		
		JButton btnServContratar = new JButton("Contratar");
		btnServContratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TabelaServico db = new TabelaServico();
				ArrayList<Servico> registros = null;
				
				Servico s = new Servico(
						Integer.parseInt(textServCodCli.getText()),
						Integer.parseInt(textServCodDia.getText()),
						
						Integer.parseInt(textServDias.getText()),
						"0000-00-00",
						"0000-00-00",
						Double.parseDouble(textServTranspValor.getText()),
						Double.parseDouble(textServComValor.getText()),
						
						Integer.parseInt(textServRoupasQtd.getText()),
						"Nenhuma",
						Double.parseDouble(textServPecasValor.getText()),
						
						0,0,0
						
				);
				
				try {
					db.inserir(s);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					registros = db.buscar("cod_cli", textServCodCli.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				int serv_cod = registros.get(registros.size() - 1).getCod_serv();
				textServServCod.setText(Integer.toString(serv_cod));
			}
		});
		btnServContratar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnServContratar.setBounds(10, 240, 100, 40);
		novo_servico.add(btnServContratar);
		
		JLabel lblNewLabel_3_1_4_1 = new JLabel("Codigo da Diarista:");
		lblNewLabel_3_1_4_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_1.setBounds(191, 51, 121, 20);
		novo_servico.add(lblNewLabel_3_1_4_1);
		
		textServCodDia = new JTextField();
		textServCodDia.setFont(new Font("Arial", Font.PLAIN, 14));
		textServCodDia.setColumns(10);
		textServCodDia.setBounds(322, 51, 40, 20);
		novo_servico.add(textServCodDia);
		
		JLabel lblNewLabel_3_1_4_2 = new JLabel("Codigo do Servi\u00E7o:");
		lblNewLabel_3_1_4_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_2.setBounds(309, 260, 121, 20);
		novo_servico.add(lblNewLabel_3_1_4_2);
		
		textServServCod = new JTextField();
		textServServCod.setEditable(false);
		textServServCod.setFont(new Font("Arial", Font.PLAIN, 14));
		textServServCod.setColumns(10);
		textServServCod.setBounds(439, 260, 40, 20);
		novo_servico.add(textServServCod);
		
		JLabel lblNewLabel_3_1_4_3 = new JLabel("Dias de limpeza:");
		lblNewLabel_3_1_4_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_3.setBounds(11, 82, 110, 20);
		novo_servico.add(lblNewLabel_3_1_4_3);
		
		textServDias = new JTextField();
		textServDias.setFont(new Font("Arial", Font.PLAIN, 14));
		textServDias.setColumns(10);
		textServDias.setBounds(141, 82, 40, 20);
		novo_servico.add(textServDias);
		
		JLabel lblNewLabel_3_1_4_4 = new JLabel("Valor por c\u00F4modo:");
		lblNewLabel_3_1_4_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_4.setBounds(195, 82, 117, 20);
		novo_servico.add(lblNewLabel_3_1_4_4);
		
		textServComValor = new JTextField();
		textServComValor.setFont(new Font("Arial", Font.PLAIN, 14));
		textServComValor.setColumns(10);
		textServComValor.setBounds(322, 82, 40, 20);
		novo_servico.add(textServComValor);
		
		JLabel lblNewLabel_3_1_4_5 = new JLabel("Pe\u00E7as de roupa:");
		lblNewLabel_3_1_4_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_5.setBounds(10, 113, 110, 20);
		novo_servico.add(lblNewLabel_3_1_4_5);
		
		textServRoupasQtd = new JTextField();
		textServRoupasQtd.setFont(new Font("Arial", Font.PLAIN, 14));
		textServRoupasQtd.setColumns(10);
		textServRoupasQtd.setBounds(141, 113, 40, 20);
		novo_servico.add(textServRoupasQtd);
		
		JLabel lblNewLabel_3_1_4_6 = new JLabel("Valor por pe\u00E7a:");
		lblNewLabel_3_1_4_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_6.setBounds(205, 113, 100, 20);
		novo_servico.add(lblNewLabel_3_1_4_6);
		
		textServPecasValor = new JTextField();
		textServPecasValor.setFont(new Font("Arial", Font.PLAIN, 14));
		textServPecasValor.setColumns(10);
		textServPecasValor.setBounds(322, 113, 40, 20);
		novo_servico.add(textServPecasValor);
		
		JLabel lblNewLabel_3_1_4_7 = new JLabel("Valor do transporte:");
		lblNewLabel_3_1_4_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_7.setBounds(10, 144, 126, 20);
		novo_servico.add(lblNewLabel_3_1_4_7);
		
		textServTranspValor = new JTextField();
		textServTranspValor.setFont(new Font("Arial", Font.PLAIN, 14));
		textServTranspValor.setColumns(10);
		textServTranspValor.setBounds(141, 144, 40, 20);
		novo_servico.add(textServTranspValor);
		
		JPanel boleto = new JPanel();
		layeredPane.add(boleto, "boleto");
		boleto.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gerar Boleto");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(0, 0, 500, 40);
		boleto.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_3_1_4_8 = new JLabel("Codigo do Cliente:");
		lblNewLabel_3_1_4_8.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_8.setBounds(10, 82, 117, 20);
		boleto.add(lblNewLabel_3_1_4_8);
		
		textBoletoCodCli = new JTextField();
		textBoletoCodCli.setEditable(false);
		textBoletoCodCli.setFont(new Font("Arial", Font.PLAIN, 14));
		textBoletoCodCli.setColumns(10);
		textBoletoCodCli.setBounds(141, 82, 40, 20);
		boleto.add(textBoletoCodCli);
		
		JLabel lblNewLabel_3_1_4_1_1 = new JLabel("Codigo da Diarista:");
		lblNewLabel_3_1_4_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_1_1.setBounds(191, 82, 121, 20);
		boleto.add(lblNewLabel_3_1_4_1_1);
		
		textBoletoCodDia = new JTextField();
		textBoletoCodDia.setEditable(false);
		textBoletoCodDia.setFont(new Font("Arial", Font.PLAIN, 14));
		textBoletoCodDia.setColumns(10);
		textBoletoCodDia.setBounds(322, 82, 40, 20);
		boleto.add(textBoletoCodDia);
		
		JLabel lblNewLabel_3_1_4_3_1 = new JLabel("Dias de limpeza:");
		lblNewLabel_3_1_4_3_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_3_1.setBounds(11, 113, 110, 20);
		boleto.add(lblNewLabel_3_1_4_3_1);
		
		textBoletoLimpDias = new JTextField();
		textBoletoLimpDias.setEditable(false);
		textBoletoLimpDias.setFont(new Font("Arial", Font.PLAIN, 14));
		textBoletoLimpDias.setColumns(10);
		textBoletoLimpDias.setBounds(141, 113, 40, 20);
		boleto.add(textBoletoLimpDias);
		
		JLabel lblNewLabel_3_1_4_4_1 = new JLabel("Valor por c\u00F4modo:");
		lblNewLabel_3_1_4_4_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_4_1.setBounds(195, 113, 117, 20);
		boleto.add(lblNewLabel_3_1_4_4_1);
		
		textBoletoLimpValor = new JTextField();
		textBoletoLimpValor.setEditable(false);
		textBoletoLimpValor.setFont(new Font("Arial", Font.PLAIN, 14));
		textBoletoLimpValor.setColumns(10);
		textBoletoLimpValor.setBounds(322, 113, 40, 20);
		boleto.add(textBoletoLimpValor);
		
		JLabel lblNewLabel_3_1_4_5_1 = new JLabel("Pe\u00E7as de roupa:");
		lblNewLabel_3_1_4_5_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_5_1.setBounds(10, 144, 110, 20);
		boleto.add(lblNewLabel_3_1_4_5_1);
		
		textBoletoRoupasQtd = new JTextField();
		textBoletoRoupasQtd.setEditable(false);
		textBoletoRoupasQtd.setFont(new Font("Arial", Font.PLAIN, 14));
		textBoletoRoupasQtd.setColumns(10);
		textBoletoRoupasQtd.setBounds(141, 144, 40, 20);
		boleto.add(textBoletoRoupasQtd);
		
		JLabel lblNewLabel_3_1_4_6_1 = new JLabel("Valor por pe\u00E7a:");
		lblNewLabel_3_1_4_6_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_6_1.setBounds(205, 144, 100, 20);
		boleto.add(lblNewLabel_3_1_4_6_1);
		
		textBoletoRoupasValor = new JTextField();
		textBoletoRoupasValor.setEditable(false);
		textBoletoRoupasValor.setFont(new Font("Arial", Font.PLAIN, 14));
		textBoletoRoupasValor.setColumns(10);
		textBoletoRoupasValor.setBounds(322, 144, 40, 20);
		boleto.add(textBoletoRoupasValor);
		
		JLabel lblNewLabel_3_1_4_7_1 = new JLabel("Valor do transporte:");
		lblNewLabel_3_1_4_7_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_7_1.setBounds(10, 175, 126, 20);
		boleto.add(lblNewLabel_3_1_4_7_1);
		
		textBoletoTranspValor = new JTextField();
		textBoletoTranspValor.setEditable(false);
		textBoletoTranspValor.setFont(new Font("Arial", Font.PLAIN, 14));
		textBoletoTranspValor.setColumns(10);
		textBoletoTranspValor.setBounds(141, 175, 40, 20);
		boleto.add(textBoletoTranspValor);
		
		JLabel lblNewLabel_3_1_4_8_1 = new JLabel("Codigo do Servico:");
		lblNewLabel_3_1_4_8_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_8_1.setBounds(10, 51, 121, 20);
		boleto.add(lblNewLabel_3_1_4_8_1);
		
		textBoletoCodServ = new JTextField();
		textBoletoCodServ.setFont(new Font("Arial", Font.PLAIN, 14));
		textBoletoCodServ.setColumns(10);
		textBoletoCodServ.setBounds(141, 51, 40, 20);
		boleto.add(textBoletoCodServ);
		
		JButton btnGerarBoleto = new JButton("Gerar Boleto");
		btnGerarBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cod_serv = textBoletoCodServ.getText();
				
				TabelaCliente db_cli = new TabelaCliente();
				TabelaServico db_serv = new TabelaServico();
				
				ArrayList<Cliente> result_cli = null;
				ArrayList<Servico> result_serv = null;
				
				Cliente c = new Cliente();
				Servico s = new Servico();
				
				try {
					result_serv = db_serv.buscar("cod_serv", cod_serv);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (result_serv.size() != 0)
					s = result_serv.get(0);
				
				try {
					result_cli = db_cli.buscar("cod", Integer.toString(s.getCod_cli()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (result_cli.size() != 0)
					c = result_cli.get(0);
				
				
				textBoletoCodCli.setText(Integer.toString(s.getCod_cli()));
				textBoletoCodDia.setText(Integer.toString(s.getCod_dia()));
				textBoletoLimpDias.setText(Integer.toString(s.getTempo()));
				textBoletoLimpValor.setText(Double.toString(s.getTaxa()));
				textBoletoComodos.setText(c.getTam_total());
				textBoletoRoupasQtd.setText(Integer.toString(s.getRp_qtd()));
				textBoletoRoupasValor.setText(Double.toString(s.getRp_vlr()));
				textBoletoTranspValor.setText(Double.toString(s.getTransp()));
				
				
				double montante = 0;
				
				montante += s.getTaxa() * Integer.parseInt(c.getTam_total()) * s.getTempo();
				montante += s.getRp_qtd() * s.getRp_vlr();
				montante += s.getTransp();
				
				textBoletoValorTotal.setText(Double.toString(montante));
			}
		});
		btnGerarBoleto.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGerarBoleto.setBounds(10, 240, 117, 40);
		boleto.add(btnGerarBoleto);
		
		JLabel lblNewLabel_3_1_4_8_2 = new JLabel("Valor total:");
		lblNewLabel_3_1_4_8_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1_4_8_2.setBounds(335, 250, 75, 20);
		boleto.add(lblNewLabel_3_1_4_8_2);
		
		textBoletoValorTotal = new JTextField();
		textBoletoValorTotal.setFont(new Font("Arial", Font.PLAIN, 14));
		textBoletoValorTotal.setEditable(false);
		textBoletoValorTotal.setColumns(10);
		textBoletoValorTotal.setBounds(420, 250, 60, 20);
		boleto.add(textBoletoValorTotal);
		
		JLabel lblNewLabel_3_1_4_8_3 = new JLabel("Comodos:");
		lblNewLabel_3_1_4_8_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_1_4_8_3.setBounds(372, 113, 64, 20);
		boleto.add(lblNewLabel_3_1_4_8_3);
		
		textBoletoComodos = new JTextField();
		textBoletoComodos.setFont(new Font("Arial", Font.PLAIN, 14));
		textBoletoComodos.setEditable(false);
		textBoletoComodos.setColumns(10);
		textBoletoComodos.setBounds(440, 113, 40, 20);
		boleto.add(textBoletoComodos);
		
		

		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Servi\u00E7os");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Contratar Servi\u00E7o");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(novo_servico);
				layeredPane.repaint();
				layeredPane.revalidate();

				textServCodCli.setText("");
				textServCodDia.setText("");
				textServDias.setText("");
				textServComValor.setText("");
				textServRoupasQtd.setText("");
				textServPecasValor.setText("");
				textServTranspValor.setText("");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gerar Boleto");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(boleto);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				textBoletoCodServ.setText("");
				textBoletoCodCli.setText("");
				textBoletoCodDia.setText("");
				textBoletoLimpDias.setText("");
				textBoletoLimpValor.setText("");
				textBoletoRoupasQtd.setText("");
				textBoletoRoupasValor.setText("");
				textBoletoTranspValor.setText("");
				textBoletoValorTotal.setText("");
				textBoletoComodos.setText("");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Cadastrar");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cliente");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(cad_cli);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Diarista");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(cad_dia);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Atualizar");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Cliente");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(atu_cli);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Diarista");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(atu_dia);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("Remover");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Cliente");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(rmv_cli);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Diarista");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(rmv_dia);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("Listar");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Clientes");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(lst_cli);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				textPaneLstCli.setText("");
				
				TabelaCliente db = new TabelaCliente();
				ArrayList<Cliente> registros = null;
				
				try {
					registros = db.listar();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				for (int i = 0; i < registros.size(); i++) {
					if (i != 0 ) textPaneLstCli.append("\n\n");
					
					textPaneLstCli.append(registros.get(i).getCod() + " ");
					textPaneLstCli.append(registros.get(i).getNome() + "\n");
					textPaneLstCli.append("Cpf: " + registros.get(i).getCpf() + "  ");
					textPaneLstCli.append("Tel.: " + registros.get(i).getTel() + "\n");

					textPaneLstCli.append(registros.get(i).getEnd());
					if (registros.get(i).getCompl().length() > 0)
						textPaneLstCli.append(" - " + registros.get(i).getCompl());
					textPaneLstCli.append("\n" + registros.get(i).getBairro());
					textPaneLstCli.append(", " + registros.get(i).getCid());
					textPaneLstCli.append(", " + registros.get(i).getCep());
					textPaneLstCli.append("\n" + "Comodos: " + registros.get(i).getTam_total());
				}
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Diaristas");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(lst_dia);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				textPaneLstDia.setText("");
				
				TabelaDiarista db = new TabelaDiarista();
				ArrayList<Diarista> registros = null;
				
				try {
					registros = db.listar();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				String data, dia, mes, ano;
				
				for (int i = 0; i < registros.size(); i++) {
					if (i != 0 ) textPaneLstDia.append("\n\n");
					
					data = registros.get(i).getNasc();
					ano = data.substring(0,4);
					mes = data.substring(5,7);
					dia = data.substring(8,10);
					data = dia + "/" + mes + "/" + ano;
					
					textPaneLstDia.append(registros.get(i).getCod() + " ");
					textPaneLstDia.append(registros.get(i).getNome() + "\n");
					textPaneLstDia.append("Nascimento: " + data + "\n");
					textPaneLstDia.append("Cpf: " + registros.get(i).getCpf() + "  ");
					textPaneLstDia.append("Tel.: " + registros.get(i).getTel() + "\n");
					textPaneLstDia.append(registros.get(i).getEnd());
				}
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);
	}
}
