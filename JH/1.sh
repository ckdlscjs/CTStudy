#!/bin/bash

# Loop through the weeks folder (week1 to week6 and week7-8)
for folder in week{1..6} week7_8; do
    # Check if the directory exists
    if [ -d "$folder" ]; then
        # Loop through all .java files in the folder
        for file in "$folder"/*.java; do
            # Extract the number from the filename (e.g., Main175.java -> 175)
            if [[ "$file" =~ Main([0-9]+)\.java ]]; then
                # Get the number part from the match
                number="${BASH_REMATCH[1]}"
                # Rename the file from MainXXX.java to ProblemXXX.java
                mv "$file" "$folder/Problem$number.java"
            fi
        done
    else
        echo "Directory $folder does not exist."
    fi
done

