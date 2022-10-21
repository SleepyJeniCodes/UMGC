# Group 7 Project #
# Jennifer Tran
# Kelly Wilson
# Wei-Hsien (Alicia) Yang
# Christa Yuekelsoy

# This program will split a given sequence into 6 different reading frames. #

######################################### Methods #####################################
# Import required modules #
import re

# Define Functions #
#===========================================================
# Wei-Hsien Yang's section #

# Define frame 1:
# frame1 starts at index position 0 with 3 base codon.
# First codon of frame 1 will have position index of 0 to 3(not inclusive at 3).
# Second codon will start at pos 3:6.

# Define a function to get frame:
def findFrame(sequence, start_pos):
    frame = ""
    # add starting bases to each frame based on starting position.
    # If starting position is at begining of sequence, add nothing to beginning.
    # If starting position is second base position, then add first base position followed by " "
    # If starting position is third base, then add first and second bases followed by " ".
    # This will help find position of codons at the end.
    if start_pos == 0:
        frame = ""
    elif start_pos == 1:
        frame += sequence[0] + " "
    elif start_pos == 2:
        frame += sequence[0:2] + " "
    # for each start position until end of sequence, get the 3-base codons and add to frame string:
    for start in range(start_pos, len(sequence), 3):
        frame += sequence[start:start+3] + " "
    return frame

# Define function to get reverse complement sequence:
def getRevComp(sequence):
    comp = sequence.upper()
    comp = comp.replace("A", "t").replace("C","g").replace("G","c").replace("T","a")
    revcomp = comp[::-1].upper()
    return revcomp
    
# Put these functions together to get frames #
def getAllFrames(sequence):
    frames = {}
    frames['1'] = findFrame(sequence,0)
    frames['2'] = findFrame(sequence,1)
    frames['3'] = findFrame(sequence,2)
    revcomp = getRevComp(sequence)
    frames['4'] = findFrame(revcomp,0)
    frames['5'] = findFrame(revcomp,1)
    frames['6'] = findFrame(revcomp,2)
    return frames

# End of Wei-Hsien Yang's functions #

#===========================================================
# Kelly Wilson's section #
#Method to determine the ORF:
def identify_coding(header, frame, frame_num, og_end, min_ORF):
    
#Determines if the start codon is present:
    # for match in matches:
    if re.search(r"ATG([ ATGC]+)(TAA|TAG|TGA)", frame):
        # initialize list to save outputs:
        output_list = ""
       
#Identifies start of the start codon
        x = re.search(r"ATG", frame)
        x_start = x.start()
        orig_framelen = len(frame)
        
#Creates new sequence starting at start codon
        codingstart = frame[x_start:orig_framelen]

#Identifies where the end of the stop codon is located 
        y = re.search(r"(TAA|TAG|TGA)", codingstart)
        y_start = y.start()
        y_end = int(y_start) + 3 + int(x_start)

#Determines coding sequence based on start of start codon and end of stop codon
        coding = frame[x_start:y_end]
        
#Removes the whitespace between characters and calculates length of coding sequence
        coding2 = coding.replace(' ', '')
        coding_length = len(coding2)
        
#Removes whitespace from original frame
        frame_format = frame.replace(' ', '')

#Calculates the coding start position (without whitespaces)         
        match = re.search(coding2,frame_format)
        match_start = int(match.start()) + 1 + og_end
        match_end = int(match.end())       
    
#If the frame number is 4,5, or 6, then the start of the ORF should be negative:
        if 4 <= frame_num <= 6:
            match_start = match_start * (-1)

#Determines if the ORF length meets the minimum length:
        
        if coding_length >= min_ORF:
            
            headerlist.append(header)
            framelist.append(frame_num)
            positionlist.append(match_start)
            lengthlist.append(coding_length)
            sequencelist.append(coding)

#Creates a new search frame to determine if there is another coding sequence after the first.
        next_set = frame[y_end:orig_framelen]

#Assigns the same header to the next coding sequence.
        header2 = header

#Calls on function to determine if there is another coding sequence after the first one.
        identify_coding(header2, next_set, frame_num, match_end, min_ORF)
    
# End of Kelly Wilson's functions.

#===========================================================================
# Christa's code:
def output():
    
    total = len(framelist)
    
    for i in range(0, len(framelist), 1):
        seqlist = sequencelist[i]
        n=60
        print("\n" + headerlist[i] + "|" + " FRAME = " + str(framelist[i]) + "|" + " POS = " + \
            str(positionlist[i]) + "|" + " LEN = " + str(lengthlist[i]) )

        for position in range(0, len(seqlist), n):
            print(seqlist[position:position+n])
  

#=============================================================================
# Define the main function for script:
def main():
    
    # Integrate Jennifer Tran section #
    
    # create empty dictionary
    DNA_dict = {}
    # user input for file
    file = input("Please enter a file that contains DNA sequences in the FASTA format: ")
    # open file in reading mode
    file_seq = open(file, 'r')
    
    # uses a for loop to separate the header from the sequences and add to dictionary
    for line in file_seq:
        if line.startswith(">"): # if header 
            key = line.strip() # removes white spaces front & back
            DNA_dict[key] = ""
        else:   # if seq, removes all white spaces and add to dictionary
            stripped_line = line.strip() # removes white spaces in front & back
            stripped_line = stripped_line.replace(" ", "").replace("\n", "").replace("\r", "").upper()
            DNA_dict[key] = DNA_dict[key] + stripped_line # add to dictionary

    # ask for user input for min number of ORFs
    num_orf = int(input("Please enter the minimum number of ORFs to search for: "))

    # set a default value for ORFs less than 50
    if num_orf <= 50:
        num_orf = 50

    # Integrate Wei-Hsien Yang's section #
    # for each fasta sequence:
    for seq in DNA_dict.keys():
        # get the sequence to translate into frames and store in tmp:
        tmp = DNA_dict.get(seq)
        # get all the reading frames for the tmp sequence:
        frames = getAllFrames(tmp)

        # Integrate Kelly Wilson's section:
        #Assigns the header for each sequence:
        header = seq
        
        #Loop through each frame and identify the ORF regions:
        for key, value in frames.items():
            
            #Call function to identify ORF regions:
            identify_coding(header, value, int(key), 0, num_orf)

    # Integrate Christa's section:
    # Print out final output:        
    output()
            
################################################################################
# Run program:
# Initialize lists required:
headerlist = []
framelist = []
positionlist = []
lengthlist = []
sequencelist = []

# execute main function:
main()

