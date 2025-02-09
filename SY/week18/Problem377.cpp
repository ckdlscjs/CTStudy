#include <bits/stdc++.h>
using namespace std;
uint32_t common_prefix = 0xffffffff; //f(4자리 * 8개), ~0U로 대체가능(1111....)
std::string ip;
std::vector<uint32_t> ips; //입력된ip들
int N;
uint32_t ip_to_int(const std::string &ip) 
{
  uint32_t result = 0; //string을 uint32_t형 ip로 변환시킴
  std::stringstream ss(ip); //stringstream으로 string을 스플릿하여 segment단위로 분리하여 체크
  std::string segment;

  while (getline(ss, segment, '.')) //ss에서 '.'까지 입력받고 segment에저장시킴
    result = (result << 8) | std::stoi(segment);
  return result;
}

string int_to_ip(uint32_t num) 
{
  return 
  std::to_string((num >> 24) & 255) + "." + //앞8자리, &연산을 255(오른쪽8자리)만 하므로 끝 8자리만이남음
  std::to_string((num >> 16) & 255) + "." + //두번째8자리
  std::to_string((num >> 8) & 255) + "." + //세번째 8자리
  std::to_string(num & 255);
}

int main() 
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  cin >> N;
  // 최소 공통 프리픽스 찾기
  for (int i = 0; i < N; i++) 
  {
    std::cin >> ip;
    ips.push_back(ip_to_int(ip));
    common_prefix &= ips[i];
  }

  // 네트워크 마스크 찾기
  int mask_bits = 32;
  uint32_t diff = 0;
  for (int i = 0; i < N; i++) 
    diff |= (ips[i] ^ common_prefix);  // 달라진 비트를 찾기, 끝자리에 달라진비트들이모인다
  while (diff) 
  {
    mask_bits--;
    diff >>= 1;
  }

  uint32_t netmask = mask_bits == 0 ? 0 : (~0U << (32 - mask_bits)); //32-비트수 하여 좌측시프트해서 마스크를 구함
    
  // 결과 출력
  cout << int_to_ip(common_prefix & netmask) << '\n';
  cout << int_to_ip(netmask);

  return 0;
}