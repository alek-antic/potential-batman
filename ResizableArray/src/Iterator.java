
public class Iterator<E> implements java.util.Iterator{

	private ResizableArray<E> array;
	int index;
	
	public Iterator(ResizableArray<E> array) {
		this.array = array;
		index = 0;
	}

	public boolean hasNext() {
		if(index < array.size())
			return true;
		else 
			return false;
	}


	public E next() {
		index++;
		return array.get(index);
	}

	public void remove() {
		
	}

	
	
}
