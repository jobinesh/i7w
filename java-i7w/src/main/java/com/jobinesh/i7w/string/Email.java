package com.jobinesh.i7w.string;

public class Email {
    public int numUniqueEmails(String[] emails) {
        for(int i=0;i<emails.length;i++){
            emails[i] = emails[i].replaceAll(".+=", "");
        }
        return 0;
    }
    public static void main(String[] arg){

    }
}
