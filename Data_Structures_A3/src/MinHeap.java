
public class MinHeap 
{
	private int[] A;
	private int current_index;
	
	public MinHeap(int n)
	{
		A = new int[n];
		current_index = 0;
	}
	
	public void insert(int x)
	{
		//check if there is enough space in the array
		if(current_index < A.length - 1){
			
		//add x to the next available spot in the array
			
		A[current_index+1] = x;

		//bubble up or heapify
		Heapify(current_index + 1);
		
		//move index to next position
		current_index = current_index + 1;
		
		}
	}
	
	//heapify (bubble up) to restore order of heap starting at index
	private void Heapify(int index)
	{
		while(index > 1) { //while index hasn't gone beyond the root index
			//if the child is greater than the parent, the heap is ordered
			if(A[index] >= A[index/2]){
				break;
			}
			else{
				//swap parent and child
				int temp = A[index];
				A[index] = A[index/2];
				A[index/2] = temp;
				
				index = index/2;
			}
		}
	}
	
	public int removeMin()
	{
		int min = A[1]; //minimum value in the heap is the first value in the array
		
		//move the largest value to the first position
		A[1] = A[current_index-1];
		current_index = current_index-1;
		
		//heapify (sort of) to restore order to the structure
		int index = 1, min_child_index;
		
		while(index <= current_index/2)
		{
		    //get minimum child index
		    if(A[index*2] < A[index*2 + 1])
		    {
		    	min_child_index = index*2;
			}
			else{
				min_child_index = index*2 + 1;
			    
			}
		    
		    if(A[index] > A[min_child_index]){
		    	//swap current index value with minimum child index value
				int temp = A[index];
				A[index] = A[min_child_index];
				A[min_child_index] = temp;
				
				index = min_child_index;
		    }
		    else{
		    	break;
		    }
		    
		}
		
		return min;
	}
	
	public int min()
	{
		return A[1];
	}
	
	public boolean isEmpty()
	{
		if(current_index > 0)
			return false;
		else
			return true;
	}
	
	public int size()
	{
		return current_index;
	}
	
	public void printHeap()
	{
		int index = 1;
		
		for(index = 1; index <= current_index; index++)
		{
			//print root value
			System.out.print("PARENT: " + A[index]);
			
			//make sure the parent has a left child
			if(index*2 <= current_index){
				System.out.print(" LEFT CHILD: " + A[index*2]);
				
				if(index*2 + 1 <= current_index){
					System.out.print(" RIGHT CHILD: " + A[index*2 + 1]);
				}
			}
			System.out.println("");
		}
	}

	

}
