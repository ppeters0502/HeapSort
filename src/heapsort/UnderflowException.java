/** Exception class for access in empty containers (stacks, queues etc). */
package HeapSort;

public class UnderflowException extends RuntimeException
{
	/** Construct this exception object. */
	public UnderflowException(String message)
	{
		super(message);
	}
	public UnderflowException()
    {
        super();
    }

}
