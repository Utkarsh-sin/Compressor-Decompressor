/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author ASUS
 */
public class compressor {
    public static void method(File file)  throws IOException{
        
        String filedirectory = file.getParent();// get the path of the file
        
        FileInputStream fis = new FileInputStream(file);//read the input bytes from the file
        FileOutputStream fos = new FileOutputStream(filedirectory+"/Compressed.gz");//write the output bytes to new file in that directory
        //java.util.zip gives te package gzip
        
        GZIPOutputStream gzip = new GZIPOutputStream(fos); // perform compression on output file
        
        byte[] buffer = new byte[1024];// array for file data
        int len; // to store length of file
        
        while((len=fis.read(buffer))!=-1){// unitl file read is over
            gzip.write(buffer,0,len); // offset(start) and end of data to read are passed
        }
        
        gzip.close();
        fos.close();//close output file
        fis.close();//close input file
        
    }
    public static void main(String args[]) throws IOException{
        File path = new File("E:/java learning/CompressorDecompressor/Testfile.txt");
        method(path);
    }
}
