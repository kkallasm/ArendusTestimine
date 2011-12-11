package kodune_yl2;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class TicketSellerTest {

    private Receiver smsIn = mock(Receiver.class);
    private Receiver ticket = mock(Receiver.class);
    private Receiver bill = mock(Receiver.class);
    private Receiver smsOut = mock(Receiver.class);
    private Receiver web = mock(Receiver.class);
    private Receiver txt = mock(Receiver.class);

    @Test
    public void buyTicketWithSms() throws Exception {
        Controller controller = new Controller();
        controller.addModule("smsIn", smsIn);
        controller.addModule("ticket", ticket);
        controller.addModule("bill", bill);
        controller.addModule("smsOut", smsOut);
        
        Client c = new Client();
        c.setSimNumber("+3725543456");

        doAnswer(sendMessage(controller, "sms:buy:"+c.getSimNumber()+":2")).when(smsIn).message("buy:"+c.getSimNumber()+":2");
        doAnswer(sendMessage(controller, "sms:bought:"+c.getSimNumber()+":2")).when(ticket).message("sms:buy:"+c.getSimNumber()+":2");
        doAnswer(sendMessage(controller, "sms:billed:"+c.getSimNumber()+":2")).when(bill).message("sms:bill:"+c.getSimNumber()+":2");

        smsIn.message("buy:"+c.getSimNumber()+":2");

        verify(smsOut).message("sendSms:"+c.getSimNumber()+":2");
    }
    
    
    @Test
    public void buyTicketWithWeb() throws Exception {
        Controller controller = new Controller();
        controller.addModule("web", web);
        controller.addModule("ticket", ticket);
        controller.addModule("bill", bill);
        
        Client c = new Client();
        c.setUsername("KorogSuntiger");

        doAnswer(sendMessage(controller, "web:buy:"+c.getUsername()+":2")).when(web).message("buy:"+c.getUsername()+":2");
        doAnswer(sendMessage(controller, "web:bought:"+c.getUsername()+":2")).when(ticket).message("web:buy:"+c.getUsername()+":2");
        doAnswer(sendMessage(controller, "web:billed:"+c.getUsername()+":2")).when(bill).message("web:bill:"+c.getUsername()+":2");

        web.message("buy:"+c.getUsername()+":2");

        verify(web).message("success");
    }
    
    
    @Test
    public void buyTicketWithTxt() throws Exception {
        Controller controller = new Controller();
        controller.addModule("txt", txt);
        controller.addModule("ticket", ticket);
        controller.addModule("bill", bill);
        
        Client c = new Client();
        c.setUsername("KorogSuntiger");

        doAnswer(sendMessage(controller, "txt:buy:"+c.getUsername()+":2")).when(txt).message("buy:"+c.getUsername()+":2");
        doAnswer(sendMessage(controller, "txt:bought:"+c.getUsername()+":2")).when(ticket).message("txt:buy:"+c.getUsername()+":2");
        doAnswer(sendMessage(controller, "txt:billed:"+c.getUsername()+":2")).when(bill).message("txt:bill:"+c.getUsername()+":2");

        txt.message("buy:"+c.getUsername()+":2");

        verify(txt).message("success");
    }

    private Answer<Object> sendMessage(Controller c, String message) {
        return new SentMessageAction(c, message);
    }

    // Sellesse (SentMessageAction-isse) pole vaja süveneda. Sellise konstruktsiooniga
    // saab mock-ist tegevusi välja kutsuda.
    // Siin on seda selleks kasutatud, et kontrollerile sõnumeid tagasi saata.

    class SentMessageAction implements Answer<Object> {

        private String message;
        private Controller controller;

        public SentMessageAction(Controller controller, String message) {
            this.message = message;
            this.controller = controller;
        }

        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            controller.message(message);
            return null;
        }

    }

}
