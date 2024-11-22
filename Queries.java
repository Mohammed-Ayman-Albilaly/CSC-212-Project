
public class Queries {
	SearchEngine engine = new SearchEngine();
	LinkedList<Integer> result = new LinkedList<Integer>();

	public void QueryProcessing(String s) {
		Queue<String> queue = new Queue<String>();
		Stack<LinkedList<Integer>> stack = new Stack<LinkedList<Integer>>();
		s = postfix(s);
		String demarcation = " ";
		int start = 0, end = s.indexOf(demarcation, start);
		while (end != -1) {
			String parts = s.substring(start, end);
			queue.enqueue(parts);
			start = end + 1;
			end = s.indexOf(demarcation, start);
		}
		String parts = s.substring(start);
		queue.enqueue(parts);

		while (!queue.empty()) {
			String word = queue.serve();
			if (word.equalsIgnoreCase("and")) {
				LinkedList<Integer> word1 = stack.pop();
				LinkedList<Integer> word2 = stack.pop();
				LinkedList<Integer> result = AND(word1, word2);
				stack.push(result);
			} else if (word.equalsIgnoreCase("or")) {
				LinkedList<Integer> word1 = stack.pop();
				LinkedList<Integer> word2 = stack.pop();
				LinkedList<Integer> result = OR(word1, word2);
				stack.push(result);
			} else {
				stack.push(engine.searchInvertedIndex(word));
			}
		}
		stack.pop().print();

	}

	public String postfix(String query) {
		Stack<String> operation = new Stack<String>();
		String postfix = "";
		query = query.toLowerCase();
		query = query.trim();
		String demarcation = " ";
		int start = 0, end = query.indexOf(demarcation, start);
		while (end != -1) {
			String parts = query.substring(start, end);

			if (parts.equalsIgnoreCase("and")) {
				operation.push(parts);
			}

			else if (parts.equalsIgnoreCase("or")) {

				if (!operation.empty()) {
					String op = operation.pop();

					if (op.equalsIgnoreCase("and")) {
						operation.push(parts);
						postfix = postfix + op + " ";
					} else {
						operation.push(op);
						operation.push(parts);
					}

				} else
					operation.push(parts);

			}
			// word
			else {
				postfix = postfix + parts + " ";
			}

			start = end + 1;
			end = query.indexOf(demarcation, start);
		}

		String parts = query.substring(start);

		if (parts.equalsIgnoreCase("and")) {
			operation.push(parts);
		} else if (parts.equalsIgnoreCase("or")) {
			String op = operation.pop();
			if (op.equalsIgnoreCase("and")) {
				operation.push(parts);
				postfix = postfix + op + " ";
			}
		} else {
			postfix = postfix + parts + " ";
		}

		while (!operation.empty())
			postfix = postfix + operation.pop() + " ";
		postfix = postfix.trim();
		return postfix;
	}

	public static LinkedList<Integer> AND(LinkedList<Integer> n, LinkedList<Integer> m) {
		LinkedList<Integer> result = new LinkedList<Integer>();

		n.findFirst();
		while (!n.last()) {
			m.findFirst();
			while (!m.last()) {
				if (n.retrieve() == m.retrieve()) {
					result.insert(n.retrieve());
				}
				m.findNext();
			}
			if (n.retrieve() == m.retrieve()) {
				result.insert(n.retrieve());
			}

			n.findNext();
		}

		// last emlement
		m.findFirst();
		while (!m.last()) {
			if (n.retrieve() == m.retrieve()) {
				result.insert(n.retrieve());
			}
			m.findNext();
		}
		if (n.retrieve() == m.retrieve()) {
			result.insert(n.retrieve());
		}
		
		return result;
	}

	public LinkedList<Integer> OR(LinkedList<Integer> n, LinkedList<Integer> m) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		n.findFirst();
		while(!n.last()) {
			if(!result.search(n.retrieve())) {
				result.insert(n.retrieve());
			}
			n.findNext();
		}
		// last element 
		if(!result.search(n.retrieve())) {
			result.insert(n.retrieve());
		}
		
		
		m.findFirst();
		while(!m.last()) {
			if(!result.search(m.retrieve())) {
				result.insert(m.retrieve());
			}
			m.findNext();
		}
		// last element
		if(!result.search(m.retrieve())) {
			result.insert(m.retrieve());
		}
		
		return result;
	}

}
