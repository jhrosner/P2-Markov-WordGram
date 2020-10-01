
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Julia Rosner
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int i=0; i < size; i++){
			myWords[i] = source[start+i];
		}
		myToString = null;
		myToString = this.toString();
		myHash = 0;
		myHash = this.hashCode();
	}
		// TODO: initialize all instance variable

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * return size of WordGram
	 * @return length of myWords
	 */
	public int length(){
		int len = myWords.length;
		return len;
	}


	/**
	 * check if object passed in parameter is a WordGram object with same order of strings
	 * @param o object to check if equal to this WordGram
	 * @return true or false
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram wg = (WordGram) o;
		return this.myToString.equals(wg.myToString);
	}

	@Override
	public int hashCode(){
		// TODO: complete this method: assign to myHash as needed
		if(myHash == 0){
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * shifts the words in the array and adds the new string (last) in last index
	 * @param last is last String of returned WordGram
	 * @return new WordGram object, whose k-1 entries are same as last k-1 entries of this WordGram
	 */
	public WordGram shiftAdd(String last) {
		String[] newarray = new String[myWords.length];
		for(int k=1; k<myWords.length; k++){
			newarray[k-1] = myWords[k];
		}
		newarray[myWords.length-1] = last;
		// TODO: Complete this method
		return new WordGram(newarray, 0, myWords.length);
	}

	@Override
	public String toString(){
		if(myToString == null) {
			myToString = String.join(" ", myWords);
		}
		// TODO: Complete this method, assign to myToString as needed
		return myToString;
	}
}
