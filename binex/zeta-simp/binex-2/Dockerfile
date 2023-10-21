FROM ubuntu:20.04
RUN useradd -ms /bin/bash kobo 
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update && \
    apt-get install -y \
    python2 \
    xinetd && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* /etc/xinetd.d/*
WORKDIR /app
COPY ./app/huh.py .
COPY ./app/flag.txt /
COPY ./app/start.sh /usr/bin/start
COPY ./app/xinetd /etc/xinetd.d/xinetd
COPY ./app/run.sh ./run
RUN chmod +x .
RUN chown -R root:root /flag.txt
RUN chmod 444 /flag.txt
RUN chmod 500 /etc/xinetd.d/xinetd && chmod 500 /usr/bin/start && \
    chmod +x run
EXPOSE 13372
ENTRYPOINT ["/usr/bin/start"]