FROM ubuntu:20.04

ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update && \
    apt-get install -y \
    gcc \
    build-essential \
    socat \
    gcc-multilib && \
    rm -rf /var/lib/apt/lists/*

COPY ./fbk /
RUN chmod +x entrypoint.sh
RUN gcc -m32 -fno-stack-protector -o fubuki shirakami.c

EXPOSE 13371
ENTRYPOINT ["./entrypoint.sh"]