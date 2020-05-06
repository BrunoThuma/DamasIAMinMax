
/**
 * Objetos desta classe utilizam métodos de busca para resolver problemas.
 * 
 * @author Marcos
 * @version V 1.0
 */

public class ResolvedorDeProblemas
{
	public int MINIMAX_NIVEL; // niveis impares - 3, 5, 7, 9
	Problema problema;

    public ResolvedorDeProblemas()
    {
    
    }

    public boolean buscaCega(Problema problema, Lista fronteira)
    {
        Nodo nodo = problema.nodoInicial() ;
        if(problema.verificaObjetivo(nodo))
        {
            problema.apresentaSolucao(nodo) ; // pode ser substituido por objeto 
            return true ;
        }
        fronteira.inserir(nodo) ;
        Lista explorados = new Fila() ;
        Fila todosOsFilhos ;
        Nodo nodoFilho ;
        do
        {
            if(fronteira.vazia())
            {
                return false ;
            }
            nodo = fronteira.remover() ;
            explorados.inserir(nodo) ;
            todosOsFilhos = problema.gerarFilhos(nodo) ;
            while( !todosOsFilhos.vazia() )
            {
                nodoFilho = todosOsFilhos.remover() ;
                if( !fronteira.pesquisar(nodoFilho.getEstado()) && 
                !explorados.pesquisar(nodoFilho.getEstado()))
                {
                    if(problema.verificaObjetivo(nodoFilho))
                    {
                        problema.apresentaSolucao(nodoFilho) ; // pode ser substituido por objeto 
                        return true ;
                    }
                    fronteira.inserir(nodoFilho) ;
                }
            }
        } while(true);
    }

    public boolean aEstrela(Problema problema, Lista fronteira)
    {
        Nodo nodo = problema.nodoInicial() ;
        if(problema.verificaObjetivo(nodo))
        {
            problema.apresentaSolucao(nodo) ; // pode ser substituido por objeto 
            return true ;
        }
        fronteira.inserir(nodo) ;
        Lista explorados = new Fila() ;
        Fila todosOsFilhos ;
        Nodo nodoFilho ;
        boolean naFronteira ;
        boolean nosExplorados ;
        do
        {
            if(fronteira.vazia())
            {
                System.out.println("Fronteira vazia");
                System.out.println("Numero de nodos gerados : "+Nodo.getQuantos());
                System.out.println() ;
                return false ;
            }
            nodo = fronteira.remover() ;
            explorados.inserir(nodo) ;
            todosOsFilhos = problema.gerarFilhos(nodo) ;
            while( !todosOsFilhos.vazia() )
            {
                nodoFilho = todosOsFilhos.remover() ;
                naFronteira = fronteira.pesquisar(nodoFilho.getEstado()) ;
                nosExplorados = explorados.pesquisar(nodoFilho.getEstado()) ;
                if( ! naFronteira  && ! nosExplorados )
                {
                    if(problema.verificaObjetivo(nodoFilho))
                    {
                        problema.apresentaSolucao(nodoFilho) ; 
                        return true ;
                    }
                    int estimativa = nodoFilho.getCusto() + problema.h1(nodoFilho.getEstado()) ;
                    nodoFilho.setCustoEstimado(estimativa) ;
                    fronteira.inserir(nodoFilho) ;
                }
            }
            // System.out.println("numero de nodos na fronteira : "+fronteira.tamanho());
        } while(true);
    }

    public void minimax(Problema problema){
    	Nodo nodoSolucao = this.maxInicial(problema);
    	//teste
    	System.out.println("Inicial");
    	EstadoDamas e = (EstadoDamas) problema.nodoInicial().getEstado();
    	e.mostra();
    	
    	problema.apresentaSolucao(nodoSolucao);
    }
    
    public Nodo maxInicial(Problema problema){
    	this.problema = problema;
		Fila filhos = this.problema.gerarFilhos(this.problema.getNodoInicial());
		Nodo nodo = null, nodoSolucao = null;
		int alpha = Integer.MIN_VALUE, alphaNovo = 0;
    	while(!filhos.vazia()){
    		nodo = filhos.remover();
    		alphaNovo = this.maxValue(nodo, Integer.MIN_VALUE, Integer.MAX_VALUE);
    		//teste
//    		System.out.println("alpha "+alphaNovo);
//    		EstadoDamas est = (EstadoDamas) nodo.getEstado();
//    		est.mostra();
    		
    		if(alphaNovo >= alpha){
				nodoSolucao = nodo;
				alpha = alphaNovo;
			}
		}
    	return nodoSolucao;
	}
	
	public int maxValue(Nodo nodo, int alpha, int beta){
//		System.out.println("max "+nodo.getProfundidade());
//		EstadoDamas e = (EstadoDamas) nodo.getEstado();
//		e.mostra();
		
		Fila filhos = this.problema.gerarFilhos(nodo);
		// se profundidade chegar ao limite definido
		// ou se um jogador nao possuir mais pecas, verificaObjetivo
		// ou se voltar fila vazia nao tem mais jogadas, jogador bloqueado, fim de jogo
		if(nodo.getProfundidade()+1 > this.MINIMAX_NIVEL || this.problema.verificaObjetivo(nodo) || filhos.vazia()){
			return this.problema.funcaoAvaliacao(nodo.getEstado());
		}
		while(!filhos.vazia()){
			alpha = Math.max(alpha, this.minValue(filhos.remover(), alpha, beta));
			if(alpha >= beta){
				return beta;
			}
		}
		return alpha;
	}
	
	public int minValue(Nodo nodo, int alpha, int beta){
//		System.out.println("min "+nodo.getProfundidade());
//		EstadoDamas e = (EstadoDamas) nodo.getEstado();
//		e.mostra();
		
		Fila filhos = this.problema.gerarFilhos(nodo);
		// se profundidade chegar ao limite definido
		// ou se um jogador nao possuir mais pecas, verificaObjetivo
		// ou se voltar fila vazia nao tem mais jogadas, jogador bloqueado, fim de jogo
		if(nodo.getProfundidade()+1 >= this.MINIMAX_NIVEL || this.problema.verificaObjetivo(nodo) || filhos.vazia()){
			return this.problema.funcaoAvaliacao(nodo.getEstado());
		}
		while(!filhos.vazia()){
			beta = Math.min(beta, this.maxValue(filhos.remover(), alpha, beta));
			if(beta <= alpha){
				return alpha;
			}
		}
		return beta;
	}
	
	/*
	function Max-Value(state, alpha, beta) returns a utility
	value
	if Terminal-Test (state) or nivel = n then return Utility(state)
	for each s in Successors(state) do
		alpha := Max (alpha, Min-Value(s, alpha, beta))
		if alpha >= beta then return beta
	end
	return alpha
	
	function Min-Value(state, alpha, beta) returns a utility
	value
	if Terminal-Test (state) then return Utility(state)
	for each s in Successors(state) do
		beta := Min (beta, Max-Value(s, alpha, beta))
		if beta <= alpha then return alpha
	end
	return beta
     */
	
}
