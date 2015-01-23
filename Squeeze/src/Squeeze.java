import java.io.*;
import java.util.*;

public class Squeeze {
	
	public void squeeze(String[] data) {
		
		for(int j = 0; j < data.length; j++){
			int spaces = 0;
			for(int i = 0; i < data[j].length() - 1 && Character.isWhitespace(data[j].charAt(i)); i++) {
				if(Character.isWhitespace(data[j].charAt(i))) {
					spaces++;
				}
			}
			data[j] = spaces + data[j].substring(spaces);
		}
	}
}
