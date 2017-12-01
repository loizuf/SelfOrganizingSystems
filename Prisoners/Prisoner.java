import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.core.AID;

public class Prisoner extends Agent {

	protected void setup() {
		// Printout a welcome message
		System.out.println("Hello! Friend-agent "+getAID().getName()+" is ready. Fuck");
		this.addBehaviour(new OneShotBehaviour(){
			
			@Override
			public void action() {
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

	protected void takeDown() {
		// Printout a dismissal message
		System.out.println("Friend-agent "+getAID().getName()+" terminating.");
	}

}
