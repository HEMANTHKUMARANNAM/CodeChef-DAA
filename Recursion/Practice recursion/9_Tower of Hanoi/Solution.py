# Update the code below this line
def tower_of_hanoi(n, source, destination, auxiliary):
    
    if n ==0 :
        return 
    
    tower_of_hanoi(n-1 , source , auxiliary , destination )
    
    print("Move disk" , n , "from rod" ,source , "to rod" , destination )
    
    
    tower_of_hanoi( n-1 , auxiliary , destination , source )






def solve_tower_of_hanoi(n):
    print(f"Tower of Hanoi solution for {n} disks:")
    tower_of_hanoi(n, 1, 3, 2)
    print(f"Total number of moves: {2**n - 1}")

n = int(input())
solve_tower_of_hanoi(n)
