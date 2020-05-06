
/**
 * Write a description of class ProblemaDosBaldes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProblemaDosBaldes implements Problema
{
    public Nodo nodoInicial() 
    {
        return new Nodo() ; // deve retornar um nodo adequado
    }
    
    public boolean verificaObjetivo(Nodo nodo) 
    {
        return false ; //deve verificar se o nodo é um objetivo
    }
    
    public Fila gerarFilhos(Nodo nodo) 
    {
        return new Fila() ; //deve incluir todos os filhos na Fila
    }
    
    public void apresentaSolucao(Nodo nodoSolucao) 
    {
        // deveria apresentar a solução ;
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
