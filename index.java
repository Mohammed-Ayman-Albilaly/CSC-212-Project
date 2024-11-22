
public class index {
	LinkedList<String> listOfwords = new LinkedList<String>();
	int id;
	
	public index() {
		
	}

//	public Index(int id, LinkedList l) {
//		this.id = id;
//		listOfwords.insert(l);
//	}
	
	public void add(String document, int id) {
		this.id =id;
		
		String demarcation = " ";
		int start = 0, end = document.indexOf(demarcation, start);
		while(end != -1) {
			String parts = document.substring(start, end);
			listOfwords.insert(parts);
			
			start = end +1;
			end = document.indexOf(demarcation, start);
		}
		String parts = document.substring(start);
		listOfwords.insert(parts);
	}
	
	public boolean exist(String word) {
		listOfwords.findFirst();
		while(!listOfwords.last()) {
			if (word.equalsIgnoreCase(listOfwords.retrieve()))
				return true;
			listOfwords.findNext();
		}
		if (word.equalsIgnoreCase(listOfwords.retrieve()))
			return true;
		return false;
	}
	
	public String toString () {
		String s = id+" ";
		listOfwords.findFirst();
		while(!listOfwords.last()) {
			s= s+listOfwords.retrieve()+" ";
			listOfwords.findNext();
		}
		s= s+listOfwords.retrieve()+" ";
		return s;
	}
	

	
}
