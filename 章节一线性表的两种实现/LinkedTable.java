
public class LinkedTable<E> {

	int size;
	Node last;
	Node first;
	public LinkedTable() {
		this.size = 0;
		this.first =this.last = null;
	}
	
	/**
	 * 添加一个元素
	 * @param e
	 */
	public void addElement(E e) {
		if(size == 0) {
			last = new Node<E>(null, e);
			first = last;
		}else {
			Node node = new Node<E>(null, e);
			last.next = node;
			last = node;
			
		}
		size++;
	}
	/**
	 * 删除第pos个元素（从0开始技术）
	 * @param pos
	 */
	public void deleteElement(int pos) {
		if(pos<0||pos>size-1) {
			System.out.println("数组越界");
			return;
		}
		Node node = first;
		for(int i = 0; i < pos-1;i++) {
			node  = node.next;
		}
		node.next = node.next.next;
		size--;
	}
	private static class Node<E> {
		E data;
		Node next;
		
		public Node(Node next,E data) {
			this.data = data;
			this.next = next;
		}
		
	}
	/**
	 * 获取第pos个元素
	 * @param pos
	 * @return
	 */
	public E getElement(int pos) {
		if(pos<0||pos>size) {
			System.out.println("越界");
			return null;
		}
		Node<E> node = first;
		for(int i = 0; i < pos-1;i++) {
			node  = node.next;
		}
		return node.data;
	}
	public static void main(String[] args) {
		LinkedTable lk = new LinkedTable();
		lk.addElement("a");
		lk.addElement(2);
		lk.addElement(3);
		lk.addElement(4);
		lk.addElement("g");
		//lk.deleteElement(3);
		System.out.println(lk.getElement(5));
//		System.out.println(lk.size);
//		
//		System.out.println(lk.getElement(4));
	}
}
