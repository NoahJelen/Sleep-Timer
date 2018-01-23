package sleepTimer;

public class Init {
	public static void main(String[] args) {
		try {
			if (args[0].equals("config")||args[0].equals("c")||args[0].equals("cfg")){
				CFGWindow.Config();
				return;
			}
		}
		catch (Exception e){}
		PCQuit.run();
	}
}