
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.core.AID;

public class Prisoner extends Agent {

        protected void setup() {
            // Printout a welcome message
            System.out.println("Hello! Friend-agent "+getAID().getName()+" is ready");
            this.addBehaviour(new PrisonerBehaviour(this));
        }

        protected void takeDown() {
            // Printout a dismissal message
            System.out.println("Friend-agent "+getAID().getName()+" terminating.");
        }

    }
