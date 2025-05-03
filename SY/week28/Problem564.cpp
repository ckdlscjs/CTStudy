#include <bits/stdc++.h>
using namespace std;
int T, N, M, A[1'005], B[1'005];
long long res;
std::vector<int> psumsA, psumsB;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> T;
    std::cin >> N;
    for(int n = 1; n <= N; n++)
    {
        std::cin >> A[n];
        psumsA.push_back(A[n]);
        A[n] += A[n-1];
    }
    for(int len = N; len >= 2; len--)               //partial sum  length N, N-1, N-2, ...2
        for(int i = N; i - len >= 0; i--)
            psumsA.push_back(A[i] - A[i - len]);
            
    std::cin >> M;
    for(int m = 1; m <= M; m++)
    {
        std::cin >> B[m];
        psumsB.push_back(B[m]);
        B[m] += B[m-1];
    }
     for(int len = M; len >= 2; len--)
        for(int i = M; i - len >= 0; i--)
            psumsB.push_back(B[i] - B[i - len]);

    std::sort(psumsA.begin(), psumsA.end());
    std::sort(psumsB.begin(), psumsB.end());
    
    int idxA = 0, idxB = psumsB.size()-1;
    while(idxA < psumsA.size() && idxB >= 0)
    {
        if(psumsA[idxA] + psumsB[idxB] > T) idxB--;
        else if(psumsA[idxA] + psumsB[idxB] < T) idxA++;
        else
        {
            int lo = idxA, hi = psumsA.size();
            while(lo + 1 < hi)
            {
                int mid = (lo + hi) / 2;
                if(psumsA[mid] <= psumsA[idxA]) lo = mid;
                else hi = mid;
            }
            long long cntA = hi - idxA;                         //idxA ttttt / hi fffff 경계값, hi - idxA ->갯수, hi값(f값)
            idxA = hi;
            
            lo = -1, hi = idxB + 1;
            while(lo + 1 < hi)
            {
                int mid = (lo + hi) / 2;
                if(psumsB[mid] < psumsB[idxB]) lo = mid;
                else hi = mid;
            }
            long long cntB = idxB - hi + 1;                     // fff../hi tttt idxB, idxB - hi + 1 -> 갯수, hi값(t값, -1시 f값)
            idxB = hi - 1;
            res += cntA * cntB;
        }
    }
    std::cout << res;
    return 0;
}
