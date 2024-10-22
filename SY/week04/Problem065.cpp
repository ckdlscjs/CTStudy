//https://school.programmers.co.kr/learn/courses/30/lessons/12933
#include <bits/stdc++.h>
using namespace std;

long long solution(long long n) 
{
    std::string str = std::to_string(n);
    std::sort(str.begin(), str.end(), std::greater<>());
    return std::stoll(str);
}