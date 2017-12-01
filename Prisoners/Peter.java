import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.core.AID;

public class Peter extends Agent {

	protected void setup() {
		// Printout a welcome message
		System.out.println("Hello! Friend-agent "+getAID().getName()+" is ready. Fuck");
		this.addBehaviour(new CyclicBehaviour(){
			
			@Override
			public void action() {
				System.out.println("Test");
				ACLMessage msg = myAgent.receive();
				 if (msg != null) {
					 System.out.println(msg);
					 System.out.println("Banana");
				 }
				 else {
				 	block();
				 } 


			}
		});
	}

	protected void takeDown() {
		// Printout a dismissal message
		System.out.println("Friend-agent "+getAID().getName()+" terminating.");
	}

}

