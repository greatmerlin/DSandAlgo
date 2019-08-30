package ch.ffhs.dua.tree;

import java.util.Iterator;

/**
 * Ein Iterator, der in Depth-First Reihenfolge alle Werte 
 * der Knoten eines Baumes ausgibt.
 *
 * @param <N> Typ des Knotenwertes.
 */
public class TreeIterator<N> implements Iterator<N>
{
	/** 
	 * Erzeugt einen neuen neuen Baum-Knoten-Iterator
	 * @param node Die Wurzel des zu traversierenden Baumes.
	 */
	public TreeIterator(TreeNode<N> node)
	{
		// TODO
	}

	@Override
	public boolean hasNext() 
	{
		//TODO
		return false;
	}

	@Override
	public N next() {
		// TODO
		return null;
	}
	
	// remove() muss nicht implementiert werden.
}
