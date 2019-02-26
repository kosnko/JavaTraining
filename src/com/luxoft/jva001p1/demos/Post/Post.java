package com.luxoft.jva001p1.demos.Post;

import java.util.Arrays;

public class Post {
    private int storageCapacity = 10;
    private int letterCount = 0;
    private Letter[] letters = new Letter[storageCapacity];

    public int getLetterCount() {
        return letterCount;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public Letter[] getLetters() {
        return letters;
    }

    public void sendLetter(Letter letter) {
        if (letterCount == storageCapacity) {
             letters = Arrays.copyOf(letters, storageCapacity += 5);
        }
        letters[letterCount++] = letter;
    }

    public Letter[] takeMyLetters(Person person) {
        Letter[] personLetters = new Letter[10];
        int personCount = 0;
        for (int i = 0; i < letterCount; i++) {
            if (person == letters[i].getReceiver()) {
                if (personCount == personLetters.length) {
                    personLetters = Arrays.copyOf(personLetters, personLetters.length + 5);
                }
                personLetters[personCount++] = letters[i];
                letters[i].setDelivered(true);
            }
        }
        return Arrays.copyOf(personLetters, personCount);
    }

    public int getNumberOflettersSentByPerson(Person person) {
        int personCount = 0;
        for (int i = 0; i < letterCount; i++) {
            if (person == letters[i].getSender()) {
                personCount++;
            }
        }
        return personCount;
    }

    public Letter[] getUndeliveredLetters()
    {
        Letter[] letters = new Letter[10];
        int letterCount = 0;
        for (int i = 0; i < this.letterCount; i++) {
            if (!this.letters[i].isDelivered()) {
                if (letterCount == letters.length) {
                    letters = Arrays.copyOf(letters, letters.length + 5);
                }
                letters[letterCount++] = this.letters[i];
            }
        }
        return Arrays.copyOf(letters, letterCount);
    }

    public Letter[] getDeliveredLetters()
    {
        Letter[] letters = new Letter[10];
        int letterCount = 0;
        for (int i = 0; i < this.letterCount; i++) {
            if (this.letters[i].isDelivered()) {
                if (letterCount == letters.length) {
                    letters = Arrays.copyOf(letters, letters.length + 5);
                }
                letters[letterCount++] = this.letters[i];
            }
        }
        return Arrays.copyOf(letters, letterCount);
    }
}
