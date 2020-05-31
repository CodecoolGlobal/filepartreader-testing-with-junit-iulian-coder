package com.codecool;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }

    public List <String> getWordsOrderedAlphabetically () throws IOException {
        //returns the words ordered by alphabetically as an ArrayList
        List<String> tempList;
        tempList = Arrays.asList(filePartReader.readLines().split("\\s+"));
        Collections.sort(tempList);
        return tempList;
    }

    public List <String>getWordsContainingSubstring (String subString ) throws IOException {
        //returns the words which contains the subString
        List <String> tempList;
        List <String> result = new ArrayList<>();
        tempList = Arrays.asList(filePartReader.readLines().split("\\s+"));
        tempList.forEach((String word) ->{
            if (word.contains(subString)){
                result.add(word);
            }
        });
        return result;

    }
    public List <String> getStringsWhichPalindromes () throws IOException {
        //returns the words from the String which are palindrome
        List<String> tempList;
        tempList = Arrays.asList(filePartReader.readLines().split("\\s+"));
        List<String> result = new ArrayList<>();
        tempList.forEach((String word) ->{
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(word);
            if (word.toLowerCase().equals(stringBuilder.reverse().toString().toLowerCase())){
                result.add(word);
            }
        });
        return result;
    }
}
