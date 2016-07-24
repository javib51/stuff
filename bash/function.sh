#!/bin/bash

HELLO=Hello

function hello () {
	local HELLO=World
	echo $HELLO
	echo
	echo $@
}

echo $HELLO
#Way to send argumets
hello "aaa" "bbbb"




