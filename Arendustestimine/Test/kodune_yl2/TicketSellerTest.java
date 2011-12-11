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

    @Test
    public void buyTicketWithSms() throws Exception {
        Controller controller = new Controller();
        controller.addModule("smsIn", smsIn);
        controller.addModule("ticket", ticket);
        controller.addModule("bill", bill);
        controller.addModule("smsOut", smsOut);

        doAnswer(sendMessage(controller, "sms:buy")).when(smsIn).message("buy");
        doAnswer(sendMessage(controller, "sms:bought")).when(ticket).message("sms:buy");
        doAnswer(sendMessage(controller, "sms:billed")).when(bill).message("sms:bill");

        smsIn.message("buy");

        verify(smsOut).message("sendSms");
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
