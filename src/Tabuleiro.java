import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class Tabuleiro extends Frame {
    
	public int qtdClick = 0;
	public BotaoTab btAnt;
	public int jogador = 1;
	public EstadoDamas damas;
	public Panel tab;
	public int nivel = 3;
        public static int[] comeu = new int[] {-1, -1};
	
    private int primJogador;
    private int xOld;
    private int yOld;
	
    public int linhas = 10;
    public int colunas = 10;
    
    boolean tipo = true;
	
	public BufferedImage imgBrancas;
	public BufferedImage imgPretas;
	public BufferedImage imgPretaDamas;
	public BufferedImage imgBrancaDamas;
	public BufferedImage imgFundoBranca;
	public BufferedImage imgFundoPreta;
	
	public class BotaoTab extends JButton implements MouseListener {  
	    
	    JButton bt = new JButton();
	    
	    private int x;
	    private int y;
	    private int corFundo;
	    
	    private int peca;
	    
	    //usa o construtor da classe super (JButton), e adiciona o mouselistener ao objeto  
	    BotaoTab(ImageIcon img, int x, int y, int peca, int corFundo)  
	    {  
	        this.setIcon(img);
	        this.x = x;
	        this.y = y;
	        this.peca = peca;
	        this.corFundo = corFundo;
	        
	        this.setBackground(Color.WHITE);
	        this.setBorder(new LineBorder(Color.WHITE, 0));
	        
	        this.setFocusPainted(false);
                
	        
	        addMouseListener(this);  
	    }
                
		@Override
		public void mouseClicked(MouseEvent arg0) {
                    // TODO Auto-generated method stub
                    
                    // Primeiro clique, devo aguardar o proximo
                    if (qtdClick == 0){

                        this.setBorder(new LineBorder(Color.YELLOW, 6));
                        this.setContentAreaFilled(false);

                        qtdClick++;
                        btAnt = this;

                        xOld = x;
                        yOld = y;

                    }else{
                        try {
                            //Salva numa variavel o jogador correspondente a IA
                            int jIA = damas.getJogador() == 1 ? 2 : 1;
                            
                            //Recupera o numero atual de pecas da jIA
                            int qntAntes = damas.contaPecas(jIA, damas.getDamas());
                            
                            damas = damas.movimento(yOld, xOld, y, x);
                            
                            int[] temp = new int[2];
                            temp = damas.comeu;
                           
                            System.out.println("tetetetey temp" + temp[0] + "" + temp[1]);
                            //Verifica se jogador Humano comeu uma peca
                            if (damas.contaPecas(jIA, damas.getDamas()) < qntAntes && damas.hasPecaComer(comeu)){
//                                System.out.println("comeu peça" + temp[0] + "" + temp[1]);
                                for(int i=0; i < damas.getDamas()[0].length; i++) {
                                    System.out.println("");
                                    for (int j = 0; j < damas.getDamas()[0].length; j++) {
                                        System.out.print(damas.getDama(j, i));
                                    }
                                }
                                
                                //Coloca jogador da proximo jagada como humano
                                damas.setJogador(damas.getJogador() == 1 ? 2 : 1);
//                                  damas.setJogador(1);
                            }
                            else {
                                //Coloca jogador da proximo jagada como ia
                                damas = jogadaCPU(damas);
                                Tabuleiro.comeu[0] = -1;
                                Tabuleiro.comeu[1] = -1;
                            }
                            
                        } catch (Exception ex) {
                                JOptionPane.showMessageDialog(this, "Erro: "+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }

                        if (btAnt.corFundo == 0)
                                btAnt.setBorder(new LineBorder(Color.WHITE, 0));
                        else if (btAnt.corFundo == 1)
                                btAnt.setBorder(new LineBorder(new Color(205,201,201) ));

                        tab.removeAll();

                        atualizaTab(damas.getDamas(), tab);

                        tab.repaint();

                        qtdClick = 0;
                    }
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}  
	}
        
        public EstadoDamas jogadaCPU(EstadoDamas damas){
            int humano = damas.getJogador() == 1 ? 2 : 1;

            int qntAntes = damas.contaPecas(humano, damas.getDamas());

            Problema p = new ProblemaDamas();
            p.setNodoInicial(damas);
            ResolvedorDeProblemas r = new ResolvedorDeProblemas();
            r.MINIMAX_NIVEL = nivel;
            Nodo nodo = r.maxInicial(p);
            if(nodo == null){
                JOptionPane.showMessageDialog(this, "Voce ganhou", "Fim de jogo", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            damas = (EstadoDamas) nodo.getEstado();

            Lista l = p.gerarFilhos(nodo);
            if(l.vazia()){
                JOptionPane.showMessageDialog(this, "Voce perdeu", "Fim de jogo", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
                
            //Verifica se jogador Humano perdeu uma peca
            if (damas.contaPecas(humano, damas.getDamas()) < qntAntes && damas.hasPecaComer(comeu)){
                damas.setJogador(damas.getJogador() == 1 ? 2 : 1);
                damas = jogadaCPU(damas);
            } else {
                Tabuleiro.comeu[0] = -1;
                Tabuleiro.comeu[1] = -1;
            }
            return damas;
        }
	
	public void atualizaTab(int[][] mat, Panel p){
        
            JButton bt = null;
            // Faz o mapa preto e branco
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
            	
                    if (tipo){
                            bt = new BotaoTab(new ImageIcon(imgFundoPreta), i, j, mat[i][j], 1);
                    }else{

                        if (mat[i][j] == 0)
                            bt = new BotaoTab(new ImageIcon(imgFundoBranca), i, j, mat[i][j],0);
                        if (mat[i][j] == 1)
                            bt = new BotaoTab(new ImageIcon(imgBrancas), i, j, mat[i][j], 0);
                        if (mat[i][j] == 2)
                            bt = new BotaoTab(new ImageIcon(imgPretas), i, j, mat[i][j], 0);
                        if (mat[i][j] == 11)
                            bt = new BotaoTab(new ImageIcon(imgBrancaDamas), i, j, mat[i][j], 0);
                        if (mat[i][j] == 22)
                            bt = new BotaoTab(new ImageIcon(imgPretaDamas), i, j, mat[i][j], 0);
                    }
            	
                    p.add(bt);
                    tipo = !tipo;
                }
                tipo = !tipo;
            }
	}
	
    public Tabuleiro(int[][] matriz, EstadoDamas d, int nivel, int primJogador) {
    	
    	this.setTitle("Jogo de Damas");
        this.setSize(750, 750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.damas = d;
        this.nivel = nivel;
        this.primJogador = primJogador;
        
        Panel painel = new Panel(new GridLayout(linhas, colunas));
//        painel.setPreferredSize(new Dimension(600, 600));
        
        tab = painel;
        
        try {
            imgBrancas = ImageIO.read(getClass().getResourceAsStream("img/branca.jpg"));
        	} catch (IOException e) {
        }
        
        try {
            imgPretas = ImageIO.read(getClass().getResourceAsStream("img/preta.jpg"));
        	} catch (IOException e) {
        }
        
        try {
            imgPretaDamas = ImageIO.read(getClass().getResourceAsStream("img/preta_dama.jpg"));
        	} catch (IOException e) {
        }
        
        try {
            imgBrancaDamas = ImageIO.read(getClass().getResourceAsStream("img/branca_dama.jpg"));
        	} catch (IOException e) {
        }
        
        try {
            imgFundoBranca = ImageIO.read(getClass().getResourceAsStream("img/fundo_branco.jpg"));
        	} catch (IOException e) {
        }

        try {
            imgFundoPreta = ImageIO.read(getClass().getResourceAsStream("img/fundo_escuro.jpg"));
        	} catch (IOException e) {
        }
       
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, painel);
        
        if(this.primJogador == 1){
            this.damas = jogadaCPU(d);
        }
        
        atualizaTab(this.damas.getDamas(), painel);
        
        WindowListener listener = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Object origem = e.getSource();
                if (origem == Tabuleiro.this) {
                    System.exit(0);
                }
            }
        };
        this.addWindowListener(listener);
        
    }
}