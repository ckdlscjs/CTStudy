#include <bits/stdc++.h>
using namespace std;
int N, M, arr[22][22], res;
void Rotate90(int (*ret)[22], int (*arr)[22])
{
  for(int i = 0; i < N; i++)
    for(int j = 0; j < N; j++)
      ret[i][j] = arr[N-1-j][i];
}
void MoveRight(int (*arr)[22])
{
  for(int i = 0; i < N; i++)
  {
    int jidx = N-1;
    while(jidx)
    {
      for(int j = jidx-1; j >= 0; j--)
      {
        if(arr[i][j] == 0)
        {
          if(j == 0) jidx--;
          else continue;
        }
        if(arr[i][jidx] == 0)
        {
          arr[i][jidx] = arr[i][j];
          arr[i][j] = 0;
          break;
        }
        else if(arr[i][jidx] == arr[i][j])
        {
          arr[i][jidx] += arr[i][j];
          arr[i][j] = 0;
          jidx--;
          break;
        }
        else if(arr[i][jidx] != arr[i][j])
        {
          jidx--;
          break;
        }
      }
    }
  }
}
void Check(int cnt, int (*arr)[22])
{
  if(cnt >= 5)
  {
    for(int i = 0; i < N; i++)
      for(int j = 0; j < N; j++)
        res = std::max(arr[i][j], res);
    return;
  }
  for(int rot = 0; rot < 4; rot++)
  {
    int temp[22][22];
    Rotate90(temp, arr);
    std::memcpy(arr, temp, sizeof(temp));
    MoveRight(temp);
    Check(cnt+1, temp);
  }
}
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 0; i < N; i++)
    for(int j = 0; j < N; j++)
      std::cin >> arr[i][j];

  Check(0, arr);
  std::cout << res;
  return 0;
}