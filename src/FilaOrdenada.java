/**
 * Uma implementação de Lista obedecendo a política FIFO para inserção e remoção.
 * 
 * @author Marcos.
 * @version V 1.0
 */
public class FilaOrdenada extends Lista
{

    /**
     * Insere um Nodo da Lista obedecendo a política de inserção da Lista em particular.
     * 
     * @param noco o Nodo que será inserido na Lista.
     */
    void inserir(Nodo nodo) 
    {
        int estimativa = nodo.getCustoEstimado();
        int tamanho = lista.size() ;
        if(tamanho == 0)
        {
            lista.add(nodo) ;
        }
        else
        {
            if(estimativa >= (lista.get(tamanho-1)).getCustoEstimado())
            {
                lista.add(nodo) ;
            }
            else
            {
                for(int i=0 ; i<lista.size() ; i++)
                {
                    int custoNaLista = (lista.get(i)).getCustoEstimado() ;
                    if(estimativa < custoNaLista  )
                    {
                        lista.add(i,nodo);
                        break;
                    }
                }
            }
        }
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