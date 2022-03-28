package tickets;
import interfaces.TicketInterface;

public class FlexImpl implements TicketInterface{

    @Override
    public void doSomething(){
        System.out.println("Working in real object");
    }
}
