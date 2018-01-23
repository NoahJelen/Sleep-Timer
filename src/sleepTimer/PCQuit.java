package sleepTimer;

import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

public class PCQuit{
	@SuppressWarnings("deprecation")
	public static void run() {
		Date today= new Date();
		long[] options=ConfigLoad.readJson("resources/config.json");
		String quitHr=Long.toString(options[0]);
		String quitMin=Long.toString(options[1]);
		
		boolean sawWarning=false;
		
		if (options[0]<10)
			quitHr="0"+quitHr;
		
		if (options[1]<10)
			quitMin="0"+quitMin;
		while (true) {
			if (today.getMinutes()==options[3]&&today.getHours()==options[2]&&!sawWarning) {
				JOptionPane.showMessageDialog(null,"You need to go to bed!\nThis machine will automatically shut down at "+quitHr+":"+quitMin,"Bed Time!",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
				sawWarning=true;
			}
			if (today.getMinutes()==options[1]&&today.getMinutes()==options[0]) {
				try {
					shutDown.shutdown();
				}
				catch (RuntimeException|IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
}