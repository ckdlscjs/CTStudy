//https://school.programmers.co.kr/learn/courses/30/lessons/142086
#include <bits/stdc++.h>
using namespace std;
std::unordered_map<char, int> checks;
vector<int> solution(string s) {
    vector<int> answer;
    for(int i = 0; i < s.size(); i++)
    {
        if(checks.find(s[i]) == checks.end())
        {
            checks[s[i]] = i;
            answer.push_back(-1);
        }
        else
        {
            answer.push_back(i-checks[s[i]]);
            checks[s[i]] = i;
        }
    }
    
    return answer;
}