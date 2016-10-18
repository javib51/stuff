from distutils.core import setup
from Cython.Build import cythonize
from distutils.extension import Extension

ext_modules=[
    Extension("print_cython",
              sources=["print_cython.pyx"],
              libraries=["m"] # Unix-like specific
    )
]

setup(
  name = "print_cython",
  ext_modules = cythonize(ext_modules)
)
