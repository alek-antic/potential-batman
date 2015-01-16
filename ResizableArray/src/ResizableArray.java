import java.util.Iterator;


public class ResizableArray<E> /*implements Iterable<E>*/{

	private E[] data;
	private int size;
	private final int DEFAULT_ARRAY_LENGTH = 100;

	public ResizableArray() {
		data = (E[])new Object[DEFAULT_ARRAY_LENGTH];
		size = 0;
	}

	public ResizableArray(int length) {
		data = (E[])new Object[length];
		size = 0;
	}

	public void add(E value) {
		if (size == data.length) {
			E[] newData = (E[])new Object[size * 2];
			for (int i = 0; i < size; i++)
				newData[i] = data[i];
			data = newData;
		}

		data[size] = value;
		size++;
	}

	public E remove(int index) {
		if (index >= size)
			throw new ArrayIndexOutOfBoundsException(
					"Your code sucks and you should feel bad about yourself."
							+ " Bad Index: " + index);
		for (int j = index; j < size - 1; j++)
			data[j] = data[j + 1];
		size--;
		return data[index];
	}

	public int size() {
		return size;
	}

	public void insert(int index, E value) {
		if (index > size)
			throw new ArrayIndexOutOfBoundsException(
					"Your code sucks and you should feel bad about yourself."
							+ " Bad Index: " + index);
		if (size == data.length) {
			E[] newData = (E[])new Object[size + 10];
			for (int i = 0; i < size; i++)
				newData[i] = data[i];
			data = newData;
		}
	
		for (int i = size; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = value;
		size++;
	}

	public E get(int index) {
		if (index >= size)
			throw new ArrayIndexOutOfBoundsException(
					"Your code sucks and you should feel bad about yourself."
							+ " Bad Index: " + index);
		return data[index];
	}

	public void set(int index, E value) {
		if (index >= size)
			throw new ArrayIndexOutOfBoundsException(
					"Your code sucks and you should feel bad about yourself."
							+ " Bad Index: " + index);
		data[index] = value;
	}

	public void sort() {
		if(size == 0) {
			return;
		}
		
		if(data[0] instanceof Comparable) {
			int j;
			boolean flag = true;
			E temp;

			while (flag) {
				flag = false;
				for (j = 0; j < size - 1; j++) {
					if (((Comparable) data[j]).compareTo(data[j + 1]) > 0) {
						temp = data[j];
						data[j] = data[j + 1];
						data[j + 1] = temp;
						flag = true;
					}
				}
			}
		} else {
			return; //EXCPETION
		}
		
	}
	
	public ResizableArray<E> intersection(ResizableArray<E> other) {
		ResizableArray<E> intersection = new ResizableArray<E>();
		for(int i = 0; i < size; i ++) {
			for(int j = 0; j < other.size(); j++) {
				if(data[i].equals(other.get(j)))
					intersection.add(data[i]);
			}
		}
		return intersection;
	}

	public E[] toArray() {
		E[] result = (E[])new Object[size];
		for(int i = 0; i<size; i++) {
			result[i] = data[i];
		}
		return result;
	}
	
	public int indexOf(E value) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean equals(ResizableArray<E> other) {
		boolean result = true;
		for (int i = 0; i < other.size(); i++) {
			if (!data[i].equals(other.get(i))) {
				result = false;
				break;
			}
		}
		return result;
	}

	public String toString() {
		String result = "[ ";
		for (int i = 0; i < size; i++)
			result = result.concat("" + data[i] + " ");
		result = result.concat("]");
		return result;
	}
/*
	public Iterator<E> iterator() {
		Iterator<E> i = new Iterator<E>(this);
	}
	*/
}
