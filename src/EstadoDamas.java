import java.util.ArrayList;


public class EstadoDamas extends Estado {
	private int jogador;
	private int[][] estado;
	static final int LENGTH_X = 10;
	static final int LENGTH_Y = 10;
        
	
        public int[] comeu = new int[] {-1, -1};
	public static final int JOGADOR_1 = 1;
	public static final int JOGADOR_2 = 2;
	public static final int PECA_1 = 1;
	public static final int PECA_2 = 2;
	public static final int DAMA_1 = 11;
	public static final int DAMA_2 = 22;
	public static final int NOPECA = 0;
	
	public EstadoDamas() {
		super();
		this.estado = new int[LENGTH_X][LENGTH_Y];
	}

	public void estadoInicial() {
		this.jogador = JOGADOR_1;
		/*
		 * 1 - peca jogador 1
		 * 2 - peca jogador 2
		 * 11 - dama jogador 1
		 * 22 - dama jogador 2
		 * 0 - sem peca
		 * 
		 * jogador 1 - pecas de cima
		 * jogador 2 - pecas de baixo
		 */
                this.estado = new int[][]{
                        {NOPECA, PECA_1, NOPECA, PECA_1, NOPECA, PECA_1, NOPECA, PECA_1, NOPECA, PECA_1},
                        {PECA_1, NOPECA, PECA_1, NOPECA, PECA_1, NOPECA, PECA_1, NOPECA, PECA_1, NOPECA},
                        {NOPECA, PECA_1, NOPECA, PECA_1, NOPECA, PECA_1, NOPECA, PECA_1, NOPECA, PECA_1},
                        {PECA_1, NOPECA, PECA_1, NOPECA, PECA_1, NOPECA, PECA_1, NOPECA, PECA_1, NOPECA},
                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
                        {NOPECA, PECA_2, NOPECA, PECA_2, NOPECA, PECA_2, NOPECA, PECA_2, NOPECA, PECA_2},
                        {PECA_2, NOPECA, PECA_2, NOPECA, PECA_2, NOPECA, PECA_2, NOPECA, PECA_2, NOPECA},
                        {NOPECA, PECA_2, NOPECA, PECA_2, NOPECA, PECA_2, NOPECA, PECA_2, NOPECA, PECA_2},
                        {PECA_2, NOPECA, PECA_2, NOPECA, PECA_2, NOPECA, PECA_2, NOPECA, PECA_2, NOPECA}
		};
//		this.estado = new int[][]{
//                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
//                        {NOPECA, NOPECA, PECA_1, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
//                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
//                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
//                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
//                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
//                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
//                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
//                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA},
//                        {NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA, NOPECA}
//		};
	}
	
	/**
	 * Retorna os movimentos possiveis
	 * @param x
	 * @param y
	 * @return
	 */
	public ArrayList<EstadoDamas> novosMovimento(int x, int y){
		ArrayList<EstadoDamas> novos = new ArrayList<EstadoDamas>();
		int peca = this.getDama(x, y);
		if(this.isPermitido(x, y)){
			if(peca == PECA_1){
				try {
					novos.add(this.movimento(x, y, x-1, y+1)); // diagonal esquerda baixo
				} catch (Exception e) {}
				try{
					novos.add(this.movimento(x, y, x+1, y+1)); // diagonal direita baixo
				} catch (Exception e) {}
			}else if(peca == PECA_2){
				try{
					novos.add(this.movimento(x, y, x-1, y-1)); // diagonal esquerda cima
				} catch (Exception e) {}
				try{
					novos.add(this.movimento(x, y, x+1, y-1)); // diagonal direita cima
				} catch (Exception e) {}
			}else if(peca == DAMA_1 || peca == DAMA_2){
				// diagonal direita baixo
				int i = x + 1;
				int j = y + 1;
				while(i < LENGTH_X && j < LENGTH_Y){
					try{
						novos.add(this.movimento(x, y, i, j));
					} catch (Exception e) {}
					if(this.getDama(i, j) != NOPECA){
						break;
					}
					i++;
					j++;
				}
				// diagonal esquerda baixo
				i = x - 1;
				j = y + 1;
				while(i >= 0 && j < LENGTH_Y){
					try{
						novos.add(this.movimento(x, y, i, j));
					} catch (Exception e) {}
					if(this.getDama(i, j) != NOPECA){
						break;
					}
					i--;
					j++;
				}
				// diagonal direita cima
				i = x + 1;
				j = y - 1;
				while(i < LENGTH_X && j >= 0){
					try{
						novos.add(this.movimento(x, y, i, j));
					} catch (Exception e) {}
					if(this.getDama(i, j) != NOPECA){
						break;
					}
					i++;
					j--;
				}
				// diagonal esquerda cima
				i = x - 1;
				j = y - 1;
				while(i >= 0 && j >= 0){
					try{
						novos.add(this.movimento(x, y, i, j));
					} catch (Exception e) {}
					if(this.getDama(i, j) != NOPECA){
						break;
					}
					i--;
					j--;
				}
				
				
			}
		}
		return novos;
	}
	
	/**
	 * Retorna o novo estado de um movimento, se for valido
	 * @param x
	 * @param y
	 * @param xNovo
	 * @param yNovo
	 * @return
	 * @throws Exception 
	 */
	public EstadoDamas movimento(int x, int y, int xNovo, int yNovo) throws Exception{
		// verifica para mover somente suas pecas
		if(!this.isPermitido(x, y)){
			throw new Exception("Jogada invalida, peca de outro jogador");
		}
		// verifica limites do tabuleiro
		if((xNovo < 0 || xNovo > LENGTH_X-1) || (yNovo < 0 || yNovo > LENGTH_Y-1)){
			throw new Exception("Jogada invalida, atingiu o limite do tabuleiro");
		}
                // verifica se a jogada eh relativa a peca que comeu anteriormente
                if(this.getComeu()[0] != -1){
                    if(x != this.getComeu()[0] || y != this.getComeu()[1])
                        throw new Exception("Jogada invalida, so e possivel");
                }
		// se for peca normal, verifica movimentos permitidos
		if(this.getDama(x, y) == PECA_1 || this.getDama(x, y) == PECA_2){
			if(this.getDama(x, y) == PECA_1 && !((x == xNovo+1 && y == yNovo-1) || (x == xNovo-1 && y == yNovo-1))){
				throw new Exception("Jogada invalida, movimento invalido"); // peca 1 so anda pra cima nas diagonais
			}else if(this.getDama(x, y) == PECA_2 && !((x == xNovo+1 && y == yNovo+1) || (x == xNovo-1 && y == yNovo+1))){
				throw new Exception("Jogada invalida, movimento invalido"); // peca 2 so anda pra baixo nas diagonais
			}
		// verifica movimento da dama permite somente na diagonal
		}else if((this.getDama(x, y) == DAMA_1 || this.getDama(x, y) == DAMA_2) && 
			!((x - y == xNovo - yNovo && (x != xNovo && y != yNovo)) || (x + y == xNovo + yNovo && (x != xNovo && y != yNovo)))){
			throw new Exception("Jogada invalida, movimento invalido dama");
		}
		// verifica se possui pecas no caminho
		if((this.getDama(x, y) == DAMA_1 || this.getDama(x, y) == DAMA_2)){
			int i = x, j = y;
			while(true){
				if(x > xNovo){ // esquerda
					i--;
				}else if(x < xNovo){ // direita
					i++;
				}
				if (y > yNovo){ // cima
					j--;
				}else if(y < yNovo){ // baixo
					j++;
				}
				if(i == xNovo){
					break;
				}
				if(this.getDama(i, j) != NOPECA){
					throw new Exception("Jogada invalida, movimento invalido dama");
				}
			}
		}
		// verifica se pode comer peca
		int yAntigo = -1, xAntigo = -1;
		if(this.getJogador() == JOGADOR_1 && (this.getDama(xNovo, yNovo) == PECA_2 || this.getDama(xNovo, yNovo) == DAMA_2)){
			yAntigo = yNovo;
			if (y > yNovo){ // cima
				yNovo--;
			}else{ // baixo
				yNovo++;
			}
		}else if(this.getJogador() == JOGADOR_2 && (this.getDama(xNovo, yNovo) == PECA_1 || this.getDama(xNovo, yNovo) == DAMA_1)){
			yAntigo = yNovo;
			if (y > yNovo){ // cima
				yNovo--;
			}else{ // baixo
				yNovo++;
			}
		// verifica se eh peca do mesmo jogador
		}else if(this.getDama(xNovo, yNovo) != NOPECA){
			throw new Exception("Jogada invalida, peca do mesmo jogador");
		}
		if(yAntigo >= 0){
			xAntigo = xNovo;
			if(x > xNovo){ // esquerda
				xNovo--;
			}else if(x < xNovo){ // direita
				xNovo++;
			}
			// verifica limites do tabuleiro da segunda jogada
			if((xNovo < 0 || xNovo > LENGTH_X-1) || (yNovo < 0 || yNovo > LENGTH_Y-1)){
				throw new Exception("Jogada invalida, atingiu o limite do tabuleiro");
			}
			// verifica existe peca depois da peca comida
			if(this.getDama(xNovo, yNovo) != NOPECA){
				throw new Exception("Jogada invalida, mais de uma peca consecutiva");
			}
//                        System.out.println("Comeu Peca");
                        
		}
		// transforma peca em damas
		int peca = this.getDama(x, y);
		if(peca == PECA_1 && yNovo == LENGTH_Y-1){
			peca = DAMA_1;
		}else if(peca == PECA_2 && yNovo == 0){
			peca = DAMA_2;
		}
		// se nao comer pecas, obriga comer peca quando possivel
		if(yAntigo < 0){
			if(this.hasPecaComer()){
				throw new Exception("Jogada invalida, tem peca para tomar");
			}
		}
		
		EstadoDamas novoEstado = new EstadoDamas();
		if(this.getJogador() == JOGADOR_1){
			novoEstado.setJogador(JOGADOR_2);
		}else{
			novoEstado.setJogador(JOGADOR_1);
		}
		int[][] damas = new int[LENGTH_X][LENGTH_Y];
		for(int i = 0; i < damas.length; i++){
			for(int j = 0; j < damas[i].length; j++){
				damas[i][j] = this.estado[i][j];
			}
		}
		novoEstado.setDamas(damas);
		novoEstado.setDama(xNovo, yNovo, peca);
		novoEstado.setDama(x, y, NOPECA);
                
		if(yAntigo >= 0){
			novoEstado.setDama(xAntigo, yAntigo, NOPECA);
                        int[] temp = new int[2];
                        temp[0] = xNovo;
                        temp[1] = yNovo;
                        Tabuleiro.comeu = temp;
		}
		return novoEstado;
	}
	
        /**
	 * Conta numero de pecas que o jogador possui
	 * @param jogador
	 * @param estado
	 * @return
	 */
        public int contaPecas(int jogador, int[][] estado){
            int total = 0;
            for (int[] linha : estado){
                for (int peca : linha){
                    //Verifica se tem uma peca ou uma dama correspondente
                    //ao jogador indicado na posicao atual
                    if (peca == jogador || peca == jogador * 11){
                        total ++;
                    }
                }
            }
            return total;
        }
        
	/**
	 * Verifica para jogador mover somente pecas dele mesmo
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isPermitido(int x, int y){
		if(this.getJogador() == JOGADOR_1 && (this.getDama(x, y) == PECA_1 || this.getDama(x, y) == DAMA_1)){
			return true;
		}else if(this.getJogador() == JOGADOR_2 && (this.getDama(x, y) == PECA_2 || this.getDama(x, y) == DAMA_2)){
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica se tem pegas pra comer
	 * @return
	 */
	public boolean hasPecaComer(){
		int[][] damas = this.getDamas();
		int i, j;
		for(i = 0; i < damas.length; i++){
			for(j = 0; j < damas[i].length; j++){
				if(this.isPermitido(i, j)){
					if(this.getDama(i, j) == PECA_1 || this.getDama(i, j) == DAMA_1){
						try{
							// pra baixo esquerda, tem peca do adversario, e nao tem proxima peca
							if((this.getDama(i-1, j+1) == PECA_2 || this.getDama(i-1, j+1) == DAMA_2) && this.getDama(i-2, j+2) == NOPECA){
								return true;
							}
						}catch(Exception exc){}
						try{
							// pra baixo direita, tem peca do adversario, e nao tem proxima peca
							if((this.getDama(i+1, j+1) == PECA_2 || this.getDama(i+1, j+1) == DAMA_2) && this.getDama(i+2, j+2) == NOPECA){
								return true;
							}
						}catch(Exception exc){}
						if(this.getDama(i, j) == DAMA_1){
							try{
								// pra cima esquerda, tem peca do adversario, e nao tem proxima peca
								if((this.getDama(i-1, j-1) == PECA_2 || this.getDama(i-1, j-1) == DAMA_2) && this.getDama(i-2, j-2) == NOPECA){
									return true;
								}
							}catch(Exception exc){}
							try{
								// pra cima direita, tem peca do adversario, e nao tem proxima peca
								if((this.getDama(i+1, j-1) == PECA_2 || this.getDama(i+1, j-1) == DAMA_2) && this.getDama(i+2, j-2) == NOPECA){
									return true;
								}
							}catch(Exception exc){}
						}
					}else if(this.getDama(i, j) == PECA_2 || this.getDama(i, j) == DAMA_2){
						try{
							// pra cima esquerda, tem peca do adversario, e nao tem proxima peca
							if((this.getDama(i-1, j-1) == PECA_1 || this.getDama(i-1, j-1) == DAMA_1) && this.getDama(i-2, j-2) == NOPECA){
								return true;
							}
						}catch(Exception exc){}
						try{
							// pra cima direita, tem peca do adversario, e nao tem proxima peca
							if((this.getDama(i+1, j-1) == PECA_1 || this.getDama(i+1, j-1) == DAMA_1) && this.getDama(i+2, j-2) == NOPECA){
								return true;
							}
						}catch(Exception exc){}
						if(this.getDama(i, j) == DAMA_2){
							try{
								// pra baixo esquerda, tem peca do adversario, e nao tem proxima peca
								if((this.getDama(i-1, j+1) == PECA_1 || this.getDama(i-1, j+1) == DAMA_1) && this.getDama(i-2, j+2) == NOPECA){
									return true;
								}
							}catch(Exception exc){}
							try{
								// pra baixo direita, tem peca do adversario, e nao tem proxima peca
								if((this.getDama(i+1, j+1) == PECA_1 || this.getDama(i+1, j+1) == DAMA_1) && this.getDama(i+2, j+2) == NOPECA){
									return true;
								}
							}catch(Exception exc){}
						}
					}
				}
			} 
		}
		return false;
	}
        public boolean hasPecaComer(int[] pos){
            int i = pos[0], j = pos[1];
            System.out.println("perimtdio" + i + " " + j + " " + this.isPermitido(i, j));
                if(this.getDama(i, j) == PECA_1 || this.getDama(i, j) == DAMA_1){
                    try{
                        // pra baixo esquerda, tem peca do adversario, e nao tem proxima peca
                        if((this.getDama(i-1, j+1) == PECA_2 || this.getDama(i-1, j+1) == DAMA_2) && this.getDama(i-2, j+2) == NOPECA){
                                return true;
                        }
                    }catch(Exception exc){
                        System.out.println("lol");}
                    try{
                        // pra baixo direita, tem peca do adversario, e nao tem proxima peca
                        if((this.getDama(i+1, j+1) == PECA_2 || this.getDama(i+1, j+1) == DAMA_2) && this.getDama(i+2, j+2) == NOPECA){
                                return true;
                        }
                    }catch(Exception exc){}
                    if(this.getDama(i, j) == DAMA_1){
                        try{
                            // pra cima esquerda, tem peca do adversario, e nao tem proxima peca
                            if((this.getDama(i-1, j-1) == PECA_2 || this.getDama(i-1, j-1) == DAMA_2) && this.getDama(i-2, j-2) == NOPECA){
                                    return true;
                            }
                        }catch(Exception exc){System.out.println("lol1");}
                        try{
                            // pra cima direita, tem peca do adversario, e nao tem proxima peca
                            if((this.getDama(i+1, j-1) == PECA_2 || this.getDama(i+1, j-1) == DAMA_2) && this.getDama(i+2, j-2) == NOPECA){
                                    return true;
                            }
                        }catch(Exception exc){System.out.println("lol2");}
                    }
                }else if(this.getDama(i, j) == PECA_2 || this.getDama(i, j) == DAMA_2){
                    try{
                            // pra cima esquerda, tem peca do adversario, e nao tem proxima peca
                            if((this.getDama(i-1, j-1) == PECA_1 || this.getDama(i-1, j-1) == DAMA_1) && this.getDama(i-2, j-2) == NOPECA){
                                    return true;
                            }
                    }catch(Exception exc){System.out.println("lol3");}
                    try{
                            // pra cima direita, tem peca do adversario, e nao tem proxima peca
                            if((this.getDama(i+1, j-1) == PECA_1 || this.getDama(i+1, j-1) == DAMA_1) && this.getDama(i+2, j-2) == NOPECA){
                                    return true;
                            }
                    }catch(Exception exc){System.out.println("lol4");}
                    if(this.getDama(i, j) == DAMA_2){
                        try{
                            // pra baixo esquerda, tem peca do adversario, e nao tem proxima peca
                            if((this.getDama(i-1, j+1) == PECA_1 || this.getDama(i-1, j+1) == DAMA_1) && this.getDama(i-2, j+2) == NOPECA){
                                    return true;
                            }
                        }catch(Exception exc){System.out.println("lol5");}
                        try{
                            // pra baixo direita, tem peca do adversario, e nao tem proxima peca
                            if((this.getDama(i+1, j+1) == PECA_1 || this.getDama(i+1, j+1) == DAMA_1) && this.getDama(i+2, j+2) == NOPECA){
                                    return true;
                            }
                        }catch(Exception exc){System.out.println("lol6");}
                    }
                
            }
            return false;
	}

	public int[] calculaNumVantagem(){
		int numPecasJogador1 = 0, numPecasJogador2 = 0, numDamasJogador1 = 0, numDamasJogador2 = 0, numVantagemPecas, numVantagemDamas;
		for(int i = 0; i < this.estado.length; i++){
			for(int j = 0; j < this.estado[i].length; j++){
				if(this.estado[i][j] == PECA_1){
					numPecasJogador1++;
				}else if(this.estado[i][j] == DAMA_1){
					numDamasJogador1++;
				}else if(this.estado[i][j] == PECA_2){
					numPecasJogador2++;
				}else if(this.estado[i][j] == DAMA_2){
					numDamasJogador2++;
				}
			}
		}
		if(this.getJogador() == JOGADOR_1){
			numVantagemPecas = numPecasJogador1 - numPecasJogador2;
			numVantagemDamas = numDamasJogador1 - numDamasJogador2;
		}else{
			numVantagemPecas = numPecasJogador2 - numPecasJogador1;
			numVantagemDamas = numDamasJogador2 - numDamasJogador1;
		}
		return new int[]{numVantagemPecas, numVantagemDamas};
	}
	
	public int calculaMobilidade(){
		int res = 0;
		ArrayList<EstadoDamas> temp;
		int[][] damas = this.getDamas();
		int i, j;
		for(i = 0; i < damas.length; i++){
			for(j = 0; j < damas[i].length; j++){
				temp = this.novosMovimento(i, j);
				for (EstadoDamas tempEstado : temp) {
					if(tempEstado != null){
						if(!tempEstado.hasPecaComer()){
							res++;
						}
					}
				}
			}
		}
		return res;
	}
	
	public void mostra(){
        int i, j;
        for(i = 0 ; i < estado.length ; i++){
            for(j = 0 ; j < estado[i].length ; j++){
            	System.out.print(estado[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

	public int getJogador() {
		return jogador;
	}

	public void setJogador(int jogador) {
		this.jogador = jogador;
	}
	
	public int getDama(int x, int y) {
		return estado[y][x];
	}

	public void setDama(int x, int y, int v){
		this.estado[y][x] = v;
	}
	
	public int[][] getDamas() {
		return estado;
	}

	public void setDamas(int[][] estado) {
		this.estado = estado;
	}
        
        public int[] getComeu() {
		return comeu;
	}

	public void setComeu(int[] comeu) {
		this.comeu = comeu;
	}
	
	public boolean equals(Estado outroEstado) {
		// TODO Auto-generated method stub
		return false;
	}

}
