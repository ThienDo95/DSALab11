package v1;

public class BinarySearchTree<T extends KeyedItem<KT>,KT extends Comparable<? super KT>>extends BinaryTreeBasis<T> 
{
	// inherits isEmpty(), makeEmpty(), getRootItem(), and
	// the use of the constructors from BinaryTreeBasis

	public BinarySearchTree() 
	{
	}  // end default constructor

	public BinarySearchTree(T rootItem) 
	{
		super(rootItem);
	}  // end constructor

	public void setRootItem(T newItem)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}  // end setRootItem

	public void insert(T newItem) 
	{
		root = insertItem(root, newItem);
	}  // end insert

	public T retrieve(KT searchKey) {
		return retrieveItem(root, searchKey);
	}  // end retrieve

	public void delete(KT searchKey) throws TreeException {
		root = deleteItem(root, searchKey);
	}  // end delete

	public void delete(T item) throws TreeException {
		root = deleteItem(root, item.getKey());
	}  // end delete

	protected TreeNode<T> insertItem(TreeNode<T> tNode,
			T newItem) {
		TreeNode<T> newSubtree;
		if (tNode == null) {
			// position of insertion found; insert after leaf
			// create a new node
			tNode = new TreeNode<T>(newItem, null, null);
			return tNode;
		}  // end if
		T nodeItem = tNode.getItem();

		// search for the insertion position

		if (newItem.getKey().compareTo(nodeItem.getKey()) < 0) {
			// search the left subtree
			newSubtree = insertItem(tNode.getLeftChild(), newItem);
			tNode.setLeftChild(newSubtree);
			return tNode;
		}
		else { // search the right subtree
			newSubtree = insertItem(tNode.getRightChild(), newItem);
			tNode.setRightChild(newSubtree);
			return tNode;
		}  // end if
	}  // end insertItem

	protected T retrieveItem(TreeNode<T> tNode,
			KT searchKey) {
		T treeItem;
		if (tNode == null) {
			treeItem = null;
		}
		else {
			T nodeItem = tNode.getItem();
			if (searchKey.compareTo(nodeItem.getKey()) == 0) {
				// item is in the root of some subtree
				treeItem = tNode.getItem();
			}
			else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
				// search the left subtree
				treeItem = retrieveItem(tNode.getLeftChild(), searchKey);
			}
			else { // search the right subtree
				treeItem = retrieveItem(tNode.getRightChild(), searchKey);
			}  // end if
		}  // end if
		return treeItem;
	}  // end retrieveItem

	protected TreeNode<T> deleteItem(TreeNode<T> tNode,
			KT searchKey) {
		// Calls: deleteNode.
		TreeNode<T> newSubtree;
		if (tNode == null) {
			throw new TreeException("TreeException: Item not found");
		}
		else {
			T nodeItem = tNode.getItem();
			if (searchKey.compareTo(nodeItem.getKey()) == 0) {
				// item is in the root of some subtree
				tNode = deleteNode(tNode);  // delete the item
			}
			// else search for the item
			else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
				// search the left subtree
				newSubtree = deleteItem(tNode.getLeftChild(), searchKey);
				tNode.setLeftChild(newSubtree);
			}
			else { // search the right subtree
				newSubtree = deleteItem(tNode.getRightChild(), searchKey);
				tNode.setRightChild(newSubtree);
			}  // end if
		}  // end if
		return tNode;
	}  // end deleteItem

	protected TreeNode<T> deleteNode(TreeNode<T> tNode) 
	{
		// Algorithm note: There are four cases to consider:
		//   1. The tNode is a leaf.
		//   2. The tNode has no left child.
		//   3. The tNode has no right child.
		//   4. The tNode has two children.
		// Calls: findLeftmost and deleteLeftmost
		T replacementItem;

		// test for a leaf
		if ( (tNode.getLeftChild() == null) &&
				(tNode.getRightChild() == null) ) {
			return null;
		}  // end if leaf

		// test for no left child
		else if (tNode.getLeftChild() == null) {
			return tNode.getRightChild();
		}  // end if no left child

		// test for no right child
		else if (tNode.getRightChild() == null) {
			return tNode.getLeftChild();
		}  // end if no right child

		// there are two children:
		// retrieve and delete the inorder successor
		else {
			replacementItem = findLeftmost(tNode.getRightChild());
			tNode.setItem(replacementItem);
			tNode.setRightChild(deleteLeftmost(tNode.getRightChild()));
			return tNode;
		}  // end if
	}  // end deleteNode

	protected T findLeftmost(TreeNode<T> tNode)  {
		if (tNode.getLeftChild() == null) {
			return tNode.getItem();
		}
		else {
			return findLeftmost(tNode.getLeftChild());
		}  // end if
	}  // end findLeftmost

	protected TreeNode<T> deleteLeftmost(TreeNode<T> tNode) {
		if (tNode.getLeftChild() == null) {
			return tNode.getRightChild();
		}
		else {
			tNode.setLeftChild(deleteLeftmost(tNode.getLeftChild()));
			return tNode;
		}  // end if
	}  // end deleteLeftmost

}  // end BinarySearchTree
