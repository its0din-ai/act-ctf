#!/bin/bash
socat -T60 TCP-LISTEN:13371,reuseaddr,fork EXEC:./fubuki 2>/dev/null