package com.luxoft.jva001p1.demos.Post;

import java.util.Arrays;

public class Post {
    private Letter[] undeliveredLetters = new Letter[10];
    private Letter[] deliveredLetters = new Letter[10];
    int undelivLetcout = 0;
    int delivLetcout = 0;

//    public void sendLetter(Letter letter) {
//        if (undelivLetcout == undeliveredLetters.length) {
//            increaseStorage(undeliveredLetters);
//        }
//        undeliveredLetters[undelivLetcout] = letter;
//        undelivLetcout++;
//    }
//
//    public Letter[] takeMyLetters(Person person) {
//        Letter[] letters = new Letter[];
//        for (Letter undeliveredLetter : undeliveredLetters) {
//            if (undeliveredLetter.getReceiver() == person) {
//
//            }
//        }
//
//        if (undelivLetcout == undeliveredLetters.length) {
//            increaseStorage(undeliveredLetters);
//        }
//        undeliveredLetters[undelivLetcout] = letter;
//        undelivLetcout+
//    }
//
//    public Letter[] getUndeliveredLetters() {
//        return Arrays.copyOf(undeliveredLetters, undeliveredLetters.length);
//    }
//
//    public Letter[] getDeliveredLetters() {
//        return Arrays.copyOf(deliveredLetters, deliveredLetters.length);
//    }
//
//    public int getNumberOflettersSentByPerson(Person person) {
//
//    }
}
