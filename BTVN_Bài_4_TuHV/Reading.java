import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Reading {
	String path;
	String data;
	String key;
	int value;
	BufferedWriter bw = null;
	FileWriter fw = null;
	HashMap<String, Integer> map;
	
	public Reading(String _path) {
		this.path = _path;
		try {
			this.data = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
			countWord();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void countWord() {
		String[] str = data.toLowerCase(Locale.ENGLISH)
				.replace("//", "").replace("\"", "").replace("?", "").replace("<", "").replace("/", "")
				.replace(".", " ").replace("“", "").replace("-", "").replace(">", "").replace("…", "")
				.replace(",", " ").replace("{", "").replace("}","").replace("(", "").replace(")","")
				.replace("”", "").replace("=", "").replace(")", "").replace("*", "").replace(":", "")
				.replace("’", " ").replace("–", "").replace("—", "").replace(";", "").replace("?", "")
				.replace("!", "").replace("‘", "").replace("•", "").replace("#", "")
				.split("\\s");
		map(str);
	}
	
	private void map(String[] str) {
		map = new HashMap<String, Integer>();
		for(String s:str) {
			key = s;
			if(map.containsKey(key)){
				value = map.get(key);
				map.remove(key);
				map.put(key, value+1);
			} else {
				map.put(key, 1);
				
			}
		}
		
		map.remove("");
		Map<String, Integer> result = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		Set set = result.entrySet();
		Iterator iterator = set.iterator();
		String string = "";
		try {
			fw = new FileWriter("C:\\Java\\BTVN_Bai_4_TuHV\\src\\write.txt");
			bw = new BufferedWriter(fw);
			while(iterator.hasNext()) {
		         Map.Entry mentry = (Map.Entry)iterator.next();
		         bw.write(mentry.getKey() + " : " + mentry.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
	       }
	}
}
