#include <bits/stdc++.h>
struct Node
{
  int val;
  Node* left;
  Node* right;
  Node(int _val)
  {
    val = _val;
    left = right = nullptr;
  }
  virtual ~Node()
  {
    left = right = nullptr;
  }
};
struct Deque
{
  int size;
  Node* head;
  Node* tail;
  Deque()
  {
    size = 0;
    head = tail = nullptr;
  }
  virtual ~Deque()
  {
    while(head)
    {
      Node* next = head->right;
      delete head;
      head = next;
    }
  }
  void PushFront(int _val)
  {
    size++;
    Node* newNode = new Node(_val);
    if(head == nullptr && tail == nullptr)
    {
      tail = newNode;
      head = newNode;
      return;
    }
    head->left = newNode;
    newNode->right = head;
    head = newNode;
  }
  void PushBack(int _val)
  {
    size++;
    Node* newNode = new Node(_val);
    if(head == nullptr && tail == nullptr)
    {
      tail = newNode;
      head = newNode;
      return;
    }
    tail->right = newNode;
    newNode->left = tail;
    tail = newNode;
  }
  void PopFront()
  {
    if(size <= 0 || head == nullptr)
    {
      return;
    }
    size--;
    Node* del = head;
    head = head->right;
    if(head != nullptr)
      head->left = nullptr;
    else
      tail = nullptr;
    delete del;
  }
  void PopBack()
  {
    if(size <= 0 || tail == nullptr)
    {
      return;
    }
    size--;
    Node* del = tail;
    tail = tail->left;
    if(tail != nullptr)
      tail->right = nullptr;
    else
      head = nullptr;
    delete del;
  }
  int Size()
  {
    return size;
  }
  int Empty()
  {
    return size ? 0 : 1;
  }
  int Front()
  {
    return head == nullptr ? -1 : head->val;
  }
  int Back()
  {
    return tail == nullptr ? -1 : tail->val;
  }
};
int T, n;
std::string p, nums;
int main(void)
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> T;
  for(int t = 0; t < T; t++)
  {
    std::cin >> p >> n;
    std::cin >> nums;
    Deque dq;
    std::string num = "";
    for(int i = 1; i < nums.size(); i++)
    {
      if('0' <= nums[i] && nums[i] <= '9')
      {
        num += nums[i];
      }
      else
      {
        if(num.empty())
          continue;
        dq.PushBack(std::stoi(num));
        num.clear();
      }
    }
    bool rev = false;
    bool error = false;
    for(const auto& it : p)
    {
      if(it == 'R')
      {
        rev = !rev;
      }
      else
      {
        if(dq.Size() <= 0)
        {
          error = true;
          break;
        }
        else
        {
          if(!rev)
            dq.PopFront();
          else
            dq.PopBack();
        }
      }
    }
    if(error)
    {
      std::cout <<"error" <<'\n';
    }
    else
    {
      std::cout << '[';
      while(dq.Size() > 1)
      {
        if(!rev)
        {
          std::cout << dq.Front() << ',';
          dq.PopFront();
        }
        else
        {
          std::cout <<dq.Back() << ',';
          dq.PopBack();
        }
      }
      if(dq.Size() >= 1)
        std::cout << (!rev ? dq.Front() : dq.Back());
      std::cout << ']' << '\n';
    }
  }
  
  return 0;
}