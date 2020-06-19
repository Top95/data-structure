/**
 * 线性表数组实现
 * @author SJF
 *
 */
public class LinkedArray<E> {

	Object[] data;
	/**
	 * 数组当前长度
	 */
	int length = 0;
	/**
	 * 数组默认大小
	 */
	private final int DEFAULT_SIZE = 10;
	/**
	 * 当前分配的大小
	 */
	private  int CURENT_SIZE = 10;
	
	public LinkedArray(){
		data = new Object[DEFAULT_SIZE];
	}
	
	/**
	 * 初始化时如果指定大小小于等于0，分配默认大小
	 * @param size
	 */
	public LinkedArray(int size){
		if(size <= 0) size = DEFAULT_SIZE;
		data = new Object[size];
	}
	
	public void addArray(E o) {
		//为数组重新分配空间
		if(length + 1>CURENT_SIZE) {
			CURENT_SIZE = CURENT_SIZE +10;
			Object[] newArray = new Object[CURENT_SIZE];
			System.arraycopy(data, 0, newArray, 0, length);
			data = newArray;
		}
		data[length++] = o;
	}
	public void addArray(E o,int i) {
		if(i<0||i>length+1) {
			System.out.println("数组越界");
			return;
		}
		//为数组重新分配空间
		if(length + 1>CURENT_SIZE) {
			CURENT_SIZE = CURENT_SIZE +10;
			Object[] newArray = new Object[CURENT_SIZE];
			System.arraycopy(data, 0, newArray, 0, length);
			data = newArray;
		}
		for(int k = length;k>=i;k--) {
			data[k] = data[k-1];
		}
		
		data[i-1] = o;
		length++;
	}
	/**
	 * 获取一个元素
	 * @param i
	 * @return
	 */
	public E getArray(int i) {
		if(i<0||i>length) return null;
		return (E)data[i-1];
	}
	/**
	 * 删除某个位置的元素
	 * @param i
	 */
	public void  delete(int i) {
		if(i<0||i>length) {
			System.out.println("越界");
			return;
		}
		for(int k = i; k<length ;k++) {
			data[k-1]=data[k];
		}
		length--;
		// 为避免存储空间浪费定时清理
		while(CURENT_SIZE-length>=DEFAULT_SIZE) {
			CURENT_SIZE = CURENT_SIZE -10;
			Object[] newArray = new Object[CURENT_SIZE];
			System.arraycopy(data, 0, newArray, 0, length);
			data = newArray;
		}
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedArray<String> ls = new LinkedArray<String>();
		ls.addArray("1");
		ls.addArray("2");
		ls.addArray("3");
		ls.addArray("4");
		ls.addArray("5");
		ls.addArray("6");
		ls.addArray("7");
		ls.addArray("8");
		ls.addArray("9");
		ls.addArray("10");
		ls.addArray("1");
		ls.addArray("2");
		ls.addArray("3");
		ls.addArray("4");
		ls.addArray("5");
		ls.addArray("6");
		ls.addArray("7");
		ls.addArray("8");
		ls.addArray("9");
		ls.addArray("10");
		ls.addArray("a", 5);
		System.out.println(ls.CURENT_SIZE);
		ls.delete(6);
		System.out.println(ls.CURENT_SIZE);
		//System.out.println(ls.getArray(1).equals("2"));
		//System.out.println(ls.length);
		for(int i=1;i<ls.length+2;i++ ) {
			
			System.out.println(ls.getArray(i)+"*****");
		}
	}
}

