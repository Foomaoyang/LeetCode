package adt;

public interface UF {
	
	// 并查集的接口

	int getSize();
	boolean isConnected(int p, int q);
	void unionElements(int p, int q);
}
