package sleepTimer;

import java.io.FileWriter;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

public class CFGWindow {
	@SuppressWarnings({ "unchecked", "resource" })
	public static void Config() {
		System.out.println("You are running "+System.getProperty("os.name"));
		JTextField shdHour = new JTextField();
		JTextField shdMinute = new JTextField();
		JTextField rmdHour = new JTextField();
		JTextField rmdMinute = new JTextField();
		final JComponent[] inputs = new JComponent[] {
				new JLabel("Shut Down Hour"),
				shdHour,
				new JLabel("Shut Down Minute"),
				shdMinute,
				new JLabel("Reminder Hour"),
				rmdHour,
				new JLabel("Reminder Minute"),
				rmdMinute,
				new JLabel("Version 1.0")
		};
		int result = JOptionPane.showConfirmDialog(null, inputs, "Configuration", JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {	
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("shutdownhr", Long.parseLong(shdHour.getText()));
			jsonObject.put("shutdownmin", Long.parseLong(shdMinute.getText()));
			jsonObject.put("remindhr", Long.parseLong(rmdHour.getText()));
			jsonObject.put("remindmin", Long.parseLong(rmdMinute.getText()));
			try {
				FileWriter fileWriter = new FileWriter("config.json");
				fileWriter.write(jsonObject.toJSONString());
				fileWriter.flush();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}