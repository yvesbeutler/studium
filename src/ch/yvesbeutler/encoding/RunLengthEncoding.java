package ch.yvesbeutler.encoding;

/**
 * @author yvesbeutler
 * This was originally a computer science task of the ETHZ I got from a girl from Tinder.
 * Run-Length Encoding is a famous algorithm for reducing the size of images.
 */
class RunLengthEncoding {

    public static void main(String[] args) {

        int[] input = { 42, 42, 85, 85, 85, 85, 172, 172, 172, 13, 13, 42, -1};
        encode(input);

        input = new int[] { 2, 42, 4, 85, 3, 172, 2, 13, 1, 42, -1 };
        decode(input);
    }

    private static boolean validate(int value) {
        return value >= 0 && value <= 255;
    }

    private static void encode(int[] numbers) {
        StringBuilder result = new StringBuilder();
        int prevNumber = -1;
        int counter = 1;

        for (int i : numbers) {
            if (validate(i)) {
                // if a sequence is found
                if (i == prevNumber) {
                    counter++;
                } else {
                    // save last sequence
                    if (prevNumber != -1) {
                        result.append(counter).append(" ").append(prevNumber).append(" ");
                        // set new previous number
                        prevNumber = i;
                        // reset counter
                        counter = 1;
                    } else {
                        // if it's the first run
                        prevNumber = i;
                    }
                }
            } else if (i == -1) {
                // save last sequence (but not if first number is the exit condition)
                if (prevNumber != -1) {
                    result.append(counter).append(" ").append(prevNumber);
                }
                // exit the loop
                break;
            }
        }

        // print the result
        System.out.println(result.toString());
    }

    private static void decode(int[] numbers) {
        StringBuilder result = new StringBuilder();
        boolean isMultiplier = true;
        int multiplier = 0;

        for (int i : numbers) {
            if (validate(i)) {

                if (isMultiplier) {
                    // set new multiplier
                    multiplier = i;
                    isMultiplier = false;
                } else {
                    // write values n times
                    while (multiplier > 0) {
                        result.append(i).append(" ");
                        multiplier--;
                    }
                    isMultiplier = true;
                }
            } else if (i == -1) {
                // exit the loop
                break;
            }
        }

        // print the result
        System.out.println(result.toString());
    }
}