#include <cstdio>
#include <string.h>

using namespace std;

int N;
int top = -1;
int arr[10000];

int main() {	
	scanf("%d", &N);

	char command[40];
	int x;
	for (int i = 0; i < N; i++) {
		scanf("%s", command);

		if (!strcmp(command, "push")) {
			scanf("%d", &x);
			arr[++top] = x;
		}
		else if (!strcmp(command, "pop")) {
			printf("%d\n", top == -1 ? -1 : arr[top--]);
		}
		else if (!strcmp(command, "size")) {
			printf("%d\n", top + 1);
		}
		else if (!strcmp(command, "empty")) {
			printf("%d\n", top == -1 ? 1 : 0);
		} 
		else if (!strcmp(command, "top")) {
			printf("%d\n", top == -1 ? -1 : arr[top]);
		}
	}
}
