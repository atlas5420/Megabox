package Ch01.Movie;

import java.util.ArrayList;

public class C03BoardBean {
	
	private String txtarea;
	public ArrayList<String> list = new ArrayList();
	
	public String getTxtarea() {
		return txtarea;
	}

	public void setTxtarea(String txtarea) {
		this.txtarea = txtarea;
		list.add(txtarea);
	}
}
