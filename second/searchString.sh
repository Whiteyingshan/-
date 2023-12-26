#!/bin/bash

# 检查输入参数是否正确
if [ "$#" -ne 3 ]; then
  echo "Usage: $0 <search_string> <input_file> <output_file>"
  exit 1
fi

# 提取命令行参数
search_string=$1
input_file=$2
output_file=$3

# 搜索指定内容并保存结果到新文件
grep -n "$search_string" "$input_file" > "$output_file"

# 输出结果到控制台
cat "$output_file"

echo "Search results saved to $output_file"
