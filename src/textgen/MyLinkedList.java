

package textgen;
import java.util.AbstractList;
/** A class that implements a doubly linked list
*
* @author UC San Diego Intermediate Programming MOOC team
*
* @param <E> The type of the elements stored in the list
*/
public class MyLinkedList<E> extends AbstractList<E> {
   LLNode<E> head;
   LLNode<E> tail;
   int size;

   /** Create a new empty LinkedList */
   public MyLinkedList() {
       size=0;
       head=new LLNode<E>(null);
       tail=new LLNode<E>(null);
       head.next=tail;
       tail.prev=head;
       // TODO: Implement this method
   }


   private void checkBoundsInclusive(int index)
   {
       if (index < 0 || index > size)
           throw new IndexOutOfBoundsException("Index: " + index + ", Size:"+ size);
   }
   private void checkBoundsExclusive(int index)
   {
       if (index < 0 || index >= size)
           throw new IndexOutOfBoundsException("Index: " + index + ", Size:"+ size);
   }

   /**
    * Checks that the index is in the range of existing elements (exclusive).
    *
    * @param index the index to check
    * @throws IndexOutOfBoundsException if index &lt; 0 || index &gt;= size
    */


   private void addLastEntry(LLNode<E> e)
      {
            modCount++;
            if (size == 0)
                head = tail = e;
           else
              {
                    e.prev = tail;
                    tail.next = e;
                    tail = e;
                  }
            size++;
          }
   /**
    * Appends an element to the end of the list
    * @param element The element to add
    */
   public boolean add(E element )
   {
       //create new node here
	   addLastEntry(new LLNode<E>(element));  
     //  n.next=head.next;
    //   n.prev=n.next.prev;
    //   n.next.prev=n;
    //   head.next=n;
    //   size++;
       // TODO: Implement this method
       	return true;
       
   }

   LLNode<E> getEntry(int n)
   {
       LLNode<E> e;
          if (n < size / 2)
                {
                  e = head;
                  // n less than size/2, iterate from start
                  while (n-- > 0)
                        e = e.next;
                }
          else
            {
                  e = tail;
                  // n greater than size/2, iterate from end
                  while (++n < size)
                        e = e.prev;
                }
          return e;
        }
   /** Get the element at position index
    * @throws IndexOutOfBoundsException if the index is out of bounds. */
   public E get(int index)
   {
	   checkBoundsExclusive(index);
       return getEntry(index).data;


       // TODO: Implement this method.
      // 	return null;
   }

   /**
    // Add an element to the list at the specified index
    //@param  index where the element should be added
    // @param element The element to add
    */
   public void add(int index, E element )
   {
       checkBoundsInclusive(index);
       checkNullElement(element);
       LLNode<E> e = new LLNode<E>(element);

       if (index < size)
       {
           modCount++;
           LLNode<E> after =  getEntry(index);
           e.next = after;
           e.prev = after.prev;
           if (after.prev == null){
               head = e;}
           else
           { after.prev.next = e;
           after.prev = e;
           size++;}
       }
       else {
           addLastEntry(e);
       }
       // TODO: Implement this method
   }


   /** Return the size of the list */
   public int size()
   {
       return size;
       // TODO: Implement this method
      // return -1;
   }

   /** Remove a node at the specified index and return its data element.
    * @param index The index of the element to remove
    * @return The data element removed
    * @throws IndexOutOfBoundsException If index is outside the bounds of the list
    *
    */
   void removeEntry(LLNode<E> e)
      {
        modCount++;
       size--;
      if (size == 0)
       head = tail = null;
       else
       {
          if (e == head)
          {
           head = e.next;
               e.next.prev = null;
         }
          else if (e == tail)
         {
          tail = e.prev;
            e.prev.next = null;
            }
       else
         {
           e.next.prev = e.prev;
            e.prev.next = e.next;
        }
      }
    }
 
   
   public E remove(int index)
   {
       checkBoundsInclusive(index);
       LLNode<E> e = getEntry(index);
       removeEntry(e);
       return e.data;
       // TODO: Implement this method
       //	return null;
   }

   /**
    * Set an index position in the list to a new element
    * @param index The index of the element to change
    * @param element The new element
    * @return The element that was replaced
    * @throws IndexOutOfBoundsException if the index is out of bounds.
    */
   private void checkNullElement(E element)
   {
       if (element==null)
           throw new NullPointerException("Element: " + element);
           		 }
           	
   
   public E set(int index, E element)
   {
       checkBoundsInclusive(index);
       checkNullElement(element);
       LLNode<E> e =getEntry(index);
       E old = e.data;
       e.data = element;
       return old;
       // TODO: Implement this method
       //	return null;
   }
}

class LLNode<E>
{
   LLNode<E> prev;
   LLNode<E> next;
   E data;

   // TODO: Add any other methods you think are useful here
   // E.g. you might want to add another constructor

   public LLNode(E e)
   {
       this.data = e;
       this.prev = null;
       this.next = null;
   }

}
