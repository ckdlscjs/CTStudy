#pragma once
#include <bits/stdc++.h>

int main(void)
{
	std::ios::sync_with_stdio(false);
	std::cin.tie(0);
	std::cout.tie(0);
	std::string str = "a";
	while (std::cin >> str && str != "0")
	{
		bool palin = true;
		for (int i = 0; i < str.size() / 2; i++)
		{
			palin = str[i] == str[str.size() - 1 - i];
			if (!palin)
				break;
		}
		std::cout << (palin ? "yes" : "no") << '\n';
	}
	return 0;
}