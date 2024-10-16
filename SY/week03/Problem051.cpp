//https://school.programmers.co.kr/learn/courses/30/lessons/17681
#include <bits/stdc++.h>
using namespace std;
vector<string> solution(int n, vector<int> arr1, vector<int> arr2) 
{
    vector<string> answer;
    for(int i = 0; i < n; i++)
    {
        int num = arr1[i] | arr2[i];
        std::string temp = "";
         for(int j = n-1; j >= 0; j--)
            temp += num & 1 << j ? '#' : ' ';
        answer.push_back(temp);
    }
    return answer;
}