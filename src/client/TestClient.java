/**
 *
 */
package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author ryokakomi
 *
 */
public class TestClient {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 10000);
			Scanner scanner = new Scanner(System.in);
			PrintWriter pWriter = new PrintWriter(socket.getOutputStream(),true);
			String string = null;

			do {
				string = scanner.nextLine();
				pWriter.println(string);
				pWriter.flush();
			}while(string != "end" || string != "END");

			pWriter.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(socket != null) {
					System.out.println("Socket closed");
					socket.close();
				}else {
					System.out.println("Socket is null");
				}

			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}


	}

}
