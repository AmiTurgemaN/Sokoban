package reciever;

public class ExitReciever extends GeneralReciever {

	private String exitString;
	
	public ExitReciever(String exitString) {
		this.exitString = exitString;
	}

	public String getExitString() {
		return exitString;
	}

	public void setExitString(String exitString) {
		this.exitString = exitString;
	}

	@Override
	public void action() {
		String dotsString = "......";
		System.out.print(exitString);
		for(int i=0;i<dotsString.length();i++)
		{
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(dotsString.charAt(0));
		}
		System.exit(0);
	}

}
