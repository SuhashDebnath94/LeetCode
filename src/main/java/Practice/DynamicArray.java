package Practice;

public class DynamicArray<T> {
    private T[] arr;
    private int length; //size which user thinks array is
    private int capacity; //actual size of array

    public DynamicArray() {
        this.length = 0;
        this.capacity = 16;
        arr = (T[]) new Object[capacity];
    }

    public DynamicArray(int size) {
        if (size < 0) {
            throw new RuntimeException("Capacity of array cannot be less than 0");
        }
        this.capacity = size;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return length;
    }

    public void add(T elem) {
        if (length + 1 > capacity) {
            if (capacity == 0) capacity += 1;
            else {
                capacity = capacity * 2;
                T[] temp_arr = (T[]) new Object[capacity];
                for (int i = 0; i < length; i++)
                    temp_arr[i] = arr[i];
                arr = temp_arr;
            }
        }
        arr[length++] = elem;
    }


}
