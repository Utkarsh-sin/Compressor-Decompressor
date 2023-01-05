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
import java.util.zip.GZIPInputStream;

/**
 *
 * @author ASUS
 */
public class decompressor {
    public static void method(File file) throws IOException{
        String filedirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(filedirectory+"/Decompressed");
        
        byte[] buffer = new byte[1024];
        int len;
        
        while((len=gzip.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }
    
    public static void main(String args[]) throws IOException{
        File path = new File("E://java learning/CompressorDecompressor/Compressed.gz");
        method(path);
    }
}
