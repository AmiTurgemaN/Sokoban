package model.receiver;

public class ExitReceiver extends GeneralReceiver {

	private String exitString;
	
	public ExitReceiver(String exitString) {
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
	}

}
