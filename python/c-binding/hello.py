def say_helo_to(name):
    print("Hello %s" %name)

"""
Convert to c --->  cython3 -a hello.py
Compile      --->  gcc -shared -pthread -fPIC -fwrapv -O2 -Wall -fno-strict-aliasing \
      -I/usr/include/python3.5 -o hello.so hello.c

"""
