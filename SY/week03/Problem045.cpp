//https://school.programmers.co.kr/learn/courses/30/lessons/42889
#include <bits/stdc++.h>
using namespace std;
std::pair<int, int> cnts[505];
struct compare
{
    bool operator()(const std::pair<double, int>&a, const std::pair<double, int>& b)
    {
        return a.first == b.first ? a.second > b.second : a.first < b.first;
    }
};
vector<int> solution(int N, vector<int> stages) {
    for(const auto& iter : stages)
    {
        for(int i = 1; i <= iter; i++)
            cnts[i].second++;
        cnts[iter].first++;
    }
    std::vector<int> answer;
    std::priority_queue<std::pair<double, int>, std::vector<std::pair<double, int>>, compare> pq;
    for(int i = 1; i <= N; i++)
    {
        if(cnts[i].second == 0)
            pq.push({0, i});
        else
            pq.push({cnts[i].first/(double)cnts[i].second, i});
    }
    while(pq.size())
    {
        answer.push_back(pq.top().second);
        pq.pop();
    }
    return answer;
}