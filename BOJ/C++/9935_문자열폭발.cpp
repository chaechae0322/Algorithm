#include <stdio.h>

char input[1000001];
char bump[37];
char stack[1000001];
int match[1000001] = { 0, };
int top = -1;

void explosion(int length) {
	for (int i = 0; i < length; i++)
		top--;
}

int getLength(char str[], int N) {
	int size = 0;
	for (int i = 0; i < N; i++) {
		if ((str[i] >= 48 && str[i] <= 57) || (str[i] >= 65 && str[i] <= 90)
			|| (str[i] >= 97 && str[i] <= 122)) {
			size++;
		}
		else {
			break;
		}
	}
	return size;
}

int main() {
	scanf("%s", &input);
	scanf("%s", &bump);

	int bumpSize = getLength(bump, 37);
	int inputSize = getLength(input, 1000001);

	int matchPos = 0;

	for (int i = 0; i < inputSize; i++) {
		matchPos = top == -1 ? 0 : match[top];

		stack[++top] = input[i];

		if (stack[top] == bump[matchPos]) {
			matchPos++;
		} else if (stack[top] == bump[0]) {
			matchPos = 1;
		} else {
			matchPos = 0;
		}

		match[top] = matchPos;

		if (matchPos == bumpSize) {
			explosion(bumpSize);
			matchPos = 0;
		}
	}

	if (top == -1) {
		printf("FRULA\n");
	}
	else {
		for (int i = 0; i <= top; i++) {
			printf("%c", stack[i]);
		}
		printf("\n");
	}
}
