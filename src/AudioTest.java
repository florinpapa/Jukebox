

import java.io.File;

import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.RealizeCompleteEvent;
import javax.media.Time;
import javax.media.format.AudioFormat;

public class AudioTest {
	public static void main(String[] args) {
		Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
		Format input2 = new AudioFormat(AudioFormat.MPEG);
		Format output = new AudioFormat(AudioFormat.LINEAR);
		PlugInManager.addPlugIn(
			"com.sun.media.codec.audio.mp3.JavaDecoder",
			new Format[]{input1, input2},
			new Format[]{output},
			PlugInManager.CODEC
		);
		try{
			Player player = Manager.createPlayer(new MediaLocator(new File("/Users/florinpapa/Downloads/salam.mp3").toURI().toURL()));
			double x = 50;
			Time t = new Time(x);
			MyListener m = new MyListener(player, t);
			
			player.start();
			player.addControllerListener(m);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

class MyListener implements ControllerListener {
    Player p;
    Time t;
    
	public MyListener(Player p, Time t) {
		this.p = p;
		this.t = t;
	}
	
	@Override
	public void controllerUpdate(ControllerEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0 instanceof RealizeCompleteEvent) {
			p.setMediaTime(t);
		}
	}
	
}