import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		// Passo 1: Criar o objeto socket que é responsável por manter o dado
		DatagramSocket ds = new DatagramSocket();
		
		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;
		
		while (true)
		{
			String inp = sc.nextLine();
			
			// Converter a string input em um array byte
			buf = inp.getBytes();
			
			// Passo 2: Criar o datagramPacket responsável por enviar o dado.
			DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);
			
			// Passo 3: Enviar o dado
			ds.send(DpSend);
			
			if (inp.equals("bye"))
				break;
		}
		
	}

}
