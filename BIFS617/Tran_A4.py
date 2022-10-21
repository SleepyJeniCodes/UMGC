# Jennifer Tran
# BIFS 617
# Assignment 4

# A program that test for an AT repeat
# A repeat of AT as 3 or more occurrences
# Uses Test.txt as the test file

import os
import re

def AT_repeats():
    file = open("Test.txt")

    # skip first line of file
    next(file)
    seq = ""
    for line in file:
        seq += line.rstrip()

    ATrepeats = "ATATAT" in seq
    if ATrepeats:
        print("AT repeat exists")
    else:
        print("AT repeat does not exists")

    
AT_repeats()

# A program that parse out EMBL id, description, and sequence

def embl():
    emblfile = open("EMBL_records.txt")

    in_seq = False
    
    for line in emblfile:
        line = line.rstrip()
        if line.startswith("ID"):
            print(line)
        elif line.startswith("DE"):
            print(line)
        elif line.startswith("//"):
            in_seq = False
        elif line.startswith("SQ") or in_seq:
            in_seq = True
            print(line)
embl()


