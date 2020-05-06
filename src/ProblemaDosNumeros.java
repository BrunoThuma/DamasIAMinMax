public class ProblemaDosNumeros implements Problema
{
    private Fila estadosFinais = new Fila() ;

    public ProblemaDosNumeros()
    {
        Nodo objetivo = new Nodo() ;
        EstadoDosNumeros estado = new EstadoDosNumeros() ;
        estado.estadoFinal() ;
        objetivo.setEstado(estado) ;
        estadosFinais.inserir(objetivo);
    }

    public Nodo nodoInicial() 
    {
        Nodo primeiro = new Nodo() ;
        EstadoDosNumeros estado = new EstadoDosNumeros() ;
        estado.estadoInicial() ;
        primeiro.setEstado(estado) ;
        return primeiro ;
    }

    public boolean verificaObjetivo(Nodo nodo) 
    {
        Estado estadoParaVerificar = nodo.getEstado();
        return estadosFinais.pesquisar(estadoParaVerificar) ;
    }

    public Fila gerarFilhos(Nodo nodo) 
    {        
        Fila filhos = new Fila() ;
        EstadoDosNumeros estado = (EstadoDosNumeros) nodo.getEstado() ;
        /**
        System.out.println();
        System.out.println("Pai");
        estado.mostra();
        **/
        EstadoDosNumeros[] novos = new EstadoDosNumeros[4];
        novos[0] = estado.novoParaCima(); ;
        novos[1] = estado.novoParaBaixo() ;
        novos[2] = estado.novoParaEsquerda() ;
        novos[3] = estado.novoParaDireita() ;
        Nodo novoNodo ;
        
        
        //System.out.println("Filhos");
        
        for(int i=0 ; i<4 ; i++)
        {
            if(novos[i] != null)
            {
                //novos[i].mostra() ;
                
                novoNodo = new Nodo() ;
                novoNodo.setEstado(novos[i]) ;
                novoNodo.setPai(nodo) ;
                int profundidade = nodo.getProfundidade()+1 ;
                novoNodo.setProfundidade(profundidade) ;
                novoNodo.setCusto(profundidade) ;
                filhos.inserir(novoNodo) ;
            }
        }
        return filhos ;
    }

    /**
     * Heuristica 1
     */
    public int h1(Estado estado)
    {
        EstadoDosNumeros estadoNum = (EstadoDosNumeros) estado ;
        int[][] numeros = estadoNum.getNumeros() ;
        int k = 1 ;
        int foraDoLugar = 0 ;
        for(int i=0 ; i<3 ; i++)
        {
            for(int j=0 ; j<3 ; j++)
            {
                if(numeros[i][j] != k)
                {
                    foraDoLugar++ ;
                }
                k++;
            }
        }
        foraDoLugar--;
        return foraDoLugar ;        
    }

    /**
     * Heuristica 2
     */
    public int h2(Estado estado)
    {
        EstadoDosNumeros estadoNum = (EstadoDosNumeros) estado ;
        int[][] numeros = estadoNum.getNumeros() ;
        int estimativa = 0 ;
        for(int i=0 ; i<3 ; i++)
        {
            for(int j=0 ; j<3 ; j++)
            {
                switch (numeros[i][j]) 
                {
                    case 1 :
                    estimativa += i+j ;
                    break ;
                    case 2 :
                    estimativa += i+Math.abs(j-1) ;
                    break ;
                    case 3 :
                    estimativa += i+Math.abs(j-2) ;
                    break ;
                    case 4 :
                    estimativa += Math.abs(i-1)+j ;
                    break ;
                    case 5 :
                    estimativa += Math.abs(i-1)+Math.abs(j-1) ;
                    break ;
                    case 6 :
                    estimativa += Math.abs(i-1)+Math.abs(j-2) ;
                    break ;
                    case 7 :
                    estimativa += Math.abs(i-2)+j ;
                    break ;
                    case 8 :
                    estimativa += Math.abs(i-2)+Math.abs(j-1) ;
                    break ;
                }

            }
        }
        return estimativa ;
    }

    public void apresentaSolucao(Nodo nodoSolucao) 
    {
        // deve apresentar a solução do problema (poderia retornar um objeto que representa a solução) 
        System.out.println("Numero de nodos gerados : "+Nodo.getQuantos());
        System.out.println("Numero de movimentos : "+nodoSolucao.getProfundidade());
        System.out.println() ;
        Nodo temp = nodoSolucao;
        EstadoDosNumeros estado ;
        while(temp.getProfundidade() > 0)
        {
            estado = (EstadoDosNumeros) temp.getEstado();
            estado.mostra();
            temp = temp.getPai();
        }
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
