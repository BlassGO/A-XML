package com.codyi.xml2axml.test;

import android.content.Context;
import com.codyi.xml2axml.Encoder;
import org.apache.commons.io.FileUtils;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Roy on 15-10-6.
 */
public class Main {
    private static void usage() {
        System.out.println("XML2AXML version 1.0");
        System.out.println("\nUsage:");
        System.out.println("  xml2axml -d <input.xml> <output.xml>   Decode binary XML to text");
        System.out.println("  xml2axml -e <input.xml> <output.xml>   Encode text XML to binary");
        System.out.println("\nFor more information, use --help");
    }

    public static void main(String args[]) throws IOException, XmlPullParserException {
        if (args.length < 2) {
            usage();
            return;
        }

        if (args[0].endsWith("e")) {
            encode(args[1],args[2]);
        } else if (args[0].endsWith("d")) {
            decode(args[1],args[2]);
        } else if (args[0].endsWith("t")) {
            decode(args[1], args[2]);
            encode(args[2], args[3]);
            decode(args[3], args[4]);
        } else if (args[0].equals("--help")) {
            usage();
            return;
        } else {
            System.out.printf("Invalid command: %s\nPlease use --help to see available options.\n", args[0]);
        }
    }

    public static void encode(String in,String out) throws IOException, XmlPullParserException {
        Encoder e = new Encoder();
        byte[] bs = e.encodeFile(new Context(), in);
        FileUtils.writeByteArrayToFile(new File(out), bs);
    }

    public static void decode(String in,String out) throws FileNotFoundException {
        AXMLPrinter.out=new PrintStream(new File(out));
        AXMLPrinter.main(new String[]{in});
        AXMLPrinter.out.close();
    }
}
