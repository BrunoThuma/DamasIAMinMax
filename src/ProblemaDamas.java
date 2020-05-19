import java.util.ArrayList;


public class ProblemaDamas implements Problema {
	private Nodo nodoInicial;
	
	@Override
	public Nodo nodoInicial() {
		this.nodoInicial = new Nodo();
		EstadoDamas estado = new EstadoDamas();
        estado.estadoInicial();
        this.nodoInicial.setEstado(estado);
        return this.nodoInicial;
	}

	public void setNodoInicial(Estado estado) {
		this.nodoInicial = new Nodo();
        this.nodoInicial.setEstado(estado);
	}
	
	public Nodo getNodoInicial(){
		return this.nodoInicial;
	}
	
	@Override
	public boolean verificaObjetivo(Nodo nodo) {
		EstadoDamas e = (EstadoDamas) nodo.getEstado();
		int[][] damas = e.getDamas();
		int i, j;
		boolean tem1 = false, tem2 = false;
		// verifica se um jogador nao tem mais pecas
		for(i = 0; i < damas.length; i++){
			for(j = 0; j < damas[i].length; j++){
				if(damas[i][j] == EstadoDamas.PECA_1 || damas[i][j] == EstadoDamas.DAMA_1){
					tem1 = true;
				} else if(damas[i][j] == EstadoDamas.PECA_2 || damas[i][j] == EstadoDamas.DAMA_2){
					tem2 = true;
				}
			}
			if(tem1 && tem2){
				return false;
			}
		}
		// verifica se jogador esta bloquado, nao pode mais fazer jogadas
		// essa verificacao eh feita no minimax, quando o gerar filhos nao retonar mais filhos
		return true;
	}

	@Override
	public Fila gerarFilhos(Nodo nodo) {
		Fila filhos = new Fila();
		ArrayList<EstadoDamas> temp;
		Nodo novoNodo;
		EstadoDamas e = (EstadoDamas) nodo.getEstado();
		int[][] damas = e.getDamas();
		int i, j;
		for(i = 0; i < damas.length; i++){
			for(j = 0; j < damas[i].length; j++){
				temp = e.novosMovimento(i, j);
				for (EstadoDamas tempEstado : temp) {
					if(tempEstado != null){
                                            novoNodo = new Nodo() ;
                                            novoNodo.setEstado(tempEstado) ;
                                            novoNodo.setPai(nodo) ;
                                            novoNodo.setProfundidade(nodo.getProfundidade() + 1) ;
                                            filhos.inserir(novoNodo) ;
					}
				}
			}
		}
		return filhos;
	}

	@Override
	public int funcaoAvaliacao(Estado estado){
		/*
		 * damas - Vantagem em Damas
		 * pecas - Vantagem em outras Peças
		 * mobilidade - Vantagem em mobilidade (número de movimentos que Max pode fazer de forma que Min não pode tomar peças)
		 */
		EstadoDamas e = (EstadoDamas) estado;
		int[] numVantagem = e.calculaNumVantagem();
		return 6*numVantagem[1] + 4*numVantagem[0] + e.calculaMobilidade();
	}

	@Override
	public void apresentaSolucao(Nodo nodoSolucao) {
		EstadoDamas e = (EstadoDamas) nodoSolucao.getEstado();
		System.out.println("Solucao: ");
		e.mostra();
	}

	@Override
	public int h1(Estado estado) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int h2(Estado estado) {
		// TODO Auto-generated method stub
		return 0;
	}

}
