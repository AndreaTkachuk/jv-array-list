package core.basesyntax;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    @SuppressWarnings("unchecked")
    private T[] arrayData = (T[]) new Object[DEFAULT_CAPACITY];
    private int size = 0;

    @SuppressWarnings("unchecked")
    @Override
    public void add(T value) {
        if (this.size == arrayData.length) {
            T[] newData = (T[]) new Object[arrayData.length * 3 / 2];   
            for (int i = 0; i < arrayData.length; i++) {
                newData[i] = arrayData[i];
            }
            arrayData = newData;
        }

        arrayData[this.size] = value;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void add(T value, int index) {
        if (index > this.size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("The index does not exist");
        }
        if (this.size == arrayData.length) {
            T[] newData = (T[]) new Object[arrayData.length * 3 / 2];   
            for (int i = 0; i < arrayData.length; i++) {
                newData[i] = arrayData[i];
            }
            arrayData = newData;
        }
        T[] tempData = (T[]) new Object[arrayData.length];
        int count = 0;
        for (int i = index; i < this.size; i++) {
            tempData[count] = arrayData[i];
            count++;
        }
        arrayData[index] = value;
        count = 0;
        for (int i = index + 1; i <= this.size; i++) {
            arrayData[i] = tempData[count];
            count++;
        }
        this.size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addAll(List<T> list) {
        if (this.size + list.size() > arrayData.length) {
            T[] newData = (T[]) new Object[arrayData.length * 3 / 2];   
            for (int i = 0; i < arrayData.length; i++) {
                newData[i] = arrayData[i];
            }
            arrayData = newData;
        }
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        if (index >= this.size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("The index does not exist");
        }
        return this.arrayData[index];
    }

    @Override
    public void set(T value, int index) {
        if (index >= this.size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("The index does not exist");
        }
        this.arrayData[index] = value;
    }

    @Override
    public T remove(int index) {
        if (index >= this.size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("The index does not exist");
        }
        T remElem = this.arrayData[index];
        for (int i = index; i < this.size - 1; i++) {
            arrayData[i] = arrayData[i + 1];
        }
        this.size--;
        return remElem;
    }

    @Override
    public T remove(T element) {
        for (int i = 0; i < this.size; i++) {
            if ((element == null && arrayData[i] == null) 
                    || (arrayData[i] != null && arrayData[i].equals(element))) {
                return remove(i);
            }
        }
        throw new java.util.NoSuchElementException("No such element");
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
