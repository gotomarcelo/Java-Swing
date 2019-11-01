package disciplina.cr;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import connection.conexao;
import model.componente;

public class Controle{
	
	public void InsereDados(String codigo, String nome, String ch, String cr, String natureza) {
		conexao disciplinas = new conexao();
		String retorno = "erro";
		try {
			
			Connection ExConn = (Connection) disciplinas.abrirBDConn();
			Statement stmt = (Statement) ExConn.createStatement();
			String sSQL = "insert into cadeiras (codcomponente, nomecomponente, cargahoraria, crcomponente, natureza) values ('"+ codigo +"','"+ nome +"','"+ ch +"','"
			+ cr +"','"+ natureza +"');";
				System.out.println(sSQL);
			boolean res = stmt.execute(sSQL);
			
			JOptionPane.showMessageDialog(null, (!res)?"Dados inseridos com sucesso!":""+
			"Os dados não puderam ser inseridos!");
			stmt.close();
			disciplinas.fecharBDConn();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Os dados não puderam ser inseridos!");
		}
	}
	
	public List<componente> AtualizaDados() {
		conexao disciplinas = new conexao();
		String retorno = "erro";
		List<componente> materia = new ArrayList<>();
		
		try {
			Connection ExConn = (Connection) disciplinas.abrirBDConn();
			Statement stmt = ExConn.createStatement();
			ResultSet res = null;
				
			String sSQL = "SELECT * FROM cadeiras ;";	
			System.out.println(sSQL);
			res = stmt.executeQuery(sSQL);
				
			while (res.next()) {
				componente materias = new componente();
									
				materias.setCodcomponente(res.getString("codcomponente"));
				materias.setNomecomponente(res.getString("nomecomponente"));
				materias.setCargahoraria(res.getString("cargahoraria"));
				materias.setCrcomponente(res.getString("crcomponente"));
				materias.setNatureza(res.getString("natureza"));
					
				materia.add(materias);
				
			}
			
			System.out.println(Arrays.toString(materia.toArray()));
			stmt.close();
			disciplinas.fecharBDConn();
			res.close();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "A pesquisa não pôde ser feita!");
			System.out.println(e);
		}
		
		return materia;
	}
	
	
	public List<componente> PesquisaDados(String pesqnome) {
		conexao disciplinas = new conexao();
		String retorno = "erro";
		List<componente> materia = new ArrayList<>();
		
		try {
			Connection ExConn = (Connection) disciplinas.abrirBDConn();
			Statement stmt = ExConn.createStatement();
			ResultSet res = null;
				
			String sSQL = "SELECT * FROM cadeiras WHERE nomecomponente = '"+ pesqnome +"';";	
			System.out.println(sSQL);
			res = stmt.executeQuery(sSQL);
				
			while (res.next()) {
				componente materias = new componente();
									
				materias.setCodcomponente(res.getString("codcomponente"));
				materias.setNomecomponente(res.getString("nomecomponente"));
				materias.setCargahoraria(res.getString("cargahoraria"));
				materias.setCrcomponente(res.getString("crcomponente"));
				materias.setNatureza(res.getString("natureza"));
					
				materia.add(materias);
				
			}
			
			System.out.println(Arrays.toString(materia.toArray()));
			stmt.close();
			disciplinas.fecharBDConn();
			res.close();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "A pesquisa não pôde ser feita!");
			System.out.println(e);
		}
		
		return materia;
	}
}
