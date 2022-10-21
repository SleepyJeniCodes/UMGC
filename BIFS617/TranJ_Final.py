# Jennifer Tran
# BIFS 617 Final
# November 7, 2021

import os
import re

# 1. A program that asks for a file containing a FASTA
# nucleotide sequence

def sequence():
    user_file = input("Please enter a file containing a FASTA nucleotide sequence: ")
    FASTA_file = open(user_file)

    if FASTA_file.readline()[0] != ">" :
        print("INVALID FASTA FILE")
    else:
        next(FASTA_file) # skip first line of file
        seq = "" # empty string
        for line in FASTA_file:
            seq += line.rstrip()

    return seq


def composition(seq):
    # Assign count of bases
    A = 0
    T = 0
    G = 0
    C = 0
    N = 0

    # use for loop and if-elif to count each bases
    for i in seq:
        if 'A' in i:
            A += 1
        elif 'T' in i:
            T += 1
        elif 'G' in i:
            G += 1
        elif 'C' in i:
            C += 1
        else:
            N += 1
    composition = print("There are ", A, " A's, ", T, " T's, ", G, " G's, ", C, " C's, and ", N, " N's")

    return composition

def AT_content(seq):
    float_AT = (seq.count('A') + seq.count('T'))/len(seq)
    AT = print("The AT content of the sequence is", float_AT * 100,'%')
    
    return AT

def GC_content(seq):
    float_GC = (seq.count('G') + seq.count('C'))/len(seq)
    GC = print("The GC content of the sequence is", float_GC * 100,'%')
    
    return GC

def DNA_complement(seq):
    comp = ""

    # use for loop and if-elif to count each bases
    for i in seq:
        if i == 'A':
            comp += 'T'
        elif i == 'T':
            comp += 'A'
        elif i == 'G':
            comp += 'C'
        elif i == 'C':
            comp += 'G'
    
    return comp

def reverse_complement(seq):
    sequence = DNA_complement(seq)
    reverse = sequence[::-1]

    return reverse

seq = sequence()
composition(seq)
AT_content(seq)
GC_content(seq)
print("The DNA complement is: ")
print(DNA_complement(seq))
print("The reverse complement is: ")
print(reverse_complement(seq))

###################################################################
# 2. A program that ask user to select a frame and find the translation
# of that frame

def rna_seq(seq):
    rna = ''

    for i in seq:
        if i == 'A':
            rna += 'U'
        elif i == 'T':
            rna += 'A'
        elif i == 'G':
            rna += 'C'
        elif i == 'C':
            rna += 'G'

    return rna

    
protein_dict = {
    'UUU':'F', 'UUC':'F', 'UUA':'L', 'UUG':'L',
    'UCU':'S', 'UCC':'S', 'UCA':'S', 'UCG':'S',
    'UAU':'Y', 'UAC':'Y', 'UAA':'*', 'UAG':'*',
    'UGU':'C', 'UGC':'C', 'UGA':'*', 'UGG':'W',
    'CUU':'L', 'CUC':'L', 'CUA':'L', 'CUG':'L',
    'CCU':'P', 'CCC':'P', 'CCA':'P', 'CCG':'P',
    'CAU':'H', 'CAC':'H', 'CAA':'Q', 'CAG':'Q',
    'CGU':'R', 'CGC':'R', 'CGA':'A', 'CGG':'R',
    'AUU':'I', 'AUC':'I', 'AUA':'I', 'AUG':'M',
    'ACU':'T', 'ACC':'T', 'ACA':'T', 'ACG':'T',
    'AAU':'N', 'AAC':'N', 'AAA':'K', 'AAG':'K',
    'AGU':'S', 'AGC':'S', 'AGA':'R', 'AGG':'R',
    'GUU':'V', 'GUC':'V', 'GUA':'V', 'GUG':'V',
    'GCU':'A', 'GCC':'A', 'GCA':'A', 'GCG':'A',
    'GAU':'D', 'GAC':'D', 'GAA':'E', 'GAG':'E',
    'GGU':'G', 'GGC':'G', 'GGA':'G', 'GGG':'G' 
    }

rna = rna_seq(seq)
all_frames = {}
rev_rna = rna[::-1]

for frame in range(3):
    all_frames[frame+1] = "".join(protein_dict.get(rna[pos:pos+3], "pro")
                                  for pos in range(frame, len(rna)-2,3)
                                  )
for frame in range(3):
    all_frames[frame+4]="".join(protein_dict.get(rev_rna[pos:pos+3], "pro")
                                for pos in range(frame, len(rev_rna)-2,3)
                                )
       
user_frame = int(input('Please select a frame from 1-6: '))

print("Frame: ", user_frame)
print("Protein Sequence: \n", all_frames[user_frame])


###################################################################
# 3. A program that asks for the user for a sequence in GenBank format
# covert GenBank formatted sequence into FASTA format
# write FASTA sequence to file
# name include accession number

user_file = input("Please enter a file containing a sequence in GenBank format: ")
GenBank_file = open(user_file)

in_seq = False

access = ""
file_content = ""

for line in GenBank_file:
    line = line.rstrip()
    if line.startswith("DEFINITION"):
        file_content += ">" + line[12:]+ "\n"
    elif line.startswith("//"):
        in_seq = False
    elif line.startswith("ORIGIN"):
        in_seq = True
    elif in_seq:
        file_content += "".join(line.split()[1:]) + "\n"
    elif line.startswith("ACCESSION"):
        access = line[12:]


new_file = open(access + ".txt", "w")
new_file.write(file_content)
new_file.close()

###################################################################
# 4. A program that asks for a nucleotide seq and the name of the
# restriction enzyme. Returns postions in the seq and cut sites

nt_file = input("Please enter a file containing a nucleotide sequence: ")
nt = open(nt_file, 'r')
next(nt)
nt_seq = ""

for line in nt:
    nt_seq += line.rstrip()

enzyme_file = open("RestrictionEnzymes.txt", "r", encoding='utf-8-sig')
enzyme = input("Please enter the name of the restriction enzyme: ")

code = {
    'N':'[ATGC]',
    'M':'[AC]',
    'R':'[AG]',
    'W':'[AT]',
    'Y':'[CT]',
    'S':'[CG]',
    'K':'[GT]',
    'H':'[ACT]',
    'B':'[CGT]',
    'V':'[ACG]',
    'D':'[AGT]'
    }

restriction = {}
for line in enzyme_file:
    (restrict,cut) = line.split(",")
    restriction[restrict] = cut.strip()

regex = restriction[enzyme]
for char in code:
    regex = regex.replace(char, code[char])
regex = regex.split("'")
regex = "(" + regex[0] + ")(" + regex[1] + ")"

x = re.search(regex, nt_seq)
print("start: " + str(x.start()))
print("end: " + str(x.end()))

runs = re.finditer(regex, nt_seq)
for match in runs:
    run_start = match.start()
    run_end = match.end()
    print("The retriction site for " + enzyme + " starts from " + str(run_start) + " to " + str(run_end))

print("The cut site for " + enzyme + " is at: " + regex)
 
###################################################################
# 5. A program that read in whole genome and compute background codon
# frequences using
# background_frq(condon) = 100*N(codon)/Total_codons
# N(codon) = occurence of codone across entire genome
# Total_codons = total num of all codons in whole genome

genome_file = open("genome.txt", 'r') # open file
next(genome_file) # skip first line
genome = "" # empty string

#add nucleotide sequence to empty string
# removes whitespaces and new lines
for line in genome_file:
    genome += line.rstrip().replace('\n', '')

# create an empty dictionary for codons while initializing each codon = 0
codon_dict = {'ATT':0, 'ATC':0, 'ATA':0,
              'CTT':0, 'CTC':0, 'CTA':0, 'CTG':0, 'TTA':0, 'TTG':0,
              'GTT':0, 'GTC':0, 'GTA':0, 'GTG':0,
              'TTT':0, 'TTC':0,
              'ATG':0,
              'TGT':0, 'TGC':0,
              'GCT':0, 'GCC':0, 'GCA':0, 'GCG':0,
              'GGT':0, 'GGC':0, 'GGA':0, 'GGG':0,
              'CCT':0, 'CCC':0, 'CCA':0, 'CCG':0,
              'ACT':0, 'ACC':0, 'ACA':0, 'ACG':0,
              'TCT':0, 'TCC':0, 'TCA':0, 'TCG':0, 'AGT':0, 'AGC':0,
              'TAT':0, 'TAC':0,
              'TGG':0,
              'CAA':0, 'CAG':0,
              'AAT':0, 'AAC':0,
              'CAT':0, 'CAC':0,
              'GAA':0, 'GAG':0,
              'GAT':0, 'GAC':0,
              'AAA':0, 'AAG':0,
              'CGT':0, 'CGC':0, 'CGA':0, 'CGG':0, 'AGA':0, 'AGG':0,
              'TAA':0, 'TAG':0, 'TGA':0
    }

# for loop used to count appearance of codon in genome
for i in range(len(genome)): 
    codon = i + 3 
    key = genome[i:codon]
    if key in codon_dict:
        codon_dict[key] += 1

total = 0 # initialize total codon - 0

# print header for list of codons
print("codon" + "\t" + "background frequency")
print("--------------------------------------")

# sums up total of times codon appears in genome
for code in codon_dict:
    total += codon_dict[code]

# uses equation to calculate background frq of each codon
for code in codon_dict:
    N_codon = codon_dict[code]
    back_frq = (100*N_codon)/total
    print(code, ":", back_frq)

    
    
