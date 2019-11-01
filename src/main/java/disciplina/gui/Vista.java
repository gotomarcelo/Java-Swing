package disciplina.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import disciplina.cr.Controle;
import model.componente;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class Vista extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel PainelPesquisar;
	private JPanel PainelCriar;
	private JPanel Panel;
	private JLayeredPane layeredPane;
	private JTextField TextoCodComp;
	private JTextField TextoComponente;
	private JTextField TextoCH;
	private JTextField TextoCR;
	private JTextField TextoPesqNome;
	private JTextField TextoNatureza;
	
	Controle Control = new Controle();
	Controle Pesquisa = new Controle();
	private JTable tableDisciplinas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * @param <PainelPesquisar>
	 */
	public <PainelPesquisar> Vista() {
		setTitle("Disciplinas BICT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 395);
		Panel = new JPanel();
		Panel.setBackground(new Color(255, 228, 225));
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 106, 539, 243);
		Panel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		PainelPesquisar = new JPanel();
		PainelPesquisar.setBackground(Color.PINK);
		layeredPane.add(PainelPesquisar, "name_176525844300300");
		PainelPesquisar.setLayout(null);
		
		JLabel PesqNome = new JLabel("Pesquisar:");
		PesqNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		PesqNome.setBounds(10, 11, 65, 20);
		PainelPesquisar.add(PesqNome);
		
		TextoPesqNome = new JTextField();
		TextoPesqNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		TextoPesqNome.setColumns(10);
		TextoPesqNome.setBounds(85, 12, 261, 20);
		PainelPesquisar.add(TextoPesqNome);
		
		JButton PesquisaBtn = new JButton("Buscar");
		PesquisaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pesquise = TextoPesqNome.getText();
				DefaultTableModel modelo = (DefaultTableModel) tableDisciplinas.getModel();
				Controle pdao = new Controle();
				modelo.setNumRows(0);
				
				for (componente p: pdao.PesquisaDados(pesquise)) {
					modelo.addRow(new Object[] {
							p.getCodcomponente(),
							p.getNomecomponente(),
							p.getCargahoraria(),
							p.getCrcomponente(),
							p.getNatureza()
							
					});
				}
			}	
		});
		PesquisaBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		PesquisaBtn.setBounds(356, 13, 65, 20);
		PainelPesquisar.add(PesquisaBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 519, 190);
		PainelPesquisar.add(scrollPane);
		
		tableDisciplinas = new JTable();
		tableDisciplinas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "Nome", "Carga Horária", "CR", "Natureza"
			}
		));
		scrollPane.setViewportView(tableDisciplinas);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modelo = (DefaultTableModel) tableDisciplinas.getModel();
				Controle pdao = new Controle();
				modelo.setNumRows(0);
				
				for (componente p: pdao.AtualizaDados()) {
					modelo.addRow(new Object[] {
							p.getCodcomponente(),
							p.getNomecomponente(),
							p.getCargahoraria(),
							p.getCrcomponente(),
							p.getNatureza()
							
					});
				}
			}
		});
		btnAtualizar.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		btnAtualizar.setBounds(431, 12, 80, 20);
		PainelPesquisar.add(btnAtualizar);

		
		
		PainelCriar = new JPanel();
		PainelCriar.setBackground(Color.PINK);
		layeredPane.add(PainelCriar, "name_176535181797800");
		PainelCriar.setLayout(null);
		
		JLabel TituloCriar = new JLabel("Cadastro de Disciplinas do BICT");
		TituloCriar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		TituloCriar.setBounds(10, 11, 310, 40);
		PainelCriar.add(TituloCriar);
		
		JLabel CodComponente = new JLabel("Código do Componente:");
		CodComponente.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		CodComponente.setBounds(10, 60, 150, 20);
		PainelCriar.add(CodComponente);
		
		TextoCodComp = new JTextField();
		TextoCodComp.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		TextoCodComp.setColumns(10);
		TextoCodComp.setBounds(160, 62, 85, 20);
		PainelCriar.add(TextoCodComp);
		
		JLabel NomeComponente = new JLabel("Nome do Componente:");
		NomeComponente.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		NomeComponente.setBounds(10, 90, 150, 20);
		PainelCriar.add(NomeComponente);
		
		TextoComponente = new JTextField();
		TextoComponente.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		TextoComponente.setColumns(10);
		TextoComponente.setBounds(160, 91, 304, 20);
		PainelCriar.add(TextoComponente);
		
		JLabel CargaHor = new JLabel("Carga Horária:");
		CargaHor.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		CargaHor.setBounds(10, 120, 150, 20);
		PainelCriar.add(CargaHor);
		
		TextoCH = new JTextField();
		TextoCH.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		TextoCH.setColumns(10);
		TextoCH.setBounds(160, 122, 85, 20);
		PainelCriar.add(TextoCH);
		
		JLabel CR = new JLabel("CR:");
		CR.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		CR.setBounds(10, 150, 150, 20);
		PainelCriar.add(CR);
		
		TextoCR = new JTextField();
		TextoCR.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		TextoCR.setColumns(10);
		TextoCR.setBounds(160, 153, 85, 20);
		PainelCriar.add(TextoCR);
		
		JButton LimparBtn = new JButton("Limpar");
		LimparBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextoCodComp.setText("");
				TextoComponente.setText("");
				TextoCH.setText("");
				TextoCR.setText("");
				TextoNatureza.setText("");
			}
		});
		LimparBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		LimparBtn.setBounds(279, 192, 120, 40);
		PainelCriar.add(LimparBtn);
		
		JButton CadastrarBtn = new JButton("Cadastrar");
		CadastrarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CodigoComponente = TextoCodComp.getText();
				String NomeComponente = TextoComponente.getText();
				String CargaHoraria = TextoCH.getText();
				String CoefRend = TextoCR.getText();
				String Natureza = TextoNatureza.getText();
				
				Control.InsereDados(CodigoComponente, NomeComponente, CargaHoraria, CoefRend, Natureza);
			}
			
			
		});
		CadastrarBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		CadastrarBtn.setBounds(409, 192, 120, 40);
		PainelCriar.add(CadastrarBtn);
		
		JLabel Natureza = new JLabel("Natureza:");
		Natureza.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		Natureza.setBounds(10, 181, 150, 20);
		PainelCriar.add(Natureza);
		
		TextoNatureza = new JTextField();
		TextoNatureza.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		TextoNatureza.setColumns(10);
		TextoNatureza.setBounds(160, 184, 99, 20);
		PainelCriar.add(TextoNatureza);
		
		JButton PesquisarBtnAba = new JButton("Pesquisar");
		PesquisarBtnAba.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		PesquisarBtnAba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelCriar.setVisible(false);
				PainelPesquisar.setVisible(true);
			}
		});
		PesquisarBtnAba.setBounds(10, 55, 125, 40);
		Panel.add(PesquisarBtnAba);
		
		JButton CriarBtnAba = new JButton("Cadastrar");
		CriarBtnAba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelPesquisar.setVisible(false);
				PainelCriar.setVisible(true);
			}
		});
		CriarBtnAba.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		CriarBtnAba.setBounds(145, 55, 125, 40);
		Panel.add(CriarBtnAba);
		
		JLabel TituloAba = new JLabel("Disciplinas BICT");
		TituloAba.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		TituloAba.setBounds(10, 11, 260, 33);
		Panel.add(TituloAba);
	}
}
