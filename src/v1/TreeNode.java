package v1;

public class TreeNode<T> 
{
	private T item;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;

	public TreeNode(T newItem) 
	{
		// Initializes tree node with item and no children.
		item = newItem;
		leftChild  = null;
		rightChild = null;
	}  // end constructor

	public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right) 
	{
		// Initializes tree node with item and
		// the left and right children references.
		item = newItem;
		leftChild  = left;
		rightChild = right;
	}  // end constructor

	public T getItem()
	{
		return item;
	}

	public void setItem(T item)
	{
		this.item = item;
	}

	public TreeNode<T> getLeftChild()
	{
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild)
	{
		this.leftChild = leftChild;
	}


	public TreeNode<T> getRightChild()
	{
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild)
	{
		this.rightChild = rightChild;
	}


}  // end TreeNode

