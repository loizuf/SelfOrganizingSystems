import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;


public class Game extends Agent{

    private ContainerController container = Runtime.instance().createAgentContainer(new ProfileImpl());
    public int rounds = 8;

    @Override
    protected void setup(){
        try {
            AgentController a = container.createNewAgent("a", "Prisoner", null);
            AgentController b = container.createNewAgent("b", "Prisoner", null);
            a.start();
            b.start();
            this.doWait(3000);
            this.addBehaviour(new GameBehaviour(this));
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}
