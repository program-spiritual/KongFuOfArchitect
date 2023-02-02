from setuptools import setup

setup(
    name='demo_package',
    version='0.1.0',
    author='An Awesome Coder',
    author_email='aac@example.com',
    packages=['demo_package', 'demo_package.test'],
    scripts=['bin/script1','bin/script2'],
    url='http://pypi.python.org/pypi/PackageName/',
    license='LICENSE.txt',
    description='An awesome package that does something',
    long_description=open('README.txt').read(),
    install_requires=[
        "Django >= 1.1.1",
        "pytest",
    ],
)
