#include <stdlib.h>
#include <stdio.h>

int main() {
    int makanan = 0x313337FF;
    char buf[40];

    printf("minta mkn bang, 7 hari blm mkn: ");
    fflush(stdout);
    fgets(buf, 45, stdin);

    if ((makanan == 0x313337FF) && (makanan != 0xDEADFACE))
        printf("\ngk enak, gw maunya: [%p]\n", (void*)makanan);
        fflush(stdout);

    if ((makanan != 0x313337FF) && (makanan != 0xDEADFACE))
        printf ("\nNah, [%p] ini ok lah yaaa.\ntapi gw masih kurang suka sih\n", (void*)makanan);
        fflush(stdout);

    if(makanan == 0xDEADFACE)
    {
        printf("\n-----------------\nNgeriiii gg lu banh,\ntau aja apa yg gw suka.\nNih, flag buat lo:\n");
        fflush(stdout);
        system("cat flag.txt");
        fflush(stdout);
        printf("\nBye.!\n\n\n");
        fflush(stdout);
    }
    return 0;
}