#include <bits/stdc++.h>
int N, arr[2'005], cnt;
std::unordered_set<int> idxs;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 0; i < N; i++) std::cin >> arr[i];
  std::sort(arr, arr+N);
  for(int i = 0; i < N; i++)
  {
    for(int j = i+1; j < N; j++)
    {
      int lo = -1, hi = N;
      while(lo + 1 < hi)
      {
        int mid = (lo + hi) / 2;
        if(arr[mid] == arr[i] + arr[j])
        {
          if(mid == i || mid == j) break;
          if(idxs.find(mid) != idxs.end())
            break;
          idxs.insert(mid);
          int l = mid-1;
          int r = mid+1;
          while(l >= 0 && arr[mid] == arr[l]) idxs.insert(l--);
          while(r < N && arr[mid] == arr[r]) idxs.insert(r++);
          break;
        }
        else if(arr[mid] < arr[i] + arr[j]) lo = mid;
        else hi = mid;
      }
    }
  }
  std::cout << idxs.size();
  return 0;
}

---------------------------------------------


#include <bits/stdc++.h>
int N, arr[2'005], cnt;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 0; i < N; i++) std::cin >> arr[i];
  std::sort(arr, arr+N);
  for(int i = 0; i < N; i++)
  {
    int left = 0, right = N-1;
    while(left < right)
    {
      if(arr[left] + arr[right] > arr[i]) right--;
      else if(arr[left] + arr[right] < arr[i]) left++;
      else if(left == i) left++;
      else if(right == i) right--;
      else if(arr[left] + arr[right] == arr[i])
      {
        cnt++;
        break;
      }
    }
  }
  std::cout << cnt;
  return 0;
}