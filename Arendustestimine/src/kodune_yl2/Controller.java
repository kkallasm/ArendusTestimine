package kodune_yl2;

import java.util.HashMap;
import java.util.Map;

public class Controller implements Receiver {

    private Map<String, Receiver> modules = new HashMap<String, Receiver>();

    @Override
    public void message(String message) {
        System.out.println(message);

        String channel = getChannel(message);
        String client = getClient(message);
        String time = getTime(message);

        if (getCommand(message).equals("buy")) {
            Receiver ticketModule = getModule("ticket");
            ticketModule.message(channel + ":buy:"+client+":"+time);
        }
        if (getCommand(message).equals("bought")) {
            Receiver billModule = getModule("bill");
            billModule.message(channel + ":bill:"+client+":"+time);
        }
        if (getCommand(message).equals("billed")) {
            if (getChannel(message).equals("sms")) {
                Receiver smsModule = getModule("smsOut");
                smsModule.message("sendSms:"+client+":"+time);
            } else if (getChannel(message).equals("web")) {
                getModule("web").message("success");
            } else if (getChannel(message).equals("txt")) {
                getModule("txt").message("success");
            }
        }
    }
    
//    private String calculatePrice(String time) {
//	
//    	double price = Double.parseDouble(time) * 0.1;
//		return Double.toString(price);
//	}

    
    private String getChannel(String message) {
        return message.split(":")[0];
    }

    private String getCommand(String message) {
        return message.split(":")[1];
    }
    
    private String getClient(String message) {
        return message.split(":")[2];
    }
    
    private String getTime(String message) {
        return message.split(":")[3];
    }

    private Receiver getModule(String name) {
        return modules.get(name);
    }

    public void addModule(String name, Receiver module) {
        modules.put(name, module);
    }

}
