import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class GameBehaviour extends OneShotBehaviour {

    private Game agent;

    public GameBehaviour(Game a) {
        super(a);
        this.agent = a;
    }

    @Override
    public void action() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        ACLMessage msg1 = new ACLMessage(), msg2 = new ACLMessage();
        msg.addReceiver(new AID("a", AID.ISLOCALNAME));
        msg.addReceiver(new AID("b", AID.ISLOCALNAME));
        msg.setLanguage("English");
        msg.setOntology("Start");
        msg.setContent("start");
        agent.send(msg);
        for (int i = 0; i < agent.rounds; i++) {
            msg1 = agent.blockingReceive();
            msg2 = agent.blockingReceive();
            AID agent1 = msg1.getSender();
            AID agent2 = msg1.getSender();
            msg1.clearAllReceiver();
            msg1.addReceiver(agent2);
            agent.send(msg1);
            msg2.clearAllReceiver();
            msg2.addReceiver(agent1);
            agent.send(msg2);
        }

        msg1.clearAllReceiver();
        msg1.addReceiver(new AID("a", AID.ISLOCALNAME));
        msg1.setContent("end");
        agent.send(msg1);
        msg2.clearAllReceiver();
        msg2.addReceiver(new AID("b", AID.ISLOCALNAME));
        msg2.setContent("end");
        agent.send(msg2);
    }
}