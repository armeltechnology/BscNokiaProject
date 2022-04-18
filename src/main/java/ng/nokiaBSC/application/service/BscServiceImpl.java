package ng.nokiaBSC.application.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.stereotype.Service;

import lombok.Data;
import ng.nokiaBSC.application.service.interfaceService.BscService;
 @Service
 @Data
public class BscServiceImpl implements BscService {
	
	private  InputStream in;
	private static  PrintStream out;
	private  char prompt = '<';
	private  String f;
	private  String da;
	private String ex;
	private String fi;
	PrintStream printstream;
	
	private TelnetClient telnet;

	@Override
	public void telnet(String ipBSC, String username, String password) {
		
		directorytemplate(username);
		file(username);
		final  int portTel=23;
		telnet=new TelnetClient();
		try {
			telnet.connect(ipBSC, portTel);
			in =telnet.getInputStream();
			out=new PrintStream(telnet.getOutputStream());
			 readUntil(prompt+" ");
			 write( username );
			 readUntil(prompt+" ");
		      write( password );
		      readUntil(prompt+" ");
			
		} catch (Exception e) {
			disconnect();
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void disconnect() {
		
		try {
			telnet.disconnect();
			printstream.close();
			
			System.out.println("bon");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String sendCommand(String command) {
		try {   
			 
			  
			  
			   write( command );
			   readUntil( prompt+"");
				return readUntil( prompt+" ");
		   }
		 catch( Exception e ) {
			 
			   disconnect();
			  
		   }
		return "nothing has been send";
	}
	
	// internal function in BSC NOKIA
	
	public void write( String value ) {
		
		out.println(value);
		out.flush();
		
	}
	
	public String readUntil( String pattern ) {
		
		
		try {
			char lastChar=pattern.charAt(pattern.length() -1);
			StringBuffer sb=new StringBuffer();
			char ch=(char)in.read();
			while(true) {
				System.out.print(ch);
				sb.append(ch);
				if(ch== lastChar) {
					if(sb.toString().endsWith(pattern)) {
						return sb.toString();
					}
					
				}
				ch=(char)in.read();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			disconnect();
		}
		return"nothing in present ";
	}
	
	public String readUntilyes( String pattern ) {
		
		try {
			 char lastChar = pattern.charAt( pattern.length() - 1 );
			 StringBuffer sb = new StringBuffer();
			 char ch = ( char )in.read();
			 while( true ) {
			  System.out.print( ch );		
			  sb.append( ch );
			  if( ch == lastChar ) {
			    if( sb.toString().endsWith( pattern ) ) {
			    	
				 return sb.toString();
				 
			    }
			    
			  }
			  ch = ( char )in.read();
			  
			 }
			 
} catch (Exception e) {
			
			e.printStackTrace();
			
			disconnect();
		}
		return"nothing in present ";
			 
		 }

	@Override
	public String sendCommandreset(String command) {
		 try {   
						  
			   write( command );
			   readUntilyes("Y/N ?");
			   write("Y");
			   readUntil( prompt+"");
				return readUntil( prompt+" ");
		   }
		   catch( Exception e ) {
			   
			   disconnect();
			   
		   }
		   return "nothing has been send";
		  }
		 
	
	public String file(String username) {
		
		String nomlog=username+System.currentTimeMillis();
		
		File file;
		
		file=new File(getF(),nomlog+".txt");
		
		try {
		 printstream= new PrintStream(file);
			System.setOut(printstream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nomlog;
	}
	
	private void directorytemplate(String cheminrepertoire) {
		File repertoire = new File("\\v_nathan_ran\\Projet ran\\"+cheminrepertoire);
		boolean res= repertoire.mkdir();
		if(res) {
			
			/*
			 * try { copycontenu(new File("\\v_nathan_ran\\Projet ran\\"), repertoire); }
			 * catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
			
			System.out.println("this directory{} has been create");
		}else {
			System.out.println("this directory already exists");
		}
		File repertoireini = new File("\\v_nathan_ran\\Projet ran\\"+cheminrepertoire+"\\fichier_netact\\");
		File repertoire_csv = new File("\\v_nathan_ran\\Projet ran\\"+cheminrepertoire+"\\fichier_netact\\fichier_csv\\");
		setF(repertoire.getAbsolutePath()+"\\");
		setDa(repertoire.getAbsolutePath()+"\\ton_resultat\\");
		setEx(repertoireini.getAbsolutePath()+"\\");
		setFi(repertoire_csv.getAbsolutePath()+"\\");
	}
	
	public void copycontenu(File src, File dest) throws IOException {
	      if(src.isDirectory()){
	          //si le répertoire n'existe pas, créez-le
	            if(!dest.exists()){
	               dest.mkdir();
	               System.out.println("Dossier "+ src + "  > " + dest);
	            }
	            //lister le contenu du répertoire
	            String files[] = src.list();
	            
	            for (String f : files) {
	               //construire la structure des fichiers src et dest
	               File srcF = new File(src, f);
	               File destF = new File(dest, f);
	               //copie récursive
	               copycontenu(srcF, destF);
	            }
	          }else{
	              //si src est un fichier, copiez-le.
	              InputStream in = new FileInputStream(src);
	              OutputStream out = new FileOutputStream(dest); 
	                               
	              byte[] buffer = new byte[1024];
	              int length;
	              //copier le contenu du fichier
	              while ((length = in.read(buffer)) > 0){
	                out.write(buffer, 0, length);
	              }
	     
	              in.close();
	              out.close();
	              System.out.println("Fichier " + src + " > " + dest);
	          }
		
	}
	
}
