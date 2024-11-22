
public class TestCases {

	public static void main(String[] args) {
		SearchEngine search = new SearchEngine();
		Queries query = new Queries();
		//search.uniqeWords.print();
//		System.out.println(search.uniqeWords.size());
//		System.out.println(search.invertedIndex.size());
//		System.out.println(search.index.size());
//		search.invertedIndex.findFirst();
//		for(int i =0 ; i < search.invertedIndex.size();i++) {
//			System.out.println(search.invertedIndex.retrieve().word);
//			search.invertedIndex.findNext();
//		}
		//search.invertedIndex.print();
		//System.out.println(query.postfix("sport and cofee or king and area"));
		query.QueryProcessing("market OR sports AND warming");

	}

}
