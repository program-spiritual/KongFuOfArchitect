#!/usr/bin/env python

"""
A really simple module, just to demonstrate packaging
"""

from pathlib import Path


def load_special_words(data_file_name, words=None):
    """
    Loads the special words (those that don't get capitalized)
        
    from the data file in the package

    data file is a text file with one work per line
    the # charactor is a comment -- everything after it will be ignored

    """
    words  = set() if words is None else words
    with open(data_file_name) as data_file:
        for line in data_file:
            word = line.split('#')[0].strip()
            if word:
                words.add(word.lower())
    return words

def get_datafile_name():
    """
    return the default data file that comes with the package
    """
    return Path(__file__).parent / "cap_data.txt"

## load up the special words on import
special_words = load_special_words(get_datafile_name())

def capitalize_line(instr, special_words=special_words):
    """
    capitalizes the input string

    :param instr: the string to capitalize it should be a single sentence.
    :type instr: string

    :param special_words: set of words that should not be capitalized
                          defaults to the words in the encosed data file
    :type special_words: set of str

    :returns: a capitalized version of instr
    """
    new_words = []
    for word in instr.split():
        new = word.capitalize() if word not in special_words else word
        new_words.append(new)
    # capitalize the first word:
    
    if new_words:
        new_words[0] = new_words[0].capitalize()
    return " ".join(new_words)

    # return " ".join(word.capitalize() for word in instr.split()
    #                 if word not in special_words)


def capitalize(infilename, outfilename):
    """
    reads the contents of infilename, and writes it to outfilename, but with
    every word capitalized

    note: very primitive -- it will mess some files up!

    this is called by the capitalize script

    :param infilename: The file name you want to process
    :type infilename: string

    :param outfilename: the name of the new file that will be created
    :type outfilename: string

    :returns: None

    :raises: IOError if infilename doesn't exist.
    """
    infile = open(infilename, 'U')
    outfile = open(outfilename, 'w')

    for line in infile:
        outfile.write(capitalize_line(line))
        outfile.write("\n")

    return None

