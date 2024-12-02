#include <bits/stdc++.h>
using namespace std;
int N, M, arr[15];
void Check(int num, int cnt)
{
  if(num > N)
    return;
  if(cnt >= M)
  {
    for(int i = 0; i < M; i++)
      std::cout << arr[i] << ' ';
    std::cout << '\n';
    return;
  }
  arr[cnt] = num +1;
  Check(num+1, cnt+1);
  Check(num+1, cnt);
}
int main() 
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> M;
  Check(0, 0);
  return 0;
}
----------------------------------------------------------------
#include <bits/stdc++.h>
using namespace std;
int N, M, arr[15];
void Check(int idx, int cnt)
{
  if(cnt >= M)
  {
    for(int i = 0; i < M; i++)
      std::cout << arr[i] << ' ';
    std::cout << '\n';
    return;
  }
  for(int i = idx+1; i <= N; i++)
  {
    arr[cnt] = i;
    Check(i, cnt+1);
  }
}
int main() 
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> M;
  Check(0, 0);
  return 0;
}
----------------------------------------------------------------
#include <bits/stdc++.h>
using namespace std;
int N, M, arr[15];
void Check(int idx, int mask)
{
  if(idx >= M)
  {
    for(int i = 0; i < M; i++)
      std::cout << arr[i] << ' ';
    std::cout << '\n';
    return;
  }
  for(int i = 0; i < N; i++)
  {
    if(mask & 1 << i) continue;
    if(idx >= 1 && arr[idx-1] >= i+1) continue;
    mask |= 1 << i;
    arr[idx] = i+1;
    Check(idx+1, mask);
    mask &= ~(1 << i);
  }
}
int main() 
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> M;
  Check(0, 0);
  return 0;
}