package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 11 Problems 1, 2, and 3
 * Status: Complete and thoroughly tested
 * Last update: 04/19/17
 * Submitted:  04/20/17
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 04.20.17
 */
public class Driver
{

	static BufferedReader stdin = new BufferedReader ( new  InputStreamReader (System.in));

	public static void main(String[] args) throws IOException
	{

		int i = 0;
		MyBinarySearchTreePlus<Data, String> mbstp = new MyBinarySearchTreePlus<Data, String>();
	
		
		mbstp.insert(new Data("2"));
		mbstp.insert(new Data("6"));
		mbstp.insert(new Data("5"));
		mbstp.insert(new Data("8"));
		mbstp.insert(new Data("7"));
		mbstp.insert(new Data("10"));
		mbstp.insert(new Data("12"));
	
	

		do
		{
			System.out.println("\n"+"Application's Options: ");
			System.out.println("                       ");
			System.out.println("1. Insert key in BST");
			System.out.println("2. Delete key from BST");
			System.out.println("3. Search for key in BST");
			System.out.println("4. Display height of BST");
			System.out.println("5. Display size of BST");
			System.out.println("6. Display content of BST in inorder");
			System.out.println("7. Display content of BST in preorder");
			System.out.println("8. Display content of BST in postorder");
			System.out.println("9. Build copy of the tree, and test it");
			System.out.println("10. Exit");
			System.out.println("                       ");
			System.out.println("Choose your option: " + "\n");
			String input = stdin.readLine().trim();
			System.out.println(input);
			i = Integer.parseInt(input);

			if (i > 0 && i < 11)
			{
				switch(i)
				{
					case 1:
						System.out.println("Enter key to be inserted: ");
						String curKey = stdin.readLine().trim();
						TreeNode<Data> n;
						
						if(mbstp.root == null)
						{
							n = new TreeNode<Data>(new Data(curKey));
							mbstp.root = n;
						}
						else
						{
							mbstp.insert(new Data(curKey));
						}
						break;
					case 2:
						System.out.println("Enter key to be removed: ");
						String sRemove = stdin.readLine().trim();
						mbstp.delete(sRemove);
						System.out.println(sRemove + " has been removed.");
						break;
					case 3:
						System.out.println("Enter key to be searched: ");
						String sSearch = stdin.readLine().trim();
						Data d = mbstp.retrieve(sSearch);
						System.out.println(d.getKey() + " is here.");
						break;
					case 4:
						System.out.println(mbstp.getHeight() + " is the height of this tree.");
						break;
					case 5:
						System.out.println(mbstp.getSize() + " is the size of this tree.");
						break;
					case 6:
						System.out.println("In-order");
						System.out.println(mbstp.toStringInorder());
						break;
					case 7:
						System.out.println("Pre-order");
						System.out.println(mbstp.toStringPreorder());
						break;
					case 8:
						System.out.println("Post-order");
						System.out.println(mbstp.toStringPostorder());
						break;
					case 9:
						break;
					case 10:
						System.out.println("Bye");
						break;

				}
			}
		}while(i < 10 || i > 10);
	}
}



