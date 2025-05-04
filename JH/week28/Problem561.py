from sys import stdin
input = stdin.readline

def init(nums): 
    n = len(nums)
    dp = [[False]*n for _ in range(n)]
    
    # 길이 1 
    for i in range(n):
        dp[i][i] = True
    
    # 길이 2 
    for i in range(n-1):
        if nums[i] == nums[i+1]:
            dp[i][i+1] = True
    
    # 길이 3
    for legnth in range(3,n+1):
        for start in range(n-legnth+1):
            end = start + legnth -1 
            if nums[start] == nums[end] and dp[start+1][end-1]:
                dp[start][end] = True
    return dp

n = int(input())
nums = list(map(int,input().split()))
m = int(input())
dp = init(nums)

for _ in range(m):
    a, b = map(int,input().split())
    print( 1 if dp[a-1][b-1] else 0)