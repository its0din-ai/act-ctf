#include <stdio.h>
#include <stdlib.h>

int main() {
    int lockbitDecrypt[] = {65,67,84,67,84,70,123,101,53,98,50,48,55,97,55,97,54,49,99,54,52,48,99,98,101,51,98,55,98,52,101,56,56,57,51,98,98,57,48,125};
    int *input = (int *)malloc(sizeof(int) * 69);
    int i = 0;

    if (input == NULL) {
        printf("Mau ngehek bang?\n");
        return 1;
    }

    printf("LOCKBIT RANSOMWARE V.69\n"
           "Masukkan password untuk decrypt data: ");
    while (1) {
        int c = getchar();
        if (c == '\n' || c == EOF) {
            break;
        }
        input[i] = c;
        i++;
    }

    int match = 1;
    if (i != sizeof(lockbitDecrypt) / sizeof(lockbitDecrypt[0])) {
        match = 0;
    } else {
        for (int j = 0; j < i; j++) {
            if (input[j] != lockbitDecrypt[j]) {
                match = 0;
                break;
            }
        }
    }

    if (match) {
        printf("Makasih dah bayar decryptor pake BTC\n");
    } else {
        printf("Password SALAH!\nFile akan dipublish 69 JAM Lagi!\n");
    }
    
    free(input);

    return 0;
}
