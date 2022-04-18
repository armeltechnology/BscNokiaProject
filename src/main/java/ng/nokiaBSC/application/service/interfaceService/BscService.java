package ng.nokiaBSC.application.service.interfaceService;

public interface BscService {
	
	void telnet(String ipBSC,String username, String password);
	
	String sendCommand(String command);
	String sendCommandreset(  String command);
	void disconnect();

}
