#include <cstdlib>
#include <iostream>
#include <map>
#include <stdio.h>
#include <vector>
#include<bits/stdc++.h>
#include <ctype.h>
#include <list>
#include <stack>
#include <queue>
#include <string.h>
#include <iomanip>
#include <string>
#include <algorithm>
#include <cmath>
#define _CRT_SECURE_NO_DEPRECATE
#define INF 1000000000
#define Set(a, s) memset(a, s, sizeof (a))
#define forpos(i,j,k) for (int i=0 ; i<j ; i+=k)
#define forneg(i,j,k) for (int i=j ;i>=0 ;i-=k)
#define upcase(x) transform(x.begin(), x.end(), x.begin(), ::toupper)
#define locase(x) transform(x.begin(), x.end(), x.begin(), ::tolower)
#define PI 3.14159265358979323846
#define VISITED 1
#define UNVISITED -1
#define pf printf
#define SSTR( x ) dynamic_cast< std::ostringstream & >( \
       ( std::ostringstream() << std::dec << x ) ).str()


using namespace std;

typedef long long ll;
typedef std::pair<int,int> ii;
typedef std::pair<std::string,int> si;
typedef vector<int> vi;
typedef vector<ii> vii;





    int arr [501][501];
    int N , M;
     int BS_ROW (int row , int num)
    {
        int lo = 0 , hi = M - 1;
        int lastFound = 502;
        for (int i = 0 ; i < 9 ; ++i)
        {
            int mid = lo + ((hi - lo) >> 1);
            if (arr[row][mid] >= num)
            {
                lastFound = min(lastFound , mid);
                hi = max(mid - 1 , lo);
            }
            else lo = min(mid + 1 , hi);
        }
        return lastFound == 502 ? -1 : lastFound;
    }

    int BS_DIAG (int rowNum , int colNum , int L , int U)
    {
        int loCol = colNum , hiCol = colNum + min(N - rowNum - 1 , M - colNum - 1);
        int loRow = rowNum , hiRow = rowNum + min(N - rowNum - 1 , M - colNum - 1);
        int lastCol = -1 ;
        for(int i = 0 ; i < 9 ; ++i)
        {
            int midCol = loCol + ((hiCol - loCol) >> 1) , midRow = loRow + ((hiRow - loRow) >> 1);
            if (arr[midRow][midCol] >= L && arr[midRow][midCol]<= U)
            {
                lastCol = max(lastCol , midCol);
                loRow= min(midRow + 1 , hiRow);
                loCol= min(midCol + 1 , hiCol);
            }
            else if (arr[midRow][midCol] > U)
            {
                hiRow = max(midRow - 1 , loRow);
                hiCol = max(midCol - 1 , loCol);
            }
        }
        return lastCol;
    }
    int main (){

        while(true)
        {
            cin >> N >> M;
            if(N == 0 && M ==0) break;
            for(int i = 0; i < N ; ++i) for(int j = 0 ; j < M ; ++j) cin >> arr[i][j] ;
            int Q ; cin >> Q;
            while (Q --)
            {
                int L , U; cin >> L >> U;
                int mx = 0;
                for (int i = 0 ; i < N ; ++i)
                {
                    int idx_row = BS_ROW(i , L);
                    if (idx_row == -1 || arr[i][idx_row] > U) continue;
                    int idx_diag = BS_DIAG(i , idx_row , L , U);
                    mx = max(idx_diag - idx_row + 1 , mx);
                }
                printf("%d\n" , mx);
            }
            printf("-\n");
        }
       return 0;
    }



