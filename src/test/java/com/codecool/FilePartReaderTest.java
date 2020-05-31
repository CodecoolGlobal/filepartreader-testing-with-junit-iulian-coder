package com.codecool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FilePartReaderTest {

    @Test
    public void testSetupThrowsIllegalArgument(){
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("filename.txt",1,0));
    }


}