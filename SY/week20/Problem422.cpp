#include <bits/stdc++.h>
using namespace std;
int psums[1'000'005];
vector<int> solution(vector<int> sequence, int k) 
{
    for(int i = 1; i <= sequence.size(); i++)
    {
        psums[i] = sequence[i-1];
        psums[i] += psums[i-1];
    }
    vector<int> answer(2, sequence.size()+1);
    answer[0] = 0;
    int l = sequence.size(), r = sequence.size();
    while(1 <= l && l <= r)
    {
        if(psums[r] - psums[l-1] == k)
        {
            if(r - l < answer[1] - answer[0])
            {
                answer[0] = l-1;
                answer[1] = r-1;
            }
            else if(r - l == answer[1] - answer[0] && l < answer[0])
            {
                answer[0] = l-1;
                answer[1] = r-1;
            }
            l--;
        }
        else if(psums[r] - psums[l-1] < k) l--;
        else if(psums[r] - psums[l-1] > k) r--;
    }
    return answer;
}