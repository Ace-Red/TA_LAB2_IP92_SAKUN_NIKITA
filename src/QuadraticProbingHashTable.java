public class QuadraticProbingHashTable {
    //текущий размер для вывода текущего заполнения матрицы и максимальный размер для установки размера массивов ключей и значений
    private int currentSize, maxSize;
    //кон
    private static final int hash32Init = 0x811c9dc5;
    private static final int hash32Prime = 0x01000193;
    //ключ по которому мы будем искать значение
    private String[] keys;
    //само значение
    private String[] vals;
    //конструктор
    public QuadraticProbingHashTable(int capacity)
    {
        this.currentSize = 0;
        this.maxSize = capacity;
        this.keys = new String[maxSize];
        this.vals = new String[maxSize];
    }
    //получаем колличество элементов в таблице
    public int getSize()
    {
        return currentSize;
    }
    //хеш функция FNV32
    private int hash32(String key)
    {
        int rv = hash32Init;
        final int len = key.length();
        for(int i = 0; i < len; i++) {
            rv ^= key.charAt(i);
            rv *= hash32Prime;
        }
        return rv;
    }
    //метод всавки
    public void insert(String key, String val)
    {
        int tmp = hash32(key);
        int i = tmp, h = 1;
        do
        {
            if (keys[i] == null)
            {
                keys[i] = key;
                vals[i] = val;
                currentSize++;
                return;
            }
            if (keys[i].equals(key))
            {
                vals[i] = val;
                return;
            }
            i = (i + h * h++) % maxSize;
        } while (i != tmp);
    }
    //метод поиска элемента
    public String get(String key)
    {
        int i = hash32(key), h = 1;
        while (keys[i] != null)
        {
            if (keys[i].equals(key))
                return vals[i];
            i = (i + h * h++) % maxSize;
            System.out.println("i "+ i);
        }
        return null;
    }

}
