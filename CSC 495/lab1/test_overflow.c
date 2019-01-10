#include <stdio.h>

void func(){
	printf("Secret.\n");
}

void echo(){
	char buffer[20];
	
	printf("Enter text:\n");
	scanf("%s", buffer);
	printf("You entered:\n%s");

}

int main (){
	
	echo();

	return 0;
}
