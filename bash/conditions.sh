#!/bin/bash

if [ "foo" == "foo" ]; then
	echo expression evaluated as true
fi

arg1=$1

if [[ -n "$arg1" ]]; then
	echo "$1=$( date +%s )"  
else
    echo "Error: argument error" 1>&2
fi


echo "arguments $@"

if [ 1 == 1 ] && [ 3 != 1 ]; then	
	echo "Conditions work"
else
	echo "Conditions dont work"
fi
