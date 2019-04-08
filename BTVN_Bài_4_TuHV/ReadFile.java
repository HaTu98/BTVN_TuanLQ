import java.util.Date;

public class ReadFile {

	public static void main(String[] args) {
		Date t = new Date();
		String path = "C:\\Java\\BTVN_Bai_4_TuHV\\src\\b4_raw.txt";
		new Reading(path);
		Date t1 = new Date();
		System.out.println(t + " " +t1);
	}
}
