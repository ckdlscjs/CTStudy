//https://school.programmers.co.kr/learn/courses/30/lessons/140108
#include <bits/stdc++.h>
using namespace std;
int cnt_f, cnt_other, answer;
int solution(string s) 
{
    char ch = s[0];
    for(int i = 0; i < s.size(); i++)
    {
        if(ch == s[i])
            cnt_f++;
        else
            cnt_other++;
        if(cnt_f == cnt_other)
        {
            answer++;
            cnt_f = cnt_other = 0;
            ch = s[i+1];
        }
    }
    return cnt_f ? answer + 1 : answer;
}