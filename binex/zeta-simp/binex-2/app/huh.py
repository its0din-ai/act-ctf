#!/usr/bin/env python2
from __future__ import print_function
from random import randint
import subprocess, sys

class Unbuffered(object):
    def __init__(self, stream):
        self.stream = stream
    def write(self, data):
        self.stream.write(data)
        self.stream.flush()
    def writelines(self, datas):
        self.stream.writelines(datas)
        self.stream.flush()
    def __getattr__(self, attr):
        return getattr(self.stream, attr)
sys.stdout = Unbuffered(sys.stdout)

secret = randint(0, 666666)
print('46esaB Tool\nBy: Vestia Zeta 1337')
try:
    key = input("[>] Masukkan PIN: ")
    if key == secret:
        pwn = raw_input("Plaintek: ")
        enc = "echo '{0}' | base64 | rev".format(pwn)
        proc = subprocess.Popen(enc, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
        out = proc.communicate()[0]
        print("[*] Cipher: ", out)
    else:
        print("[-] Akses Ditolak! You need to SIMP Vestia Zeta first!")
except Exception:
    pass
