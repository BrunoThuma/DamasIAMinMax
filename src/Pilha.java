
/**
 * Write a description of class Pilha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pilha extends Lista
{
      
    /**
     * Insere um Nodo da Lista obedecendo a política de inserção da Lista em particular.
     * 
     * @param noco o Nodo que será inserido na Lista.
     */
    void inserir(Nodo nodo) 
    {
        lista.add(0,nodo) ;
    }
    
    /**
     * Remove um Nodo da Lista obedecendo a política de remoção da Lista em particular.
     * 
     * @return   o Nodo removido ou null se a Lista estiver vazia.
     */
    Nodo remover()  
    {
        return lista.get(0);
    }
    

}
