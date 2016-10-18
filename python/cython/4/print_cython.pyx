cdef extern from "math.h":
    double sin(double x)

cdef extern from "stdlib.h":
    int atoi(const char *nptr)


def parse_charptr_to_py_int(string):
    #c->char* == python->byte[]
    return atoi(string.encode())

def f(x):
    return sin(x*x)


