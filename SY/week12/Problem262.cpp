#include <bits/stdc++.h>
using namespace std;
long long int N, arr[4'005][4], lo, hi, ub, lb, cnt;
std::vector<long long int> A, B;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 0; i < N; i++)
    for(int j = 0; j < 4; j++)
      std::cin >> arr[i][j];
  for(int i = 0; i < N; i++)
    for(int j = 0; j < N; j++)
      A.push_back(arr[i][0] + arr[j][1]);
  std::sort(A.begin(), A.end());
  for(int i = 0; i < N; i++)
    for(int j = 0; j < N; j++)
      B.push_back(arr[i][2] + arr[j][3]);
  std::sort(B.begin(), B.end());
  for(int i = 0; i < A.size(); i++)
  {
    lo = -1, hi = B.size();
    while(lo + 1 < hi)
    {
      int mid = (lo + hi) / 2;
      if(A[i] + B[mid] > 0) hi = mid;
      else lo = mid;
    }
    ub = hi;
    lo = -1, hi = B.size();
    while(lo + 1 < hi)
    {
      int mid = (lo + hi) / 2;
      if(A[i] + B[mid] >= 0) hi = mid;
      else lo = mid;
    }
    lb = hi;
    cnt += ub - lb;
  }
  std::cout << cnt;
  return 0;
}

----------------

#include <bits/stdc++.h>
using namespace std;
long long int N, arr[4][4'005], lo, hi, cnt;
std::vector<long long int> A, B;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 0; i < N; i++)
    for(int j = 0; j < 4; j++)
      std::cin >> arr[j][i];
  std::sort(&arr[0][0], &arr[0][0] + N);
  std::sort(&arr[1][0], &arr[1][0] + N);
  std::sort(&arr[2][0], &arr[2][0] + N);
  std::sort(&arr[3][0], &arr[3][0] + N);
  for(int i = 0; i < N; i++)
    for(int j = 0; j < N; j++)
      A.push_back(arr[0][i] + arr[1][j]);
  std::sort(A.begin(), A.end());
  for(int i = 0; i < N; i++)
    for(int j = 0; j < N; j++)
      B.push_back(arr[2][i] + arr[3][j]);
  std::sort(B.begin(), B.end());
  long long int l = 0, r = B.size()-1;
  while(l < A.size() && r >= 0)
  {
    long long int temp = A[l] + B[r];
    if(temp > 0) r--;
    else if(temp < 0) l++;
    else
    {
      long long int cntl = 0, cntr = 0;
      long long int lval = A[l];
      while(l < A.size() && A[l] == lval)
      {
        cntl++;
        l++;
      }
      long long int rval = B[r];
      while(0 <= r && B[r] == rval)
      {
        cntr++;
        r--;
      }
      cnt += cntl * cntr;
    }
  }
  std::cout << cnt;
  return 0;
}

------------------

#include <bits/stdc++.h>
using namespace std;
long long int N, arr[4][4'005], lo, hi, cnt;
std::vector<long long int> A, B;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 0; i < N; i++)
    for(int j = 0; j < 4; j++)
      std::cin >> arr[j][i];
  std::sort(&arr[0][0], &arr[0][0] + N);
  std::sort(&arr[1][0], &arr[1][0] + N);
  std::sort(&arr[2][0], &arr[2][0] + N);
  std::sort(&arr[3][0], &arr[3][0] + N);
  for(int i = 0; i < N; i++)
    for(int j = 0; j < N; j++)
      A.push_back(arr[0][i] + arr[1][j]);
  std::sort(A.begin(), A.end());
  for(int i = 0; i < N; i++)
    for(int j = 0; j < N; j++)
      B.push_back(arr[2][i] + arr[3][j]);
  std::sort(B.begin(), B.end());
  long long int l = 0, r = B.size()-1;
  while(l < A.size() && r >= 0)
  {
    long long int temp = A[l] + B[r];
    if(temp > 0) r--;
    else if(temp < 0) l++;
    else
    {
      long long int cntl = 0, cntr = 0;
      lo = -1, hi = A.size();
      while(lo + 1 < hi)
      {
        long long int mid = (lo + hi) / 2;
        if(A[mid] > A[l]) hi = mid;
        else lo = mid;
      }
      cntl = hi - l;
      l = hi;
      
      lo = -1, hi = B.size();
      while(lo + 1 < hi)
      {
        long long int mid = (lo + hi) / 2;
        if(B[mid] >= B[r]) hi = mid;
        else lo = mid;
      }
      cntr = r - hi + 1;
      r = hi - 1;
      cnt += cntl * cntr;
    }
  }
  std::cout << cnt;
  return 0;
}