from bisect import bisect_left

n = int(input())
nums = list(map(int,input().split()))
nums.sort()
res = float('inf')

res_1 = [-float('inf'), float('inf')]

for i in range(n):
    num = nums[i]
    idx = bisect_left(nums, -num)
    
    for j in [idx-1, idx]:
        if 0 <= j < n and i!=j:
            total = nums[i] + nums[j]
            if abs(total) < res:
                res = abs(total)
                answer = [nums[i], nums[j]]

answer.sort()

print(*answer)