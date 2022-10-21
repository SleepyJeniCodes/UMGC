# Jennifer Tran
# BIFS 617 Assignment 3

# 1. A program that asks a user for a motif is found in the sequence or not

import re

def motif_search():

    file = input("Please enter a FASTA file: ") # ask for user input file
    seq = open(file, "r") # open file in read mode
    seq_read = seq.read() # read file

    search = re.search(motif, seq_read) # uses search function

    # if/else statement to check if motif exists
    if search: 
        print("The motif ," + motif + ", is found in file")
    else:
        print("Motif NOT found")

    seq.close() # close file
        
# ask for a motif to search for in all upper
motif = input("Please enter a motif to search for: ").upper()

# calls for the funtion
motif_search()

# 2. A program that calculates and prints the following information
# for each of the tissues
# a) Number of measurements (count)
# b) Average enzyme activity
# c) Maximum value in data set
# d) Minimum value in data set

# assign arrays
brain = [65, 69, 70, 63, 70, 68]
heart = [102, 95, 98, 110]
lung = [112, 115, 113, 109, 95, 98, 100]

# for loop to count number of elements in array
def measurements(array):
    count = 0
    for i in array:
        count = count + 1
    return count

# for loop to calculate the sum and divide by using len()
def average(array):
    total = 0
    for i in array:
        total = total + i

    avg = total/len(array)
    return avg

# for loop to find max value
def max_value(array):
    max_num = 0 
    for i in array:
        if i > max_num:
            max_num = i
    return max_num

# sort the list and returns the first number in the array
def min_value(array):
    array.sort()
    return array[:1]

# prints out the brain information
print("The number of measurements in the brain is:", measurements(brain))
print("The average enzyme activity in the brain is:", average(brain))
print("The maximum value in the brain is:", max_value(brain))
print("The minimum value in the brain is:", min_value(brain))

# prints out the heart information        
print("The number of measurements in the heart is:", measurements(heart))
print("The average enzyme activity in the heart is:", average(heart))
print("The maximum value in the heart is:", max_value(heart))
print("The minimum value in the heart is:", min_value(heart))

# prints out the lung information
print("The number of measurements in the lung is:", measurements(lung))
print("The average enzyme activity in the lung is:", average(lung))
print("The maximum value in the lung is:", max_value(lung))
print("The minimum value in the lung is:", min_value(lung))

