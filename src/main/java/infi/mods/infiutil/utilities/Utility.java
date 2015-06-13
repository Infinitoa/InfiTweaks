package infi.mods.infiutil.utilities;

import java.util.Random;

public class Utility {

	private static Random rand = new Random();

	public static int getNewID() {
		return rand.nextInt();
	}
}
