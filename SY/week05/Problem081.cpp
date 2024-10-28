//https://school.programmers.co.kr/learn/courses/30/lessons/12906
#include <bits/stdc++.h>
using namespace std;
vector<int> solution(vector<int> arr) 
{
    arr.erase(std::unique(arr.begin(), arr.end()), arr.end());
    return arr;
}