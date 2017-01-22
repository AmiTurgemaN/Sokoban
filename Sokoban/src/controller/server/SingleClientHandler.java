package controller.server;

import java.io.InputStream;
import java.io.OutputStream;

public class SingleClientHandler implements ClientHandler {

	private InputStream is;
	private OutputStream os;
	
	public SingleClientHandler(InputStream is, OutputStream os) {
		this.is = is;
		this.os = os;
	}

	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}

	public OutputStream getOs() {
		return os;
	}

	public void setOs(OutputStream os) {
		this.os = os;
	}

	@Override
	public void handleClinet(InputStream inFromClient, OutputStream outToClient) {
		
	}

}
