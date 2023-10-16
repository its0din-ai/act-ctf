FROM ubuntu:22.04

RUN useradd -ms /bin/bash kobo 

ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update && \
    apt-get install -y \
    python2 \
    xinetd && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* /etc/xinetd.d/*

WORKDIR /app

COPY ./app .
COPY ./flag.txt /
COPY ./start.sh /usr/bin/start
COPY ./xinetd /etc/xinetd.d/xinetd
COPY ./run.sh ./run

RUN chmod +x .
RUN chown -R root:root /flag.txt
RUN chmod 444 /flag.txt
RUN chmod 500 /etc/xinetd.d/xinetd && chmod 500 /usr/bin/start && \
    chmod +x run

EXPOSE 13372
ENTRYPOINT ["/usr/bin/start"]