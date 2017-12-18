package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 11 Problems 2
 * Status: Complete and thoroughly tested [ Implemented copy()]
 * Last update: 04/27/17
 * Submitted:  04/27/17
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 04.27.17
 */
public class MyBinarySearchTreePlus <T extends KeyedItem<KT>,KT extends Comparable<? super KT>> extends MyBinarySearchTree<T,KT> implements BSTPInterface
{


	public int getHeight()
	{
		int leftHeight = 1;
		int rightHeight = 1;
		
		if(root==null)
		{
			return 0;
		}
		else
		{
			if(root.getLeftChild() != null)
			{
				leftHeight = getHeight(root.getLeftChild(),0) + 1;
			}
			if(root.getRightChild() != null)
			{
				rightHeight = getHeight(root.getRightChild(),0) + 1;
			}
		}
		
		System.out.println("Left Height " + leftHeight);
		System.out.println("Right Height " + rightHeight);
		
		return leftHeight>rightHeight?leftHeight:rightHeight;
	}

	
	private int getHeight(TreeNode<T> node, int level)
	{
		
		if(node.getLeftChild()==null && node.getRightChild()==null)
		{
			++level;
		}
		else if(node.getLeftChild()!=null)
		{
			level = getHeight(node.getLeftChild(), ++level);
		}
		else if(node.getRightChild()!=null)
		{
			level = getHeight(node.getRightChild(), ++level);
		}
		
		return level;	
	}

	public int getSize()
	{
		int leftHeight = 0;
		int rightHeight = 0;
		
		if(root.getLeftChild()!=null)
		{
			leftHeight = getSize(root.getLeftChild(),0);
		}
		if(root.getRightChild()!=null)
		{
			rightHeight = getSize(root.getRightChild(),0);
		}
		
		return leftHeight + rightHeight + 1;
	}

	
	private int getSize(TreeNode<T> node, int totalNodes){
		if(node.getLeftChild()==null && node.getRightChild()==null)
		{
			++totalNodes;
		}
		else if(node.getLeftChild()!=null)
		{
			totalNodes += getSize(node.getLeftChild(), ++totalNodes);
		}
		else if(node.getRightChild()!=null)
		{
			totalNodes += getSize(node.getRightChild(), ++totalNodes);
		}
		
		return totalNodes;
	}

	public String toStringInorder()
	{
		return toStringInorderAssistant(root);
	}

	private String toStringInorderAssistant(TreeNode<T> node)
	{
		String s ="";
		if(node != null)
		{
			s += " " + toStringInorderAssistant(node.getLeftChild());
			s += " " +node.getItem().getKey();
			s += " " +toStringInorderAssistant(node.getRightChild());
		}
		
		return s;
	}

	public String toStringPreorder()
	{
		return toStringPreorderAssistant(root);
	}
	
	private String toStringPreorderAssistant(TreeNode<T> node)
	{
		String s ="";
		if(node != null)
		{
			s += " " + node.getItem().getKey();
			s += " " + toStringInorderAssistant(node.getLeftChild());
			s += " " + toStringInorderAssistant(node.getRightChild());
		}
		
		return s;
	}

	
	public String toStringPostorder()
	{
		return toStringPostorderAssistant(root);
	}

	private String toStringPostorderAssistant(TreeNode<T> node)
	{
		String s ="";
		if(node != null)
		{
			s += " " + toStringInorderAssistant(node.getLeftChild());
			s += " " + toStringInorderAssistant(node.getRightChild());
			s += " " + node.getItem().getKey();
		}
		
		return s;
	}
	
	public MyBinarySearchTreePlus getCopyOfTree()
	{
		MyBinarySearchTreePlus<T, KT> newTree = new MyBinarySearchTreePlus<T, KT>();
		
		getCopyOfTreeAssistant(root, newTree);
		
		return newTree;
	}
	
	public MyBinarySearchTree<T, KT> getCopyOfTreeAssistant(TreeNode<T> node, MyBinarySearchTree<T, KT> newTree)
	{
		if(node != null)
		{
			newTree.insert(node.getItem());
			getCopyOfTreeAssistant(node.getLeftChild(), newTree);
			getCopyOfTreeAssistant(node.getRightChild(), newTree);
		}
		
		return newTree;
	}
}