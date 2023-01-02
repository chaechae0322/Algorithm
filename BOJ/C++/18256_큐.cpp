#include <stdio.h>

int q[2000001];
int back = -1;
int front = 0;

int main() {
	int n, val = 0;
	scanf("%d", &n);

	char command[20];
	for (int i = 0; i < n; i++) {
		scanf("%s", command);
		if (command[0] == 'p') {
			if (command[1] == 'u') {
				scanf("%d", &val);
				q[++back] = val;
			}
			else {
				printf("%d\n", (back - front) == -1 ? -1 : q[front++]);
			}
		} else if (command[0] == 's') {
			printf("%d\n", back - front + 1);
		} else if (command[0] == 'e') {
			printf("%d\n", (back - front) == -1 ? 1 : 0);
		} else if (command[0] == 'f') {
			printf("%d\n", (back - front) == -1 ? -1 : q[front]);
		} else if (command[0] == 'b') {
			printf("%d\n", (back - front) == -1 ? -1 : q[back]);
		}
	}
}
