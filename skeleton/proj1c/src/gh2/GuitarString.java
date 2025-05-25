package gh2;

// TODO: maybe more imports

import deque.ArrayDeque61B;
import deque.Deque61B;


//Note: This file will not compile until you complete the Deque61B implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    // TODO: uncomment the following line once you're ready to start this portion
    private Deque61B<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Initialize the buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this division operation into an int. For
        //       better accuracy, use the Math.round() function before casting.
        //       Your should initially fill your buffer with zeros.


        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayDeque61B<>();
        for (int i = 0; i < capacity; i++) {
         buffer.addLast(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // TODO: Dequeue everything in buffer, and replace with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each
        //       other. This does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.
        int size = buffer.size();
        for (int i = 0; i < size; i++) {
            buffer.removeFirst();
        }
        // 2. 用随机值填充（模拟拨弦时的混乱状态）
        for (int i = 0; i < size; i++) {
            // random inoup noise
            double r = Math.random() - 0.5;
            buffer.addLast(r);
        }

     

    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       **Do not call StdAudio.play().**

           // 1. 获取当前位置的值（相当于弦的某个点）
        double first = buffer.removeFirst();
        // 2. 获取下一个位置的值
        double second = buffer.get(0);
        
        // 3. 计算新值（模拟能量传递和衰减）
        double newValue = DECAY * (first + second) / 2;
        // 4. 将新值放到末尾（形成循环）
        buffer.addLast(newValue);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // TODO: Return the correct thing.
        return buffer.get(0);
    }
}
    // TODO: Remove all comments that say TODO when you're done.
