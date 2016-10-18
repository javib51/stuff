from libc.stdio cimport printf
from libc.math cimport sin
from libc.stdlib cimport atoi
#cdef extern from *:
#    ctypedef char const_char "const char"

#cdef p(const char* c_string):
    #cdef bytes py_bytes = string.encode()
    #cdef char* c_string = py_bytes
    #printf(c_string)


cdef parse_charptr_to_py_int(char* s):
    assert s is not NULL, "byte string value is NULL"
    return atoi(s)


cdef double f(double x):
    return sin(x*x)

cdef extern from "math.h":
    cpdef double sin(double x)
