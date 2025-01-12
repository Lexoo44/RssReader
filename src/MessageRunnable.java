
import java.awt.EventQueue;

import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JEditorPane;

public class MessageRunnable implements Runnable {
	private JEditorPane jEditorPane;
	private StringBuilder stringBuilder;
	private TrayIcon trayIcon;

	public MessageRunnable(JEditorPane jEditorPane, StringBuilder stringBuilder, TrayIcon trayIcon) {
		this.jEditorPane = jEditorPane;
		this.stringBuilder = stringBuilder;
		this.trayIcon = trayIcon;
	}

	@Override
	public void run() {
		trayIcon.setToolTip("There are new Items");
		trayIcon.displayMessage("NEW ITEM", "Channels updated", MessageType.INFO);
		stringBuilder.append("<b> Message : </b> Updating Channels..... <br>");

		final String stringBuilder_copy = stringBuilder.toString();
		try {
			EventQueue.invokeAndWait(() -> jEditorPane.setText(stringBuilder_copy));
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
