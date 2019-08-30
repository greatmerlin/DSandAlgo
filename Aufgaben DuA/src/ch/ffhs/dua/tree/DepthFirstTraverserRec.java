package ch.ffhs.dua.tree;

/**
 * Klasse zum Traversieren eines Baumes mit Tiefensuche.
 * Am einfachsten kann die Tiefensuche rekursiv programmiert werden.
 *
 * @param <N>
 */
public abstract class DepthFirstTraverserRec<N> 
{
	/**
	 * Traversiert einen Baum mit DepthFirst Strategie.
	 * @param node Die Wurzel des zu traversierenden Baumes.
	 */
	public void traverse(TreeNode<N> node) 
	{
		// TODO
	}
	
	/**
	 * Operation auf einem Knoten, bevor die Nachkommen besucht wurden.
	 * @param value
	 */
	abstract protected void preOperation(N value);   
    
	/**
	 * Operation auf einem Knoten, nachdem die Nachkommen besucht wurden.
	 * @param value
	 */
	abstract protected void postOperation(N value);  

}   