#!/bin/bash

# 显示硬盘使用情况
echo "Hard Disk Usage:"
df -h

# 显示内存使用情况
echo -e "\nMemory Usage:"
free -h

# 显示CPU使用情况
echo -e "\nCPU Usage:"
top -b -n 1 | grep "Cpu(s)"

# 如果系统使用了 systemd，使用下面的命令显示 CPU 使用情况
# systemctl status cpu

# 如果系统使用了 systemd，使用下面的命令显示内存使用情况
# systemctl status memory

# 如果系统使用了 systemd，使用下面的命令显示硬盘使用情况
# systemctl status disk
