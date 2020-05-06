Universidade de Caxias do Sul - Centro de Computação e Tecnologia da Informação 

Inteligência artificial

O Jogo de damas, regras e definições para o projeto minimax

Nas definições abaixo a observação "para o projeto" refere-se a simplificações do jogo aceitas para a implementação deste trabalho.
Não é necessário implementar as regras em toda sua flexibilidade, mas implementações mais completas terão um "bônus".

No Brasil e em Portugal é mais conhecido a versão de 64 casas (8 por 8), mas a versão mais conhecida mundialmente é a que usa um tabuleiro de 100 casas (10 por 10).

Para o projeto: estaremos utilizando a versão com tabuleiro 8 x 8 !

O jogo de damas é praticado entre dois parceiros, com 12 pedras brancas de um lado e com 12 pedras pretas de outro lado.

Movimentos:
O lance inicial cabe sempre a quem estiver com as peças brancas. 
As pedras andam somente para a frente, na diagonal, uma casa de cada vez. 
Quando a pedra atinge a oitava linha do tabuleiro (e permanece lá) ela é promovida à dama. Se a peça apenas passa pela casa final, sem permanecer nela, não é promovida.
A dama é uma peça de movimentos mais amplos. Ela anda para frente e para trás, quantas casas quiser. 
A dama, como qualquer outra peça, não pode saltar uma peça da mesma cor.
Para o projeto: a dama move-se em qualquer direção, mas somente uma casa, e pode tomar peças tanto movendo-se para a frente quanto para trás


Captura:
A captura é obrigatória. 
Se houver mais de uma possibilidade de captura deve-se escolher a que captura mais peças. 
Para o projeto: quando há mais de uma possibilidade de captura, pode-se escolher qualquer uma das possibilidades 
A pedra e a dama podem capturar tanto para frente como para trás, uma ou mais peças
Para o projeto: pedras comuns podem capturar somente para a frente (nunca para trás) e pode-se implementar somente a captura simples (e não múltipla)
Na execução do lance de captura múltipla (se implementado), é permitido passar mais de uma vez pela mesma casa vazia, não é permitido capturar duas vezes a mesma peça.
Vitória:
Um jogador vence se toma todas as peças do oponente ou se o oponente ficar bloqueado (sem possibilidades de movimento)
Empate:
Após 20 lances sucessivos de damas, sem captura ou deslocamento de pedra, a partida é declarada empatada.
ou, os jogadores concordarem com o empate
Para o projeto: pode-se implementar apenas uma opção para o jogador humano declarar o empate.


