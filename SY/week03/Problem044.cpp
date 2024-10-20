//https://school.programmers.co.kr/learn/courses/30/lessons/64061
#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) 
{
    int answer = 0;
    std::queue<int> q[35];
    std::stack<int> st_result;
    for(int i = 0; i < board.size(); i++)
        for(int j = 0; j < board[0].size(); j++)
            if(board[i][j])
                q[j].push(board[i][j]);
    
    for(int i = 0; i < moves.size(); i++)
    {
        if(q[moves[i]-1].empty())
            continue;
        if(st_result.size() && st_result.top() == q[moves[i]-1].front())
        {
            st_result.pop();
            answer += 2;
        }
        else
        {
            st_result.push(q[moves[i]-1].front());
        }
        q[moves[i]-1].pop();
    }
    return answer;
}