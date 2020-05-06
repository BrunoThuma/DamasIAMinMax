/**
 * Uma implementação de Lista obedecendo a política FIFO para inserção e remoção.
 * 
 * @author Marcos.
 * @version V 1.0
 */
public class Fila extends Lista
{
 
        
    /**
     * Insere um Nodo da Lista obedecendo a política de inserção da Lista em particular.
     * 
     * @param noco o Nodo que será inserido na Lista.
     */
    void inserir(Nodo nodo) 
    {
        lista.add(nodo) ;
    }
    
    /**
     * Remove um Nodo da Lista obedecendo a política de remoção da Lista em particular.
     * 
     * @return   o Nodo removido ou null se a Lista estiver vazia.
     */
    Nodo remover()  
    {
        return lista.remove(0) ;
    }
    

 

}
