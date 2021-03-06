// BinaryHeap class
//
// CONSTRUCTION: with optional capacity (that defaults to 100)
//               or an array containing initial items
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Throws UnderflowException as appropriate
package heapsort;
/**
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinaryHeap
{
    private static int d;
    /**
     * Construct the binary heap.
     */
    public BinaryHeap()
    {
        this( DEFAULT_CAPACITY );
 
    }
   
    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    public BinaryHeap( int capacity )
    {
        currentSize = 0;
        array = new int[ capacity + 1 ];
    }
    
    /**
     * Construct the binary heap given an array of items.
     */
    public BinaryHeap(  int[ ] items, int D, int capacity )
    {
        d = D;
        currentSize = items.length;
       array =  new int[ ( currentSize + 2 ) * 11/10 ];
        
        
        int i = 1;
        for( int item : items )
            array[ i++ ] = item;
   
        buildHeap(d);
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( int x, int D )
    {
        d = D;
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * d + 1 );

            // Percolate up
        int hole = ++currentSize;
        for( ; hole > 1 && x < array[ hole / d ]; hole /= d )
            array[ hole ] = array[ hole / d ];
        array[ hole ] = x;
        
        buildHeap(d);
    }


    private void enlargeArray( int newSize )
    {
        int[] old = array;
        array =  new int[ newSize ];
        for( int i = 0; i < old.length; i++ )
            array[ i ] = old[ i ];        
    }
    
    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public int findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return array[ 1 ];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public int deleteMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );

        int minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    public void buildHeap(int D )
    {
        d = D;
        for( int i = currentSize/d; i > 0; i-- )
        {
           
            percolateDown( i );
        }
        
    }
    
    public void buildHeap(int[] Heap, int D)
    {
        d = D;
       array = new int[Heap.length + d];
       int i = 1;
       for (int entry : Heap)
           array[i++] = entry;
       
       for( int j = array.length/d; j > 0; j-- )
       {
           percolateDown(j);
       }
       
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
    }

    public void print( )
    {
        for( int i = 0; i < currentSize; i++ )
            System.out.printf("%d ", array[i+1]);
        System.out.println();

    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;      // Number of elements in heap
    private int [ ] array; // The heap array

    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    public int percolateDown( int hole )
    {
        int child;
        int tmp = array[hole];
        int tmp2 = 0;
        for( ; hole * d < currentSize; hole = child)
        {
            int j = 1;
            //Equation for finding the 1st child (why j = 1) of a parent node.
            child = (hole - 1) * d + j + 1;

            
            //Nested for loop takes furthest left child, and compares it to the
            //other children to find the smallest child.
            for (int i =1; i<d; i++)
            {
  
                 if (array[child] > array[child + i])
                 {
                    child = child + i;
                    
                 }
            }
                //Now to check the smallest child element with it's parent.
            if (array[child] < array[hole])
            {
                tmp = array[hole];
                tmp2 = array[child];
                array[hole] = tmp2;
                array[child] = tmp;
            }
            else
                break;
        }
         //tmp = array[hole];
         
         
           
         
        return array[hole];
         
    }
    
    
    
}
