package ng.nokiaBSC.application;

import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ng.nokiaBSC.application.service.interfaceService.BscService;

@SpringBootApplication
public class ProjectBscNokia1Application implements CommandLineRunner {
	@Autowired
	private BscService bsc;

	public static void main(String[] args) {
		SpringApplication.run(ProjectBscNokia1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		bsc.telnet("IpAdressOfBSC", "userNameOfBsc", "passwordOfBsc");
		bsc.sendCommand("ZEEI:BCF=70;");
		bsc.sendCommand("ZEEI:;");
		bsc.disconnect();
		PrintStream standard;
		standard=System.out;
		  System.setOut(standard);
		System.out.println("fin de la partie");
		
		
	}
	

}
