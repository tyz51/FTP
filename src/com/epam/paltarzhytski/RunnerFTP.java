package com.epam.paltarzhytski;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;
import java.io.IOException;

import static java.lang.System.*;


public class RunnerFTP {
	public static void main(String[] args) throws FTPDataTransferException, FTPAbortedException, FTPListParseException, FTPException, IllegalStateException, IOException, FTPIllegalReplyException{
		boolean exit=true;
                out.println("!!!Start connection!!!");
		Connnector myftp= new Connnector();
		myftp.ftpConnect();
		myftp.FileInfo();
               while (true){
                    out.println("If you want change folder, press '1';");
                    out.println("If you want download  file,  press '2';");
                    out.println("If you want go to yhe parent folder, press '3';");
                    out.println("If you want exit, press '0';");
                    String answer=User.Command("Yours choise: ");
                    if (answer.equals("1")){
                        myftp.changeDir(User.Command("Enter folder name"));
                        myftp.FileInfo();
                        //break;
                    }
                    if (answer.equals("2")){
                        myftp.fileDownloader(User.Command("Enter file name"));
                        //break;
                    }
                    
                    if (answer.equals("3")){
                        myftp.backDirUp();
                        myftp.FileInfo();
                        //break;
                    }
                    
                    if (answer.equals("0")){
                        myftp.disconect();
                        exit=false;
                        break;
                    }
                }
        }              
}



