package adt;

public interface UF {
	
	// ���鼯�Ľӿ�

	int getSize();
	boolean isConnected(int p, int q);
	void unionElements(int p, int q);
}
