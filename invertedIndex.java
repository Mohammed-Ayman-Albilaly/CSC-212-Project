
public class invertedIndex {
	LinkedList<Integer> IDofDocuments = new LinkedList<Integer>();
	String word;
	
	public invertedIndex() {
		
	}
	
	public void add(String word, LinkedList<index> index) {
		this.word = word;
		index.findFirst();
		while(!index.last()) {
			if(index.retrieve().exist(word)) {
				IDofDocuments.insert(index.retrieve().id);
			}
			index.findNext();
		}
		if(index.retrieve().exist(word)) {
			IDofDocuments.insert(index.retrieve().id);
		}
	}
	
	public void printinv() {
		System.out.println(word+" ");
		IDofDocuments.print();
	}
	
	public String toString () {
		String s = word+" ";
		IDofDocuments.findFirst();
		while(!IDofDocuments.last()) {
			s= s+IDofDocuments.retrieve()+" ";
			IDofDocuments.findNext();
		}
		s= s+IDofDocuments.retrieve()+" ";
		return s;
	}
}
