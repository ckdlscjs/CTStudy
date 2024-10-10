//https://school.programmers.co.kr/learn/courses/30/lessons/77484
#include <bits/stdc++.h>
using namespace std;
long long int lotto;
vector<int> solution(vector<int> lottos, vector<int> win_nums)
{
    for(const auto& iter : win_nums)
        lotto |= (1LL << iter);
    int cnt = 0;
    int zero_cnt = 0;
    for(const auto& iter : lottos)
    {
        cnt += (lotto & 1LL << iter) ? 1 : 0;
        zero_cnt += iter ? 0 : 1;
    }
    return {std::min(6, 7-cnt+zero_cnt), std::min(6, 7-cnt)};
}