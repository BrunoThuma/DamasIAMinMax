import javax.swing.JOptionPane;


public class Main
{
    public static void main(String[] args)
    {
        
        String[] jogadores = {"Humano","Ia"};
    	// Damas
    	int nivel= Integer.parseInt(JOptionPane.showInputDialog("Quantos niveis serao utilizados?"));
        int primJogador = JOptionPane.showOptionDialog(null, "Quem jogara primeiro?",
                "Escolher jogador",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, jogadores, jogadores[0]);
    	EstadoDamas e = new EstadoDamas();
    	e.estadoInicial();
        Tabuleiro tab = new Tabuleiro(e.getDamas(), e, nivel, primJogador);
        tab.setVisible(true);
    }
}
