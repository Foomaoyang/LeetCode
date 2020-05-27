package adt;

public class UnionFind implements UF {

	private int[] id;
	
	public UnionFind(int size) {
		id = new int[size];
		for(int i = 0; i < id.length; i ++)
			id[i] = i;
	}
	
	@Override
	public int getSize() {
		return id.length;
	}

	private int find(int p) {
		if(p < 0 && p>= id.length)
			throw new IllegalArgumentException("p is out of bound.");
		return id[p];
	}
	
	// �鿴Ԫ��p��q�Ƿ�����ͬһ������
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	// �ϲ�Ԫ��p��q�����ļ���
	@Override
	public void unionElements(int p, int q) {

		int pID = find(p);
		int qID = find(q);
		
		if(pID == qID)
			return;
		
		for(int i = 0; i < id.length; i ++)
			if(id[i] == pID)
				id[i] = qID;
	}

	
	
	public static void main(String[] args) {

	} 

}
