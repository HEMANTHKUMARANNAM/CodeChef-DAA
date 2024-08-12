# cook your dish here
def check_palindrome(s, n):
    #Write your code here
    if( len(s) == n ):
        return "YES"
        
    if( s[n] == s[len(s)-1-n] ):
        return check_palindrome(s,n+1)
        
    return "NO"
    
    
s = input()
print(check_palindrome(s, 0))