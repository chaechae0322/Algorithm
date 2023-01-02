#include <stdio.h>

char lights[100001];
int N, K = 0;
int q[100001];
int front = 0, back = -1;

bool isEmpty() {
	return (back - front) == -1 ? true : false;
}

void pop() {
	front++;
}

void push(int idx) {
	q[++back] = idx;
}

int turnOffTheLights() {
	int answer = 0;

	for (int idx = 0; idx < N; idx++) {
		if (isEmpty() == false && idx > q[front]) {
			pop();
		}

		int isSwitch = (back - front + 1) % 2;
		if (isSwitch == 1) {
			if (lights[idx] == '1')
				lights[idx] = '0';
			else
				lights[idx] = '1';
		}

		if (lights[idx] == '1') {
			push(idx+K-1);
			lights[idx] = '0';
			answer++;
		}
	}

	if (isEmpty() == false && q[front] == N - 1) {
		pop();
	}

	int size = (back - front + 1);

	return size == 0 ? answer : -1;
}

int main() {
	char flush;
	scanf("%d %d", &N, &K);
	scanf("%c", &flush);

	int zeroCount = 0, oneCount = 0;
	for (int i = 0; i < N; i++) {
		scanf("%c", &lights[i]);
		scanf("%c", &flush);
	}

	int answer = turnOffTheLights();

	if (answer == -1) {
		printf("Insomnia\n");
	} else {
		printf("%d\n", answer);
	}
}
