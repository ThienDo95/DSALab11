package v1;

public interface BSTPInterface <T extends KeyedItem<KT>,KT extends Comparable<? super KT>>  {

	public int getHeight();
	// returns the height of the tree (recursive implementation)

	public int getSize();
	// returns the number of nodes in the tree(recursive implementation)

	public String toStringInorder();
	// returns String representation of Tree with items in Inorder
	//(recursive implementation)

	public String toStringPreorder();
	// returns String representation of Tree with items in Preorder
	//(recursive implementation)

	public String toStringPostorder();
	// returns String representation of Tree with items in Postorder
	// (recursive implementation)

	public MyBinarySearchTreePlus<T,KT> getCopyOfTree();
	// returns a new tree containing a copy of the original tree 
	// with the same structure. Note: the new tree should not have
	// any shared nodes with the original.(recursive implementation)

}// end BSTPInterface
