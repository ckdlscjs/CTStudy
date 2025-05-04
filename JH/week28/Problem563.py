
n = int(input())

def sieve(n):

    flags = [False] *(n+1)
    st = [] 
    for i in range(2, n+1):
        if not flags[i]:
            flags[i] = True
            st.append(i)
            for j in range(i,n+1,i):
                flags[j] = True
    return st

def two_pointers(n,lst):
    cnt = 0 
    length = len(lst)
    temp = 0
    i, j = 0, 0
    while j<length:
        while temp < n and j<length:
            temp += lst[j]
            j+=1

        if temp == n:
            cnt+=1
        
        while temp >= n and i<j:
            temp -= lst[i]
            if temp == n:
                cnt+=1
            i+=1
    return cnt
primes = sieve(n)
# print(primes)
print(two_pointers(n,primes))