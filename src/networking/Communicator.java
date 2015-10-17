package networking;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Communicator {
	public void sendFile(String filename, Socket socket) {
		File f = new File(filename);

		int count;
		byte[] buffer = new byte[1024];

		try {
			OutputStream out = socket.getOutputStream();
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
			while ((count = in.read(buffer)) >= 0) {
			     out.write(buffer, 0, count);
			     out.flush();
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void receiveFile(String filename, Socket socket) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			
			byte[] buffer = new byte[1024];
			int count;
			
			InputStream in = socket.getInputStream();
			while((count=in.read(buffer)) >= 0){
			    fos.write(buffer, 0, count);
			}
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
