#!/usr/bin/python3

from datetime import datetime as t
import random as r



def psort(size):
    size = 10**size
    l=[]
    for i in range(1,size):
        l.append(r.randrange(1,size))

    timep = t.now()
    l.sort()
    timep = (t.now() - timep).microseconds
    
    return timep/1e6

cdef 

if __name__=="__main__":

    print("Sort\nsize\tpython\tcython")

    for i in range(2,7):
        timep= psort (size)
    
        print("%s\t%s\t%s" %(size,timep,timec))
