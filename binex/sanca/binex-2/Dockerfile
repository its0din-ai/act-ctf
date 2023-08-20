FROM ubuntu:latest

RUN useradd -ms /bin/bash kobo

ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update && \
    apt-get install -y \
    python2 \
    socat && \
    rm -rf /var/lib/apt/lists/*

COPY ./app /app
COPY ./flag.txt /

RUN chmod +x /app/*
RUN chmod 444 flag.txt

USER kobo
EXPOSE 13372
ENTRYPOINT ["/app/entrypoint.sh"]