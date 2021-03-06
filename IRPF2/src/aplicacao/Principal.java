package aplicacao;

import javax.swing.JOptionPane;

import dadosCidadao.Cidadao;
import dadosCidadao.IRPF;

public class Principal {
	static IRPF ir = null;
	
	// lista de menu
	private static final int cadastrar_dependente = 1;
	private static final int apagar_dependente = 2;
	private static final int ver_dependente = 3;
	private static final int cadastro_rend = 4;
	private static final int lista_rend = 5;
	private static final int apagar_rend = 6;
	private static final int cadastro_ded = 7;
	private static final int lista_ded = 8;
	private static final int apagar_ded = 9;
	private static final int valor_imposto = 10;
	private static final int SAIR_DO_PROGRAMA = 11;
	
	public static void main(String[]args) {
	
	cadastrarNovoCidadao();
	int opcao = lerOpcaoDoMenu();
	
	while(opcao != SAIR_DO_PROGRAMA){
		switch(opcao){
		case cadastrar_dependente:
			cadastrarNovoDependente();
			break;
		case apagar_dependente:
			apagarDependente();
			break;
		case ver_dependente:
			listaDependente();
			break;
		case cadastro_rend:
			cadastrarNovorendimento();
			break;
		case lista_rend:
			listaRendimento();
			break;
		case apagar_rend:
			apagarRendimento();
			break;
		case cadastro_ded:
			cadastrarNovaDeducao();
			break;
		case lista_ded:
			listaDeducao();
			break;
		case apagar_ded:
			apagarDeducao();
			break;
		case valor_imposto:
			calcularImposto();
			break;
		case SAIR_DO_PROGRAMA:
			JOptionPane.showMessageDialog(null,"[Programa será encerado!]");
			break;
		 default:
			 JOptionPane.showMessageDialog(null,"Opcao Invalida!");
			 break;
		}
		
		opcao = lerOpcaoDoMenu();
	}
	
}
	
private static int lerOpcaoDoMenu(){
		String menu = "[-------- Menu ---------]";
		menu += "\n[1] - Cadastrar dependente";
		menu += "\n[2] - Apagar dependente";
		menu += "\n[3] - Lista de dependentes";
		menu += "\n[4] - Cadastro de rendimentos";
		menu += "\n[5] - Lista de rendimentos";
		menu += "\n[6] - Apagar rendimentos";
		menu += "\n[7] - Cadastrar deduções";
		menu += "\n[8] - Lista de deduções";
		menu += "\n[9] - Apagar deduções";
		menu += "\n[10] - Imposto";
		menu += "\n[11] - Sair";
		menu += "\n[ ------------------------- ]";
		menu += "\nInforme sua opcao: ";
		
		String strOpcao = JOptionPane.showInputDialog(null,menu);
		
		return Integer.parseInt(strOpcao);
	}
	
	// cadastro do cidadao
	private static void cadastrarNovoCidadao(){
	String nome = JOptionPane.showInputDialog("Entre com o nome do cidadao:");
	String sexo = JOptionPane.showInputDialog("Entre com o sexo do cidadao:");
	String CPF = JOptionPane.showInputDialog("Entre com o cpf do cidadao:");
	ir = new IRPF(nome, sexo, CPF);
	}
	
	// cadastro de dependente
	private static void cadastrarNovoDependente(){
	int numDependente = Integer.parseInt(JOptionPane.showInputDialog("Quantos dependentes deseja cadastrar?"));
	
	Cidadao c = ir.getCidadao();
	
	for (int i=0; i<numDependente; i++){
		c.cadastrarDependente();
		}
	}
	
	// apagar dependente
	private static void apagarDependente() {
		Cidadao c = ir.getCidadao();
		if(c.contaDependente()==0) {
			JOptionPane.showMessageDialog(null, "Não há dependentes cadastrados");
			return;
		}
		
		String nomeRemover = JOptionPane.showInputDialog("Informe o nome do dependente que deseja remover");
		
		if(c.removerDependente(nomeRemover) == 0) {
			JOptionPane.showMessageDialog(null, "Náo há dependentes com esse nome");
		}
			else {
				JOptionPane.showMessageDialog(null, "Dependente removido");
			}
		return;
	}
	
	//listar dependente
	private static void listaDependente() {
		Cidadao c = ir.getCidadao();
		c.listaDependente();
	}
	
	//cadastar novo rendimento
	private static void cadastrarNovorendimento(){
		int numRen = Integer.parseInt(JOptionPane.showInputDialog("Quantos rendimentos deseja cadastrar?"));
		
		for (int i=0; i<numRen; i++){
			ir.cadastrarRendimento();;
			}
		}
	
	//listrar rendimento
	private static void listaRendimento() {
		ir.listaRendimentos();
	}
	
	//apagar rendimento
	private static void apagarRendimento() {
		if(ir.contaRendimento()==0) {
			JOptionPane.showMessageDialog(null, "Náo há rendimentos cadastrados");
			return;
		}
		
		String nomeRemover = JOptionPane.showInputDialog("Informe a descrição do rendimento que deseja remover");
		
		if(ir.removerRendimento(nomeRemover) == 0) {
			JOptionPane.showMessageDialog(null, "Nao há rendimentos com essa descrição");
		}
			else {
				JOptionPane.showMessageDialog(null, "Rendimento removido");
			}
		return;
	}
	
	//cadastar nova deducao
	
		private static void cadastrarNovaDeducao(){
			int numRen = Integer.parseInt(JOptionPane.showInputDialog("Quantas deduções deseja cadastrar?"));
			
			for (int i=0; i<numRen; i++){
				ir.cadastrarDeducao();
				}
			}
		
		private static void listaDeducao() {
			ir.listaDeducao();
		}
		
		private static void apagarDeducao() {
			if(ir.contaDed()==0) {
				JOptionPane.showMessageDialog(null, "Não há deduções cadastradas");
				return;
			}
			
			String nomeRemover = JOptionPane.showInputDialog("Informe a descrição da dedução que deseja remover");
			
			if(ir.removerDed(nomeRemover) == 0) {
				JOptionPane.showMessageDialog(null, "Náo há dedução com essa descrição");
			}
				else {
					JOptionPane.showMessageDialog(null, "Dedução removida");
				}
			return;
		}
		
	//valor do imposto
		private static void calcularImposto() {
			JOptionPane.showMessageDialog(null, "Seu imposto foi de : " +  ir.calculaImposto());
		}
}

