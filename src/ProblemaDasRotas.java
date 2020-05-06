
/**
 * Write a description of class ProblemaDasRotas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProblemaDasRotas implements Problema
{
    private Fila objetivos = new Fila() ;
    
    public ProblemaDasRotas()
    {
        // insere Nodos com Estados objetivo na fila de objetivos
    }
    
    public Nodo nodoInicial() 
    {
        Nodo primeiro = new Nodo() ;
        EstadoRotas estado = new EstadoRotas() ;
        // Montar agora a estrutura para o estado das rotas
        primeiro.setEstado(estado) ;
        return primeiro ;
    }
    
    public boolean verificaObjetivo(Nodo nodo) 
    {
        Estado estadoParaVerificar = nodo.getEstado();
        return objetivos.pesquisar(estadoParaVerificar) ;
    }
    
    public Fila gerarFilhos(Nodo nodo) 
    {
        return new Fila() ; //deve incluir todos os filhos de "nodo" nesta Fila
    }
    
    public void apresentaSolucao(Nodo nodoSolucao) 
    {
        // deve apresentar a solução do problema (poderia retornar um objeto que representa a solução) 
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

	@Override
	public int funcaoAvaliacao(Estado estado) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Nodo getNodoInicial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNodoInicial(Estado estado) {
		// TODO Auto-generated method stub
		
	}
}
