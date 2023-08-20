#!/usr/bin/env python2
from __future__ import print_function
from random import randint

secret = randint(0, 100000000)
try:
    print("Selamat Datang di portal layanan Kobo Kanaeru")
    print("[>] Masukkan PIN: ", end="")
    key = input()
    if key == secret:
        print("[-] Akses Ditolak! Ayo jgn nyerah")
    else:
        print("[-] Akses Ditolak!")
except Exception:
    pass
