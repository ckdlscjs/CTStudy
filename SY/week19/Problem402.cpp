#include <bits/stdc++.h>
int N, M, K;
long long int arr[1'000'005], tree[4*1'000'005], cache[4*1'000'005], a, b, c, d;
long long int init(const int s, const int e, const int cur)
{
  if(s >= e) return tree[cur] = arr[s];
  int mid = (s + e) / 2;
  return tree[cur] = init(s, mid, cur*2) + init(mid+1, e, cur*2+1);
}
void update_cache(const long long int s, const int e, const int cur)
{
  if(!cache[cur]) return;
  tree[cur] += (e-s+1) * cache[cur];
  if(s != e)
  {
    cache[cur*2] += cache[cur];
    cache[cur*2+1] += cache[cur];
  }
  cache[cur] = 0;
}
long long int update(const long long int val, const int l, const int r, const int s, const int e, const int cur)
{
  update_cache(s, e, cur);
  if(r < s || e < l) return tree[cur];
  if(l <= s && e <= r)
  {
    cache[cur] += val;
    update_cache(s, e, cur);
    return tree[cur];
  }
  else
  {
    int mid = (s + e) / 2;
    return tree[cur] = update(val, l, r, s, mid, cur*2) + update(val, l, r, mid+1, e, cur*2+1);
  }
}
long long int query_sum(const int l, const int r, const int s, const int e, const int cur)
{
  update_cache(s, e, cur);
  if(r < s || e < l) return 0;
  if(l <= s && e <= r) return tree[cur];
  int mid = (s + e) / 2;
  return query_sum(l, r, s, mid, cur*2) + query_sum(l, r, mid+1, e, cur*2+1);
}
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> M >> K;
  for(int n = 1; n <= N; n++) std::cin >> arr[n];
  init(1, N, 1);
  for(int m = 0; m < M+K; m++)
  {
    std::cin >> a >> b >> c;
    if(a == 1)
    {
      std::cin >> d;
      update(d, b, c, 1, N, 1);
    }
    else
    {
      std::cout << query_sum(b, c, 1, N, 1) << '\n';
    }
  }
  return 0;
}
