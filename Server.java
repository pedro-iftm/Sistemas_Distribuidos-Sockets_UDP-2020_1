import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
	
	public static void main(String[] args) throws IOException {
		
		
		// Passo 1: Criar um socket para ouvir na porta 1234
		DatagramSocket ds = new DatagramSocket(1234);
		byte[] receive = new byte[65534];
		
		DatagramPacket DpReceive = null;
		while (true) 
		{
			// Passo 2: Criar o DatagramPacket para receber o dado (do cliente)
			DpReceive = new DatagramPacket(receive, receive.length);
			
			// Passo 3: Receber o dado do buffer
			ds.receive(DpReceive);
			
			System.out.print("Cliente: -" + data(receive));
			
			if (data(receive).toString().equals("bye")) {
				System.out.println("Cliente enviou bye ... Exiting");
				break;
			}
			
			// Limpa o buffer a cada mensagem
			receive = new byte[65534];
		}
		
	}
	
	// Método utilitário para converter o array de bytes em uma representação de string
	public static StringBuilder data(byte[] a) 
	{
		if (a == null)
			return null;
		
		StringBuilder ret = new StringBuilder();
		int i = 0;
		while (a[i] != 0) {
			ret.append((char) a[i]);
			i++;
		}
		
		return ret;
	}	

}
