#!/bin/bash
socat -T60 TCP-LISTEN:13372,reuseaddr,fork EXEC:'python2 -u /app/huh.py'