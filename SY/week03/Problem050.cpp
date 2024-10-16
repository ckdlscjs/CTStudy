//https://school.programmers.co.kr/learn/courses/30/lessons/17682
#include <bits/stdc++.h>
using namespace std;
int solution(string dartResult) 
{
    int scores[3] = {0, 0, 0};
    std::string score = "";
    int idx = -1;
    for(const auto& iter : dartResult)
    {
        if('0' <= iter && iter <= '9')
        {
            if(score.empty()) idx++;
            score += iter;
        }
        else
        {
            if(iter == 'S' || iter == 'D' || iter == 'T')
            {
                scores[idx] = std::stoi(score);
                score.clear();
                scores[idx] = std::pow(scores[idx], (iter == 'S' ? 1 : iter == 'D' ? 2 : 3));
            }
            else if(iter == '*' && idx > 0)
                scores[idx] *= 2, scores[idx-1] *= 2;
            else if(iter == '*' && idx <= 0)
                scores[idx] *= 2;
            else if(iter == '#')
                scores[idx] *= -1;
        }
    }
    
    return scores[0] + scores[1] + scores[2];
}