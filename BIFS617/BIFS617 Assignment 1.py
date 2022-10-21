# Jennifer Tran 9/7/2021
# BIFS 617 Advanced Bioinformatics
# Assignment 1

# 1. A program that produces the following text as exactly as it is 

print("What is the difference between \n"
      "a \' and a \"? Or between a \" and a \\\"?")
print()
print("One is what we see when we're typing our program. \n"
      'The other is what appears on the "console."')
print()

# 2. A program that transcribes DNA to RNA.
print("This program transcribes DNA to RNA")
print()
# A string that stores user input for DNA
DNA = input("Please enter a DNA: ")
RNA = ""
    
# Transcribes DNA to RNA by substitution    
RNA = DNA.replace("T", "U")

# Prints the user's DNA and the transcibed RNA 
print("Your DNA is: " + DNA)
print("Your RNA is: " + RNA)

# 3. A program that calculates the AT and GC content
print()
print("This program is used to calculate the AT and GC content of your DNA sequence")
print()
dnaSequence = input("Please enter a DNA sequence: ")

# 'ATGC' starts at 0 
A = 0
T = 0
G = 0
C = 0

# Use the following for loop and if statement to count each base
for x in dnaSequence:
    if "A" in x:
        A += 1
    elif "T" in x:
        T += 1
    elif "G" in x:
        G += 1
    elif "C" in x:
        C += 1

# Counts the number of bases in the sequence using len()
sequenceLength = len(dnaSequence)

# Calculates the AT and GC content and returns a percentage value
GC = str((G+C)*100/(sequenceLength)) + '%'
AT = str((A+T)*100/(sequenceLength)) + '%'

# Prints the results of dnaSequence
print ("The GC content of the DNA sequence given is: ", GC)
print ("The AT content of the DNA sequence given is: ", AT)

