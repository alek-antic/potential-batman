package gui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SimSchool {

	
	public static void main(String[] args) {
		
		
		   JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "SimSchool save File (xml)", "xml");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	SchoolWindow window = new SchoolWindow(500, 500, new Sketch(chooser.getSelectedFile().getPath()));
		    }
		
		
		
	}
}
