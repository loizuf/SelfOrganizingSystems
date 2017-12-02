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

				ACLMessage msg = myAgent.receive();
				if (msg != null) {
					System.out.println(msg);
					int decision = handleMessage(msg.getContent());
					sendMessage(decision);

				} else {
					block();
				} 
			}

			private String handleMessage(String content){
				switch(content){
					case "end":
						doDelete();
						return -1;
						break;

					case "quiet":
						return 0;
						break;

					case "talk":
						return 1;
						break;

					default:
						print(content)
						return -1;
				}
			}

			private void sendMessage(int decision){
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.addReceiver(new AID("A", AID.ISLOCALNAME));
				msg.setLanguage("English");
				msg.setOntology("Decision");
				if(decision == 0){
					msg.setContent("quiet");
				} else {
					if(decision<0) System.out.println("something might have gone wrong here");
					msg.setContent("talk");
				}
				send(msg);
			}
		});
	}

	protected void takeDown() {
		// Printout a dismissal message
		System.out.println("Friend-agent "+getAID().getName()+" terminating.");
	}

}
