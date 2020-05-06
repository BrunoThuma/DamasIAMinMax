
/**
 * Define uma interface de programação padrão para manipular listas.
 * 
 * @author Marcos
 * @version V1.0
 */

import java.util.ArrayList ;
import java.util.List ;

public abstract class Lista
{
    protected List<Nodo> lista ;
    
    /*
     * Construtor de Lista que inicializa a lista com um ArrayList;
     */
    public Lista()
    {
        lista = new ArrayList<Nodo>() ; //poderia ter uma implementação específica para cada tipo de lista?
    }
    
    /**
     * Insere um Nodo da Lista obedecendo a política de inserção da Lista em particular.
     * 
     * @param noco o Nodo que será inserido na Lista.
     */
    abstract void inserir(Nodo nodo) ;
    
    /**
     * Remove um Nodo da Lista obedecendo a política de remoção da Lista em particular.
     * 
     * @return   o Nodo removido ou null se a Lista estiver vazia.
     */
    abstract Nodo remover() ;
    
    

    /**
     * Consulta uma lista para verificar se um determinado Estado está presente em algum Nodo dela oou não.
     * 
     * @return   true se o Estado aparece em algum Nodo; false se não aparece
     */
    boolean pesquisar(Estado umEstado)  
    {
        for(Nodo nodo : lista)
        {
            if(nodo.estadoIgual(umEstado))
            {
                return true ;
            }
        }
        return false ;
    }
    
    /**
     * Consulta uma lista para verificar se está ou não vazia (quantidade de elementos == 0)
     * 
     * @return   true se está vazia; false se não está
     */
    public boolean vazia() 
    {
        return lista.isEmpty() ;
    }

    public int tamanho()
    {
        return lista.size() ;
    }
    
    
}
