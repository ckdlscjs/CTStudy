//https://school.programmers.co.kr/learn/courses/30/lessons/77884
#include <bits/stdc++.h>
using namespace std;
int solution(int left, int right) 
{
    int answer = 0;
    for(left; left <= right; left++)
    {
        std::set<int> divisors;
        for(int j = 1; j <= std::sqrt(left); j++)
        {
            if(left%j == 0)
            {
                divisors.insert(left/j);
                divisors.insert(j);
            }
        }
        answer += divisors.size() % 2 ? -1 * left : left;
    }
    return answer;
}