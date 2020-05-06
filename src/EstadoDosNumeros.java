public class EstadoDosNumeros extends Estado
{
    private int[][] estado = new int[3][3] ; 
    private int brancoLinha ;
    private int brancoColuna ;

    public void estadoInicial()
    {
        /**
        estado[0][0] = 1 ;
        estado[0][1] = 2 ;
        estado[0][2] = 3 ;
        estado[1][0] = 5 ;
        estado[1][1] = 0 ;
        estado[1][2] = 6 ;
        estado[2][0] = 4 ;
        estado[2][1] = 7 ;
        estado[2][2] = 8 ;
        brancoLinha = 1 ;
        brancoColuna = 1 ;
        
        estado[0][0] = 4 ;
        estado[0][1] = 1 ;
        estado[0][2] = 3 ;
        estado[1][0] = 7 ;
        estado[1][1] = 0 ;
        estado[1][2] = 6 ;
        estado[2][0] = 5 ;
        estado[2][1] = 2 ;
        estado[2][2] = 8 ;
        brancoLinha = 1 ;
        brancoColuna = 1 ;       
       
        estado[0][0] = 7 ;
        estado[0][1] = 1 ;
        estado[0][2] = 0 ;
        estado[1][0] = 5 ;
        estado[1][1] = 3 ;
        estado[1][2] = 2 ;
        estado[2][0] = 8 ;
        estado[2][1] = 4 ;
        estado[2][2] = 6 ;
        brancoLinha = 0 ;
        brancoColuna = 2 ;       
         **/
        
        estado[0][0] = 6 ;
        estado[0][1] = 0 ;
        estado[0][2] = 5 ;
        estado[1][0] = 1 ;
        estado[1][1] = 7 ;
        estado[1][2] = 3 ;
        estado[2][0] = 8 ;
        estado[2][1] = 4 ;
        estado[2][2] = 2 ;
        brancoLinha = 0 ;
        brancoColuna = 1 ;    
        
    }

    public void estadoFinal()
    {
        estado[0][0] = 1 ;
        estado[0][1] = 2 ;
        estado[0][2] = 3 ;
        estado[1][0] = 4 ;
        estado[1][1] = 5 ;
        estado[1][2] = 6 ;
        estado[2][0] = 7 ;
        estado[2][1] = 8 ;
        estado[2][2] = 0 ;
        brancoLinha = 2 ;
        brancoColuna = 2 ;
    }

    public EstadoDosNumeros novoParaCima()
    {
        if(brancoLinha>0)
        {
            int[][] novosNumeros = new int[3][3];
            for(int i=0 ; i<3 ; i++)
            {
                for(int j=0 ; j<3 ; j++)
                {
                    novosNumeros[i][j] = estado[i][j] ;
                }
            }
            novosNumeros[brancoLinha][brancoColuna] = estado[brancoLinha-1][brancoColuna] ;
            novosNumeros[brancoLinha-1][brancoColuna] = 0;
            EstadoDosNumeros novo = new EstadoDosNumeros() ;
            novo.setNumeros(novosNumeros) ;
            novo.setBrancoLinha(brancoLinha-1) ;
            novo.setBrancoColuna(brancoColuna) ;
            return novo ;
        }
        return null ;
    }

    public EstadoDosNumeros novoParaBaixo()
    {
        if(brancoLinha<2)
        {
            int[][] novosNumeros = new int[3][3];
            for(int i=0 ; i<3 ; i++)
            {
                for(int j=0 ; j<3 ; j++)
                {
                    novosNumeros[i][j] = estado[i][j] ;
                }
            }
            novosNumeros[brancoLinha][brancoColuna] = estado[brancoLinha+1][brancoColuna] ;
            novosNumeros[brancoLinha+1][brancoColuna] = 0;
            EstadoDosNumeros novo = new EstadoDosNumeros() ;
            novo.setNumeros(novosNumeros) ;
            novo.setBrancoLinha(brancoLinha+1) ;
            novo.setBrancoColuna(brancoColuna) ;
            return novo ;
        }
        return null ;
    }
    
    public EstadoDosNumeros novoParaEsquerda()
    {
        if(brancoColuna>0)
        {
            int[][] novosNumeros = new int[3][3];
            for(int i=0 ; i<3 ; i++)
            {
                for(int j=0 ; j<3 ; j++)
                {
                    novosNumeros[i][j] = estado[i][j] ;
                }
            }
            novosNumeros[brancoLinha][brancoColuna] = estado[brancoLinha][brancoColuna-1] ;
            novosNumeros[brancoLinha][brancoColuna-1] = 0;
            EstadoDosNumeros novo = new EstadoDosNumeros() ;
            novo.setNumeros(novosNumeros) ;
            novo.setBrancoLinha(brancoLinha) ;
            novo.setBrancoColuna(brancoColuna-1) ;
            return novo ;
        }
        return null ;
    }
    
    public EstadoDosNumeros novoParaDireita()
    {
        if(brancoColuna<2)
        {
            int[][] novosNumeros = new int[3][3];
            for(int i=0 ; i<3 ; i++)
            {
                for(int j=0 ; j<3 ; j++)
                {
                    novosNumeros[i][j] = estado[i][j] ;
                }
            }
            novosNumeros[brancoLinha][brancoColuna] = estado[brancoLinha][brancoColuna+1] ;
            novosNumeros[brancoLinha][brancoColuna+1] = 0;
            EstadoDosNumeros novo = new EstadoDosNumeros() ;
            novo.setNumeros(novosNumeros) ;
            novo.setBrancoLinha(brancoLinha) ;
            novo.setBrancoColuna(brancoColuna+1) ;
            return novo ;
        }
        return null ;        
    }
    
    public boolean equals(Estado outroEstado) 
    {
        int[][] outro = ((EstadoDosNumeros)outroEstado).getNumeros();
        for(int i=0 ; i<3 ; i++)
        {
            for(int j=0 ; j<3 ; j++)
            {
                if(this.estado[i][j]!=outro[i][j])
                {
                    return false ;
                }
            }
        }
        return true ;
    }
    
    public int[][] getNumeros()
    {
        return estado ;
    }

    public void setNumeros(int[][] numeros)
    {
        estado = numeros ;
    }
    
    public void setBrancoLinha(int linha)
    {
        brancoLinha = linha ;
    }

    public void setBrancoColuna(int coluna)
    {
        brancoColuna = coluna ;
    }
    
    public void mostra()
    {
        System.out.println();
        for(int i=0 ; i<3 ; i++)
        {
            System.out.println(estado[i][0]+"  "+estado[i][1]+"  "+estado[i][2]);
        }
        
    }

}
