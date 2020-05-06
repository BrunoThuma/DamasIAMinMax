
/**
 * Write a description of class Nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nodo
{
    private int profundidade = 0 ;
    private Estado estado = null ;
    private Nodo pai = null ;
    private int custo = 0 ;
    private int custoEstimado = 0 ;
    
    private static int quantos = 0 ;
    
    public Nodo()
    {
        quantos++ ;
    }
    
    public boolean estadoIgual(Estado outroEstado)
    {
        return estado.equals(outroEstado) ;
    }
    
    public void setProfundidade(int profundidade)
    {
        this.profundidade = profundidade ;
    }

    public int getProfundidade()
    {
        return profundidade ;
    }
        
    public void setEstado(Estado estado)
    {
        this.estado = estado ;
    }

    public Estado getEstado()
    {
        return estado ;
    }
            
    public void setPai(Nodo pai)
    {
        this.pai = pai;
    }

    public Nodo getPai()
    {
        return pai ;
    }

    public void setCusto(int custo)
    {
        this.custo = custo ;
    }

    public int getCusto()
    {
        return custo;
    }
    
    public void setCustoEstimado(int custoEstimado)
    {
        this.custoEstimado = custoEstimado ;
    }

    public int getCustoEstimado()
    {
        return custoEstimado ;
    }
    
    public static int getQuantos()
    {
        return quantos ;
    }
    
}
