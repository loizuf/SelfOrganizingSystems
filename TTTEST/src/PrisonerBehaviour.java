import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class PrisonerBehaviour extends CyclicBehaviour{

    private Prisoner agent;

    public PrisonerBehaviour(Prisoner a) {
        super(a);
        this.agent = a;
    }

    @Override
    public void action(){
        ACLMessage msg = agent.blockingReceive();
        int decision = handleMessage(msg.getContent());
        sendMessage(decision);
    }

    private int handleMessage(String content){
        System.out.println(agent.getAID() + " has received: " + content);
        switch(content){
            case "end":
                agent.doDelete();
                return -1;

            case "quiet":
                return 0;

            case "talk":
                return 1;

            case "start":
                return -1;

            default:
                System.out.println(content);
                return -1;
        }
    }

    private void sendMessage(int decision){
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("game", AID.ISLOCALNAME));
        msg.setLanguage("English");
        msg.setOntology("Decision");
        if(decision == 0){
            msg.setContent("quiet");
        } else {
            msg.setContent("talk");
        }
        agent.send(msg);
    }


}
