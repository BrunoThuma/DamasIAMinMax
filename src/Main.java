import javax.swing.JOptionPane;


public class Main
{
    public static void main(String[] args)
    {
        
        String[] jogadores = {"Humano","Ia"};
    	// Damas
    	int nivel= Integer.parseInt(JOptionPane.showInputDialog("Quantos niveis serao utilizados?"));
//        int primJogador = Integer.parseInt(JOptionPane.showInputDialog("Quem Jogara primeiro? 1 para IA 2 para Humano"));
        int primJogador = JOptionPane.showOptionDialog(null, "Quem jogara primeiro?",
                "Escolher jogador",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, jogadores, jogadores[0]);
        
        System.out.println("o primeiro a jogar sera: " + primJogador);
    	EstadoDamas e = new EstadoDamas();
    	e.estadoInicial();
        // Para printar o tabuleiro no console antes de iniciar o jogo descomentar o ciclo abaixo
//        int [][] tabuleiro = e.getDamas();
//        for (int[] i : tabuleiro){
//            for (int j : i){
//                System.out.print(j + " ");
//            }
//            System.out.println("");
//        }
        Tabuleiro tab = new Tabuleiro(e.getDamas(), e, nivel, primJogador);
        tab.setVisible(true);
		
//    	e.setJogador(EstadoDamas.JOGADOR_1);
//    	int[][] matriz = new int[][]{
//			{0, 1, 0, 1, 0, 1, 0, 1},
//			{1, 0, 0, 0, 0, 0, 1, 0},
//			{0, 0, 0, 0, 0, 1, 0, 2},
//			{1, 0, 1, 0, 0, 0, 0, 0},
//			{0, 0, 0, 0, 0, 0, 0, 0},
//			{2, 0, 2, 0, 2, 0, 2, 0},
//			{0, 2, 0, 2, 0, 0, 0, 0},
//			{2, 0, 2, 0, 0, 0, 0, 0}};
//    	e.setDamas(matriz);
    	
//		// teste minimax
//    	Problema p = new ProblemaDamas();
//    	ResolvedorDeProblemas r = new ResolvedorDeProblemas();
//    	r.minimax(p);

//    	e.mostra();
    	/*
    	try {
    		e = e.movimento(1, 6, 0, 7);
        	e.mostra();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		*/
    	/*
    	try {
    		e = e.movimento(6, 1, 7, 0);
        	e.mostra();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
    	*/
    	
//    	// teste geracao estados
//    	Problema p = new ProblemaDamas();
//    	Nodo nodoInicial = p.nodoInicial();
//    	Nodo nodo = null;
//    	
//    	EstadoDamas eInicial = (EstadoDamas) nodoInicial.getEstado();
////    	EstadoDamas e;
////		System.out.println(eInicial.getJogador());
//    	eInicial.mostra();
////		System.out.println(p.funcaoAvaliacao(eInicial));
//        
//        ArrayList<EstadoDamas> temp = eInicial.novosMovimento(3, 4);
//		for (EstadoDamas tempEstado : temp) {
//			if(tempEstado != null){
//				nodo = new Nodo() ;
//				nodo.setEstado(tempEstado) ;
//				nodo.setPai(nodoInicial) ;
//				nodo.setProfundidade(nodoInicial.getProfundidade() + 1) ;
//                tempEstado.mostra();
//			}
//		}
    	
//    	Fila f = p.gerarFilhos(nodoInicial);
//    	while(!f.vazia()){
//        	nodo = f.remover();
//    		e = (EstadoDamas) nodo.getEstado();
////    		System.out.println(e.getJogador());
//    		e.mostra();
////    		System.out.println(p.funcaoAvaliacao(e));
//    	}
//    	f = p.gerarFilhos(nodo);
//    	while(!f.vazia()){
//        	nodo = f.remover();
//    		e = (EstadoDamas) nodo.getEstado();
//    		System.out.println(e.getJogador());
//    		e.mostra();
//    	}
    	
//    	// teste 1
//    	e.estadoInicial();
//    	e.mostra();
//    	e = e.movimento(1, 2, 2, 3);
//    	e.mostra();
//    	e = e.movimento(0, 5, 1, 4);
//    	e.mostra();
//    	e = e.movimento(2, 3, 1, 4);
//    	e.mostra();
        
//    	// teste 2 - come peca nao consecutiva
//    	e.setDamas(new int[][]{
//			{0, 1, 0, 1, 0, 1, 0, 1},
//			{1, 0, 1, 0, 1, 0, 1, 0},
//			{0, 1, 0, 0, 0, 1, 0, 1},
//			{0, 0, 1, 0, 0, 0, 0, 0},
//			{0, 2, 0, 0, 0, 0, 0, 0},
//			{2, 0, 0, 0, 2, 0, 2, 0},
//			{0, 2, 0, 2, 0, 2, 0, 2},
//			{2, 0, 2, 0, 2, 0, 2, 0}
//		});
//    	e.mostra();
//    	try {
//			e = e.movimento(2, 3, 1, 4);
//	    	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_2);
//			e = e.movimento(1, 4, 2, 3);
//	    	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
    	
//    	// teste 3
//    	e.setDamas(new int[][]{
//			{0, 1, 0, 1, 0, 1, 0, 1},
//			{1, 0, 1, 0, 1, 0, 1, 0},
//			{0, 0, 0, 1, 0, 1, 0, 1},
//			{1, 0, 0, 0, 0, 0, 0, 0},
//			{0, 2, 0, 0, 0, 0, 0, 0},
//			{0, 0, 2, 0, 2, 0, 2, 0},
//			{0, 2, 0, 2, 0, 2, 0, 2},
//			{2, 0, 2, 0, 2, 0, 2, 0}
//		});
//    	e.mostra();
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_2);
//    		e = e.movimento(1, 4, 0, 3);
//    		e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_1);
//    		e = e.movimento(0, 3, 1, 4);
//    		e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}

//    	// teste 4 - movimento pecas
//    	e.setDamas(new int[][]{
//			{0, 1, 0, 1, 0, 1, 0, 1},
//			{1, 0, 1, 0, 1, 0, 1, 0},
//			{0, 0, 0, 1, 0, 1, 0, 1},
//			{1, 0, 0, 0, 0, 0, 0, 0},
//			{0, 2, 0, 0, 0, 0, 0, 0},
//			{0, 0, 2, 0, 2, 0, 2, 0},
//			{0, 2, 0, 2, 0, 2, 0, 2},
//			{2, 0, 2, 0, 2, 0, 2, 0}
//		});
//    	e.mostra();
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_1);
//    		e = e.movimento(0, 0, 1, 1);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 2, 3);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 3, 3);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 4, 3);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 2, 2);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 4, 2);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 2, 1);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 3, 1);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 4, 1);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
    	
//    	// teste 5 - peca vira dama
//    	e.setDamas(new int[][]{
//			{0, 1, 0, 1, 0, 1, 0, 0},
//			{1, 0, 1, 0, 1, 0, 2, 0},
//			{0, 0, 0, 1, 0, 1, 0, 1},
//			{1, 0, 0, 0, 0, 0, 0, 0},
//			{0, 2, 0, 0, 0, 0, 0, 0},
//			{0, 0, 2, 0, 2, 0, 2, 0},
//			{0, 1, 0, 2, 0, 2, 0, 2},
//			{0, 0, 2, 0, 2, 0, 2, 0}
//		});
//    	e.mostra();
//    	try {
//    		e = e.movimento(1, 6, 0, 7);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(6, 1, 7, 0);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
    	
//    	// teste 6 - movimentos da dama
//    	e.setDamas(new int[][]{
//			{0, 1, 0, 1, 0, 1, 0, 1},
//			{1, 0, 1, 0, 1, 0, 1, 0},
//			{0, 0, 0, 11, 0, 1, 0, 1},
//			{1, 0, 0, 0, 0, 0, 0, 0},
//			{0, 2, 0, 0, 0, 0, 0, 0},
//			{0, 0, 2, 0, 2, 0, 2, 0},
//			{0, 2, 0, 2, 0, 2, 0, 2},
//			{2, 0, 2, 0, 2, 0, 2, 0}
//		});
//    	e.mostra();
//    	try {
//    		e = e.movimento(3, 2, 2, 3);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 3, 3);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 4, 3);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 2, 2);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 4, 2);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 2, 1);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 3, 1);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e = e.movimento(3, 2, 4, 1);
//        	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
    	
    	// teste 7 - dama so come na diagonal
//    	e.setDamas(new int[][]{
//			{0, 1, 0, 1, 0, 1, 0, 1},
//			{1, 0, 1, 0, 1, 0, 1, 0},
//			{0, 0, 0, 0, 0, 1, 0, 1},
//			{0, 1, 1, 0, 0, 0, 0, 0},
//			{0, 22, 0, 0, 0, 0, 0, 0},
//			{2, 0, 0, 0, 2, 0, 2, 0},
//			{0, 2, 0, 2, 0, 2, 0, 2},
//			{2, 0, 2, 0, 2, 0, 2, 0}
//		});
//    	e.mostra();
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_2);
//			e = e.movimento(1, 4, 0, 3);
//	    	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_2);
//			e = e.movimento(1, 4, 1, 3);
//	    	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_2);
//			e = e.movimento(1, 4, 2, 3);
//	    	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_2);
//			e = e.movimento(1, 4, 0, 4);
//	    	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_2);
//			e = e.movimento(1, 4, 2, 4);
//	    	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_2);
//			e = e.movimento(1, 4, 0, 5);
//	    	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_2);
//			e = e.movimento(1, 4, 1, 5);
//	    	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
    	
//    	// teste 8 - obriga comer peca
//    	e.setDamas(new int[][]{
//			{0, 1, 0, 1, 0, 1, 0, 1},
//			{1, 0, 1, 0, 0, 0, 1, 0},
//			{0, 1, 0, 1, 0, 1, 0, 1},
//			{0, 0, 1, 0, 0, 0, 0, 0},
//			{0, 2, 0, 0, 0, 0, 0, 0},
//			{0, 0, 2, 0, 2, 0, 2, 0},
//			{0, 2, 0, 2, 0, 2, 0, 2},
//			{2, 0, 2, 0, 2, 0, 2, 0}
//		});
//    	e.mostra();
//    	try {
//    		e.setJogador(EstadoDamas.JOGADOR_2);
//			e = e.movimento(6, 5, 7, 4);
//	    	e.mostra();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
////    	try {
////			e = e.movimento(2, 3, 3, 4);
////	    	e.mostra();
////		} catch (Exception ex) {
////			ex.printStackTrace();
////			System.out.println(ex.getMessage());
////		}
//    	try {
//			e = e.movimento(2, 3, 1, 4);
//	    	e.mostra();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//    	try {
//			e = e.movimento(4, 5, 5, 4);
//	    	e.mostra();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//    	try {
//			e = e.movimento(3, 2, 4, 3);
//	    	e.mostra();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
//    	try {
//			e = e.movimento(2, 5, 1, 4);
//	    	e.mostra();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//		}
    	
//    	// teste 9 - mobilidade
////    	e.setDamas(new int[][]{
////			{0, 1, 0, 1, 0, 1, 0, 1},
////			{1, 0, 1, 0, 0, 0, 1, 0},
////			{0, 1, 0, 1, 0, 1, 0, 1},
////			{0, 0, 1, 0, 0, 0, 0, 0},
////			{0, 0, 0, 0, 0, 0, 0, 0},
////			{2, 0, 2, 0, 2, 0, 2, 0},
////			{0, 2, 0, 2, 0, 2, 0, 2},
////			{2, 0, 2, 0, 2, 0, 2, 0}
////		});
//    	// 7
//    	e.setDamas(new int[][]{
//			{0, 1, 0, 1, 0, 1, 0, 1},
//			{1, 0, 1, 0, 0, 0, 1, 0},
//			{0, 1, 0, 0, 0, 1, 0, 0},
//			{0, 0, 1, 0, 1, 0, 1, 0},
//			{0, 0, 0, 0, 0, 0, 0, 2},
//			{2, 0, 2, 0, 2, 0, 0, 0},
//			{0, 2, 0, 2, 0, 2, 0, 2},
//			{2, 0, 2, 0, 2, 0, 2, 0}
//		});
//    	// 6
//    	e.mostra();
//    	System.out.println(e.calculaMobilidade());
    	
    }
}
