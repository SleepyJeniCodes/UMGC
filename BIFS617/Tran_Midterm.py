# Jennifer Tran 9/28/2021
# BIFS 617 Midterm Exam

import os

# 1. A program that print out to to files the coding and non-coding regions of the sequence
# open file
file = open("genomic_dna.txt")

# read file and stores as a variable
dna_seq = file.read()

coding_file = open("coding.txt", "w") #open file in write mode
coding_file.write(dna_seq[0:63])
coding_file.write(dna_seq[90:])

noncoding_file = open("non_coding.txt", "w") #opens file in write mode
noncoding_file.write(dna_seq[63:90])

# close files
file.close()
coding_file.close()
noncoding_file.close()

# 2. A program that calculates the percentage of the sequence is coding
total = len(dna_seq) # length of sequence
coding_file = open("coding.txt")
coding_seq = coding_file.read()
coding = len(coding_seq)
percentage = float(coding) / float(total) * 100
print("The percentage of the sequence that is coding is: ", percentage, "%\n\n")

#3. A program that write out fasta files
import re

sequences = open("sequences.txt")
accession = open("AccessionNumbers.txt")

for i in range(3):
    seq = sequences.readline().strip()
    access = accession.readline().strip()
    file = open(access+".txt", "w")
    file.write(">" + access + "\n")
    file.write(re.sub(r'[^A-Za-z0-9]', '', seq.upper()))
    file.close()

# 4. A program that checks to see if 2 DNA sequences given are reverse complements of one another
print("This program is used to check if the given DNA sequences are reverse complements of one another")
dna_1 = str(input("Please input a DNA sequence: ")).upper()
dna_2 = str(input("Please input a DNA sequence: ")).upper()
out = ""

complement = dna_2[::-1] #reverses the sequence

# prints out the complement DNA for dna_1
for i in dna_1:
    if i == 'A':
        out += 'T'
    elif i == 'T':
        out += 'A'
    elif i == 'G':
        out += 'C'
    else:
        out += 'G'

# Checks if the 2 are equivalent to one another
if complement == out:
    print("The 2 given DNA are reverse complements of one another")
else:
    print("The 2 given DNA are NOT reverse complements of one another")

# 5. A program that reads a file and prints its lines the reverse order

user_file = open(input("Please input a file name: "), "r") #gets file from user input and reads file
read = user_file.readlines() #reads each line
reverse = reversed(read) #reverses the lines

# uses a for loop to print each line in the reverse order
for i in reverse:
    print(i.rstrip())

user_file.close() #close file

# 6. A program that predicts the size of population of organisms
print("\n\n")
# ask user for starting number or organisms
organisms = int(input("Please enter a starting number of organisms: "))

# input validation for number of organisms
while organisms < 2:
    print("ERROR: Starting number of organims need to be at least 2")
    organisms = int(input("Please enter a starting number of organisms: "))

# ask user for daily population increase
daily = float(input("Please enter the average daily increase (as a percentage): "))
daily_percent = daily * 0.01

# input validation for daily population increase
while daily < 0:
    print("ERROR: Daily increase must be a positive number")
    daily = int(input("Please enter the average daily increase (as a percentage): "))

# ask user for number of days multiply
days = int(input("Please enter the number of days they will multiply: "))

# input validation for days multiply
while days < 1:
    print("ERROR: Number of days must be more than 1")
    days = int(input("Please enter the number of days they will multiply: "))

# output
print("Day     Organisms")
print("-----------------------------")

for i in range (1, days + 1):
    print(i, "\t", organisms)
    organisms = organisms + (daily_percent * organisms)

# 7. A program that takes entered lines from the keyboard and stores them in an array
# program prints out all lines sorted when user enters quit
print("\n\n")
user_array = [] # create empty list
print("This program allow you to store your input into an array.")
print("Please enter 'quit' to print out all the lines sorted.")
# ask for user input
user_input = input("Please enter a line to store into an array: ")
user_array.append(user_input)

# use while loop to continue asking for user input
while user_input != "quit":
    user_input = input("Please enter a line to store into an array: ")
    user_array.append(user_input)
    user_array.sort() # sort list

# print sorted list
print(user_array)

# 8. Modifies the above to print out number of lines entered
# count number of elements in list
array_count = len(user_array)
print("The number of lines entered is: ", array_count)

# print line 2-4
print(user_array[1:4])

# 9. A program that list sequence lengths, separated by whitespace, and stores as 1 string

lengths = input("Please enter a list of sequence lengths separated by white space: ")
length = lengths.split()

total = 0
for i in length:
    total += int(i)

average = total/len(length)
print("The average of the list of sequence lengths is", average)


# 10. A program that ask for the number of calories and fat grams in a food item
# user input for number of calories in food item
calories = float(input("Please enter the number of calories in a food item: "))

# user input for fat grams in food item
fat = float(input("Please enter the number of fat grams in a food item: "))

# converts fat grams into calories
fatcal = fat * 9

# calculate percentage of calories from fat
total = fatcal/calories

# if/else to determine validity of calories and fat grams
if fatcal > calories:
    print("ERROR: the input is invalid")
elif fatcal < 0.3 * calories:
    print("Food is low in fat")
    
print("The total calories from fat is: ", total, "%")
