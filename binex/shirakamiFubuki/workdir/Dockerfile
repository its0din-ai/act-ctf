# Use a 32-bit Ubuntu base image
FROM i386/ubuntu:18.04

# Install necessary packages
RUN apt-get update && apt-get install -y build-essential gcc-multilib

# Set the working directory
WORKDIR /app

# Copy your source code into the container
COPY shirakami.c /app/

# Compile the source code with the desired flags
RUN gcc -m32 -fno-stack-protector -o fubuki shirakami.c
RUN gcc -m32 -fno-stack-protector -static -o fubuki-static shirakami.c

# Copy the binary to the /app directory so it can be accessed from outside the container

# Clean up unnecessary build packages
RUN apt-get remove -y build-essential && apt-get autoremove -y

# Define an entry point to run any custom scripts if needed
# ENTRYPOINT ["/app/your-entry-script.sh"]

# When you run the container, the binary will be available at /app/fubuki
# You can mount a volume to copy it to your local machine
