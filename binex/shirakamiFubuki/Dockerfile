FROM ubuntu:20.04
RUN useradd -ms /bin/bash fubuki 
ENV DEBIAN_FRONTEND=noninteractive
RUN dpkg --add-architecture i386 && \
    apt-get update && \
    apt-get install -y \
    libc6:i386 libncurses5:i386 libstdc++6:i386 xinetd && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* /etc/xinetd.d/*
WORKDIR /app
COPY ./app/fubuki .
COPY ./app/flag.txt /
COPY ./app/start.sh /usr/bin/start
COPY ./app/xinetd /etc/xinetd.d/xinetd
COPY ./app/run.sh ./run
RUN chmod +x .
RUN chown -R root:root /flag.txt
RUN chmod 444 /flag.txt
RUN chmod 500 /etc/xinetd.d/xinetd && chmod 500 /usr/bin/start && \
    chmod +x run
EXPOSE 13370
ENTRYPOINT ["/usr/bin/start"]