import jade.core.Agent;

public class RoundBehaviour extends OneShotBehaviour{
	
	private Game game;

	@Override
	public RoundBehaviour(Game game){
		super(game);
		this.game = game;
	}
}