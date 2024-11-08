import sys
input = sys.stdin.read

# 문제의 요점 : 문자열들의 괄호가 짝을 제대로 이루고 있는가? -> stack 을 사용해서 쌓아뒀다가 짝을 만나면 꺼냄

def balance(s):
    stack=[]
    for char in s:
        if char == '(' or char == '[':
            stack.append(char)

        elif char == ')':
            if not stack or stack[-1] != '(':
                return "no"
            stack.pop()
        elif char == ']':
            if not stack or stack[-1] != '[':
                return "no"
            stack.pop()
        return "yes" if not stack else "No"
    
line = input().strip().splitlines()

for lines in line:
    if lines == ".":    # 종료 조건
        break
    print(balance(lines))