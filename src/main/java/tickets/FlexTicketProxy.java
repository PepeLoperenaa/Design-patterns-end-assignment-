package tickets;

public class FlexTicketProxy extends FlexImpl{

    @Override
    public void doSomething()
    {
        System.out.println("working");
        super.doSomething();
    }

}
