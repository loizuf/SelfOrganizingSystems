import jade.core.Agent;
import jade.wrapper.ContainerController;
import jade.core.ProfileImpl;
import jade.lang.acl.ACLMessage;
import jade.core.Runtime;
import jade.wrapper.AgentController;

public class Game extends Agent {
	
	private ContainerController container = Runtime.instance().createAgentContainer(new ProfileImpl());

	@Override
	protected void setup() {
		this.addBehaviour(new OneShotBehaviour(){
			
			@Override
			public void action() {
				for 
				System.out.println("Test");
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.addReceiver(new AID("Peter", AID.ISLOCALNAME));
				msg.setLanguage("English");
				msg.setOntology("Weather-forecast-ontology");
				msg.setContent("Today it’s raining");
				send(msg);

			}
		});

	}
}