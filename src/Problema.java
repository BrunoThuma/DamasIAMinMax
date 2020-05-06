
/**
 * Classe base para a definição de problemas.
 * 
 * @author Marcos 
 * @version V 1.0
 */
public interface Problema
{
    public Nodo nodoInicial() ;
    public Nodo getNodoInicial() ;
    public void setNodoInicial(Estado estado) ;
    public boolean verificaObjetivo(Nodo nodo) ;
    public Fila gerarFilhos(Nodo nodo) ;
    public void apresentaSolucao(Nodo nodoSolucao) ;
    public int h1(Estado estado) ;
    public int h2(Estado estado) ;
	public int funcaoAvaliacao(Estado estado);
}
