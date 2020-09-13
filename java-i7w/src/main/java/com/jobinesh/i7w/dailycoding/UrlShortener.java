package com.jobinesh.i7w.dailycoding;

public class UrlShortener {
    private final String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public long string2Id(String url) {
        char[] urlChars = url.toCharArray();
        long num = 0;
        for (int i = 0; i < urlChars.length; i++) {
            if (urlChars[i] >= 'a' && urlChars[i] <= 'z') {
                num = num * 62 + urlChars[i] - 'a';
            } else if (urlChars[i] >= 'A' && urlChars[i] <= 'Z') {
                num = num * 62 + urlChars[i] - 'A' + 26;
            } else if (urlChars[i] >= '0' && urlChars[i] <= '9') {
                num = num * 62 + urlChars[i] - '0' + 52;
            }
        }
        return num;
    }

    public String id2String(long shortenUrl) {
        long n=shortenUrl;
        StringBuilder url=new StringBuilder();
        while( n>0){
           long num = n%62;
           n = n/62;
           url.append(allowedChars.charAt((int)num));
        }
        return url.reverse().toString();
    }
    public static void main(String[] args){
        UrlShortener urlShortener = new UrlShortener();
        String url= (urlShortener.id2String(323231412412412412l));
        System.out.println(url);
        long shorten = urlShortener.string2Id(url);
        System.out.println(shorten);

    }
}
