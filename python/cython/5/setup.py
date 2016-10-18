from distutils.core import setup
from Cython.Build import cythonize
from distutils.extension import Extension

ext_modules=[
    Extension("cfib_wrapper",
              sources=["cfib.c","cfib_wrapper.pyx"],
              libraries=["m"] # Unix-like specific
    )
]

setup(
  name = "cfib_wrapper",
  ext_modules = cythonize(ext_modules)
)
