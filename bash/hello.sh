#!/bin/bash
echo "Hello with echo
"
echo "Hello World"

echo "
Hello with variables
"

str="Hello World!"
echo $str


echo "
Use variables creating it implicitly
"

OF=/var/my-backup-$(date +%d%m%Y).tar
echo $OF
